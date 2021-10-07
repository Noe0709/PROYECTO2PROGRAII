package units;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * Este metodo y clase inician la aplicacion para ejecutarse la primera vez y viajar entre clases.
 */
public class Main extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception {
        /**
         * busca en la ubicacion de archivos en la maquina para activar la interfaz
         */
        Pane root = (Pane) FXMLLoader.load(getClass().getResource("/view/SetDatos.fxml"));
        primaryStage.setTitle("CONFIGURAR DATOS PARA EL ESTACIONAMIENTO");
        Scene scene = new Scene(root, 600,400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * Ejecucion Main
     * @param args para ejecutar todo el programa
     */
    public static void main(String[] args) {
        launch(args);
    }

}
