package Services;

import DAO.StudentMapper;
import DAO.TeacherMapper;
import DAO.UserMapper;
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

    public User logIn(int id, String password) {
        /*------------------------------业务逻辑begin------------------------------*/
        User temp = studentMapper.getStudentById(id);
        if (temp != null){
            return temp;
        }
        //不是学生
        else{
            temp = teacherMapper.getTeacherById(id);
            if (temp != null){
                return temp;
            }
            //不是教师
            else{
                temp = userMapper.getUserById(id);
                if (temp != null){
                    return temp;
                }
            }
            //没有这个用户
            return new User();
        }
        /*------------------------------业务逻辑end------------------------------*/
    }
}
