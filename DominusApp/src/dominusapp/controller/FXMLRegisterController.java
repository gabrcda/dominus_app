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
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author gabri
 */
public class FXMLRegisterController implements Initializable {

    @FXML
    private AnchorPane anchorPaneRegister;
    @FXML
    private ImageView cancelButton;
    @FXML
    private TextField nameTextField;
    @FXML
    private TextField cpfTextField;
    @FXML
    private TextField emailTextField;
    @FXML
    private TextField blockTextField;
    @FXML
    private PasswordField passwordPasswordField;
    @FXML
    private TextField numberTextField;
    @FXML
    private DatePicker dateTextField;
    @FXML
    private ImageView confirmationButton;
    
    private final Database database = DatabaseFactory.getDatabase("postgresql");
    private final Connection connection = database.conectar();
    private Residente residente = new Residente();
    private ResidenteDAO residenteDAO = new ResidenteDAO();


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        residenteDAO.setConnection(connection);
    }

    @FXML
    public void changeHomeScene() throws IOException{
        Parent interfaceInicio = FXMLLoader.load(getClass().getResource("/dominusapp/view/FXMLHome.fxml"));
        anchorPaneRegister.getChildren().removeAll();
        anchorPaneRegister.getChildren().setAll(interfaceInicio);
    }
    
    @FXML
    public void persistirDados(){
        receberDadosInterface();
        if(residenteDAO.inserir(residente)){
            exibirConfirmacao();
            esvaziarCampos();
        }else{
            emitirAlertaErro();
        }
    }
    
    public void receberDadosInterface(){
        if(verificarPreenchimentoDeDados() == true){
            residente.setNome(nameTextField.getText());
            residente.setCpf(cpfTextField.getText());
            residente.setEmail(emailTextField.getText());
            residente.setDataNascimento(dateTextField.getValue());
            residente.setBlocoApt(blockTextField.getText());
            residente.setNumeroApt(Integer.parseInt(numberTextField.getText()));
            residente.setSenha(passwordPasswordField.getText());
        }
    }
    
    public void esvaziarCampos(){
        nameTextField.setText(null);
        cpfTextField.setText(null);
        emailTextField.setText(null);
        dateTextField.setValue(null);
        blockTextField.setText(null);
        numberTextField.setText(null);
        passwordPasswordField.setText(null);
    }
    
    public void exibirConfirmacao(){
        Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
        alerta.setTitle("Sucesso!");
        alerta.setHeaderText("Cadastro realizado com sucesso!");
        alerta.setContentText("Os dados foram gravados!");
        alerta.show();
    }
    
    public void emitirAlertaErro(){
        Alert alerta = new Alert(Alert.AlertType.ERROR);
        alerta.setTitle("Erro!");
        alerta.setHeaderText("Erro ao cadastrar!");
        alerta.setContentText("Tente Novamente!");
        alerta.show();
    }

    public boolean verificarPreenchimentoDeDados(){
        String errorMessage = "";
        
        if (nameTextField.getText() == null || nameTextField.getText().length() == 0) {
             errorMessage += "Nome inválido!\n";
        }
        if (emailTextField.getText() == null || emailTextField.getText().length() == 0) {
            errorMessage += "Email inválido!\n";;
        }
        if (cpfTextField.getText() == null || cpfTextField.getText().length() == 0) {
            errorMessage += "Cpf inválido!\n";
        }
        if (blockTextField.getText() == null || blockTextField.getText().length() <= 0){
            errorMessage += "Bloco inválido!\n";
        }
        if(numberTextField.getText() == null || numberTextField.getText().length() == 0){
            errorMessage += "Número inválido!\n";
        }
        if(passwordPasswordField.getText() == null || passwordPasswordField.getText().length() == 0){
            errorMessage += "Senha inválida!\n";
        }
        if(dateTextField.getValue() == null){
            errorMessage += "Data inválida!\n";
        }
        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Mostrando a mensagem de erro
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro no cadastro");
            alert.setHeaderText("Campos inválidos, por favor, corrija...");
            alert.setContentText(errorMessage);
            alert.show();
            return false;
        }
    }
    
}
