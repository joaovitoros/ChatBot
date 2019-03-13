package controller;

import java.io.IOException;

import javax.swing.JOptionPane;

public class FormularResposta {
	public static void Decifrar(String frase) throws IOException {
		int i = ProcessDiversos.VerificaFrase(frase.trim());
		if (frase.equalsIgnoreCase("Adicionar novo assunto")){
			String nome = JOptionPane.showInputDialog("Qual o nome do assunto?");
			String tipo = JOptionPane.showInputDialog("Qual o tipo do assunto?");
			ProcessDiversos.ChamadaAssunto(nome, tipo);
			EnviarResposta("Processo de aprendizado finalizado, agradeço por me ensinar coisas novas!");
		}else if(frase.equalsIgnoreCase("Adicionar nova frase")){
			String fra = JOptionPane.showInputDialog("Qual a frase?");
			String tipo = JOptionPane.showInputDialog("Qual o tipo de assunto que essa frase pertence?");
			String resp = JOptionPane.showInputDialog("Me diga uma possivel resposta para essa frase");
			ProcessDiversos.ChamadaFrase(fra, tipo, resp);
			EnviarResposta("Processo de aprendizado finalizado, agradeço por me ensinar coisas novas!");
		}else if(frase.equalsIgnoreCase("Adicionar novo amigo")){
			String nome = JOptionPane.showInputDialog("Qual o seu nome?");
			if(ProcessDiversos.ChamadaQTDAmigo()<1){
				EnviarResposta("Agradeço, é bom ter um amigo!");
			}else{
				EnviarResposta("Agradeço, é bom fazer um novo amigo!");
			}
			ProcessDiversos.ChamadaAmigo(nome);
		}else if(frase.equalsIgnoreCase("Mudar apelido da ia")){
			String nome = JOptionPane.showInputDialog("Qual o seu nome?");
			try {
				ProcessAmigo.LerAmigo(nome);
				String apelido = JOptionPane.showInputDialog("Qual o apelido que gostaria de me dar?");
				ProcessDiversos.ChamadaMudarApelido(apelido, nome);
				EnviarResposta("Ótimo! Adorei o apelido!");
			} catch (Exception e) {
				EnviarResposta("Infelizmente ainda não somos amigos...");
			}
		}else if(frase.equalsIgnoreCase("Adicionar palavra")){
			String palavra = JOptionPane.showInputDialog("Diga a palavra que gostaria de adicionar");
			ProcessDiversos.ChamadaPalavra(palavra);
			EnviarResposta("Processo de aprendizado finalizado, agradeço por me ensinar coisas novas!");
		}else{	
			try {
				if(ProcessFrase.LerFrase(i).equalsIgnoreCase("status")){
					EnviarResposta(ProcessResposta.LerResposta(i) + "\nnivel de humor em... " +ProcessDiversos.ChamadaHumor() +" de 10");
				}else if(ProcessFrase.LerFrase(i).equalsIgnoreCase("informaçoes tecnicas")){
					EnviarResposta(ProcessResposta.LerResposta(i) + "\nnumero de " +ProcessDiversos.ChamadaVersao());
				}else if(ProcessFrase.LerFrase(i).equalsIgnoreCase("comando de desligamento")){
					EnviarResposta(ProcessResposta.LerResposta(i));
					System.exit(0);
				}else{	
					EnviarResposta(ProcessResposta.LerResposta(i));
				}
			} catch (IOException e) {
					try {
						//teste de detecção de erro de digitação
						String novafrase = ProcessDiversos.CorrigirPalavras(frase);
						System.out.println(novafrase);
						try {
							i = ProcessDiversos.VerificaFrase(novafrase);
							EnviarResposta(ProcessResposta.LerResposta(i));
						} catch (Exception e2) {
							try {
								//teste de correção de frases
								String frasecorrigida = ProcessDiversos.CorrigirFrases(novafrase);
								System.out.println(frasecorrigida);
								try {
									i = ProcessDiversos.VerificaFrase(frasecorrigida);
									EnviarResposta(ProcessResposta.LerResposta(i));
								} catch (Exception e4) {
									EnviarResposta("Não entendi o que disse");
								}
							} catch (Exception e3) {
								e3.printStackTrace();
							}
						}
					} catch (Exception e2) {
						e2.printStackTrace();
					}
				e.printStackTrace();
			}
		}
	}

	public static void EnviarResposta(String frase) {
		ControleFace.RecebeResp(frase);
	}
}
