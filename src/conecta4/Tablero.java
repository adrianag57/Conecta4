package conecta4;

public class Tablero {

	private int[] donde;
	private char[][] tablero;

	private final int FILAS = 6;
	private final int COLUMNAS = 7;

	private char turno;

	public Tablero() {

		turno = 'X';
		tablero = new char[FILAS][COLUMNAS];
		donde = new int[COLUMNAS];

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
			}
		}

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

		return devolver;
	}

}
