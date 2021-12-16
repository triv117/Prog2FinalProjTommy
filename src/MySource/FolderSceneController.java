/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package MySource;

import javafx.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author TomRi
 */
public class FolderSceneController implements Initializable {

    @FXML
    private TextField deptTxtField;
    @FXML
    private TextField stuTxtField;
    @FXML
    private TextField teachTextField;
    @FXML
    private TextField staffTxtField;
    @FXML
    private Button launchBtn;
    
    private String deptPath,stuPath,teachPath,stfPath="";

    public String getDeptPath() {
        return deptPath;
    }

    public String getStuPath() {
        return stuPath;
    }

    public String getTeach() {
        return teachPath;
    }

    public String getStf() {
        return stfPath;
    }    
    
    public FolderSceneController(){}
    
    private Stage stage;
    private Scene scene;
    private Parent root;
    
    @FXML
    public void goToMainScene(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("MainScene.fxml"));
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
