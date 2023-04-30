package Parcial;

import tp02.ejercicio2.ListaEnlazadaGenerica;

public class Ej10 {
	
	private int Helper(ArbolBinario<Integer> a, ListaEnlazadaGenerica<Integer> lista) {
		int descendientesIzq = 0;
		int descendientesDer = 0;
		
		if(!a.esVacio()) {
			if(a.esHoja()) return 0;
			if(a.tieneHijoIzquierdo()) descendientesIzq = 1 + Helper(a.getHijoIzquierdo(), lista);
			if(a.tieneHijoDerecho()) descendientesDer =  1 + Helper(a.getHijoDerecho(), lista);
			
			if(descendientesDer == descendientesIzq) lista.agregarFinal(a.getDato());
			
			
		}
		return descendientesDer + descendientesIzq;
	}

	public ListaEnlazadaGenerica<Integer> resolver(ArbolBinario<Integer> a){
		
		ListaEnlazadaGenerica<Integer> Lista = new ListaEnlazadaGenerica<Integer>();
		
		Helper(a,Lista);
		
		return Lista;
		
	}
	
	
	public static void main(String[] args) {
		ArbolBinario<Integer> Arbol = new ArbolBinario<Integer>(100);
		Arbol.agregarHijoIzquierdo(new ArbolBinario<>(1));
		Arbol.getHijoIzquierdo().agregarHijoIzquierdo(new ArbolBinario<>(11));
		Arbol.getHijoIzquierdo().agregarHijoDerecho(new ArbolBinario<>(12));
		Arbol.agregarHijoDerecho(new ArbolBinario<>(2));
		Arbol.getHijoDerecho().agregarHijoIzquierdo(new ArbolBinario<>(21));
		Arbol.getHijoDerecho().agregarHijoDerecho(new ArbolBinario<>(22));
		Arbol.getHijoDerecho().getHijoDerecho().agregarHijoIzquierdo(new ArbolBinario<>(3));
		Arbol.getHijoDerecho().getHijoDerecho().agregarHijoDerecho(new ArbolBinario<>(4));
		Ej10 Ej10 = new Ej10();
		
		System.out.println(Ej10.resolver(Arbol));
	}
}
