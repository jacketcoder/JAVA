package hashingSHA;
import interfaceUsed.Hashing;

public class Entry {
	public static void main(String[] args) {
		String _message="A quick brown fox jumps over the lazy dog";
		Hashing hashing=new SHA3Hashing();
		hashing.enterMessage(_message);
		hashing.doHashEncoding();
		System.out.println("hashed mesage\n"+hashing.showHashedMessage());
		
	}
}
