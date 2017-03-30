

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Logger {
	// Attributes
	public final static int ALL = 0;
	public final static int DEBUG = 100;
	public final static int INFO = 500;
	public final static int IMPORTANT = 900;
	public final static int OFF = Integer.MAX_VALUE;
	
	private static int level;
	private static PrintWriter flotSortie;

	public Logger(){
		level = DEBUG;
		flotSortie = new PrintWriter(System.err);
	}
	
	public Logger(int level, PrintWriter pw){
		Logger.level = level;
		flotSortie = pw;
	}
	
	public Logger(String name) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader(name));
		String ligne = br.readLine();
		StringTokenizer tk = new StringTokenizer(ligne, " ");;	
		
		level = Integer.valueOf(tk.nextToken());
		flotSortie = new PrintWriter(tk.nextToken());
	}
	
	public static void log(int level, String message){
		if (level >= Logger.level){
			flotSortie.println(message);
			flotSortie.flush();
	
		} 
	}
}
