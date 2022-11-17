/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominusapp.controller;

import dominusapp.modelDAO.ResidenteDAO;
import dominusapp.modelDatabase.Database;
import dominusapp.modelDatabase.DatabaseFactory;
import dominusapp.modelDomain.Residente;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author gabri
 */
public class FXMLChangeAccountController implements Initializable {

    @FXML
    private AnchorPane anchorPaneChangeAccount;
    @FXML
    private PasswordField userPassword;
    @FXML
    private TextField emailTextField;
    @FXML
    private Button enterButton;
    @FXML
    private Label registerLabel;
    @FXML
    private Label passwordRecoverLabel;
    
    private final Database database = DatabaseFactory.getDatabase("postgresql");
    private final Connection connection = database.conectar();
    private Residente residente = new Residente();
    private final ResidenteDAO residenteDAO = new ResidenteDAO();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        residenteDAO.setConnection(connection);
    }    

    @FXML
    public void changeRegisterScene() throws IOException{
        Parent interfaceInicio = FXMLLoader.load(getClass().getResource("/dominusapp/view/FXMLRegister.fxml"));
        anchorPaneChangeAccount.getChildren().removeAll();
        anchorPaneChangeAccount.getChildren().setAll(interfaceInicio);
    }
    
    public void emitirAlertaNaoEncontrado(){
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Erro ao encontrar!");
            alerta.setHeaderText("Residente não encontrado!");
            alerta.setContentText("Tente novamente!");
            alerta.show();
    }
    
    @FXML
    public void changeFeedPage() throws IOException{
        Parent interfaceInicio = FXMLLoader.load(getClass().getResource("/dominusapp/view/FXMLFeedPage.fxml"));
        anchorPaneChangeAccount.getChildren().removeAll();
        anchorPaneChangeAccount.getChildren().setAll(interfaceInicio);
    }
    
    @FXML
    public void validarUsuario() throws SQLException, IOException{
        residente = residenteDAO.verificar(emailTextField.getText(), userPassword.getText());
        if(residente.getEmail() == null || residente.getSenha() == null){
            emitirAlertaNaoEncontrado();
        }else{
            changeFeedPage();
        }
    }
}
