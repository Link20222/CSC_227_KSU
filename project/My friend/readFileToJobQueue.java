import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class readFileToJobQueue extends Thread {
	static PCB[] arrOfProcesses = new PCB[30];
	static Queue<PCB> jobQueue = new LinkedList<>();
	static int n = 0;
	static int numberOffProcesses = 0;

	public void run() {
	    try {
	        File file = new File("\"C:\\Users\\Huawei\\Desktop\\testdata1.txt\"");
	        Scanner scan = new Scanner(file);
	        while (scan.hasNextLine()) {
	            String line = scan.nextLine();
	            String[] processInfo = line.split(", ");
	            if (processInfo.length != 3) {
	                System.out.println("Invalid file format");
	                return;
	            }
	            String jobId = processInfo[0].trim();
	            int burstTime = Integer.parseInt(processInfo[1].trim());
	            int memorySize = Integer.parseInt(processInfo[2].trim());
	            PCB p = new PCB(jobId, burstTime, memorySize);
	            arrOfProcesses[n++] = p;
	        }
	        for (int i = 0; i < n; i++) {
	            jobQueue.add(arrOfProcesses[i]);
	            numberOffProcesses++;
	        }

	    } catch (FileNotFoundException e) {
	        System.out.println("Invalid file path");
	    } catch (NumberFormatException e) {
	        System.out.println("Invalid file format");
	    } catch (ArrayIndexOutOfBoundsException e) {
	        System.out.println("Number of processes must be less than or equal to 30");
	    }
	}
}