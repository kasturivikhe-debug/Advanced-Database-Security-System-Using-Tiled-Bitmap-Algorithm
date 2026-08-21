/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package admin_operations;

import db_ops.DB_Driver;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Kasturi
 */
public class Admin_db_operations {
    public boolean isAdminExisted(String username,String password)
    {
        boolean flag=false;
        try
        {
            Statement st=new DB_Driver().getDBStatement();
            //select * from admin_info where user_name='username' and admin_password='password';
            String query="select * from admin_info where user_name= '"+username+"'and admin_password='"+password+"'";
            ResultSet rs=st.executeQuery(query);
            if(rs.next())
            {
                flag=true;
            }
        }
        catch(Exception ex)
        {
            System.out.println("Exception at class Admin_db_Operations in mathod isAdminExisted() : "+ex);
        }
        return flag;
    }
    
}
