package application.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

public class ContaLuzController {

    @FXML
    private Button botaoLimparCamposLuz;

    @FXML
    private BorderPane btnContaAgua;

    @FXML
    private TextField txtCodIdentificacao;

    @FXML
    void clickLimpar(ActionEvent event) {
    	txtCodIdentificacao.setText("");
    }

}
