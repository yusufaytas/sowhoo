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
 * File : CompositeMessageContent.java
 */
package com.sowhoo.common.message;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("rawtypes")
public class CompositeMessageContent extends MessageContent<List<MessageContent>>{
	
	public CompositeMessageContent(){
		content = new ArrayList<MessageContent>();
	}
}
