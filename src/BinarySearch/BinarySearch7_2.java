package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BinarySearch7_2 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		String[] str = bf.readLine().split(" ");
		for (int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(str[i]);
		}
		
		int max = Arrays.stream(arr).max().getAsInt();
		int min = 0;
		int mid = (max + min)/2;
		
		while(min <= max) {
			int sum = 0;
			for (int i=0;i<N;i++) {
				if (arr[i] > mid) {
					sum += (arr[i] - mid);
				}
				
			}
			if (sum > M) {
				min = mid + 1;
				mid = (max + min)/2;
			}
			else if (sum < M) {
				max = mid -1;
				mid = (max + min)/2;
			}
		}
		System.out.println(mid);
		
	}

}

//전형적인 이진탐색 문제, 파라메트릭 서치 유형(원하는 조건을 만족하는 가장 알맞은 값을 찾는 문제 ex-범위 내에서 조건을 만족하는 가장 큰 값을 찾는 문제)