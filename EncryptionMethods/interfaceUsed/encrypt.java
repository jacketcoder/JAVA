package interfaceUsed;

import java.security.PrivateKey;
import java.security.PublicKey;

public interface encrypt {
	void startEncryption(String key,String messageToEncrypt);
	void startEncryption( PublicKey key,String messageToEncrypt);
	String getEncryptedData();
	void startEncryption(byte[] key, String messageToEncrypt);
}
