package conecta4;

import java.util.Iterator;

public class Tablero {

	private int[] donde;
	private char[][] tablero;

	private final int FILAS = 6;
	private final int COLUMNAS = 7;

	private char turno;
	private boolean ganador;

	public Tablero() {

		turno = 'X';
		tablero = new char[FILAS][COLUMNAS];
		donde = new int[COLUMNAS];
		ganador = false;

		for (int i = 0; i < COLUMNAS; i++) {

			donde[i] = FILAS - 1;
		}
	}

	public void coloca(int columna) {

		if ((columna >= 0) & (columna < COLUMNAS)) {

			if (donde[columna] >= 0) {

				int fila = donde[columna];
				tablero[fila][columna] = turno;
				donde[columna]--;
				turno = (turno == 'X') ? 'O' : 'X';

				ganador = hayGanadorVertical(fila, columna);
//					ganador = ganador || hayGanadorHorizontal(fila, columna);
				ganador |= hayGanadorHorizontal(fila, columna);
				ganador |= hayGanadorDiagonalPrincipal(fila, columna);
				ganador |= hayGanadorDiagonalSecundario(fila, columna);
			}
		}

	}
	
	private boolean hayGanadorDiagonalSecundario(int fila, int columna) {
		
		int coincidencias = 0;

		int retroceso = (columna < fila) ? columna : fila;
		char ficha = tablero[fila][columna];

		int i = fila - retroceso;
		int j = columna - retroceso;

		while ((i < FILAS) && (j < COLUMNAS) && (coincidencias < 4)) {

			// comparar con la ficha
			// contar las coincidencias
			if (tablero[i][j] == ficha) {

				coincidencias++;
			} else
				coincidencias = 0;
			i++;
			j++;
		}

		boolean devolver = false;
		if (coincidencias == 4) {

			devolver = true;
		}

		return devolver;
	}

	private boolean hayGanadorDiagonalPrincipal(int fila, int columna) {

		int coincidencias = 0;

		int retroceso = (fila < columna) ? fila : columna;
		char ficha = tablero[fila][columna];

		int i = fila - retroceso;
		int j = columna - retroceso;

		while ((i < FILAS) && (j < COLUMNAS) && (coincidencias < 4)) {

			// comparar con la ficha
			// contar las coincidencias
			if (tablero[i][j] == ficha) {

				coincidencias++;
			} else
				coincidencias = 0;
			i++;
			j++;
		}

		boolean devolver = false;
		if (coincidencias == 4) {

			devolver = true;
		}

		return devolver;
	}

	private boolean hayGanadorHorizontal(int fila, int columna) {

		char ficha = tablero[fila][columna];

		int i = 0;
		int coincidencias = 0;
		// mientras no encuentre 4
		// mientras no llegue al final
		while ((i < COLUMNAS) && (coincidencias < 4)) {

			// comparar con la ficha
			// contar las coincidencias
			if (tablero[fila][i] == ficha) {

				coincidencias++;
			} else
				coincidencias = 0;
			i++;
		}

		boolean devolver = false;
		if (coincidencias == 4) {

			devolver = true;
		}

		return devolver;
	}

	private boolean hayGanadorVertical(int fila, int columna) {

		char mirarChar = tablero[fila][columna];
		int coincidencia = 0;

		if (fila <= 2) {

			for (int i = fila + 1; i <= fila + 3; i++) {

				if (tablero[i][columna] == mirarChar) {

					coincidencia++;
				}
			}
		}

		boolean devolver = false;
		if (coincidencia == 3) {

			devolver = true;
		}

		return devolver;
	}

	@Override
	public String toString() {

		String devolver = "";

		for (int i = 0; i < FILAS; i++) {

			for (int j = 0; j < COLUMNAS; j++) {

				devolver += tablero[i][j] + " ";
			}
			devolver += "\n";
		}
		for (int j = 0; j < COLUMNAS; j++) {

			devolver += "- ";
		}
		devolver += "\n";
		for (int j = 0; j < COLUMNAS; j++) {

			devolver += j + " ";
		}

		if (ganador) {

			devolver += "\n ya gano alguien\n";
		}

		return devolver;
	}

	public boolean hayGanador() {

		return ganador;
	}

}
