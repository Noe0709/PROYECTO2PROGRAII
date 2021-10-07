package TipoAutomotor;

import units.PVehiculo;
import java.util.Date;
import CControl.SetDatos;

/**
 *
 */
public class Moto extends Vehiculo{

    /**
     *
     */
    public Moto(){

    }

    /**
     *
     * @param noEstacionamiento
     * @param placa
     * @param fechayHoraEntrada
     * @param tipoVehiculo
     * @param segundos
     */
    public Moto(int noEstacionamiento, String placa, Date fechayHoraEntrada,    PVehiculo tipoVehiculo, int segundos) {
        super(noEstacionamiento, placa, fechayHoraEntrada, tipoVehiculo, segundos);
    }

    /**
     *
     * @param tiempo
     * @param tarifa
     * @return
     */
    public double monto(int tiempo, double tarifa){
        double monto = tiempo * tarifa;
        double montoTotal = monto-(monto*0.10);
        return montoTotal;
    }

}





