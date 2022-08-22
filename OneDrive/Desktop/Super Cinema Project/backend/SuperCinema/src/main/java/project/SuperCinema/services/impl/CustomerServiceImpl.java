package project.SuperCinema.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import project.SuperCinema.dtos.CustomerDtoJson;
import project.SuperCinema.entities.Customer;
import project.SuperCinema.repositories.CustomerRepository;
import project.SuperCinema.services.interfaces.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {
    private CustomerRepository customerRepository;
    private ModelMapper modelMapper;
    public CustomerServiceImpl(CustomerRepository customerRepository, ModelMapper modelMapper) {
        this.customerRepository = customerRepository;
        this.modelMapper = modelMapper;
    }
    @Override
    public CustomerDtoJson saveCustomer(CustomerDtoJson customerJson) {
        Customer customer = this.modelMapper.map(customerJson,Customer.class);
        Customer created = this.customerRepository.save(customer);
        return this.modelMapper.map(created,CustomerDtoJson.class);
    }
    @Override
    public Customer findCustomerByFirstName(String firstName) {
       return this.customerRepository.findCustomerByFirstName(firstName);
    }

    @Override
    public CustomerDtoJson[] getAllCustomers() {
        Customer[] customers = this.customerRepository.findAllCustomers();
        return this.modelMapper.map(customers,CustomerDtoJson[].class);
    }

    @Override
    public void deleteCustomerById(Long id) {
        this.customerRepository.deleteCustomerById(id);

    }

    @Override
    public Customer findCustomerByEmail(String email) {

        return this.customerRepository.findCustomerByEmail(email);
    }
}
