package criptografia;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.jar.JarOutputStream;

import javax.swing.JOptionPane;


public class CifraVigenere {

	public static void main(String[] args) throws IOException {
		
		
		
		Scanner teclado = new Scanner(System.in);

		
		System.out.println("Digite um texto: ");
		String txtoUsuario = teclado.nextLine();
		System.out.println("Digite a senha: ");
		String senha = teclado.nextLine();
		
		String textoCriptografado = "";
		
		//transforma os textos digitados em charArray
		char[] arrayChartxtUsuario = txtoUsuario.toCharArray();
		char[] arrayChartSenha = senha.toCharArray();
		
		
		
		for (int i = 0, j= 0; i < arrayChartxtUsuario.length; i++) {
			
	
			textoCriptografado += (char) (arrayChartxtUsuario[i] + arrayChartSenha[j]);
//			textoCriptografado += arrayChartxtUsuario[i];
			
			if (j == arrayChartSenha.length-1) {
				j = -1;
			}
			j++;
		}

		
		File fileOutput = new File("C:\\Users\\pubdaniel\\Desktop\\teste_criptografado.txt");
		System.out.println("Arquivo salvo em D:/Aluno/teste_criptografado.txt");
		
		
//		File f2 = new File(J);
		FileOutputStream fOut = new FileOutputStream(fileOutput);
		DataOutputStream dOut = new DataOutputStream(fOut);
//		System.out.println(txtoUsuario);
		dOut.writeBytes(textoCriptografado);
		
		
		
//		File fileInput = new File("D:\\Aluno\\teste_criptografado.txt");
		
		//Scanner txtCriptografado = new Scanner("D:\\Aluno\\teste_criptografado.txt");
		File f= new File("C:\\Users\\pubdaniel\\Desktop\\teste_criptografado.txt");
		FileInputStream fin = new FileInputStream(f);
		DataInputStream din = new DataInputStream(fin);
		byte[] conteudoArquivo= new byte[fin.available()];
		din.readFully(conteudoArquivo);
		
		String strArquivo=String.valueOf(conteudoArquivo);
		System.out.println(strArquivo);
		
//		String textoCompleto = "";
//		String linha = din.readLine();
		
		
		
		
		
		
//		DataInputStream dIn = new DataInputStream(fIn);
		
		
		
//		for (int = 0; i > dIn.)
//		char[] txtCriptografado = dIn.readFully();
//		
//		for (int i = 0, j= 0; i < arrayChartxtUsuario.length; i++) {
//			
//			
//			textoCriptografado += (char) (arrayChartxtUsuario[i] + arrayChartSenha[j]);
////			textoCriptografado += arrayChartxtUsuario[i];
//			
//			if (j == arrayChartSenha.length-1) {
//				j = -1;
//			}
//			j++;
//		}
		
		

	}

}
