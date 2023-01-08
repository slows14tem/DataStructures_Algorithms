package Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Sorting6_3 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] arr1 = new int[N];
		Integer[] arr2 = new Integer[N];
		
		String[] str1 = br.readLine().split(" ");
		for (int i=0;i<N;i++) {
			arr1[i] = Integer.parseInt(str1[i]);
		}
		
		String[] str2 = br.readLine().split(" ");
		for (int i=0;i<N;i++) {
			arr2[i] = Integer.parseInt(str2[i]);
		}
		//arr1은 오름차순
		Arrays.sort(arr1);
		//arr2는 내림차순
		Arrays.sort(arr2, Collections.reverseOrder());
		
		//arr1의 가장 작은 값과 arr2의 가장 큰 값을 교환 = 지정된 횟수만큼의 교환 내에서 가장 큰 값을 출력 가능
		for (int i=0;i<K;i++) {
			//1번 배열의 값이 작을때만 수행
			if (arr1[i]<arr2[i]) {
				int temp = arr1[i];
				arr1[i] = arr2[i];
				arr2[i] = temp;
			} 
			//값이 크면 index i 부터는 1번 배열이 크다는 의미라서 중지하고 더하기 수행
			else break;
			
		}
		System.out.println(Arrays.stream(arr1).sum());
		
		
		
	}

}

