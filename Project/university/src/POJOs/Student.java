package POJOs;

/**
 *
 * @author BobLi
 */
public class Student extends User{
    protected float credit;
    protected String dept;
    public void setCredit(float credit){
        this.credit=credit;
    }
    public void setDeptid(String dept){
        this.dept=dept;
    }
}
