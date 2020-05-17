package POJOs;

import java.util.List;

/**
 *
 * @author BobLi
 */
public class Student extends User{
    //Table Attributes
    protected float credit;//该学生所修学分
    protected String dept;//该学生所属学院

    //Class Attributes
    public List<Classes> tokenclasses;//该学生上过的课程

    //setFunction
    public void setTokenclasses(List<Classes> tokenclasses){
        this.tokenclasses = tokenclasses;
    }
    public void setCredit(float credit){
        this.credit=credit;
    }
    public void setDeptid(String dept){
        this.dept=dept;
    }

    //getFunction
    public float getCredit(){
        return  this.credit;
    }
    public String getDept(){
        return this.dept;
    }
    public List<Classes> getTokenclasses(){
        return this.tokenclasses;
    }
}
