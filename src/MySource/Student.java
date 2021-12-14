package MySource;

public class Student extends Person{
    private String course;
    private int semester;
    private int dept_id;

    @Override
    public void setGender(String gender) {
        super.setGender(gender); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getGender() {
        return super.getGender(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setAge(int age) {
        super.setAge(age); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getAge() {
        return super.getAge(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setName(String name) {
        super.setName(name); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getName() {
        return super.getName(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setId(int id) {
        super.setId(id); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getId() {
        return super.getId(); //To change body of generated methods, choose Tools | Templates.
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public int getDept_id() {
        return dept_id;
    }

    public void setDept_id(int dept_id) {
        this.dept_id = dept_id;
    }
    
    
    
    @Override
    public String category() {
        return "Student";
    }
    
    public Student(int id, String name, int age, String gender, String course, 
            int semester, int dept_id) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.course = course; 
        this.semester = semester;
        this.dept_id = dept_id;
    }

    @Override
    public String toString() {
        return "Student{" + "course=" + course + ", semester=" + semester + '}';
    }
}
