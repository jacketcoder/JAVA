package digitalsignature;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Security;
import java.security.Signature;
import java.security.SignatureException;
import java.util.Base64;

public class ECDSA  {
	String signature;
	public String getSignature() {
		return signature;
	}
	public ECDSA() {
		Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
	}
	public void signatureGeneration(PrivateKey key,String message) {
		try {
			Signature sig=Signature.getInstance("ECDSA");
			sig.initSign(key);
			sig.update(message.getBytes());
			signature=Base64.getEncoder().encodeToString(sig.sign());
		} catch (NoSuchAlgorithmException | InvalidKeyException | SignatureException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	public boolean signatureVerification(PublicKey key,String message,String signature) {
		try {
			Signature sig=Signature.getInstance("ECDSA");
			sig.initVerify(key);
			sig.update(message.getBytes());
			return sig.verify(Base64.getDecoder().decode(signature));
		} catch (NoSuchAlgorithmException | InvalidKeyException | SignatureException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
}
