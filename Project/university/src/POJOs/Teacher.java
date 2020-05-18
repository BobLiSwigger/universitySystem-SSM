package POJOs;

import java.util.List;

public class Teacher extends User {
    protected short level;
    protected float salary;
    protected String dept;
    public List<Classes> teachClass;

    //JavaBean Function
    public short getLevel() {
        return level;
    }
    public void setLevel(short level) {
        this.level = level;
    }
    public float getSalary() {
        return salary;
    }
    public void setSalary(float salary) {
        this.salary = salary;
    }
    public String getDept() {
        return dept;
    }
    public void setDept(String dept) {
        this.dept = dept;
    }
    public List<Classes> getTeachClass() {
        return teachClass;
    }
    public void setTeachClass(List<Classes> teachClass) {
        this.teachClass = teachClass;
    }


    //User defined Function
    public void teachClass(Classes cls){

    }
    public void openClass(Classes cls){

    }
    public void setAllAttribures(Teacher teacher){
        super.id = teacher.id;
        super.name = teacher.name;
        super.email = teacher.email;
        super.sex = teacher.sex;
        super.password = teacher.password;
        super.active = teacher.active;
        super.logInStatus = teacher.logInStatus;
        this.dept = teacher.dept;
        this.level = teacher.level;
        this.salary = teacher.salary;
        this.teachClass = teacher.teachClass;
    }
}
