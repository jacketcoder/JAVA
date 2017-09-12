package RC4Encryption;
import java.util.List;

public class KSA {
	int stateSize=256;
	int []stateVector=new int[stateSize];
	int []keyVector=new int[stateSize];
	KSA(List<Integer>intKey) {
		initializeStateVector(intKey);
		
	}
	void initializeStateVector(List<Integer>intKey) {
		for(int index=0;index<stateSize;index++) {
			stateVector[index]=index;
			keyVector[index]=intKey.get(index%intKey.size());
		}
		
	}
	void scrambleStateVector() {
		int indexy=0;
		for(int index=0;index<stateSize;index++) {
			indexy=(indexy+stateVector[index]+keyVector[index])%stateSize;
			int temp=stateVector[index];
			stateVector[index]=stateVector[indexy];
			stateVector[indexy]=temp;
		
		}
	}
	public int[] getStateVector() {
		return stateVector;
	}
	public int getStateSize() {
		return stateSize;
	}
}
