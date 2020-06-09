package com.flipkart.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileHandling {

	public static void main(String[] args) throws IOException {

		BufferedReader inputStream = null;
		BufferedWriter outputStream = null;

		try {
			inputStream = new BufferedReader(new FileReader("output.txt"));
			outputStream = new BufferedWriter(new FileWriter("test.txt",true));

			int c;
			while ((c = inputStream.read()) != -1) {
				outputStream.write(c);
			}
		} finally {
			if (inputStream != null) {
				inputStream.close();
			}
			if (outputStream != null) {
				outputStream.close();
			}
		}

	}

}
