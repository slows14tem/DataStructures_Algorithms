package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BinarySearch7_1 {

	public static boolean binary_Search(int[] arr, int target, int start, int end) {
		if (start > end) return false;
		int mid = (int)(start + end) / 2;
		if (arr[mid] == target) return true;
		else if (arr[mid] > target) return binary_Search(arr, target, start, mid-1);
		else return binary_Search(arr, target, mid+1, end);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());	//가게의 부품
		int[] arr1 = new int[N];
		String[] str1 = br.readLine().split(" ");
		for (int i=0;i<N;i++) {
			arr1[i] = Integer.parseInt(str1[i]);
		}
		
		int M = Integer.parseInt(br.readLine());	//요청 부품
		int[] arr2 = new int[M];
		String[] str2 = br.readLine().split(" ");
		for (int i=0;i<M;i++) {
			arr2[i] = Integer.parseInt(str2[i]);
		}
		
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		
		for (int i=0;i<M;i++) {
			if (binary_Search(arr1, arr2[i], 0, N-1)) System.out.println("yes");
			else System.out.println("no");
		}

	}

}
