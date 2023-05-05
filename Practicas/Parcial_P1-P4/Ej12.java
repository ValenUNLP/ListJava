package Parcial;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp04.ejercicio1.ArbolGeneral;

public class Ej12 {
	
	private void agregarLista(int dato, ListaGenerica<Integer> Lista) {
		int aux;
		if(dato >= 0) {
			aux = Lista.elemento(1);
			Lista.eliminarEn(1);
			Lista.agregarInicio(aux + dato);
			
		}else {
			aux = Lista.elemento(2);
			Lista.eliminarEn(2);
			Lista.agregarFinal(aux + dato);
		}
	}
	
	private int Helper(ArbolGeneral<Integer> a, ListaGenerica<Integer> Lista) {
		
		if(!a.esVacio()) {
			
			int cantHijos = 1;
			
			if(a.esHoja()) {
				agregarLista(a.getDato(), Lista);
				return 1;
			}
			
			for (int i = 1; i <= 1; i++) {
				cantHijos = cantHijos  + Helper(a.getHijos().elemento(i), Lista);
			}
			
			agregarLista(a.getDato(), Lista);
			
			for (int i = 2; i <= a.getHijos().tamanio(); i++) {
				cantHijos = cantHijos  + Helper(a.getHijos().elemento(i), Lista);
			}
			return cantHijos;
		}else {
			return 0;
		}
		//System.out.println(a.getDato());
		//System.out.println(cantHijos);
		//System.out.println("--------------");
	}
	
	public int cantNumeros(ArbolGeneral<Integer> a) {
		ListaGenerica<Integer> Lista = new ListaEnlazadaGenerica<Integer>();
		Lista.agregarInicio(0);
		Lista.agregarFinal(0);
		int nodos = Helper(a, Lista);
		System.out.println(Lista);
		if(nodos % 2 == 0) {
			return Lista.elemento(1);
		}
		return Lista.elemento(2);
		
	}
	
	public static void main(String[] args) {
		ArbolGeneral<Integer> Arbol = new ArbolGeneral<Integer>(2);
		Arbol.agregarHijo(new ArbolGeneral<Integer>(1));
		Arbol.getHijos().elemento(1).agregarHijo(new ArbolGeneral<Integer>(5));
		Arbol.getHijos().elemento(1).agregarHijo(new ArbolGeneral<Integer>(4));
		Arbol.getHijos().elemento(1).getHijos().elemento(2).agregarHijo(new ArbolGeneral<Integer>(9));
		Arbol.getHijos().elemento(1).getHijos().elemento(2).agregarHijo(new ArbolGeneral<Integer>(10));
		Arbol.getHijos().elemento(1).getHijos().elemento(2).agregarHijo(new ArbolGeneral<Integer>(5));
		Arbol.agregarHijo(new ArbolGeneral<Integer>(12));
		Arbol.getHijos().elemento(2).agregarHijo(new ArbolGeneral<Integer>(8));
		Arbol.getHijos().elemento(2).getHijos().elemento(1).agregarHijo(new ArbolGeneral<Integer>(3));
		Arbol.getHijos().elemento(2).agregarHijo(new ArbolGeneral<Integer>(4));
		Arbol.getHijos().elemento(2).agregarHijo(new ArbolGeneral<Integer>(7));
		Arbol.getHijos().elemento(2).getHijos().elemento(3).agregarHijo(new ArbolGeneral<Integer>(-13));
		
		
		Ej12 Ej12 = new Ej12();
		System.out.println(Ej12.cantNumeros(Arbol));
	}
	
}
