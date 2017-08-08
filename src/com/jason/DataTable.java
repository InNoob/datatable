package com.jason;

import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * Table
 */
public class DataTable {

	private ResultSet rs = null;
	private int rows=0;
	private int cols=0;
	private ArrayList<DataRow> alrow;


	// public DataRow[] ROWS;
	public static DataRow[] ROWS;

    public DataTable () {
		
	}

	public DataTable(ResultSet rs) {
		try {
			this.rs=rs;
			cols=rs.getMetaData().getColumnCount();
			this.alrow = new ArrayList<DataRow>();
			while(rs.next()){
				this.alrow.add(new DataRow(rows,cols,rs));
				++rows;
			}
			ROWS = new DataRow[rows];
			for(int i = 0;i<rows;++i){
				ROWS[i]=alrow.get(i);
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
			//TODO: handle exception
		}
	}

	public DataRow rows(int index){
		return this.alrow.get(index);
	}

	public int getRows(){
		return rows;
	}
	public int getCols(){
		return cols;
	}

	public void free(){
		System.gc();
	}
	@Override
	public String toString(){
		return "com.jason.Table:{'rows':"+this.rows+",'cols':"+this.cols+"}";

	}

}