package ht.concurrency;

//Buffer interface specifies methods called by Producer and Consumer.
public interface Buffer {

	// place int value into buffer
	public void set(int value) throws InterruptedException;
	
	// return int value from buffer
	public int get() throws InterruptedException;
}
