package com.sowhoo.common.serialization;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

public class Serializer {
	
	public static byte[] serialize(Object object){
		byte[] objectBytes = null;
		ByteArrayOutputStream bos = new ByteArrayOutputStream(); 
		try {
			ObjectOutput out = new ObjectOutputStream(bos);  
			out.writeObject(object);
			objectBytes = bos.toByteArray();
			out.close();
			bos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return objectBytes;
	}
}
