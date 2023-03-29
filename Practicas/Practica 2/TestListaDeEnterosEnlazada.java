package Practica2;

import tp02.ejercicio1.ListaDeEnterosEnlazada;

public class TestListaDeEnterosEnlazada {
	private ListaDeEnterosEnlazada L;
	
	public TestListaDeEnterosEnlazada() {
		this.L = new ListaDeEnterosEnlazada();
	}
	public static void LeerInverso(ListaDeEnterosEnlazada Lista){
		int n;
		if(!Lista.fin()){
			n = Lista.proximo();
			LeerInverso(Lista);
			System.out.println(n);
		}
	}
	
	public ListaDeEnterosEnlazada calcularSucesion (int n) {
			this.L.agregarFinal(n);
			if(n !=1) {
				if(n % 2 == 0) {
					calcularSucesion(n/2);
				}else{
					calcularSucesion(3*n+1);
				}
			}
			return this.L;
			
		}
		

	
	public static void main(String[] args) {

		ListaDeEnterosEnlazada Lista = new ListaDeEnterosEnlazada();
		String argument;
		int n;
		for (int i = 0; i < args.length; i++) {
			argument = args[i];
			n =  Integer.parseInt(argument);
			Lista.agregarFinal(n);
		}
		
		System.out.println(Lista.toString());
		//Lista.comenzar();
		//LeerInverso(Lista);
		//TestListaDeEnterosEnlazada ej2 = new TestListaDeEnterosEnlazada();
		
		//ListaDeEnterosEnlazada L = ej2.calcularSucesion(6);
		
		//System.out.println(L.toString());
	}
}
