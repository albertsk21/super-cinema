package project.SuperCinema.web;


import org.springframework.web.bind.annotation.*;
import project.SuperCinema.dtos.CustomerDtoJson;
import project.SuperCinema.services.interfaces.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {


    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("")
    public CustomerDtoJson createCustomer(@RequestBody CustomerDtoJson customerJson){
        return this.customerService.saveCustomer(customerJson);
    }

    @GetMapping("")
    public CustomerDtoJson[] getAllCustomers(){
        return this.customerService.getAllCustomers();
    }


    @DeleteMapping("/{id}")
    public void deleteCustomerById(@PathVariable("id") Long id){
        this.customerService.deleteCustomerById(id);
    }

}
