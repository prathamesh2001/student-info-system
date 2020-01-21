package com.sis.application;

import com.sis.database.StudentDatabase;
import com.sis.ui.UserInterface;

/**
 * Main class.
 * Entry of project.
 *
 */
public class MainClass {
	static {
		/**
		 * Below code is used to initialize database.
		 * i.e. initial values are loaded, with 3 entries in database.
		 */
		StudentDatabase.initialDatabase();
	}
	
	public static void main(String[] args) {
		/**
		 * Creating instance of User Interface class to view UI.
		 */
		UserInterface ui = new UserInterface();
	}
	
}
