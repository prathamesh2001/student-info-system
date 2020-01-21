package com.sis.service;

import java.util.Arrays;

import com.sis.database.StudentDatabase;
import com.sis.object.Student;

/**
 * 
 * All the functionalities that are used in application will be coded here.
 *
 */
public class StudentServices {
	
	/**
	 * This method is used to get Student object based on roll number.
	 * @param rollNumber
	 * @return
	 */
	public Student getStudent(int rollNumber) {
		Student student = null;
		for (Student s : StudentDatabase.studentDatabase) {
			if (s.getRollNumber() == rollNumber) {
				student = s;
				break;
			}
		}
		return student;
	}
	
	/**
	 * This method is used to add student to StudentDatabase.
	 * @param studentToBeAdded
	 */
	public void addStudent(Student studentToBeAdded) {
		//Here we are increementing the size of array by one, and then adding new Student.
		StudentDatabase.studentDatabase = Arrays.copyOf(StudentDatabase.studentDatabase, StudentDatabase.studentDatabase.length + 1);
		StudentDatabase.studentDatabase[StudentDatabase.studentDatabase.length - 1] = studentToBeAdded;
	}
	
	/**
	 * This method is used to get new roll number, whenever a student is added to system.
	 * @return
	 */
	public Integer getRollNumber() {
		Integer rollNumber = null;
		rollNumber = this.getLargestNumber() + 1;
		return rollNumber;
	}
	
	/**
	 * This method gives largest roll number present in data base, 
	 * so that when new student is added, we increment this number by one.
	 * @return
	 */
	private Integer getLargestNumber() {
		Integer largestNumber = null;
		largestNumber = StudentDatabase.studentDatabase[0].getRollNumber();
		for (int i = 0; i < StudentDatabase.studentDatabase.length; i++) {
			if (largestNumber < StudentDatabase.studentDatabase[i].getRollNumber()) {
				largestNumber = StudentDatabase.studentDatabase[i].getRollNumber();
			}
		}
		
		return largestNumber;
	}
	
	/**
	 * This method is used to check if roll number is present or not.
	 * @param rollNumber
	 * @return
	 */
	public boolean isRollNumberPresent(int rollNumber) {
		Boolean isRollNumberPresent = false;
		for (int i = 0; i < StudentDatabase.studentDatabase.length; i++) {
			if (StudentDatabase.studentDatabase[i].getRollNumber() == rollNumber) {
				isRollNumberPresent = true;
			}
		}
		return isRollNumberPresent;
		
	}
	
	/**
	 * This method is used to remove a student from StudentDatabase.
	 * @param rollNumber
	 */
	public void removeStudent(int rollNumber) {
		int index = 0;
		for (int i = 0; i < StudentDatabase.studentDatabase.length; i++) {
			if (StudentDatabase.studentDatabase[i].getRollNumber() == rollNumber) {
				index = i;
			}
		}
		StudentDatabase.studentDatabase = this.removeTheElement(StudentDatabase.studentDatabase, index);
	}
	
	/**
	 * Generic  method to remove element from array.
	 * @param arr
	 * @param index
	 * @return
	 */
	private Student[] removeTheElement(Student[] arr, int index) {
		
		// If the array is empty 
		// or the index is not in array range 
		// return the original array 
		if (arr == null || index < 0 || index >= arr.length) {
			
			return arr;
		}
		
		// Create another array of size one less 
		Student[] anotherArray = new Student[arr.length - 1];
		
		// Copy the elements except the index 
		// from original array to the other array 
		for (int i = 0, k = 0; i < arr.length; i++) {
			
			// if the index is 
			// the removal element index 
			if (i == index) {
				continue;
			}
			
			// if the index is not 
			// the removal element index 
			anotherArray[k++] = arr[i];
		}
		
		// return the resultant array 
		return anotherArray;
	}
	
	/**
	 * This method is used to Edit student.
	 * @param editedStudent
	 */
	public void editStudent(Student editedStudent) {
		this.getStudent(editedStudent.getRollNumber());
		for (int i = 0; i < StudentDatabase.studentDatabase.length; i++) {
			if (StudentDatabase.studentDatabase[i].getRollNumber() == editedStudent.getRollNumber()) {
				StudentDatabase.studentDatabase[i] = editedStudent;
			}
		}
	}
	
}
