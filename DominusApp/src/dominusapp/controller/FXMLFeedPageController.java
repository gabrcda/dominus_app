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
public class FXMLFeedPageController implements Initializable {

    @FXML
    private AnchorPane anchorPaneFeedPage;
    @FXML
    private ImageView profileButton;
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
    public void changeProfileScene() throws IOException{
        Parent interfaceInicio = FXMLLoader.load(getClass().getResource("/dominusapp/view/FXMLProfile.fxml"));
        anchorPaneFeedPage.getChildren().removeAll();
        anchorPaneFeedPage.getChildren().setAll(interfaceInicio);
    }

    @FXML
    private void changeRecordScene() throws IOException {
        Parent interfaceInicio = FXMLLoader.load(getClass().getResource("/dominusapp/view/FXMLRecord.fxml"));
        anchorPaneFeedPage.getChildren().removeAll();
        anchorPaneFeedPage.getChildren().setAll(interfaceInicio);
    }
}
