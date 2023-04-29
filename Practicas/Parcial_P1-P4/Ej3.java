package Parcial;

import src.ColaGenerica;
import tp04.ejercicio1.ArbolGeneral;

public class Ej3 {
	
	public ArbolGeneral<Integer> esCreciente(ArbolGeneral<Integer> a){
		ArbolGeneral<Integer> nodoMaxHijos = new ArbolGeneral<Integer>(null);
		
		if(!a.esVacio()) {
			ColaGenerica<ArbolGeneral<Integer>> Cola = new ColaGenerica<>();
			int Nivel = 0;
			int maxHijos = 0;
			int cantHijosNivel = 0;
			
			Cola.encolar(a);
			Cola.encolar(null);
			
			while(!Cola.esVacio()){
				ArbolGeneral<Integer> aux = Cola.desencolar();
				
				if(aux != null) {
					cantHijosNivel++;
					if(aux.getHijos().tamanio() >= maxHijos) {
						maxHijos = aux.getHijos().tamanio();
						nodoMaxHijos = aux;
					}
					for (int i = 1; i <= aux.getHijos().tamanio(); i++) {
						Cola.encolar(aux.getHijos().elemento(i));
					}
					
				}else {
					//System.out.println(cantHijosNivel);
					if(!(cantHijosNivel == Nivel+1)) return null;
					cantHijosNivel = 0;
					if(!Cola.esVacio()) {
						Nivel++;
						Cola.encolar(null);
					}
				}
				
				
			}
			
			return nodoMaxHijos;
		}
		return null;
		
		
	}
	
	public static void main(String[] args) {
		ArbolGeneral<Integer> Arbol = new ArbolGeneral<Integer>(100);
		ArbolGeneral<Integer> Arbol2 = new ArbolGeneral<Integer>(1);
		ArbolGeneral<Integer> Arbol3 = new ArbolGeneral<Integer>(2);
		
		
		
		Arbol2.agregarHijo(new ArbolGeneral<Integer>(11));
		Arbol2.agregarHijo(new ArbolGeneral<Integer>(12));
		
		Arbol3.agregarHijo(new ArbolGeneral<Integer>(21));
		Arbol3.getHijos().elemento(1).agregarHijo(new ArbolGeneral<Integer>(3));
		Arbol3.getHijos().elemento(1).agregarHijo(new ArbolGeneral<Integer>(4));
		Arbol3.getHijos().elemento(1).agregarHijo(new ArbolGeneral<Integer>(5));
		Arbol3.getHijos().elemento(1).agregarHijo(new ArbolGeneral<Integer>(6));
		Arbol3.getHijos().elemento(1).agregarHijo(new ArbolGeneral<Integer>(6));
		
		Arbol.agregarHijo(Arbol2);
		Arbol.agregarHijo(Arbol3);
		Ej3 Ej3 = new Ej3();
		System.out.println(Ej3.esCreciente(Arbol));
		
	}
}
