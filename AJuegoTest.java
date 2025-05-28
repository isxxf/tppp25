package TrabajoPractico;

public class AJuegoTest {

    public static void main(String[] args) {
        // 1. Crear un mapa pequeño (3x3 para pruebas)
        Mapa mapa = new Mapa(7, 7);
        mapa.Misiones(1);
        // 3. Mostrar el mapa
        System.out.println("=== Mapa de prueba ===");
        mapa.mostrar();

    }

}
