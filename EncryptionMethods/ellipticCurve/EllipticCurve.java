package ellipticCurve;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Security;
import java.security.spec.ECGenParameterSpec;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import interfaceUsed.decrypt;
import interfaceUsed.encrypt;

public class EllipticCurve implements encrypt,decrypt{
String algo="ECIES";
String decryptMessage;
String encryptedMessage;
	public EllipticCurve() {
		  Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
			
	}
	@Override
	public void startDecryption(String key, String chiperText) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public String getDecryptedData() {
		// TODO Auto-generated method stub
		return decryptMessage;
	}
	@Override
	public void startDecryption(byte[] key, String chiperText) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void startEncryption(String key, String messageToEncrypt) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public String getEncryptedData() {
		// TODO Auto-generated method stub
		return encryptedMessage;
	}
	@Override
	public void startEncryption(byte[] key, String messageToEncrypt) {
		
	}
	@Override
	public void startDecryption(PrivateKey key, String chiperText) {
		// TODO Auto-generated method stub
		try {
			Cipher cipher=Cipher.getInstance(algo,"BC");
			cipher.init(Cipher.DECRYPT_MODE, key);
			byte[] data=cipher.doFinal(Base64.getDecoder().decode(chiperText));
			decryptMessage=new String(data);
		} catch (NoSuchAlgorithmException | NoSuchProviderException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
}
	@Override
	public void startEncryption( PublicKey key, String messageToEncrypt) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				try {
					Cipher cipher=Cipher.getInstance(algo,"BC");
					cipher.init(Cipher.ENCRYPT_MODE, key);
					byte[] data=cipher.doFinal(messageToEncrypt.getBytes());
					//System.out.println(new String(data));
					encryptedMessage=Base64.getEncoder().encodeToString(data);
					//System.out.println(new String(encryptedMessage));
				} catch (NoSuchAlgorithmException | NoSuchProviderException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
	}
	
	
}
