package prefix_Sum;

import java.util.Scanner;

public class Prefix_sum_11441 {
	//백준 11441번 (11659번과 풀이가 완전 같다)
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int size=sc.nextInt();
		int[] arr= new int[size];		
		
		for (int i=0;i<size;i++) {
			int num=sc.nextInt();
			arr[i] = num;  
		}
		
		//arr배열의 전체 누적합
		int[] sum_arr = new int[size+1];
		for (int i=0;i<size;i++) {
			sum_arr[i+1] += sum_arr[i] + arr[i];
		}
		int cnt=sc.nextInt();
		for (int i=0;i<cnt;i++) {
			//구간은 1부터 시작하는 것으로 설정
			int a=sc.nextInt();
			int b=sc.nextInt();
			//a에서 b까지의 누적합 구하기 
			System.out.println(sum_arr[b]-sum_arr[a-1]);
		}

	}

}
