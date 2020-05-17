package POJOs;

import java.time.Year;

public class Classes extends Course {
    private int classID;
    private Year year;
    private boolean term;
    private short maxSize;
    private short size;


    public int getClassID() {
        return classID;
    }

    public void setClassID(int classID) {
        this.classID = classID;
    }

    public Year getYear() {
        return year;
    }

    public void setYear(Year year) {
        this.year = year;
    }

    public boolean isTerm() {
        return term;
    }

    public void setTerm(boolean term) {
        this.term = term;
    }

    public short getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(short maxSize) {
        this.maxSize = maxSize;
    }

    public short getSize() {
        return size;
    }

    public void setSize(short size) {
        this.size = size;
    }
}
