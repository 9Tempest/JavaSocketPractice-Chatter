import java.io.BufferedReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import java.io.InputStreamReader;

public class UDPClient {
	public static void main(String[] args) {
		DatagramSocket ds = null;
		DatagramPacket dp = null;
		try {
			ds = new DatagramSocket(6666);
			
			while(true) {
				BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
				String msg = reader.readLine();
				dp = new DatagramPacket(msg.getBytes(), 0, msg.length(), InetAddress.getByName("localhost"), 8888);
				ds.send(dp);
				System.out.println("msg sent!");
				if (msg.equals("bye")) {
					break;
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (ds != null) {
				ds.close();
			}
		}
	}
}
