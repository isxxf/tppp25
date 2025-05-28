package TrabajoPractico;

public abstract class Mision {

    protected String nombre;
    protected String objetivo;
    protected Mapa mapa;
    protected boolean completada = false;

    protected Mision(int filas, int columnas) {
        this.mapa = new Mapa(filas,columnas);
    }

    public void mostrarMapa() {
        mapa.mostrar();
    }

    public String getObjetivo() {
        return objetivo;
    }

    public boolean isCompletada() {
        return completada;
    }
        
    public abstract void iniciar();
}
