package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Sdetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String Sname;
    private String result;
    private int maths;
    private int science;
    private int english;
    private String remarks;
    private String division;

    // Constructors

    public Sdetails(int id, String Sname, String result, int maths, int science, int english, String remarks, String division) {
        this.id = id;
        this.Sname = Sname;
        this.result = result;
        this.maths = maths;
        this.science = science;
        this.english = english;
        this.remarks = remarks;
        this.division = division;
    }

    public Sdetails() {
    }

   

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSname() {
        return Sname;
    }

    public void setSname(String Sname) {
        this.Sname = Sname;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public int getMaths() {
        return maths;
    }

    public void setMaths(int maths) {
        this.maths = maths;
    }

    public int getScience() {
        return science;
    }

    public void setScience(int science) {
        this.science = science;
    }

    public int getEnglish() {
        return english;
    }

    public void setEnglish(int english) {
        this.english = english;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

   

    @Override
    public String toString() {
        return "Sdetails [id=" + id + ", Sname=" + Sname + ", result=" + result + ", maths=" + maths + ", science=" + science
                + ", english=" + english + ", remarks=" + remarks + ", division=" + division + "]";
    }

  

    public boolean isPresent() {
       
        return false;
    }
}

