package Sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Student implements Comparable<Student>{
	private String name;
	private int score;
	
	public Student(String name, int score) {
		this.name = name;
		this.score = score;
	}

	public String getName() {
		return name;
	}

	public int getScore() {
		return score;
	}

	@Override
	public String toString() {
		return name;
	}

	@Override
	public int compareTo(Student o) {
		if (this.score < o.score) return -1;
		else if (this.score > o.score) return 1;
		else return this.name.compareTo(o.name);
	}
	
}

public class Sorting6_2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		ArrayList<Student> arr = new ArrayList<>();
		for (int i=0;i<N;i++) {
			String n = sc.next();
			int s = sc.nextInt();
			arr.add(new Student(n, s));
		}
		Collections.sort(arr);
		System.out.println(arr.toString());
	
	}
	
}
