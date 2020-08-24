
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class TalkReceive implements Runnable{
	private int port;
	private String msgFrom;
	DatagramSocket ds = null;
	
	public TalkReceive(int port, String msgFrom) {
		// TODO Auto-generated constructor stub
		this.setPort(port);
		this.setMsgFrom(msgFrom);
		try {
			ds = new DatagramSocket(port);
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void run() {
			
			try {
				while (true) {
					byte[] buffer = new byte[1024];
					DatagramPacket dp = new DatagramPacket(buffer, 0, buffer.length);
					ds.receive(dp);
					String msg = new String(buffer, 0, buffer.length);
					System.out.println(msgFrom + ": " + msg);
					if (msg.equals("bye")) break;
				}

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	finally {
				if (ds != null) {
					ds.close();
				}
			}
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getMsgFrom() {
		return msgFrom;
	}

	public void setMsgFrom(String msgFrom) {
		this.msgFrom = msgFrom;
	}

}
