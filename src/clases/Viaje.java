package clases;

import java.util.List;

public class Viaje {

    protected String tipo;
    protected String origen;
    protected String destino;
    protected String fechaIda; // cambiar el string
    protected String fechaVuelta;
    protected int cantBilletes;
    protected List<Actividad> listaActividades;

    public Viaje(String tipo, String origen, String destino, String fechaIda, String fechaVuelta, int cantBilletes,
            List<Actividad> listaActividades) {
        this.tipo = tipo;
        this.origen = origen;
        this.destino = destino;
        this.fechaIda = fechaIda;
        this.fechaVuelta = fechaVuelta;
        this.cantBilletes = cantBilletes;
        this.listaActividades = listaActividades;
    }
    
    public Viaje() {
        this.tipo = "";
        this.origen = "";
        this.destino = "";
        this.fechaIda = "";
        this.fechaVuelta = "";
        this.cantBilletes = 0;
        this.listaActividades = null;
    }

    public String getTipo() {
        return this.tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getOrigen() {
        return this.origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return this.destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getFechaIda() {
        return this.fechaIda;
    }

    public void setFechaIda(String fechaIda) {
        this.fechaIda = fechaIda;
    }

    public String getFechaVuelta() {
        return this.fechaVuelta;
    }

    public void setFechaVuelta(String fechaVuelta) {
        this.fechaVuelta = fechaVuelta;
    }

    public int getCantBilletes() {
        return this.cantBilletes;
    }

    public void setCantBilletes(int cantBilletes) {
        this.cantBilletes = cantBilletes;
    }

    public List<Actividad> getListaActividades() {
        return this.listaActividades;
    }

    public void setListaActividades(List<Actividad> listaActividades) {
        this.listaActividades = listaActividades;
    }

    @Override
    public String toString() {
        return "{" +
            " tipo='" + getTipo() + "'" +
            ", origen='" + getOrigen() + "'" +
            ", destino='" + getDestino() + "'" +
            ", fechaIda='" + getFechaIda() + "'" +
            ", fechaVuelta='" + getFechaVuelta() + "'" +
            ", cantBilletes='" + getCantBilletes() + "'" +
            ", listaActividades='" + getListaActividades() + "'" +
            "}";
    }   
}
