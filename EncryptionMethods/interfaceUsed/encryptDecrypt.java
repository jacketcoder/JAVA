package interfaceUsed;

import java.security.PrivateKey;
import java.security.PublicKey;

public interface encryptDecrypt {
	void startEncryption(String key,String messageToEncrypt);
	void startEncryption(PublicKey key,String messageToEncrypt);
	void startDecryption(PrivateKey key,String messageToDecrypt);
	void startDecryption(String key,String chiperText);
	void startEncryption();
	void startDecryption();
	void setMessage(String message);
	 String getEncryptedData();
	 String getDecryptedData();
	
}
