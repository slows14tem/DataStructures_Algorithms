package Sorting;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Sorting6_1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Integer[] arr = new Integer[N];
		for (int i=0;i<N;i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr, Collections.reverseOrder());
		
		System.out.println("Sorted arr[] : " + Arrays.toString(arr));
	}

}
//그냥 자바의 기본 정렬 알고리즘을 사용한 것.