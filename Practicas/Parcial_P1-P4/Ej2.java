package Parcial;

import tp04.ejercicio1.ArbolGeneral;

public class Ej2 {
	
	private Boolean esDragon(ArbolGeneral<String> a) {
		if(a.getDato().equals("Dragon")) return true;
		return false;
	}
	
	private Boolean esPrincesa(ArbolGeneral<String> a) {
		if(a.getDato().equals("Princesa")) return true;
		return false;
	}
	
	public Boolean princesaAccesible(ArbolGeneral<String> a){
		
		if(a.esVacio()) return false;
		if(a.esHoja() && !esPrincesa(a)) return false;
		if(esDragon(a)) return false;
		if(esPrincesa(a)) return true;
			for (int i = 1; i <= a.getHijos().tamanio(); i++) {
				if(princesaAccesible(a.getHijos().elemento(i))) return true;
			}
			return false;
		//return false;
	}
	
	public static void main(String[] args) {
		ArbolGeneral<String> Arboll = new ArbolGeneral<String>("x");
		ArbolGeneral<String> Arbol2 = new ArbolGeneral<String>("Dragon");
		ArbolGeneral<String> Arbol3 = new ArbolGeneral<String>("z");
		Arbol2.agregarHijo(new ArbolGeneral<String>("Princesa"));
		Arbol2.agregarHijo(new ArbolGeneral<String>("y"));
		Arbol3.agregarHijo(new ArbolGeneral<String>("w"));
		Arbol3.getHijos().elemento(1).agregarHijo(new ArbolGeneral<String>("z"));
		Arboll.agregarHijo(Arbol2);
		Arboll.agregarHijo(Arbol3);
		Ej2 Ej2 = new Ej2();
		
		System.out.println(Ej2.princesaAccesible(Arboll));
		
	}
}
