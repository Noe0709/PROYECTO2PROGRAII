package Servidor;

import java.io.*;
import java.net.*;
import CControl.*;


public class Servidor {
    public static final int PUERTO = 4182;
    public static String mensajeServidor;
    public static ServerSocket ss;
    public static Socket cs;
    public static DataOutputStream salidaCliente;
    public static double totalDia = 0;

    public static void calcularTotal(double montos){
        totalDia = totalDia + montos;
    }


    public static void startServer(){
        //int estacionamientosOcupados = IngresarVehiculo.v.size();
        //int totalEstacionamientos = EstablecerDatos.estMo + EstablecerDatos.estCar + EstablecerDatos.estCam;
        //int estacionamientosLibres = totalEstacionamientos - estacionamientosOcupados;
        try{
            ss = new ServerSocket(PUERTO);
            cs = new Socket();
            cs = ss.accept();
            //salidaCliente = new DataOutputStream(cs.getOutputStream());
            //salidaCliente.writeUTF(totalDia + "\n");
            //salidaCliente.writeUTF(estacionamientosOcupados + "\n");
            //salidaCliente.writeUTF(estacionamientosLibres + "\n");
            ss.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }



}
