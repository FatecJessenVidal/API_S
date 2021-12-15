package control;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import model.*;
import view.*;

public class ControlesPerfilAdminHistEntregas implements Initializable {

	Motorista motorista = new Motorista();
	Veiculo veiculo = new Veiculo();
	
	private String funcao = "";
	private boolean confirmado = false;
	public static boolean atualizarInfos = false;
	
    @FXML
    private TextField campoDeBuscaEmpresaDestino;
    @FXML
    private TextField campoDeBuscaCpf;
    @FXML
    private Button botaoBuscar;
    @FXML
    private TextField campoDeBuscaMotorista;
    @FXML
    private TableView<Viagens> tabela;
    @FXML
    private TableColumn<?, ?> colunaId;
    @FXML
    private TableColumn<?, ?> colunaEmpresaDestino;
    @FXML
    private TableColumn<?, ?> colunaMotorista;
    @FXML
    private Pane paneSelecionarViagem;
    @FXML
    private Pane paneViagemSelecionada;
    @FXML
    private TextField textFieldId;
    @FXML
    private TextField textFieldInicio;
    @FXML
    private TextField textFieldTotal;
    @FXML
    private DatePicker datePickerPrazo;
    @FXML
    private TextField textFieldDestino;
    @FXML
    private TextField textFieldCarga;
    @FXML
    private TextField textFieldSituacao;
    @FXML
    private ComboBox<Funcionarios> comboBoxMotorista;
    @FXML
    private ComboBox<Veiculos> comboBoxVeiculo;
    @FXML
    private Button botaoSalvar;
    @FXML
    private Button botaoDescartar;
    @FXML
    private Pane paneAvisosPrincipal;
    @FXML
    private Pane paneAvisosSombra;
    @FXML
    private Pane paneAvisosSucesso;
    @FXML
    private Label labelAvisosTextoSucesso;
    @FXML
    private Label labelAvisosTituloSucesso;
    @FXML
    private Pane paneAvisosFalha;
    @FXML
    private Label labelAvisosTextoFalha;
    @FXML
    private Label labelAvisosTituloFalha;
    @FXML
    private Pane paneAvisosConfirmar;
    @FXML
    private PasswordField passwordFieldConfirmarSenha;
    @FXML
    private Label labelAvisosTextoConfirmar;
    @FXML
    private Label labelAvisosTituloConfirmar;
    @FXML
    private Label labelDicaFlutuante;
    
	private List<Viagens> listaDeViagens = new ArrayList<>();
	private ObservableList<Viagens> obsListViagens;
	
	private List<Funcionarios> listaDeMotoristas = new ArrayList<>();
	private ObservableList<Funcionarios> obsListMotorista;
	
	private List<Veiculos> listaDeVeiculos = new ArrayList<>();
	private ObservableList<Veiculos> obsListVeiculo;
	
    private int idViagem;
    
	private List<Viagens> listaDeViagensPesquisa = new ArrayList<>();
	private ObservableList<Viagens> obsListViagensPesquisa;
    
    
    
