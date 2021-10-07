package CControl;

import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.control.Button;
//import units.Compressed;
import units.*;

/**
 *Es donde se colocan los controladores para poder referenciar en el scene Builder
 * a cada uno se le coloca el identtificador asignado en la parte grafica.
 */
public class SetDatos {
    public TextField txtMotos;
    public TextField txtCarros;
    public TextField txtCamiones;
    public TextField txtTarifa;
    public TextField txtMensaje;
    public Button cerrarPestania;
    public static int estMo;
    public static int estCar;
    public static int estCam;
    public static double tarifa;
    Compressed sv = new Compressed();
    /**Los datos se declaran static porque se fijaron para usarlos en otras clases para no instanciar objetos.
    // Esto para usarlos desde donde se quiera.

    /**
     * Lugar donde se realiza la conversion de tipos de string a entero ya que inicialmente se
     * pide que se ingrese un caracter tipo string para convertirlo a entero.
     * Tambien aca es donde el Scenne Builder buscar el metodo para proseguir
     * @param actionEvent es para conectar con su Scene Builder correspondiente
     */
    public void grabarDatos(ActionEvent actionEvent){
        int esMo = Integer.parseInt(txtMotos.getText());
        estMo = esMo;
        int esCar = Integer.parseInt(txtCarros.getText());
        estCar = esCar;
        int esCam = Integer.parseInt(txtCamiones.getText());
        estCam = esCam;
        double ctarifa = Double.parseDouble(txtTarifa.getText());
        tarifa = ctarifa;
        /**
         * para eliminar los datos una vez sean guardados de lo contrario quedaria con el mismo
         * numero que se coloco.
         */
        txtMotos.setText("");
        txtCarros.setText("");
        txtCamiones.setText("");
        txtTarifa.setText("");
        txtMensaje.setText("Informacion grabada satisfactoriamente");
    }

    /**
     * Metodo principal para conectar
     * @param actionEvent es para conectar con su Scene Builder correspondiente
     * @throws Exception lo que sea invocado es lo que maneja la excepcion, esto para evitar problemas con los xml.loaders
     */
    public void MenuBase(ActionEvent actionEvent) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/MenuBase.fxml"));
        Pane root = (Pane) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle("Menu Principal");
        stage.setScene(new Scene(root, 600, 400));
        stage.show();
        /**
         * Buscar el metodo para poder cerrar la pestaña
         */
        sv.salirGeneral(cerrarPestania);
    }

}

