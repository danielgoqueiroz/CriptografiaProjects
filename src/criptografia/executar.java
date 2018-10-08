package criptografia;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

import javax.print.DocFlavor.INPUT_STREAM;
import javax.xml.crypto.Data;

public class executar {

	public static void main(String[] args) throws IOException {
		

		System.out.println("Digite um texto: ");
		Scanner teclado = new Scanner(System.in);
		String txtoUsuario = teclado.nextLine();
		
		char[] arrayChar = txtoUsuario.toCharArray();
		String textoCriptografado = "";
		
		for (int i = 0; i < arrayChar.length; i++) {
			
			arrayChar[i] = (char) (arrayChar[i] + 10 );
			textoCriptografado += arrayChar[i];
		
		}

		
		File f2 = new File("D:\\Aluno\\teste_novo.txt");
//		File f2 = new File(J);
		FileOutputStream fOut = new FileOutputStream(f2);
		DataOutputStream dOut = new DataOutputStream(fOut);
//		System.out.println(txtoUsuario);
		dOut.writeBytes(textoCriptografado);
		
		
		
		
//		if (f.exists()) {
//			System.out.println("arquivo existe");
//
//			FileInputStream fin = new FileInputStream(f);
//			DataInputStream din = new DataInputStream(fin);
//			String textoCompleto = "";
//			String linha = din.readLine();
//			
//			while (linha != null) {
//				textoCompleto += linha;
//				linha=din.readLine();
//			}
//			
//			System.out.println(textoCompleto);
//			
//			String txtoCOnvertido = textoCompleto.toUpperCase();
//			
//			File f2 = new File("D:\\Aluno\\teste_novo.txt");
//			FileOutputStream fOut = new FileOutputStream(f2);
//			DataOutputStream dOut = new DataOutputStream(fOut);
//			
//			dOut.writeChars(textoCompleto);
			
//		}
	}

}
