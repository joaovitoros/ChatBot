package view;

import java.io.IOException;

import controller.ProcessLoli;
import model.MemoriaBase;

public class Main{

	public static void main(String[] args) {
		
		try {
			MemoriaBase[] memo = new MemoriaBase[2];
			Face face = new Face(ProcessLoli.Inicializacao(memo));
			face.setVisible(true);
			System.out.println("Inicialização Finalizada!");
		} catch (IOException e) {
			e.printStackTrace();
		}
		

	}

}