package sample;

import java.io.*;

public class PostmanImpl implements Postman {

	private PrintStream output;
	
	public PostmanImpl() {
		output = System.out;
	}
	
//	public PostmanImpl() throws IOException {
//		output = new PrintStream(new FileOutputStream("msg.txt"));
//	}
//
	public void deliverMessage(String msg) {
		int a = Integer.parseInt(msg);System.out.println(a+9);if(a<10){System.out.println("true");}else{System.out.println("false");}

		output.flush();
	}
}

