package POJOs;

import java.sql.Time;
import java.time.Year;
import java.util.Calendar;
import java.util.Date;

public class GlobalValues {
    private Year presentYear;
    private boolean presentTerm;
    private Year availableChooseYear;

    public Year getPresentYear() {
        return presentYear;
    }

    public void setPresentYear(Year presentYear) {
        this.presentYear = presentYear;
    }

    public boolean getPresentTerm() {
        return presentTerm;
    }

    public void setPresentTerm(boolean presentTerm) {
        this.presentTerm = presentTerm;
    }

    public Year getAvailableChooseYear() {
        return availableChooseYear;
    }

    public void setAvailableChooseYear(Year availableChooseYear) {
        this.availableChooseYear = availableChooseYear;
    }

    public boolean getAvailableChooseTerm() {
        return availableChooseTerm;
    }

    public void setAvailableChooseTerm(boolean availableChooseTerm) {
        this.availableChooseTerm = availableChooseTerm;
    }

    private boolean availableChooseTerm;
    GlobalValues(){
        this.presentYear = Year.now();
        this.presentTerm = false;
        this.availableChooseYear = Year.now();
        this.availableChooseTerm = false;
    }


}
