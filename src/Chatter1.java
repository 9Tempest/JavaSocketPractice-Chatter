
public class Chatter1 {
	public static void main(String[] args) {
		System.out.println("chatter 1 is online");
		new Thread(new TalkSent(8888, "localhost")).start();
		new Thread(new TalkReceive(6666, "Chatter2")).start();
	}
}
