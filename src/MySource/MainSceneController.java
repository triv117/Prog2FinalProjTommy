package MySource;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class MainSceneController implements Initializable {
    //Lists
    public static ObservableList<Department> DeptList = FXCollections.observableArrayList();
    public static ObservableList<Teacher> TempTeachList = FXCollections.observableArrayList();
    public static ObservableList<Student> oStudentList = FXCollections.observableArrayList();
    public static ObservableList<Teacher> oTeacherList = FXCollections.observableArrayList();
    public static ObservableList<Staff> oStaffList = FXCollections.observableArrayList();
    
    //To ensure ID integrity
    public static ArrayList<Integer> IDList = new ArrayList<>();
    
    //Declaring FXML 
    @FXML
    private Button deptAddBtn;
    @FXML
    private Button deptDelBtn;
    @FXML
    private Button deptModBtn;
    @FXML
    private Button stuAddBtn;
    @FXML
    private Button stuDelBtn;
    @FXML
    private Button stuModBtn;
    @FXML
    private Button teachAddBtn;
    @FXML
    private Button teachDelBtn;
    @FXML
    private Button teachModBtn;
    @FXML
    private Button stfAddBtn;
    @FXML
    private Button stfDelBtn;
    @FXML
    private Button stfModBtn;
    @FXML
    private TableView<Department> deptTable;
    @FXML
    private TableColumn<Department, Integer> deptIDCol;
    @FXML
    private TableColumn<Department, String> deptDescCol;
    @FXML
    private TableColumn<Department, Integer> deptDeanCol;
    @FXML
    private TextField stuViewField;
    @FXML
    private Button stuViewBtn;
    @FXML
    private Button teachViewBtn;
    @FXML
    private Button stfViewBtn;
    @FXML
    private TextField searchField;
    @FXML
    private Button searchBtn;
    @FXML
    private Button deptLoadBtn;
    @FXML
    private Button deptRefreshBtn;
    @FXML
    private TextField deptSetIDField;
    @FXML
    private TextField deptSetDescField;
    @FXML
    private TextField deptSetDeanField;
    @FXML
    private Button deptCreateBtn;
    @FXML
    private TextField stuSetIDField;
    @FXML
    private TextField stuSetNameField;
    @FXML
    private TextField stuSetAgeField;
    @FXML
    private TextField stuSetGenderField;
    @FXML
    private TextField stuSetCourseField;
    @FXML
    private TextField stuSetSemesterField;
    @FXML
    private TextField stuSetDeptIDField;
    @FXML
    private Button stuCreateBtn;
    @FXML
    private TextField teachSetIDField;
    @FXML
    private TextField teachSetNameField;
    @FXML
    private TextField teachSetAgeField;
    @FXML
    private TextField teachSetGenderField;
    @FXML
    private TextField teachSetSpecField;
    @FXML
    private TextField teachSetDegField;
    @FXML
    private TextField teachSetDeptIDField;
    @FXML
    private Button teachCreateBtn;
    @FXML
    private TextField stfSetIDField;
    @FXML
    private TextField stfSetNameField;
    @FXML
    private TextField stfSetAgeField;
    @FXML
    private TextField stfSetGenderField;
    @FXML
    private TextField stfSetDutyField;
    @FXML
    private TextField stfSetWLField;
    @FXML
    private TextField stfSetDeptIDField;
    @FXML
    private Button stfCreateBtn;
    @FXML
    private TextField deptDelField;
    @FXML
    private Button deptDelBtn2;
    @FXML
    private TextField stuDelField;
    @FXML
    private Button stuDelBtn2;
    @FXML
    private TextField teachDelField;
    @FXML
    private Button teachDelBtn2;
    @FXML
    private TextField stfDelField;
    @FXML
    private Button stfDelBtn2;
    @FXML
    private TextField deptModIDField;
    @FXML
    private TextField deptModDescField;
    @FXML
    private TextField deptModDeanField;
    @FXML
    private Button deptModBtn2;
    @FXML
    private TextField stuModIDField;
    @FXML
    private TextField stuModNameField;
    @FXML
    private TextField stuModAgeField;
    @FXML
    private TextField stuModGenderField;
    @FXML
    private TextField stuModCourseField;
    @FXML
    private TextField stuModSemesterField;
    @FXML
    private Button stuModBtn2;
    @FXML
    private TextField teachModIDField;
    @FXML
    private TextField teachModNameField;
    @FXML
    private TextField teachModAgeField;
    @FXML
    private TextField teachModGenderField;
    @FXML
    private TextField teachModSpecField;
    @FXML
    private TextField teachModDegField;
    @FXML
    private Button teachModBtn2;
    @FXML
    private TextField stfModIDField;
    @FXML
    private TextField stfModNameField;
    @FXML
    private TextField stfModAgeField;
    @FXML
    private TextField stfModGenderField;
    @FXML
    private TextField stfModDutyField;
    @FXML
    private TextField stfModWorkField;
    @FXML
    private Button stfModBtn2;
    @FXML
    private TableView<Student> stuTbl;
    @FXML
    private TableColumn<Student, Integer> stuIDCol;
    @FXML
    private TableColumn<Student, String> stuNameCol;
    @FXML
    private TableColumn<Student, Integer> stuAgeCol;
    @FXML
    private TableColumn<Student, String> stuGenderCol;
    @FXML
    private TableColumn<Student, String> stuCourseCol;
    @FXML
    private TableColumn<Student, Integer> stuSemesterCol;
    @FXML
    private Button stuMenuBtn;
    @FXML
    private Button stuLoadBtn;
    @FXML
    private TableView<Teacher> teachTbl;
    @FXML
    private TableColumn<Teacher, Integer> teachIDCol;
    @FXML
    private TableColumn<Teacher, String> teachNameCol;
    @FXML
    private TableColumn<Teacher, Integer> teachAgeCol;
    @FXML
    private TableColumn<Teacher, String> teachGenderCol;
    @FXML
    private TableColumn<Teacher, String> teachSpecCol;
    @FXML
    private TableColumn<Teacher, String> teachDegCol;
    @FXML
    private Button teachMenuBtn;
    @FXML
    private Button teachLoadBtn;
    @FXML
    private TableView<Staff> stfTbl;
    @FXML
    private TableColumn<Staff, Integer> stfIDCol;
    @FXML
    private TableColumn<Staff, String> stfNameCol;
    @FXML
    private TableColumn<Staff, Integer> stfAgeCol;
    @FXML
    private TableColumn<Staff, String> stfGenderCol;
    @FXML
    private TableColumn<Staff, String> stfDutyCol;
    @FXML
    private TableColumn<Staff, Integer> stfWorkCol;
    @FXML
    private Button stfMenuBtn;
    @FXML
    private Button stfLoadBtn;
    @FXML
    private TextField stfViewField;
    @FXML 
    private TextField teachViewField;
    @FXML
    private Button SearchBtn;
    @FXML
    private TextField SearchField;
    @FXML
    private Button saveBtn;
    
    //Reading and Writing
    static int load = 0;//Used to track the number of times the data is loaded from the text file
    
    public void load(ActionEvent event){//Loads form text files, creates new file, displays departments in MainScene's table
        if (load>0){//Stops user form loading from the file more than once
            throw new IDIntegrityException("Only load the data once!");
        }
        String pathDeptRead = "C:\\\\Users\\\\TomRi\\\\Desktop\\\\FinalProject\\\\Prog2FinalProjTommy\\\\Department.txt";//To Change
        String pathStuRead = "C:\\\\Users\\\\TomRi\\\\Desktop\\\\FinalProject\\\\Prog2FinalProjTommy\\\\Student.txt";//To Change
        String pathTeachRead = "C:\\\\Users\\\\TomRi\\\\Desktop\\\\FinalProject\\\\Prog2FinalProjTommy\\\\Teacher.txt";//To Change
        String pathStaffRead = "C:\\\\Users\\\\TomRi\\\\Desktop\\\\FinalProject\\\\Prog2FinalProjTommy\\\\Staff.txt";//To Change
        
        try{
            RandomAccessFile fileDept = new RandomAccessFile(pathDeptRead,"r");
            RandomAccessFile fileStu = new RandomAccessFile(pathStuRead,"r");
            RandomAccessFile fileTeach = new RandomAccessFile(pathTeachRead,"r");
            RandomAccessFile fileStaff = new RandomAccessFile(pathStaffRead,"r");
            String str;
            //Reading from Department
            while((str=fileDept.readLine()) != null){
                String department[] = str.split(",");
                DeptList.add(new Department(Integer.parseInt(department[0]),department[1]));
                DeptList.get(DeptList.size()-1).setDean(new Teacher(Integer.parseInt(department[2])));
                System.out.println("New Dept Created: " + Integer.parseInt(department[0]));
                IDList.add(Integer.parseInt(department[0]));
            }
            //Reading from Student
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
                        IDList.add(Integer.parseInt(student[0]));
                    }
                }           
            }
            //Reading from Teacher
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
                        IDList.add(Integer.parseInt(teacher[0]));
                    }
                }
            }
            //Reading from Staff
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
                        IDList.add(Integer.parseInt(staff[0]));
                    }
                }
            }
            load++;
            displayDeptList(DeptList);
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
    
    public void save(ActionEvent event) throws IOException{
        String pathDeptWrite = "C:\\\\Users\\\\TomRi\\\\Desktop\\\\FinalProject\\\\Prog2FinalProjTommy\\\\NewDepartment.txt";//To Change
        String pathStuWrite = "C:\\\\Users\\\\TomRi\\\\Desktop\\\\FinalProject\\\\Prog2FinalProjTommy\\\\NewStudent.txt";//To Change
        String pathTeachWrite = "C:\\\\Users\\\\TomRi\\\\Desktop\\\\FinalProject\\\\Prog2FinalProjTommy\\\\NewTeacher.txt";//To Change        
        String pathStaffWrite = "C:\\\\Users\\\\TomRi\\\\Desktop\\\\FinalProject\\\\Prog2FinalProjTommy\\\\NewStaff.txt";//To Change

        for(Department d: DeptList){
            //Writing Departments
            String deptline = d.getId()+","+d.getDescription()+","+d.getDean()+"\n";
            write(deptline, pathDeptWrite);
            for(Staff stf: d.StaffList){//Writing Staff
                String line = stf.id+","+stf.name+","+stf.age+","+stf.gender+","+stf.getDuty()
                    +","+stf.getWorkload()+","+stf.getDept_id()+"\n";
                write(line, pathStaffWrite);
            }
            for(Teacher te: d.TeacherList){//Writing Teachers
                String line = te.id+","+te.name+","+te.age+","+te.gender+","+te.getSpecialty()
                    +","+te.getDegree()+","+te.getDept_id()+"\n";
                write(line, pathTeachWrite);
            }
            for(Student st: d.StudentList){//Writing Students
                String line = st.id+","+st.name+","+st.age+","+st.gender+","+st.getCourse()
                    +","+st.getSemester()+","+st.getDept_id()+"\n";
                write(line, pathStuWrite);
            }
        }
    }
    
    //Department Functions
    @FXML
    public void addDeptartment(ActionEvent event) throws IOException{
        boolean contains = true;
        Department newDept = new Department(Integer.parseInt(deptSetIDField.getText()),
                deptSetDescField.getText());
        if (IDList.contains(Integer.parseInt(deptSetIDField.getText()))==true){
            throw new IDIntegrityException("ID '"+Integer.parseInt(deptSetIDField.getText())+"' is already in use");
        }
        if (deptSetDeanField.getText().trim().isEmpty()==true){
            throw new NullDeanException("Dean required to create department!");
        }
        for(int i = 0; i<TempTeachList.size(); i++){
            if(TempTeachList.get(i).getId()==Integer.parseInt(deptSetDeanField.getText())){
                newDept.setDean(TempTeachList.get(i));
                newDept.TeacherList.add(TempTeachList.get(i));
                contains = true;
            }
        }
        if(contains==false){
            throw new NullFieldException("Invalid Teacher ID!");
        }
        DeptList.add(newDept);
        IDList.add(Integer.parseInt(deptSetIDField.getText()));
        System.out.println("New Dept Created: "+Integer.parseInt(deptSetIDField.getText()));
        BackToMainScene(event);
    }
    
    @FXML
    public void deleteDepartment(ActionEvent event) throws IOException{
        boolean contains = false;
        if (deptDelField.getText().trim().isEmpty()==true){
            throw new NullFieldException("Field is Empty!");
        }
        for(int i = 0; i<DeptList.size(); i++){
            if(DeptList.get(i).getId()==Integer.parseInt(deptDelField.getText())){
                DeptList.remove(i);
                contains = true;
            }
        }
        if (contains==false){
            throw new NullFieldException("Invalid ID!");
        }
        BackToMainScene(event);
    }
    
    @FXML
    public void ModifyDepartment(ActionEvent event) throws IOException{
        int index=0;
        boolean contains = false;
        if (deptModIDField.getText().trim().isEmpty()==true){
            throw new NullFieldException("Field is Empty!");
        }
        for(int i = 0; i<DeptList.size(); i++){
            if(DeptList.get(i).getId()==Integer.parseInt(deptModIDField.getText())){
                index=i;
                contains = true;
            }
        }
        if (contains==false){
            throw new NullFieldException("Invalid Department ID!");
        }
        contains=false;
        if (deptModDescField.getText().trim().isEmpty()==false){
            DeptList.get(index).setDescription(deptModDescField.getText());
        }
        if (deptModDeanField.getText().trim().isEmpty()==false){
            for (int i = 0; i<DeptList.get(index).TeacherList.size(); i++)
                if(DeptList.get(index).TeacherList.get(i).getId()==Integer.parseInt(deptModDeanField.getText())){
                    DeptList.get(index).setDean(DeptList.get(index).TeacherList.get(i));
                    contains=true;
                }
        }
        if(contains==false){
            throw new NullFieldException("Invalid Teacher ID!");
        }
        BackToMainScene(event);
    }
    
    //Student Functions
    @FXML
    public void addStudent(ActionEvent event) throws IOException{
        int index=0;
        boolean contains = false;
        Student newStu = new Student(Integer.parseInt(stuSetIDField.getText()),
                stuSetNameField.getText(),Integer.parseInt(stuSetAgeField.getText()),
                stuSetGenderField.getText(), stuSetCourseField.getText(), 
                Integer.parseInt(stuSetSemesterField.getText()),
                Integer.parseInt(stuSetDeptIDField.getText()));
        if (IDList.contains(Integer.parseInt(stuSetIDField.getText()))==true){
            throw new IDIntegrityException("ID '"+Integer.parseInt(stuSetIDField.getText())+"' is already in use");
        }
        for(int i = 0; i<DeptList.size(); i++){
            if(DeptList.get(i).getId()==Integer.parseInt(stuSetDeptIDField.getText())){
                index=i;
                contains=true;
            }
        }
        if (contains==true){
            DeptList.get(index).StudentList.add(newStu);
        }
        else{
            throw new NullFieldException("Invalid Dept ID!");
        }
        IDList.add(Integer.parseInt(stuSetIDField.getText()));
        System.out.println("New Student Created: "+Integer.parseInt(stuSetIDField.getText()));
        BackToMainScene(event);
    }
    
    @FXML
    public void deleteStudent(ActionEvent event) throws IOException{
        int deptIndex = 0;
        int stuIndex = 0;
        boolean contains = false;
        if (stuDelField.getText().trim().isEmpty()==true){
            throw new NullFieldException("Field is Empty!");
        }
        for(int i = 0; i<DeptList.size(); i++){
            for(int j = 0; j<DeptList.get(i).StudentList.size(); j++){
                if(DeptList.get(i).StudentList.get(j).getId()==Integer.parseInt(stuDelField.getText())){
                    deptIndex = i;
                    stuIndex = j;
                    DeptList.get(deptIndex).StudentList.remove(stuIndex);
                    System.out.println("Student Deleted: "+Integer.parseInt(stuDelField.getText()));
                    contains = true;
                }
            }
        }
        if (contains==false){
            throw new NullFieldException("Invalid Student ID!");
        }
        BackToMainScene(event);
    }
    
    @FXML
    public void ModifyStudent(ActionEvent event) throws IOException{
        int deptIndex = 0;
        int stuIndex = 0;
        boolean contains = false;
        if (stuModIDField.getText().trim().isEmpty()==true){
            throw new NullFieldException("Field is Empty!");
        }
        for(int i = 0; i<DeptList.size(); i++){
            for(int j = 0; j<DeptList.get(i).StudentList.size(); j++){
                if(DeptList.get(i).StudentList.get(j).getId()==Integer.parseInt(stuModIDField.getText())){
                    deptIndex=i;
                    stuIndex=j;
                    contains = true;
                }
            }
        }
        if (contains==false){
            throw new NullFieldException("Invalid Teacher ID!");
        }
        if (stuModNameField.getText().trim().isEmpty()==false){
            DeptList.get(deptIndex).StudentList.get(stuIndex).setName(stuModNameField.getText());
        }
        if (stuModAgeField.getText().trim().isEmpty()==false){
            DeptList.get(deptIndex).StudentList.get(stuIndex).setAge(Integer.parseInt(stuModNameField.getText()));
        }
        if (stuModGenderField.getText().trim().isEmpty()==false){
            DeptList.get(deptIndex).StudentList.get(stuIndex).setGender(stuModGenderField.getText());
        }
        if (stuModCourseField.getText().trim().isEmpty()==false){
            DeptList.get(deptIndex).StudentList.get(stuIndex).setCourse(stuModCourseField.getText());
        }
        if (stuModSemesterField.getText().trim().isEmpty()==false){
            DeptList.get(deptIndex).StudentList.get(stuIndex).setSemester(Integer.parseInt(stuModSemesterField.getText()));
        }
        System.out.println("Student Modified: "+Integer.parseInt(stuModIDField.getText()));
        BackToMainScene(event);
    }
    
    //Teacher Functions
    @FXML
    public void addTeacher(ActionEvent event) throws IOException{
        int index=0;
        boolean contains = false;
        Teacher newTeach = new Teacher(Integer.parseInt(teachSetIDField.getText()),
                teachSetNameField.getText(),Integer.parseInt(teachSetAgeField.getText()),
                teachSetGenderField.getText(), teachSetSpecField.getText(), 
                teachSetDegField.getText());
        if (IDList.contains(Integer.parseInt(teachSetIDField.getText()))==true){
            throw new IDIntegrityException("ID '"+Integer.parseInt(teachSetIDField.getText())+"' is already in use");
        }
        if (teachSetDeptIDField.getText().trim().isEmpty()==true){
            TempTeachList.add(newTeach);
        }
        else{
            for(int i = 0; i<DeptList.size(); i++){
                if(DeptList.get(i).getId()==Integer.parseInt(teachSetDeptIDField.getText())){
                    newTeach.setDept_id(Integer.parseInt(teachSetDeptIDField.getText()));
                    index=i;
                    contains=true;
                }
            }
            if (contains==true){
                DeptList.get(index).TeacherList.add(newTeach);
            }
            else{
                throw new NullFieldException("Invalid Dept ID!");
            }
        }
        IDList.add(Integer.parseInt(teachSetIDField.getText()));
        System.out.println("New Teacher Created: "+Integer.parseInt(teachSetIDField.getText()));
        BackToMainScene(event);
    }
    
    @FXML
    public void deleteTeacher(ActionEvent event) throws IOException{
        int deptIndex = 0;
        int teachIndex = 0;
        boolean contains = false;
        if (teachDelField.getText().trim().isEmpty()==true){
            throw new NullFieldException("Field is Empty!");
        }
        for(int i = 0; i<DeptList.size(); i++){
            for(int j = 0; j<DeptList.get(i).TeacherList.size(); j++){
                if(DeptList.get(i).TeacherList.get(j).getId()==Integer.parseInt(teachDelField.getText())){
                    deptIndex = i;
                    teachIndex = j;
                    DeptList.get(deptIndex).TeacherList.remove(teachIndex);
                    System.out.println("Teacher Deleted: "+Integer.parseInt(teachDelField.getText()));
                    contains = true;
                }
            }
        }
        if (contains==false){
            throw new NullFieldException("Invalid Teacher ID!");
        }
        BackToMainScene(event);
    }
    
    @FXML
    public void ModifyTeacher(ActionEvent event) throws IOException{
        int deptIndex = 0;
        int teachIndex = 0;
        boolean contains = false;
        if (teachModIDField.getText().trim().isEmpty()==true){
            throw new NullFieldException("Field is Empty!");
        }
        for(int i = 0; i<DeptList.size(); i++){
            for(int j = 0; j<DeptList.get(i).TeacherList.size(); j++){
                if(DeptList.get(i).TeacherList.get(j).getId()==Integer.parseInt(teachModIDField.getText())){
                    deptIndex=i;
                    teachIndex=j;
                    contains = true;
                }
            }
        }
        if (contains==false){
            throw new NullFieldException("Invalid Staff ID!");
        }
        if (teachModNameField.getText().trim().isEmpty()==false){
            DeptList.get(deptIndex).TeacherList.get(teachIndex).setName(teachModNameField.getText());
        }
        if (teachModAgeField.getText().trim().isEmpty()==false){
            DeptList.get(deptIndex).TeacherList.get(teachIndex).setAge(Integer.parseInt(teachModNameField.getText()));
        }
        if (teachModGenderField.getText().trim().isEmpty()==false){
            DeptList.get(deptIndex).TeacherList.get(teachIndex).setGender(teachModGenderField.getText());
        }
        if (teachModSpecField.getText().trim().isEmpty()==false){
            DeptList.get(deptIndex).TeacherList.get(teachIndex).setSpecialty(teachModSpecField.getText());
        }
        if (teachModDegField.getText().trim().isEmpty()==false){
            DeptList.get(deptIndex).TeacherList.get(teachIndex).setDegree(teachModDegField.getText());
        }
        System.out.println("Teacher Modified: "+Integer.parseInt(teachModIDField.getText()));
        BackToMainScene(event);
    }   
    
    //Staff Functions:
    @FXML
    public void addStaff(ActionEvent event) throws IOException{
        int index=0;
        boolean contains = false;
        Staff newStf = new Staff(Integer.parseInt(stfSetIDField.getText()),
                stfSetNameField.getText(),Integer.parseInt(stfSetAgeField.getText()),
                stfSetGenderField.getText(), stfSetDutyField.getText(), 
                Integer.parseInt(stfSetWLField.getText()),Integer.parseInt(stfSetDeptIDField.getText()));
        if (IDList.contains(Integer.parseInt(stfSetIDField.getText()))==true){
            throw new IDIntegrityException("ID '"+Integer.parseInt(stfSetIDField.getText())+"' is already in use");
        }
        for(int i = 0; i<DeptList.size(); i++){
            if(DeptList.get(i).getId()==Integer.parseInt(stfSetDeptIDField.getText())){
                index=i;
                contains=true;
            }
        }
        if (contains==true){
            DeptList.get(index).StaffList.add(newStf);
        }
        else{
            throw new NullFieldException("Invalid Dept ID!");
        }
        IDList.add(Integer.parseInt(stfSetIDField.getText()));
        System.out.println("New Staff Created: "+Integer.parseInt(stfSetIDField.getText()));
        BackToMainScene(event);
    }
    
    @FXML
    public void deleteStaff(ActionEvent event) throws IOException{
        int deptIndex = 0;
        int stfIndex = 0;
        boolean contains = false;
        if (stfDelField.getText().trim().isEmpty()==true){
            throw new NullFieldException("Field is Empty!");
        }
        for(int i = 0; i<DeptList.size(); i++){
            for(int j = 0; j<DeptList.get(i).StaffList.size(); j++){
                if(DeptList.get(i).StaffList.get(j).getId()==Integer.parseInt(stfDelField.getText())){
                    deptIndex = i;
                    stfIndex = j;
                    DeptList.get(deptIndex).StaffList.remove(stfIndex);
                    System.out.println("Staff Deleted: "+Integer.parseInt(stfDelField.getText()));
                    contains = true;
                }
            }
        }
        if (contains==false){
            throw new NullFieldException("Invalid Staff ID!");
        }
        BackToMainScene(event);
    }
    
    @FXML
    public void ModifyStaff(ActionEvent event) throws IOException{
        int deptIndex = 0;
        int stfIndex = 0;
        boolean contains = false;
        if (stfModIDField.getText().trim().isEmpty()==true){
            throw new NullFieldException("Field is Empty!");
        }
        for(int i = 0; i<DeptList.size(); i++){
            for(int j = 0; j<DeptList.get(i).StaffList.size(); j++){
                if(DeptList.get(i).StaffList.get(j).getId()==Integer.parseInt(stfModIDField.getText())){
                    deptIndex=i;
                    stfIndex=j;
                    contains = true;
                }
            }
        }
        if (contains==false){
            throw new NullFieldException("Invalid Staff ID!");
        }
        if (stfModNameField.getText().trim().isEmpty()==false){
            DeptList.get(deptIndex).StaffList.get(stfIndex).setName(stfModNameField.getText());
        }
        if (stfModAgeField.getText().trim().isEmpty()==false){
            DeptList.get(deptIndex).StaffList.get(stfIndex).setAge(Integer.parseInt(stfModNameField.getText()));
        }
        if (stfModGenderField.getText().trim().isEmpty()==false){
            DeptList.get(deptIndex).StaffList.get(stfIndex).setGender(stfModGenderField.getText());
        }
        if (stfModDutyField.getText().trim().isEmpty()==false){
            DeptList.get(deptIndex).StaffList.get(stfIndex).setDuty(stfModDutyField.getText());
        }
        if (stfModWorkField.getText().trim().isEmpty()==false){
            DeptList.get(deptIndex).StaffList.get(stfIndex).setWorkload(Integer.parseInt(stfModWorkField.getText()));
        }
        System.out.println("Staff Modified: "+Integer.parseInt(stfModIDField.getText()));
        BackToMainScene(event);
    }
    
    //View Functions
    @FXML
    public void refreshDeptList(ActionEvent event){
        displayDeptList(DeptList);
    }
    
    @FXML
    public void displayDeptList(ObservableList<Department> tableArray){
        deptIDCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        deptDescCol.setCellValueFactory(new PropertyValueFactory<>("description"));
        deptDeanCol.setCellValueFactory(new PropertyValueFactory<>("dean"));
        deptTable.setItems(tableArray);
    }
    
    @FXML
    public void refreshStuList(ActionEvent event) throws IOException{
        oStudentList.clear();
        int index = 0;
        boolean contains = false;
        for(int i = 0; i<DeptList.size(); i++){
            if(DeptList.get(i).getId()==Integer.parseInt(stuViewField.getText())){
                index = i;
                contains = true;
            }
        }
        if (contains==false){
            throw new NullFieldException("Invalid Dept ID!");
        }
        for(int i = 0; i<DeptList.get(index).StudentList.size(); i++){
            oStudentList.add(DeptList.get(index).StudentList.get(i));
        }
        createStuList(oStudentList);
    }
    
    @FXML
    public void createStuList(ObservableList<Student> tableArray){
        stuIDCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        stuNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        stuAgeCol.setCellValueFactory(new PropertyValueFactory<>("age"));
        stuGenderCol.setCellValueFactory(new PropertyValueFactory<>("gender"));
        stuCourseCol.setCellValueFactory(new PropertyValueFactory<>("course"));
        stuSemesterCol.setCellValueFactory(new PropertyValueFactory<>("semester"));
        stuTbl.setItems(tableArray);
    }
    
    @FXML
    public void refreshTeachList(ActionEvent event) throws IOException{
        oTeacherList.clear();
        int index = 0;
        boolean contains = false;
        for(int i = 0; i<DeptList.size(); i++){
            if(DeptList.get(i).getId()==Integer.parseInt(teachViewField.getText())){
                index = i;
                contains = true;
            }
        }
        if (contains==false){
            throw new NullFieldException("Invalid Dept ID!");
        }
        for(int i = 0; i<DeptList.get(index).TeacherList.size(); i++){
            oTeacherList.add(DeptList.get(index).TeacherList.get(i));
        }
        createTeachList(oTeacherList);
    }
    
    @FXML
    public void createTeachList(ObservableList<Teacher> tableArray){
        teachIDCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        teachNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        teachAgeCol.setCellValueFactory(new PropertyValueFactory<>("age"));
        teachGenderCol.setCellValueFactory(new PropertyValueFactory<>("gender"));
        teachSpecCol.setCellValueFactory(new PropertyValueFactory<>("specialty"));
        teachDegCol.setCellValueFactory(new PropertyValueFactory<>("degree"));
        teachTbl.setItems(tableArray);
    }
    
    @FXML
    public void refreshStfList(ActionEvent event) throws IOException{
        oStaffList.clear();
        int index = 0;
        boolean contains = false;
        for(int i = 0; i<DeptList.size(); i++){
            if(DeptList.get(i).getId()==Integer.parseInt(stfViewField.getText())){
                index = i;
                contains = true;
            }
        }
        if (contains==false){
            throw new NullFieldException("Invalid Dept ID!");
        }
        for(int i = 0; i<DeptList.get(index).StaffList.size(); i++){
            oStaffList.add(DeptList.get(index).StaffList.get(i));
        }
        createStfList(oStaffList);
    }
    
    @FXML
    public void createStfList(ObservableList<Staff> tableArray){
        stfIDCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        stfNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        stfAgeCol.setCellValueFactory(new PropertyValueFactory<>("age"));
        stfGenderCol.setCellValueFactory(new PropertyValueFactory<>("gender"));
        stfDutyCol.setCellValueFactory(new PropertyValueFactory<>("duty"));
        stfWorkCol.setCellValueFactory(new PropertyValueFactory<>("workload"));
        stfTbl.setItems(tableArray);
    }
    
    //Search
    @FXML
    public void search(ActionEvent event) throws IOException{
        int id = Integer.parseInt(SearchField.getText());
        int student = 0;
        int teacher = 0;
        int staff = 0;
        for (int i = 0; i<DeptList.size(); i++){
            for(int j=0; j<DeptList.get(i).StudentList.size(); j++){
                if(DeptList.get(i).StudentList.get(j).getId()==id){
                    student = 1;
                    System.out.println(DeptList.get(i).StudentList.get(j));//Had trouble getting the JavaFX implementation to work in.
                    /*ObservableList SearchStuList = FXCollections.observableArrayList();
                    SearchStuList.add(DeptList.get(i).StudentList.get(j));
                    goToViewStudentScene(event);
                    createStuList(SearchStuList);
                    refreshStuList(event);*/
                }
            }
            for(int j=0; j<DeptList.get(i).TeacherList.size(); j++){
                if(DeptList.get(i).TeacherList.get(j).getId()==id){
                    teacher = 1;
                    System.out.println(DeptList.get(i).TeacherList.get(j));
                    /*ObservableList SearchTeachList = FXCollections.observableArrayList();
                    SearchTeachList.add(DeptList.get(i).StudentList.get(j));
                    goToViewTeacherScene(event);
                    createStuList(SearchTeachList);*/
                    
                }
            }
            for(int j=0; j<DeptList.get(i).StaffList.size(); j++){
                if(DeptList.get(i).StaffList.get(j).getId()==id){
                    student = 1;
                    System.out.println(DeptList.get(i).StaffList.get(j));
                    /*ObservableList SearchStfList = FXCollections.observableArrayList();
                    SearchStfList.add(DeptList.get(i).StudentList.get(j));
                    goToViewStaffScene(event);
                    createStuList(SearchStfList);**/
                    
                }
            }
        }
        if(student==0 && teacher==0 && staff==0){
                System.out.println("No results");
                BackToMainScene(event);
                
        }
    }
    //Scene Transitions:
    private Stage stage;
    private Scene scene;
    private Parent root;
    
    @FXML
    public void BackToMainScene(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("MainScene.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    @FXML
    public void goToAddDepartmentScene(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("AddDepartmentScene.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    @FXML
    public void goToAddStudentScene(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("AddStudentScene.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    @FXML
    public void goToAddTeacherScene(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("AddTeacherScene.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    @FXML
    public void goToAddStaffScene(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("AddStaffScene.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    @FXML
    public void goToDeleteDepartmentScene(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("DeleteDepartmentScene.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    @FXML
    public void goToDeleteStudentScene(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("DeleteStudentScene.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    @FXML
    public void goToDeleteTeacherScene(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("DeleteTeacherScene.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    @FXML
    public void goToDeleteStaffScene(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("DeleteStaffScene.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    @FXML
    public void goToModifyDepartmentScene(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("ModifyDepartmentScene.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    @FXML
    public void goToModifyStudentScene(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("ModifyStudentScene.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    @FXML
    public void goToModifyTeacherScene(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("ModifyTeacherScene.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    @FXML
    public void goToModifyStaffScene(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("ModifyStaffScene.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    @FXML
    public void goToViewStudentScene(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("ViewStudentScene.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    @FXML
    public void goToViewTeacherScene(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("ViewTeacherScene.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    @FXML
    public void goToViewStaffScene(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("ViewStaffScene.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    @FXML
    public void goToSearchScene(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("SearchScene.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
}
 