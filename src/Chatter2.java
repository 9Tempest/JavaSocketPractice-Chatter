
public class Chatter2 {
	public static void main(String[] args) {
		System.out.println("chatter 2 is online");
		new Thread(new TalkSent(6666,"localhost")).start();
		new Thread(new TalkReceive(8888, "Chatter1")).start();
	}
}
