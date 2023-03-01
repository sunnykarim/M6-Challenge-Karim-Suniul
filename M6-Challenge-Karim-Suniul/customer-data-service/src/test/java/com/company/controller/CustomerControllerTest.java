package com.company.controller;

import com.company.model.Customer;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class CustomerControllerTest {
    // Wiring in the MockMvc object
    @Autowired
    private MockMvc mockMvc;

    // ObjectMapper used to convert Java objects to JSON and vice versa
    private ObjectMapper mapper = new ObjectMapper();

    // A list of customers for testing purposes
    private List<Customer> recordList;

    @Before
    public void setUp() {
        // Standard set up method, for instantiating test objects
        // Don't have to do anything special for mockMvc since it's Autowired
    }

    // Testing GET /records
    @Test
    public void shouldReturnAllCustomersInCollection() throws Exception {

        // ARRANGE
        // Convert Java object to JSON
        String outputJson = mapper.writeValueAsString(recordList);

        // ACT
        mockMvc.perform(get("/customers"))                // Perform the GET request
                .andDo(print())                          // Print results to console
                .andExpect(status().isOk());              // ASSERT (status code is 200)
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

        Customer outputCustomer = new Customer();
        outputCustomer.setF_name("Joe");
        outputCustomer.setL_name("Smith");
        outputCustomer.setPhone("111-222-3456");
        outputCustomer.setCompany("BigCo");
        outputCustomer.setAddress1("Address1");
        outputCustomer.setAddress2("Address2");
        outputCustomer.setCity("Los Angeles");
        outputCustomer.setState("California");
        outputCustomer.setPostal_code("12345");
        outputCustomer.setCountry("United States of America");
        outputCustomer.setCustomer_id(6);

        String outputJson = mapper.writeValueAsString(outputCustomer);

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
    public void shouldReturnRecordById() throws Exception {

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
        customer.setCustomer_id(6);

        String outputJson = mapper.writeValueAsString(customer);

        mockMvc.perform(get("/customers/2"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(outputJson));
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
        customer.setCustomer_id(6);

        String inputJson = mapper.writeValueAsString(customer);

        mockMvc.perform(
                        put("/customers/2")
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isNoContent());
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
}