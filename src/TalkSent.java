
import java.io.BufferedReader;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.io.InputStreamReader;

public class TalkSent implements Runnable{
	DatagramSocket ds = null;
	BufferedReader reader = null;
	
	private int port;
	private String toIp;
	
	public TalkSent(int port, String toIp) {
		super();
		this.port = port;
		this.toIp = toIp;
		try {
			ds = new DatagramSocket();
			reader = new BufferedReader(new InputStreamReader(System.in));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
			try {
				while(true) {
					String msg = reader.readLine();
					byte[] data = msg.getBytes();
					DatagramPacket dp = new DatagramPacket(data, 0, data.length, new InetSocketAddress(toIp, port));
					ds.send(dp);
					if (msg.equals("bye")) {
						break;
					}
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	finally {
				if (ds != null) {
					ds.close();
				}
				if (reader != null) {
					try {
						reader.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			
		}
		
	}
	

	//getter setter
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	public String getToIp() {
		return toIp;
	}
	public void setToIp(String toIp) {
		this.toIp = toIp;
	}

}
