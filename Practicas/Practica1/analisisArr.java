package Practica1B;

public class analisisArr {
	int[] arr;
	int max;
	int min;
	int promedio;
	int total;
	int[] arrReturn = new int[3];
	
	public analisisArr(int[] unArr){
		arr = unArr;
		total = 0;
		max = 0;
		min = 9999999;
	}

	public int[] getArr() {
		return arr;
	}

	public void setArr(int[] arr) {
		this.arr = arr;
	}

	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}

	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		this.min = min;
	}

	public int getPromedio() {
		return promedio;
	}

	public void setPromedio(int promedio) {
		this.promedio = promedio;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}
	
	public void calcular() {
		for (int i = 0; i < arr.length; i++) {
			total = total + arr[i];
			if(arr[i] > max) max = arr[i];
			if(arr[i] < min) min = arr[i];
		}
		promedio = total / arr.length;
		total = 0;
	}
	
	public int[] devolverArr() {
		calcular();
		arrReturn[0] = max;
		arrReturn[1] = min;
		arrReturn[2] = promedio;
		
		return arrReturn;
	}
	
	public int devolverValor(String valor) {
		calcular();
		if(valor == "Maximo") {
			return max;
		}else {
			if(valor == "Minimo") {
				return min;
			}else {
				if(valor == "Promedio") {
					return promedio;
				}
			}
		}
		return 0;
	}
	
	public void devolverGet() {
		calcular();
	}
}
