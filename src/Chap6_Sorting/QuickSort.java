//퀵 정렬(비재귀 버전)
package Chap6_Sorting;

import java.util.ArrayList;
import java.util.List;

//스택 클래스
class Stack<T> {
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
	private List<T> data;	//스택용 List
	private int capacity; // 스택의 크기(List는 크기가 가변적이라서 의미 없을 듯)
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

//포인트 클래스
class Point {
	private int ix;
	private int iy;

	public Point(int x, int y) {
		ix = x;
		iy = y;
	}

	public int getX() {
		return ix;
	}

	public int getY() {
		return iy;
	}

	public void setX(int x) {
		ix = x;
	}

	public void setY(int y) {
		iy = y;
	}
}

//퀵정렬
public class QuickSort {

	// --- 배열 요소 a[idx1]와 a[idx2]의 값을 교환 ---//
	static void swap(int[] a, int idx1, int idx2) {
		int t = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = t;
	}

	// --- 퀵 정렬(비재귀 버전)---//
	static void quickSort(int[] a, int left, int right) {

		Stack<Point> st = new Stack<>(a.length);
		Point pt = new Point(left, right);
		st.push(pt);

		while(st.isEmpty() != true) {
			Point p = st.pop();
			int pl = left = p.getX();
			int pr = right = p.getY();
			int x = a[(pl+pr)/2];	//피벗값
			
			do {	//퀵 정렬
				while (a[pl]<x) pl++;	//0번에서 부터 올라가면서 피벗 x보다 큰 값이 있는지 확인
				while (a[pr]>x) pr--;	//마지막에서 부터 내려가면서 피벗 x보다 작은 값이 있는지 확인
				if (pl<=pr)
					swap(a, pl++, pr--);	//a[pl]과 a[pr]의 값을 교환
			}while(pl<=pr);	//pl이 pr보다 커질때까지 반복
			
			//배열 a를 피벗 이하와 피벗 초과로 나눈 후에 각각 스택 push
			//각각 다시 퀵정렬 실행
			if (left < pr) {	//피벗 이하
				pt = new Point(left, pr);
				st.push(pt);
			}
			if (pl < right) {	//피벗 초과
				pt = new Point(pl, right);
				st.push(pt);
			}
			//List가 비어있지 않으면 분할할 배열이 남았다는 것
		}
	}

	public static void main(String[] args) {
		int nx = 10;
		int[] x = new int[nx];
		for (int ix = 0; ix < nx; ix++) {
			double d = Math.random();
			x[ix] = (int) (d * 20);
		}
		for (int i = 0; i < nx; i++)
			System.out.print(" " + x[i]);
		System.out.println();

		quickSort(x, 0, nx - 1); // 배열 x를 퀵정렬

		System.out.println("오름차순으로 정렬했습니다.");
		for (int i = 0; i < nx; i++)
			System.out.print(" " + x[i]);
	}
}
