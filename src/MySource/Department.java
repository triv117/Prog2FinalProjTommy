package MySource;

import java.util.ArrayList;

public class Department {
    private int id;
    private String description;
    private Teacher dean;
    
    public ArrayList<Teacher> TeacherList = new ArrayList<>();
    public ArrayList<Student> StudentList = new ArrayList<>();
    public ArrayList<Staff> StaffList = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Teacher getDean() {
        return dean;
    }

    public void setDean(Teacher dean) {
        this.dean = dean;
    }
    
    public Department(){
    
    }
    

    public Department(int id){
        this.id = id;
    }
    
    public Department(int id, String description) {
        this.id = id;
        this.description = description;
    }
    
    public Department(int id, String description, Teacher dean) {
        this.id = id;
        this.description = description;
        this.dean = dean;
    }

    @Override
    public String toString() {
        return "Department{" + "id=" + id + ", description=" + description + ", dean=" + dean.getId() + '}';
    }
    
    public void assignTeacher(Teacher t){
        TeacherList.add(t);
    }
    
    public void assignStudent(Student s){
        StudentList.add(s);
    }
    
    public void assignStaff(Staff s){
        StaffList.add(s);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj){
        if(obj!=null){
            if(obj.getClass()==this.getClass()){
                Department dep = (Department) obj;
                return (dep.getId()==this.getId());
            }
        }
        return true;
    }
}