	@FXML
	void requisitarAlteracao(ActionEvent event) {
		if(!comboBoxVeiculo.getSelectionModel().getSelectedItem().getPlaca().equals("Selecione um ve�culo...")) {
			funcao = "Veiculo";
			notificar("Confirmar", "Confirmar senha do usu�rio", "Por favor, confirme sua senha no campo abaixo para confirmar as altera��es nos dados");	
		}
		else {
			System.out.println("Selecione um ve�culo!");
		}
	}
	
    
    @FXML
    private void salvarAlteracoes(ActionEvent event) {
    	if(confirmado) {
    	   	Viagem viagem = new Viagem().encontrarViagem(idViagem);
    	   	
    	   	Map<String, String> dicionarioViagem = viagem.dadosViagem();
        	
        	int dia = datePickerPrazo.getValue().getDayOfMonth();
        	int mes = datePickerPrazo.getValue().getMonthValue();
        	int ano = datePickerPrazo.getValue().getYear();
        	
        	String prazo;
        	
        	if(dia < 10) {
            	prazo = ("0" + String.valueOf(dia) + "/" + String.valueOf(mes) + "/" + String.valueOf(ano));
        	}
        	else {
            	prazo = (String.valueOf(dia) + "/" + String.valueOf(mes) + "/" + String.valueOf(ano));
        	}
        	
        	viagem.alterarDadosViagem(prazo, textFieldDestino.getText(),
        							  comboBoxMotorista.getSelectionModel().getSelectedItem().getCpf(), 
        							  comboBoxVeiculo.getSelectionModel().getSelectedItem().getPlaca(), 
        							  textFieldCarga.getText(), Integer.parseInt(textFieldId.getText()));
        	
    		Logs log = new Logs();
    		log.registrarLog(ControlesLogin.nomeLogado, ControlesLogin.cpfLogado, "Altera��o de dados de viagem:"
    				+ "\nDestino: " + dicionarioViagem.get("Destino") +" -> " + textFieldDestino.getText()
    				+ "\nCarga: " + dicionarioViagem.get("Carga") +" -> " + textFieldCarga.getText()
    				+ "\nPrazo: " + dicionarioViagem.get("Prazo") +" -> " + prazo
    				+ "\nMotorista respons�vel: " + dicionarioViagem.get("Motorista respons�vel") +" -> " + comboBoxMotorista.getSelectionModel().getSelectedItem().getNome()
    				+ "\nPlaca do ve�culo atribu�do: " + dicionarioViagem.get("Placa do ve�culo atribu�do") +" -> " + comboBoxVeiculo.getSelectionModel().getSelectedItem().getPlaca());
        	
        	
    		new Funcionario().encontrarFuncionario(ControlesLogin.cpfLogado).incrementarMetadados("VgmAlt");
    		
        	textFieldDestino.setDisable(false);
        	textFieldCarga.setDisable(false);
        	comboBoxMotorista.setDisable(false);
        	comboBoxVeiculo.setDisable(false);
        	datePickerPrazo.setDisable(false);
        	
        	notificar("Sucesso", "Dados alterados", "Os dados da viagem foram alterados com sucesso");
        	
        	desabilitarEdicao();
        	
        	atualizarInfos = true;
    	}
    	else {
    		notificar("Falha", "Senha de confirma��o incorreta", "A senha de verifica��o estava incorreta, tente novamente");
    	}
 
    	confirmado = false;
    	funcao = "";
    }
    
    @FXML
	void requisitarExclusaoViagem(ActionEvent event) {
		confirmado = false;
		funcao = "ExcluirViagem";
		notificar("Confirmar", "Confirmar senha do usu�rio", "Por favor, confirme sua senha no campo abaixo para confirmar a exclus�o.");
	}
    @FXML
    private void excluirViagem(ActionEvent event) {
    	
		if (confirmado) {
	    	Viagem viagem = new Viagem().encontrarViagem(idViagem);
    	   	
    	   	Map<String, String> dicionarioViagem = viagem.dadosViagem();
    	   	
	    	boolean viagemExcluida = viagem.excluirViagem(Integer.parseInt(textFieldId.getText()));
	    	desabilitarEdicao();
	    	
			paneViagemSelecionada.setVisible(false);
			paneSelecionarViagem.setVisible(true);
			paneSelecionarViagem.setDisable(false);
	    	
	    	if (viagemExcluida) {
				notificar("Sucesso", "Viagem exclu�da", "A viagem foi exclu�da com sucesso do banco de dados!");
				
	        	int dia = datePickerPrazo.getValue().getDayOfMonth();
	        	int mes = datePickerPrazo.getValue().getMonthValue();
	        	int ano = datePickerPrazo.getValue().getYear();
	        	
	        	String prazo;
	        	
	        	if(dia < 10) {
	            	prazo = ("0" + String.valueOf(dia) + "/" + String.valueOf(mes) + "/" + String.valueOf(ano));
	        	}
	        	else {
	            	prazo = (String.valueOf(dia) + "/" + String.valueOf(mes) + "/" + String.valueOf(ano));
	        	}
				
	    		Logs log = new Logs();
	    		log.registrarLog(ControlesLogin.nomeLogado, ControlesLogin.cpfLogado, "Exclus�o de viagem:"
	    				+ "\nDestino: " + dicionarioViagem.get("Destino")
	    				+ "\nCarga: " + dicionarioViagem.get("Carga")
	    				+ "\nPrazo: " + dicionarioViagem.get("Prazo")
	    				+ "\nMotorista respons�vel: " + dicionarioViagem.get("Motorista respons�vel")
	    				+ "\nPlaca do ve�culo atribu�do: " + dicionarioViagem.get("Placa do ve�culo atribu�do"));
	    		
        		new Funcionario().encontrarFuncionario(ControlesLogin.cpfLogado).incrementarMetadados("VgmExc");
				
				atualizarInfos = true;
	    	}
	    	else {
				notificar("Falha", "Falha",
						"A viagem n�o foi exclu�da. Verifique se n�o h� nenhum registro ligado a ela e tente novamente.");
	    	}
		}
		else {
			notificar("Falha", "Senha de confirma��o incorreta", "A senha de verifica��o estava incorreta, tente novamente");
		}
		confirmado = false;
		funcao = "";
    }
	@FXML
	private void selecionarViagem(ActionEvent event) {
		try {
			Viagens selecionada = tabela.getSelectionModel().getSelectedItem();
			idViagem = selecionada.getId();

			carregarInfoViagem();
		}
		catch (NullPointerException falha) {
			notificar("Falha", "Entidade n�o selecionada", "Nenhuma viagem foi selecionada na lista, por favor selecione uma e tente novamente");
		}

	}
	@FXML
	void abrirTelaAvisos(MouseEvent event) {
		Main.trocarTela("Tela Avisos");
	}
    @FXML
    private void atualizarLista(ActionEvent event) {
    	atualizarInfos = true;
    }
    
