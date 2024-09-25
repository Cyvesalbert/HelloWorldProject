package ht.concurrency;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.SwingWorker;

//Calculates the first n primes, displaying them as they are found.
public class PrimeCalculator extends SwingWorker<Integer, Integer>{

	private final Random generator = new Random();
	private final JTextArea intermediateJTextArea; // displays found prime
	private final JButton getPrimesJButton;
	private final JButton cancelJButton;
	private final JLabel statusJLabel; // displays status of calculation
	private final boolean[] primes; // boolean array for finding primes
	
	// constructor
	public PrimeCalculator(int max, JTextArea intermediate,JLabel status, JButton getPrimes, JButton cancel) {
		intermediateJTextArea = intermediate;
		statusJLabel = status;
		getPrimesJButton = getPrimes;
		cancelJButton = cancel;
		primes = new boolean[max];
		
		// initialize all prime array values to true
		Arrays.fill(primes, true);
	}
	
	// find all primes up to max using the sieve of eratosthenes
	public Integer doInBackground() {
		int count = 0; // the number of primes found
		
		// starting at the third value, cycle through the array and put
		// false as the value of any greater number that is a multiple
		for ( int i = 2; i < primes.length; i++ ){
			if ( isCancelled() ) // if calculation has been canceled
				return count;
			else {
				setProgress(100 * (i + 1) / primes.length);
				
				try {
					Thread.sleep(generator.nextInt(5));
				}catch(InterruptedException ex) {
					statusJLabel.setText("Worker thread interrrupted");
				}
				
				if(primes[i]) { // i is prime
					publish(i); // make i available for display in prime list
					++count;
					
					for(int j = i + i; j < primes.length; j += i)
						primes[j] = false; // i  is not prime
				}
			}
	}
		
		return count;
	}
	
	// displays published values in primes list
	protected void process(List<Integer> publishedVals) {
		for(int i = 0; i < publishedVals.size(); i++)
			intermediateJTextArea.append(publishedVals.get(i) + "\n");
	}
	
	// code to execute when doInbackground completes
	protected void done() {
		getPrimesJButton.setEnabled(true); // enable Get Primes button
		cancelJButton.setEnabled(false); // disable Cancel button
		
		int numPrimes;
		
		try {
			numPrimes = get(); // retrieve doInBackground return value
		}catch(InterruptedException ex) {
			statusJLabel.setText("Interrupted while waiting for results");
			return;
		}catch(ExecutionException ex) {
			statusJLabel.setText("Error performing computation");
			return;
		}catch(CancellationException ex) {
			statusJLabel.setText("Cancelled");
			return;
		}
		
		statusJLabel.setText("Found " + numPrimes + " primes" );
	}
}
