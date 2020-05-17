package POJOs;

public class Course {
    protected String courseID;
    protected String dept;//学院名称
    protected String courseName;
    public String courseDescription;
    protected float credit;

    public String getCourseID() {
        return courseID;
    }

    public void setCourseID(String courseiID) {
        this.courseID = courseID;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseDescription() {
        return courseDescription;
    }

    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }

    public float getCredit() {
        return credit;
    }

    public void setCredit(float credit) {
        this.credit = credit;
    }
}
