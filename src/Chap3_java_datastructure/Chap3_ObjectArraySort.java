package Chap3_java_datastructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

//class StrComp implements Comparator<Fruit> {
//	@Override
//	public int compare(Fruit o1, Fruit o2) {
//		if (o1.compareTo(o2)<0) {	//Fruit class에서 오버라이딩된 compareTo를 사용하는 것
//			return -1;
//		 }  else if (o1.compareTo(o2)>0) {
//			 return 1;
//		 } else {
//			 return 0;
//		 }	
//	}
//}

public class Chap3_ObjectArraySort {
	public static void main(String[] args) {
//	String[] s = { "sort", "string", "array" };
//	Arrays.sort(s);
//	Arrays.sort(s, Comparator.naturalOrder());
//	Arrays.sort(s, Comparator.reverseOrder());
//	
//	Arrays.sort(s, new Comparator<String>() {
		//comparator 인터페이스의 compare함수 오버라이딩하여 정렬
//	    @Override
//	    public int compare(String o1, String o2) {
//	        return o2.compareTo(o1);            // 내림차순으로 정렬
//	    }
//	});
	//stream으로 정렬 구현
//	s = Arrays.stream(s).sorted().toArray(String[]::new);	
//	s = Arrays.stream(s).sorted(Collections.reverseOrder()).toArray(String[]::new);
//	Collections.sort(Arrays.asList(s));
	
	//객체 정렬
	Fruit[] arr = {
	        new Fruit("사과", 200),
	        new Fruit("키위", 500),
	        new Fruit("오렌지", 200),	        
	        new Fruit("바나나", 50),
	        new Fruit("바나나", 880),
	        new Fruit("체리", 10)
	};
	
    System.out.println();
    System.out.println("정렬전::");
    for ( Fruit city: arr)
    	System.out.print(" " + city);
	
	//배열 정렬
	Arrays.sort(arr);
	
	//for문으로 정렬 구현
//	for(int i=0;i<arr.length;i++) {
//		for(int j=i+1;j<arr.length;j++) {
//			if((arr[i].getName().compareTo(arr[j].getName()))>1) {
//    			Fruit temp = arr[j];
//    			arr[j] = arr[i];
//    			arr[i] = temp;
//    		}
//			else if((arr[i].getName().compareTo(arr[j].getName()))==0){
//				if(arr[i].getPrice() > arr[j].getPrice()) {
//					Fruit temp = arr[j];
//	    			arr[j] = arr[i];
//	    			arr[i] = temp;
//				}
//			}
//		}
//	}
//    Collections.sort(arr); -- 안먹힘

//구현 - 정렬
    System.out.println();
    System.out.println("정렬후::");
    for ( Fruit city: arr)
    	System.out.print(" " + city);

	ArrayList<Fruit> lst1 = new ArrayList<Fruit>(Arrays.asList(arr));
	ArrayList<Fruit> lst2 = new ArrayList<Fruit>();
	lst2.add(new Fruit("복숭아", 200));
	lst2.add(new Fruit("포도", 100));
	lst2.add(new Fruit("포도", 300));
	lst2.add(new Fruit("딸기", 50));
	lst2.add(new Fruit("블루베리", 500));
	lst2.add(new Fruit("구지뽕", 300));
//	System.out.println();
//	System.out.println("새로운 리스트2::");
//    for ( Fruit city: lst2)
//    	System.out.print(" " + city);

	//List 정렬
    Collections.sort(lst2);
    
    //for문으로 구현
//    for(int i=0;i<lst2.size();i++) {
//		for(int j=i+1;j<lst2.size();j++) {
//			if((lst2.get(i).getName().compareTo(lst2.get(j).getName()))>1) {
//				Fruit temp = lst2.get(j);
//    			lst2.set(j, lst2.get(i));
//    			lst2.set(i, temp);
//			}
//			else if((lst2.get(i).getName().compareTo(lst2.get(j).getName()))==0) {
//				if(lst2.get(i).getPrice() > lst2.get(j).getPrice()) {
//					Fruit temp = lst2.get(j);
//	    			lst2.set(j, lst2.get(i));
//	    			lst2.set(i, temp);
//				
//		    	}
//		    }
//		}
//	}
    
	System.out.println();
	System.out.println("새로운 리스트2::");
    for ( Fruit city: lst2)
    	System.out.print(" " + city);
    
    ArrayList<Fruit> lst3 = new ArrayList<Fruit>();
	
	Iterator<Fruit> iter1 = lst1.iterator();
	Iterator<Fruit> iter2 = lst2.iterator();
	//Iterator == 컬렉션에 저장된 모든 데이터를 순차적으로 접근하여 사용하기 위한 객체(컬렉션 뷰)
	//컬렉션에 저장된 데이터의 위치정보를 포함한 커서가 존재해서 인덱스등이 없어도 쉽게 데이터에 접근 가능
	//첫 커서는 가장 위 데이터의 위칸(null을 가리킴)에 위치하기 때문에 next, hasNext 한번 해줘야 함
	
//구현-  iterator 사용한 merge
	
	Fruit v1 = iter1.next();
	Fruit v2 = iter2.next();
	while (iter1.hasNext() && iter2.hasNext()) {
        if ((v1.compareTo(v2)<0)) {
            lst3.add(v1);
            v1 = iter1.next();  
            if(!iter1.hasNext()) {
        		lst3.add(v1);
    	    }
        } 
        else if((v1.compareTo(v2)>0)) {
        	lst3.add(v2);
        	v2 = iter2.next();   
        	if(!iter2.hasNext()) {
        		lst3.add(v2);
        	}
        }
        else if((v1.compareTo(v2)==0)) {
            lst3.add(v2);
            v1 = iter1.next();
            v2 = iter2.next();		            	
        }
        		           
    }		    
    if(!iter1.hasNext() && !iter2.hasNext()) {
		lst3.add(v1);
		lst3.add(v2);
    }    
    while (iter1.hasNext()) {
        lst3.add(v1);
        v1 = iter1.next();
        if(!iter1.hasNext()) {
    		lst3.add(v1);
	    }
    }    
    while (iter2.hasNext()) {
        lst3.add(v2);
        v2 = iter2.next();
        if(!iter2.hasNext()) {
    		lst3.add(v2);
    	}
    }
    
	System.out.println();
    System.out.println("merge:: ");
    for ( Fruit city: lst3)
    	System.out.print(city+ " ");

    
    Fruit newFruit = new Fruit("바나나", 50);
    System.out.println();
    System.out.println(newFruit);
    //binary search - Comparator를 사용한 구현
    Comparator<Fruit> cc= new Comparator<Fruit>() {
    	//new Comparator<T>() 는 익명객체(클래스 없이 오버라이딩 가능) - Comparator의 구현을 통해 compare 만 사용하고 싶은 것
		//comparable<T>은 클래스 안에서 오버라이딩하는 객체
		//둘다 객체를 비교할 수 있도록 만드는 것.
    	@Override
    	public int compare(Fruit o1, Fruit o2) {
    		return o1.compareTo(o2);
    	}
    }; //정렬과 탐색의 기준
    
//    Collections.sort(lst3, cc); //lst3 은 이미 정렬되어 있음

    System.out.println();
    if (Collections.binarySearch(lst3, newFruit, cc) < 0)
    	//Collections.binarySearch==list에서 key를 찾아 그 인덱스 값 반환 못찾으면 음의 정수 반환
		System.out.println("조회결과 없다");
    else System.out.println("조회 결과 "+ newFruit);
    //참고 사이트 : https://m.blog.naver.com/PostView.naver?isHttpsRedirect=true&blogId=hongyou022&logNo=221521885248
	}
}
