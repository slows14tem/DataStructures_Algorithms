package Chap8_LinkedList;

import java.util.Comparator;

public class DoubledLinkedList<E> {

//원형 이중 연결 리스트 클래스 - first node를 가짐

	// --- 노드 ---//
	class Node<E> {
		private E data; // 데이터
		private Node<E> llink; // 앞쪽포인터(앞쪽 노드에 대한 참조)
		private Node<E> rlink; // 뒤쪽포인터(뒤쪽 노드에 대한 참조)

		// --- 생성자(constructor) ---//
		public Node() {
			//데이터가 null이고 앞,뒤 포인터 모두 자기자신을 가리키는 노드 생성
			data = null;
			llink = rlink = this;
		}

		public Node(E data, Node<E> llink, Node<E> rlink) {
			super();
			this.data = data;
			this.llink = llink;
			this.rlink = rlink;
		}
	}

	private Node<E> first; // 머리 포인터(참조하는 곳은 더미노드)

	// --- 생성자(constructor) ---//
	public DoubledLinkedList() {
		first = new Node<E>(); // dummy(first) 노드를 생성
	}

	// --- 리스트가 비어있는가? ---//
	public boolean isEmpty() {
		return first.rlink == first;
	}

	// --- 노드를 검색 ---//
	public E search(E obj, Comparator<? super E> c) {
		Node<E> ptr = first.rlink; // 현재 스캔 중인 노드

		while (ptr != first) {
			if (c.compare(obj, ptr.data) == 0) {
				return ptr.data; // 검색 성공
			}
			ptr = ptr.rlink; // 뒤쪽 노드에 주목
		}
		return null; // 검색 실패
	}

	// --- 전체 노드 표시 ---//
	public boolean show() {
		Node<E> ptr = first.rlink; // 더미 노드의 뒤쪽 노드
		if (first.rlink == first) {
			System.out.println("리스트가 비었습니다.");
			return false;
		}
		while (ptr != first) {
			System.out.println(ptr.data);
			ptr = ptr.rlink;
		}
		return true;
	}

	// --- 올림차순으로 정렬이 되도록 insert ---//
	public void add(E obj, Comparator<? super E> c) {		
		
		if (first.rlink == first) {
			first.rlink = new Node<E>(obj, first, first);
			System.out.println("입력되었습니다.");
			return;
		}
		Node<E> pre = first;
		Node<E> ptr = first.rlink;
		while(ptr != first) {
			if(c.compare(ptr.data, obj)>0) {
				pre.rlink = new Node<E>(obj, pre, ptr);
				System.out.println("입력되었습니다.");
				break;
			} else if (c.compare(ptr.data, obj)<0) {
				if (ptr.rlink == first) {
					ptr.rlink = new Node<E>(obj, ptr, first);
					System.out.println("입력되었습니다.");
					break;
				}				
			} else {
				System.out.println("사용할 수 없는 번호입니다.");
				break;
			}
			pre = ptr;
			ptr = ptr.rlink;
		}
	}

	// --- list에 삭제할 데이터가 있으면 해당 노드를 삭제 ---//
	public void delete(E obj, Comparator<? super E> c, Comparator<? super E> d) {

		Node<E> pre = first;
		Node<E> ptr = first.rlink;
		while(ptr != first) {
			if (c.compare(ptr.data, obj)==0 && d.compare(ptr.data, obj)==0) {
				pre.rlink = ptr.rlink;
				ptr.rlink.llink = pre;
				System.out.println("삭제되었습니다.");
				return;
			}
			pre = ptr;
			ptr = ptr.rlink;
		}
		System.out.println("데이터가 없습니다.");			
	}
}
