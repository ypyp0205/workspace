package kr.or.ddit.basic;

import java.net.ServerSocket;
import java.net.Socket;

public class T06_TcpServer {
	public static void main(String[] args) {
		// 서버 소켓을 만들고, 클라이언트가 접속하면 소켓을 만들어 
		// 데이터를 받는 클래스와 데이터를 보내는 클래스에 이 소켓을 넘겨준다.
		ServerSocket server = null;
		Socket socket = null;
		
		try {
			server = new ServerSocket(7777);
			System.out.println("서버 준비 완료...");
			socket = server.accept();
			
			System.out.println(socket.toString());
			
			Sender sender = new Sender(socket);
			Receiver receiver = new Receiver(socket);
			
			sender.start();
			receiver.start();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}

