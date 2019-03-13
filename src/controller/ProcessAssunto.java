package controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import model.Assunto;
import model.MemoriaBase;

public class ProcessAssunto {
	public static void GravaAssunto(int Nassunto, String nome, String tipo) throws IOException{
		File arquivo = new File("A"+Nassunto+".txt");
		BufferedWriter grava = new BufferedWriter(new FileWriter(arquivo));
		
		Assunto assunto = new Assunto();
		
		assunto.setNome(nome);
		grava.write(assunto.getNome());
		grava.newLine();
		
		assunto.setTipo(tipo);
		grava.write(tipo);
		grava.newLine();
		
		System.out.println("Gravação Concluida!");
		grava.close();
	}
	
	public static String LerAssunto(int num) throws IOException{
		File arquivo = new File("A"+num+".txt");
		BufferedReader ler = new BufferedReader(new FileReader(arquivo));
		
		Assunto assunt = new Assunto();
		
		String nome = ler.readLine();
		assunt.setNome(nome);
		
		String tipo = ler.readLine();
		assunt.setTipo(tipo);
		
		System.out.println("Leitura Concluida!");
		ler.close();
		return assunt.getNome();
	}
	
	public static int AtualizaQTDAssunto(MemoriaBase[] memo) throws IOException{
		File arquivo = new File("Memoriabase.txt");
		BufferedReader ler = new BufferedReader(new FileReader(arquivo));
		
		MemoriaBase obj = new MemoriaBase();
		obj = (MemoriaBase) ProcessLoli.Leitura(memo);
		
		ProcessLoli.GravacaoParam(obj.getQTDAssuntos()+1, obj.getHumor(), obj.getQTDFrases(), obj.getVida(), obj.getNome(),
				obj.getQTDAmigos(), obj.getVersao(), obj.getQTDPalavras());
		ler.close();
		return obj.getQTDAssuntos()+1;
	}
	
	public static int VerificaQTD(MemoriaBase[] memo) throws IOException{
		File arquivo = new File("Memoriabase.txt");
		BufferedReader ler = new BufferedReader(new FileReader(arquivo));
		int quantidade = Integer.parseInt(ler.readLine());
		ler.close();
		return quantidade;
	}
}
