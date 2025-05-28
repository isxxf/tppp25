package TrabajoPractico;

public class Objeto {

    private String tipo;
    private Posicion posicion;

    public Objeto(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void recoger() {
        System.out.println("Objeto " + tipo + " recogido");
    }

    public Posicion getPosicion() {
        return posicion;
    }

    public void setPosicion(Posicion posicion) {
        this.posicion = posicion;
    }

    public char getSimbolo() {
        switch (tipo) {
            case "Hangar":
                return 'H';
            case "Llave":
                return 'L';
            default:
                return ' ';
        }
    }
}
