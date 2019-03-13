package controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import model.MemoriaBase;
import model.Palavra;

public class ProcessPalavra {
	public static void GravaPalavra(String palavra) throws IOException {
		File arquivo = new File("Palavras.txt");
		BufferedWriter grava = new BufferedWriter(new FileWriter(arquivo, true));
		
			Palavra palavr = new Palavra();
			
			palavr.setPalavra(palavra);
			grava.write(palavr.getPalavra());
			grava.newLine();
			
			System.out.println("Gravação Concluida!");
			grava.close();
		
	}
	
	public static int AtualizaQTDPalavras(MemoriaBase[] memo) throws IOException{
		File arquivo = new File("Memoriabase.txt");
		BufferedReader ler = new BufferedReader(new FileReader(arquivo));
		MemoriaBase obj = new MemoriaBase();
		obj = (MemoriaBase) ProcessLoli.Leitura(memo);
		
		ProcessLoli.GravacaoParam(obj.getQTDAssuntos(), obj.getHumor(), obj.getQTDFrases(), obj.getVida(), obj.getNome(),
				obj.getQTDAmigos(), obj.getVersao(), obj.getQTDPalavras()+1);
		
		ler.close();
		return obj.getQTDPalavras()+1;
	}
	
	public static int VerificaQTD(MemoriaBase[] memo) throws IOException{
		File arquivo = new File("Memoriabase.txt");
		BufferedReader ler = new BufferedReader(new FileReader(arquivo));
		
		MemoriaBase obj = new MemoriaBase();
		obj = (MemoriaBase) ProcessLoli.Leitura(memo);
		
		int quantidade = obj.getQTDPalavras();
		ler.close();
		return quantidade;
	}
	
	public static String CorrecaoPalavra(String compara, MemoriaBase[] memo) throws IOException{
		File arquivo = new File("Palavras.txt");
		BufferedReader ler = new BufferedReader(new FileReader(arquivo));
		double aux;
		String palavraFinal = "";
		double porcentagem = 0;
		String palavra;
		double bufferPorcentagem[] = new double[500];
		String bufferPalavra[] = new String[500];
		for (int i = 0; i < VerificaQTD(memo); i++) {
			palavra = ler.readLine();
			porcentagem = CalculoPorcentagem(compara, palavra);
			if (porcentagem==100) {
				ler.close();
				return palavra;
			}else if(porcentagem>=70){
				System.out.println(porcentagem+"/"+ palavra);
				bufferPorcentagem[i] = porcentagem;
				bufferPalavra[i] = palavra;
			}
		}
		
		for (int j = 0; j < bufferPorcentagem.length; j++) {
			for (int j2=j+1; j2 < bufferPorcentagem.length; j2++) {
				if(bufferPorcentagem[j]>bufferPorcentagem[j2]){
					aux = bufferPorcentagem[j];
					bufferPorcentagem[j] = bufferPorcentagem[j2];
					bufferPorcentagem[j2] = aux;
						
					palavraFinal = bufferPalavra[j];
					bufferPalavra[j] = bufferPalavra[j2];
					bufferPalavra[j2] = palavraFinal;
				}
			}
			if(bufferPorcentagem[99]>=90){
				palavraFinal = bufferPalavra[99];
				ler.close();
				return palavraFinal;
			}else if(bufferPorcentagem[99]>=80){
				palavraFinal = bufferPalavra[99];
				ler.close();
				return palavraFinal;
			}
			else if(bufferPorcentagem[99]>=75){
				palavraFinal = bufferPalavra[99];
				ler.close();
				return palavraFinal;
			}
			
		}
		
		System.out.println("Leitura Concluida!");
		ler.close();
		return compara;
	}
	
	public static double CalculoPorcentagem(String compara, String palavra){
		int acerto = 0;
		double porcentagem = 0;
		for (int i = 0; i < palavra.length(); i++) {
			try {
				if (compara.equalsIgnoreCase(palavra)) {
					return 100;
				}else if (palavra.charAt(i)==compara.charAt(i)) {
					acerto++;
				}	
			} catch (Exception e) {
		}
		//calculo da porcentagem que determinara a substituição ou não da palavra digitada pela armazenada
		porcentagem = acerto*100/(palavra.length());
		}
		return porcentagem;
	}

	public static boolean LerPalavra(String compara, MemoriaBase[] memo) throws IOException {
		
		File arquivo = new File("Palavras.txt");
		BufferedReader ler = new BufferedReader(new FileReader(arquivo));
		for (int i = 0; i < VerificaQTD(memo); i++) {
			String palavra = ler.readLine();
			if(palavra.equalsIgnoreCase(compara)){
				ler.close();
				return false;
			}
		}
		ler.close();
		return true;
	}
}
