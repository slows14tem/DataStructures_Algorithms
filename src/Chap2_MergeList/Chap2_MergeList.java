package Chap2_MergeList;
//교제 6장 정열 알고리즘
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
public class Chap2_MergeList {
	public static String[] removeElement1(String[] arr, String item) {
        List<String> list = new ArrayList<>(Arrays.asList(arr));
        list.remove(item);
        return list.toArray(String[]::new);
    }
	//중복 제거 함수
	public static String[] removeDuplicate(String[] lst) {
		int cnt = lst.length;
	    for (int i=0;i<cnt;i++) {
	    	int j=i+1;
	    	//lst[i]와 lst[j]~마지막까지를 비교한 후 i+1로 넘어가는 것을 반복 
	    	while(j<cnt){
	    		if((lst[i].compareTo(lst[j]))==0) {
	    			lst = removeElement1(lst, lst[j]);
	    			cnt--;	//중복 항목이 삭제 되어서 배열의 길이도 하나 감소시켜 줌
	    		}
	    		else j++;
	    	}
	    }
	    return lst;
    }
	public static Iterator<String> removeIterDuplicate(ArrayList<String> list, Iterator<String> it) {
		//리스트와 iterator를 받아서 중복을 제거하는 함수.
		//메인에서 리턴을 받아도 hasNext가 false라서 사용 못해봄
		while (it.hasNext()) {
        	int count = 0;
        	String str = it.next();
        	for (int i1 = 0; i1 < list.size(); i1++) {
        		if (list.get(i1) == str) {
        			count++;
        		}
        	}            
        	if (count >= 2) {
        		it.remove();
        	}
        	count = 0;
        }
		return it;
	}
	