	private void carregarInfoViagem() {
    	paneSelecionarViagem.setVisible(false);
    	paneSelecionarViagem.setDisable(true);
    	paneViagemSelecionada.setVisible(true);
    	paneViagemSelecionada.setDisable(false);
    	
    	Viagem viagem = new Viagem();
    	viagem = viagem.encontrarViagem(idViagem);
    	
    	textFieldCarga.setText(viagem.getCarga());
    	textFieldDestino.setText(viagem.getDestino());
    	textFieldId.setText(String.valueOf(viagem.getId()));
    	textFieldInicio.setText(viagem.getInicio());
    	textFieldSituacao.setText(viagem.getSituacao());
    	textFieldTotal.setText(viagem.getSituacao());
    	
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    	LocalDate localDate = LocalDate.parse(viagem.getFim(), formatter);
    	datePickerPrazo.setValue(localDate);
    	
    	comboBoxMotorista.getSelectionModel().selectFirst();
    	int seguranca = 0;
    	// O while abaixo pode ser um pouco confuso, mas basicamente ele verifica se o que est� selecionado na combobox � igual ao funcion�rio da viagem
    	while(!viagem.getMotorista().getNome().equals(comboBoxMotorista.getSelectionModel().getSelectedItem().getNome())) {
    		comboBoxMotorista.getSelectionModel().selectNext();
    		seguranca++;
    		if(seguranca > 100) {
    			break;
    		}
    	}
    	
    	
    	
    	//Esse aqui ta meio bugado, esse n�o � a forma correta de fazer, mas da forma correta n�o funciona :/

    	comboBoxVeiculo.getSelectionModel().selectFirst();
    	int seguranca1 = 0;
    	// O while abaixo pode ser um pouco confuso, mas basicamente ele verifica se o que est� selecionado na combobox � igual ao veiculo da viagem  	
    	while(!viagem.getVeiculo().getPlaca().equals(comboBoxVeiculo.getSelectionModel().getSelectedItem().getPlaca())) {
    		comboBoxVeiculo.getSelectionModel().selectNext();
    		seguranca1++;
    		if(seguranca1 > 100) {
    			break;
    		}
    	}
    	
    }
    
    
    @FXML
    void exibirDicaFlutuante(MouseEvent event) {
    	if (event.getTarget().toString().contains("textFieldId")) {
        	labelDicaFlutuante.setText("ID");
        	labelDicaFlutuante.setVisible(true);
    	}else if (event.getTarget().toString().contains("textFieldInicio")) {
        	labelDicaFlutuante.setText("In�cio");
        	labelDicaFlutuante.setVisible(true);
    	}else if (event.getTarget().toString().contains("textFieldTotal")) {
        	labelDicaFlutuante.setText("Total");
        	labelDicaFlutuante.setVisible(true);
    	}else if (event.getTarget().toString().contains("datePickerPrazo")) {
        	labelDicaFlutuante.setText("Prazo");
        	labelDicaFlutuante.setVisible(true);
    	}else if (event.getTarget().toString().contains("textFieldDestino")) {
        	labelDicaFlutuante.setText("Destino");
        	labelDicaFlutuante.setVisible(true);
    	}else if (event.getTarget().toString().contains("textFieldCarga")) {
        	labelDicaFlutuante.setText("Carga");
        	labelDicaFlutuante.setVisible(true);
    	}else if (event.getTarget().toString().contains("textFieldSituacao")) {
        	labelDicaFlutuante.setText("Situa��o");
        	labelDicaFlutuante.setVisible(true);
    	}else if (event.getTarget().toString().contains("comboBoxMotorista")) {
        	labelDicaFlutuante.setText("Motorista");
        	labelDicaFlutuante.setVisible(true);
    	}else if (event.getTarget().toString().contains("comboBoxVeiculo")) {
        	labelDicaFlutuante.setText("Ve�culo");
        	labelDicaFlutuante.setVisible(true);
    	}
    	
    	labelDicaFlutuante.setLayoutX(event.getSceneX());
    	labelDicaFlutuante.setLayoutY(event.getSceneY());
    }
    @FXML
    void esconderDicaFlutuante(MouseEvent event) {
    	labelDicaFlutuante.setVisible(false);
    	
    }
    
