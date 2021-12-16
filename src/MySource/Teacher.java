package MySource;

public class Teacher extends Person implements PayRoll {
    private String specialty;
    private String degree;
    private double salary;
    private int dept_id;

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getDept_id() {
        return dept_id;
    }

    public void setDept_id(int dept_id) {
        this.dept_id = dept_id;
    }
    
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

    @Override
    public double computePayroll() {
        double saldegree=0;
        String bach = "bachelors";
        String master = "master";
        String phd = "phd";
                
        if(degree.equals(bach)){
            saldegree = 42;
        }
        else if(degree.equals(master)){
            saldegree = 82;
        }
        else if(degree.equals(phd)){
            saldegree = 112;
        }
        return (36 *saldegree *2)*0.76;
    }

    @Override
    public String category() {
        return "Teacher";
    }
    
    public Teacher(){
        
    }
    
    public Teacher(int id){
        this.id = id;
    }
    
    public Teacher(int id, String name, int age, String gender,
            String specialty, String degree, int dept_id) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.specialty = specialty; 
        this.degree = degree;
        this.dept_id = dept_id;
    }

    @Override
    public String toString() {
        return "Teacher{id=" +id+", name="+name+", age="+age+", gender="+gender+
                ", specialty=" + specialty + ", degree=" + degree + '}';
    }
    
    @Override
    public boolean equals(Object obj){
        if(obj!=null){
            if(obj.getClass()==this.getClass()){
                Teacher teach = (Teacher) obj;
                return (teach.getId()==this.getId());
            }
        }
        return true;
    }
}
