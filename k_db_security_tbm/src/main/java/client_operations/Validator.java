/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package client_operations;

/**
 *
 * @author Kasturi
 */
public class Validator {
    public String isEmailIdValidated(String emailid)
    {
        String result="perfect";
        if(emailid.isEmpty())
            result="Email ID is EMPTY.\nPlease Enter It.";
        else if(!emailid.contains(".") && !emailid.contains("@"))
            result=". and @ are MISSING in your Email ID.";
        else if(!emailid.contains("."))
            result=". is MISSING in your Email ID.";
        else if(!emailid.contains("@"))
            result="@ is MISSING in your Email ID.";
        else
            result="perfect";    
        return result;   
              
    }
    public String isMobileNoValidated(String mobile_no)
    {
        String result="perfect";
        if(mobile_no.isEmpty())
            result="Please Enter Mobile Number.";
        else if(mobile_no.length()!=10)
            result="Entered Mobile Number does not contain 10 digits.\nPlease Re-enter It.";
        else if(!isDigits(mobile_no))
            result="Entered Mobile Number does NOT Contains ALL Disgis";
        else 
            result="perfect";
        
            
        return result;        
    }
    boolean isDigits(String mobile_no)
    {
        boolean flag=false;
        try
        {
            Long.parseLong(mobile_no);
            flag=true;
        }
        catch(Exception ex)
        {
            System.out.println("Exception at class Validator in function isDigits() : "+ex);
        }
        return flag;
    }
}
