package clases;

import java.util.List;

public class Billete {

    protected String localizadorBillete;
    protected String localizadorViaje;
    protected List<Actividad> listaActividades;

    public Billete(String localizadorBillete, String localizadorViaje, List<Actividad> listaActividades) {
        this.localizadorBillete = localizadorBillete;
        this.localizadorViaje = localizadorViaje;
        this.listaActividades = listaActividades;
    }

    public Billete() {
        this.localizadorBillete = "";
        this.localizadorViaje = "";
        this.listaActividades = null;
    }

    public String getLocalizadorBillete() {
        return this.localizadorBillete;
    }

    public void setLocalizadorBillete(String localizadorBillete) {
        this.localizadorBillete = localizadorBillete;
    }

    public String getLocalizadorViaje() {
        return this.localizadorViaje;
    }

    public void setLocalizadorViaje(String localizadorViaje) {
        this.localizadorViaje = localizadorViaje;
    }

    public List<Actividad> getListaActividades() {
        return this.listaActividades;
    }

    public void setListaActividades(List<Actividad> listaActividades) {
        this.listaActividades = listaActividades;
    }

    public Billete localizadorBillete(String localizadorBillete) {
        setLocalizadorBillete(localizadorBillete);
        return this;
    }

    public Billete localizadorViaje(String localizadorViaje) {
        setLocalizadorViaje(localizadorViaje);
        return this;
    }

    public Billete listaActividades(List<Actividad> listaActividades) {
        setListaActividades(listaActividades);
        return this;
    }

    @Override
    public String toString() {
        return "{" +
            " localizadorBillete='" + getLocalizadorBillete() + "'" +
            ", localizadorViaje='" + getLocalizadorViaje() + "'" +
            ", listaActividades='" + getListaActividades() + "'" +
            "}";
    }
}
