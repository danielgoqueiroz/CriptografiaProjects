package criptografia;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.Scanner;

public class TelaCriptografia {

	private JFrame frame;
	private JTextField textSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try { 
					TelaCriptografia window = new TelaCriptografia();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaCriptografia() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 479);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		textSenha = new JTextField();
		textSenha.setColumns(10);
		
		JTextPane textOriginal = new JTextPane();
		
		JTextPane textCodificado = new JTextPane();
		
		JButton btnCodifica = new JButton("Codifica");
		btnCodifica.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (textSenha.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Campo senha vazio.");
				} else {
					Scanner teclado = new Scanner(System.in);
	
					
					String txtoUsuario = textOriginal.getText() + "";
					String senha = textSenha.getText() + "";
					
					String textoCriptografado = "";
					
					//transforma os textos digitados em charArray
					char[] arrayChartxtUsuario = txtoUsuario.toCharArray();
					char[] arrayChartSenha = senha.toCharArray();
								
					
					for (int i = 0, j= 0; i < arrayChartxtUsuario.length; i++) {
						
				
						textoCriptografado += (char) (arrayChartxtUsuario[i] + arrayChartSenha[j]);
	//					textoCriptografado += arrayChartxtUsuario[i];
						
						if (j == arrayChartSenha.length-1) {
							j = -1;
						}
						j++;
					}
					
					textCodificado.setText(textoCriptografado + "");
					
	//				File fileOutput = new File("C:\\Users\\pubdaniel\\Desktop\\teste_criptografado.txt");
	//				System.out.println("Arquivo salvo em D:/Aluno/teste_criptografado.txt");
					
				}
			}
		});
		
		JButton btnDecodifica = new JButton("Decodifica");
		btnDecodifica.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (textSenha.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Campo senha vazio.");
				} else {
	
					
					String txtoUsuario = textCodificado.getText() + "";
					String senha = textSenha.getText() + "";
					
					String textoDescriptografado = "";
					
					//transforma os textos digitados em charArray
					char[] arrayChartxtUsuario = txtoUsuario.toCharArray();
					char[] arrayChartSenha = senha.toCharArray();
								
					
					for (int i = 0, j= 0; i < arrayChartxtUsuario.length; i++) {
						
				
						textoDescriptografado += (char) (arrayChartxtUsuario[i] - arrayChartSenha[j]);
	//					textoCriptografado += arrayChartxtUsuario[i];
						
						if (j == arrayChartSenha.length-1) {
							j = -1;
						}
						j++;
					}
					
					textOriginal.setText(textoDescriptografado + "");
					
	//				File fileOutput = new File("C:\\Users\\pubdaniel\\Desktop\\teste_criptografado.txt");
	//				System.out.println("Arquivo salvo em D:/Aluno/teste_criptografado.txt");
					
				}
			}
				
				
			
		});
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(textSenha, GroupLayout.PREFERRED_SIZE, 203, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnCodifica, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(18)
							.addComponent(btnDecodifica, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE))
						.addComponent(textOriginal, GroupLayout.PREFERRED_SIZE, 404, GroupLayout.PREFERRED_SIZE)
						.addComponent(textCodificado, GroupLayout.PREFERRED_SIZE, 404, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(19, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(textOriginal, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textSenha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnCodifica)
						.addComponent(btnDecodifica))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(textCodificado, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		frame.getContentPane().setLayout(groupLayout);
	}
}
