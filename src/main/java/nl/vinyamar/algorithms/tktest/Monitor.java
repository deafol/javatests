package nl.vinyamar.algorithms.tktest;

import java.io.IOException;
import java.net.Socket;

public class Monitor {
	public static void checkAvailability(String webAddress, int checkFrequency, int waitTimeOut) {
		int i = 0;
		boolean connected = false;
		while (i < checkFrequency && !connected) {
			try {
				i++;
				Socket socket = new Socket(webAddress, 80);
				socket.setSoTimeout(waitTimeOut);
				socket.getInetAddress();
				connected = true;
				System.out.println("Connected!");
			} catch (IOException e) {
				System.out.println("Not connected: " + e.getMessage());
			}
		}
	}

	public static void main(String[] args) throws IOException {
		checkAvailability("www.google.com", 2, 10);
		checkAvailability("www.example.co/", 2, 10);
	}
}
