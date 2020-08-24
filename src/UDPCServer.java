import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPCServer {
	public static void main(String[] args) {
		DatagramSocket ds = null;
		DatagramPacket dp = null;
		try {
			ds = new DatagramSocket(8888);
			
			while(true) {
				byte[] bytes = new byte[1024];
				dp = new DatagramPacket(bytes, 0, bytes.length);
				ds.receive(dp);
				System.out.println("msg received!");
				String msg = new String(dp.getData(), 0, dp.getLength());
				System.out.println(msg);
				if (msg.equals("bye")) {
					System.out.println("byebye!");
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
