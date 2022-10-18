package com.mislbd.testautomation.util;

import org.openqa.selenium.WebElement;
import javax.swing.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationUtils {

    public static void isNull(String value, String fieldName){

        if(value == null) {
            JOptionPane.showMessageDialog(null, fieldName + " is required");
        }
    }

    public static void numberLengthCheck(WebElement element){

       String getNumber = element.getAttribute("value");
       int length = getNumber.length();

        if(length != 11)
        {
            JOptionPane.showMessageDialog(null,"Minimum length of Number is 11");
        }
    }

    public static void addressLineLengthCheck(WebElement element){

        String getAddressLine = element.getAttribute("value");
        int length = getAddressLine.length();

        if(length<3 || length>50)
        {
            JOptionPane.showMessageDialog(null,"Address Line should be in between 3 to 50 Characters");
        }
    }

    public static void nameCheck(WebElement element){

        String getName = element.getAttribute("value");
        int length = getName.length();
        String regex = "^[a-zA-Z ]+$" ;
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(getName);

        if(length<2 || length>50)
        {
            JOptionPane.showMessageDialog(null,"Name should be in between 2 to 50 Characters");
        }

        if(matcher.matches() == false )
        {
            JOptionPane.showMessageDialog(null,"Name format is Invalid. Name should be in letters only");
        }
    }

    public static void nameFormatCheck(WebElement element){

        String getName = element.getAttribute("value");
        String regex = "^[a-zA-Z0-9_ ]*$" ;
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(getName);

        if(matcher.matches() == false )
        {
            JOptionPane.showMessageDialog(null,"Name format is Invalid. Name should be in letters only");
        }
    }

    public static void emailFormatCheck(WebElement element){

        String getEmail = element.getAttribute("value");
        String regex = "^[^@]+@[a-zA-Z0-9]+?\\.[a-zA-Z]{2,}$" ;
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(getEmail);

        if(matcher.matches() == false )
        {
            JOptionPane.showMessageDialog(null,"Email format is Invalid");
        }
    }
}
