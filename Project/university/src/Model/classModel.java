package Model;

import POJOs.Classes;
import POJOs.Teacher;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;

public class classModel {
    public int classID;
    public List<String> teacherNames;
    public String courseID;
    public String courseName;
    public Year year;
    public String term;
    public String deptName;
    public float credit;
    public short maxSize;
    public short size;

    classModel(Classes classes){
        this.classID=classes.getClassID();
        List<Teacher> Teachers = classes.getTeachers();
        this.teacherNames = new ArrayList<String>();
        for (Teacher teacher : Teachers){
                this.teacherNames.add(teacher.getName());
        }
        this.courseID=classes.getCourseID();
        this.courseName=classes.getCourseName();
        this.year=classes.getYear();
        if (classes.getTerm()){
            this.term="秋季";
        }
        else{
            this.term="春季";
        }
        this.deptName=classes.getDept().getName();
        this.credit=classes.getCredit();
        this.maxSize=classes.getMaxSize();
        this.size=classes.getSize();
    }
}
