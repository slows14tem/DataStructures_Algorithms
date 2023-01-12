package DynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class DynamicProgramming8_2 {

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		String[] K = bf.readLine().split(" ");
		int[] arr = new int[N];
		int[] sum = new int[100];
		for (int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(K[i]);
		}
		sum[0] = arr[0];
		sum[1] = arr[1];
		
		for (int i=2;i<N;i++) {
			sum[i] = Math.max(sum[i-1], sum[i-2]+arr[i]);
		}
		System.out.println(sum[N-1]);
	}

}
