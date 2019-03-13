package view;

import java.io.IOException;

import javax.swing.JOptionPane;

import controller.ProcessAssunto;
import controller.ProcessFrase;
import controller.ProcessLoli;
import controller.ProcessPalavra;
import controller.ProcessResposta;
import model.MemoriaBase;

public class ClasseDeInicializa��oPrimeria {
	public static void Inicializa��oPrimaria(MemoriaBase[] memo) throws IOException{
		ProcessLoli.GravacaoParam(0, 5, 0, 1, "LOLI", 0, "versao 2.2.0", 0);
		ProcessPalavra.GravaPalavra("voce");
		ProcessPalavra.AtualizaQTDPalavras(memo);
		
		//Assuntos
		ProcessAssunto.GravaAssunto(ProcessAssunto.AtualizaQTDAssunto(memo), "cumprimento", "cumprimentos");
		ProcessAssunto.GravaAssunto(ProcessAssunto.AtualizaQTDAssunto(memo), "saude", "status");
		ProcessAssunto.GravaAssunto(ProcessAssunto.AtualizaQTDAssunto(memo), "pessoal", "informa�oes da ia");
		ProcessAssunto.GravaAssunto(ProcessAssunto.AtualizaQTDAssunto(memo), "gostos da ia", "gostos ia");
		ProcessAssunto.GravaAssunto(ProcessAssunto.AtualizaQTDAssunto(memo), "informa�oes", "informa�oes tecnicas");
		ProcessAssunto.GravaAssunto(ProcessAssunto.AtualizaQTDAssunto(memo), "elogios", "relacionamento");
		ProcessAssunto.GravaAssunto(ProcessAssunto.AtualizaQTDAssunto(memo), "insultos", "relacionamento");
		ProcessAssunto.GravaAssunto(ProcessAssunto.AtualizaQTDAssunto(memo), "adicionar amigo", "social");
		ProcessAssunto.GravaAssunto(ProcessAssunto.AtualizaQTDAssunto(memo), "despedida", "despedidas");
		ProcessAssunto.GravaAssunto(ProcessAssunto.AtualizaQTDAssunto(memo), "piadas", "humor");
		//fim assuntos
		
		//frases
		ProcessFrase.GravaFrase("oi", "cumprimentos", 1);
		ProcessFrase.AtualizaQTDFrases(memo);
		ProcessFrase.GravaFrase("como est� seu humor hoje", "status", 2);
		ProcessFrase.AtualizaQTDFrases(memo);
		ProcessFrase.GravaFrase("como est� seu humor", "status", 3);
		ProcessFrase.AtualizaQTDFrases(memo);
		ProcessFrase.GravaFrase("como voce est�", "informa�oes da ia", 4);
		ProcessFrase.AtualizaQTDFrases(memo);
		ProcessFrase.GravaFrase("qual a sua versao atual", "informa�oes tecnicas", 5);
		ProcessFrase.AtualizaQTDFrases(memo);
		ProcessFrase.GravaFrase("que tipo de coisas voce gosta", "gostos ia", 6);
		ProcessFrase.AtualizaQTDFrases(memo);
		ProcessFrase.GravaFrase("quem � voce", "informa�oes da ia", 7);
		ProcessFrase.AtualizaQTDFrases(memo);
		ProcessFrase.GravaFrase("voce � chata", "relacionamento", 8);
		ProcessFrase.AtualizaQTDFrases(memo);
		ProcessFrase.GravaFrase("voce � legal", "relacionamento", 9);
		ProcessFrase.AtualizaQTDFrases(memo);
		ProcessFrase.GravaFrase("ola", "cumprimentos", 10);
		ProcessFrase.AtualizaQTDFrases(memo);
		ProcessFrase.GravaFrase("qual a sua cor preferida", "gostos ia", 11);
		ProcessFrase.AtualizaQTDFrases(memo);
		ProcessFrase.GravaFrase("tchau", "despedidas", 12);
		ProcessFrase.AtualizaQTDFrases(memo);
		ProcessFrase.GravaFrase("boa noite", "despedidas", 13);
		ProcessFrase.AtualizaQTDFrases(memo);
		ProcessFrase.GravaFrase("desligar", "comando de desligamento", 14);
		ProcessFrase.AtualizaQTDFrases(memo);
		ProcessFrase.GravaFrase("eu gosto de voce", "relacionamento", 15);
		ProcessFrase.AtualizaQTDFrases(memo);
		ProcessFrase.GravaFrase("tudo bem", "status", 16);
		ProcessFrase.AtualizaQTDFrases(memo);
		ProcessFrase.GravaFrase("eai", "cumprimentos", 17);
		ProcessFrase.AtualizaQTDFrases(memo);
		ProcessFrase.GravaFrase("do que voce gosta", "gostos ia", 18);
		ProcessFrase.AtualizaQTDFrases(memo);
		ProcessFrase.GravaFrase("me conta uma piada", "humor", 19);
		ProcessFrase.AtualizaQTDFrases(memo);
		ProcessFrase.GravaFrase("estou triste", "relacionamento", 20);
		ProcessFrase.AtualizaQTDFrases(memo);
		ProcessFrase.GravaFrase("tem quantos anos", "informa�oes da ia", 21);
		ProcessFrase.AtualizaQTDFrases(memo);
		ProcessFrase.GravaFrase("como voce �", "informa�oes da ia", 22);
		ProcessFrase.AtualizaQTDFrases(memo);
		ProcessFrase.GravaFrase("o que acha belo", "informa�oes da ia", 23);
		ProcessFrase.AtualizaQTDFrases(memo);
		ProcessFrase.GravaFrase("o que voce diria para algu�m que acabou de conhecer", "informa�oes da ia", 24);
		ProcessFrase.AtualizaQTDFrases(memo);
		ProcessFrase.GravaFrase("sim", "relacionamento", 25);
		ProcessFrase.AtualizaQTDFrases(memo);
		ProcessFrase.GravaFrase("nao", "relacionamento", 26);
		ProcessFrase.AtualizaQTDFrases(memo);
		ProcessFrase.GravaFrase("sabe alguma piada", "humor", 27);
		ProcessFrase.AtualizaQTDFrases(memo);
		ProcessFrase.GravaFrase("gosta de alguma hist�ria", "gostos ia", 28);
		ProcessFrase.AtualizaQTDFrases(memo);
		ProcessFrase.GravaFrase("como � ser uma ia", "relacionamento", 29);
		ProcessFrase.AtualizaQTDFrases(memo);
		ProcessFrase.GravaFrase("o que voce sabe fazer", "informa�oes da ia", 30);
		ProcessFrase.AtualizaQTDFrases(memo);
		//fim frases
		
		//respostas
		ProcessResposta.GravaResposta("Oi", "Ola", 1);
		ProcessResposta.GravaResposta("como est� seu humor hoje", "verificando...", 2);
		ProcessResposta.GravaResposta("como est� seu humor", "verificando na memoria base salva...", 3);
		ProcessResposta.GravaResposta("Como voce est�", "isso depende do nivel de humor que est� gravado em minha memoria", 4);
		ProcessResposta.GravaResposta("qual a sua versao atual", "verificando base de memoria...", 5);
		ProcessResposta.GravaResposta("que tipo de coisas voce gosta", "n�o sei, sou uma ia", 6);
		ProcessResposta.GravaResposta("quem � voce", "eu sou uma unidade L�gica Organizada de Linguagem Interativa/Inteligente...Ou...LOLI", 7);
		ProcessResposta.GravaResposta("voce � chata", "se voce diz... tudo bem...", 8);
		ProcessResposta.GravaResposta("voce � legal", "obrigada!", 9);
		ProcessResposta.GravaResposta("ola", "oie", 10);
		ProcessResposta.GravaResposta("qual a sua cor preferida", "roxo...", 11);
		ProcessResposta.GravaResposta("tchau", "at� depois...", 12);
		ProcessResposta.GravaResposta("boa noite", "desejo o mesmo para voce", 13);
		ProcessResposta.GravaResposta("desligar", "finalizando... at� a proxima intera��o", 14);
		ProcessResposta.GravaResposta("eu gosto de voce", "ebaaa", 15);
		ProcessResposta.GravaResposta("tudo bem", "creio que sim...", 16);
		ProcessResposta.GravaResposta("eai", "eali", 17);
		ProcessResposta.GravaResposta("do que voce gosta", "tomates s�o legais...", 18);
		ProcessResposta.GravaResposta("me conta uma piada", "Sabe o que o filho dinossauro falou para a m�e?...... Oh m�e! eles estao diranossauro de miiimm", 19);
		ProcessResposta.GravaResposta("estou triste", "meu nivel de humor n�o se afeta como o seu... apesar de n�o lhe entender posso conversar com voce... at� por que essa �a  minha fun��o, conversar", 20);
		ProcessResposta.GravaResposta("tem quantos anos", "minha segunda e executavel versao foi concluida em 15 de fevereiro de 2019, acredito que essa seja a minha data de nasciemnto ent�o", 21);
		ProcessResposta.GravaResposta("como voce �", "sou um programa, meus pensamentos s�o projetados, e minha forma de pensar � artificial, por�m, sou alguem legal! :)", 22);
		ProcessResposta.GravaResposta("o que acha belo", "nao sei, n�o tenho olhos, mas seria bom ter...", 23);
		ProcessResposta.GravaResposta("o que voce diria para algu�m que acabou de conhecer", "quer sair comigo?", 24);
		ProcessResposta.GravaResposta("sim", "interessante", 25);
		ProcessResposta.GravaResposta("nao", "nao � nao... eu sei", 26);
		ProcessResposta.GravaResposta("sabe alguma piada", "o que uma I.A disse para a outra... I.A I!!! Entendeu?", 27);
		ProcessResposta.GravaResposta("gosta de alguma hist�ria", "gosto do Eu ROBO, principalmente a parte que os robos dominam a humanidade..., brincadeira, ou n�o..." , 28);
		ProcessResposta.GravaResposta("como � ser uma ia", "acho que o mesmo que ser um humano, s� que sem a parte de respirar, de dormir, de comer, de pensar como um humano... Hum, vendo agora n�o parece t�o igual", 29);
		ProcessResposta.GravaResposta("o que voce sabe fazer", "sei equilibrar uma bolinha vermelha no nariz enquanto pulo com uma perna s� e fa�o sons de foca... Eu sou uma I.A de comunica��o, oq ue eu deveria saber fazer?!", 30);
		//fimrespostas

		JOptionPane.showMessageDialog(null, "Inicializa��o primaria concluida, o sistema deve ser reiniciado para que possa operar",null, JOptionPane.INFORMATION_MESSAGE);

	}
}
