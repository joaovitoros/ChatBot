package controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import model.Respostas;

public class ProcessResposta {
	public static String GravaResposta(String pergunta, String resposta, int index) throws IOException {
		File arquivo = new File("R"+index+".txt");
		BufferedWriter grava = new BufferedWriter(new FileWriter(arquivo,true));
		
		Respostas resp = new Respostas();
		
		resp.setPergunta(pergunta);
		grava.write(resp.getPergunta());
		grava.newLine();
		
		resp.setResposta(resposta);
		grava.write(resp.getResposta());
		grava.newLine();
		
		System.out.println("Gravação Concluida!");
		grava.close();
		return resposta;
	}
	
	public static String LerResposta(int index) throws IOException{
		File arquivo = new File("R"+index+".txt");
		BufferedReader ler = new BufferedReader(new FileReader(arquivo));
		
		Respostas resp = new Respostas();
		
		String pergunta = ler.readLine();
		resp.setPergunta(pergunta);
		
		String resposta = ler.readLine();
		resp.setResposta(resposta);
		
		System.out.println("Leitura Concluida!");
		ler.close();
		return resp.getResposta();
	}
}
