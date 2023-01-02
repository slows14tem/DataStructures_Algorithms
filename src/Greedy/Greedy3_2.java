package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//큰 수의 법칙
public class Greedy3_2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 세로
		int[] arr = new int[N];
		int M = Integer.parseInt(st.nextToken()); // 가로
		int K = Integer.parseInt(st.nextToken()); // 가로
		String[] str = br.readLine().split(" ");
		
		for (int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(str[i]);
		}
		
		Arrays.sort(arr);
		
//		int i = arr[N-1]*((M/K)*K) + arr[N-2]*(M%K);	//만약 M = 9, K = 3이라면 arr[N-1]이 9번 더해지는 결과로 오답
//		반드시 여러가지 변수를 대입해보고 결과가 항상 옳은지 확인해야
//		int i = (M/(K+1))*(arr[N-1]*K + arr[N-2]) + (M%(K+1))*arr[N-1];
		//가장 큰 수가 더해지는 횟수
		int i = (M/(K+1))*K + (M%(K+1));
		//두번째로 큰 수가 더해지는 횟수
		int j = (M/(K+1));
		System.out.println(i*arr[N-1] + j*arr[N-2]);

	}

}
