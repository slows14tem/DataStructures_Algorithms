package prefix_Sum;

public class Prefix_Sum_Array {
	
	public static void main(String[] args) {
		int[][] arr = new int[][] {{1,2,3,4}, {2,3,4,5}, {3,4,5,6}};
		int n = 3;
		int m = 4;
		
		int[][]sum_arr = new int[n+1][m+1];
		
		//전구간 누적합 구하기
		for (int i=1;i<n+1;i++) {
			for (int j=1;j<m+1;j++) {
				sum_arr[i][j] = arr[i-1][j-1] + sum_arr[i-1][j] + sum_arr[i][j-1] - sum_arr[i-1][j-1];
			}
		}
		
		//전구간 누적합 출력
//		System.out.println("sum_arr");
//		for(int i=0;i<n+1;i++) {
//			for (int j=0;j<m+1;j++) {
//				System.out.print(sum_arr[i][j]+" ");
//			}
//			System.out.println();
//		}
		
		//구간합 구하기
		//arr의 (1,1)~(3,2)까지의 구간합
		int x1 = 1;
		int y1 = 1;
		int x2 = 2;
		int y2 = 2;
		
		int SumArr = sum_arr[x2+1][y2+1] - sum_arr[x1][y2+1] - sum_arr[x2+1][y1] + sum_arr[x1][y1];
		System.out.println(SumArr);
	}
}

//https://yiyj1030.tistory.com/489
