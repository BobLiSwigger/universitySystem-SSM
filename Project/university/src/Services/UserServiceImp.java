package Services;

import DAO.StudentMapper;
import DAO.TeacherMapper;
import DAO.UserMapper;
import POJOs.Student;
import POJOs.Teacher;
import POJOs.User;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.ContextLoader;


public class UserServiceImp implements UserService{
    UserMapper userMapper;
    StudentMapper studentMapper;
    TeacherMapper teacherMapper;
    ApplicationContext context;
    UserServiceImp(){
        this.context = ContextLoader.getCurrentWebApplicationContext();
        this.userMapper = (UserMapper)context.getBean("userMapper");
        this.studentMapper = (StudentMapper) context.getBean("studentMapper");
        this.teacherMapper = (TeacherMapper)context.getBean("teacherMapper");
    }

    public String logIn(int id, String password) {
        /*------------------------------业务逻辑begin------------------------------*/
        Student student = studentMapper.getStudentById(id);

        if (student != null){
            Student logInStudent = (Student)context.getBean("logInStudent");
            logInStudent.setAllAttribures(student);
            return "student";
        }
        //不是学生
        else{
            Teacher teacher = teacherMapper.getTeacherById(id);
            if (teacher != null){
                Teacher logInTeacher = (Teacher)context.getBean("logInTeacher");
                logInTeacher.setAllAttribures(teacher);
                System.out.println("ID: "+teacher.getId()+" teacher just logged in.");
                System.out.println("Dept: "+logInTeacher.getDept()+", level: "+logInTeacher.getLevel()+", Salary: "+ logInTeacher.getSalary());
                return "teacher";
            }
            //不是教师
            else{
                User user = userMapper.getUserById(id);
                if (user != null){
                    User logInUser = (User)context.getBean("logInUser");
                    logInUser.setAllAttributes(user);
                    System.out.println("ID: "+logInUser.getId()+" user just logged in.");
                    return "user";
                }
            }
            return "failure";
        }
        /*------------------------------业务逻辑end------------------------------*/
    }
}
