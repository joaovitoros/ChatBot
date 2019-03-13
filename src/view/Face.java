package view;

import java.awt.event.KeyAdapter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.sun.glass.events.KeyEvent;

import controller.ControleFace;

public class Face extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldLoliNome;

	/**
	 * Create the frame.
	 * @param nome 
	 */
	public Face(String nome) {
		setTitle("L.O.L.I");
		setResizable(false);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 441, 440);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textFieldLoliNome = new JTextField(nome +":");
		textFieldLoliNome.setEnabled(false);
		textFieldLoliNome.setBounds(10, 11, 86, 20);
		contentPane.add(textFieldLoliNome);
		textFieldLoliNome.setColumns(10);
		
		JTextArea textAreaLoli = new JTextArea();
		textAreaLoli.setLineWrap(true);
		textAreaLoli.setEditable(false);
		textAreaLoli.setBounds(10, 42, 414, 148);
		contentPane.add(textAreaLoli);
		
		JTextArea textAreaUsuario = new JTextArea();
		textAreaUsuario.setWrapStyleWord(true);
		textAreaUsuario.setLineWrap(true);
		textAreaUsuario.setBounds(10, 216, 414, 148);
		contentPane.add(textAreaUsuario);
		
		
		
		JButton btnEnviar = new JButton("Enviar");
		btnEnviar.setBounds(10, 377, 89, 23);
		contentPane.add(btnEnviar);

		ControleFace contface = new ControleFace(textAreaLoli, textAreaUsuario);
		btnEnviar.addActionListener(contface);
		
		textAreaUsuario.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(java.awt.event.KeyEvent evt) {
				if (evt.getKeyCode()==KeyEvent.VK_ENTER) {
					btnEnviar.doClick();
				}
			}
		});
	}

}
