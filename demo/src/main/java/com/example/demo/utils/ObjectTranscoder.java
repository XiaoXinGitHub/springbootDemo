package com.example.demo.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

/*
 * 序列化工具类
 */
public class ObjectTranscoder {
	public static byte[] serialize(Object value) {
		if(value==null) {
			throw new NullPointerException("Can not serialize null");
		}
		byte [] rv=null;
		ByteArrayOutputStream bos=null;
		ObjectOutput os =null;
		try {
			bos=new ByteArrayOutputStream();
			os=new ObjectOutputStream(bos);
			os.writeObject(value);
			os.close();
			bos.close();
			rv=bos.toByteArray();
		} catch (Exception e) {
			throw new IllegalArgumentException("Non-serializable object",e); 
		}finally {
				try {
					if(os!=null)os.close();
					if(bos!=null)bos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}		
		}
		return rv;
	}
	public static Object deserialize(byte[] value) {
		Object rv=null;
		ByteArrayInputStream bis=null;
		ObjectInputStream is=null;
		try {
			if(value!=null) {
				bis=new ByteArrayInputStream(value);
				is=new ObjectInputStream(bis);
				rv=is.readObject();
				is.close();
				bis.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(bis!=null)bis.close();
				if(is!=null)is.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return rv;
	}
}

