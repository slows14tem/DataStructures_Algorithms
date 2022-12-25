package Chap10_Tree;
import java.util.Scanner;

class Student {
	  static final int NO   = 1;        // 번호를 읽어 들일까요?
	  static final int NAME = 2;        // 이름을 읽어 들일까요?

	  public Integer no;                      // 회원번호(키값)
	  public String  name;                    // 이름

	  //--- 키값 ---//
	  public Integer keyCode() {
	      return no;
	  }

	  //--- 문자열 표현을 반환 ---//
	  public String toString() {
	      return "(" + no + ")" + name;
	  }
	  public Student(Integer snum, String sname) {
	  	no = snum; name = sname;
	  }
	  public Student(Student s) {
	  	no = s.no; name = s.name;
	  }
	  public Student() {
	  	no = null; name = null;
	  }
}

//class TreeNode3 {
//	public TreeNode3 LeftChild;
//	public Student data;
//	public TreeNode3 RightChild;
//
//	public TreeNode3() {
//		LeftChild = RightChild = null;
//	}
//}

class Tree3 {
	class TreeNode3 {
		private TreeNode3 LeftChild;
		private Student data;
		private TreeNode3 RightChild;

		private TreeNode3() {
			LeftChild = RightChild = null;
		}

		public TreeNode3(Student data) {
			LeftChild = null;
			this.data = data;
			RightChild = null;
		}
		
	}
	private TreeNode3 root;

	Tree3() {
		root = null;
	}
	TreeNode3 InorderSucc(TreeNode3 current) {
		TreeNode3 temp = current.RightChild;
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

	void inorder(TreeNode3 CurrentNode) {
		if (CurrentNode != null) {
			inorder(CurrentNode.LeftChild);
			System.out.print(" " + CurrentNode.data);
			inorder(CurrentNode.RightChild);
		}
	}

	void preorder(TreeNode3 CurrentNode) {
		if (CurrentNode != null) {
			System.out.print(CurrentNode.data + " ");
			preorder(CurrentNode.LeftChild);
			preorder(CurrentNode.RightChild);
		}
	}

	void postorder(TreeNode3 CurrentNode) {
		if (CurrentNode != null) {
			postorder(CurrentNode.LeftChild);
			postorder(CurrentNode.RightChild);
			System.out.print(CurrentNode.data + " ");
		}
	}

	boolean Insert(Student input) {// binary search tree를 만드는 입력
		//root가 비었을 때
		if (root == null) {
			root = new TreeNode3(input);
			return true;
		} else {
			TreeNode3 p = root;
			TreeNode3 q = root;
			while(true) {
				if (p.data.no > input.no) {
					p=p.LeftChild;
					if (p==null) {
						q.LeftChild = new TreeNode3(input);
						return true;
					}
					q=q.LeftChild;
				} else if(p.data.no < input.no) {
					p=p.RightChild;
					if (p==null) {
						q.RightChild = new TreeNode3(input);
						return true;
					}
					q=q.RightChild;
				} else {
					return false;
				}
			}			
		}
	}

	boolean Delete(Integer x) {// binary search tree에서 x가 있으면 삭제하는 구현
		TreeNode3 p = root;	//삭제할 노드
		TreeNode3 q = null;	//삭제할 노드의 부모
		
		while(p.data.no != x) {
			q=p;
			if (p.data.no > x) {
				p=p.LeftChild;
			} else {
				p=p.RightChild;
			}
			if (p == null) {
				return false;
			}
		}
		//p의 자식이 없을 때
		if (p.LeftChild == null && p.RightChild == null) {
			if (p == root) {
				p=null;
			} else {
				if (p.data.no == q.LeftChild.data.no) {
					q.LeftChild = null;
				} else {
					q.RightChild = null;
				}
			}
			return true;
		}
		//p의 왼쪽자식만 있을 떄
		else if (p.RightChild == null) {
			//p가 root일떄
			if (p == root) {
				root = root.LeftChild;
				//부모노드를 설정하지 않았기 때문에 삭제노드가 부모노드의 왼쪽인지 오른쪽인지 판단해야함 
			} else if (p.data.no == q.LeftChild.data.no) {
				q.LeftChild = p.LeftChild;
			} else {
				q.RightChild = p.LeftChild;
			}
			return true;
		}
		//p의 오른쪽 자식만 있을 때
		else if (p.LeftChild == null) {
			//p가 root일떄
			if (p == root) {
				root = root.RightChild;
			} else if (p.data.no == q.LeftChild.data.no) {
				q.LeftChild = p.RightChild;
			} else {
				q.RightChild = p.RightChild;
			}
			return true;
		}
		//양쪽 자식 다 있을 때
		//inordersucc를 사용해서 삭제할 노드의 오른쪽 노드들 중 값이 가장 작은 값과 변경
		else {
			//삭제 대상 노드의 자식 노드 중에서 대체될 노드를 찾는다.
			TreeNode3 qtemp = p;	//후개자의 부모가 될 노드
			TreeNode3 ptemp = qtemp.RightChild;	//후개자 노드 (삭제 대상의 오른쪽 서브 트리 탐색 지정)
			while (ptemp.LeftChild != null) {	//가장 작은 값을 찾기 위해 왼쪽 자식 노드로 탐색한다.
                qtemp = ptemp;
                ptemp = ptemp.LeftChild;
            }
			if (ptemp != p.RightChild) {	//삭제하려는 노드의 오른쪽 자식이 자식노드가 있을 때
                qtemp.LeftChild = ptemp.RightChild;	//가장 작은 값을 선택하기 때문에 대체 노드의 왼쪽 자식은 빈 노드가 된다.
                ptemp.RightChild = p.RightChild;	//대체할 노드의 오른쪽 자식 노드를 삭제할 노드의 오른쪽으로 지정한다.(???)
            }
			if (p == root) {
                root = ptemp;
            } else if (p == q.RightChild) {
                q.RightChild = ptemp;
            } else {
                q.LeftChild = ptemp;
            }

            ptemp.LeftChild = p.LeftChild;	//삭제 대상 노드의 왼쪽 자식을 잇는다.
            return true;			
		}		
	}
}

public class Chap10_Test_BinaryTree_Objects {
	public static void main(String[] args) {
		Tree3 t = new Tree3();
		Scanner stdIn = new Scanner(System.in);
		int select = 0;
		while (select != 6) {
			System.out.println(
					"BinarySearchTree. Select 1:Insert, 2. Delete, 3:preorder, 4:postorder, 5. inorder, 6. Quit =>");

			select = stdIn.nextInt();
			switch (select) {
			case 1:
				System.out.println("The number of items = ");

				int nx = stdIn.nextInt();
				Student[] input = new Student[nx];
				for (int ix = 0; ix < nx; ix++) {
					System.out.println("no = ");
					Integer snum = stdIn.nextInt();
					System.out.println("name = ");
					String sname = stdIn.next();
					input[ix] = new Student(snum, sname); 
					//추가 코딩
				}
				for (int i = 0; i < nx; i++) {
					if ((t.Insert(input[i])) == false)
						System.out.println("Insert Duplicated data");
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
