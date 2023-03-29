package Practica2;
import java.util.Scanner;

import tp02.ejercicio1.*;

public class TestListaDeEnterosConArreglos {
	
	
	public static void LeerInverso(ListaDeEnterosConArreglos Lista){
		int n;
		if(!Lista.fin()){
			n = Lista.proximo();
			LeerInverso(Lista);
			System.out.println(n);
		}
	}
	

	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n;
		ListaDeEnterosConArreglos Lista = new ListaDeEnterosConArreglos();
		
		//n = s.nextInt();
		//while (n != -1) {
			//Lista.agregarFinal(n);
			//n = s.nextInt();
		//}

	
	}
}
