package conecta4;

import java.util.Scanner;

public class Start {

	public static void main(String[] args) {

		Scanner teclado = new Scanner(System.in);
		Tablero tablero = new Tablero();
		
		while (!tablero.hayGanador()) {
			
			int donde = teclado.nextInt();
			tablero.coloca(donde);
			System.out.println(tablero);
		}

	}

}
