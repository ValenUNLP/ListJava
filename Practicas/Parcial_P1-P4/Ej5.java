package Parcial;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp04.ejercicio1.ArbolGeneral;

public class Ej5 {
	
	private void unirCamino(ArbolGeneral<Character> a, ListaEnlazadaGenerica<Character> l, ListaEnlazadaGenerica<ListaEnlazadaGenerica<Character>> ListaGeneral ){
		
		if(!a.esVacio()){
			l.agregarFinal(a.getDato());
			if(a.esHoja()) {
				ListaEnlazadaGenerica<Character> aux = (ListaEnlazadaGenerica<Character>) l.clonar();
				if(l.tamanio() % 2 == 0) ListaGeneral.agregarFinal(aux);
			}
				
			for (int i = 1; i <= a.getHijos().tamanio(); i++) {
				unirCamino(a.getHijos().elemento(i), l, ListaGeneral);
			}
			l.eliminarEn(l.tamanio());
		}
		
	}
	
	private void buscarCamino(ArbolGeneral<Character> a, ListaEnlazadaGenerica<ListaEnlazadaGenerica<Character>> l) {
		
		ListaEnlazadaGenerica<Character> Lista =  new ListaEnlazadaGenerica<Character>();
		unirCamino(a, Lista, l);
		
	}
	
	public ListaEnlazadaGenerica<ListaEnlazadaGenerica<Character>> caminosPares(ArbolGeneral<Character> a){
		ListaEnlazadaGenerica<ListaEnlazadaGenerica<Character>> ListaGeneral = new ListaEnlazadaGenerica<ListaEnlazadaGenerica<Character>>();
		buscarCamino(a, ListaGeneral);
		
		
		return ListaGeneral;
	}
	
	public static void main(String[] args) {
		ArbolGeneral<Character> Arbol = new ArbolGeneral<Character>('A');
		Arbol.agregarHijo(new ArbolGeneral<Character>('B'));
		Arbol.agregarHijo(new ArbolGeneral<Character>('C'));
		Arbol.agregarHijo(new ArbolGeneral<Character>('D'));
		Arbol.getHijos().elemento(1).agregarHijo(new ArbolGeneral<Character>('E'));
		Arbol.getHijos().elemento(2).agregarHijo(new ArbolGeneral<Character>('F'));
		Arbol.getHijos().elemento(2).agregarHijo(new ArbolGeneral<Character>('G'));
		Arbol.getHijos().elemento(2).getHijos().elemento(1).agregarHijo(new ArbolGeneral<Character>('H'));
		Arbol.getHijos().elemento(2).getHijos().elemento(1).agregarHijo(new ArbolGeneral<Character>('I'));
		
		Ej5 Ej5  = new Ej5();
		ListaEnlazadaGenerica<ListaEnlazadaGenerica<Character>> Lista = Ej5.caminosPares(Arbol);
		Lista.comenzar();
		while(!Lista.fin()) {
			System.out.println(Lista.proximo());
		}
			

	}
}
