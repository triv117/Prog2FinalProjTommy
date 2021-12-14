package MySource;

import java.io.*;
import java.util.*;
import java.time.*;
import java.time.format.*;

public class CodeSnippets {//Just using this file to store code I intend on using later.
    LocalDateTime getTime = LocalDateTime.now();
    DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    String DateTime = getTime.format(timeFormat);
        
    public void read(){
        ArrayList<Department> DeptList = new ArrayList<>();
            String pathStuRead = "E:\\\\Prog\\\\Student.txt";//To Change
            String pathTeachRead = "E:\\\\Prog\\\\Teacher.txt";//To Change
            String pathStaffRead = "E:\\\\Prog\\\\Staff.txt";//To Change

            String pathStuWrite = "E:\\\\Prog\\\\Student "+DateTime+".txt";//To Change
            String pathTeachWrite = "E:\\\\Prog\\\\Teacher "+DateTime+".txt";//To Change        
            String pathStaffWrite = "E:\\\\Prog\\\\Staff "+DateTime+".txt";//To Change

                try{
                    RandomAccessFile fileStu = new RandomAccessFile(pathStuRead,"r");
                    RandomAccessFile fileTeach = new RandomAccessFile(pathTeachRead,"r");
                    RandomAccessFile fileStaff = new RandomAccessFile(pathStaffRead,"r");
                    String str;

                    while((str=fileStu.readLine()) != null){
                        String student[] = str.split(",");
                        Department test = new Department((Integer.parseInt(student[6])));//Lines 31-35 creates departments by comparing department ids in person lists. May or may not use.
                        if (DeptList.contains(test)==false){
                            DeptList.add(test);
                            System.out.println("New Dept Created: " + Integer.parseInt(student[6]));
                        }
                        for(Department d: DeptList){
                            if(d.getId()==(Integer.parseInt(student[6]))){
                               d.StudentList.add(new Student(Integer.parseInt(student[0]),student[1]
                                ,Integer.parseInt(student[2]),student[3],student[4],
                                Integer.parseInt(student[5]), Integer.parseInt(student[6])));
                               System.out.println("New Student Created: " + Integer.parseInt(student[0]));
                               
                               for(Student st: d.StudentList){
                                    String line = st.id+","+st.name+","+st.age+","+st.gender+","+st.getCourse()
                                            +","+st.getSemester()+","+st.getDept_id()+"\n";
                                    write(line, pathStuWrite);
                                }
                            }
                        }
                        
                    }
                    while((str=fileTeach.readLine()) != null){
                        String teacher[] = str.split(",");
                        Department test = new Department((Integer.parseInt(teacher[6])));//See Mesage above
                        if (DeptList.contains(test)==false){
                            DeptList.add(test);
                            System.out.println("New Dept Created: " + Integer.parseInt(teacher[6]));
                        }
                        for(Department d: DeptList){
                            if(d.getId()==(Integer.parseInt(teacher[6]))){
                               d.TeacherList.add(new Teacher(Integer.parseInt(teacher[0]),teacher[1]
                                ,Integer.parseInt(teacher[2]),teacher[3],teacher[4],
                                teacher[5], Integer.parseInt(teacher[6])));
                               System.out.println("New Teacher Created: " + Integer.parseInt(teacher[0]));
                               
                               for(Teacher st: d.TeacherList){
                                    String line = st.id+","+st.name+","+st.age+","+st.gender+","+st.getSpecialty()
                                            +","+st.getDegree()+","+st.getDept_id()+"\n";
                                    write(line, pathTeachWrite);
                                }
                            }
                        }
                    }
                    while((str=fileStaff.readLine()) != null){
                        String staff[] = str.split(",");
                        Department test = new Department((Integer.parseInt(staff[6])));//See Mesage above
                        if (DeptList.contains(test)==false){
                            DeptList.add(test);
                            System.out.println("New Dept Created: " + Integer.parseInt(staff[6]));
                        }
                        for(Department d: DeptList){
                            if(d.getId()==(Integer.parseInt(staff[6]))){
                               d.StaffList.add(new Staff(Integer.parseInt(staff[0]),staff[1]
                                ,Integer.parseInt(staff[2]),staff[3],staff[4],
                                Integer.parseInt(staff[5]), Integer.parseInt(staff[6])));
                               System.out.println("New Staff Created: " + Integer.parseInt(staff[0]));
                               
                               for(Staff st: d.StaffList){
                                    String line = st.id+","+st.name+","+st.age+","+st.gender+","+st.getDuty()
                                            +","+st.getWorkload()+","+st.getDept_id()+"\n";
                                    write(line, pathStaffWrite);
                                }
                            }
                        }
                    }

                }catch(FileNotFoundException ex){
                    ex.getMessage();
                }catch(IOException ex){
                    ex.getMessage();
                }
        }
    
    public void write(String data, String path) throws IOException{
        BufferedWriter writer = new BufferedWriter(new FileWriter(path, true));
        writer.write(data);
        writer.close();
    }

    ArrayList<Integer> IDList = new ArrayList<>();
    ArrayList<Teacher> TempTeachList = new ArrayList<>();
    ArrayList<Student> TempStuList = new ArrayList<>();
    ArrayList<Staff> TempStaffList = new ArrayList<>();

    public void newTeach(int id, String name, int age, String gender,
            String spec, String deg, int dept){
        Teacher newTeach = new Teacher(id,name,age,gender,spec,deg,dept);
        newTeach.setSalary(newTeach.computePayroll());
        if (IDList.contains(id)){

        }
        else{
            TempTeachList.add(newTeach);
            IDList.add(id);
        }
    }

    public void newStu(int id, String name, int age, String gender,
            String course, int sem, int dept){
        Student newStu = new Student(id,name,age,gender,course,sem,dept);
        if (IDList.contains(id)){

        }
        else{
            TempStuList.add(newStu);
            IDList.add(id);
        }
    }

    public void newStaff(int id, String name, int age, String gender,
            String duty, int wload, int dept){
        Staff newStaff = new Staff(id,name,age,gender,duty,wload,dept);
        newStaff.setSalary(newStaff.computePayroll());
        if (IDList.contains(id)){

        }
        else{
            TempStaffList.add(newStaff);
            IDList.add(id);
        }
    }
}
            
