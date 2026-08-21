/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package client_operations;

import db_ops.DB_Driver;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

/**
 *
 * @author Kasturi
 */
public class ExcelOperations {

    public ArrayList<String> getColumnNames(String filepath) {
        ArrayList<String> column_names = new ArrayList<String>();
        try {
            File file = new File(filepath);
            Workbook wb = Workbook.getWorkbook(file);
            Sheet sht = wb.getSheet(0);
            int rows = sht.getRows();
            int columns = sht.getColumns();
            System.out.println("Rows : " + rows);
            System.out.println("Columns : " + columns);
            int i = 0;
            for (int j = 0; j < columns; j++) {
                Cell cl = sht.getCell(j, i);
                String content = cl.getContents().trim();
                column_names.add(content);
            }
            wb.close();

        } catch (Exception ex) {
            System.out.println("Exception at class ExcelOperations at method getColumnNames() : " + ex);
        }
        return column_names;
    }

    public boolean isTableCreated(String tablename, ArrayList<String> column_names) {
        boolean flag = false;
        try {
            // create table IF NOT EXISTED sampleinfo(Sr_ID VARCHAR(45),name VARCHAR(45),collage VARCHAR(45),PRIM

            String query_part1 = "create table IF NOT EXISTS " + tablename + "(";
            System.out.println("query_part1 : " + query_part1);
            String query_part2 = " ";
            for (int i = 0; i < column_names.size(); i++) {
                String column_name = column_names.get(i);
                System.out.println("column_name " + column_name);
                query_part2 = query_part2 + column_name + " VARCHAR(45) ,";

            }
            System.out.println("query_part2 : " + query_part2);
//PRIMARY KEY(SR_ID))
            String query_part3 = "PRIMARY KEY (" + column_names.get(0) + "))";
            System.out.println("query_part3 : " + query_part3);
            String finalquery = query_part1 + query_part2 + query_part3;
            System.out.println("finalquery : " + finalquery);

            Statement st = new DB_Driver().getDBStatement();
            st.executeUpdate(finalquery);
            flag = true;
        } catch (Exception ex) {
            System.out.println("Exception at class ExcelOperations in method isTableCreated : " + ex);
        }
        return flag;
    }

    public boolean isClientDataStored(String filepath, ArrayList<String> column_names, String tablename) {
        boolean flag = false;
        try {
            //insert into stu_info (reg_no,name,percentage)values(?,?,?);
            String query1 = "INSERT INTO " + tablename + "(";
            String query2 = "";
            String query3 = ")VALUES(";
            for (int i = 0; i < column_names.size(); i++) {
                String single_column_name = column_names.get(i);
                query2 = query2 + single_column_name + ", ";
                query3 = query3 + "? , ";
            }
            
            query2=query2.substring(0,query2.length()-2);
            query3=query3.substring(0,query3.length()-2)+")";
            String sample_query="insert into stu_info (reg_no,name,percentage)values(?,?,?);";
            System.out.println("Sample Query : "+sample_query);
            System.out.println("Query 1 : " + query1);
            System.out.println("Query 2 : " + query2);
            System.out.println("Query 3 : " + query3);
            String final_query=query1+query2+query3;
            System.out.println("Final Query : "+final_query);
            DB_Driver dbd=new DB_Driver();
            dbd.getDBStatement();
            Connection conn=dbd.conn;
            PreparedStatement ps =conn.prepareStatement(final_query);
            File file=new File(filepath);
            Workbook wb=Workbook.getWorkbook(file);
            Sheet sht=wb.getSheet(0);
            int rows=sht.getRows();
            int columns=sht.getColumns();
            for (int i = 1; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    Cell cl=sht.getCell(j,i);
                    String content=cl.getContents();
                    ps.setString(j+1, content);
                }
                ps.addBatch();
            }
            ps.executeBatch();
            wb.close();
            conn.close();
            flag=true;
            return flag;
            } catch (Exception ex) {
            System.out.println("Exception at class ExcelOperations at method isClientDataStored : " + ex);
        }
        return flag;
    }
    public boolean isClientDataInfoStored(String client_name,String table_name,String date_time)
    {
        boolean flag=false;
        try{
            Statement st=new DB_Driver().getDBStatement();
            String query="Insert into client_data_info values ('"+client_name+"','"+table_name+"','"+date_time+"')";
            System.out.println("Query : "+query);
            int nor=st.executeUpdate(query);
            if(nor>0)
                flag=true; 
            
            
        }catch(Exception ex){
            System.out.println("Exceptiion at class ExcelOperations in method isClientDataInfoStored() : "+ex);
        }
        return flag;
        
    }
}
