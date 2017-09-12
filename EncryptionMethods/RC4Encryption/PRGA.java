package RC4Encryption;

public class PRGA {
	int []chiperText;
	int[]decryptText;
	int []key;
	PRGA(int messageLength){
		chiperText=new int[messageLength];
		decryptText=new int[messageLength];
		key=new int[messageLength];
	}
	void generateStream(int stateSize,int[]stateVector) {
		int index=0,indexy=0;
		for(int indexMessage=0;indexMessage<chiperText.length;indexMessage++) {
			index=(indexMessage+1)%stateSize;
			indexy=(indexy+stateVector[index])%stateSize;
			int temp=stateVector[index];
			stateVector[index]=stateVector[indexy];
			stateVector[indexy]=temp;
			key[indexMessage]=stateVector[(stateVector[index]+stateVector[indexy])%stateSize];
		}
	}
	public void encryptText(char[]message) {
		for(int indexMessage=0;indexMessage<chiperText.length;indexMessage++) {
			chiperText[indexMessage]=key[indexMessage]^message[indexMessage];
		}	
	}
	public void decryptText() {
		for(int indexMessage=0;indexMessage<chiperText.length;indexMessage++) {
			decryptText[indexMessage]=key[indexMessage]^chiperText[indexMessage];
		}	
	}
	public int[]getChiperText(){
		return chiperText;
	}
	public int[] getDecryptText() {
		return decryptText;
	}
}
