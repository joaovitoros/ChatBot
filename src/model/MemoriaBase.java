package model;

public class MemoriaBase {
	private int QTDAssuntos;
	private int Humor;
	private int QTDFrases;
	private int vida;
	private String Nome;
	private int QTDAmigos;
	private String frase;
	private String versao;
	private int QTDPalavras;
	public int getQTDPalavras() {
		return QTDPalavras;
	}
	public void setQTDPalavras(int qTDPalavras) {
		QTDPalavras = qTDPalavras;
	}
	public String getVersao() {
		return versao;
	}
	public void setVersao(String versao) {
		this.versao = versao;
	}
	public String getFrase() {
		return frase;
	}
	public void setFrase(String frase) {
		this.frase = frase;
	}
	public int getQTDAmigos() {
		return QTDAmigos;
	}
	public void setQTDAmigos(int qTDAmigos) {
		QTDAmigos = qTDAmigos;
	}
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public int getVida() {
		return vida;
	}
	public void setVida(int vida) {
		this.vida = vida;
	}
	public int getQTDAssuntos() {
		return QTDAssuntos;
	}
	public void setQTDAssuntos(int qTDAssuntos) {
		QTDAssuntos = qTDAssuntos;
	}
	public int getHumor() {
		return Humor;
	}
	public void setHumor(int humor) {
		Humor = humor;
	}
	public int getQTDFrases() {
		return QTDFrases;
	}
	public void setQTDFrases(int qTDFrases) {
		QTDFrases = qTDFrases;
	}

	@Override
	public String toString() {
		return getNome();
	}
}
