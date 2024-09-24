package ht.concurrency;

import java.util.concurrent.ExecutionException;

import javax.swing.JLabel;
import javax.swing.SwingWorker;

//SwingWorker subclass for calculating Fibonacci numbers
// in a background thread.
public class BackgroundCalculator extends SwingWorker<Long, Object>{
	
	private final int n; // fibonacci number to calculate
	private final JLabel resultJLabel; // JLabel to display the result
	
	// constructor
	public BackgroundCalculator(int number, JLabel label) {
		n = number;
		resultJLabel = label;
	}
	
	// long running code to be run in a worker thread
	public Long doInBackground() {
		long nthFib;
		return nthFib = fibonacci(n);
	}
	
	// code to run on the event dispatch thread when doInBackGround and return
	protected void done() {
		try {
			// get the result of doInBackground and display it
			resultJLabel.setText(get().toString());
		}catch(InterruptedException ex) {
			resultJLabel.setText("Interrupted while waiting for results");
		}catch(ExecutionException ex) {
			resultJLabel.setText("Error encountered while performing calculation");
		}
	}
	
	// recursive method fibonacci; calculates nth fibonacci number
	public long fibonacci(long number) {
		if(number == 0 || number == 1)
			return number;
		else
			return fibonacci(number - 1) + fibonacci(number - 2);
	}

}
