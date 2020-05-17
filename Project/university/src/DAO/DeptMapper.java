package DAO;

import POJOs.Course;
import POJOs.Dept;

import java.util.List;

public interface DeptMapper {
    public Dept getDeptByID(String deptID);
    public Dept getDeptByName(String name);
    public void createDept(Dept dept);
    public void updateDept(Dept dept);
    public List<Course> getRequiredCourse(String deptID);
    //public void deleteDeptByID(String id);
    //public void deleteDeptByName(String name);
}
