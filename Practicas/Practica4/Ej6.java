	private ArbolGeneral<T> aux(ArbolGeneral<T> arbol,T n) {
		if(!arbol.esVacio()) {
			if(arbol.getDato() == n) return arbol;
			if(arbol.tieneHijos()) {
				for (int i = 1; i <= arbol.getHijos().tamanio(); i++) {
						if((arbol.aux(arbol.getHijos().elemento(i), n).getDato() != null)){
							return  arbol.aux(arbol.getHijos().elemento(i), n);
						}
					} 
			}
		}
		return new ArbolGeneral<T>(null);
	}
	
	public Boolean esAncestro(T a, T b) {
		ArbolGeneral<T> Arbol = aux(this, a);
		if(Arbol.getDato() != null) {
			if(aux(Arbol, b).getDato() != null) {
				return true;
			}
		}
		return false;
	}
