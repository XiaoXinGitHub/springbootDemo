/**
 * 
 */
package com.example.demo.utils;

import java.util.UUID;

public class UUIDUtils {

	public static String uuid() {
		//java.util.UUID;
		String uuid = UUID.randomUUID().toString();
		return uuid.replaceAll("-", "");
	}

	public static String fileNameUUID(String fileName) {
		return uuid() + "_" + fileName;
	}

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			System.out.println(uuid());
		}
	}
}
