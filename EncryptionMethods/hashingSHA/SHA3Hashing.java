package hashingSHA;

import org.bouncycastle.jcajce.provider.digest.SHA3;
import org.bouncycastle.util.encoders.Base64;
import org.bouncycastle.util.encoders.Hex;

import interfaceUsed.Hashing;

public class SHA3Hashing implements Hashing {
	String Message;
	SHA3.DigestSHA3 _sha3;
	byte[] hashedMessage;
	public SHA3Hashing() {
		_sha3=new SHA3.Digest512();
	}
	public void enterMessage(String _message) {
		// TODO Auto-generated method stub
		Message=_message;
	}

	@Override
	public void doHashEncoding() {
		hashedMessage=_sha3.digest(Message.getBytes());
		
		// TODO Auto-generated method stub
		
	}

	@Override
	public String showHashedMessage() {
		return new String(Base64.encode(hashedMessage));
		//in hex
		//return new String(Hex.toHexString(hashedMessage));
		// TODO Auto-generated method stub
		//return null;
	}

}
