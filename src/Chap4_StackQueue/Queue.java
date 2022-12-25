package Chap4_StackQueue;

import java.util.ArrayList;
import java.util.List;

//List 큐<Integer> 형식
//데이터를 일시적으로 쌓아 놓는 자료구조. 가장 먼저 넣은 데이터를 가장 먼저 꺼내는 선입선출(First in First out)방식
public class Queue {
//	private int[] que; // 큐용 배열
	private List<Integer> que;
	private int capacity; // 큐의 크기
	private int front; // 맨 처음 요소 커서
	private int rear; // 맨 끝 요소 커서
	private int num; // 현재 데이터 개수

//--- 실행시 예외: 큐가 비어있음 ---//
	public class EmptyQueueException extends RuntimeException {
		public EmptyQueueException() {
		}
	}

//--- 실행시 예외: 큐가 가득 찼음 ---//
	public class OverflowQueueException extends RuntimeException {
		public OverflowQueueException() {
		}
	}

//--- 생성자(constructor) ---//
	public Queue(int maxlen) {
	
	   try {
		   que = new ArrayList<Integer>(maxlen);
		   capacity = maxlen;
		   num = front = rear = 0;
	
	   } catch (OutOfMemoryError e) {        // 생성할 수 없음
	       capacity = 0;
	   }
	}

//--- 큐에 데이터를 인큐 ---//
	public int enque(int x) throws OverflowQueueException {
		if (num >= capacity)
			throw new OverflowQueueException(); // 큐가 가득 찼음
		que.add(x);
		rear = que.size();
		num++;
		return x;
	}

//--- 큐에서 데이터를 디큐 ---//
	public int deque() throws EmptyQueueException {
		if (num <= 0)
			throw new EmptyQueueException(); // 큐가 비어있음
		int ret = que.get(front);
		que.remove(front);
		rear = que.size();
		return ret;
	}

//--- 큐에서 데이터를 피크(프런트 데이터를 들여다봄) ---//
	public int peek() throws EmptyQueueException {
		if (num <= 0)
			throw new EmptyQueueException(); // 큐가 비어있음
		return que.get(front);
	}

//--- 큐를 비움 ---//
	public void clear() {
		num = front = rear = 0;
		que.clear();
	}

//--- 큐에서 x를 검색하여 인덱스(찾지 못하면 –1)를 반환 ---//
	public int indexOf(int x) {
		return que.indexOf(x);
	}

//--- 큐의 크기를 반환 ---//
	public int getCapacity() {
		return capacity;
	}

//--- 큐에 쌓여 있는 데이터 개수를 반환 ---//
	public int size() {
		return rear;
	}

//--- 큐가 비어있는가? ---//
	public boolean isEmpty() {
		return num <= 0;
	}

//--- 큐가 가득 찼는가? ---//
	public boolean isFull() {
		return num >= capacity;
	}

//--- 큐 안의 모든 데이터를 프런트 → 리어 순으로 출력 ---//
	public void dump() {
		if (num <= 0)
			System.out.println("큐가 비어있습니다.");
		else {
			for(Integer t:que) {
				System.out.println(t);
			}
		}
	}
}