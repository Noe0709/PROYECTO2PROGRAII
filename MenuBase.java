package CControl;

import Servidor.Servidor;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import units.Compressed;

/**
 * Conector entre el scene Builder y los botones para poder egresar del sistema se
 * realizaron independientes ya que era factible de esta manera
 */
public class MenuBase {
    public Button salirSistema1;
    public Button salirSistema2;
    public Button salirSistema3;
    Compressed sv = new Compressed();


    /**
     * Levanta la interfaz y vuelve a llamar el metodo para cerrar la ventana anterior y abrir la nueva
     * @param actionEvent Conecta con SB.
     * @throws Exception Permite evitar problemas con fxml
     */
    public void ingresarVehiculo(ActionEvent actionEvent) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/IngresoVehiculo.fxml"));
        Pane root = (Pane) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle("Ingresar Vehiculo");
        stage.setScene(new Scene(root, 600, 400));
        stage.show();
        sv.salirGeneral(salirSistema1);
    }

    /**
     * opcion para retirar el vehiculo conectada con el boton en el scenne builder
     * @param actionEvent conector con el scenne builder
     * @throws Exception Para evitar problemas con el xml
     */
    public void retirarVehiculo(ActionEvent actionEvent) throws Exception{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/SalidaVehiculo.fxml"));
        Pane root = (Pane) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle("Retirar vehiculo");
        stage.setScene(new Scene(root, 600, 400));
        stage.show();
        sv.salirGeneral(salirSistema2);
    }

    /**
     *
     * @param actionEvent
     */
    public void salir(ActionEvent actionEvent) {
        sv.salirGeneral(salirSistema3);
    }

    /**
     * Metodo para intentar ejecutar la clase servidor
     * @param actionEvent Conecta con el scenne B.
     * @throws Exception para evitar problemas con el pdf y xml.
     */
    public void ejecutarServer(ActionEvent actionEvent) throws Exception{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/ShowData.fxml"));
        Pane root = (Pane) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle("Datos para dueños");
        stage.setScene(new Scene(root, 600, 400));
        stage.show();
        Servidor.startServer(); //arreglar esto
    }
}

