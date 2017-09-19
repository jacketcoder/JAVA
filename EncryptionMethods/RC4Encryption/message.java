package RC4Encryption;

import java.util.ArrayList;
import java.util.List;

public class message  {
	String plainMessage;
	char[] charPlainMessage;
	List<Integer>intPlainMessage=new ArrayList<Integer>(); 
	String key;
	char[] charKey;
	List<Integer>intKey=new ArrayList<Integer>(); 
	int keyLength;
	message(String _key){
		key=_key;
		keyLength=_key.length();
		
		charKey=key.toCharArray();
		for(int index=0;index<charKey.length;index++)
		intKey.add((int)charKey[index]);
	}
	public String getPlainMessage() {
		return plainMessage;
	}
	public String getKey() {
		return key;
	}
	public List<Integer> getKeyChar() {
		return intKey;
	}
	public char[] getCharPlainMessage() {
		return charPlainMessage;
	}
	public void setMessage(String mes) {
		plainMessage=mes;
		charPlainMessage=plainMessage.toCharArray();
		for(int index=0;index<charPlainMessage.length;index++)
		intPlainMessage.add((int)charPlainMessage[index]);
	}
}
