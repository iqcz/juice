package com.packt.mvneclipse.javainanutshell.io;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class ByteBufferExample {

    public static void main(String[] args) {
	ByteBuffer b = ByteBuffer.allocateDirect(65536);
	ByteBuffer b2 = ByteBuffer.allocate(4096);

	byte[] data = { 1, 2, 3 };
	ByteBuffer b3 = ByteBuffer.wrap(data);

	System.out.println(b3.order(ByteOrder.BIG_ENDIAN));

	int capacity = b3.capacity();
	int position = b3.position();
	int limit = b3.limit();
	int remaining = b3.remaining();
	boolean more = b3.hasRemaining();
	System.out.printf("c: %d, p: %d, l: %d, r: %d, m: %b\n", capacity, position, limit, remaining, more);
	
    }

}
