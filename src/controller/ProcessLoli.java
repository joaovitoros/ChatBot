package controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import model.MemoriaBase;
import view.ClasseDeInicializaçãoPrimeria;

public class ProcessLoli {
	
	public static String Inicializacao(MemoriaBase[] memo) throws IOException{
		
		try {
			String nome = Leitura(memo).toString();
			System.out.println("Leitura da Memoria Base Concluida! \n" +memo[1].getQTDAssuntos()
					+memo[1].getHumor() +memo[1].getQTDFrases() +memo[1].getVida() 
					+memo[1].getQTDAmigos() +memo[1].getQTDPalavras() 
					+"\nnome de I.A: " +memo[1].getNome() +" "+memo[1].getVersao() );
			
			if(ProcessAssunto.VerificaQTD(memo)==0){
				memo[1].setFrase("Está é minha primeira inicialização, por isso não tenho nenhum assunto para falar, me diga um que gostaria de começar a falar");
				FormularResposta.EnviarResposta(memo[1].getFrase());
			}
			return nome;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			ClasseDeInicializaçãoPrimeria.InicializaçãoPrimaria(memo);
		}
		return null;
		
	}
	
	public static void ChamadaAssunto(MemoriaBase[] memo, String nome, String tipo) throws IOException{
		ProcessAssunto.GravaAssunto(ProcessAssunto.AtualizaQTDAssunto(memo), nome, tipo);
	}
	
	public static Object Leitura(MemoriaBase[] memo) throws IOException{
		File arquivo = new File("Memoriabase.txt");
		BufferedReader ler = new BufferedReader(new FileReader(arquivo));
		memo[1] = new MemoriaBase();
		
		int qtdassunto = Integer.parseInt(ler.readLine());
		memo[1].setQTDAssuntos(qtdassunto);
		
		int humor = Integer.parseInt(ler.readLine());
		memo[1].setHumor(humor);
		
		int qtdfrases = Integer.parseInt(ler.readLine());
		memo[1].setQTDFrases(qtdfrases);
		
		int vida = Integer.parseInt(ler.readLine());
		memo[1].setVida(vida);
		
		String nome = ler.readLine();
		memo[1].setNome(nome);	
		
		int qtdamigos = Integer.parseInt(ler.readLine());
		memo[1].setQTDAmigos(qtdamigos);
		
		String versao = ler.readLine();
		memo[1].setVersao(versao);
		
		int qtdpalavras = Integer.parseInt(ler.readLine());
		memo[1].setQTDPalavras(qtdpalavras);
		
		ler.close();
		return memo[1];

	}
	
	public static void GravacaoParam(int qtdassunto, int humor, int qtdfrases, 
			int vida, String nome, int qtdamigos, String versao, int qtdpalavras) throws IOException {
		
		File arqui = new File("Memoriabase.txt");
		BufferedWriter grava = new BufferedWriter(new FileWriter(arqui));
		grava.write(Integer.toString(qtdassunto));
		grava.newLine();
		
		grava.write(Integer.toString(humor));
		grava.newLine();
		
		grava.write(Integer.toString(qtdfrases));
		grava.newLine();
		
		grava.write(Integer.toString(vida));
		grava.newLine();
		
		grava.write(nome);
		grava.newLine();
		
		grava.write(Integer.toString(qtdamigos));
		grava.newLine();
		
		grava.write(versao);
		grava.newLine();
		
		grava.write(Integer.toString(qtdpalavras));
		grava.newLine();
	
		grava.close();

	}

}
