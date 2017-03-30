

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
		StringTokenizer tk = new StringTokenizer(ligne, "\t");;	
		
		String arg1 = tk.nextToken();
		String arg2 = tk.nextToken();
		
		switch (arg1){
		case "ALL" :
			level = ALL;
			break;
		case "DEBUG" :
			level = DEBUG;
			break;
		case "INFO" :
			level = INFO;
			break;
		case "IMPORTANT" :
			level = IMPORTANT;
			break;
		case "OFF" :
			level = OFF;
			break;
			default :
				System.err.println("Erreur : argument n°1 invalide");
		}
		
		switch (arg2){
		case "System.err" :
			flotSortie = new PrintWriter(System.err);
			break;
		case "System.out" :
			flotSortie = new PrintWriter(System.out);
			break;
		default :
			flotSortie = new PrintWriter(arg2);
		}
	}
	
	public static void log(int level, String message){
		if (level >= Logger.level){
			flotSortie.println(message);
			flotSortie.flush();
	
		} 
	}
}
