package org.example;

public class EmplOsnov {
    private String surNamePatrn;
    private int workExpert;
    private int yearAdmis;
    private String post;
    public EmplOsnov(){
    }
    public void setSurNamePatrn (String surNamePatrn){
        this.surNamePatrn = surNamePatrn;
    }
    public void setWorkExpert (int workExpert){
        this.workExpert = workExpert;
    }
    public void setYearAdmis (int yearAdmis){
        this.yearAdmis = yearAdmis;
    }
    public void setPost (String post){
        this.post = post;
    }
    @Override
    public  String toString(){
        final StringBuilder sb =new StringBuilder("Employee{");
        sb.append("Name='").append(surNamePatrn).append('\'');
        sb.append(", Work experience='").append(workExpert).append('\'');
        sb.append(", Year of employment='").append(yearAdmis).append('\'');
        sb.append(", Aappointment='").append(post).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
