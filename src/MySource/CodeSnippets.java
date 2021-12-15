package MySource;

import java.io.*;
import java.util.*;
import java.time.*;
import java.time.format.*;

public class CodeSnippets {//Just using this file to store code I intend on using later.
    LocalDateTime getTime = LocalDateTime.now();
    DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    String DateTime = getTime.format(timeFormat);
    
    ArrayList<Department> DeptList = new ArrayList<>();
    
    ArrayList<Integer> IDList = new ArrayList<>();
    ArrayList<Teacher> TempTeachList = new ArrayList<>();
    ArrayList<Student> TempStuList = new ArrayList<>();
    ArrayList<Staff> TempStaffList = new ArrayList<>();
    
         
    public void readWrite(){
        String pathDeptRead = "C:\\\\Users\\\\TomRi\\\\Desktop\\\\FinalProject\\\\Prog2FinalProjTommy\\\\Department.txt";//To Change
        String pathStuRead = "C:\\\\Users\\\\TomRi\\\\Desktop\\\\FinalProject\\\\Prog2FinalProjTommy\\\\Student.txt";//To Change
        String pathTeachRead = "C:\\\\Users\\\\TomRi\\\\Desktop\\\\FinalProject\\\\Prog2FinalProjTommy\\\\Teacher.txt";//To Change
        String pathStaffRead = "C:\\\\Users\\\\TomRi\\\\Desktop\\\\FinalProject\\\\Prog2FinalProjTommy\\\\Staff.txt";//To Change

        String pathDeptWrite = "C:\\\\Users\\\\TomRi\\\\Desktop\\\\FinalProject\\\\Prog2FinalProjTommy\\\\Department "+DateTime+".txt";//To Change
        String pathStuWrite = "C:\\\\Users\\\\TomRi\\\\Desktop\\\\FinalProject\\\\Prog2FinalProjTommy\\\\Student "+DateTime+".txt";//To Change
        String pathTeachWrite = "C:\\\\Users\\\\TomRi\\\\Desktop\\\\FinalProject\\\\Prog2FinalProjTommy\\\\Teacher "+DateTime+".txt";//To Change        
        String pathStaffWrite = "C:\\\\Users\\\\TomRi\\\\Desktop\\\\FinalProject\\\\Prog2FinalProjTommy\\\\Staff "+DateTime+".txt";//To Change

        try{
            RandomAccessFile fileDept = new RandomAccessFile(pathDeptRead,"r");
            RandomAccessFile fileStu = new RandomAccessFile(pathStuRead,"r");
            RandomAccessFile fileTeach = new RandomAccessFile(pathTeachRead,"r");
            RandomAccessFile fileStaff = new RandomAccessFile(pathStaffRead,"r");
            String str;
                
            while((str=fileDept.readLine()) != null){
                String department[] = str.split(",");
                DeptList.add(new Department(Integer.parseInt(department[0]),department[1]));
                System.out.println("New Dept Created: " + Integer.parseInt(department[0]));
            
                String line = Integer.parseInt(department[0])+","+department[1]+"\n";
                write(line, pathDeptWrite);
                
                IDList.add(Integer.parseInt(department[0]));
            }

            while((str=fileStu.readLine()) != null){
                String student[] = str.split(",");
                Department test = new Department((Integer.parseInt(student[6])));
                if (DeptList.contains(test)==false){
                    throw new NullDepartmentException("Department ID '"+Integer.parseInt(student[6])+"' not found: ");
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
                        IDList.add(Integer.parseInt(student[0]));
                    }
                }           
            }
            
            while((str=fileTeach.readLine()) != null){
            String teacher[] = str.split(",");
                Department test = new Department((Integer.parseInt(teacher[6])));
                if (DeptList.contains(test)==false){
                    throw new NullDepartmentException("Department ID '"+Integer.parseInt(teacher[6])+"' not found: ");
                }
                for(Department d: DeptList){
                    if(d.getId()==(Integer.parseInt(teacher[6]))){
                        d.TeacherList.add(new Teacher(Integer.parseInt(teacher[0]),teacher[1]
                            ,Integer.parseInt(teacher[2]),teacher[3],teacher[4],
                            teacher[5], Integer.parseInt(teacher[6])));
                        System.out.println("New Teacher Created: " + Integer.parseInt(teacher[0]));
                               
                        for(Teacher te: d.TeacherList){
                            String line = te.id+","+te.name+","+te.age+","+te.gender+","+te.getSpecialty()
                                +","+te.getDegree()+","+te.getDept_id()+"\n";
                            write(line, pathTeachWrite);
                        }
                        IDList.add(Integer.parseInt(teacher[0]));
                    }
                }
            }
        
            while((str=fileStaff.readLine()) != null){
                String staff[] = str.split(",");
                Department test = new Department((Integer.parseInt(staff[6])));
                if (DeptList.contains(test)==false){
                    throw new NullDepartmentException("Department ID '"+Integer.parseInt(staff[6])+"' not found: ");
                }
                for(Department d: DeptList){
                    if(d.getId()==(Integer.parseInt(staff[6]))){
                        d.StaffList.add(new Staff(Integer.parseInt(staff[0]),staff[1]
                            ,Integer.parseInt(staff[2]),staff[3],staff[4],
                            Integer.parseInt(staff[5]), Integer.parseInt(staff[6])));
                        System.out.println("New Staff Created: " + Integer.parseInt(staff[0]));
                               
                        for(Staff stf: d.StaffList){
                            String line = stf.id+","+stf.name+","+stf.age+","+stf.gender+","+stf.getDuty()
                                +","+stf.getWorkload()+","+stf.getDept_id()+"\n";
                            write(line, pathStaffWrite);
                        }
                        IDList.add(Integer.parseInt(staff[0]));
                    }
                }
            }
        }catch(FileNotFoundException ex){
            ex.getMessage();
        }catch(IOException ex){
            ex.getMessage();
        }
    }
    
    public static void write(String data, String path) throws IOException{
        BufferedWriter writer = new BufferedWriter(new FileWriter(path, true));
        writer.write(data);
        writer.close();
    }

    public void newDept(int id, String desc, int deanId){
        Department newDept = new Department(id,desc);
        if (IDList.contains(id)){
            throw new IDIntegrityException("ID '"+id+"' is already in use");
        }
        Teacher test = new Teacher(deanId);
        if (TempTeachList.contains(test)==false){
            throw new NullDeanException("Dean '"+deanId+"' not found");
        }
        else{
            newDept.setDean(TempTeachList.get(TempTeachList.indexOf(test)));
            DeptList.add(newDept);
            IDList.add(id);
        }
    }

    public void newTeach(int id, String name, int age, String gender,
            String spec, String deg, int dept){
        Teacher newTeach = new Teacher(id,name,age,gender,spec,deg,dept);
        newTeach.setSalary(newTeach.computePayroll());
        if (IDList.contains(id)){
            throw new IDIntegrityException("ID '"+id+"' is already in use");
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
            throw new IDIntegrityException("ID '"+id+"' is already in use");
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
            throw new IDIntegrityException("ID '"+id+"' is already in use");
        }
        else{
            TempStaffList.add(newStaff);
            IDList.add(id);
        }
    }
}
            
