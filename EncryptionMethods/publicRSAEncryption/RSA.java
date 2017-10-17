package publicRSAEncryption;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import org.bouncycastle.util.encoders.Base64;

import interfaceUsed.encryptDecrypt;

public class RSA implements encryptDecrypt {
	Cipher cipher;
	byte[] cipherByte,decryptedByte;
	public RSA() {
		try {
			cipher=Cipher.getInstance("RSA");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Override
	public String getEncryptedData() {
		// TODO Auto-generated method stub
		return new String(new String(Base64.encode(cipherByte)));
	}
	@Override
	public String getDecryptedData() {
		// TODO Auto-generated method stub
		return new String(decryptedByte);
	}
	
	@Override
	public void startEncryption(String key, String messageToEncrypt) {
		// TODO Auto-generated method stub
		
		
	}
	@Override
	public void startDecryption(String key, String chiperText) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void startEncryption(PublicKey key, String messageToEncrypt) {
		// TODO Auto-generated method stub
		try {
			cipher.init(Cipher.ENCRYPT_MODE,key);
			cipherByte=cipher.doFinal(messageToEncrypt.getBytes());
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BadPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Override
	public void startDecryption(PrivateKey key, String messageToDecrypt) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				try {
					cipher.init(Cipher.DECRYPT_MODE,key);
					byte[] temp=Base64.decode(messageToDecrypt);
					decryptedByte=cipher.doFinal(temp);
				} catch (InvalidKeyException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalBlockSizeException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (BadPaddingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
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

}
