package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JTextArea;

public class ControleFace implements ActionListener{
	private JTextArea textAreaLoli;
	private JTextArea textAreaUsuario;
	static String resposta;
	public ControleFace(JTextArea textAreaLoli1, JTextArea textAreaUsuario1) {
		this.textAreaLoli = textAreaLoli1;
		this.textAreaUsuario = textAreaUsuario1;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		
		if(cmd=="Enviar"){
			String frase = textAreaUsuario.getText();
			textAreaUsuario.setText("");
			try {
				FormularResposta.Decifrar(frase);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		textAreaLoli.setText(resposta);
		
	}


	public static void RecebeResp(String frase){
		resposta = frase;
	}


}
