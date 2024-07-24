package ht.helloworld;

import java.util.Scanner;

public class GradeBook {

	private String courseName;
	private int[][] grades;
	
	public GradeBook(String name, int[][] gradesArray) {
		courseName = name;
		grades = gradesArray;
	}
	public void setCourseName(String name) {
		courseName = name;
	}
	
	public String getCourseName() {
		return courseName;
	}
	
	public void displayMessage() {
		System.out.printf("Welcome to the grade book for\n%s!\n", getCourseName());
	}
	
	public void processGrades() {
		outputGrades();
		
		//System.out.printf("\nClass average id %.2f\n", getAverage());
		
		System.out.printf("Lowest grade is %d\nHighest grade is %d\n\n", getMinimum(), getMaximum() );
		
		outputBarChart();
		
	}
	
	public int getMinimum() {
		int lowGrade = grades[0][0];
		for(int[] studentGrades : grades) {
			for(int grade : studentGrades) {
				if(grade < lowGrade) {
					lowGrade = grade;
				}
		}
		}
		return lowGrade;
	}
	
	public int getMaximum() {
		int highGrade = grades[0][0];
		for(int[] studentGrades : grades) {
			for(int grade : studentGrades) {
				if(grade > highGrade) {
					highGrade = grade;
				}
		}
		}
		
		return highGrade;
	}
	
	public double getAverage(int[] setOfGrades) {
		int total = 0;
		for(int grade : setOfGrades) {
			total += grade;
		}
		
		return (double) total / setOfGrades.length;
	}
	
	public void outputBarChart() {
		
		System.out.println(" Overall grade distribution");
		
		int[] frequency = new int[11];
		for(int[] studentGrades : grades) {
			for(int grade : studentGrades) {
				++frequency[grade / 10];
			}
		}
		
		for(int count = 0; count < frequency.length; count++) {
			if(count == 10) {
				System.out.printf("%5d: ", 100);
			}else {
				System.out.printf("%02d-%02d: ", count * 10, count *10 + 9);
				
			}
			
			for(int stars = 0; stars < frequency[count]; stars++) {
				System.out.print("*");
			}
			System.out.println();
			
		}
		
		
	}
	
	public void outputGrades() {
		System.out.println("The grades are:\n");
		System.out.print("               ");
		
		for(int test = 0; test < grades[0].length; test++) {
			System.out.printf("Test %d ", test + 1);
		}
		System.out.println("Average");
			
		for(int student = 0; student < grades.length; student++) {
				
			System.out.printf("Student %2d", student + 1, grades[student]);
				
			for(int test : grades[student]) {
				System.out.printf("%8d", test);
					
				}
			
			double average = getAverage(grades[student]);
			System.out.printf("%9.2f\n", average);
		}
	}
		
		
	
	

	
	
//	public void determineClassAverage() {
//		
//		Scanner input = new Scanner(System.in);
//		
//		int total;
//		int gradeCounter;
//		int grade;
//		double average;
//		
//		total = 0;
//		gradeCounter = 0;
//		
//		System.out.print("Enter grade  or -1 to quit: ");
//		grade = input.nextInt();
//		
//		while(grade != -1) {
//			total = total + grade;
//			gradeCounter = gradeCounter + 1;
//			
//			System.out.print("Enter grade or -1 to quit: ");
//			grade = input.nextInt();
//		}
//		
		/*
		 * while(gradeCounter <= 10) { System.out.print("Enter grade: "); grade =
		 * input.nextInt(); total = total + grade; gradeCounter = gradeCounter + 1;
		 * 
		 * }
		 * 
		 * average = total / 10;
		 */
//		
//		if(gradeCounter != 0) {
//			average = (double) total / gradeCounter;
//	
//		System.out.printf("\n Total of the %d grades entered is %d\n", gradeCounter, total);
//		System.out.printf("Class average is %.2f\n", average);
//		
//		}else {
//			System.out.println("No grades were entered");
//		}
//		
//		
		
		
	
}
