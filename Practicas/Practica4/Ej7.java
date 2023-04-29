package Ej7;

import tp04.ejercicio1.ArbolGeneral;

public class RedDeAguaPotable {

	ArbolGeneral<String> Arbol;
	
	public RedDeAguaPotable(ArbolGeneral<String> a) {
		this.Arbol = a;
	}
	
	private double minimo(double caudal, ArbolGeneral<String> a) {
		double act;
		double min = 9999;
		if(a.esVacio()) return -1;
		if(a.esHoja()) return caudal;
		for (int i = 1; i <= a.getHijos().tamanio(); i++) {
			act = minimo(caudal/a.getHijos().tamanio(),a.getHijos().elemento(i));
			if(act <= min) min = act;
		}
		return min;
	}
	
	public void minimoCaudal(double caudal) {
		System.out.println(minimo(caudal, Arbol));
		minimo(caudal, Arbol);
	}
	
	public static void main(String[] args) {
		ArbolGeneral<String> a = new ArbolGeneral<String>("A");
		a.agregarHijo(new ArbolGeneral<String>("B"));
		
		ArbolGeneral<String> c = new ArbolGeneral<String>("C");
		c.agregarHijo(new ArbolGeneral<String>("F"));
		ArbolGeneral<String> g = new ArbolGeneral<String>("G");
		g.agregarHijo(new ArbolGeneral<String>("L"));
		c.agregarHijo(g);
		
		a.agregarHijo(c);
		
		ArbolGeneral<String> d = new ArbolGeneral<String>("D");
		
		d.agregarHijo(new ArbolGeneral<String>("H"));
		d.agregarHijo(new ArbolGeneral<String>("I"));
		
		ArbolGeneral<String> j = new ArbolGeneral<String>("J");
		j.agregarHijo(new ArbolGeneral<String>("M"));	
		j.agregarHijo(new ArbolGeneral<String>("N"));
		
		d.agregarHijo(j);
		d.agregarHijo(new ArbolGeneral<String>("K"));
		
		a.agregarHijo(d);
		a.agregarHijo(new ArbolGeneral<String>("E"));
		
		RedDeAguaPotable redAgua = new RedDeAguaPotable(a);
		
		redAgua.minimoCaudal(3000);
	}
	
}
