package Chap6_Sorting;

public class HeapSortRevised {

	//HeapSort 교과서 버전
 //--- 배열 요소 a[idx1]와 a[idx2]의 값을 교환 ---//
 static void swap(int[] a, int idx1, int idx2) {
     int t = a[idx1];  
     a[idx1] = a[idx2];  
     a[idx2] = t;
 }

 static void makeHeap(int []a, int left, int right) {
	 int temp = a[left];
	 int child;
	 int parent;
	 
	 for (parent = left; parent < (right+1)/2; parent = child) {
		 int cl = parent *2+1;
		 int cr = cl+1;
		 
		 child = (cr<= right && a[cr]>a[cl]) ?cr:cl;
		 if (temp >= a[child]) break;
		 a[parent] = a[child];
	 }
	 a[parent] = temp;
 }

 //--- 힙 정렬 ---//
 static void heapSort(int[] a, int n) {
	 //int[] b = new int[n];
	 for (int ix = (n-1)/2; ix >= 0; ix--)
		 makeHeap(a, ix, n-1);
	 System.out.println();
	 for (int ix = 0; ix < a.length; ix ++) {
    	 System.out.print(a[ix] + " ");
     }
     System.out.println();
	 for (int i = n-1; i>0; i--) {
		 swap(a, 0, i);
		 makeHeap(a, 0, i-1);
	 }
     System.out.println();
     System.out.println("makeHeap:");
     

 }

 public static void main(String[] args) {

	 final int count = 10;
     int[] x = new int[count];

     for (int i = 0; i < count; i++) {
         x[i] = (int)(Math.random() * 20);
     }
     System.out.println("정렬전:");
     for (int i = 0; i < count; i++)
         System.out.print(" " + x[i]);
     heapSort(x, count);    // 배열 x를 힙정렬
     System.out.println();
     System.out.println("정렬후: ");
     for (int i = 0; i < count; i++)
         System.out.print(" " + x[i]);
 }
}
