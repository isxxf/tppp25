package TrabajoPractico;

public abstract class Personaje {
    private Posicion posicion;

    public Posicion getPosicion() {
        return posicion;
    }

    public void setPosicion(Posicion posicion) {
        this.posicion = posicion;
    }
    
    public abstract void mover();
    public abstract char getSimbolo();
}
