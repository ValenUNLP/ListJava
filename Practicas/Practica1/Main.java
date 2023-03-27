package Practica1B;

import java.util.Scanner;

public class P1B {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		listarNumeros prueba1 = new listarNumeros(3,10);
		multiplos prueba2;
		test prueba3 = new test();
		int[] arr4 = {1,2,3,4,5,6,9};
		analisisArr prueba4 = new analisisArr(arr4);
		
		//Ej1
		//prueba.listarConFor();
		//prueba.listarConWhile();
		//prueba.listarSinEstructuras();
		
		//Ej2
		
		//int n = s.nextInt();
		//prueba2 = new multiplos(n);
		//prueba2.arrMultiplos();
		//System.out.println(preba2.toString());
		
		//Ej3
		
		//prueba3.llenarEstudiantes();
		//prueba3.leerEstudiantes();
		
		//prueba3.llenarProfesores();
		//prueba3.leerProfesores();
		
		//Ej5
		
		System.out.println("Metodo de devolucion por arreglo: ");
		System.out.println("Maximo: " + prueba4.devolverArr()[0]);
		System.out.println("Minimo: " + prueba4.devolverArr()[1]);
		System.out.println("Promedio " + prueba4.devolverArr()[2]);
		
		System.out.println("");
		
		System.out.println("Metodo de devolucion por parametro");
		System.out.println("Maximo: " + prueba4.devolverValor("Maximo"));
		System.out.println("Minimo: " + prueba4.devolverValor("Minimo"));
		System.out.println("Promedio: " + prueba4.devolverValor("Promedio"));
		
		System.out.println("");
		
		System.out.println("Metodo de devolucion por getters");
		prueba4.devolverGet();
		System.out.println("Maximo: " + prueba4.getMax());
		System.out.println("Minimo: " + prueba4.getMin());
		System.out.println("Promedio: " + prueba4.getPromedio());
	}
}
