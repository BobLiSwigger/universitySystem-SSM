package Services;

import DAO.StudentMapper;
import POJOs.Student;
import POJOs.User;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.ContextLoader;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class StudentServiceImp implements StudentService {
    //ApplicationContext context;
    //tudentMapper studentMapper;
    //User user;

    @Override
    public boolean chooseClass(int studentID, int classID) {
        return false;
    }
}
