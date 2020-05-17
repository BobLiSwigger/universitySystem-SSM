package POJOs;

import java.util.List;

public class Dept {
    //Table Attributes
    private String deptID;
    private String name;

    //Class Attributes
    public List<Course> requiredCourse;

    //JavaBean Functions
    public String getDeptID() {
        return deptID;
    }
    public void setDeptID(String deptID) {
        this.deptID = deptID;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public List<Course> getRequiredCourse() {
        return requiredCourse;
    }
    public void setRequiredCourse(List<Course> requiredCourse) {
        this.requiredCourse = requiredCourse;
    }
}