    private void carregarTableView(){
    	Viagem viagem = new Viagem();
    	
    	listaDeViagens = viagem.listarViagens();
    	
    	obsListViagens = FXCollections.observableArrayList(listaDeViagens);
    	
    	
    	colunaId.setCellValueFactory(new PropertyValueFactory<>("id"));
    	colunaEmpresaDestino.setCellValueFactory(new PropertyValueFactory<>("destino"));
    	colunaMotorista.setCellValueFactory(new PropertyValueFactory<>("nomeMotorista"));
    	
    	tabela.setItems(obsListViagens);
    }
    
    private void carregarComboBoxs() {
    	
    	listaDeMotoristas = motorista.listarMotoristas();
    	obsListMotorista = FXCollections.observableArrayList(listaDeMotoristas);
		comboBoxMotorista.setItems(obsListMotorista);

		
    	listaDeVeiculos = veiculo.listarVeiculos();
    	listaDeVeiculos.add(0, new Veiculos(0, "Selecione um ve�culo..."));
    	obsListVeiculo = FXCollections.observableArrayList(listaDeVeiculos);
		comboBoxVeiculo.setItems(obsListVeiculo);

    }
    
    
	@FXML
	void pesquisarViagens(ActionEvent event) {
		if(!campoDeBuscaMotorista.getText().isEmpty() || !campoDeBuscaEmpresaDestino.getText().isEmpty()){
			
			String empresaRequisitado = campoDeBuscaEmpresaDestino.getText().toLowerCase();
			String motoristaRequisitado = campoDeBuscaMotorista.getText().toLowerCase();
 
			// Caso n�o existe nada no campo pesquisado, ele retorna "", uma string vazia, por�m "" existe em todas as strings
			//ent�o � necess�rio criar um pequeno filtro para ele n�o retornar pesquisas incorretas e pesquisar de acordo com os campos preenchidos
			listaDeViagens.forEach(viagem -> {
				boolean empresa = false;
				boolean motorista = false;
				boolean tudo = false;

				// Nessa parte ele checa se est� utilizando todos os campos de pesquisa ou somente alguns
				if(!campoDeBuscaEmpresaDestino.getText().isEmpty() && !campoDeBuscaMotorista.getText().isEmpty()) {
					tudo = true;
				}else {
					if(!campoDeBuscaEmpresaDestino.getText().isEmpty()) {
						empresa = true;
					}
					if(!campoDeBuscaMotorista.getText().isEmpty()) {
						motorista = true;
					}
				}

				// Aqui ele faz definitivamente a pesquisa, de acordo com estar utilizando todos os campos ou n�o
				if(tudo && viagem.getDestino().toLowerCase().contains(empresaRequisitado) && viagem.getNomeMotorista().contains(motoristaRequisitado)) {
					listaDeViagensPesquisa.add(viagem);
				}else if(empresa && viagem.getDestino().toLowerCase().contains(empresaRequisitado)) {
					listaDeViagensPesquisa.add(viagem);
				}else if(motorista && viagem.getNomeMotorista().toLowerCase().contains(motoristaRequisitado)) {
					listaDeViagensPesquisa.add(viagem);
				}
			});

			obsListViagensPesquisa = FXCollections.observableArrayList(listaDeViagensPesquisa);

			tabela.setItems(obsListViagensPesquisa);

			// Limpa as listas para n�o acumular com a pr�xima pesquisa
			listaDeViagensPesquisa.clear();
		}else {
			// Se n�o houver nada escrito nos campos, reseta a tabela mostrando todo o conte�do
			tabela.setItems(obsListViagens);
		}
	}
    
    
    
