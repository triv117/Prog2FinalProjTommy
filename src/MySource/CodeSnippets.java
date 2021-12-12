package MySource;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class CodeSnippets {//Just using this file to store code I intend on using later.
    public void read(){
    ArrayList<Department> DeptList = new ArrayList<>();
        String pathStu = "E:\\\\Prog\\\\Student.txt";//To Change
        String pathTeach = "E:\\\\Prog\\\\Teacher.txt";//To Change
        String pathStaff = "E:\\\\Prog\\\\Staff.txt";//To Change
            try{
                RandomAccessFile fileStu = new RandomAccessFile(pathStu,"r");
                RandomAccessFile fileTeach = new RandomAccessFile(pathTeach,"r");
                RandomAccessFile fileStaff = new RandomAccessFile(pathStaff,"r");
                String str;
                
                while((str=fileStu.readLine()) != null){
                    String student[] = str.split(",");
                    Department test = new Department((Integer.parseInt(student[6])));//Lines 22-25 creates departments by comparing department ids in person lists. May or may not use.
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
                        }
                    }
                }
            }catch(FileNotFoundException ex){
                ex.getMessage();
            }catch(IOException ex){
                ex.getMessage();
            }
    }
}
            
