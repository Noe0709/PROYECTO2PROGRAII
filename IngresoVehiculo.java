package CControl;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import java.util.ArrayList;
import java.util.Date;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import TipoAutomotor.*;
//import units.Compressed;
import units.*;
import java.time.LocalTime;
import java.io.*;
import java.net.*;

/**
 * Se ingresa los totales de parqueos que hay para luego contarlos
 */
public class IngresoVehiculo {
    private int contMotos;
    private int contCamiones;
    private int contCarros;
    public static ArrayList<Vehiculo> v = new ArrayList<>();
    public TextField txtPlaca;
    public Button volver;
    public TextField txtMensaje;
    Compressed sv = new Compressed();

    /**
     * Se calcula el tiempo en el cual el vehiculo estara dentro del parqueo se utiliza localtime la cual mide
     * desde que se realiza la primera accion hasta que deja de funcionar
     * @param actionEvent Conecta con el SB.
     */
    public void grabarPlaca(ActionEvent actionEvent){
        String placa = txtPlaca.getText();
        txtPlaca.setText("");
        Date fecha = new Date();
        boolean lleno = true;
        LocalTime HoraInicio = LocalTime.now();
        int startTime = sv.calcularTiempo(HoraInicio);
        if(placa.charAt(0) == 'P' && contCarros < SetDatos.estCar){
            contCarros++;
            Vehiculo c = new Vehiculo(contCarros, placa, fecha, PVehiculo.CARRO, startTime);
            lleno = false;
            v.add(c);
            try{
                sv.generarTicket(contCarros, placa, fecha);
                txtMensaje.setText("El ticket fue generado");
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
        if(placa.charAt(0) == 'M' && contMotos < SetDatos.estMo) {
            contMotos++;
            Vehiculo m = new Vehiculo(contMotos, placa, fecha, PVehiculo.MOTO, startTime);
            lleno = false;
            v.add(m);
            try{
                sv.generarTicket(contMotos, placa, fecha);
                txtMensaje.setText("El ticket fue generado");
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
        if(placa.charAt(0) == 'C' && contCamiones < SetDatos.estCam){
            contCamiones++;
            Vehiculo c = new Vehiculo(contCamiones, placa, fecha, PVehiculo.CAMION, startTime);
            lleno = false;
            v.add(c);
            try{
                sv.generarTicket(contCamiones, placa, fecha);
                txtMensaje.setText("El ticket fue generado");
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
        if(lleno == true){
            txtMensaje.setText("El estacionamiento esta lleno");
        }
    }

    /**
     *
     * @param actionEvent Conecta con el scene Builder
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

    /**
     * Conecta los sockets (no salio)
     */
    public static final int PUERTO = 4182;
    public static final String HOST = "localhost";
    public static String mensajeCliente;
    public static Socket cs;
    public static DataOutputStream salidaServidor;
    public static TextField txtTotal;
    public static TextField txtDisponibles;
    public static TextField txtOcupados;

    /**
     * Metodo para iniciar el programa
     */
    public static void startCliente(){
        int cont = 1;
        try{
            cs = new Socket(HOST, PUERTO);

            cs.close();

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    /**
     * Inicia la parte de la interfaz conectando con el metodo
     * @param actionEvent Conecta con el SB.
     */
    public void iniciarCliente(ActionEvent actionEvent){
        startCliente();
    }
}

