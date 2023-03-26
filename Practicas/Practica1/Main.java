package Practica1;

import java.util.Scanner;

public class P1 {

	public static void main(String[] args) {
		listarNumeros prueba1 = new listarNumeros(3,10);
		multiplos prueba2;
		Scanner s = new Scanner(System.in);

		
		//Ej1
		//prueba.listarConFor();
		//prueba.listarConWhile();
		//prueba.listarSinEstructuras();
		
		//Ej2
		
		int n = s.nextInt();
		prueba2 = new multiplos(n);
		//prueba2.arrMultiplos();
		//System.out.println(prueba2.toString());
		
	}
}
