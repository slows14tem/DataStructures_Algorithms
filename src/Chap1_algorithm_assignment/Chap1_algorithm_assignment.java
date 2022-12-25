package Chap1_algorithm_assignment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//import java.util.Collections;
//string 정렬, binary search 구현
//1단계: string, 2단계: string 객체,  Person 객체들의 list\
public class Chap1_algorithm_assignment {
    public static String[] removeElement1(String[] arr, String item) {
        List<String> list = new ArrayList<>(Arrays.asList(arr));
        list.remove(item);
        return list.toArray(String[]::new);
    }
	public static void main(String[] args) {
		
		ArrayList<String> list = new ArrayList<String>();
		list.add("서울");
		list.add("북경");
		list.add("상해");
		list.add("서울");
		list.add("도쿄");
		list.add("뉴욕");

		list.add("런던");
		list.add("로마");
		list.add("방콕");
		list.add("북경");
		list.add("도쿄");
		list.add("서울");

		list.add(1, "LA");
		
		//sort - 오름차순으로 정렬, 내림차순으로 정렬, 중복 제거하는 코딩
		System.out.println("collection.sort()::");
//	    Collections.sort(list); //collection을 활용한 정렬
//	    for ( String city: list)
//	    	System.out.println(city);
	    
	    String cities[] = new String[0];
	    cities = list.toArray(cities); // list -> 배열(array)

	    //반복문을 활용한 정렬
	    for(int i=0;i<cities.length;i++) {
	    	for(int j=i+1;j<cities.length;j++) {
	    		if((cities[i].compareTo(cities[j]))>1) {
	    			String temp = cities[j];
	    			cities[j] = cities[i];
	    			cities[i] = temp;
	    		}
	    	}
	    }
	    
	    System.out.println("정렬후::");
	    for ( String city: cities)
	    	System.out.print(city + " ");
	    System.out.println();
	    
	    //중복제거
	    System.out.println("중복제거::");
	    
	    int cnt = cities.length;
	    //removeElement1 메소드 사용
	    for(int i=0;i<cnt;i++) {
	    	int j=i+1;
	    	while(j<cnt){
	    		if((cities[i].compareTo(cities[j]))==0) {
	    			//비교해서 같으면 0 리턴
	    			cities = removeElement1(cities, cities[i]);
	    			cnt--;
	    		}
	    		else j++;
	    	}
	    }

	    for ( String city: cities)
	    	System.out.print(city + " ");
	    
	    //다양한 중복제거 방법
	    
	    //1번(중복값을 ""으로 변경한 후 제거하기)
//	    for(int i=0;i<cities.length;i++) {
//	    	for(int j=i+1;j<cities.length;j++) {
//	    		if((cities[i].compareTo(cities[j]))==0) {
//	    			cities[j]="";
//	    		}
//	    	}
//	    }	    
//	    ArrayList<String> list2 = new ArrayList<String>();
//	    for(int i=0;i<cities.length;i++) {
//	    	if(cities[i]!="") {
//	    		list2.add(cities[i]);
//	    	}
//	    }
//	    
//	    for ( String city: list2)
//	    	System.out.println(city);
	    
	    //2번 contains함수 사용(문자열 포함 여부 확인)
//	    ArrayList<String> list2 = new ArrayList<String>();
//	    for(String item: cities) {
//	    	if(!list2.contains(item)) {
//	    		list2.add(item);
//	    	}
//	    }
//	    System.out.println(list2);
	    
	    //3번 stream.distinct 함수 사용(자바 8.0이상)
//	    cities = Arrays.stream(cities).distinct().toArray(String[]::new);
//	    for ( String city: cities)
//	    	System.out.print(city + " ");
	    
//	    ArrayList<String> lst = new ArrayList<String>(Arrays.asList(cities));
//	    for ( String city: lst)
//	    	System.out.println(city);

	}
}