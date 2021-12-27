package clases;

import java.util.List;

public class Viaje {

    protected String localizador;
    protected String origen;
    protected String destino;
    protected String fechaIda; // cambiar el string
    protected String fechaVuelta;
    protected int aforo;
    protected List<Actividad> listaActividades;

    public Viaje(String localizador, String origen, String destino, String fechaIda, String fechaVuelta, int aforo,
            List<Actividad> listaActividades) {
        this.localizador = localizador;
        this.origen = origen;
        this.destino = destino;
        this.fechaIda = fechaIda;
        this.fechaVuelta = fechaVuelta;
        this.aforo = aforo;
        this.listaActividades = listaActividades;
    }
    
    public Viaje() {
        this.localizador = "";
        this.origen = "";
        this.destino = "";
        this.fechaIda = "";
        this.fechaVuelta = "";
        this.aforo = 0;
        this.listaActividades = null;
    }

    public String getLocalizador() {
        return this.localizador;
    }

    public void setLocalizador(String localizador) {
        this.localizador = localizador;
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

    public int getAforo() {
        return this.aforo;
    }

    public void setAforo(int aforo) {
        this.aforo = aforo;
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
            "localizador='" + getLocalizador() + "'" +
            ", origen='" + getOrigen() + "'" +
            ", destino='" + getDestino() + "'" +
            ", fechaIda='" + getFechaIda() + "'" +
            ", fechaVuelta='" + getFechaVuelta() + "'" +
            ", aforo='" + getAforo() + "'" +
            ", listaActividades='" + getListaActividades() + "'" +
            "}";
    }   
}
