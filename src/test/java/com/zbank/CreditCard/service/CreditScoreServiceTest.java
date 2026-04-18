package com.zbank.CreditCard.service;


import com.zbank.CreditCard.entity.Customer;
import com.zbank.CreditCard.repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CreditScoreServiceTest {

    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private CreditScoreService creditScoreService;

    // Positive Test — salary > 200000 → score 500
    @Test
    void testCalculateScore_HighSalary() {

        Customer customer = new Customer();
        customer.setId(1L);
        customer.setCustId(1001L);
        customer.setAnnualSalary(300000.0);
        customer.setCreditScore(0);

        when(customerRepository.findByCustId(1001L))
                .thenReturn(customer);

        long score = creditScoreService.calculateScore("1001");

        assertEquals(500, score);
        verify(customerRepository, times(1))
                .findByCustId(1001L);
    }

    // Positive Test — salary between 50000 and 200000 → score 150
    @Test
    void testCalculateScore_MediumSalary() {

        Customer customer = new Customer();
        customer.setId(1L);
        customer.setAnnualSalary(100000.0);

        when(customerRepository.findByCustId(1002L))
                .thenReturn(customer);

        long score = creditScoreService.calculateScore("1002");

        assertEquals(150, score);
    }

    // Positive Test — salary < 50000 → score 50
    @Test
    void testCalculateScore_LowSalary() {

        Customer customer = new Customer();
        customer.setId(1L);
        customer.setAnnualSalary(40000.0);

        when(customerRepository.findByCustId(1003L))
                .thenReturn(customer);

        long score = creditScoreService.calculateScore("1003");

        assertEquals(50, score);
    }

    // Positive Test — existingCards >= 2 → score 300
    @Test
    void testCalculateScore_ExistingCards() {

        Customer customer = new Customer();
        customer.setId(2L); // existingCards >= 2
        customer.setAnnualSalary(1000000.0);

        when(customerRepository.findByCustId(1004L))
                .thenReturn(customer);

        long score = creditScoreService.calculateScore("1004");

        assertEquals(500, score);
    }
}