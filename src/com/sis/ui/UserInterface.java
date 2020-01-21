package com.sis.ui;

import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.sis.database.StudentDatabase;
import com.sis.object.Student;
import com.sis.service.StudentServices;

/**
 *User Interface class is used for designing part.
 *All that you see on desktop will be coded here in this class. 
 *
 */
public class UserInterface implements ActionListener {
	JFrame frame;
	JPanel viewStudentPanel;
	JPanel addStudentPanel;
	JPanel removeStudentPanel;
	JPanel editStudentPanel;
	Font font = new Font("Serif", Font.PLAIN, 14);
	Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
	
	JPanel mainPanel;
	Dimension dimension = new Dimension(130, 25);
	
	/**
	 * Default constructor.
	 * Defining initial window size and main page of Application.
	 */
	public UserInterface() {
		frame = new JFrame("Student Information System");
		frame.setSize(400, 300);
		this.createUI();
	}
	
	/**
	 * Main Page of application.
	 */
	public void createUI() {
		viewStudentPanel = new JPanel();
		addStudentPanel = new JPanel();
		removeStudentPanel = new JPanel();
		editStudentPanel = new JPanel();
		mainPanel = new JPanel();
		JLabel l = new JLabel("Student Information System");
		l.setFont(new Font("Monotype Corsiva", Font.BOLD, 30));
		
		JButton viewStudentBtn = new JButton("View Student");
		JButton addStudentBtn = new JButton("Add Student");
		JButton editStudentBtn = new JButton("Edit Student");
		JButton removeStudentBtn = new JButton("Remove Student");
		
		viewStudentBtn.setCursor(cursor);
		addStudentBtn.setCursor(cursor);
		removeStudentBtn.setCursor(cursor);
		editStudentBtn.setCursor(cursor);
		
		viewStudentBtn.setFont(font);
		addStudentBtn.setFont(font);
		removeStudentBtn.setFont(font);
		editStudentBtn.setFont(font);
		
		viewStudentBtn.setPreferredSize(dimension);
		addStudentBtn.setPreferredSize(dimension);
		removeStudentBtn.setPreferredSize(dimension);
		editStudentBtn.setPreferredSize(dimension);
		
		addStudentBtn.addActionListener(this);
		viewStudentBtn.addActionListener(this);
		removeStudentBtn.addActionListener(this);
		editStudentBtn.addActionListener(this);
		
		GridBagConstraints gbc = new GridBagConstraints();
		GridBagLayout grid = new GridBagLayout();
		gbc.weighty = 1;
		gbc.gridwidth = 2;
		setGridbagConstraint(gbc, 0, 0);
		setComponemt(gbc, l, grid, mainPanel);
		
		gbc.weightx = 1;
		gbc.gridwidth = 1;
		setGridbagConstraint(gbc, 0, 1);
		setComponemt(gbc, viewStudentBtn, grid, mainPanel);
		
		setGridbagConstraint(gbc, 1, 1);
		setComponemt(gbc, addStudentBtn, grid, mainPanel);
		
		setGridbagConstraint(gbc, 0, 2);
		setComponemt(gbc, editStudentBtn, grid, mainPanel);
		
		setGridbagConstraint(gbc, 1, 2);
		setComponemt(gbc, removeStudentBtn, grid, mainPanel);
		mainPanel.setLayout(grid);
		frame.add(mainPanel);
		
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	/**
	 * Set layout configuration.
	 * 
	 * @param gbc
	 * @param x
	 * @param y
	 */
	private static void setGridbagConstraint(GridBagConstraints gbc, int x, int y) {
		gbc.gridx = x;
		gbc.gridy = y;
	}
	
	/**
	 * Set component to panel.
	 * 
	 * @param gbc
	 * @param component
	 * @param grid
	 * @param p
	 */
	private static void setComponemt(GridBagConstraints gbc, Component component, GridBagLayout grid, JPanel p) {
		grid.setConstraints(component, gbc);
		p.add(component, gbc);
	}
	
	JTextField rollNumberField;
	JTextField firstName;
	JTextField lastName;
	JTextField division;
	
	/**
	 * All the actions to be performed on click of any button will be coded in actionPerformed method.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getActionCommand().equals("View Student")) {
			this.viewStudentAction();
		} else if (e.getActionCommand().equals("Add Student")) {
			this.addStudentAction();
		} else if (e.getActionCommand().equals("Home")) {
			this.homeAction();
		} else if (e.getActionCommand().equals("View")) {
			this.viewAction();
		} else if (e.getActionCommand().equals("Add")) {
			this.addAction();
		} else if (e.getActionCommand().equals("Remove Student")) {
			this.removeStudentAction();
		} else if (e.getActionCommand().equals("Remove")) {
			this.removeAction();
		} else if (e.getActionCommand().equals("Edit Student")) {
			this.editStudentAction();
		} else if (e.getActionCommand().equals("Edit")) {
			this.editAction();
		} else if (e.getActionCommand().equals("Change Details")) {
			this.changeDetailsAction();
		}
		
	}
	
	/**
	 * Action that will be performed on click of View Student button.
	 */
	private void viewStudentAction() {
		
		mainPanel.setVisible(false);
		viewStudentPanel = new JPanel();
		JLabel rollNumberLabel = new JLabel("Enter Roll Number");
		rollNumberLabel.setFont(font);
		rollNumberField = new JTextField(10);
		JButton viewBtn = new JButton("View");
		JButton homeBtn = new JButton("Home");
		viewBtn.setFont(font);
		homeBtn.setFont(font);
		viewBtn.setCursor(cursor);
		homeBtn.setCursor(cursor);
		viewStudentPanel.add(rollNumberLabel);
		viewStudentPanel.add(rollNumberField);
		viewStudentPanel.add(viewBtn);
		viewStudentPanel.add(homeBtn);
		viewBtn.addActionListener(this);
		homeBtn.addActionListener(this);
		frame.add(viewStudentPanel);
		
	}
	
	/**
	 * Action that will be performed on click of Add Student button.
	 */
	private void addStudentAction() {
		
		mainPanel.setVisible(false);
		addStudentPanel = new JPanel();
		JLabel firstNameLbl = new JLabel("First Name: ");
		firstName = new JTextField(10);
		firstName.setToolTipText("Enter First Name");
		firstNameLbl.setFont(font);
		JLabel lastNameLbl = new JLabel("Last Name: ");
		lastName = new JTextField(10);
		lastName.setToolTipText("Enter Last Name");
		lastNameLbl.setFont(font);
		JLabel divisionLbl = new JLabel("Division: ");
		division = new JTextField(10);
		division.setToolTipText("Enter Division");
		divisionLbl.setFont(font);
		
		JButton addBtn = new JButton("Add");
		JButton homeBtn = new JButton("Home");
		addBtn.setFont(font);
		homeBtn.setFont(font);
		addBtn.setCursor(cursor);
		homeBtn.setCursor(cursor);
		addBtn.addActionListener(this);
		homeBtn.addActionListener(this);
		
		GridBagConstraints gbc = new GridBagConstraints();
		GridBagLayout grid = new GridBagLayout();
		//	gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.gridwidth = 1;
		
		setGridbagConstraint(gbc, 0, 0);
		setComponemt(gbc, firstNameLbl, grid, addStudentPanel);
		
		setGridbagConstraint(gbc, 1, 0);
		setComponemt(gbc, firstName, grid, addStudentPanel);
		
		setGridbagConstraint(gbc, 0, 1);
		setComponemt(gbc, lastNameLbl, grid, addStudentPanel);
		
		setGridbagConstraint(gbc, 1, 1);
		setComponemt(gbc, lastName, grid, addStudentPanel);
		
		setGridbagConstraint(gbc, 0, 2);
		setComponemt(gbc, divisionLbl, grid, addStudentPanel);
		
		setGridbagConstraint(gbc, 1, 2);
		setComponemt(gbc, division, grid, addStudentPanel);
		
		setGridbagConstraint(gbc, 0, 3);
		setComponemt(gbc, addBtn, grid, addStudentPanel);
		
		setGridbagConstraint(gbc, 1, 3);
		setComponemt(gbc, homeBtn, grid, addStudentPanel);
		
		addStudentPanel.setLayout(grid);
		frame.add(addStudentPanel);
		
	}
	
	/**
	 * Action that will be performed on click of Home button.
	 */
	private void homeAction() {
		
		viewStudentPanel.setVisible(false);
		addStudentPanel.setVisible(false);
		removeStudentPanel.setVisible(false);
		editStudentPanel.setVisible(false);
		mainPanel.setVisible(true);
		
	}
	
	/**
	 * Action that will be performed on click of View button.
	 */
	private void viewAction() {
		
		viewStudentPanel.setVisible(false);
		StudentServices services = new StudentServices();
		String rollNumber = rollNumberField.getText();
		Integer rollNum = null;
		if (!rollNumber.equals("")) {
			
			try {
				rollNum = Integer.parseInt(rollNumber);
			} catch (Exception exception) {
				JOptionPane.showMessageDialog(frame, "Enter Valid Roll Number", "Warning", JOptionPane.ERROR_MESSAGE);
				viewStudentPanel.setVisible(true);
			}
		}
		if (rollNumber.equals("")) {
			JOptionPane.showMessageDialog(frame, "First enter Roll Number", "Warning", JOptionPane.WARNING_MESSAGE);
			viewStudentPanel.setVisible(true);
		} else if (!services.isRollNumberPresent(rollNum)) {
			JOptionPane.showMessageDialog(frame, "Roll Number does not exist", "Warning", JOptionPane.ERROR_MESSAGE);
			viewStudentPanel.setVisible(true);
		} else {
			viewStudentPanel.removeAll();
			Student s = services.getStudent(rollNum);
			JLabel rollNo = new JLabel("Roll Number");
			JLabel name = new JLabel("Name");
			JLabel division = new JLabel("Division");
			JLabel rollNoValue = new JLabel(rollNum + "");
			JLabel nameValue = new JLabel(s.getFirstName() + " " + s.getLastName());
			JLabel divisionValue = new JLabel(s.getDivision());
			JLabel totalStudents = new JLabel("Total Number of Students: " + StudentDatabase.studentDatabase.length);
			
			rollNo.setFont(font);
			name.setFont(font);
			division.setFont(font);
			rollNoValue.setFont(font);
			nameValue.setFont(font);
			divisionValue.setFont(font);
			totalStudents.setFont(font);
			JButton okBtn = new JButton("Home");
			okBtn.setFont(font);
			okBtn.setCursor(cursor);
			okBtn.addActionListener(this);
			
			GridBagConstraints gbc = new GridBagConstraints();
			GridBagLayout grid = new GridBagLayout();
			
			setGridbagConstraint(gbc, 0, 0);
			setComponemt(gbc, rollNo, grid, viewStudentPanel);
			
			setGridbagConstraint(gbc, 1, 0);
			setComponemt(gbc, rollNoValue, grid, viewStudentPanel);
			
			setGridbagConstraint(gbc, 0, 1);
			setComponemt(gbc, name, grid, viewStudentPanel);
			
			setGridbagConstraint(gbc, 1, 1);
			setComponemt(gbc, nameValue, grid, viewStudentPanel);
			
			setGridbagConstraint(gbc, 0, 2);
			setComponemt(gbc, division, grid, viewStudentPanel);
			
			setGridbagConstraint(gbc, 1, 2);
			setComponemt(gbc, divisionValue, grid, viewStudentPanel);
			
			gbc.gridwidth = 2;
			setGridbagConstraint(gbc, 0, 3);
			setComponemt(gbc, okBtn, grid, viewStudentPanel);
			
			gbc.weighty = 1;
			setGridbagConstraint(gbc, 0, 4);
			setComponemt(gbc, totalStudents, grid, viewStudentPanel);
			
			viewStudentPanel.add(rollNo);
			viewStudentPanel.add(name);
			viewStudentPanel.add(division);
			viewStudentPanel.add(okBtn);
			viewStudentPanel.setLayout(grid);
			viewStudentPanel.setVisible(true);
			frame.add(viewStudentPanel);
		}
		
	}
	
	/**
	 * Action that will be performed on click of Add button.
	 */
	private void addAction() {
		
		StudentServices services = new StudentServices();
		if (firstName.getText().equals("") || lastName.getText().equals("") || division.getText().equals("")) {
			JOptionPane.showMessageDialog(frame, "All Fields are required", "Warning", JOptionPane.WARNING_MESSAGE);
			addStudentPanel.setVisible(true);
		} else {
			
			Student s = new Student();
			s.setFirstName(firstName.getText());
			s.setLastName(lastName.getText());
			s.setDivision(division.getText());
			s.setRollNumber(services.getRollNumber());
			services.addStudent(s);
			JOptionPane.showMessageDialog(frame, "Student Added Successfully.\n Your Roll Number is " + s.getRollNumber(), "Info", JOptionPane.INFORMATION_MESSAGE);
			addStudentPanel.setVisible(false);
			mainPanel.setVisible(true);
		}
		
	}
	
	/**
	 * Action that will be performed on click of Remove Student button.
	 */
	private void removeStudentAction() {
		
		mainPanel.setVisible(false);
		removeStudentPanel = new JPanel();
		JLabel rollNumberLabel = new JLabel("Enter Roll Number");
		rollNumberLabel.setFont(font);
		rollNumberField = new JTextField(10);
		JButton removeBtn = new JButton("Remove");
		JButton homeBtn = new JButton("Home");
		removeBtn.setFont(font);
		homeBtn.setFont(font);
		removeBtn.setCursor(cursor);
		homeBtn.setCursor(cursor);
		homeBtn.addActionListener(this);
		removeBtn.addActionListener(this);
		removeStudentPanel.add(rollNumberLabel);
		removeStudentPanel.add(rollNumberField);
		removeStudentPanel.add(removeBtn);
		removeStudentPanel.add(homeBtn);
		
		removeStudentPanel.setVisible(true);
		frame.add(removeStudentPanel);
		
	}
	
	/**
	 * Action that will be performed on click of Remove button.
	 */
	private void removeAction() {
		
		StudentServices services = new StudentServices();
		String rollNumber = rollNumberField.getText();
		Integer rollNum = null;
		if (!rollNumber.equals("")) {
			
			try {
				rollNum = Integer.parseInt(rollNumber);
			} catch (Exception exception) {
				JOptionPane.showMessageDialog(frame, "Enter Valid Roll Number", "Warning", JOptionPane.ERROR_MESSAGE);
				removeStudentPanel.setVisible(true);
			}
		}
		if (rollNumber.equals("")) {
			JOptionPane.showMessageDialog(frame, "First enter Roll Number", "Warning", JOptionPane.WARNING_MESSAGE);
			removeStudentPanel.setVisible(true);
		} else if (!services.isRollNumberPresent(rollNum)) {
			JOptionPane.showMessageDialog(frame, "Roll Number does not exist", "Warning", JOptionPane.ERROR_MESSAGE);
			removeStudentPanel.setVisible(true);
		} else {
			services.removeStudent(rollNum);
			JOptionPane.showMessageDialog(frame, "Student with Roll Number " + rollNum + " removed Successfully.", "Info", JOptionPane.INFORMATION_MESSAGE);
			removeStudentPanel.setVisible(false);
			mainPanel.setVisible(true);
		}
		
	}
	
	/**
	 * Action that will be performed on click of Edit Student button.
	 */
	private void editStudentAction() {
		
		mainPanel.setVisible(false);
		editStudentPanel = new JPanel();
		JLabel rollNumberLabel = new JLabel("Enter Roll Number");
		rollNumberLabel.setFont(font);
		rollNumberField = new JTextField(10);
		JButton editBtn = new JButton("Edit");
		JButton homeBtn = new JButton("Home");
		editBtn.setFont(font);
		homeBtn.setFont(font);
		editBtn.setCursor(cursor);
		homeBtn.setCursor(cursor);
		editStudentPanel.add(rollNumberLabel);
		editStudentPanel.add(rollNumberField);
		editStudentPanel.add(editBtn);
		editStudentPanel.add(homeBtn);
		editBtn.addActionListener(this);
		homeBtn.addActionListener(this);
		frame.add(editStudentPanel);
		
	}
	
	JLabel rollNo;
	
	/**
	 * Action that will be performed on click of Edit button.
	 */
	private void editAction() {
		
		editStudentPanel.setVisible(false);
		StudentServices services = new StudentServices();
		String rollNumber = rollNumberField.getText();
		Integer rollNum = null;
		if (!rollNumber.equals("")) {
			
			try {
				rollNum = Integer.parseInt(rollNumber);
			} catch (Exception exception) {
				JOptionPane.showMessageDialog(frame, "Enter Valid Roll Number", "Warning", JOptionPane.ERROR_MESSAGE);
				editStudentPanel.setVisible(true);
			}
		}
		if (rollNumber.equals("")) {
			JOptionPane.showMessageDialog(frame, "First enter Roll Number", "Warning", JOptionPane.WARNING_MESSAGE);
			editStudentPanel.setVisible(true);
		} else if (!services.isRollNumberPresent(rollNum)) {
			JOptionPane.showMessageDialog(frame, "Roll Number does not exist", "Warning", JOptionPane.ERROR_MESSAGE);
			editStudentPanel.setVisible(true);
		} else {
			editStudentPanel.removeAll();
			Student s = services.getStudent(rollNum);
			JLabel rollNumberLbl = new JLabel("Roll Number");
			rollNumberLbl.setFont(font);
			rollNumberField = new JTextField(s.getRollNumber() + "");
			rollNumberField.setColumns(20);
			rollNumberField.setEditable(false);
			JLabel firstNameLbl = new JLabel("First Name");
			firstNameLbl.setFont(font);
			firstName = new JTextField(s.getFirstName());
			firstName.setColumns(20);
			firstName.setEditable(true);
			JLabel lastNameLbl = new JLabel("Last Name");
			lastNameLbl.setFont(font);
			lastName = new JTextField(s.getLastName());
			lastName.setColumns(20);
			lastName.setEditable(true);
			JLabel divisionLbl = new JLabel("Division");
			divisionLbl.setFont(font);
			division = new JTextField(s.getDivision());
			division.setColumns(20);
			division.setEditable(true);
			
			JButton edit = new JButton("Change Details");
			edit.setFont(font);
			edit.setCursor(cursor);
			edit.addActionListener(this);
			
			GridBagConstraints gbc = new GridBagConstraints();
			GridBagLayout grid = new GridBagLayout();
			
			setGridbagConstraint(gbc, 0, 0);
			setComponemt(gbc, rollNumberLbl, grid, editStudentPanel);
			
			setGridbagConstraint(gbc, 1, 0);
			setComponemt(gbc, rollNumberField, grid, editStudentPanel);
			
			setGridbagConstraint(gbc, 0, 1);
			setComponemt(gbc, firstNameLbl, grid, editStudentPanel);
			
			setGridbagConstraint(gbc, 1, 1);
			setComponemt(gbc, firstName, grid, editStudentPanel);
			
			setGridbagConstraint(gbc, 0, 2);
			setComponemt(gbc, lastNameLbl, grid, editStudentPanel);
			
			setGridbagConstraint(gbc, 1, 2);
			setComponemt(gbc, lastName, grid, editStudentPanel);
			
			setGridbagConstraint(gbc, 0, 3);
			setComponemt(gbc, divisionLbl, grid, editStudentPanel);
			
			setGridbagConstraint(gbc, 1, 3);
			setComponemt(gbc, division, grid, editStudentPanel);
			
			gbc.gridwidth = 2;
			setGridbagConstraint(gbc, 0, 4);
			setComponemt(gbc, edit, grid, editStudentPanel);
			
			editStudentPanel.setLayout(grid);
			editStudentPanel.setVisible(true);
			frame.add(editStudentPanel);
		}
		
	}
	
	/**
	 * Action that will be performed on click of Change Details button.
	 */
	private void changeDetailsAction() {
		
		Student editedStudent = new Student();
		StudentServices services = new StudentServices();
		String rollNumber = rollNumberField.getText();
		Integer rollNum = null;
		if (!rollNumber.equals("")) {
			
			try {
				rollNum = Integer.parseInt(rollNumber);
			} catch (Exception exception) {
				JOptionPane.showMessageDialog(frame, "Enter Valid Roll Number", "Warning", JOptionPane.ERROR_MESSAGE);
				editStudentPanel.setVisible(true);
			}
		}
		if (firstName.getText().equals("") || lastName.getText().equals("") || division.getText().equals("")) {
			JOptionPane.showMessageDialog(frame, "All Fields are required", "Warning", JOptionPane.WARNING_MESSAGE);
			editStudentPanel.setVisible(true);
		} else {
			editedStudent.setRollNumber(rollNum);
			editedStudent.setFirstName(firstName.getText());
			editedStudent.setLastName(lastName.getText());
			editedStudent.setDivision(division.getText());
			
			services.editStudent(editedStudent);
			JOptionPane.showMessageDialog(frame, "Student Updated Successfully", "Info", JOptionPane.INFORMATION_MESSAGE);
			editStudentPanel.setVisible(false);
			mainPanel.setVisible(true);
		}
	}
}
