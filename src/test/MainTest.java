package test;

import entity.Main;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class MainTest {

    private final InputStream sysInBackup = System.in;

    @Before
    public void setUp() {
        // Backup System.in to restore it after the test
        System.setIn(sysInBackup);
    }

    @Test
    public void testMain() {
        // Test input file content
        String input = "5 5\n1 2 N\nGAGAGAGAA\n3 3 E\nAADAADADDA";
        String expectedOutput = "1 3 N\n5 1 E";

        // Simulate input from a file
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // Call main method and capture output
        String output = captureOutput(() -> {
			try {
				Main.main(null);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});

        assertEquals(expectedOutput.trim(), output.trim());
    }

    public String captureOutput(Runnable runnable) {
    	// Capture System.out.println output
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Run the method
        runnable.run();

        // Reset System.out
        System.setOut(System.out);

        // Get the captured output and remove empty lines
        String output = outContent.toString().trim();
        output = output.replaceAll("(?m)^[ \t]*\r?\n", "");

        return output;

    }
    
    
	/*
	 * public String captureOutput(Runnable runnable) { // Capture
	 * System.out.println output ByteArrayOutputStream outContent = new
	 * ByteArrayOutputStream(); System.setOut(new PrintStream(outContent));
	 * 
	 * // Run the method runnable.run();
	 * 
	 * // Reset System.out System.setOut(System.out);
	 * 
	 * return outContent.toString().trim(); }
	 */
}

