package TipoAutomotor;

import units.PVehiculo;
import java.util.Date;

/**
 *
 */
public class camion extends Vehiculo{
    public camion(){

    }

    /**
     *
     * @param noEstacionamiento
     * @param placa
     * @param fechayHoraEntrada
     * @param tipoVehiculo
     * @param segundos
     */
    public camion(int noEstacionamiento, String placa, Date fechayHoraEntrada, PVehiculo tipoVehiculo, int segundos) {
        super(noEstacionamiento, placa, fechayHoraEntrada, tipoVehiculo, segundos);
    }

    /**
     *
     * @param periodos
     * @return
     */
    public double monto(int periodos){
        double montoTotal = ((30*periodos)+(5*(periodos-1))-30);
        return montoTotal;
    }
}
