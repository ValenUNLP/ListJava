package Parcial;

public class Ej7 {

	public Integer sumaImparesPosOrdenMayorA(ArbolBinario<Integer> a, int n) {
		int total = 0;
		if(a.esVacio()) return 0;
		if(a.tieneHijoIzquierdo()) total = total + sumaImparesPosOrdenMayorA(a.getHijoIzquierdo(), n);
		if(a.tieneHijoDerecho()) total = total + sumaImparesPosOrdenMayorA(a.getHijoDerecho(), n);
		if((a.getDato() > n) && (a.getDato()%2 == 1)) {
			System.out.println(a.getDato());
			total = total + a.getDato();
		}
		
		return total;
	}
	
	public static void main(String[] args) {
		
		ArbolBinario<Integer> Arbol = new ArbolBinario<Integer>(7);
		Arbol.agregarHijoIzquierdo(new ArbolBinario<>(56));
		Arbol.getHijoIzquierdo().agregarHijoIzquierdo(new ArbolBinario<>(38));
		Arbol.getHijoIzquierdo().getHijoIzquierdo().agregarHijoIzquierdo(new ArbolBinario<Integer>(87));
		Arbol.getHijoIzquierdo().getHijoIzquierdo().agregarHijoDerecho(new ArbolBinario<Integer>(77));
		Arbol.getHijoIzquierdo().getHijoIzquierdo().getHijoDerecho().agregarHijoIzquierdo(new ArbolBinario<>(16));
		Arbol.getHijoIzquierdo().getHijoIzquierdo().getHijoDerecho().getHijoIzquierdo().agregarHijoDerecho(new ArbolBinario<Integer>(43));
		Arbol.getHijoIzquierdo().getHijoIzquierdo().getHijoDerecho().getHijoIzquierdo().getHijoDerecho().agregarHijoIzquierdo(new ArbolBinario<Integer>(9));
		Arbol.getHijoIzquierdo().getHijoIzquierdo().getHijoDerecho().getHijoIzquierdo().getHijoDerecho().agregarHijoIzquierdo(new ArbolBinario<Integer>(10));
		Arbol.getHijoIzquierdo().agregarHijoDerecho(new ArbolBinario<Integer>(31));
		Arbol.getHijoIzquierdo().getHijoDerecho().agregarHijoDerecho(new ArbolBinario<Integer>(94));
		Arbol.getHijoIzquierdo().getHijoDerecho().getHijoDerecho().agregarHijoDerecho(new ArbolBinario<Integer>(2));
		Arbol.getHijoIzquierdo().getHijoDerecho().getHijoDerecho().getHijoDerecho().agregarHijoIzquierdo(new ArbolBinario<Integer>(1));
		Arbol.agregarHijoDerecho(new ArbolBinario<Integer>(25));
		Arbol.getHijoDerecho().agregarHijoIzquierdo(new ArbolBinario<Integer>(5));
		Arbol.getHijoDerecho().agregarHijoIzquierdo(new ArbolBinario<Integer>(6));
		
		Ej7 Ej7 = new Ej7();
		System.out.println(Ej7.sumaImparesPosOrdenMayorA(Arbol, 30));
		}
}
