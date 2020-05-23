package Services;

import POJOs.Classes;
import POJOs.User;
import POJOs.Student;

import java.util.List;

public interface StudentService {
    public String chooseClass(int studentID, int classID);
    public boolean dropOutClass(int studentID, int classID);
    public List<Classes> fetchTakenClasses(int id);
}
