package project.SuperCinema.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import project.SuperCinema.entities.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {


    @Query("FROM Customer AS c WHERE c.firstName = ?1")
    Customer findCustomerByFirstName(String firstName);

    @Query("FROM Customer ")
    Customer[] findAllCustomers();

    @Query("FROM Customer AS c WHERE c.id = ?1")
    Customer findCustomerById(Long id);

    @Query("FROM Customer AS c WHERE c.email = ?1")
    Customer findCustomerByEmail(String email);

    @Transactional
    @Modifying
    void deleteCustomerById(Long id);
}
