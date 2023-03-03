package com.company.customerdataservice.repository;

import com.company.customerdataservice.model.Customer;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
//@SpringBootConfiguration
public class CustomerRepositoryTest {
    //@MockBean
    @Autowired
    CustomerRepository customerRepo;

    @Before
    public void setUp() throws Exception {
        customerRepo.deleteAll();
    }

    @Test
    public void findCustomerByState() {
        Customer customer = new Customer();
        customer.setF_name("Joe");
        customer.setL_name("Smith");
        customer.setPhone("111-222-3456");
        customer.setCompany("BigCo");
        customer.setAddress1("Address1");
        customer.setAddress2("Address2");
        customer.setCity("Los Angeles");
        customer.setState("California");
        customer.setPostal_code("12345");
        customer.setCountry("United States of America");

        customerRepo.save(customer);

        Customer customer2 = new Customer();
        customer2.setF_name("Joel");
        customer2.setL_name("Shay");
        customer2.setPhone("111-322-3456");
        customer2.setCompany("BigCo");
        customer2.setAddress1("Address1");
        customer2.setAddress2("Address2");
        customer2.setCity("Los Angeles");
        customer2.setState("California");
        customer2.setPostal_code("12345");
        customer2.setCountry("United States of America");

        customerRepo.save(customer2);

        Customer customer3 = new Customer();
        customer3.setF_name("Bob");
        customer3.setL_name("Marley");
        customer3.setPhone("222-333-4567");
        customer3.setCompany("Independent");
        customer3.setAddress1("Address1");
        customer3.setAddress2("Address2");
        customer3.setCity("St. Louis");
        customer3.setState("Missouri");
        customer3.setPostal_code("14875");
        customer3.setCountry("United States of America");

        customerRepo.save(customer3);

        List<Customer> customerList = customerRepo.findByState("California");

        assertEquals(2, customerList.size());
    }
}

//    @Test
//    public void addCustomer() {
//        //Arrange...
//        Customer customer = new Customer();
//        customer.setF_name("Joe");
//        customer.setL_name("Smith");
//        customer.setPhone("111-222-3456");
//        customer.setCompany("BigCo");
//        customer.setAddress1("Address1");
//        customer.setAddress2("Address2");
//        customer.setCity("Los Angeles");
//        customer.setState("California");
//        customer.setPostal_code("12345");
//        customer.setCountry("United States of America");
//
//        //Act...
//        customer = customerRepo.save(customer);
//
//        //Assert...
//        Optional<Customer> customer1 = customerRepo.findById(customer.getCustomer_id());
//
//        assertEquals(customer1.get(), customer);
//    }
//
//    @Test
//    public void getAllCustomers() {
//        //Arrange...
//
//        //Act...
//        Customer customer = new Customer();
//        customer.setF_name("Joe");
//        customer.setL_name("Smith");
//        customer.setPhone("111-222-3456");
//        customer.setCompany("BigCo");
//        customer.setAddress1("Address1");
//        customer.setAddress2("Address2");
//        customer.setCity("Los Angeles");
//        customer.setState("California");
//        customer.setPostal_code("12345");
//        customer.setCountry("United States of America");
//
//        customerRepo.save(customer);
//
//        Customer customer2 = new Customer();
//        customer2.setF_name("Bob");
//        customer2.setL_name("Marley");
//        customer2.setPhone("222-333-4567");
//        customer2.setCompany("Independent");
//        customer2.setAddress1("Address1");
//        customer2.setAddress2("Address2");
//        customer2.setCity("Los Angeles");
//        customer2.setState("California");
//        customer2.setPostal_code("12345");
//        customer2.setCountry("United States of America");
//
//        customerRepo.save(customer2);
//
//        List<Customer> customerList = customerRepo.findAll();
//
//        //Assert...
//        assertEquals(2, customerList.size());
//    }
//
//    @Test
//    public void updateCustomer() {
//        //Arrange...
//        Customer customer = new Customer();
//        customer.setF_name("Joe");
//        customer.setL_name("Smith");
//        customer.setPhone("111-222-3456");
//        customer.setCompany("BigCo");
//        customer.setAddress1("Address1");
//        customer.setAddress2("Address2");
//        customer.setCity("Los Angeles");
//        customer.setState("California");
//        customer.setPostal_code("12345");
//        customer.setCountry("United States of America");
//
//        customerRepo.save(customer);
//
//        //Act...
//        customer.setF_name("UPDATED");
//
//        customerRepo.save(customer);
//
//        //Assert...
//        Optional<Customer> customer1 = customerRepo.findById(customer.getCustomer_id());
//
//        assertEquals(customer1.get(), customer);
//    }
//
//    @Test
//    public void deleteCustomer() {
//        //Arrange...
//        Customer customer = new Customer();
//        customer.setF_name("Joe");
//        customer.setL_name("Smith");
//        customer.setPhone("111-222-3456");
//        customer.setCompany("BigCo");
//        customer.setAddress1("Address1");
//        customer.setAddress2("Address2");
//        customer.setCity("Los Angeles");
//        customer.setState("California");
//        customer.setPostal_code("12345");
//        customer.setCountry("United States of America");
//
//        customerRepo.save(customer);
//
//        //Act...
//        customerRepo.deleteById(customer.getCustomer_id());
//
//        //Assert...
//        Optional<Customer> customer1 = customerRepo.findById(customer.getCustomer_id());
//        assertFalse(customer1.isPresent());
//    }
//    @org.junit.Test
//    public void findCustomerById() {
//        Customer customer = new Customer();
//        customer.setF_name("Joe");
//        customer.setL_name("Smith");
//        customer.setPhone("111-222-3456");
//        customer.setCompany("BigCo");
//        customer.setAddress1("Address1");
//        customer.setAddress2("Address2");
//        customer.setCity("Los Angeles");
//        customer.setState("California");
//        customer.setPostal_code("12345");
//        customer.setCountry("United States of America");
//
//        customerRepo.save(customer);
//
//        //Assert...
//        Optional<Customer> customer1 = customerRepo.findById(customer.getCustomer_id());
//
//        assertEquals(customer1.get(), customer);
//    }

