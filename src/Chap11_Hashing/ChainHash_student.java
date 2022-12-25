package Chap11_Hashing;
//hash node가 student 객체일 때를 구현하는 과제
//체인법에 의한 해시
import java.util.Scanner;

class Student {
	static final int NO   = 1;        // 번호를 읽어 들일까요?
	static final int NAME = 2;        // 이름을 읽어 들일까요?

	private Integer no;                      // 회원번호(키값)
	private String  name;                    // 이름

	//--- 키값 ---//
	public Integer keyCode() {
		return no;
	}

	//--- 문자열 표현을 반환 ---//
	public String toString() {
		return no + ", " + name;
	}
	public Student(Integer snum, String sname) {
		no = snum; name = sname;
	}
	public Student(Student s) {
		no = s.no; name = s.name;
	}
	public Student() {
		no = null; name = null;
	}
	//--- 데이터를 읽어 들임 ---//

}
class ChainHash2 {
	//--- 해시를 구성하는 노드 ---//
	class Node2 {
		private Student data;                 // 키값
		private Node2 next;        // 뒤쪽 포인터(뒤쪽 노드에 대한 참조)

		//--- 생성자(constructor) ---//
		public Node2(Student s) {
			this.data  = new Student(s);
			this.next = null;
		}
		Node2(Student s, Node2 p) {
			this.data  = s;
			this.next = p;

		}
		Node2() {
			this.data  = null;
			this.next = null;
		}
		//--- 키값을 반환 ---//
		Integer getKey() {
			return data.keyCode();
		}

		//--- 키의 해시값을 반환 ---//
		public int hashCode() {
			int hash = getKey();
			return hash;
		}
	}

	private int    size;              // 해시 테이블의 크기
	private Node2[] table;        // 해시 테이블

	//--- 생성자(constructor) ---//
	public ChainHash2(int capacity) {
		try {
			table = new Node2[capacity];
			this.size = capacity;
		} catch (OutOfMemoryError e) {        // 테이블을 생성할 수 없음
			this.size = 0;
		}
	}

	//--- 해시값을 구함 ---//
	public int hashValue(Object key) {
		int hash;
		hash = key.hashCode() % size;
		return hash;
	}

	//--- 키값이 key인 요소를 검색(데이터를 반환) ---//
	public String search(int key) {
		int hash = hashValue(key);            // 검색할 데이터의 해시값
		Node2 p = table[hash];            // 선택 노드

		while (p != null) {
			if (p.getKey() == key) {
				return p.data.toString();
			}// 검색 성공
			p = p.next;                             // 다음 노드를 선택
		}
		return null;                                // 검색 실패
	}

	//--- 키값이 key인 데이터를 data의 요소로 추가 ---//
	public void add(Student st) {
		int hash = hashValue(st.keyCode());            // 추가할 데이터의 해시값		
		Node2 p = table[hash];            // 추가될 노드
		//같은 키값을 가진 해시값이 있는지 확인
		while(p!=null) {
			if (p.data.keyCode() == st.keyCode()) return;
			p=p.next;
		}
		//no의 중복이 없으면 노드 입력
		Node2 temp = new Node2(st, table[hash]);	//생성자 호출. table[hash]의 맨 앞에 새로운 노드를 삽입(새로운 temp의 next가 table[hash]가 됨)
		table[hash] = temp;
	}

	//--- 키값이 key인 요소를 삭제 ---//
	public void remove(int key) {
		int hash = hashValue(key);            // 삭제할 데이터의 해시값
		Node2 p = table[hash];            // 선택 노드
		Node2 pp = null;                  // 바로 앞의 선택 노드

		while(p!=null) {
			if (p.data.keyCode() == key) {
				if (pp == null) table[hash] = p.next;	//table[hash] 배열의 첫번째 값일 때
				else pp.next = p.next;	//table[hash] 배열의 두번쨰 이상의 값일 때
				System.out.println(key + "삭제");
				return;
			}
			pp=p;
			p=p.next;
		}
		System.out.println("값이 없습니다.");
                           // 찾는 키값이 없음
	}

	//--- 해시 테이블을 덤프(dump) ---//
	public void dump() {
		for (int i = 0; i < size; i++) {
			Node2 p = table[i];
			System.out.printf("%02d  ", i);
			while (p != null) {
				System.out.printf("→ %s ", p.getKey());
				p = p.next;
			}
			System.out.println();
		}
	}
}


public class ChainHash_student {
	static Scanner stdIn = new Scanner(System.in);

	public static void main(String[] args) {
		ChainHash2 hash = new ChainHash2(11);
		//11칸짜리 배열 생성
		Student data;
		int select = 0;
		final int count = 3;	//한번에 입력받는 student object개수
		while (select != 6) {
			System.out.println(
					"SimpleChainHash. Select 1:Add, 2. Delete, 3:Search, 4. PrintDump, 5. Quit =>");

			select = stdIn.nextInt();
			switch (select) {
			case 1:
				Student[] input = new Student[count];
				Integer sno = 0;
				String sname = null;
				for (int ix = 0; ix < count; ix++) {

					System.out.println("입력 데이터(sno, sname):: ");

					System.out.print("번호: ");
					sno = stdIn.nextInt();

					System.out.print("이름: ");
					sname = stdIn.next();
					
					System.out.print("sno =  " + sno);
					input[ix] = new Student(sno, sname);
					hash.add(input[ix]);

					System.out.print(" " + input[ix]);
				}
				break;
			case 2:
				// Delete
				int no = 0;
				System.out.println("삭제할 데이터(no):: ");
				System.out.print("번호: ");
				no = stdIn.nextInt();
				hash.remove(no);
				break;
			case 3:
				System.out.println("Search Value:: ");
				int val = stdIn.nextInt();			
				//Chap11_Hashing.ChainHash2.Node2 p = hash.search(val); //Node2는 ChainHash2의 inner class라서 Chap11_Hashing.ChainHash2.Node2로 선언
				String result = hash.search(val);
				System.out.println(result);
				break;
			case 4:
				hash.dump();
				break;
			case 5:
				System.out.println("Quit");
				break;

			default:
				System.out.println("WRONG INPUT  ");
				System.out.println("Re-Enter");
				break;
			}
		}
	}
}
