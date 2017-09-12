package caesarChiper;

public class decryptionAlgo {
	String decryptedMessage;
	int upperBoundary,lowerBoundary;
	decryptionAlgo(){
		upperBoundary=(int)'z';
		lowerBoundary=(int)'a';
	}
	public void decryptMessage(String encryptedMessage,char dirn,int shiftBit){
		char []decryptedMessageHolder=new char[encryptedMessage.length()];
		if(dirn=='l'){
			for (int index=0;index<encryptedMessage.length();index++){
				int initialAscii=(int)encryptedMessage.charAt(index);
				int finalAscii=initialAscii+shiftBit;
				char encodedLetter=(char)checkLimit(finalAscii);
				decryptedMessageHolder[index]=encodedLetter;
			}
		}
		else{
			for (int index=0;index<encryptedMessage.length();index++){
				int initialAscii=(int)encryptedMessage.charAt(index);
				int finalAscii=initialAscii-shiftBit;
				char encodedLetter=(char)checkLimit(finalAscii);
				decryptedMessageHolder[index]=encodedLetter;
			}
			
		}
		decryptedMessage=new String(decryptedMessageHolder);
	}
	public int checkLimit(int asciiValue){
		if(asciiValue>upperBoundary){//has value greater that z
			int greaterTerm=asciiValue-upperBoundary;
			greaterTerm--;
			int modifiedAscii=lowerBoundary+greaterTerm;
			return modifiedAscii;
		}
		else if(asciiValue<lowerBoundary){
			int lowerTerm=lowerBoundary-asciiValue;
			lowerTerm--;
			int modifiedAscii=upperBoundary-lowerTerm;
			return modifiedAscii;
			
		}
		else{
			return asciiValue;
		}
		
	}
	public String getDecryptedMessage() {
		return decryptedMessage;
	}
}
