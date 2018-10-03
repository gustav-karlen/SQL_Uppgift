package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;
import java.awt.event.ActionEvent;
import Controller.*;
import Model.*;
import Table.*;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Font;
public class MainGui {

	private JFrame frame;
	private JTextField addStudentPersonalNumbertxt;
	private JTextField addStudentNametxt;
	private JTextField addCourseCodetxt;
	private JTextField addCourseNametxt;
	private JTextField addCoursePointstxt;
	private JTextField courseRegistrationPersonalNumbertxt;
	private JTextField courseRegistrationCodetxt;
	private JTextField gradeRegistrationPersonalNumbertxt;
	private JTextField gradeRegistrationCourseCodetxt;
	private JTextField gradeRegistrationxt;
	private JTextField searchStudenttxt;
	private JTextField searchCoursetxt;
	private JTable searchTable;
	private JTextField searchCourseGradestxt;
	private JTextField searchStudentGradestxt;
	private JTextField courseRegistrationTermtxt;
	private JTextField gradeRegistrationTermtxt;
	private JTable table;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainGui window = new MainGui();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainGui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		MainController ctrl = new MainController();
		CronusController cronusCtrl = new CronusController();
		
		frame = new JFrame();
		frame.setBounds(100, 100, 500, 650);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frame.getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		JPanel panelone = new JPanel();
		tabbedPane.addTab("Task 1", null, panelone, null);
		panelone.setLayout(null);
		
		JLabel addStudentTitlelbl = new JLabel("Add Student");
		addStudentTitlelbl.setFont(new Font("Tahoma", Font.BOLD, 12));
		addStudentTitlelbl.setBounds(6, 6, 227, 14);
		panelone.add(addStudentTitlelbl);
		
		JLabel searchStudentTitlelbl = new JLabel("Student");
		searchStudentTitlelbl.setFont(new Font("Tahoma", Font.BOLD, 12));
		searchStudentTitlelbl.setBounds(6, 321, 206, 14);
		panelone.add(searchStudentTitlelbl);
		
		JLabel addStudentPersonalNumberlbl = new JLabel("Personal Number:");
		addStudentPersonalNumberlbl.setBounds(6, 29, 137, 14);
		panelone.add(addStudentPersonalNumberlbl);
		
		addStudentPersonalNumbertxt = new JTextField();
		addStudentPersonalNumbertxt.setBounds(147, 26, 86, 20);
		panelone.add(addStudentPersonalNumbertxt);
		addStudentPersonalNumbertxt.setColumns(10);
		
