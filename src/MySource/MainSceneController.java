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
    
    
 LocalDateTime getTime = LocalDateTime.now();
    DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    String DateTime = getTime.format(timeFormat);
    
    public static ObservableList<Department> DeptList = FXCollections.observableArrayList();
    public static ObservableList<Teacher> TempTeachList = FXCollections.observableArrayList();
    public static ObservableList<Student> TempStuList = FXCollections.observableArrayList();
    public static ObservableList<Staff> TempStaffList = FXCollections.observableArrayList();
    
    public static ArrayList<Integer> IDList = new ArrayList<>();

    FolderSceneController path = new FolderSceneController();
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
    
    @FXML
    public void refreshDeptList(ActionEvent event){
        displayDeptList(DeptList);
    }
    
    
    public void displayDeptList(ObservableList<Department> tableArray){
        deptIDCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        deptDescCol.setCellValueFactory(new PropertyValueFactory<>("description"));
        deptTable.setItems(tableArray);
    }
    
    
    public void addDeptartment(ActionEvent event) throws IOException{
        Department newDept = new Department(Integer.parseInt(deptSetIDField.getText()),
                deptSetDescField.getText());
        if (IDList.contains(Integer.parseInt(deptSetIDField.getText()))==true){
            throw new IDIntegrityException("ID '"+Integer.parseInt(deptSetIDField.getText())+"' is already in use");
        }
        DeptList.add(newDept);
        IDList.add(Integer.parseInt(deptSetIDField.getText()));
        System.out.println("New Dept Created: "+Integer.parseInt(deptSetIDField.getText()));
    }
    
    private Stage stage;
    private Scene scene;
    private Parent root;
    
    @FXML
    public void goToAddDepartmentScene(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("AddDepartmentScene.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
}
