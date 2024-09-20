package ht.concurrency;

public class UnsynchronizedBuffer implements Buffer{

	private int buffer = -1; // shared by producer and consumer threads

	@Override
	public void set(int value) throws InterruptedException {
		// TODO Auto-generated method stub
		System.out.printf( "Producer writes\t%2d", value );
		buffer = value;
	}

	@Override
	public int get() throws InterruptedException {
		// TODO Auto-generated method stub
		System.out.printf( "Consumer reads\t%2d", buffer );
		return buffer;
	}

}
