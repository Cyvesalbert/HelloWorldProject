package ht.helloworld;

import java.util.Scanner;

public class GradeBookTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		GradeBook gradeBook1 = new GradeBook("CS101 Intro to Java programming");
//		GradeBook gradeBook2 = new GradeBook("CS102 Data structures in Java");
//
//		gradeBook1.displayMessage();
//		gradeBook1.determineClassAverage();
		
		int[][] gradesArray = { { 87, 96, 70 },
				{ 68, 87, 90 },
				{ 94, 100, 90 },
				{ 100, 81, 82 },
				{ 83, 65, 85 },
				{ 78, 87, 65 },
				{ 85, 75, 83 },
				{ 91, 94, 100 },
				{ 76, 72, 84 },
				{ 87, 93, 73 } };
		GradeBook gradeBook1 = new GradeBook("CS101 Intro to Java programming", gradesArray);
		gradeBook1.displayMessage();
		gradeBook1.processGrades();
		/*
		 * System.out.printf("gradeBook1 course name is: %s\n",
		 * gradeBook1.getCourseName());
		 * System.out.printf("gradeBook2 course name is: %s\n",
		 * gradeBook2.getCourseName());
		 * 
		 * Scanner input = new Scanner(System.in); GradeBook myGradeBook = new
		 * GradeBook(); System.out.printf("Initial course Name is: %s\n\n",
		 * myGradeBook.getCourseName());
		 * System.out.println("Please enter the course Name:"); String nameOfCourse =
		 * input.nextLine(); input.close();
		 * 
		 * myGradeBook.setCourseName(nameOfCourse); System.out.println();
		 * 
		 * 
		 * myGradeBook.displayMessage();
		 */
	}

}
