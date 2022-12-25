package Chap5_backtracking;

public class Backtracking_Queen {
	//첫번쨰 정답만 체스판으로 출력
	public static void SolveQueen(int[][] d) {

		int count = 0;	//스택 카운트
		int ix = 0, iy = 0;	//x,y좌표
		Stack2 st = new Stack2(d.length);
		Point p = new Point(ix, iy);
		//최초 0,0에 퀸 놓기
		d[ix][iy] = 1;
		st.push(p);
		count++;
		while (count < d.length) {
			iy++;	//다음 row로 이동
			while (iy < d.length){
				while (ix < d[0].length) {
					if (CheckMove(d, ix, iy)) {
						//checkMove=true 일때 퀸 놓기+스택 push
						p = new Point(ix, iy);
						d[ix][iy] = 1;
						st.push(p);
						count++;
						break;	
					}
					//checkMove=false일때 ix를 한칸 이동(true가 나올때까지)
					ix++;	
				}
				if (ix != d[0].length) {
					//checkMove=true일때 ix를 초기화(다음 행으로 이동해서 ix=0부터 checkMove하기 위해서)
					ix=0;
					break;
				} else {
					//한 row 모두 checkMove=false일때 스택 pop+퀸 제거+제거된 퀸의 한칸 오른쪽으로 ix변경 ->
					//(퀸이 있던 자리의 오른쪽 자리부터 검사하기 위해서)
					p = st.pop();
					count--;
					ix=p.getX();
					iy=p.getY();
					d[ix][iy] = 0;
					ix++;
				}				
			}
		}
	}

	//행 체크(행에는 놓인 퀸이 없기때문에 의미없음)
	public static boolean checkRow(int[][] d, int y) {
		for (int i = 0; i < d.length; i++)
	        if (d[i][y]==1)
	            return false;	  
		return true;
	}

	//열 체크
	public static boolean checkCol(int[][] d, int x) {
		for (int i = 0; i < d[0].length; i++)
	        if (d[x][i]==1)
	            return false;	
		return true;
	}
	
	//남서 대각선 체크
	//현재 포인트가 가장 아랫쪽에 놓인 퀸이기 때문에 포인트보다 아래쪽은 검사할 필요 없음
	public static boolean checkDiagSW(int[][] d, int cx, int cy) {
		//x++, y-- or x--, y++ where 0<= x,y <= 7
		while(true) {
			cx++;
			cy--;
			if (cx>=d.length || cy<0) {
				return true;
			}
			if (d[cx][cy]==1) {
				return false;
			}
		}
	}

	//남동 대각선 체크
	public static boolean checkDiagSE(int[][] d, int cx, int cy) {
		//x++, y++ or x--, y--
		while(true) {
			cx--;
			cy--;
			if (cx<0 || cy<0) {
				return true;
			}
			if (d[cx][cy]==1) {
				return false;
			}
		}
	}
	
    public static boolean CheckMove(int[][]d, int x, int y) {
    	//(x,y)로 이동 가능한지를 check
    	if(checkRow(d, y) && checkCol(d, x) && checkDiagSW(d,x,y) && checkDiagSE(d,x,y)) {
    		return true;
    	}
    	return false;    	 	
    }

	public static void main(String[] args) {
		int row = 8, col = 8;
		int[][] data = new int[row][col];
		for (int i = 0; i < data.length; i++)
			for (int j = 0; j < data[0].length; j++)
				data[i][j] = 0;

		SolveQueen(data);

		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[0].length; j++) {
				System.out.print(" " + data[i][j]);
			}
			System.out.println();
		}
	}
}
