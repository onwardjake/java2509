package ch12.sec03;

public class Student {
    private int id;
    private String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {return id;}
    public String getName() {return name;}

    @Override
    public int hashCode(){
        int hashCode = id + name.hashCode();
        return hashCode;
    }

    @Override
    public boolean equals(Object o){
        if(o instanceof Student target){
            if (id == target.id && name.equals(target.getName())) {
                return true;
            }
        }
        return false;
    }
}
