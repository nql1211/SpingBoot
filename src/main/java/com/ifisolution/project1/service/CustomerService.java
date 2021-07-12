package com.ifisolution.project1.service;

import com.ifisolution.project1.entity.Customers;
import com.ifisolution.project1.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customers> getCustomers(){
        return customerRepository.findAll();
    }

    public void addNewCustomer(Customers customers){
        Boolean existPhone = customerRepository.selectExitsPhone(customers.getPhone());
        if (existPhone){
            throw new IllegalStateException("Phone is exist");
        }
        customerRepository.save(customers);
    }

    public void deleteCustomer(Long id) {
        /*customerRepository.findById(id);
        boolean exist = customerRepository.existsById(id);
        if (!exist){
            throw new IllegalStateException("Customer with id:" + id +" dose not exist");
        }*/
        customerRepository.deleteById(id);
    }



    @Transactional
    public void updateCustomer(Long customerID, String name, String phone) {
           Optional<Customers> customers = customerRepository.findById(customerID);

        if (customers.isPresent()){
            if (name != null && name.length() > 0 && !Objects.equals(customers.get().getCustomerName(), name)) {
                customers.get().setCustomerName(name);
            }

            if (phone != null && phone.length() > 0 && !Objects.equals(customers.get().getPhone(), phone)) {
                Optional<Customers> exitsPhone = customerRepository.findByCustomerPhone(phone);
            }
                customers.get().setPhone(phone);
        }
    }
}
