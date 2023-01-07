package com.example.tics;

public class Variable {
    private String studentName,studentID,classID;

    public Variable(String studentName,String studentID,String classID)
    {
        this.setStudentName(studentName);
        this.setStudentID(studentID);
        this.setClassID(classID);
    }

    public String getStudentName() {
        return studentName;
    }

    public String getClassID() {
        return classID;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setClassID(String classID) {
        this.classID = classID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
}
