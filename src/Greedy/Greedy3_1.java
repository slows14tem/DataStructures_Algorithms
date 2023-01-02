package Greedy;

import java.util.Scanner;

//이것이 코딩테스트다 예제 3-1(거슬러 줘야할 동전의 최소 개수)
public class Greedy3_1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] coin = {500, 100, 50, 10};
		int[] cnt = new int[coin.length];
		
		for (int i=0;i<coin.length;i++) {			
			cnt[i] = N/coin[i];
			N %= coin[i];
		}
		for (Integer n:cnt) {
			System.out.println(n);
		}

	}

}

//이 문제는 가지고 있는 동전 중애서 큰 단위가 항상 작은 단위의 배수이므로 작은 단위의 동전들을 종합해 다른 해가 나올 수 없다.
//그래서 가장 큰 단위부터 가장 작은 단위순으로 차례대로 확인하여 거슬러 주는 작업만 수행한다는 아이디어는 정당하다.
//하지만 예를 들어 거슬러 줘야하는 돈이 800인데 coin이 {500, 400, 100}이라면 이 알고리즘에서는 500원 1개, 100원 3개를 출력하지만 최적의 해는 400원 2개를 주는 것이다.
//때문에 그리디 알고리즘 문제는 문제풀이를 위한 최소한의 아이디어를 떠올리고 이것이 정당한지 검토할 수 있어야 답을 도출할 수 있다.