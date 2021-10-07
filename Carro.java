package TipoAutomotor;

import units.PVehiculo;
import java.util.Date;

/**
 *
 */
public class Carro extends Vehiculo{

    /**
     *
     */
    public Carro(){

    }

    /**
     *
     * @param noEstacionamiento
     * @param placa
     * @param fechayHoraEntrada
     * @param tipoVehiculo
     * @param segundos
     */
    public Carro(int noEstacionamiento, String placa, Date fechayHoraEntrada, PVehiculo tipoVehiculo, int segundos) {
        super(noEstacionamiento, placa, fechayHoraEntrada, tipoVehiculo, segundos);
    }

    /**
     *
     * @param tiempo
     * @param tarifa
     * @return
     */
    public double monto(int tiempo, double tarifa){

        double montoTotal = tiempo*tarifa;

        return montoTotal;
    }

}


