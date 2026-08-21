/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package k_db_security_tbm;

import client_operations.ClientLogInFrame;
import client_operations.ExcelOperations;
import client_operations.Validator;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;


/**
 *
 * @author Kasturi
 */
public class K_db_security_tbm {

    public static void main(String[] args) {
        ClientLogInFrame clf=new ClientLogInFrame();
        clf.setVisible(true);
        Dimension dim = Toolkit .getDefaultToolkit().getScreenSize();
        clf.setSize(dim);
          
//          ArrayList<String> columns=new ArrayList<String>();
//          columns.add("regno");
//          columns.add("department");
//          columns.add("name");
//          System.out.println("Columns : "+columns);
//          String tablename="student_department_info";
//          System.out.println("Table Name : "+tablename);
//          if(new ExcelOperations().isTableCreated(tablename,columns))
//              System.out.println("Table created Successfully");
//          else
//              System.out.println("Error occurred please check");
      
    }
}
