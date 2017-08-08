package com.jason;


import java.sql.ResultSet;
import java.util.ArrayList;

import com.jason.*;

/**
 * DataRow  */
public class DataRow {
	private int cols = 0;
	private int rowId=0;

	public Object[] COLS;
	
	public DataRow () {
		
	}


	public DataRow(int id,int cols,ResultSet rs) {
		try {
			this.cols=cols;
			this.rowId = id;
			COLS =  new Object[cols];
			for(int i = 0 ;i<cols;++i){
				COLS[i]=rs.getObject(i+1);
			}
		} catch (Exception e) {
			e.printStackTrace();
			//TODO: handle exception
		}

	}

	public Object cols(int index){
		return COLS[index];
	}

	public int getCols(){
		return this.cols;
	}

	public int getRowId(){
		return this.rowId;
	}

	@Override
	public String toString(){
		return "com.jason.DataRow:{'cols':"+this.cols+"}";
	}
}