package Services;

import POJOs.Classes;

import java.util.List;

public interface ClassService {
    public List<Classes> getCurrentClasses();
    public List<Classes> getAvailableClassesByID(int id);
}
