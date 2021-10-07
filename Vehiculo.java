package TipoAutomotor;

import units.PVehiculo;
import java.util.Date;

/**
 *
 */
public class Vehiculo {

    private int noEstacionamiento;
    private String placa;
    private Date fechayHoraEntrada;
    private PVehiculo tipoVehiculo;
    private int segundos;

    /**
     *
     */
    public Vehiculo(){}

    /**
     *
     * @param noEstacionamiento
     * @param placa
     * @param fechayHoraEntrada
     * @param tipoVehiculo
     * @param segundos
     */
    public Vehiculo(int noEstacionamiento, String placa, Date fechayHoraEntrada, PVehiculo tipoVehiculo, int segundos) {
        this.noEstacionamiento = noEstacionamiento;
        this.placa = placa;
        this.fechayHoraEntrada = fechayHoraEntrada;
        this.tipoVehiculo = tipoVehiculo;
        this.segundos = segundos;
    }

    /**
     *
     * @return
     */
    public String getPlaca() {
        return placa;
    }

    /**
     *
     * @return
     */
    public int getSegundos() {
        return segundos;
    }

    /**
     *
     * @return
     */
    public Date getFechayHoraEntrada() {
        return fechayHoraEntrada;
    }
}
