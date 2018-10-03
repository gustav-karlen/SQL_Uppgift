package Table;

import java.util.List;

import javax.swing.table.AbstractTableModel;
import Model.*;

public class DonereadingTable extends AbstractTableModel{
	private static final int CourseCode=0;
	private static final int Spnr=1;
	private static final int Grade=2;
	private static final int Term=3;
	
	private String [] columnNames = {"Course code","Personal number","Grade","Term"};
	
	private List<Donereading>doneList;
	
	public DonereadingTable (List<Donereading>theDonereading){
		doneList = theDonereading;
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
		case Spnr:
			return tempDone.getSpnr();
		case Grade:
			return tempDone.getGrade();
		case Term:
			return tempDone.getTerm();
		default:
			return tempDone.getCcode();
		}
	}
		
//	public Class getColumnClass (int c){
//			return getValueAt(0,c).getClass();
//		}
		
	

}
