package caesarChiper;

public class message {
	String messageToSend;
	int shiftBit;
	char direction;
	message(String message,int bit,char dirn){
		messageToSend=message;
		shiftBit=bit;
		setshiftDirn(dirn);
	}
	public String getMessageToSend() {
		return messageToSend;
	}
	public int getShiftBit() {
		return shiftBit;
	}
	public char getDirection() {
		return direction;
	}
	void setshiftDirn(char shiftingDirection){
		if(shiftingDirection=='l'||shiftingDirection=='L'||
				shiftingDirection=='r'||shiftingDirection=='R'){
			direction=shiftingDirection;
		}
		else{
			System.out.println("Shifting in left direction as specified direction is ambigous");
			direction='l';
		}
	} 
}
