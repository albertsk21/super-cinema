package project.SuperCinema.services.interfaces;

import project.SuperCinema.dtos.CustomerDtoJson;
import project.SuperCinema.entities.Customer;

public interface CustomerService {

    CustomerDtoJson saveCustomer(CustomerDtoJson customerJson);

    Customer findCustomerByFirstName(String firstName);
    CustomerDtoJson[] getAllCustomers();
    void deleteCustomerById(Long id);
    Customer findCustomerByEmail(String email);

}
