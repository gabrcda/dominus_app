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
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author gabri
 */
public class FXMLRecordController implements Initializable {

    @FXML
    private AnchorPane anchorPaneRecord;
    @FXML
    private ImageView advertsButton;
    @FXML
    private ImageView profileButton;

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
        anchorPaneRecord.getChildren().removeAll();
        anchorPaneRecord.getChildren().setAll(interfaceInicio);
    }

    @FXML
    private void changeProfileScene() throws IOException {
        Parent interfaceInicio = FXMLLoader.load(getClass().getResource("/dominusapp/view/FXMLProfile.fxml"));
        anchorPaneRecord.getChildren().removeAll();
        anchorPaneRecord.getChildren().setAll(interfaceInicio);
    }
    
}
