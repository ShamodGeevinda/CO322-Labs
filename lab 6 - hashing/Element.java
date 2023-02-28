
public class Element{   //creating the class entry 

    // attributes
    private int key;
    private String value;

    // constructor
    public Element(int key,String value){
        this.key=key;
        this.value=value;
    }

    // getters
    public int getKey(){
        return key;
    }

    public String getValue(){
        return value;
    }

}