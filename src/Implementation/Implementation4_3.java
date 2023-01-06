package Implementation;

import java.util.Scanner;

public class Implementation4_3 {
	
	public static boolean check(int x, int y) {
		//하나라도 범위에서 벗어나면 false
		if (x<=0 || y<=0 || x>8 || y>8) return false;
		return true;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] mx = {1, 2, 2, 1, -1, -2, -2, -1};
		int[] my = {-2, 1, -1, 2, 2, -1, 1, -2};
		String N = sc.next();
		String[] str = N.split("");
		int x = str[0].charAt(0)-96;		
		int y = (int)str[1].charAt(0)-48;
		//int row = inputData.charAt(1) - '0';
        //int column = inputData.charAt(0) - 'a' + 1;
		int cnt=0;
		
		for (int i=0;i<mx.length;i++) {
			int newx = x+mx[i];
			int newy = y+my[i];
			if (check(newx, newy)) cnt++;
		}
		System.out.println(cnt);
	}

}

//알고리즘보다 문자열을 입력받아 원하는 방식으로 가공하는 데 더 시간걸림.
//알고리즘 문제를 더 잘 풀기 위해서는 문자열 가공에 익숙해야할듯

