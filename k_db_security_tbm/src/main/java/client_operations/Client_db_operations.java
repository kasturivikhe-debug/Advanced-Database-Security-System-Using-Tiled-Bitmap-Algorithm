/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package client_operations;

import db_ops.DB_Driver;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Kasturi
 */
public class Client_db_operations {
    //username, client_name, client_type, client_type_name, email_id, mobile_no, password
    public boolean isClientRegistered(String username, String client_name,String client_type,String client_type_name,String email_id,String mobile_no,String password)
    {
        boolean flag=false;
        try
        {
            Statement st=new DB_Driver().getDBStatement();
            String query="Insert into client_info values ('"+username+"','"+client_name+"','"+client_type+"','"+client_type_name+"','"+email_id+"','"+mobile_no+"','"+password+"')";
            System.out.println("Query : "+query);
            int nor=st.executeUpdate(query);
            if(nor>0)
                flag=true;            
        }
        
        catch(Exception ex)
        {
            System.out.println("Exception at class Client_db_operations at isClientRegistered method is : "+ex);
        }
        return flag;
    }
    public boolean isClientExisted(String un,String pwd)
    {
        boolean flag=false;
        try
        {
            Statement st=new DB_Driver().getDBStatement();
            //select * from client_info where username='un' and password='pwd'
            String query="select * from client_info where username= '"+un+"'and password='"+pwd+"'";
            ResultSet rs=st.executeQuery(query);
            if(rs.next())
            {
                flag=true;
            }
        }
        catch(Exception ex)
        {
            System.out.println("Exception at class Client_db_operations at isClientExisted method is : "+ex);
        }
        return flag;
            
    }
    public ArrayList<String> getClientData(String client_username)
    {
        ArrayList<String> client_data=new ArrayList<String>();
        try
        {
            Statement st=new DB_Driver().getDBStatement();
            String query="select * from client_info where username='"+client_username+"'";
            ResultSet rs=st.executeQuery(query);
            while(rs.next())
            {
                String client_name=rs.getString("client_name");
                String client_type=rs.getString("client_type");
                String client_type_name=rs.getString("client_type_name");
                String email_id=rs.getString("email_id");
                String mobile_num=rs.getString("mobile_no");
                String password=rs.getString("password");
                client_data.add(client_name);
                client_data.add(client_type);
                client_data.add(client_type_name);
                client_data.add(email_id);
                client_data.add(mobile_num);
                client_data.add(password);
            }
            
        }
        catch(Exception ex)
        {
            System.out.println("Exception at Class Client_db_operations at getClientdata() : "+ex);
        }
        return client_data;
    }
    public boolean isClientUpdated(String username, String cname,String ctype,String ctname,String eid,String mnum,String pwd)
    {
        boolean flag=false;
        try
        {
            Statement st=new DB_Driver().getDBStatement();
            String query = "Update client_info set client_name='" +cname + "', client_type='" + ctype+ "',client_type_name='"+ctname+"',email_id='"+eid+"',mobile_no='"+mnum+"',password='"+pwd+"' where username='" +username + "'";
            int nor=st.executeUpdate(query);
            if(nor>0)
                flag=true;
        }
        catch(Exception ex)
        {
            System.out.println("Exception at class Client_db_operations at isClientUpdated method is : "+ex);
        }
        return flag;
    } 
}
