package eiGamal;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import interfaceUsed.encryptDecrypt;

public class EIGamal implements encryptDecrypt {
	String encryptData;
	String decryptedData;
	byte [] temp;
	String algo="ElGamal/ECB/PKCS1PADDING";
	@Override
	public void startEncryption(String key, String messageToEncrypt) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void startEncryption(PublicKey key, String messageToEncrypt) {
			try {
				Cipher cipher = Cipher.getInstance(algo,"BC");
				cipher.init(Cipher.ENCRYPT_MODE,key);
			
						temp=cipher.doFinal(messageToEncrypt.getBytes());
						
						encryptData=Base64.getEncoder().encodeToString(temp);
			}
			catch (NoSuchProviderException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException | NoSuchAlgorithmException | NoSuchPaddingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
	}

	@Override
	public void startDecryption(PrivateKey key, String messageToDecrypt) {
		// TODO Auto-generated method stub
		try {
			Cipher cipher = Cipher.getInstance(algo,"BC");
			cipher.init(Cipher.DECRYPT_MODE,key);
			decryptedData=new String(cipher.doFinal(Base64.getDecoder().decode(messageToDecrypt)));
		}
		catch (NoSuchProviderException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException | NoSuchAlgorithmException | NoSuchPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
	}

	@Override
	public void startDecryption(String key, String chiperText) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void startEncryption() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void startDecryption() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setMessage(String message) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getEncryptedData() {
		// TODO Auto-generated method stub
		return encryptData;
	}

	@Override
	public String getDecryptedData() {
		// TODO Auto-generated method stub
		return decryptedData;
	}
	
}
