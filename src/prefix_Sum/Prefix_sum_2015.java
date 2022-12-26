package prefix_Sum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Prefix_sum_2015 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = br.readLine().split(" ");
        int N = Integer.parseInt(strs[0]);
        int K = Integer.parseInt(strs[1]);
			
        String[] num = br.readLine().split(" ");
		
		//배열 전체 누적합 계산
		int[] K_arr = new int[N+1];
		for (int i=0;i<N;i++) {
			K_arr[i+1] = K_arr[i] + Integer.parseInt(num[i]);
		}
		
		// 1 ≤ i ≤ j ≤ N인 정수 i와 j에 대해 A[i]부터 A[j]까지의 합
		//이중for문으로 풀면 시간초과(시간복잡도를 충족시키지 못함)
		int cnt=0;
		for(int i=1;i<=N;i++) {
			for(int j=i;j<=N;j++) {
				if(K_arr[j] - K_arr[i-1] == K) cnt++;
			}
		}
		
		//합이 K인 부분합의 계수
		System.out.println(cnt);
	}

}

//map 함수를 활용해야하는데 풀이가 이해안감
