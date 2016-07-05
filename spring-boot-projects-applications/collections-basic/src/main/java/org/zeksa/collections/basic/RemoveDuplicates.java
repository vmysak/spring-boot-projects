package org.zeksa.collections.basic;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.zeksa.collections.basic.model.Customer1;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

public class RemoveDuplicates {

    private static final Logger LOGGER = LoggerFactory.getLogger(RemoveDuplicates.class);

    public void start(){
        List<Customer1> customers=initCustomers();
        List<Customer1> filteredCustomers=new ArrayList<>(new LinkedHashSet<>(customers));

        LOGGER.info("Before {}", customers.size());
        LOGGER.info("After {}", filteredCustomers.size());
    }

    private List<Customer1> initCustomers(){
        List<Customer1> result=new ArrayList<>();

        for(int i=0;i<100;i++){
            Customer1 customer=new Customer1(String.valueOf(i%10),String.valueOf(i));
            result.add(customer);
        }

        return result;
    }
}
