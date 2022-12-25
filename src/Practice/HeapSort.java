package Practice;

import java.util.ArrayList;
import java.util.Scanner;

public class HeapSort{
	
	public static void main(String[] args) {
		int select = 0;
		Scanner stdIn = new Scanner(System.in);
		int maxlen = 10;
		int[] arr = new int[maxlen];
		int ptr=0;
		
		do {
			System.out.println("Select: 1 입력, 2 오름차순 정렬, 3 내림차순 정렬, >=5 exit");
			System.out.print("번호 입력: ");
			System.out.println();
			select = stdIn.nextInt();
			switch (select) {			
				case 1:
					try {
						System.out.print("입력: ");
						System.out.println();
						int nx = stdIn.nextInt();
						arr[ptr++] = nx;				
						Insert(arr, ptr, nx);
						arr = HeapSort(arr);
						break;
					} catch(Exception e) {
						System.out.println("모두 입력되었습니다.");
					}
					
				case 2:
					System.out.println("오름차순 정렬");					
					int[] arrAs = Sort(arr, select);
					for (int i = 0; i < 10; i++)
				        System.out.print(" " + arrAs[i]);
				    System.out.println();
					break;
					
				case 3:
					System.out.println("내림차순 정렬");
					int[] arrDe = Sort(arr, select);
					for (int i = 0; i < 10; i++)
				        System.out.print(" " + arrDe[i]);
				    System.out.println();
					break;
//				case 4:
//					System.out.println("정렬후: ");
//				    for (int i = 0; i < 10; i++)
//				        System.out.print(" " + arr[i]);
//				    System.out.println();
//				    break;
				case 5:
					return;
			}
		} while(select<5);

	}
		

	static void swap(int[] a, int idx1, int idx2) {
	     int t = a[idx1];  
	     a[idx1] = a[idx2];  
	     a[idx2] = t;
	 }

	private static int[] HeapSort(int[] arr) {
		int ptr = arr.length;
		int[] arrT = new int[arr.length];		
		for (int i=0; i<arr.length;i++) {
			arrT[i] = arr[0];
			swap(arr, 0, ptr-1);
			ptr--;
			for (int j=1;j<=ptr;j++) {
				Insert(arr, j, arr[j-1]);
			}				
		}
		return arrT;
	}
	
	private static int[] Sort(int[] arr, int select) {
		if (select == 2) {
			int[] newArr = new int[arr.length];
	        for (int i = 0; i < arr.length; i++) {
	            newArr[arr.length - 1 - i] = arr[i];
	        }
	        return newArr;
		}
		return arr;
	}
	
	private static void Insert(int[] arr, int ptr, int nx) {
		int i;
		if (ptr >= arr.length) return;
		for (i=ptr-1;i>=0;i=(i-1)/2) {
			if (i==0) break;
			if (nx<=arr[(i-1)/2]) break;
			arr[i] = arr[(i-1)/2];
		}
		arr[i]=nx;		
	}

	
}

