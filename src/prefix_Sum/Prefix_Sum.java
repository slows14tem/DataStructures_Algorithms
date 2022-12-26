package prefix_Sum;

public class Prefix_Sum {
	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		int[] arr2 = { 1, 5, 8, 10, 24, 3, 5, 100, 99, 7 };
//		int a = sc.nextInt();
//		int b = sc.nextInt();		

		// 전구간 누적 합 구하기
		// 배열의 크기를 + 1하는 이유는, 0번 인덱스 ~ n번 인덱스의 구간합도 구할 수 있게 만들기 위함이다.
		int[] prefix_sum = new int[11];
		int[] prefix_sum2 = new int[11];
		for (int i = 0; i < arr.length; i++) {
			prefix_sum[i+1] += prefix_sum[i] + arr[i];
			prefix_sum2[i+1] += prefix_sum2[i] + arr2[i];
		}
		
		// 구간 합 구하기
		int a = 7;
		int b = 9;
		System.out.println(prefix_sum[b+1] - prefix_sum[a]);
		System.out.println(prefix_sum2[b+1] - prefix_sum2[a]);
//		sc.close();
	}
}

//https://sskl660.tistory.com/77
//https://yiyj1030.tistory.com/489