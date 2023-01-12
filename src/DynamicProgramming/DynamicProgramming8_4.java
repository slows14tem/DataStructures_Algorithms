package DynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

public class DynamicProgramming8_4 {

//	public static void main(String[] args) throws Exception {
//		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(bf.readLine());
//		int N = Integer.parseInt(st.nextToken());
//		int M = Integer.parseInt(st.nextToken());
//		Integer[] money = new Integer[N];
//		for (int i=0;i<N;i++) {
//			money[i] = Integer.parseInt(bf.readLine());
//		}
//		
//		int result=0;
//		Arrays.sort(money, Collections.reverseOrder());
//		for (int i=0;i<N;i++) {
//			if (money[i] > M) continue;
//			result += M/money[i];
//			if(M%money[i] == 0) break;
//			else M = M%money[i];
//			
//			if (M < money[i]) {
//				result = -1;
//				break;
//			}
//		}
//		System.out.println(result);
//
//	}
	
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 정수 N, M을 입력받기
        int n = sc.nextInt();
        int m = sc.nextInt();

        // N개의 화폐 단위 정보를 입력 받기
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // 앞서 계산된 결과를 저장하기 위한 DP 테이블 초기화 
        int[] d = new int[m + 1];
        Arrays.fill(d, 10001);

        // 다이나믹 프로그래밍(Dynamic Programming) 진행(보텀업)
        d[0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = arr[i]; j <= m; j++) {
                // (i - k)원을 만드는 방법이 존재하는 경우
                if (d[j - arr[i]] != 10001) {
                    d[j] = Math.min(d[j], d[j - arr[i]] + 1);
                }
            }
        }

        // 계산된 결과 출력
        if (d[m] == 10001) { // 최종적으로 M원을 만드는 방법이 없는 경우
            System.out.println(-1);
        }
        else {
            System.out.println(d[m]);
        }
    }

}
