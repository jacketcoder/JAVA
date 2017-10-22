package interfaceUsed;

import java.security.PrivateKey;
import java.security.PublicKey;

public interface decrypt {
	void startDecryption(String key,String chiperText);
	void startDecryption(PrivateKey key,String chiperText);
	String getDecryptedData();
	void startDecryption(byte[] key, String chiperText);
	
}
