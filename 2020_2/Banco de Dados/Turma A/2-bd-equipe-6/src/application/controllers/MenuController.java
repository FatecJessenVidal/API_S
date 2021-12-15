package application.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.models.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class MenuController {
	
	
	
    private BorderPane rootLayout;
	
	@FXML
	private Button btnCadastroUsuario;	
	
	@FXML
	private Button btnCadastroCliente;
	
	@FXML
	private Button btnContaLuz;
	
	@FXML
	private Button btnContaAgua;
	
	@FXML
	private Button btnContaGas;
	
	@FXML
	private void clickCadastroUsuario(ActionEvent evento) throws IOException {
		rootLayout = (BorderPane) btnCadastroUsuario.getScene().getRoot();
		
		FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MenuController.class.getResource("../CadastroUsuario.fxml"));
        AnchorPane cadastroUsuario = (AnchorPane) loader.load();

        rootLayout.setCenter(cadastroUsuario);
	}
	
	@FXML
	private void clickCadastroCliente(ActionEvent evento) throws IOException {
		rootLayout = (BorderPane) btnCadastroCliente.getScene().getRoot();
		
		FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MenuController.class.getResource("../CadastroCliente.fxml"));
        AnchorPane cadastroCliente = (AnchorPane) loader.load();

        rootLayout.setCenter(cadastroCliente);
	}
	
	@FXML
	private void clickContaLuz(ActionEvent evento) throws IOException {
		rootLayout = (BorderPane) btnContaLuz.getScene().getRoot();
		
		FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MenuController.class.getResource("../ContaLuz.fxml"));
        BorderPane contaLuz = loader.load();

        rootLayout.setCenter(contaLuz);
	}
	
	@FXML
	private void clickContaAgua(ActionEvent evento) throws IOException {
		rootLayout = (BorderPane) btnContaAgua.getScene().getRoot();
		
		FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MenuController.class.getResource("../ContaAgua.fxml"));
        BorderPane contaAgua = loader.load();

        rootLayout.setCenter(contaAgua);

	}
	
	@FXML
	private void clickContaGas(ActionEvent evento) throws IOException {
		rootLayout = (BorderPane) btnContaGas.getScene().getRoot();
		
		FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MenuController.class.getResource("../ContaGas.fxml"));
        BorderPane contaGas = loader.load();

        rootLayout.setCenter(contaGas);

	}
}
