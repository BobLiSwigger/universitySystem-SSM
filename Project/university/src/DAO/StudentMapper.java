package DAO;

import POJOs.ClassAndUser;
import POJOs.Classes;
import POJOs.Student;

import java.util.List;

public interface StudentMapper {
    Student getStudentById(int id);
    void createStudent(Student student);

    /*（第一步：从选课关系删除关系）
      （第二步：退课事务第二部分）
      退课事务第三部分
     */
    void updateStudent(Student student);
    List<Classes> getTakenClasses(int id);

    //选课存储过程
    public void chooseClassProcedure(ClassAndUser classAndUser);

    void dropOutClass(ClassAndUser classAndUser);//从选课关系删除关系

    //void deleteStudent(int id);
}
