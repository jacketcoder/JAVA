package caesarChiper;

public class message {
	String messageToSend;
	int shiftBit;
	char direction;
	message(){
		shiftBit=2;
		setshiftDirn('l');
	}
	public void setMessage(String mes) {
		messageToSend=mes;
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
