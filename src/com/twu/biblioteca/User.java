package com.twu.biblioteca;

public class User {
    private String name;
    private String email;
    private int phone;
    private String libraryCode;
    private String password;

    public User() {

    }

    public User(String name, String email, int phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public boolean isLoggetIn() {
        if (isCodeFilled() && isPasswordFilled()) return true;
        return false;
    }

    private boolean isCodeFilled(){
        if (hasCodeValue() && !isCodeEmpty())return true;
        return false;
    }

    private boolean isPasswordFilled(){
        if (hasPasswordValue() && !isPasswordEmpty())return true;
        return false;
    }

    private boolean hasCodeValue(){
        if(this.libraryCode != null)return true;
        return false;
    }

    private boolean hasPasswordValue(){
        if(this.password != null)return true;
        return false;
    }

    private boolean isCodeEmpty() {
        if (this.libraryCode.length() < 1)return true ;
        return false;
    }

    private boolean isPasswordEmpty() {
        if (this.password.length() < 1)return true ;
        return false;
    }

    public void login(String libraryCode, String password){
        this.libraryCode = libraryCode;
        this.password = password;
    }

    public void logout(){
        this.libraryCode = null;
        this.password = null;
    }

    @Override
    public String toString() {
        return "Name: " + name + "\nEmail: " + email + "\nPhone: " + phone;
    }
}
