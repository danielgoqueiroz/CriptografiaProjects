package AES;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.filechooser.FileFilter;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AES {
	static byte[] textoencriptadoBytes;
	private JFrame frame;
	private JTextField textSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try { 
					AES window = new AES();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @return 
	 */
	public AES() {
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
		
		JButton btnCodifica = new JButton("*Codifica");
		btnCodifica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
			}
		});
		btnCodifica.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (textSenha.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Campo senha vazio.");
				}
				
				if (!((textSenha.getText() + "").length() == 8 || (textSenha.getText() + "").length() == 16)) {
					JOptionPane.showMessageDialog(null, "Tamanho de senha inválida");
				} else {

					String txtoUsuario = textOriginal.getText();
					String senha = textSenha.getText();
					
					String textoCriptografadoTela = "";
					 
					
					try {
						textoencriptadoBytes = CriptoAES.encrypt(txtoUsuario, senha);
						
						 for (int i=0; i < textoencriptadoBytes.length; i++) {
							 textoCriptografadoTela += textoencriptadoBytes[i] + "";
						 }
						 
						textCodificado.setText(textoCriptografadoTela);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						System.out.println(e.getMessage());
						JOptionPane.showMessageDialog(null, "Algo que deu errado\nnão deu certo.");
					}
					
					//Escrever txt como write bytes
					
					
	//				File fileOutput = new File("C:\\Users\\pubdaniel\\Desktop\\teste_criptografado.txt");
	//				System.out.println("Arquivo salvo em D:/Aluno/teste_criptografado.txt");
					
				}
			}
		});
		
		JButton btnDecodifica = new JButton("*Decodifica");
		btnDecodifica.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (textSenha.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Campo senha vazio.");
				}
				
				if (!((textSenha.getText() + "").length() == 16)) {
					JOptionPane.showMessageDialog(null, "Tamanho de senha inválida");
				} else {

					byte[] txtoUsuario = textoencriptadoBytes;//(textCodificado.getText()).getBytes();
					String senha = textSenha.getText();
					
			 				
					try {
						String textoDescriptografado = CriptoAES.decrypt(txtoUsuario, senha);
						System.out.println(textoDescriptografado);

						 
						textOriginal.setText(textoDescriptografado);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						System.out.println(e.getMessage());
						JOptionPane.showMessageDialog(null, "Algo que deu errado\nnão deu certo.");
					}
					
			}
				
			}		
			
		});
		
		JButton btnSalva = new JButton("Salva");
		btnSalva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JFileChooser file = new JFileChooser();
				int retruVal = file.showSaveDialog(null);
				
				File f = file.getSelectedFile();
				BufferedReader writer = null;
				
				String currentLine;
				
				if (retruVal == JFileChooser.APPROVE_OPTION) {
					
					try {
						writer = new BufferedReader(new FileReader(f));
						 
						while((currentLine = writer.readLine()) != null) {
							System.out.println(currentLine);
						}
						
					} catch (Exception err) {
						err.printStackTrace();
					}
					
				}
				
				

			}
		});
		
		JButton btnCarregar = new JButton("Carregar");
		btnCarregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser file = new JFileChooser();
				int retruVal = file.showOpenDialog(null);
				
				File f = file.getSelectedFile();
				BufferedReader writer = null;
				
				String currentLine;
				
				if (retruVal == JFileChooser.APPROVE_OPTION) {
					
					try {
						writer = new BufferedReader(new FileReader(f));
						 
						while((currentLine = writer.readLine()) != null) {
							System.out.println(currentLine);
						}
						
					} catch (Exception err) {
						err.printStackTrace();
					}
					
				}
				
			}
		});
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(textCodificado, GroupLayout.PREFERRED_SIZE, 404, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
							.addComponent(textOriginal, GroupLayout.PREFERRED_SIZE, 404, GroupLayout.PREFERRED_SIZE)
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(textSenha, GroupLayout.PREFERRED_SIZE, 203, GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(btnSalva, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(btnCarregar, GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE))
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(btnCodifica, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(btnDecodifica, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE))))))
					.addContainerGap(20, Short.MAX_VALUE))
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
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSalva)
						.addComponent(btnCarregar))
					.addGap(16)
					.addComponent(textCodificado, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		frame.getContentPane().setLayout(groupLayout);
	}
}
