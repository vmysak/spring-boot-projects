package org.zeksa.io.basic;

import java.io.IOException;
import java.nio.ByteBuffer;

public class ByteBufferHolder {

    private final static int capacity=1024*1024*1842;

    private ByteBufferHolder prev;
    private ByteBufferHolder next;
    ByteBuffer byteBuffer;

    public ByteBufferHolder(){
        byteBuffer=ByteBuffer.allocateDirect(capacity);

        for(int i=0;i<capacity;i++){
            byteBuffer.put((byte)12);
        }
    }

    public ByteBufferHolder getPrev() {
        return prev;
    }

    public void setPrev(ByteBufferHolder prev) {
        this.prev = prev;
    }

    public ByteBufferHolder getNext() {
        return next;
    }

    public void setNext(ByteBufferHolder next) {
        this.next = next;
    }
}
