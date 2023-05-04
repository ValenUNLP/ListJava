package Parcial;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp04.ejercicio1.ArbolGeneral;

public class Ej9 {
	
	private void clonar(ListaGenerica<Integer> Lista, ListaGenerica<Integer> Camino) {
		for (int i = 1; i <= Camino.tamanio(); i++) {
			Camino.eliminarEn(1);
		}
		for (int i = 1; i <= Lista.tamanio(); i++) {
			Camino.agregarFinal(Lista.elemento(i));
		}
	}
	
	private void Buscar(ArbolGeneral<Integer> a, ListaGenerica<Integer> Lista, ListaGenerica<Integer> Camino) {
		Lista.agregarFinal(a.getDato());
		if(a.esHoja()) {
			if(Lista.tamanio() > Camino.tamanio()) {
				clonar(Lista, Camino);
			}
		}else {
			ListaGenerica<ArbolGeneral<Integer>> hijos = a.getHijos();
			hijos.comenzar();
			while(!hijos.fin()) {
				Buscar(hijos.proximo(), Lista, Camino);
				Lista.eliminarEn(Lista.tamanio());
			}
		}
	}
	
	public ListaGenerica<Integer> Buscar(ArbolGeneral<Integer> a){
		ListaGenerica<Integer> Lista = new ListaEnlazadaGenerica<Integer>();
		ListaGenerica<Integer> Camino = new ListaEnlazadaGenerica<Integer>();
		Buscar(a, Lista, Camino);
		return Camino;
	}
	
	
	
	public static void main(String[] args) {
		ArbolGeneral<Integer> Arbol = new ArbolGeneral<Integer>(8);
		Arbol.agregarHijo(new ArbolGeneral<Integer>(3));
		Arbol.getHijos().elemento(1).agregarHijo(new ArbolGeneral<Integer>(4));
		Arbol.getHijos().elemento(1).agregarHijo(new ArbolGeneral<Integer>(7));
		Arbol.getHijos().elemento(1).getHijos().elemento(2).agregarHijo(new ArbolGeneral<Integer>(2));
		Arbol.getHijos().elemento(1).agregarHijo(new ArbolGeneral<Integer>(6));
		Arbol.agregarHijo(new ArbolGeneral<Integer>(5));
		Arbol.getHijos().elemento(2).agregarHijo(new ArbolGeneral<Integer>(1));
		Arbol.getHijos().elemento(2).agregarHijo(new ArbolGeneral<Integer>(9));
		Arbol.getHijos().elemento(2).agregarHijo(new ArbolGeneral<Integer>(10));
		
		Ej9 Ej9 = new Ej9();
		System.out.println(Ej9.Buscar(Arbol));

	}
}
