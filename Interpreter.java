import java.io.*;
import java.util.*;

public class Interpreter { 

public static void main (String [] args) throws IOException {
	InputStreamReader input = new InputStreamReader(new FileInputStream("file.txt"));
	BufferedReader bufferRead = new BufferedReader(input);
	int c;
	int [] data = new int[30000];
	int i = 0;
	while ((c = bufferRead.read()) != -1) {
		data[i]=c;
	
		++i;
	}
	BrainF.code(data,0,0); 
	

}

}
