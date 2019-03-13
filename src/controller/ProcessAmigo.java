package controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import model.Amigo;
import model.MemoriaBase;

public class ProcessAmigo {
	public static void GravaAmigo(String nome, int cont, String apelido) throws IOException {
		File arquivo = new File(nome+".txt");
		BufferedWriter grava = new BufferedWriter(new FileWriter(arquivo));
		
		Amigo amigo = new Amigo();

		amigo.setNome(nome);
		grava.write(amigo.getNome());
		grava.newLine();
		
		amigo.setContHumor(cont);
		grava.write(Integer.toString(amigo.getContHumor()));
		grava.newLine();
		
		amigo.setApelidoIA(apelido);
		grava.write(amigo.getApelidoIA());
		grava.newLine();
		
		System.out.println("Gravação Concluida!");
		grava.close();

	}
	
	public static int AtualizaQTDAmigo(MemoriaBase[] memo) throws IOException{
		File arquivo = new File("Memoriabase.txt");
		BufferedReader ler = new BufferedReader(new FileReader(arquivo));
		MemoriaBase obj = new MemoriaBase();
		obj = (MemoriaBase) ProcessLoli.Leitura(memo);
		
		ProcessLoli.GravacaoParam(obj.getQTDAssuntos(), obj.getHumor(), obj.getQTDFrases(), obj.getVida(), obj.getNome(),
				obj.getQTDAmigos()+1, obj.getVersao(), obj.getQTDPalavras());
		
		ler.close();
		return obj.getQTDAmigos()+1;
	}
	
	public static int VerificaQTD(MemoriaBase[] memo) throws IOException{
		File arquivo = new File("Memoriabase.txt");
		BufferedReader ler = new BufferedReader(new FileReader(arquivo));
		
		MemoriaBase obj = new MemoriaBase();
		obj = (MemoriaBase) ProcessLoli.Leitura(memo);
		
		int quantidade = obj.getQTDAmigos();
		ler.close();
		return quantidade;
	}
	
	public static Object LerAmigo(String nome) throws IOException{
		File arquivo = new File(nome+".txt");
		BufferedReader ler = new BufferedReader(new FileReader(arquivo));
		
		Amigo amigo = new Amigo();
		
		String nomeA = ler.readLine();
		amigo.setNome(nomeA);
		
		int cont = Integer.parseInt(ler.readLine());
		amigo.setContHumor(cont);
		
		String apelido = ler.readLine();
		amigo.setApelidoIA(apelido);
		
		System.out.println("Leitura Concluida!");
		ler.close();
		return amigo;
	}

	
}
