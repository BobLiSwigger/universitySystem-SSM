package POJOs;

public class User {
    //Table Attributes
    protected int id;
    protected String name;
    protected String email;
    protected boolean sex;//0为男，1为女
    protected String password;
    protected boolean active;

    //Class Attributes
    protected boolean logInStatus;

    public User(){
        this.id=0;
        this.name="";
        this.email="";
        this.sex=false;
        this.password="";
        this.active=true;
        this.logInStatus=false;
    }
    public void setId(int id){
        this.id=id;
    }
    public void setName(String name){
        this.name=name;
    }
    public void setPassword(String password){
        this.password=password;
    }
    public void setEmail(String email){
        this.email=email;
    }
    public void setSex(boolean sex){
        this.sex=sex;
    }
    public void setActive(boolean active){
        this.active=active;
    }
    public void setlogInStatus(boolean status){
        this.logInStatus=status;
    }

    public int getId(){
        return this.id;
    }
    public String getName(){
        return this.name;
    }
    public String getPassword(){
        return this.password;
    }
    public String getEmail(){
        return this.email;
    }
    public boolean getSex(){
        return this.sex;
    }
    public boolean getActive(){
        return this.active;
    }
    public boolean getlogInStatus(){
        return this.logInStatus;
    }

    public void setAllAttributes(User user){
        this.id = user.id;
        this.name = user.name;
        this.email = user.email;
        this.sex = user.sex;
        this.password = this.password;
        this.active = user.active;
        this.logInStatus = user.logInStatus;
    }
}
