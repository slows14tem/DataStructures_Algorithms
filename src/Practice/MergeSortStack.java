package Practice;

public class MergeSortStack {
	// --- 배열 요소 a[idx1]와 a[idx2]의 값을 교환 ---//
	static void merge(int[] a, int lefta, int righta, int leftb, int rightb) {
		int[] t = new int[a.length]; // 작업용 배열
		int p = lefta; // p는 배열1의 시작 인덱스
		int q = leftb; // q는 배열2의 시작 인덱스
		int ix = lefta;
		int d = lefta;

		// 배열1의 첫값과 배열2의 첫값을 비교해서 작은 값을 t[]에 넣음
		while (p <= righta && q <= rightb) {
			if (a[p] <= a[q]) {
				t[ix++] = a[p++];
			} else {
				t[ix++] = a[q++];
			}
			// 앞쪽 포인터가 배열의 끝에서 남은 만큼을 최종 배열에 넣는다
			// for (int i = 0; i <= righta - p; i++) {
			// t[ix + i] = a[p + i];
			// }

		}
		while (p <= righta) {
			t[ix++] = a[p++];
		}
		while (q <= rightb) {
			t[ix++] = a[q++];
		}


		for (int idx = d; idx < ix; idx++) {
			a[idx] = t[idx];
		}
	}

	// --- 퀵 정렬(비재귀 버전) 이용---//
	static void MergeSort(int[] a, int left, int right) {
		// 부분 리스트 원소가 1개만 가지면 그만

		if (left < right) {
			int middle = (left + right) / 2;
			// 왼쪽으로 배열1 만들고, 정렬
			MergeSort(a, left, middle);
			// 오른쪽으로 배열2 만들고, 정렬
			MergeSort(a, middle + 1, right);
			// merge메소드(배열, 배열1의 시작점과 끝점, 배열2의 시작점과 끝점)
			merge(a, left, middle, (middle + 1), right);
		}
	}

	public static void main(String[] args) {
		int nx = 10;
		int[] x = new int[nx];
		for (int ix = 0; ix < nx; ix++) {
			double d = Math.random();
			x[ix] = (int) (d * 50);
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