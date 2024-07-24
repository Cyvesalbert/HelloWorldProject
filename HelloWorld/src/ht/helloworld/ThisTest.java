package ht.helloworld;

public class ThisTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SimpleTime time = new SimpleTime(15, 30, 19);
		System.out.println(time.buildString());
	}

}

class SimpleTime{
	private int hour; // 0-23
	private int minute; // 0-59
	private int second; // 0-59
	
	
	public SimpleTime( int hour, int minute, int second ){
		this.hour = hour; // set "this" object's hour
		this.minute = minute; // set "this" object's minute
		this.second = second; // set "this" object's second
	
	 }
	
	public String buildString(){
		return String.format( "%24s: %s\n%24s: %s", "this.toUniversalString()", this.toUniversalString() , "toUniversalString()", toUniversalString());
	 }
	
	public String toUniversalString() {
		return String.format( "%02d:%02d:%02d", this.hour, this.minute, this.second);
	}
	
}
