package controller;

import java.io.IOException;
import java.util.Iterator;
import java.util.Vector;

import model.Amigo;
import model.MemoriaBase;

public class ProcessDiversos {
	public static void ChamadaAssunto(String nome, String tipo) throws IOException{
		MemoriaBase[] memo = new MemoriaBase[2];
		ProcessLoli.ChamadaAssunto(memo, nome, tipo);
	}
	
	public static void ChamadaFrase(String fra, String tipo, String resp) throws IOException{
		MemoriaBase[] memo = new MemoriaBase[2];
		ProcessFrase.AtualizaQTDFrases(memo);
		ProcessFrase.GravaFrase(fra, tipo, ChamadaQTDFrases());
		ProcessResposta.GravaResposta(fra, resp, ChamadaQTDFrases());
	    ChamadaAddPalavras(fra);
	}
	
	public static int ChamadaHumor() throws IOException{
		MemoriaBase[] memo = new MemoriaBase[2];
		MemoriaBase obj = new MemoriaBase();
		obj = (MemoriaBase) ProcessLoli.Leitura(memo);
		return obj.getHumor();
	}

	public static String ChamadaVersao() throws IOException {
		MemoriaBase[] memo = new MemoriaBase[2];
		MemoriaBase obj = new MemoriaBase();
		obj = (MemoriaBase) ProcessLoli.Leitura(memo);
		return obj.getVersao();
	}
	
	public static void ChamadaMudarApelido(String apelido, String nome) throws IOException{
		Amigo obj = new Amigo();
		obj = (Amigo) ProcessAmigo.LerAmigo(nome);
		ProcessAmigo.GravaAmigo(nome, obj.getContHumor(), apelido);
	}
	
	public static int ChamadaQTDFrases() throws IOException{
		MemoriaBase[] memo = new MemoriaBase[2];
		MemoriaBase obj = new MemoriaBase();
		obj = (MemoriaBase) ProcessLoli.Leitura(memo);
		return obj.getQTDFrases();
	}
	
	public static int VerificaFrase(String frase) throws IOException{
		for (int i = 1; i<= ChamadaQTDFrases(); i++){
			if(ProcessFrase.LerFrasePalavras(i).equalsIgnoreCase(frase)){
				return i;
			}
		}
		return 0;
	}
	
	public static void ChamadaPalavra(String palavra) throws IOException {
		MemoriaBase[] memo = new MemoriaBase[2];
		ProcessPalavra.AtualizaQTDPalavras(memo);
		ProcessPalavra.GravaPalavra(palavra);
	}
	
	public static int ChamadaQTDPalavra() throws IOException {
		MemoriaBase[] memo = new MemoriaBase[2];
		int quantidade;
		quantidade = ProcessPalavra.VerificaQTD(memo);
		return quantidade;
	}
	
	public static String CorrigirPalavras(String frase) throws IOException {
		MemoriaBase[] memo = new MemoriaBase[2];
		//separação da frase em um vetor de string, separando palavra por palavra
		String[] fraseseparada = frase.split(" ");
		Vector<String> vetor = new Vector<>();
		String compara, frasefinal = "", fraseCorrigida = "";
		for (int i = 0; i < fraseseparada.length; i++) {
			compara = fraseseparada[i];
			vetor.add(ProcessPalavra.CorrecaoPalavra(compara, memo));	
		}
		Iterator<String> it = vetor.iterator();
		while (it.hasNext()){
			//passando as palavras já testadas de volta para uma string apenas
			frasefinal = frasefinal+" "+it.next();
		}
		for (int i = 1; i < frasefinal.length(); i++) {
			//corrigindo erro de espaços na string, o que pode gerar erro na hora da validação
			fraseCorrigida = fraseCorrigida+frasefinal.charAt(i);
		}
		return fraseCorrigida;
	}
	
	public static void ChamadaAddPalavras(String frase) throws IOException {
		MemoriaBase[] memo = new MemoriaBase[2];
		String[] fraseseparada = frase.split(" ");
		for (int i = 0; i < fraseseparada.length; i++) {
			if(ProcessPalavra.LerPalavra(fraseseparada[i], memo)){
				if(fraseseparada[i].length()>1){
					ProcessPalavra.GravaPalavra(fraseseparada[i]);
					ProcessPalavra.AtualizaQTDPalavras(memo);
				}	
			}
		}
	}
	
	public static void ChamadaAmigo(String nome) throws IOException{
		int i = 0;
		String apelido = "LOLI";
		MemoriaBase[] memo = new MemoriaBase[2];
		ProcessAmigo.GravaAmigo(nome, i, apelido);
		ProcessAmigo.AtualizaQTDAmigo(memo);
	}
	
	public static int ChamadaQTDAmigo() throws IOException{
		MemoriaBase[] memo = new MemoriaBase[2];
		int quantidade = ProcessAmigo.VerificaQTD(memo);
		return quantidade;
	}

	public static String CorrigirFrases(String novafrase) throws IOException {
		String frasecorrigida;
		frasecorrigida = ProcessFrase.CorrecaoFrases(novafrase);
		return frasecorrigida;
	}


}
