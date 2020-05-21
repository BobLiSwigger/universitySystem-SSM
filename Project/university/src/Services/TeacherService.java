package Services;

import POJOs.Course;

public interface TeacherService {
    public boolean openNewCourse(Course course, int teacherID);
}
