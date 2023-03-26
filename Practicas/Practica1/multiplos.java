package Practica1B;

public class multiplos {
	int[] nums;
	int n;
	
	public multiplos(int n) {
		this.n = n;
		nums = new int[n+1];
	}
	
	
	public int getN() {
		return n;
	}



	public void setN(int n) {
		this.n = n;
	}


	public int[] arrMultiplos() {
		for (int i = 0; i <= n; i++) {
			nums[i] = n*(i+1);
		}
		return nums;
	}
	
	public String toString() {
		String aux = "";
		
		for (int i = 0; i < n; i++) {
			aux = aux + nums[i]+ " ";
		}
		return aux;
	}
}
