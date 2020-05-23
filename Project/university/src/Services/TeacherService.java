package Services;

import POJOs.Classes;
import POJOs.Course;

import java.util.List;

public interface TeacherService {
    public boolean openNewCourse(Course course, int teacherID);
    public List<Classes> fetchTaughtClasses(int id);
}