	public static void main(String[] args) {
				ArrayList<String> list1 = new ArrayList<String>();
				list1.add("서울");
				list1.add("북경");
				list1.add("상해");
				list1.add("서울");
				list1.add("도쿄");
				list1.add("뉴욕");
				list1.add("서울");
				list1.add("부산");
				list1.add("광주");
				list1.add("양산");
				list1.add("청주");

				ArrayList<String> list2 = new ArrayList<String>();
				list2.add("런던");
				list2.add("로마");
				list2.add("방콕");
				list2.add("북경");
				list2.add("도쿄");
				list2.add("서울");
				list2.add(1, "LA");
				list2.add("서울");
				list2.add("서울");
				list2.add("양산");
				list2.add("해운대");
				
				//정렬
				System.out.println("collection.sort()::");
				Collections.sort(list1);
				Collections.sort(list2);

				//list -> 배열로 변경
			    String[] lst1 = new String[0];
			    lst1 = list1.toArray(lst1);
			    String[] lst2 = new String[0];
			    lst2 = list2.toArray(lst2);
			    
			    //중복제거
			    lst1 = removeDuplicate(lst1);
			    lst2 = removeDuplicate(lst2);
			    
			    System.out.println("list1::");
			    for ( String city: lst1)
			    	System.out.print(city+ " ");
			    System.out.println();
			    
			    System.out.println("list2::");			 
			    for ( String city: lst2)
			    	System.out.print(city+ " ");
			    	
			    String[] lst3 = new String[20];
			    
			    //두 배열을 merge (중복제거도 같이)
			    int i=0; int j = 0; int k = 0;
			    while(i<lst1.length && j<lst2.length) {
			    	if((lst1[i].compareTo(lst2[j]))<0) {	// <0 >>>  lst2가 큼
			    		lst3[k] = lst1[i];
			    		i++;
			    	}
			    	else if((lst1[i].compareTo(lst2[j]))>0){	// >0 >>> lst1이 큼
			    		lst3[k] = lst2[j];
			    		j++;
			    	}
			    	else {
			    		lst3[k] = lst2[j];
			    		j++;i++;			    		
			    	}
			    	k++;
			    }
			    //list1, 2의 항목이 남았을 때 각각 처리
			    while(i<lst1.length ) {
			    	lst3[k] = lst1[i];
		    		i++;
		    		k++;
			    }
			    while(j<lst2.length ) {
			    	lst3[k] = lst2[j];
		    		j++;
		    		k++;
			    }
			    
			    System.out.println();
			    System.out.println("merge:: ");
			    for ( String city: lst3)
			    	System.out.print(city+ " ");
			    //String[] lst3 = new String[20] 을 선언했기 때문에 남는 자리가 null로 채워짐
			    
			    
			    //null 없이 List를 사용해서 중복제거
				ArrayList<String> res = new ArrayList<String>();
			
				//이미 중복 제거된 배열을 ArrayList로 변경해서 작업
				List<String> lists1 = Arrays.asList(lst1);
				List<String> lists2 = Arrays.asList(lst2);
				
				Iterator<String> it1 = lists1.iterator();
				Iterator<String> it2 = lists2.iterator();
				
			//구현 부분	

//				it1 = removeIterDuplicate(list1, it1);
//				Iterator<String> iter1 = it1.iterator(); -- 오류(이미 iterator형인데 또 .iterator를 사용해서 오류인듯				
//				Iterator<String> iter1 = removeIterDuplicate(list1, it1); -- 안됨		        
//		        System.out.println();
//				while (it1.hasNext()) {
//				    System.out.print(it1.next() + " ");}
//				System.out.println();
//				while (it2.hasNext()) {
//				    System.out.print(it2.next() + " ");}

				String v1 = it1.next();
		        String v2 = it2.next();
		        //선언이 Iterator<String> it1 이었기 때문에 v1의 형태도 <String>이여야 함
				//while(it1.hasNext)구문이 끝나면 다시 처음으로 돌아가지 않는다.
		        
		        while (it1.hasNext() && it2.hasNext()) {
		            if ((v1.compareTo(v2)<0)) {
		                res.add(v1);
		                v1 = it1.next();
		                if(!it1.hasNext()) {
			        		res.add(v1);
					    }
		            } 
		            
		            else if((v1.compareTo(v2)>0)) {
		            	res.add(v2);
		            	v2 = it2.next();
		            	if(!it2.hasNext()) {
		            		res.add(v2);
		            	}
		            }
		            else if((v1.compareTo(v2)==0)) {
		                res.add(v2);
		                v1 = it1.next();
		                v2 = it2.next();		            	
		            }
		            		           
		        }		
		        
		        if(!it1.hasNext() && !it2.hasNext()) {
	        		res.add(v1);
	        		res.add(v2);
			    }
		        
		        while (it1.hasNext()) {
		            res.add(v1);
		            v1 = it1.next();
		            //while문으로 들어왔지만 v1 = it1.next(); 로 인해 it1.hasNext()가 false를 반환하면 다음의 if문으로 들어감  
		            if(!it1.hasNext()) {
		        		res.add(v1);
				    }
		        }
		        
		        while (it2.hasNext()) {
		            res.add(v2);
		            v2 = it2.next();
		            if(!it2.hasNext()) {
	            		res.add(v2);
	            	}
		        }
            	

		        //조금 변경된 방법
//				String v1 = it1.hasNext() ? it1.next() : null;
//		        String v2 = it2.hasNext() ? it2.next() : null;
//		        while (v1 != null && v2 != null) {
//		            if ((v1.compareTo(v2)<0)) {
//		                res.add(v1);
//		                v1 = it1.hasNext() ? it1.next() : null;
//		            } 
//		            else if((v1.compareTo(v2)>0)) {
//		            	res.add(v2);		                
//		                v2 = it2.hasNext() ? it2.next() : null;
//		            }
//		           
//		            else {
//		                res.add(v2);
//		                v1 = it1.hasNext() ? it1.next() : null;
//		                v2 = it2.hasNext() ? it2.next() : null;
//		            }
//		        }   
//		        while (v1 != null) {
//		            res.add(v1);
//		            v1 = it1.hasNext() ? it1.next() : null;
//		        }
//		        while (v2 != null) {
//		            res.add(v2);
//		            v2 = it2.hasNext() ? it2.next() : null;
//		        }
				
				System.out.println();
			    System.out.println("merge2:: ");
			    for ( String city: res)
			    	System.out.print(city+ " ");
			}

}
