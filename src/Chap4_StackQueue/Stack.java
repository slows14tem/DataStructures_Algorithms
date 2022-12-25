package Chap4_StackQueue;

import java.util.ArrayList;
import java.util.List;
//스택-데이터를 일시적으로 쌓아놓는 자료구조. 가장 나중에 넣은 데이터를 가장 먼저 꺼내는 후입선출(Last in Fisrt out)방식
public class Stack<T> {
	//generic == 데이터 형식에 의존하지 않고, 하나의 값이 여러 다른 데이터 타입들을 가질 수 있도록 하는 방법
	//--- 실행시 예외: 스택이 비어있음 ---//
	// generic class는 Throwable을 상속받을 수 없다 - 지원하지 않는다
	public class EmptyStackException {	// extends Exception
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public EmptyStackException() {
			super();
		}
	}

	//--- 실행시 예외: 스택이 가득 참 ---//
	public class OverflowStackException { //extends RuntimeException
		public OverflowStackException() {
		}
	}

//private T data[];           // 스택용 배열
	//Collection List를 활용한 스택 구현
	private List<T> data;	//스택용 List
	private int capacity; // 스택의 크기
	private int top; // 스택 포인터

//--- 생성자(constructor) ---//
	public Stack(int maxlen) {		
		data = new ArrayList<T>(maxlen);
		capacity = maxlen;
		top = data.size();
	}

//--- 스택에 x를 푸시 ---//
	public T push(T x) {
		data.add(x);		
		top = data.size();
		return x;
	}
	
//--- 스택에서 데이터를 팝(정상에 있는 데이터를 꺼냄) ---//
	public T pop()  {
		if (top == 0) {
			System.out.println("스택이 비었습니다.");
			return null;
		}
		T topVal = data.get(top-1);
		data.remove(top-1);
		top = data.size();
		return topVal;
	}

//--- 스택에서 데이터를 피크(peek, 정상에 있는 데이터를 들여다봄) ---//
	public T peek() {
		if (top == 0) {
			System.out.println("스택이 비었습니다.");
			return null;
		}
		return data.get(top-1);
	}

//--- 스택을 비움 ---//
	public void clear() {
		data.clear();
	}

//--- 스택에서 x를 찾아 인덱스(없으면 –1)를 반환 ---//
	public int indexOf(T x) {
		return data.indexOf(x);
	}

//--- 스택의 크기를 반환 ---//
	public int getCapacity() {
		return capacity;
	}

//--- 스택에 쌓여있는 데이터 갯수를 반환 ---//
	public int size() {
		return top;
	}

//--- 스택이 비어있는가? ---//
	public boolean isEmpty() {
		return top <= 0;
	}

//--- 스택이 가득 찼는가? ---//
	public boolean isFull() {
		return top >= capacity;
	}

//--- 스택 안의 모든 데이터를 바닥 → 정상 순서로 표시 ---//
	public void dump() {
		for(T t:data) {
			System.out.println(t);
		}
	}
}