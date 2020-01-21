package com.sis.database;

import com.sis.object.Student;

/**
 * Database class which will have array of students.
 * studentDatabase variable store all the entries of Students.
 *
 */
public class StudentDatabase {
	public static Student[] studentDatabase = new Student[10];
	
	/**
	 * Initial values of database are stored here.
	 */
	public static void initialDatabase() {
		
		Student s1 = new Student();
		s1.setFirstName("Raj");
		s1.setLastName("Babbar");
		s1.setRollNumber(1);
		s1.setDivision("Computers");
		Student s2 = new Student();
		s2.setFirstName("Salman");
		s2.setLastName("Khan");
		s2.setRollNumber(2);
		s2.setDivision("Information Tech");
		Student s3 = new Student();
		s3.setFirstName("Arjun");
		s3.setLastName("Kapoor");
		s3.setRollNumber(3);
		s3.setDivision("Mechanics");
		
		Student[] studentArray = { s1, s2, s3 };
		studentDatabase = studentArray;
		
	}
}
