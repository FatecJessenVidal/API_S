package application.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class UsuarioController implements Initializable {

	@FXML
	private TextField txtConteudo;
	
	@FXML
	private Label lblMensagem;
	
	@FXML
	private void executarClickConfirmar(ActionEvent evento) {
		String texto = txtConteudo.getText();
		lblMensagem.setText(texto);
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}

}
