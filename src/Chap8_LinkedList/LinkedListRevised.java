package Chap8_LinkedList;

import java.util.Comparator;

public class LinkedListRevised<E> {
//연결 리스트 클래스
	class Node<E> {	//public class 밖에서 생성한다면 getter, setter 생성해야함
		//내부클래스 (클래스의 멤버로 또다른 클래스를 선언한 것) - 오직 한 곳에서만 사용되는 클래스는 꼭 따로 클래스를 생성하지 않고 내부클래스로 선언해서 사용 
		private E data; // 데이터 입력칸
		private Node<E> next; // 뒤쪽 포인터(다음 노드에 대한 참조)

		// --- 생성자(constructor) ---//
		Node(E data) {
			this.data = data;
			this.next = null;
		}
	}

	private Node<E> head; // 머리 포인터(머리 노드에 대한 참조)

	// --- 생성자(constructor) ---//
	public LinkedListRevised() {
		head = null;
	}

	// --- 노드 검색 ---//
	public E search(E obj, Comparator<? super E> c) {//<? super E>는 wild card로서 E의 subclass에 대하여 모두 적용
		Node<E> ptr = head; // 현재 스캔 중인 노드

		while (ptr != null) {
			if (c.compare(obj, ptr.data) == 0) { // 검색 성공
				return ptr.data;
			}
			ptr = ptr.next; // 뒤쪽 노드에 주목
		}
		return null; // 검색 실패
	}
	
	// --- 꼬리 노드 삽입 ---//
	public void add(E obj, Comparator<? super E> c ) {
		if (head == null || c.compare(head.data, obj)>0) {
			//head에 데이터가 없거나 헤드의 데이터가 obj보다 더 클때
			Node<E> First = head;
			head = new Node<E>(obj);
			head.next = First;
		}			
		else {
			Node<E> ptr = head;
			Node<E> pre = head;
			while(ptr != null) {
				if(c.compare(ptr.data, obj) > 0) {
					//ptr이 obj보다 클때 pre와 ptr사이에 obj가 위치
					pre.next = new Node<E>(obj);
					pre.next.next = ptr;
					break;
				}else if (c.compare(ptr.data, obj) < 0) {
					//ptr보다 obj가 클때 
					if (ptr.next == null) {
						//ptr이 마지막 데이터(ptr.next == null)일때 마지막에 obj가 위치
						//그게 아니면 ptr.next로 넘어가서 비교
						ptr.next = new Node<E>(obj);
						break;
					}					
				}else {
					//같은 번호가 있을때
					System.out.println("해당 번호는 사용할 수 없습니다.");
					break;
				}
				pre = ptr;
				ptr = ptr.next;
				//pre와 ptr이 한칸 간격을 두고 이동
			}						
		}
	}

	// --- 노드p 삭제 ---//
	//NO_NAME_ORDER로 한번에 사용할 때
//	public void delete(E obj, Comparator<? super E> c ) {//전달 객체를 삭제
//		if (head == null) {
//			System.out.println("리스트가 비었습니다.");
//			return;
//		} else {
//			if (c.compare(obj, head.data) == 0) {
//				head = head.next;
//				System.out.println(obj + "가 삭제되었습니다.");
//				return;
//			}
//		}
//		
//		Node<E> ptr = head.next;
//		Node<E> pre = head;
//		while(ptr!=null) {
//			if (c.compare(obj, ptr.data) == 0) {
//				if (ptr.next == null) {
//					ptr = ptr.next;
//					System.out.println(obj + "가 삭제되었습니다.");
//					return;
//				} else {
//					pre.next = ptr.next;
//					System.out.println(obj + "가 삭제되었습니다.");
//					return;
//				}
//			} 
//			pre = ptr;
//			ptr = ptr.next;
//		}
//		System.out.println("데이터가 없습니다.");
//	}
	
	//두가지를 따로 사용할 때
	public void delete(E obj, Comparator<? super E> c, Comparator<? super E> d) {
		if (head == null) {
			System.out.println("리스트가 비었습니다.");
			return;
		} else {
			if (c.compare(obj, head.data) == 0 && d.compare(obj, head.data) == 0) {
				head = head.next;
				System.out.println(obj + "가 삭제되었습니다.");
				return;
			}
		}
		
		Node<E> ptr = head.next;
		Node<E> pre = head;
		while(ptr!=null) {
			if (c.compare(obj, ptr.data) == 0 && d.compare(obj, ptr.data) == 0) {
				if (ptr.next == null) {
					ptr = ptr.next;
					System.out.println(obj + "가 삭제되었습니다.");
					return;
				} else {
					pre.next = ptr.next;
					System.out.println(obj + "가 삭제되었습니다.");
					return;
				}
			} 
			pre = ptr;
			ptr = ptr.next;
		}
		System.out.println("데이터가 없습니다.");
	}

	// --- 전체 노드 표시 ---//
	public void show() {
		Node<E> ptr = head;

		while (ptr != null) {
			System.out.println(ptr.data);
			ptr = ptr.next;
		}
	}
}