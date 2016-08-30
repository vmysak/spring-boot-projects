package org.zeksa.collections.basic;

import org.zeksa.collections.basic.model.Customer1;

import java.util.Map;
import java.util.WeakHashMap;

public class WeakHashMapTest {

    public static void main(String... args){
        Map<Customer1, String> map= new WeakHashMap<>();
        Customer1 customer=new Customer1("1","John");
        map.put(customer, "data");

        customer=null;
        System.gc();

        for(int i=0;i<10000;i++){
            if(map.isEmpty()){
                System.out.println(i);
                break;
            }
        }
    }
}
