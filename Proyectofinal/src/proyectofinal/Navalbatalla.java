package proyectofinal;

import java.util.*;


public class Navalbatalla {
    /* 4 metodos, void vaciar() ,void completar()
	  	completar le pone 4 unos al azar
	  	int get barcos() me dice cuantos barcos quedan
	  	boolean probar devuelve true o false si encuentra el barco en (int i, int j)
	*/
    

	/* 4 metodos, void vaciar() ,void completar()
	  	completar le pone 4 unos al azar
	  	int get barcos() me dice cuantos barcos quedan
	  	boolean probar devuelve true o false si encuentra el barco en (int i, int j)
	*/
	private boolean bandera = false;
	private int[][] matriz = new int[10][10];
	private int barcos = 0;
	private boolean[][] marcados = new boolean[10][10];
	
		
	
	public void completar() {//pone los barcos aleatorios 
            
		Random gen = new Random();
		int num1;
		int num2;
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++){
				marcados[i][j] = true;
				marcados[i][j] = true;
			}	
		}
		this.vaciar();
		for(int i = 0; i < 5;i++) {
			num1 = gen.nextInt(10);
			num2 = gen.nextInt(10);
			if (matriz[num1][num2] != 1) {
				matriz[num1][num2] = 1;
			}
			else i--;
		}
		barcos = 5;
	}
	public boolean bander() {
		return bandera;
	}
	public void bander2(boolean b) {
		bandera = b;
	}
	public boolean marc(int i, int j) {
		return marcados[i][j] == true;
	}
	public boolean marc2(int i, int j) {
		return marcados[i][j] == true;
	}
	public void setMarc2(int i, int j, boolean b) {
		marcados[i][j] = b;
	}
	public int getBarcos() {
		return barcos;
	}
	public void vaciar() {
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++){
				matriz[i][j] = 0;
			}	
		}
		barcos = 0;
	}
		
	public boolean probar(int i, int j) {
		if (matriz[i][j] == 1) {
			barcos--;
			marcados[i][j] = true;//abre los casilleros 
			marcados[i][j] = true;
			return true;
		}
		else {
			marcados[i][j] = true;
			return false;
		}
		
	}
}

 

