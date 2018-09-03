package engine;

public class SimpleCodec implements Codec {
	private final int HASH = 5;
	

	
	public int encode(int in) {
		
		return in+HASH;
	}

	public int decode(int in) {
	
		return in-HASH;
	}

}
