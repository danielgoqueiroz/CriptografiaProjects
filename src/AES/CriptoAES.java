package AES;
import javax.crypto.spec.SecretKeySpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.Cipher;

public class CriptoAES {

	static String IV = "AAAAAAAAAAAAAAAA";
    static String textopuro = "Este é o texto para ser criptografado utilizando o algoritmo AES de criptografia simétrica.";//"teste texto 12345678\0\0\0";
    static String chaveencriptacao = "0123456789abcdef"; //0123456789abcdef (obrigatoriamente 156 bits) 
    
	
	public static byte[] encrypt(String textopuro, String chaveencriptacao) throws Exception {
        Cipher encripta = Cipher.getInstance("AES/CBC/PKCS5Padding", "SunJCE");
        SecretKeySpec key = new SecretKeySpec(chaveencriptacao.getBytes("UTF-8"), "AES");
        encripta.init(Cipher.ENCRYPT_MODE, key,new IvParameterSpec("AAAAAAAAAAAAAAAA".getBytes("UTF-8")));
        return encripta.doFinal(textopuro.getBytes("UTF-8"));
  }

  public static String decrypt(byte[] textoencriptado, String chaveencriptacao) throws Exception{
        Cipher decripta = Cipher.getInstance("AES/CBC/PKCS5Padding", "SunJCE");
        SecretKeySpec key = new SecretKeySpec(chaveencriptacao.getBytes("UTF-8"), "AES");
        decripta.init(Cipher.DECRYPT_MODE, key,new IvParameterSpec("AAAAAAAAAAAAAAAA".getBytes("UTF-8")));
        return new String(decripta.doFinal(textoencriptado),"UTF-8");
  }
	
}
