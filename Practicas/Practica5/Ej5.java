package P5;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp06.ejercicio3.Arista;
import tp06.ejercicio3.Grafo;
import tp06.ejercicio3.Vertice;

public class VisitaOslo {
	
	private void clonar (ListaGenerica<String> lis,ListaGenerica<String> camino) {
		lis.comenzar();
		while(!lis.fin()) {
			camino.agregarFinal(lis.proximo());
		}
	}
	
	public ListaGenerica<String> paseoEnBici(Grafo<String> lugares, String destino, int maxTiempo,ListaGenerica<String> lugaresRestringidos){
		boolean[] marca = new boolean[lugares.listaDeVertices().tamanio()+1];
		ListaGenerica<String> lis = new ListaEnlazadaGenerica<String>();
		ListaGenerica<String> camino = new ListaEnlazadaGenerica<String>();
		
		for(int i= 1; i <= lugares.listaDeVertices().tamanio(); i++) {
			if(!marca[i]) {
				if(lugares.listaDeVertices().elemento(i).dato() == "Ayuntamiento") {					
					lis.agregarFinal(lugares.listaDeVertices().elemento(i).dato());
					dfs(i, lugares,lis, camino, maxTiempo,0 ,lugaresRestringidos, marca, destino);
				}
			}
		}
		
		return camino;
		
	}
	
	public void dfs(int i,Grafo<String> lugares, ListaGenerica<String> lis ,ListaGenerica<String> camino, int maxTiempo, int tiempo, ListaGenerica<String> lugaresRestringidos, boolean[] marca, String destino) {
		marca[i] = true;
		Vertice<String> v = lugares.listaDeVertices().elemento(i);
		if(v.dato() == destino) {
				System.out.println(tiempo);
				clonar(lis, camino);
		}
		
		if(camino.esVacia()) {
			ListaGenerica<Arista<String>> ady = lugares.listaDeAdyacentes(v);
			ady.comenzar();
			while(!ady.fin() && camino.esVacia()) {
				Arista<String> arista = ady.proximo();
				Vertice<String> vdestino = arista.verticeDestino();
				int j = vdestino.getPosicion();
				if(!marca[j] && !lugaresRestringidos.incluye(vdestino.dato())){
					tiempo = tiempo + arista.peso();
					if(tiempo <= maxTiempo) {
						lis.agregarFinal(vdestino.dato());
						dfs(j, lugares, lis, camino, maxTiempo, tiempo, lugaresRestringidos, marca, destino);
						lis.eliminarEn(lis.tamanio());
						//if(camino.esVacia()) {
							//marca[j] = false;
						//}
					}
					tiempo = tiempo - arista.peso();
				}
			}
		}
		
		
	}
}
