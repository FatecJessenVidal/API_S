package application;
	
import java.io.IOException;

import application.models.Usuario;
import application.models.dao.UsuarioSQL;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;



public class Main extends Application {
	private Stage primaryStage;
    private BorderPane rootLayout;

    @Override
    public void start(Stage primaryStage) {
    	
    	Usuario user = new Usuario("isa", "45895874231", "chlopes", "123456", "user");
    	
    	System.out.println(user.nome_user+" "+user.cpf_user);
    	
    	UsuarioSQL database = new UsuarioSQL();
    	
    	database.create(user);
    	
    	System.out.println(database.all());    	
    	
    	System.exit(0);
    	
    	
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("AddressApp");

        initRootLayout();

        showPersonOverview();
    }
    
    /**
     * Inicializa o root layout (layout base).
     */
    public void initRootLayout() {
        try {
            // Carrega o root layout do arquivo fxml.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("Menu.fxml"));
            rootLayout = (BorderPane) loader.load();
            
            // Mostra a scene (cena) contendo o root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Mostra o person overview dentro do root layout.
     */
    public void showPersonOverview() {
        try {
            // Carrega o person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("CadastroUsuario.fxml"));
            AnchorPane cadastroUsuario = (AnchorPane) loader.load();
//            cadastroUsuario.
            
            // Define o person overview dentro do root layout.
//            rootLayout.setCenter(cadastroUsuario);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
	/**
	 * Retorna o palco principal.
	 * @return
	 */
	public Stage getPrimaryStage() {
		return primaryStage;
	}

    public static void main(String[] args) {
        launch(args);
    }
}
