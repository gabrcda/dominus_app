/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominusapp.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author gabri
 */
public class FXMLHomeController implements Initializable {
    
    @FXML
    private PasswordField userPassword;
    @FXML
    private Label registerLabel;
    @FXML
    private Label changeAccountLabel;
    @FXML
    private AnchorPane anchorPaneHome;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    public void changeRegisterScene() throws IOException{
        Parent interfaceInicio = FXMLLoader.load(getClass().getResource("/dominusapp/view/FXMLRegister.fxml"));
        anchorPaneHome.getChildren().removeAll();
        anchorPaneHome.getChildren().setAll(interfaceInicio);
    }
    
    @FXML
    public void changeUserScene() throws IOException{
        Parent interfaceInicio = FXMLLoader.load(getClass().getResource("/dominusapp/view/FXMLChangeAccount.fxml"));
        anchorPaneHome.getChildren().removeAll();
        anchorPaneHome.getChildren().setAll(interfaceInicio);
    }
}
