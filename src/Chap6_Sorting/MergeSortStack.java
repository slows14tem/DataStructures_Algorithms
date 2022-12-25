package Chap6_Sorting;

public class MergeSortStack {

	static void merge(int[] a, int i, int j, int k, int l ) {
		//i=left, j=mid, k=mid+1, l=right
		int[] aux = new int[a.length];	//새로운 배열에 정렬된 값을 입력한 후 기존 배열에 덮어쓰는 방식
		int c = i;
		int left = i;	//변경되지 않은 i값을 보관
		
		//머지 프로세스
		while (i<=j || k<=l) {
            if (k>l || (i<=j && a[i]<a[k])) {
            	//k>l이면 k이후의 값은 모두 aux에 입력되었다는 것
            	//	뒤 조건과 상관없이 a[i++]값을 차례대로 입력(이미 a[i~j]는 정렬되어있기때문)
            	//k<l이면서 i<=j이라면 현재 입력중인 상황 
            	//	a[i]와 a[k] 비교해서 작은값 먼저 입력
            	//k<l이면서 i>j라면 a[i~j]값이 모두 aux에 입력되었다는 것.
            	//	a[k++]값을 차례대로 입력(이미 a[k~l]는 정렬)
                aux[c++] = a[i++];
            } else {
                aux[c++] = a[k++];
            }
        }
		
//		while(i<=j && k<=l) {
//			if (a[i]>a[k]) {
//				aux[c++] = a[k++];
//			}else if(a[i]<a[k]) {
//				aux[c++] = a[i++];
//			}else {	
//				aux[c++] = a[i++];
//				aux[c++] = a[k++];
//			}
//		}
//		while(i<=j) {
//			aux[c++]=a[i++];
//		}
//		while(k<=l) {
//			aux[c++]=a[k++];
//		}
		
		//기존 배열에 덮어 씀
		for (int idx = left; idx < c; idx++) {
            a[idx] = aux[idx];
        }
	}

	// --- 머지 정렬(재귀 버전)---//
	static void MergeSort(int[] a, int left, int right) {

		if (left == right) {	//배열이 그 length의 크기만큼 분해될때까지 재귀호출하기 위한 조건 
            return;
        }

		int mid = (left + right) / 2;
		MergeSort(a, left, mid);
		MergeSort(a, mid+1, right);
		merge(a, left, mid, mid+1, right);
	}

	public static void main(String[] args) {
		int nx = 10;
		int[] x = new int[nx];
		for (int ix = 0; ix < nx; ix++) {
			double d = Math.random();
			x[ix] = (int) (d * 20);
		}

		for (int i = 0; i < nx; i++)
			System.out.print(" " + x[i]);
		System.out.println();

		MergeSort(x, 0, nx - 1); // 배열 x를 퀵정렬

		System.out.println("오름차순으로 정렬했습니다.");
		for (int i = 0; i < nx; i++)
			System.out.print(" " + x[i]);
	}
}
