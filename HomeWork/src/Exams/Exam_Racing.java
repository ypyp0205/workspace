
package Exams;



/*
 	3개(명)의 쓰레드가 각각 알파벳 대문자를 출력하는데 
 	출력을 끝낸 순서대로 결과를 나타내는 프로그램 작성하기
 */
public class Exam_Racing {
	static String strRank = "";
	
	public static void main(String[] args) {
		
		DisplayCharacter[] disChars = new DisplayCharacter[] {
				new DisplayCharacter("1번 말"),
				new DisplayCharacter("2번 말"),
				new DisplayCharacter("3번 말"),
				new DisplayCharacter("4번 말"),
				new DisplayCharacter("5번 말"),
				new DisplayCharacter("6번 말"),
				new DisplayCharacter("7번 말"),
				new DisplayCharacter("8번 말"),
				new DisplayCharacter("9번 말")
				
		};
		
		for(int i = 0; i < disChars.length; i++) {
			disChars[i].start();
		}
		for(DisplayCharacter dc : disChars) {
			try {
				dc.join();
			}catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("경기 끝...");
		System.out.println("--------------------------------------");
		System.out.println();
		System.out.println("경기 결과");
		System.out.println("순위 : " + strRank);
	}
}

class DisplayCharacter extends Thread{
	private String name;
	
	// 생성자
	public DisplayCharacter(String name) {
		this.name = name;
	}
	@Override
	public void run() {
		for(int i = 0; i <= 50; i++) {
			System.out.println(name + "의 출력문자 : ");
			
			try {
				// sleep()메서드의 값을 200~500사이의 난수로 한다.
				Thread.sleep((int)(Math.random() * 301 + 1000));
			}catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(name + "출력 끝...");
		Exam_Racing.strRank += name + " ";
	}
}