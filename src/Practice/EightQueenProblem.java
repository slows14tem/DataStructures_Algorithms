package Practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Points implements Comparable<Points> {
	private int x;
	private int y;
	
	public Points(int x, int y) {
		this.x=x;
		this.y=y;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public String toString() {
		return "{" + x + ", " + y + "}";
	}
	@Override
	public int compareTo(Points o) {
		if (this.x < o.x) return -1;
		else if (this.x > o.x) return 1;
		else {
			if (this.y<o.y) return -1;
			else if (this.y>o.y) return 1;
			else return 0;
		}	
	}
}

public class EightQueenProblem {
	
	public static ArrayList<Points> impossiblePoint(ArrayList<Points> list, int size){
//		불가능 좌표 검색
		//스택의 모든값에 대해서 검색해서 넣고 중복제거해야함
		ArrayList<Points> arr = new ArrayList<Points>();
		for(int a=0;a<list.size();a++) {
			Points p = list.get(a);
			int x = p.getX();
			int y = p.getY();
			
			for(int j=y+1;j<size;j++) {	//세로줄 불가능좌표
				arr.add(new Points(x, j));
			}
			for(int k=1;x-k>=0;k++) {	//왼쪽 대각선 불가능 좌표
				arr.add(new Points(x-k, y+k));			
			}
			for(int l=1;x+l<size;l++) {	//오른쪽 대각선 불가능 좌표
				arr.add(new Points(x+l, y+l));
			}			
		}

		Collections.sort(arr);
		
		//중복제거
		ArrayList<Points> list2 = new ArrayList<Points>();
	    for(Points item: arr) {
	    	if(!list2.contains(item)) {
	    		list2.add(item);
	    	}
	    }	   		
		return list2;
	}
	
	//스택 클래스를 만들어서 push, pop 등 활용해야함
	public static void main(String[] args) {
		int size = 8;	//판 크기
		int top = 0;	//스택 최상단
		ArrayList<Points> stack = new ArrayList<Points>();	//스택용 list		
		stack.add(new Points(0, 0));	//최초 0,0 push
		top++; 

		Points p = stack.get(top-1);		
		int x = p.getX();
		int y = p.getY();
		//첫 스택의 (x,y)좌표

		Comparator<Points> cc= new Comparator<Points>() {	//binarySearch하기위한 comparator
			@Override
			public int compare(Points o1, Points o2) {
				return o1.compareTo(o2);
			}
	    };
	    
	    int cnt = 0;	//정답 갯수 카운트
	    for(int i=0;i<size;i=top) {	    	//스택에 z의 값이 저장될떄까지 반복
			for(int j=x;j<=size;j++) {
				
				Points newPoints = new Points(j, y+1);
				//키값 : 스택에 입력된 값의 다음줄(x값은 기존 입력된 스택값의 +1부터 시작이거나 기존 스택이 없을떄는 0부터 시작)
				ArrayList<Points> arr = impossiblePoint(stack, size);	//불가능 좌표값
				if (Collections.binarySearch(arr, newPoints, cc) < 0 && x<size) {
					//키값이 불가능좌표 값이 아니면서 x값이 체스판 범위를 넘지 않았을 때 키값좌표를 스택에 push
					stack.add(newPoints);	//스택 push
					top=top+1;	//스택 최상단 +1					
					if (top==size) {	//스택에 값이 다 쌓였다면 정답 하나가 완성되었다고 판단. 
						//정답 print------
						for(Points pr : stack) {
							System.out.print(" "+pr);
						}
						System.out.println();
						cnt++;
						System.out.println(cnt);
						//------
						Points pu = stack.get(top-1);
						x = pu.getX()+1;	//스택값의 바로 오른쪽 값부터 시작하기 위해서 +1
						y = pu.getY()-1;	//y값이 최초 0부터 시작하기 때문에 +1을 하고 시작했는데 그것을 맞추기 위해서 -1한뒤 +1을 해서 추출한 스택의 y값을 가지게 하려고
						//마지막 스택값의 x,y값을 저장
						stack.remove(top-1);	//저장 후 스택 pop
						top=top-1;	//스택 최상단 -1
						break;
					}
					x=0; y++;	//다음줄의 첫번째 좌표부터 검색하기 위해 x,y값 조정
					break;
				} else {	//한 줄이 전부 불가능좌표일때는 전 스택값을 저장한 후 스택 pop 시킴,
					
					if (j>=size-1) {	//x값이 size-1 이상일떄 한줄 전체가 불가능좌표라고 판단
						if (top==0) {
							return;
						}
						Points pu = stack.get(top-1);
						x = pu.getX()+1;
						y = pu.getY()-1;
						//마지막 스택값의 x,y값을 저장
						stack.remove(top-1);	//저장 후 스택 pop
						top=top-1;	//스택 최상단 -1
						break;
					}
				}
			}
	    }
	}
}
