package controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import model.Frase;
import model.MemoriaBase;

public class ProcessFrase {
	public static void GravaFrase(String palavras, String assuntos, int index) throws IOException {
		File arquivo = new File("F"+index+".txt");
		BufferedWriter grava = new BufferedWriter(new FileWriter(arquivo));
		
		Frase frase = new Frase();
		
		frase.setPalavras(palavras);
		grava.write(frase.getPalavras());
		grava.newLine();
		
		frase.setAssunto(assuntos);
		grava.write(frase.getAssunto());
		grava.newLine();
		
		ProcessDiversos.ChamadaAddPalavras(palavras);
		System.out.println("Gravação Concluida!");
		grava.close();

	}
	
	public static int AtualizaQTDFrases(MemoriaBase[] memo) throws IOException{
		File arquivo = new File("Memoriabase.txt");
		BufferedReader ler = new BufferedReader(new FileReader(arquivo));
		MemoriaBase obj = new MemoriaBase();
		obj = (MemoriaBase) ProcessLoli.Leitura(memo);
		
		ProcessLoli.GravacaoParam(obj.getQTDAssuntos(), obj.getHumor(), obj.getQTDFrases()+1, obj.getVida(), obj.getNome(),
				obj.getQTDAmigos(), obj.getVersao(), obj.getQTDPalavras());
		
		ler.close();
		return obj.getQTDFrases()+1;
	}
	
	public static int VerificaQTD(MemoriaBase[] memo) throws IOException{
		File arquivo = new File("Memoriabase.txt");
		BufferedReader ler = new BufferedReader(new FileReader(arquivo));
		
		MemoriaBase obj = new MemoriaBase();
		obj = (MemoriaBase) ProcessLoli.Leitura(memo);
		
		int quantidade = obj.getQTDFrases();
		ler.close();
		return quantidade;
	}
	
	public static String LerFrase(int index) throws IOException{
		File arquivo = new File("F"+index+".txt");
		BufferedReader ler = new BufferedReader(new FileReader(arquivo));
		
		Frase frase = new Frase();
		
		String palavras = ler.readLine();
		frase.setPalavras(palavras);
		
		String assunto = ler.readLine();
		frase.setAssunto(assunto);
		
		System.out.println("Leitura Concluida!");
		ler.close();
		return frase.getAssunto();
	}
	
	public static String LerFrasePalavras(int index) throws IOException{
		File arquivo = new File("F"+index+".txt");
		BufferedReader ler = new BufferedReader(new FileReader(arquivo));
		
		Frase frase = new Frase();
		
		String palavras = ler.readLine();
		frase.setPalavras(palavras);
		
		String assunto = ler.readLine();
		frase.setAssunto(assunto);
		
		System.out.println("Leitura Concluida!");
		ler.close();
		return frase.getPalavras();
	}
	
	public static String CorrecaoFrases(String frase) throws IOException{
		double aux = 0;
		String fraseFinal;
		double bufferPorcentagem[] = new double[100];
		String bufferfrase[] = new String [100];
		int index = 0;
		for (int i = 1; i < ProcessDiversos.ChamadaQTDFrases(); i++) {
			File arquivo = new File("F"+i+".txt");
			BufferedReader ler = new BufferedReader(new FileReader(arquivo));
			String palavras = ler.readLine();
			double porcentagem = CalcularPorcentagem(frase, palavras);
				if (porcentagem==100) {
					ler.close();
					return palavras;
				}else if(porcentagem>=60){
					System.out.println(porcentagem+" / "+ palavras);
					index++;
					bufferPorcentagem[index] = porcentagem;
					bufferfrase[index] = palavras;
				}
			
			for (int j = 0; j < bufferPorcentagem.length; j++) {
				for (int j2=j+1; j2 < bufferPorcentagem.length; j2++) {
					if(bufferPorcentagem[j]>bufferPorcentagem[j2]){
						aux = bufferPorcentagem[j];
						bufferPorcentagem[j] = bufferPorcentagem[j2];
						bufferPorcentagem[j2] = aux;
					
						fraseFinal = bufferfrase[j];
						bufferfrase[j] = bufferfrase[j2];
						bufferfrase[j2] = fraseFinal;
					}
				}
			}
			if(bufferPorcentagem[99]>=80){
				fraseFinal = bufferfrase[99];
				ler.close();
				return fraseFinal;
			}else if(bufferPorcentagem[99]>=70){
				fraseFinal = bufferfrase[99];
				ler.close();
				return fraseFinal;
			}
			else if(bufferPorcentagem[99]>=65){
				fraseFinal = bufferfrase[99];
				ler.close();
				return fraseFinal;
			}
			ler.close();
		}
		return "";
	}
	
	public static double CalcularPorcentagem(String frase, String palavras){
		int acerto = 0;
		double porcentagem = 0;
		for (int i = 0; i < palavras.length(); i++) {
			try {
				if (frase.equalsIgnoreCase(palavras)) {
					return 100;
				}else if (palavras.charAt(i)==frase.charAt(i)) {
					acerto++;
				}	
			} catch (Exception e) {
		}
		//calculo da porcentagem que determinara a substituição ou não da palavra digitada pela armazenada
		porcentagem = acerto*100/(palavras.length());
		}
		return porcentagem;
	}
	
}
