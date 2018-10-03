package Table;

import java.util.List;

import javax.swing.table.AbstractTableModel;
import Model.*;
public class FindGradeAndCourseTable extends AbstractTableModel {
	private static final int CourseCode =0;
	private static final int Grade = 1;
	private static final int term = 2;
	private static final int spnr =3;
	
	private String [] columnNames = {"Course Code", "Grade","Term", "Personal number"};
	
	private List<Donereading>doneList;
	public FindGradeAndCourseTable (List<Donereading>e){
		doneList = e;
		
	}
	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public int getRowCount() {
		return doneList.size();
	}
	
	public String getColumnName (int col){
		return columnNames[col];
	}
	
	@Override
	public Object getValueAt(int row, int col) {
		Donereading tempDone = doneList.get(row);
		
		switch (col){
		case CourseCode:
			return tempDone.getCcode();
		case Grade:
			return tempDone.getGrade();
		case term:
			return tempDone.getTerm();
		case spnr:
			return tempDone.getSpnr();
		default: 
			return tempDone.getCcode();
		}
	}

}