    @FXML
    private void descartarAlteracoes(ActionEvent event) {
    	carregarInfoViagem();
    	desabilitarEdicao();
    }
    @FXML
    private void habilitarEdicao(ActionEvent event) {
    	textFieldDestino.setDisable(false);
    	textFieldCarga.setDisable(false);
    	comboBoxMotorista.setDisable(false);
    	comboBoxVeiculo.setDisable(false);
    	datePickerPrazo.setDisable(false);
    	botaoSalvar.setDisable(false);
    	botaoDescartar.setDisable(false);
    }
    private void desabilitarEdicao() {
    	textFieldInicio.setDisable(true);
    	textFieldTotal.setDisable(true);
    	textFieldDestino.setDisable(true);
    	textFieldCarga.setDisable(true);
    	textFieldSituacao.setDisable(true);
    	comboBoxMotorista.setDisable(true);
    	comboBoxVeiculo.setDisable(true);
    	datePickerPrazo.setDisable(true);
    	botaoSalvar.setDisable(true);
    	botaoDescartar.setDisable(true);
    }
	@FXML
	void confirmarAlteracao(ActionEvent event) {
		if(paneAvisosConfirmar.isVisible()) {
			if(passwordFieldConfirmarSenha.getText().equals(ControlesLogin.senha)) {
				confirmado = true;
			}else {
				confirmado = false;
			}
		}		
		
		fecharAviso(event);	
		switch(funcao) {
			case "Veiculo":
				salvarAlteracoes(event);
				break;
			case "ExcluirViagem":
				excluirViagem(event);
				break;
		}
			
	}
	
	void notificar(String tipoDeAviso, String titulo, String texto) {
		paneAvisosPrincipal.setDisable(false);
		paneAvisosPrincipal.setVisible(true);
		paneAvisosSombra.setVisible(true);
		paneAvisosSombra.setDisable(false);
		switch (tipoDeAviso) {
		case "Sucesso":
			paneAvisosSucesso.setDisable(false);
			paneAvisosSucesso.setVisible(true);
			labelAvisosTextoSucesso.setText(texto);
			labelAvisosTituloSucesso.setText(titulo);
			break;
		case "Falha":
			paneAvisosFalha.setDisable(false);
			paneAvisosFalha.setVisible(true);
			labelAvisosTextoFalha.setText(texto);
			labelAvisosTituloFalha.setText(titulo);
			break;
		case "Confirmar":
			paneAvisosConfirmar.setDisable(false);
			paneAvisosConfirmar.setVisible(true);
			labelAvisosTextoConfirmar.setText(texto);
			labelAvisosTituloConfirmar.setText(titulo);
			passwordFieldConfirmarSenha.setText("");
			break;
		}
	}
    @FXML
    void fecharAviso(ActionEvent event){
    	paneAvisosPrincipal.setDisable(true);
    	paneAvisosPrincipal.setVisible(false);
    	paneAvisosSombra.setVisible(false);
    	paneAvisosSombra.setDisable(true);
		paneAvisosSucesso.setDisable(true);
		paneAvisosSucesso.setVisible(false);
		paneAvisosFalha.setDisable(true);
		paneAvisosFalha.setVisible(false);
		paneAvisosConfirmar.setDisable(true);
		paneAvisosConfirmar.setVisible(false);
		
		
    }
    @FXML
    void abrirTelaCadFunc(MouseEvent event) {
    	Main.trocarTela("Tela Cadastrar Funcionarios");
    }
    
    @FXML
    void abrirTelaFunc(MouseEvent event) {
    	Main.trocarTela("Tela Funcionarios");
    }


    @FXML
    void voltar(ActionEvent event) {
    	if(paneViagemSelecionada.isVisible()) {
    		paneViagemSelecionada.setVisible(false);
    		paneViagemSelecionada.setDisable(true);
    		
    		paneSelecionarViagem.setVisible(true);
    		paneSelecionarViagem.setDisable(false);
    		
    	}else {
        	Main.trocarTela("Tela Boas Vindas");
    	}

    	
    }
    
    @FXML
    void minimizarJanela(ActionEvent event) {
    	Main.minimizar();
    }
    
    // Fun��o para fechar a janela ao clicar no " x "
    @FXML
    void fecharJanela(ActionEvent event) {
    	Main.trocarTela("Tela Login");
    }

    
    
    public void tarefasEmLoop() {
    	if(atualizarInfos) {
    		carregarTableView();
    		carregarComboBoxs();
    		atualizarInfos = false;
    	}
    }
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		carregarTableView();
		carregarComboBoxs();
		desabilitarEdicao();
		
        Timer myTimer = new Timer();
        myTimer.schedule(new TimerTask(){
       

          @Override
          public void run() {
        	  Platform.runLater(() -> tarefasEmLoop());
          }
        }, 0, 1000);
	}

}
