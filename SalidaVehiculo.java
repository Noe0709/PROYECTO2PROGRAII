package CControl;

import Servidor.Servidor;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import units.Compressed;
import units.Compressed;
import java.util.Date;
import java.time.LocalTime;
import TipoAutomotor.*;

/**
 * Metodo para expulsar un vehiculo generando el pdf donde tambien solicita el nit para generar el mismo
 */
public class SalidaVehiculo {
    public TextField txtPlaca;
    public Button volver;
    public TextField txtMensaje;
    public TextField txtNit;
    Compressed sv = new Compressed();
    Moto m = new Moto();
    Carro car = new Carro();
    camion cam = new camion();
    public static double montoTotal = 0;

    /**
     * graba las placas de los botones para que luego se sobreescriba.
     * @param actionEvent Conecta con el SB en el boton para ingresar placas.
     */
    public void grabarPlacas(ActionEvent actionEvent) {
        String placa = txtPlaca.getText();
        txtPlaca.setText("");

        int x = 0;
        LocalTime tiempoFinal = LocalTime.now();
        int endTime = sv.calcularTiempo(tiempoFinal);

        /**
         * Calculo de botones donde se calcula el monto segun el tiempo q el auto estuvo dentro del parqueo
         */
        double tarifa = SetDatos.tarifa;
        if(placa.charAt(0) == 'M'){
            for(x = 0; x<IngresoVehiculo.v.size(); x++){
                if(placa.equals(IngresoVehiculo.v.get(x).getPlaca())){
                    Date dateEntrada = IngresoVehiculo.v.get(x).getFechayHoraEntrada();
                    Date dateSalida = new Date();
                    String nit = txtNit.getText();
                    txtNit.setText("");
                    int startTime = IngresoVehiculo.v.get(x).getSegundos();
                    int totalTime = endTime - startTime;
                    double monto = totalTime*tarifa;
                    double descuento = monto * 0.10;
                    double recargo = 0;
                    montoTotal = m.monto(totalTime, tarifa);
                    Servidor.calcularTotal(montoTotal);
                    IngresoVehiculo.v.remove(x);
                    try{
                        sv.generarFactura(placa, nit, dateEntrada, dateSalida, monto, descuento, recargo, montoTotal);
                        txtMensaje.setText("La factura fue generada");
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                }
            }
        }
        if(placa.charAt(0) == 'P'){
            for(x = 0; x<IngresoVehiculo.v.size(); x++){
                if(placa.equals(IngresoVehiculo.v.get(x).getPlaca())){
                    Date dateEntrada = IngresoVehiculo.v.get(x).getFechayHoraEntrada();
                    Date dateSalida = new Date();
                    String nit = txtNit.getText();
                    txtNit.setText("");
                    int startTime = IngresoVehiculo.v.get(x).getSegundos();
                    int totalTime = endTime - startTime;
                    double monto = totalTime*tarifa;
                    double descuento = 0;
                    double recargo = 0;
                    montoTotal = car.monto(totalTime, tarifa);
                    Servidor.calcularTotal(montoTotal);
                    IngresoVehiculo.v.remove(x);
                    try{
                        sv.generarFactura(placa, nit, dateEntrada, dateSalida, monto, descuento, recargo, montoTotal);
                        txtMensaje.setText("La factura fue generada");
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                }
            }
        }
        if(placa.charAt(0) == 'C'){
            for(x = 0; x<IngresoVehiculo.v.size(); x++){
                if(placa.equals(IngresoVehiculo.v.get(x).getPlaca())){
                    Date dateEntrada = IngresoVehiculo.v.get(x).getFechayHoraEntrada();
                    Date dateSalida = new Date();
                    String nit = txtNit.getText();
                    txtNit.setText("");
                    int startTime = IngresoVehiculo.v.get(x).getSegundos();
                    int totalTime = endTime - startTime;

                    double monto = 30;
                    double descuento = 0;
                    double recargo = 0;
                    int periodos = 0;
                    if(totalTime > 0 && totalTime<=60){
                        recargo = 0;
                        periodos = 1;
                    }
                    if(totalTime > 60 && totalTime<=120){
                        recargo = 5;
                        periodos = 2;
                    }
                    if(totalTime > 120 && totalTime<=180){
                        recargo = 10;
                        periodos = 3;
                    }
                    if(totalTime > 180 && totalTime<=240){
                        recargo = 15;
                        periodos = 4;
                    }
                    if(totalTime > 240 && totalTime<=300){
                        recargo = 20;
                        periodos = 5;
                    }
                    if(totalTime > 300 && totalTime<=360){
                        recargo = 25;
                        periodos = 6;
                    }
                    if(totalTime > 360 && totalTime<=420){
                        recargo = 30;
                        periodos = 7;
                    }
                    if(totalTime > 420 && totalTime<=480){
                        recargo = 35;
                        periodos = 8;
                    }
                    if(totalTime > 480 && totalTime<=540){
                        recargo = 40;
                        periodos = 9;
                    }
                    if(totalTime > 540 && totalTime<=600){
                        recargo = 45;
                        periodos = 10;
                    }
                    if(totalTime > 600 && totalTime<=660){
                        recargo = 50;
                        periodos = 11;
                    }
                    if(totalTime > 660 && totalTime<=720){
                        recargo = 55;
                        periodos = 12;
                    }
                    if(totalTime > 720 && totalTime<=780){
                        recargo = 60;
                        periodos = 13;
                    }
                    montoTotal = cam.monto(periodos);
                    Servidor.calcularTotal(montoTotal);
                    IngresoVehiculo.v.remove(x);
                    try{
                        sv.generarFactura(placa, nit, dateEntrada, dateSalida, monto, descuento, recargo, montoTotal);
                        txtMensaje.setText("La factura fue generada");
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                }
            }
        }
        //txtMensaje.setText("Factura Generada");

    }

    /**
     * Metodo para regresar al menu anterior mediante la direccion local establecida.
     * @param actionEvent Conecta con el SB.
     * @throws Exception
     */
    public void volverMenu(ActionEvent actionEvent) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/MenuBase.fxml"));
        Pane root = (Pane) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle("Menu Principal");
        stage.setScene(new Scene(root, 600, 400));
        stage.show();
        sv.salirGeneral(volver);
    }

}

