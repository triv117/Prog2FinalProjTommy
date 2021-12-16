package MySource;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class MainSceneController implements Initializable {
    
    
 LocalDateTime getTime = LocalDateTime.now();
    DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    String DateTime = getTime.format(timeFormat);
    
    public static ObservableList<Department> DeptList = FXCollections.observableArrayList();
    public static ObservableList<Teacher> TempTeachList = FXCollections.observableArrayList();
    public static ObservableList<Student> TempStuList = FXCollections.observableArrayList();
    public static ObservableList<Staff> TempStaffList = FXCollections.observableArrayList();
    
    public ArrayList<Integer> IDList = new ArrayList<>();

    FolderSceneController path = new FolderSceneController();
    @FXML
    private Button deptAddBtn;
    @FXML
    private Button deptDelBtn;
    @FXML
    private Button deanBtn;
    @FXML
    private Button stuAddBtn;
    @FXML
    private Button stuDelBtn;
    @FXML
    private Button teachAddBtn;
    @FXML
    private Button teachDelBtn;
    @FXML
    private Button stfAddBtn;
    @FXML
    private Button stfDelBtn;
    @FXML
    private TableView<Department> deptTable;
    @FXML
    private TableColumn<Department, Integer> deptIDCol;
    @FXML
    private TableColumn<Department, String> deptDescCol;
    @FXML
    private TableColumn<Department, Teacher> deptDeanCol;
    @FXML
    private TextField viewField;
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
    public void load(ActionEvent event){
        String pathDeptRead = "C:\\\\Users\\\\TomRi\\\\Desktop\\\\FinalProject\\\\Prog2FinalProjTommy\\\\Department.txt";//To Change
        String pathStuRead = "C:\\\\Users\\\\TomRi\\\\Desktop\\\\FinalProject\\\\Prog2FinalProjTommy\\\\Student.txt";//To Change
        String pathTeachRead = "C:\\\\Users\\\\TomRi\\\\Desktop\\\\FinalProject\\\\Prog2FinalProjTommy\\\\Teacher.txt";//To Change
        String pathStaffRead = "C:\\\\Users\\\\TomRi\\\\Desktop\\\\FinalProject\\\\Prog2FinalProjTommy\\\\Staff.txt";//To Change

        String pathDeptWrite = "C:\\\\Users\\\\TomRi\\\\Desktop\\\\FinalProject\\\\Prog2FinalProjTommy\\\\NewDepartment.txt";//To Change
        String pathStuWrite = "C:\\\\Users\\\\TomRi\\\\Desktop\\\\FinalProject\\\\Prog2FinalProjTommy\\\\NewStudent.txt";//To Change
        String pathTeachWrite = "C:\\\\Users\\\\TomRi\\\\Desktop\\\\FinalProject\\\\Prog2FinalProjTommy\\\\NewTeacher.txt";//To Change        
        String pathStaffWrite = "C:\\\\Users\\\\TomRi\\\\Desktop\\\\FinalProject\\\\Prog2FinalProjTommy\\\\NewStaff.txt";//To Change

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
    
    public void displayDeptList(ObservableList<Department> tableArray){
        deptIDCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        deptDescCol.setCellValueFactory(new PropertyValueFactory<>("description"));
        deptTable.setItems(tableArray);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
}
