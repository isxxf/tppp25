package TrabajoPractico;

import java.util.Random;

public class Mapa {

    private Celda[][] celdas;
    private int filas;
    private int columnas;
    private Random rnd = new Random();
    private Snake snake;
    private int cantGuardias = 0;

    public Mapa(int filas, int columnas) {
        this.filas = filas;
        this.columnas = columnas;
        this.celdas = new Celda[filas][columnas];
        this.snake = new Snake();
        inicializar();
    }

    private void inicializar() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                celdas[i][j] = new Celda();
            }
        }
    }

    private Posicion generarPosicionAleatoria() {
        return new Posicion(rnd.nextInt(filas), rnd.nextInt(columnas));
    }

    public boolean celdaEstaVacia(Posicion pos) {
        return celdas[pos.getX()][pos.getY()].estaVacio();
    }

    private void colocarObjeto(Objeto objeto) {
        boolean colocado = false;
        while (!colocado) {
            Posicion pos = generarPosicionAleatoria();
            if (celdaEstaVacia(pos)) {
                celdas[pos.getX()][pos.getY()].setObjeto(objeto);
                colocado = true;
            }
        }
    }

    private void colocarGuardias(int cantidad) {
        int guardiasColocados = 0;
        while (guardiasColocados < cantidad) {
            Posicion pos = generarPosicionAleatoria();
            if (celdaEstaVacia(pos)) {
                Guardia guardia = new Guardia();
                guardia.setPosicion(pos);
                celdas[pos.getX()][pos.getY()].setPersonaje(guardia);
                guardiasColocados++;
            }
        }
    }

    private void colocarSnake() {
        boolean colocado = false;
        while (!colocado) {
            Posicion pos = generarPosicionAleatoria();
            if (celdaEstaVacia(pos) && estaLejosDeAsteriscos(pos.getX(), pos.getY())) {
                snake.setPosicion(pos);
                celdas[pos.getX()][pos.getY()].setPersonaje(snake);
                colocado = true;
            }
        }
    }

    private boolean estaLejosDeAsteriscos(int fila, int col) {
        boolean estaLejos = true;
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (celdas[i][j].toString().contains("*")) {
                    int distancia = Math.abs(fila - i) + Math.abs(col - j);
                    if (distancia < 3) {
                        estaLejos = false;
                    }
                }
            }
        }
        return estaLejos;
    }

    public void Misiones(int tipoMision) {
        switch (tipoMision) {
            case 1:
                colocarObjeto(new Objeto("Hangar"));
                colocarObjeto(new Objeto("Llave"));
                colocarGuardias(4);
                break;
            case 2:
                colocarObjeto(new Objeto("C4"));
                colocarObjeto(new Objeto("Puerta"));
                colocarGuardias(5);
                break;

        }
        colocarSnake();
    }

    private boolean esPosicionValida(Posicion pos) {
        return pos.getX() >= 0 && pos.getX() < filas
                && pos.getY() >= 0 && pos.getY() < columnas;
    }

    public void movPersonaje(Personaje personaje, Posicion nuevaPos) {

    }

    public void movGuardias() {

    }

    public void mostrar() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print("|" + celdas[i][j].toString());
            }
            System.out.println("|");
        }
    }
}
