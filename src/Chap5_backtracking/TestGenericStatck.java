package Chap5_backtracking;

import java.util.Scanner;

// Stack2 테스트용
public class TestGenericStatck {
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		Stack2 s = new Stack2(8); // 최대 64 개를 푸시할 수 있는 스택
		Point p = new Point(0,0);	

		while (true) {
			
			int rndx = (int)((Math.random()*10000)%10);
			int rndy = (int)((Math.random()*10000)%10);
			System.out.println(); // 메뉴 구분을 위한 빈 행 추가
			System.out.printf("현재 데이터 개수: %d / %d\n", s.size(), s.getCapacity());
			System.out.print("(1)푸시　(2)팝　(3)피크　(4)덤프 (5)비움 (6)검색　(0)종료: ");

			int menu = stdIn.nextInt();
			if (menu == 0)
				break;

			switch (menu) {
			case 1: // 푸시
				System.out.print("데이터: ");
				
				if (s.isFull())
					System.out.println("스택이 가득찼있습니다.");
				else {
					//객체는 주소값을 가리킨다. 객체를 while 안에서 다시 선언하지 않으면 스택에 추가되는 객체는..
					//결국 while밖에서 선언된 객체의 주소값을 가지기 때문에 스택의 모든 값이 변경된다.
					p.setX(rndx);
					p.setY(rndy);
					s.push(p);
//					s.push(new Point(rndx, rndy));
				}
				break;

			case 2: // 팝
				if (s.isEmpty())
					System.out.println("스택이 비어있습니다.");
				else {
//					s.pop();
					System.out.println("팝한 데이터는 " + s.pop() + "입니다.");
				}
				break;

			case 3: // 피크
				if (s.isEmpty())
					System.out.println("스택이 비어있습니다.");
				else {
//					s.peek();
					System.out.println("피크한 데이터는 " + s.peek() + "입니다.");
				}
				break;

			case 4: // 덤프
				s.dump();
				break;
			
			case 5:	//클리어
				s.clear();
				break;
				
			case 6:
				System.out.println(s.indexOf(new Point(9, 9)));
				break;
			}
		}
	}
}
