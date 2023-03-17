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
			}
		}

	}

	private boolean hayGanadorHorizontal(int fila, int columna) {

		char mirarChar = tablero[fila][columna];
		int coincidencia = 0;

		while (coincidencia != 3 ) {

			if (tablero[fila][i] == mirarChar) {

				coincidencia++;
			}
		}

		boolean devolver = false;
		if (coincidencia == 3) {

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
