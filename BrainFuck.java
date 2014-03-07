import java.util.*;
import java.io.*;

public class BrainF { 

        //stores the tape
	public static byte[] tape = new byte[30000];
        // data pointer 
	public static int dataPointer; 
	public static int charPointer;
	
	public static void code(int[] c, int charPointer1, int dataPointer1) throws IOException { 
	dataPointer = dataPointer1;
	charPointer = charPointer1; 
	while (charPointer < c.length) { 
		
		switch((char) c[charPointer]) {
		case Token.NEXT: //increment the data pointer to point to next byte on tape
			dataPointer++;
			charPointer++;
			break;
		case Token.PREV: //decrement the data pointer to point to prev byte on tape
			dataPointer--;
			charPointer++;
			break;
		case Token.PLUS: 
			tape[dataPointer]++;
			charPointer++;
			break;
		case Token.MINUS:
			tape[dataPointer]--;
			charPointer++;
			break;
		case Token.INPUT:
			try {
				InputStreamReader input = new InputStreamReader(System.in);
				tape[dataPointer] = (byte) input.read();
				charPointer++;
			}
			catch (IOException e) {
				e.printStackTrace();
			}
			break;
		case Token.OUTPUT:
			System.out.println((char) tape[dataPointer]);
			charPointer++;
			break;
		case Token.LEFT:
  if (tape[dataPointer] == 0) { 
    int i = 1;
    while (i > 0) {
      char c2 = (char) c[++charPointer];
      if (c2 == Token.LEFT) 
        i++;
      else if (c2 == Token.RIGHT) 
        i--;    
    }
  }
  charPointer ++;
  break;
case Token.RIGHT:
  int i = 1;
  while ( i > 0 ) {
    char c2 = (char) c[--charPointer];
    if (c2 == Token.LEFT)   
      i--;
    else if (c2 == Token.RIGHT) 
      i++;
  }
  break;
	
		} 
}
		
	
	}
	//the 6 brain fuck tokens
	static class Token {
		public final static char NEXT = '>';
		public final static char PREV = '<';
		public final static char OUTPUT = '.';
		public final static char INPUT = ',';
		public final static char LEFT = '[';
		public final static char RIGHT = ']';
		public final static char MINUS = '-';
		public final static char PLUS = '+';

	}


}
