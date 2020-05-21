package Services;

import DAO.ClassesMapper;
import POJOs.Classes;
import POJOs.GlobalValues;
import POJOs.YearAndTerm;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.ContextLoader;

import java.util.List;

public class ClassServiceImp implements ClassService {
    ApplicationContext context;
    ClassesMapper classesMapper;
    GlobalValues globalValues;
    ClassServiceImp(){
        this.context = ContextLoader.getCurrentWebApplicationContext();
        this.classesMapper = (ClassesMapper)context.getBean("classesMapper");
        this.globalValues = (GlobalValues)context.getBean("globalValues");
    }
    @Override
    public List<Classes> getCurrentClasses() {
        //YearAndTerm yearAndTerm = new YearAndTerm();
        //yearAndTerm.setYear(this.globalValues.getAvailableChooseYear());
        //yearAndTerm.setTerm(this.globalValues.getPresentTerm());
        //return classesMapper.getClassesByYearAndTerm(yearAndTerm);
        return classesMapper.getCurrentClasses();
    }
    @Override
    public List<Classes> getAvailableClassesByID(int id) {
        return classesMapper.getAvailableClassesByID(id);
    }
}
