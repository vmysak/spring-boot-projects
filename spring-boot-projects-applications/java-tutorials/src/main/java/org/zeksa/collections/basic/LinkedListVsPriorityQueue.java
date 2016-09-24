package org.zeksa.collections.basic;

import org.zeksa.collections.basic.model.PriorityUnit;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class LinkedListVsPriorityQueue {

    public static void main(String[] args) {
        Queue<PriorityUnit> linkedList=new LinkedList<>();
        Queue<PriorityUnit> priorityQueue=new PriorityQueue<>();

        for(int i=5;i>=1;i--){
            PriorityUnit unit=new PriorityUnit("name"+i, i);
            linkedList.add(unit);
            priorityQueue.add(unit);
        }

        while(!linkedList.isEmpty()){
            System.out.println(linkedList.poll());
        }

        System.out.println("===============================");

        while (!priorityQueue.isEmpty()){
            System.out.println(priorityQueue.poll());
        }
    }
}
