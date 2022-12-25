package Chap3_java_datastructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

//import 자바자료구조.Fruit;

public class ComparableMethod {
	public static void main(String[] args) {
	    System.out.println("======스트링::");
	String[] s = { "참외", "딸기", "바나나" };
	//Sort (1)
//	Arrays.sort(s);
//	Arrays.sort(s, Comparator.reverseOrder()); 	//말그대로 역정렬
	
	//Sort (2)
	Arrays.sort(s, new Comparator<String>() {
		//new Comparator<T>() 는 익명객체(클래스 없이 오버라이딩 가능) - Comparator의 구현을 통해 compare 만 사용하고 싶은 것
		//comparable<T>은 클래스 안에서 오버라이딩하는 객체
		//둘다 객체를 비교할 수 있도록 만드는 것.
		//참고사이트 : https://st-lab.tistory.com/243
	    @Override
	    public int compare(String o1, String o2) {
	        return o2.compareTo(o1);            // 내림차순으로 정렬
//	        return o1.compareTo(o2);            // 오름차순으로 정렬
	    }
	});
	
	//Sort (3)
//	s = Arrays.stream(s).sorted().toArray(String[]::new);	//오름차순	
//	s = Arrays.stream(s).sorted(Collections.reverseOrder()).toArray(String[]::new);		//내림차순
	
    for ( String city: s)
    	System.out.print(" " + city);	
    System.out.println();
    
	//Sort (4)
//	Collections.sort(Arrays.asList(s));		
//	List<String> lst = Arrays.asList(s);	//배열 s의 주소를 lst에서 사용
//  for ( String city: lst)
//  	System.out.print(" " + city);
	


    System.out.println();
    System.out.println("======객체::");
    Fruit[] arr = {
	        new Fruit("사과", 200),
	        new Fruit("키위", 500),
	        new Fruit("오렌지", 200),
	        new Fruit("바나나", 50),
	        new Fruit("수박", 880),
	        new Fruit("체리", 10)
	};
    
	Arrays.sort(arr, new Comparator<Fruit>() {
	    @Override
	    public int compare(Fruit o1, Fruit o2) {
	    	return o1.compareTo(o2);            // 오름차순으로 정렬
//	        return o2.compareTo(o1);            // 내림차순으로 정렬
	    }
	});

    for ( Fruit city: arr)
    	System.out.print(" " + city);
    System.out.println();
    System.out.println("=====람다식::");
    Arrays.sort(arr, (a,b) -> a.compareTo(b)); 	//fruit 클래스의 compareTo를 활용한 람다식
//  Arrays.sort(arr, (a,b) -> a.getPrice() - b.getPrice()); 	//오름차순(가격별)
//  Arrays.sort(arr, (a,b) -> b.getPrice() - a.getPrice()); 	//내림차순
    
	//Arrays.sort(arr,(x,y)->x-y);
	//Fruit에 compareTo()가 있어도 람다식 우선 적용 (Arrays.sort(arr, (a,b) -> Fruit.compare(a,b)))???

    for ( Fruit city: arr)
    	System.out.print(" " + city);

	ArrayList<Fruit> lst1 = new ArrayList<Fruit>(Arrays.asList(arr));
	ArrayList<Fruit> lst2 = new ArrayList<Fruit>();
	lst2.add(new Fruit("복숭아", 200));
	lst2.add(new Fruit("포도", 300));
	lst2.add(new Fruit("참외", 100));
	lst2.add(new Fruit("딸기", 50));
	lst2.add(new Fruit("블루베리", 500));
	lst2.add(new Fruit("구지뽕", 300));
	System.out.println();
	System.out.println("새로운 리스트2::");
    for ( Fruit city: lst2)
    	System.out.print(" " + city);
//    Arrays.sort(lst2);
    Collections.sort(lst2);
	System.out.println();
	System.out.println("새로운 리스트2::");
    for ( Fruit city: lst2)
    	System.out.print(" " + city);
    
    ArrayList<Fruit> lst3 = new ArrayList<Fruit>();
	
	Iterator<Fruit> iter1 = lst1.iterator();
	Iterator<Fruit> iter2 = lst2.iterator();
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
    Fruit newFruit = new Fruit("참외", 100);
    Comparator<Fruit> cc = new Comparator<Fruit>() {
        public int compare(Fruit u1, Fruit u2) {
          return u1.compareTo(u2);
        }
    };	//익명객체로 선언한 cc 객체(Comparator 기능만 따로 두고싶을 때 사용)
      		//(클래스 이름으로 정의되지 않는 객체가 바로 익명 객체-상속할 대상이 반드시 있어야 한다)

    System.out.println();
  //binary search
    if(Collections.binarySearch(lst3, newFruit, cc)<0) System.out.println("조회결과 없음");
    else System.out.println("조회 결과 "+ newFruit);
	}
}
