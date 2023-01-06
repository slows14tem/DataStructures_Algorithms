package Implementation;

import java.util.Scanner;

public class Implementation4_2 {
	
	 // 특정한 시각 안에 '3'이 포함되어 있는지의 여부(하나씩 다 보는거보다 훨씬 효율적)
//    public static boolean check(int h, int m, int s) {
//        if (h % 10 == 3 || m / 10 == 3 || m % 10 == 3 || s / 10 == 3 || s % 10 == 3)
//            return true;
//        return false;
//    }

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str;
		int cnt = 0;
		int N = sc.nextInt();
		
		for (int i=0;i<=N;i++) {
			for (int j=0;j<60;j++) {
				for (int k=0;k<60;k++) {
					// 매 시각 안에 '3'이 포함되어 있다면 카운트 증가
                    //if (check(i, j, k)) cnt++;
					
					str = String.valueOf(i)+String.valueOf(j)+String.valueOf(k);
					for (int l=0;l<str.length();l++) {
						if (str.charAt(l) == '3') {
							System.out.println(str);
							cnt++;
							break;
						}
						
					}
				}
			}
		}
		System.out.println(cnt);

	}

}
//구현 or 완전 탐색문제
//하루는 86400초이기때문에 86400가지 경우의 수 밖에 없다.
//보통 전체 데이터 개수가 100만개 이하일 때 완전 탐색 사용하면 적절