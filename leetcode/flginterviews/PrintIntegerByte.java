/**
 * 
 * byte[] printbyte(int a){
    
    byte result [] = new byte[4];
    
    result[0] = a>>>24&0xFF;
    result[1] = a>>>16&oxFF;
    result[2] = a>>>8&oxFF;
    result[3] = a&oxFF;
    return result;
    }
 * */

@Deprecated
public class PrintIntegerByte {

	public static void main(String[] args) {
		
		//the byte in java is signed
		int i =132;
		byte b =(byte)i;
		System.out.println(b);
		
		byte signedByte = -1;
		int unsignedByte = signedByte & (0xff);

		System.out.println("Signed: " + signedByte + " Unsigned: " + unsignedByte);
	}
	
}
