/*************************************************************************
 * Yusuf Aytas  © All Rights Reserved.
 * 
 * NOTICE:  All information contained herein is, and remains the property 
 * of Yusuf Aytas and its suppliers,if any.  The intellectual and 
 * technical concepts contained herein are proprietary to Yusuf Aytas
 * and its suppliers and may be covered by U.S. and Foreign Patents,patents
 * in process, and are protected by trade secret or copyright law.
 * Dissemination of this information or reproduction of this material is 
 * strictly forbidden unless prior written permission is obtained
 * from Yusuf Aytas.
 * Author : Yusuf Aytas
 * Date : Jul 30, 2012
 * File : Deserializer.java
 */
package com.sowhoo.common.serialization;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;

public class Deserializer {
	
	@SuppressWarnings("unchecked")
	public static <C> C deseralize(byte [] bytes){
		Object object = null;
		ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
		try {
			ObjectInput in = new ObjectInputStream(bis);
			object = in.readObject(); 
			bis.close();
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		return (C)object;
	}
	
}
