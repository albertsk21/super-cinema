package project.SuperCinema.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import project.SuperCinema.dtos.CustomerDtoJson;
import project.SuperCinema.dtos.ReservationDtoJson;
import project.SuperCinema.dtos.create.ReservationCreate;
import project.SuperCinema.entities.*;
import project.SuperCinema.repositories.*;
import project.SuperCinema.services.interfaces.CustomerService;
import project.SuperCinema.services.interfaces.ReservationService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class ReservationServiceImpl implements ReservationService {
    private ReservationRepository reservationRepository;
    private AvailabilityRepository availabilityRepository;
    private ModelMapper modelMapper;
    private CustomerService customerService;
    private TicketRepository ticketRepository;

    public ReservationServiceImpl(ReservationRepository reservationRepository,
                                  AvailabilityRepository availabilityRepository,
                                  ModelMapper modelMapper,
                                  CustomerService customerService,
                                  TicketRepository ticketRepository) {
        this.reservationRepository = reservationRepository;
        this.availabilityRepository = availabilityRepository;
        this.modelMapper = modelMapper;
        this.customerService = customerService;
        this.ticketRepository = ticketRepository;
    }

    @Override
    public void saveReservation(Reservation reservation) {
        this.reservationRepository.save(reservation);
    }

    @Override
    public ReservationDtoJson[] getAllReservations() {

        Reservation[] reservations = this.reservationRepository.findReservations();
        ReservationDtoJson[] reservationDtoJsons = this.modelMapper.map(reservations,ReservationDtoJson[].class);

        for (int i = 0; i <reservations.length ; i++) {
           String[] dateElements =  reservations[i].getDate().toString().split(" ")[0].split("-");
           String format = String.format("%s/%s/%s",dateElements[2],dateElements[1],dateElements[0]);


           reservationDtoJsons[i].setDate(format);
           reservationDtoJsons[i].setHour(formatHour(reservations[i].getHour()));

        }

        return reservationDtoJsons;
    }

    @Override
    public ReservationDtoJson createReservation(ReservationCreate reservation) throws ParseException {

        Reservation reservationToDB = new Reservation();
        reservationToDB.setDate(stringDateToDateObject(reservation.getDate()));
        reservationToDB.setHall(reservation.getHall());
        reservationToDB.setSeatNumber(reservation.getSeatNumber());
        reservationToDB.setHour(stringHourToDate(reservation.getHour()));


        Availability availability  = this.availabilityRepository.findAvailabilityById(reservation.getAvailabilityId());
        reservationToDB.setAvailability(availability);

        Ticket ticket = this.ticketRepository.findTicketByCategory(reservation.getTicket());
        reservationToDB.setTicket(ticket);



        CustomerDtoJson createCustomer = new CustomerDtoJson();
        createCustomer.setEmail(reservation.getCustomerEmail());
        createCustomer.setFirstName(reservation.getFirstName());
        createCustomer.setLastName(reservation.getLastName());
        createCustomer.setPhoneNumber(reservation.getPhoneNumber());

        Customer customer = this.customerService.findCustomerByEmail(reservation.getCustomerEmail());


        if(customer == null){
            this.customerService.saveCustomer(createCustomer);
            customer = this.customerService.findCustomerByEmail(reservation.getCustomerEmail());

        }



        reservationToDB.setCustomer(customer);

        if(ticket == null){
           throw new IllegalArgumentException("Ticket not found");
        }else if(customer == null){
            throw new IllegalArgumentException("Customer not found");
        }

        Reservation reservationCreated = this.reservationRepository.save(reservationToDB);
        return this.modelMapper.map(reservationCreated, ReservationDtoJson.class);
    }

    @Override
    public void deleteReservationById(Long id) {
        this.reservationRepository.deleteReservationById(id);
    }

    @Override
    public String[] getSeatsByAvailabilityId(Long id) {
        return this.reservationRepository.findSeatsByAvailabilityId(id);
    }

    @Override
    public ReservationDtoJson exportReservationById(Long id) {

        Reservation reservation = this.reservationRepository.findReservationById(id);

        ReservationDtoJson reservationDtoJson = this.modelMapper.map(reservation,ReservationDtoJson.class);

        String[] dateElements =  reservation.getDate().toString().split(" ")[0].split("-");
        String format = String.format("%s/%s/%s",dateElements[2],dateElements[1],dateElements[0]);

        reservationDtoJson.setDate(format);
        reservationDtoJson.setHour(formatHour(reservation.getHour()));

        return reservationDtoJson;
    }


    private Date stringHourToDate(String stringHour)  {

        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm");
            return simpleDateFormat.parse(stringHour);
        } catch (ParseException e) {

            System.out.println("your hour format is incorrect, please try again");
            e.printStackTrace();
        }

        return null;
    }

    private Date stringDateToDateObject(String stringDate) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return simpleDateFormat.parse(stringDate);
    }

    private String formatHour(Date date){
        String hoursFormat = "%s:%s";
        return String.format(hoursFormat,date.getHours(),date.getMinutes());

    }




}
