package Parcial;

import src.ColaGenerica;
import tp04.ejercicio1.ArbolGeneral;

public class Ej6 {

	ArbolGeneral<Integer> Arbol;
	
	public Ej6() {
		Arbol = new ArbolGeneral<Integer>(2);
		Arbol.agregarHijo(new ArbolGeneral<Integer>(7));
		Arbol.getHijos().elemento(1).agregarHijo(new ArbolGeneral<Integer>(2));
		Arbol.getHijos().elemento(1).agregarHijo(new ArbolGeneral<Integer>(6));
		Arbol.getHijos().elemento(1).getHijos().elemento(2).agregarHijo(new ArbolGeneral<Integer>(5));
		Arbol.getHijos().elemento(1).getHijos().elemento(2).agregarHijo(new ArbolGeneral<Integer>(11));
		Arbol.agregarHijo(new ArbolGeneral<Integer>(5));
		Arbol.getHijos().elemento(2).agregarHijo(new ArbolGeneral<Integer>(9));
		Arbol.getHijos().elemento(2).getHijos().elemento(1).agregarHijo(new ArbolGeneral<Integer>(4));
	}
	
	public ArbolGeneral<Integer> minEnNivelAB(int n){
		int min = 999;
		int Nivel = 0;
		ArbolGeneral<Integer> HojaMin = null;
		if(!Arbol.esVacio()) {
			ColaGenerica<ArbolGeneral<Integer>> Cola = new ColaGenerica<ArbolGeneral<Integer>>();
			
			Cola.encolar(Arbol);
			Cola.encolar(null);
			
			while(!Cola.esVacio()) {
				ArbolGeneral<Integer> aux = Cola.desencolar();
					if(aux != null) {
						
						if(Nivel == n) {
							if(aux.esHoja()){
								if(aux.getDato() < min) {
									min = aux.getDato();
									HojaMin = aux;
								}
							}
					
						}
					for (int i = 1; i <= aux.getHijos().tamanio(); i++) {
						Cola.encolar(aux.getHijos().elemento(i));
					}
					
				}else {
					if(!Cola.esVacio()) {
						Nivel++;
						Cola.encolar(null);
					}
				}
			}
			
		}
		return HojaMin;
	}
	
	public static void main(String[] args) {
		Ej6 Ej6 = new Ej6();
		//Ej6.minEnNivelAB(1);
		System.out.println(Ej6.minEnNivelAB(1));
		System.out.println(Ej6.minEnNivelAB(2).getDato());
		System.out.println(Ej6.minEnNivelAB(3).getDato());
	}
	
}
