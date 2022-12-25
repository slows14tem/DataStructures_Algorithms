package Chap6_Sorting;

public class HeapSort{
	
	private static int delete(int[] arr, int len) {
		// TODO Auto-generated method stub
		int i, j, k, x, n;
		x = arr[0];
		n= len;
		k = arr[n];
		for(i=0,j=1; j<=n;) {
			if (j<n) if (arr[j] < arr[j+1]) j++;	//자식들 중 더 큰값의 자식을 찾음
			if (k>=arr[j]) break;
			arr[i] = arr[j];
			i=j;
			j=(j*2)+1;
		}
		arr[i] = k;
		return x;
	}
	
	private static void insert(int[] arr, int ptr, int nx) {
		//새로운 값 nx와 그 부모자리의 값을 비교해서 부모가 값이 작으면 자리를 변경하는 방식
		int i;
		for (i=ptr;i>=0;i=(i-1)/2) {
			if (i==0) break;
			if (nx<=arr[(i-1)/2]) break;
//			if (nx>=arr[(i-1)/2]) break;
//			부모가 자식값보다 작게 정렬. (처음부터 오름차순으로 배열 가능)
			arr[i] = arr[(i-1)/2];
		}
		arr[i]=nx;
	}
	
	public static void main(String[] args) {
				
		int len = 10;
		int[] x = new int[len];
		for (int ix = 0; ix < len; ix++) {
			double d = Math.random();
			x[ix] = (int) (d * 20);
		}
		
		System.out.print("랜덤 배열 입력: ");
		System.out.println();
		for (int i = 0; i < len; i++)
			System.out.print(" " + x[i]);
		System.out.println();
		
		int[] arr = new int[len];
		int ptr=0;

		for (int i=0;i<arr.length;i++) {
			//랜덤배열 0번부터 하나씩 arr배열에 입력하는 동시에 Heap으로 만듬 
			int nx = x[i];
			arr[ptr] = nx;
			insert(arr, ptr, nx);
			ptr++;
		}

		System.out.println("Heap 배열 출력");
		for (int i = 0; i < arr.length; i++)
	        System.out.print(" " + arr[i]);
	    System.out.println();
	    
	    int leng = arr.length;
	    int[] arrR = new int[arr.length];
	    for (int j=0;j<arr.length;j++) {
	    	arrR[j] = delete(arr, --leng);
	    }
	    
	    System.out.println("Heap 정렬 완료");
		for (int i = 0; i < arrR.length; i++)
	        System.out.print(" " + arrR[i]);
	    System.out.println();
	}

	
}

