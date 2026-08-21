/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package client_operations;

import db_ops.DB_Driver;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Kasturi
 */
public class Client_View_Download_DB_OP {

    public ArrayList<String> getClientData(String client_name) {
        ArrayList<String> client_data = new ArrayList<String>();
        try {
            Statement st = new DB_Driver().getDBStatement();
            String query = "select * from client_data_info where client_name='" + client_name + "'";
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                String filename = rs.getString("table_name");
                client_data.add(filename);
            }
        } catch (Exception ex) {
            System.out.println("Exception at Class Client_View_Download_DB_OP at method getClientData : " + ex);
        }
        return client_data;
    }

    public String[] getTableColumnNames(String tablename) {
        String column_names[] = null;
        try {
            Statement st = new DB_Driver().getDBStatement();
            String query = "Select * from " + tablename;
            ResultSet rs = st.executeQuery(query);
            ResultSetMetaData rsmd = rs.getMetaData();
            int no_columns = rsmd.getColumnCount();
            column_names = new String[no_columns];
            System.out.println("No of Columns : " + no_columns);
            for (int i = 0; i < no_columns; i++) {
                column_names[i] = rsmd.getColumnName(i+1);
                
                
            }
        } catch (Exception ex) {
            System.out.println("Exception at Client_View_Download_DB_OP at method getTableColumns : " + ex);
        }

        return column_names;
    }
    public String[][] getTableData(String tablename,int columncount)
    {
        String[][] datamatrix=null;
        try {
            Statement st1=new DB_Driver().getDBStatement();//to get row count
            Statement st2=new DB_Driver().getDBStatement();//to get table data
            String query="select * from "+tablename;
            ResultSet rs1 =st1.executeQuery(query);//to get row count            
            ResultSet rs2=st2.executeQuery(query);//to get table data
            int rowcount=0;
            while(rs1.next())
                rowcount++;
            
            datamatrix=new String[rowcount][columncount];
            int i=0;
            while(rs2.next())
            {
                for (int j = 0; j < columncount; j++) {
                    datamatrix[i][j]=rs2.getString(j+1);
                }
                i++;
            }

        } catch (Exception ex) {
            System.out.println("Exception at Class Client_View_Download_DB_OP at method  getTableData : " + ex);
        }
        return datamatrix;
        
    }

}
