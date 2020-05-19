package DAO;

import POJOs.Classes;
import POJOs.YearAndTerm;
import java.util.List;

public interface ClassesMapper {
    public Classes getClassByID(int classesID);//按照ID查找Classes
    public List<Classes> getClassesByStudentID(int id);
    public List<Classes> getClassesByYearAndTerm(YearAndTerm yearAndTerm);//获得某一年某学期的所有课程
    public List<Classes> getCurrentClasses();//获得某一年某学期的所有课程
    public void createClassesTable(Classes classes);
    /*（第一步：从选课关系删除关系）
       退课事务第二部分
      （第三步：减少课程人数）
     */
    public void updateClassesTable(Classes classes);
    //public void deleteClasses(int classesID);
}
