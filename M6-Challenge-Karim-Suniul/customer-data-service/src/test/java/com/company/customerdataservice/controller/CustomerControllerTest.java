package com.company.customerdataservice.controller;

import com.company.customerdataservice.model.Customer;
import com.company.customerdataservice.repository.CustomerRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(CustomerController.class)
public class CustomerControllerTest {
    // Wiring in the MockMvc object
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    CustomerRepository repo;

    // ObjectMapper used to convert Java objects to JSON and vice versa
    private ObjectMapper mapper = new ObjectMapper();

    // A list of customers for testing purposes
    private List<Customer> customerList;

    @Before
    public void setUp() {
        // Standard set up method, for instantiating test objects
        // Don't have to do anything special for mockMvc since it's Autowired
    }

    // Testing POST /customers
    @Test
    public void shouldReturnNewCustomerOnPostRequest() throws Exception {
        // ARRANGE
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

        // Convert Java Object to JSON
        String inputJson = mapper.writeValueAsString(customer);

        // ACT
        mockMvc.perform(
                        post("/customers")                            // Perform the POST request
                                .content(inputJson)                       // Set the request body
                                .contentType(MediaType.APPLICATION_JSON)  // Tell the server it's in JSON format
                )
                .andDo(print())                                // Print results to console
                .andExpect(status().isCreated());              // ASSERT (status code is 201)
    }

    // Testing GET customers/{id}
    @Test
    public void shouldReturnCustomerById() throws Exception {

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
        customer.setCustomer_id(2);

        String inputJson = mapper.writeValueAsString(customer);

        mockMvc.perform(MockMvcRequestBuilders.get("/customers/2")).andDo(print()).andExpect(status().isOk());
    }

    // Testing PUT /customers/{id}
    @Test
    public void shouldUpdateByIdAndReturn204StatusCode() throws Exception {
        // This method returns nothing, so we're just checking for correct status code
        // In this case, code 204, which indicates No Content
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

        String inputJson = mapper.writeValueAsString(customer);

        mockMvc.perform(
                        put("/customers")
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isNoContent());

        //mockMvc.perform(MockMvcRequestBuilders.put("/customers")).andDo(print()).andExpect(status().isOk());
    }

    // Testing DELETE /customers/{id}
    @Test
    public void shouldDeleteByIdAndReturn204StatusCode() throws Exception {

        // This method returns nothing, so we're just checking for correct status code
        // In this case, code 204, which indicates No Content
        mockMvc.perform(delete("/customers/5"))
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    // Testing GET customers/{state}
    @Test
    public void shouldReturnCustomersByState() throws Exception{
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
        customer.setCustomer_id(2);

        String inputJson = mapper.writeValueAsString(customer);

        //        mockMvc.perform(get("/customers/2"))
        //                .andDo(print())
        //                .andExpect(status().isOk())
        //                .andExpect(content().json(inputJson));

        // mockMvc.perform(MockMvcRequestBuilders.get("/customers/2")).andDo(print()).andExpect(status().isAccepted());

        mockMvc.perform(MockMvcRequestBuilders.get("/customers/state/California")).andDo(print()).andExpect(status().isOk());
    }

}