package Table;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import Model.*;
public class CourseTable extends AbstractTableModel {
	private static final int Course_name = 0;
	private static final int Course_code = 1;
	private static final int Course_points = 2;
	
	private String [] columnNames = { "Course name", "Course code", "Course points"};

	
	private List<Course> courseList;
	
	public CourseTable (List<Course>thecourses){
		courseList = thecourses;
	}
	
	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public int getRowCount() {
		return courseList.size();
	}
	@Override
	public String getColumnName(int col) {
		return columnNames[col];
	}
	@Override
	public Object getValueAt(int row, int col) {
		
		Course tempCourses = courseList.get(row);
		
		switch (col){
		case Course_name:
			return tempCourses.getCname(); 
		case Course_code:
			return tempCourses.getCcode();
		case Course_points:
			return tempCourses.getCpoints();
		default:
			return tempCourses.getCcode();
		}
	}
	public Class getColumnClass (int c){
		return getValueAt(0,c).getClass();
	}

}

