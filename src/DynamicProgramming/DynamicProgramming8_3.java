package DynamicProgramming;

import java.util.Scanner;

public class DynamicProgramming8_3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] d = new int[N];
		d[0] = 1;
		d[1] = 3;
		
		for (int i=2;i<N;i++) {
			d[i] = d[i-1] + d[i-2]*2;
		}
		System.out.println(d[N-1]%796796);

	}

}
