package com.mislbd.testautomation.model;

/**
 * Created by Ziaur Rahaman on 24-Sep-18.
 */
public class LoginModel {

        private String emailAddress;
        private String password ;

        public LoginModel(String emailAddress, String password) {
        	
        	this.emailAddress = emailAddress;
            this.password = password ;
            
        }
        
        public LoginModel(){
        }

    public String getEmailAddress() {
            return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
            this.emailAddress = emailAddress;
    }

    public String getPassword() {
            return password;
    }

    public void setPassword(String password) {
            this.password = password;
    }
}
