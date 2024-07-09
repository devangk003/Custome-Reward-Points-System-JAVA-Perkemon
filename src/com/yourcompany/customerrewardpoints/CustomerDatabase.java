package com.yourcompany.customerrewardpoints;

import java.util.ArrayList;
import java.util.List;

public class CustomerDatabase {
    private List<Customer> customers;

    public CustomerDatabase() {
        this.customers = new ArrayList<>();
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public Customer findCustomer(String phoneNumber) {
        for (Customer customer : customers) {
            if (customer.getPhoneNumber().equals(phoneNumber)) {
                return customer;
            }
        }
        return null;
    }
}
