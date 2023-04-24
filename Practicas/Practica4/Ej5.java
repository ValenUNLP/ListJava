package P4Ej5;
import src.ColaGenerica;
import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp04.ejercicio1.ArbolGeneral;

public class AnalizadorArbol {
	
	public int devolverMaximoPromedio (ArbolGeneral<AreaEmpresa>arbol) {
		
		
		Integer cantRetardoMax = 0;
		if(!arbol.esVacio()) {
			ColaGenerica<ArbolGeneral<AreaEmpresa>> Cola = new ColaGenerica<ArbolGeneral<AreaEmpresa>>();
			Integer cantNodosNivel = 0;
			Integer cantRetardoNivel = 0;
			
			Cola.encolar(arbol);
			Cola.encolar(null);
			
			while(!Cola.esVacio()){
				ArbolGeneral<AreaEmpresa> aux = Cola.desencolar();
				if(aux != null) {
					cantNodosNivel++;
					cantRetardoNivel = cantRetardoNivel + aux.getDato().getTransmision();
					if(aux.tieneHijos()) {
						for (int i = 1; i <= aux.getHijos().tamanio() ; i++) {
							Cola.encolar(aux.getHijos().elemento(i));
						}
					}
				}else {
					if((cantRetardoNivel / cantNodosNivel) >= cantRetardoMax) {
						cantRetardoMax = (cantRetardoNivel / cantNodosNivel);
					}
					cantNodosNivel = 0;
					cantRetardoNivel= 0;
					if(!Cola.esVacio()) {
						Cola.encolar(null);
					}
				
			}
		}
		}
		return cantRetardoMax;
	}
	
	public static void main(String[] args) {
		ListaEnlazadaGenerica<ArbolGeneral<AreaEmpresa>> Lista1 = new ListaEnlazadaGenerica<ArbolGeneral<AreaEmpresa>>();
		ListaEnlazadaGenerica<ArbolGeneral<AreaEmpresa>> Lista2 = new ListaEnlazadaGenerica<ArbolGeneral<AreaEmpresa>>();
		ListaEnlazadaGenerica<ArbolGeneral<AreaEmpresa>> Lista3 = new ListaEnlazadaGenerica<ArbolGeneral<AreaEmpresa>>();
		
		Lista1.agregarFinal(new ArbolGeneral<AreaEmpresa>(new AreaEmpresa("A", 4)));
		Lista1.agregarFinal(new ArbolGeneral<AreaEmpresa>(new AreaEmpresa("B", 7)));
		Lista1.agregarFinal(new ArbolGeneral<AreaEmpresa>(new AreaEmpresa("C", 5)));
		
		Lista2.agregarFinal(new ArbolGeneral<AreaEmpresa>(new AreaEmpresa("D", 6)));
		Lista2.agregarFinal(new ArbolGeneral<AreaEmpresa>(new AreaEmpresa("E", 10)));
		Lista2.agregarFinal(new ArbolGeneral<AreaEmpresa>(new AreaEmpresa("F", 18)));
		
		Lista3.agregarFinal(new ArbolGeneral<AreaEmpresa>(new AreaEmpresa("G", 9)));
		Lista3.agregarFinal(new ArbolGeneral<AreaEmpresa>(new AreaEmpresa("H", 12)));
		Lista3.agregarFinal(new ArbolGeneral<AreaEmpresa>(new AreaEmpresa("I", 219)));
		
		ArbolGeneral<AreaEmpresa> Arbol = new ArbolGeneral<AreaEmpresa>(new AreaEmpresa("M", 14));

		Arbol.agregarHijo(new ArbolGeneral<AreaEmpresa>(new AreaEmpresa("J", 13), Lista1));
		Arbol.agregarHijo(new ArbolGeneral<AreaEmpresa>(new AreaEmpresa("K", 25), Lista2));
		Arbol.agregarHijo(new ArbolGeneral<AreaEmpresa>(new AreaEmpresa("L", 10), Lista3));
		
		AnalizadorArbol EJ5 = new AnalizadorArbol();
		EJ5.devolverMaximoPromedio(Arbol);
		
	}
	
}
