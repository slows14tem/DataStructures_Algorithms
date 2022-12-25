package Chap10_Tree;

import java.util.Scanner;

//이진트리 조건
//1. 노드 N을 기준으로 왼쪽 서브트리 노드의 모든 키값은 노드 N의 값보다 작음
//2. 오른쪽 서브트리 노드의 키값은 노드 N의 키값보다 큼
//https://st-lab.tistory.com/300
class TreeNode {
	public int data;
	public TreeNode LeftChild;
	public TreeNode RightChild;

	public TreeNode() {
		//노드 생성
		LeftChild = RightChild = null;
	}

	public TreeNode(int data) {
		this.data = data;
		LeftChild = null;		
		RightChild = null;
	}	
}

class Tree {
	private TreeNode root;

	Tree() {
		//트리 생성
		root = null;
		//노드가 하나도 없는 비어있는 이진트리 생성
	};

	TreeNode InorderSucc(TreeNode current) {
		//current노드보다 큰 값중에 가장 작은 값을 검색
		TreeNode temp = current.RightChild;
		if (current.RightChild != null)
			while (temp.LeftChild != null)
				temp = temp.LeftChild;
		return temp;
	}

	void inorder() {
		inorder(root);
	}

	void preorder() {
		preorder(root);
	}

	void postorder() {
		postorder(root);
	}

	void inorder(TreeNode CurrentNode) {
		if (CurrentNode != null) {
			inorder(CurrentNode.LeftChild);
			System.out.print(" " + CurrentNode.data);
			inorder(CurrentNode.RightChild);
		}
	}

	void preorder(TreeNode CurrentNode) {
		if (CurrentNode != null) {
			System.out.print(CurrentNode.data + " ");
			preorder(CurrentNode.LeftChild);
			preorder(CurrentNode.RightChild);
		}
	}

	void postorder(TreeNode CurrentNode) {
		if (CurrentNode != null) {
			postorder(CurrentNode.LeftChild);
			postorder(CurrentNode.RightChild);
			System.out.print(CurrentNode.data + " ");
		}
	}

	boolean Insert(int x) {// binary search tree를 만드는 입력
		//root가 비었을 때
		if (root == null) {
			root = new TreeNode(x);
			return true;
		} else {
			TreeNode p = root;	//
			TreeNode q = null;
			while(true) {
				q=p;
				if (p.data > x) {
					p = p.LeftChild;
					if (p == null) {
						q.LeftChild = new TreeNode(x);
						return true;
					}
				} else {
					p = p.RightChild;
					if (p == null) {
						q.RightChild=new TreeNode(x);
						return true;
					}
				}
			}	//렌덤 숫자가 겹치지 않게 했기 때문에 같은 경우를 고려할 필요 없어짐
		}	
	}

	boolean Delete(int x) {// binary search tree에서 x가 있으면 삭제하는 구현
		//tree가 비었을 때
		if (root == null) return false;
		//x 값을 검색
		TreeNode p = root;	//삭제할 노드
		TreeNode q = root;	//삭제할 노드의 부모
		boolean flag = true;	//방향 구분
		while(true) {
			if (p.data > x) {
				q=p;
				p=p.LeftChild;
				flag = true;
			} else if (p.data <x) {
				q=p;
				p=p.RightChild;
				flag = false;
			} else {
				//p=삭제되어야하는 노드
				//자식노드가 없는 경우
				if (p.LeftChild == null && p.RightChild == null) {
					if (flag) q.LeftChild = null;
					else q.RightChild = null;
					return true;
				}
				//자식노드가 두개인 경우
				//1. 삭제된 노드의 오른쪽 자식 노드에서 제일 작은 노드로 대체하는 방법
				//2. 삭제된 노드의 왼쪽 자식 노드에서 제일 큰 노드로 대체하는 방법 - 선택
				else if (p.LeftChild != null && p.RightChild != null) {
					q=p;	//q = 삭제할 노드
					p=p.LeftChild;	//삭제할 노드의 위치에 대체될 후계자 노드
					TreeNode temp = p;	//후계자 노드의 부모
					while(p.RightChild != null) {
						temp = p;
						p=p.RightChild;
					}
					
					q.data = p.data;	//삭제할 노드에 후계자 노드의 값을 삽입
					if (p.LeftChild != null) {	//후계자노드가 왼쪽 자식을 가지고 있을 경우
						if (p == temp) {	//삭제할 노드(q)의 왼쪽 노드들 중 가장 큰값이 q.leftChild일때  
							q.LeftChild = p.LeftChild;
						}else {
							//p = p.LeftChild;
							temp.RightChild = p.LeftChild;
						}
					} else {
						if (p == temp) {
							q.LeftChild = null;
						} else {
							temp.RightChild = null;
						}
					}
					
					return true;
				}
				//자식노드가 하나인 경우
				else {
					//p의 좌우 어느쪽 자식이 남았는지 판단
					if (p.LeftChild != null) {
						p = p.LeftChild;
					} else if(p.RightChild != null) {
						p = p.RightChild;
					}

					if (flag) q.LeftChild = p;
					else q.RightChild = p;
					return true;
				}
			}
		}
	}
}

public class BinaryTree {
	
	private static boolean exists(int n[], int index) {
        for (int i = 0; i < n.length; i++) {
            if(n[i] == index)
                return true;
        }
        return false;
    }
	
	public static void main(String[] args) {
		Tree t = new Tree();
		Scanner stdIn = new Scanner(System.in);
		int select = 0;
		int d = 0;
		while (select != 6) {
			System.out.println(
					"BinarySearchTree. Select 1:Insert, 2. Delete, 3:preorder, 4:postorder, 5. inorder, 6. Quit =>");

			select = stdIn.nextInt();
			switch (select) {
			case 1:
				System.out.println("The number of items = ");

				int in = stdIn.nextInt();
				int[] input = new int[in];
				//겹치지 않는 렌덤 숫자가 배열 안에 들어갈 수 있게 함
				for (int ix = 0; ix < in; ix++) {
					do {
						d = (int) (Math.random()* 20);
					}while(exists(input, d));					
					input[ix] = d;
				}
				for (int id=0; id<in;id++) {
					System.out.print(" "+ input[id]);					
				}
				System.out.println();
				
//				int[] input = {16,17,11,7,6};
//				for (int i = 0; i < input.length; i++) {
					
				for (int i = 0; i < in; i++) {
					if (t.Insert(input[i]) == false)
						System.out.println("Insert Duplicated data");
					else
						System.out.println("Insert data");					
				}
				break;
			case 2:
				int out = stdIn.nextInt();
				
				if (t.Delete(out) == false)
					System.out.println("Delete Fail");
				else
					System.out.println("Delete Success");
				break;
			case 3:
				t.preorder();
				System.out.println();
				break;
			case 4:
				t.postorder();
				System.out.println();
				break;
			case 5:
				t.inorder();
				System.out.println();
				break;
			case 6:
				System.out.println("Quit");
				break;

			default:
				System.out.println("WRONG INPUT  ");
				System.out.println("Re-Enter");
				break;
			}
		}
	}
}
