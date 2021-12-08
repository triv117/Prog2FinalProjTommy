package MySource;

public class Staff extends Person implements PayRoll {
    private String duty;
    private int workload;
    private double salary;
    private int dept_id;

    public String getDuty() {
        return duty;
    }

    public void setDuty(String duty) {
        this.duty = duty;
    }

    public int getWorkload() {
        return workload;
    }

    public void setWorkload(int workload) {
        this.workload = workload;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
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
        return (32 *this.workload *2)*0.85;
    }

    @Override
    public String category() {
        return "Staff";
    }
    
    public Staff(int id, String name, int age, String gender, String duty, 
            int workload, int dept_id) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.duty = duty;
        this.workload = workload;
        this.dept_id = dept_id;
    }

    @Override
    public String toString() {
        return "Staff{" + "duty=" + duty + ", workload=" + workload + '}';
    }  
}
