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
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author gabri
 */
public class FXMLProfileController implements Initializable {

    @FXML
    private AnchorPane anchorPaneProfile;
    @FXML
    private TextField blockTextField;
    @FXML
    private TextField numberTextField;
    @FXML
    private DatePicker dateTextField;
    @FXML
    private TextField emailTextField;
    @FXML
    private TextField cpfTextField;
    @FXML
    private TextField nameTextField;
    @FXML
    private ImageView advertsButton;
    @FXML
    private ImageView recordButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void changeFeedPage() throws IOException {
        Parent interfaceInicio = FXMLLoader.load(getClass().getResource("/dominusapp/view/FXMLFeedPage.fxml"));
        anchorPaneProfile.getChildren().removeAll();
        anchorPaneProfile.getChildren().setAll(interfaceInicio);
    }

    @FXML
    private void changeRecordScene() throws IOException {
        Parent interfaceInicio = FXMLLoader.load(getClass().getResource("/dominusapp/view/FXMLRecord.fxml"));
        anchorPaneProfile.getChildren().removeAll();
        anchorPaneProfile.getChildren().setAll(interfaceInicio);
    }
    
}
