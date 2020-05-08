package POJOs;

public class User {
    protected int id;
    protected String name;
    protected String email;
    protected boolean sex;//0为男，1为女

    protected String password;
    protected boolean active;
    protected boolean status;

    public User(){
        this.id=0;
        this.name="";
        this.email="";
        this.sex=false;
        this.password="";
        this.active=false;
        this.status=false;
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
    public void setStatus(boolean status){
        this.status=status;
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
    public boolean getStatus(){
        return this.status;
    }
}
