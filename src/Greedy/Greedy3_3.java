package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Greedy3_3 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 행
		int M = Integer.parseInt(st.nextToken()); // 열
		int[] min = new int [M];	//최소값을 구할 열
		int[] max = new int [N];	//최소값들 중 최대값을 구할 열
		for (int i=0;i<N;i++) {
			String[] str = br.readLine().split(" ");
			for(int j=0;j<M;j++) {
				min[j] = Integer.parseInt(str[j]);
			}
			max[i] = Arrays.stream(min).min().getAsInt();
			
		}
		System.out.println(Arrays.stream(max).max().getAsInt());
		
	}
	
	
	/*	math 함수의 min을 이용한 방법
	 Scanner sc = new Scanner(System.in);

        // N, M을 공백을 기준으로 구분하여 입력 받기
        int n = sc.nextInt();
        int m = sc.nextInt();
        int result = 0;

        // 한 줄씩 입력 받아 확인하기
        for (int i = 0; i < n; i++) {
            // 현재 줄에서 '가장 작은 수' 찾기
            int min_value = 10001;	//1이상 10000이하라서 min_value를 10001로 초기화한듯(비교해서 더 작은 것으로 가야하니깐)
            for (int j = 0; j < m; j++) {
                int x = sc.nextInt();
                min_value = Math.min(min_value, x);
            }
            // '가장 작은 수'들 중에서 가장 큰 수 찾기
            result = Math.max(result, min_value);
        }

        System.out.println(result); // 최종 답안 출력
    }
	 */

}