		JButton searchStudentbtn = new JButton("Search");
		searchStudentbtn.setBounds(140, 341, 93, 23);
		searchStudentbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try{
					String spnr = searchStudenttxt.getText();
					
					List<Student> students;
					
					if(spnr != null && spnr.length() >0 )
						students = ctrl.searchStudents(spnr);
					else
						students = ctrl.getAllStudents();
					
					StudentTable view = new StudentTable(students);
					searchTable.setModel(view);
					
				}catch (Exception ex){
					ex.printStackTrace();
				}
			}
		});
		panelone.add(searchStudentbtn);
		
		searchStudenttxt = new JTextField();
		searchStudenttxt.setBounds(6, 341, 124, 20);
		panelone.add(searchStudenttxt);
		searchStudenttxt.setColumns(10);
		
		JLabel addStudentName = new JLabel("Name:");
		addStudentName.setBounds(6, 51, 137, 14);
		panelone.add(addStudentName);
		
		addStudentNametxt = new JTextField();
		addStudentNametxt.setBounds(147, 51, 86, 20);
		panelone.add(addStudentNametxt);
		addStudentNametxt.setColumns(10);
		
		JScrollPane scrollPaneSearch = new JScrollPane();
		scrollPaneSearch.setBounds(6, 434, 464, 138);
		panelone.add(scrollPaneSearch);
		
		searchTable = new JTable();
		scrollPaneSearch.setViewportView(searchTable);
		
		JLabel addStudentshowmessagelbl = new JLabel("");
		addStudentshowmessagelbl.setBounds(147, 76, 86, 14);
		panelone.add(addStudentshowmessagelbl);
		
		JButton addStudentAddbtn = new JButton("Add");
		addStudentAddbtn.setBounds(6, 76, 111, 23);
		addStudentAddbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String failedAttempt = "Try Again";
				String successfulAttempt = "Success";
				
				if(addStudentPersonalNumbertxt.getText().isEmpty()){
					addStudentshowmessagelbl.setText(failedAttempt);
				}
				else{
					addStudentshowmessagelbl.setText(successfulAttempt);
				}
				try {
					MainController.createStudent(addStudentPersonalNumbertxt.getText(), addStudentNametxt.getText());
				} catch (Exception e) {
					
				}
				
			}
		});
		panelone.add(addStudentAddbtn);
		
		JLabel addCourseTitlelbl = new JLabel("Add Course");
		addCourseTitlelbl.setFont(new Font("Tahoma", Font.BOLD, 12));
		addCourseTitlelbl.setBounds(243, 6, 227, 14);
		panelone.add(addCourseTitlelbl);
		
		JLabel addCourseCodelbl = new JLabel("Course Code:");
		addCourseCodelbl.setBounds(243, 31, 137, 14);
		panelone.add(addCourseCodelbl);
		
		addCourseCodetxt = new JTextField();
		addCourseCodetxt.setBounds(384, 31, 86, 20);
		panelone.add(addCourseCodetxt);
		addCourseCodetxt.setColumns(10);
		
		JLabel searchCourseTitlelbl = new JLabel("Course");
		searchCourseTitlelbl.setFont(new Font("Tahoma", Font.BOLD, 12));
		searchCourseTitlelbl.setBounds(243, 321, 206, 14);
		panelone.add(searchCourseTitlelbl);
		
		JLabel addCourseNamelbl = new JLabel("Course Name:");
		addCourseNamelbl.setBounds(243, 56, 137, 14);
		panelone.add(addCourseNamelbl);
		
		addCourseNametxt = new JTextField();
		addCourseNametxt.setBounds(384, 56, 86, 20);
		panelone.add(addCourseNametxt);
		addCourseNametxt.setColumns(10);
		
		JButton searchCoursebtn = new JButton("Search");
		searchCoursebtn.setBounds(384, 341, 86, 23);
		searchCoursebtn.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				
				try{
					String ccode = searchCoursetxt.getText();
					
					List<Course> list;
					
					if(ccode != null && ccode.length() > 0 )
						list = MainController.searchCourses(ccode);
					else
						list = MainController.getAllCourses();
					
					CourseTable view = new CourseTable(list);
					searchTable.setModel(view);
					
				}catch (Exception ex){
					ex.printStackTrace();
				}
				
			}
		});
		panelone.add(searchCoursebtn);
		
		searchCoursetxt = new JTextField();
		searchCoursetxt.setBounds(243, 342, 124, 20);
		panelone.add(searchCoursetxt);
		searchCoursetxt.setColumns(10);
		
		JLabel addCoursePointslbl = new JLabel("Course Points:");
		addCoursePointslbl.setBounds(243, 84, 137, 14);
		panelone.add(addCoursePointslbl);
		
		addCoursePointstxt = new JTextField();
		addCoursePointstxt.setBounds(384, 82, 86, 20);
		panelone.add(addCoursePointstxt);
		addCoursePointstxt.setColumns(10);
		
		JLabel addCourseshowmessagelbl = new JLabel("");
		addCourseshowmessagelbl.setBounds(384, 113, 86, 14);
		panelone.add(addCourseshowmessagelbl);
		
		JButton addCoursebtn = new JButton("Add");
		addCoursebtn.setBounds(243, 114, 111, 23);
		addCoursebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String failedAttempt = "Try Again";
				String successfulAttempt = "Sucess";
				
				if(addCourseCodetxt.getText().isEmpty())
					addCourseshowmessagelbl.setText(failedAttempt);
				else
					addCourseshowmessagelbl.setText(successfulAttempt);
				
				try{
					MainController.createCourse(addCourseCodetxt.getText(), addCourseNametxt.getText(), addCoursePointstxt.getText());
				}
				catch (Exception ex){
					ex.printStackTrace();
				}
			}
		});
		panelone.add(addCoursebtn);
		
		JLabel courseRegistrationTitle = new JLabel("Course Registration");
		courseRegistrationTitle.setFont(new Font("Tahoma", Font.BOLD, 12));
		courseRegistrationTitle.setBounds(6, 147, 227, 14);
		panelone.add(courseRegistrationTitle);
		
		JLabel courseRegistrationPersonalNumberlbl = new JLabel("Personal Number:");
		courseRegistrationPersonalNumberlbl.setBounds(6, 166, 137, 14);
		panelone.add(courseRegistrationPersonalNumberlbl);
		
		courseRegistrationPersonalNumbertxt = new JTextField();
		courseRegistrationPersonalNumbertxt.setBounds(147, 163, 86, 20);
		panelone.add(courseRegistrationPersonalNumbertxt);
		courseRegistrationPersonalNumbertxt.setColumns(10);
		
		JLabel courseRegistrationCodelbl = new JLabel("Course Code:");
		courseRegistrationCodelbl.setBounds(6, 197, 137, 14);
		panelone.add(courseRegistrationCodelbl);
		
		courseRegistrationCodetxt = new JTextField();
		courseRegistrationCodetxt.setBounds(147, 194, 86, 20);
		panelone.add(courseRegistrationCodetxt);
		courseRegistrationCodetxt.setColumns(10);
		
		JLabel courseRegistrationshowmessagelbl = new JLabel("");
		courseRegistrationshowmessagelbl.setBounds(147, 253, 86, 14);
		panelone.add(courseRegistrationshowmessagelbl);
		
		JButton courseRegistrationbtn = new JButton("Register");
		courseRegistrationbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String failedAttempt = "Try Again";
				String successfulAttempt = "Sucess";
				
				if(courseRegistrationPersonalNumbertxt.getText().isEmpty())
					courseRegistrationshowmessagelbl.setText(failedAttempt);
				else
					courseRegistrationshowmessagelbl.setText(successfulAttempt);
				
				try{
					MainController.createStudentOnReading(courseRegistrationPersonalNumbertxt.getText(),
							courseRegistrationCodetxt.getText(),courseRegistrationTermtxt.getText());
				} catch (Exception e){
					e.printStackTrace();
				}
				
			}
		});
		courseRegistrationbtn.setBounds(6, 253, 111, 23);
		panelone.add(courseRegistrationbtn);
		
		
		JLabel gradeRegistrationTitle = new JLabel("Grade Registration");
		gradeRegistrationTitle.setFont(new Font("Tahoma", Font.BOLD, 12));
		gradeRegistrationTitle.setBounds(243, 148, 227, 14);
		panelone.add(gradeRegistrationTitle);
		
		JLabel gradeRegistrationPersonalNumberlbl = new JLabel("Personal Number:");
		gradeRegistrationPersonalNumberlbl.setToolTipText("");
		gradeRegistrationPersonalNumberlbl.setBounds(243, 166, 137, 14);
		panelone.add(gradeRegistrationPersonalNumberlbl);
		
		gradeRegistrationPersonalNumbertxt = new JTextField();
		gradeRegistrationPersonalNumbertxt.setBounds(384, 163, 86, 20);
		panelone.add(gradeRegistrationPersonalNumbertxt);
		gradeRegistrationPersonalNumbertxt.setColumns(10);
		
		JLabel gradeRegistrationCourseCodelbl = new JLabel("Course Code:");
		gradeRegistrationCourseCodelbl.setBounds(243, 197, 137, 14);
		panelone.add(gradeRegistrationCourseCodelbl);
		
		gradeRegistrationCourseCodetxt = new JTextField();
		gradeRegistrationCourseCodetxt.setBounds(384, 194, 86, 20);
		panelone.add(gradeRegistrationCourseCodetxt);
		gradeRegistrationCourseCodetxt.setColumns(10);
		
		JLabel gradeRegistrationGradelbl = new JLabel("Grade:");
		gradeRegistrationGradelbl.setBounds(243, 228, 137, 14);
		panelone.add(gradeRegistrationGradelbl);
		
		gradeRegistrationxt = new JTextField();
		gradeRegistrationxt.setBounds(384, 225, 86, 20);
		panelone.add(gradeRegistrationxt);
		gradeRegistrationxt.setColumns(10);
		
		JLabel gradeRegistrationshowmessagelbl = new JLabel("");
		gradeRegistrationshowmessagelbl.setBounds(384, 288, 86, 14);
		panelone.add(gradeRegistrationshowmessagelbl);
		
		JButton gradeRegistrationbtn = new JButton("Register");
		gradeRegistrationbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String failedAttempt = "Try Again";
				String successfulAttempt = "Sucess";
				
				if(gradeRegistrationPersonalNumbertxt.getText().isEmpty())
					gradeRegistrationshowmessagelbl.setText(failedAttempt);
				else
					gradeRegistrationshowmessagelbl.setText(successfulAttempt);
				
				try{
					MainController.createStudentOnDoneReadingStudent(gradeRegistrationPersonalNumbertxt.getText(), gradeRegistrationCourseCodetxt.getText(), gradeRegistrationxt.getText(), gradeRegistrationTermtxt.getText());
					
				}catch(Exception ex){
					ex.printStackTrace();
				}
				
			}
		});
		gradeRegistrationbtn.setBounds(243, 288, 111, 23);
		panelone.add(gradeRegistrationbtn);
		
		
		JLabel searchCourseGradeslbl = new JLabel("Course Grades");
		searchCourseGradeslbl.setFont(new Font("Tahoma", Font.BOLD, 12));
		searchCourseGradeslbl.setBounds(6, 375, 243, 14);
		panelone.add(searchCourseGradeslbl);
		
		JButton searchCourseGradesbtn = new JButton("Search");
		searchCourseGradesbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try{
					String ccode = searchCourseGradestxt.getText();
					
					List<Donereading> doneList;
					
					if(ccode != null && ccode.length() >0 )
						doneList = MainController.searchDonereading(ccode);
					else
						doneList = MainController.getAllDonereading();
						
					DonereadingTable view = new DonereadingTable(doneList);
					searchTable.setModel(view);
				
				} catch (Exception e){
					e.printStackTrace();
				}
			}
		});
		searchCourseGradesbtn.setBounds(144, 400, 89, 23);
		panelone.add(searchCourseGradesbtn);
		
		searchCourseGradestxt = new JTextField();
		searchCourseGradestxt.setBounds(6, 400, 124, 20);
		panelone.add(searchCourseGradestxt);
		searchCourseGradestxt.setColumns(10);
		
		JLabel searchStudentGradeslbl = new JLabel("Student Grades");
		searchStudentGradeslbl.setFont(new Font("Tahoma", Font.BOLD, 12));
		searchStudentGradeslbl.setBounds(243, 375, 215, 14);
		panelone.add(searchStudentGradeslbl);
		
		JButton searchStudentGradesbtn = new JButton("Search");
		searchStudentGradesbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try{
					String spnr = searchStudentGradestxt.getText();
					List<Donereading> list;
					
					if(spnr != null && spnr.length() > 0 )
						list = MainController.searchGrade(spnr);
					else
						list = MainController.getAllDonereading();
	
					FindGradeAndCourseTable view = new FindGradeAndCourseTable(list);
					searchTable.setModel(view);
					
				}catch (Exception ex){
					ex.printStackTrace();
				}
			
			}
		});
		searchStudentGradesbtn.setBounds(384, 400, 86, 23);
		panelone.add(searchStudentGradesbtn);
		
		
		searchStudentGradestxt = new JTextField();
		searchStudentGradestxt.setBounds(243, 401, 124, 20);
		panelone.add(searchStudentGradestxt);
		searchStudentGradestxt.setColumns(10);
		
		JLabel courseRegistrationTermlbl = new JLabel("Term:");
		courseRegistrationTermlbl.setBounds(6, 228, 137, 14);
		panelone.add(courseRegistrationTermlbl);
		
		courseRegistrationTermtxt = new JTextField();
		courseRegistrationTermtxt.setBounds(147, 225, 86, 20);
		panelone.add(courseRegistrationTermtxt);
		courseRegistrationTermtxt.setColumns(10);
		
		JLabel gradeRegistrationTermlbl = new JLabel("Term:");
		gradeRegistrationTermlbl.setBounds(243, 257, 131, 14);
		panelone.add(gradeRegistrationTermlbl);
		
		gradeRegistrationTermtxt = new JTextField();
		gradeRegistrationTermtxt.setBounds(384, 254, 86, 20);
		panelone.add(gradeRegistrationTermtxt);
		gradeRegistrationTermtxt.setColumns(10);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("CRONUS", null, panel, null);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 215, 459, 357);
		panel.add(scrollPane);
		
		JButton btnEmployee = new JButton("Employee");
		btnEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
			        DefaultTableModel cronusTable = new DefaultTableModel(); 
			        table = new JTable(cronusTable);
			        scrollPane.setViewportView(table);
			        cronusTable.setColumnCount(5);
			        String[] columns = {"No_", "First Name", "Last Name", "Address", "City"};
			        cronusTable.setColumnIdentifiers(columns); 
					List<String> list = cronusCtrl.getEmployee();
					for (int i = 0; i<list.size() / 5; i++)
	            	{
	        			String[] row = new String[5];
	                	row[0] = list.get(5*i);
	                    row[1] = list.get(5*i+1);
	                    row[2] = list.get(5*i+2);
	                    row[3] = list.get(5*i+3);
	                    row[4] = list.get(5*i+4);
	                    cronusTable.addRow(row);
	            	}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnEmployee.setBounds(10, 11, 192, 23);
		panel.add(btnEmployee);
		
		JButton btnEmployeeAbsence = new JButton("Employee Absence");
		btnEmployeeAbsence.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
			        DefaultTableModel cronusTable = new DefaultTableModel(); 
			        table = new JTable(cronusTable);
			        scrollPane.setViewportView(table);
			        cronusTable.setColumnCount(5);
			        String[] columns = {"Entry No_", "Employee No_", "From Date", "To Date", "Cause of Absence Code"};
			        cronusTable.setColumnIdentifiers(columns); 
					List<String> list = cronusCtrl.getEmployeeAbsence();
					for (int i = 0; i<list.size() / 5; i++)
	            	{
	        			String[] row = new String[5];
	                	row[0] = list.get(5*i);
	                    row[1] = list.get(5*i+1);
	                    row[2] = list.get(5*i+2);
	                    row[3] = list.get(5*i+3);
	                    row[4] = list.get(5*i+4);
	                    cronusTable.addRow(row);
	            	}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnEmployeeAbsence.setBounds(10, 45, 192, 23);
		panel.add(btnEmployeeAbsence);
		
		JButton btnEmployeePortalSetup = new JButton("Employee Portal Setup");
		btnEmployeePortalSetup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
			        DefaultTableModel cronusTable = new DefaultTableModel(); 
			        table = new JTable(cronusTable);
			        scrollPane.setViewportView(table);
			        cronusTable.setColumnCount(5);
			        String[] columns = {"Primary Key", "Search Limit", "Debugging Path", "Search Tool Pane Caption", "Write Debugging Info_"};
			        cronusTable.setColumnIdentifiers(columns); 
					List<String> list = cronusCtrl.getEmployeePortalSetup();
					for (int i = 0; i<list.size() / 5; i++)
	            	{
	        			String[] row = new String[5];
	                	row[0] = list.get(5*i);
	                    row[1] = list.get(5*i+1);
	                    row[2] = list.get(5*i+2);
	                    row[3] = list.get(5*i+3);
	                    row[4] = list.get(5*i+4);
	                    cronusTable.addRow(row);
	            	}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnEmployeePortalSetup.setBounds(10, 79, 192, 23);
		panel.add(btnEmployeePortalSetup);
		
		JButton btnEmployeeQualification = new JButton("Employee Qualification");
		btnEmployeeQualification.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
			        DefaultTableModel cronusTable = new DefaultTableModel(); 
			        table = new JTable(cronusTable);
			        scrollPane.setViewportView(table);
			        cronusTable.setColumnCount(5);
			        String[] columns = {"Employee No_", "Line No_", "Cost", "Employee Status", "From Date"};
			        cronusTable.setColumnIdentifiers(columns); 
					List<String> list = cronusCtrl.getEmployeeQualification();
					for (int i = 0; i<list.size() / 5; i++)
	            	{
	        			String[] row = new String[5];
	                	row[0] = list.get(5*i);
	                    row[1] = list.get(5*i+1);
	                    row[2] = list.get(5*i+2);
	                    row[3] = list.get(5*i+3);
	                    row[4] = list.get(5*i+4);
	                    cronusTable.addRow(row);
	            	}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnEmployeeQualification.setBounds(10, 113, 192, 23);
		panel.add(btnEmployeeQualification);
		
		JButton btnEmployeeRelative = new JButton("Employee Relative");
		btnEmployeeRelative.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
			        DefaultTableModel cronusTable = new DefaultTableModel(); 
			        table = new JTable(cronusTable);
			        scrollPane.setViewportView(table);
			        cronusTable.setColumnCount(5);
			        String[] columns = {"Employee No_", "Line No_", "First Name", "Last Name", "Birth Date"};
			        cronusTable.setColumnIdentifiers(columns); 
					List<String> list = cronusCtrl.getEmployeeRelative();
					for (int i = 0; i<list.size() / 5; i++)
	            	{
	        			String[] row = new String[5];
	                	row[0] = list.get(5*i);
	                    row[1] = list.get(5*i+1);
	                    row[2] = list.get(5*i+2);
	                    row[3] = list.get(5*i+3);
	                    row[4] = list.get(5*i+4);
	                    cronusTable.addRow(row);
	            	}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnEmployeeRelative.setBounds(10, 147, 192, 23);
		panel.add(btnEmployeeRelative);
		
		JButton btnEmployeeStatisticsGroup = new JButton("Employee Statistics Group");
		btnEmployeeStatisticsGroup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
			        DefaultTableModel cronusTable = new DefaultTableModel(); 
			        table = new JTable(cronusTable);
			        scrollPane.setViewportView(table);
			        cronusTable.setColumnCount(3);
			        String[] columns = {"timestamp", "Code", "Description"};
			        cronusTable.setColumnIdentifiers(columns); 
					List<String> list = cronusCtrl.getEmployeeStatisticsGroup();
					for (int i = 0; i<list.size() / 3; i++)
	            	{
	        			String[] row = new String[3];
	                	row[0] = list.get(3*i);
	                    row[1] = list.get(3*i+1);
	                    row[2] = list.get(3*i+2);
	                    cronusTable.addRow(row);
	            	}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnEmployeeStatisticsGroup.setBounds(10, 181, 192, 23);
		panel.add(btnEmployeeStatisticsGroup);
		
		JButton btnEmployeeMetadata = new JButton("Employee Metadata");
		btnEmployeeMetadata.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
			        DefaultTableModel cronusTable = new DefaultTableModel(); 
			        table = new JTable(cronusTable);
			        scrollPane.setViewportView(table);
			        cronusTable.setColumnCount(5);
			        String[] columns = {"Column Label", "Table Name", "Catalog Name", "Column Display Size", "Scale"};
			        cronusTable.setColumnIdentifiers(columns); 
					List<String> list = cronusCtrl.getEmployeeMetadata();
					for (int i = 0; i<list.size() / 5; i++)
	            	{
	        			String[] row = new String[5];
	                	row[0] = list.get(5*i);
	                    row[1] = list.get(5*i+1);
	                    row[2] = list.get(5*i+2);
	                    row[3] = list.get(5*i+3);
	                    row[4] = list.get(5*i+4);
	                    cronusTable.addRow(row);
	            	}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnEmployeeMetadata.setBounds(212, 11, 257, 23);
		panel.add(btnEmployeeMetadata);
		
		JButton btnEmployeeAbsenceMetadata = new JButton("Employee Absence Metadata");
		btnEmployeeAbsenceMetadata.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
			        DefaultTableModel cronusTable = new DefaultTableModel(); 
			        table = new JTable(cronusTable);
			        scrollPane.setViewportView(table);
			        cronusTable.setColumnCount(5);
			        String[] columns = {"Column Label", "Table Name", "Catalog Name", "Column Display Size", "Scale"};
			        cronusTable.setColumnIdentifiers(columns); 
					List<String> list = cronusCtrl.getEmployeeAbsenceMetadata();
					for (int i = 0; i<list.size() / 5; i++)
	            	{
	        			String[] row = new String[5];
	                	row[0] = list.get(5*i);
	                    row[1] = list.get(5*i+1);
	                    row[2] = list.get(5*i+2);
	                    row[3] = list.get(5*i+3);
	                    row[4] = list.get(5*i+4);
	                    cronusTable.addRow(row);
	            	}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnEmployeeAbsenceMetadata.setBounds(212, 45, 257, 23);
		panel.add(btnEmployeeAbsenceMetadata);
		
		JButton btnEmployeePortalSetup_1 = new JButton("Employee Portal Setup Metadata");
		btnEmployeePortalSetup_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					try {
				        DefaultTableModel cronusTable = new DefaultTableModel(); 
				        table = new JTable(cronusTable);
				        scrollPane.setViewportView(table);
				        cronusTable.setColumnCount(5);
				        String[] columns = {"Column Label", "Table Name", "Catalog Name", "Column Display Size", "Scale"};
				        cronusTable.setColumnIdentifiers(columns); 
						List<String> list = cronusCtrl.getEmployeePortalSetupMetadata();
						for (int i = 0; i<list.size() / 5; i++)
		            	{
		        			String[] row = new String[5];
		                	row[0] = list.get(5*i);
		                    row[1] = list.get(5*i+1);
		                    row[2] = list.get(5*i+2);
		                    row[3] = list.get(5*i+3);
		                    row[4] = list.get(5*i+4);
		                    cronusTable.addRow(row);
		            	}
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
			}
		});
		btnEmployeePortalSetup_1.setBounds(212, 79, 257, 23);
		panel.add(btnEmployeePortalSetup_1);
		
		JButton btnEmployeeQualificationMetadata = new JButton("Employee Qualification Metadata");
		btnEmployeeQualificationMetadata.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
			        DefaultTableModel cronusTable = new DefaultTableModel(); 
			        table = new JTable(cronusTable);
			        scrollPane.setViewportView(table);
			        cronusTable.setColumnCount(5);
			        String[] columns = {"Column Label", "Table Name", "Catalog Name", "Column Display Size", "Scale"};
			        cronusTable.setColumnIdentifiers(columns); 
					List<String> list = cronusCtrl.getEmployeeQualificationMetadata();
					for (int i = 0; i<list.size() / 5; i++)
	            	{
	        			String[] row = new String[5];
	                	row[0] = list.get(5*i);
	                    row[1] = list.get(5*i+1);
	                    row[2] = list.get(5*i+2);
	                    row[3] = list.get(5*i+3);
	                    row[4] = list.get(5*i+4);
	                    cronusTable.addRow(row);
	            	}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnEmployeeQualificationMetadata.setBounds(212, 113, 257, 23);
		panel.add(btnEmployeeQualificationMetadata);
		
		JButton btnEmployeeRelativeMetadata = new JButton("Employee Relative Metadata");
		btnEmployeeRelativeMetadata.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
						try {
					        DefaultTableModel cronusTable = new DefaultTableModel(); 
					        table = new JTable(cronusTable);
					        scrollPane.setViewportView(table);
					        cronusTable.setColumnCount(5);
					        String[] columns = {"Column Label", "Table Name", "Catalog Name", "Column Display Size", "Scale"};
					        cronusTable.setColumnIdentifiers(columns); 
							List<String> list = cronusCtrl.getEmployeeRelativeMetadata();
							for (int i = 0; i<list.size() / 5; i++)
			            	{
			        			String[] row = new String[5];
			                	row[0] = list.get(5*i);
			                    row[1] = list.get(5*i+1);
			                    row[2] = list.get(5*i+2);
			                    row[3] = list.get(5*i+3);
			                    row[4] = list.get(5*i+4);
			                    cronusTable.addRow(row);
			            	}
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
			}
		});
		btnEmployeeRelativeMetadata.setBounds(212, 147, 257, 23);
		panel.add(btnEmployeeRelativeMetadata);
		
		JButton btnEmployeeStatisticsGroup_1 = new JButton("Employee Statistics Group Metadata");
		btnEmployeeStatisticsGroup_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
			        DefaultTableModel cronusTable = new DefaultTableModel(); 
			        table = new JTable(cronusTable);
			        scrollPane.setViewportView(table);
			        cronusTable.setColumnCount(5);
			        String[] columns = {"Column Label", "Table Name", "Catalog Name", "Column Display Size", "Scale"};
			        cronusTable.setColumnIdentifiers(columns); 
					List<String> list = cronusCtrl.getEmployeeStatisticsGroupMetadata();
					for (int i = 0; i<list.size() / 5; i++)
	            	{
	        			String[] row = new String[5];
	                	row[0] = list.get(5*i);
	                    row[1] = list.get(5*i+1);
	                    row[2] = list.get(5*i+2);
	                    row[3] = list.get(5*i+3);
	                    row[4] = list.get(5*i+4);
	                    cronusTable.addRow(row);
	            	}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnEmployeeStatisticsGroup_1.setBounds(212, 181, 257, 23);
		panel.add(btnEmployeeStatisticsGroup_1);
	}
}
