package ht.helloworld;

public class ConversionTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Conversion c = new Conversion();
//		float response1 = CenF(32);
//		float response2 = FenC(95.3);
		
		float response1 = c.CenF(32);
		System.out.println(response1);
		float response2 = c.FenC((float) 9.3);
		System.out.println(response2);
		
		System.out.println();
		
		float response3 = Conversion.CenF(32);
		System.out.println(response3);
		float response4 = Conversion.FenC((float) 9.3);
		System.out.println(response4);
		
		
		
		
	}

}
