package org.zeksa.io.basic;

import java.io.IOException;

public class ByteBufferExample {

    public void init(){
        ByteBufferHolder b1=new ByteBufferHolder();
        ByteBufferHolder b2=new ByteBufferHolder();
//        b1.setNext(b2);
//        b1.setPrev(b2);
//        b2.setNext(b1);
//        b2.setPrev(b1);

        try {
            System.in.read();
            b1.byteBuffer.clear();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            System.in.read();
            b2.byteBuffer.clear();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(b1.byteBuffer.limit());
    }
}
