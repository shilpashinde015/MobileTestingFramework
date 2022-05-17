package Mock;

public class Customer {
    private String name;
    private String pass;
    private int id ;
    public Customer(int id,String name,String pass) {
        this.id = id;
        this.name = name;
        this.pass = pass;
    }

    public String getName() {
        return name;
    }
    public String getPass(){
        return pass;
    }
    public int getId(){
        return id;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setPass(String pass){
        this.pass = pass;
    }
    public void setId(int id){
        this.id = id;
    }

}
