package TrabajoPractico;

public class Celda {

    private Personaje personaje;
    private Objeto objeto;

    public Personaje getPersonaje() {
        return personaje;
    }

    public void setPersonaje(Personaje personaje) {
        this.personaje = personaje;
    }

    public Objeto getObjeto() {
        return objeto;
    }

    public void setObjeto(Objeto objeto) {
        this.objeto = objeto;
    }

    public boolean estaVacio() {
        return personaje == null && objeto == null;
    }

    @Override
    public String toString() {
        if (personaje != null) {
            return " " + personaje.getSimbolo() + " ";
        } else if (objeto != null) {
            return " " + objeto.getSimbolo() + " ";
        } else {
            return "   ";
        }

    }

}
