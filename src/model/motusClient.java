package netClient;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class motusClient implements Runnable {
	
	private BufferedReader in ;
	private PrintWriter out;
	private Socket socket;
	private Thread thread;
	private String server;
	
	Scanner sc;
	
	public motusClient(int port) throws IOException {
		connect(port, "localhost");
		sc = new Scanner(System.in);
		System.out.println("Veuillez entrez votre pseudo ");
		thread = new Thread(this);
		thread.start();
	}
	
	public void connect(int port, String serverIp) throws IOException{
		
		Socket socket = new Socket(serverIp, port);
		
		BufferedReader in = new BufferedReader(
		                       new InputStreamReader(
		                    		   socket.getInputStream()));
		PrintWriter out = new PrintWriter(
		                     new BufferedWriter(
		                    		 new OutputStreamWriter(
		                    				 socket.getOutputStream())),true);
		
		String result = in.readLine();
		
		
		
	}
	
	public void closeConnection() throws IOException {
		in.close();
		out.close();
		socket.close();
	}
	
	
	public static void main(String[] args) {
		try {
			motusClient client = new motusClient(8000);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	public String waitForPropo() throws IOException {
		String str = in.readLine();
		return  str;	
	}
	
	@Override
	public void run() {
		while(!Thread.interrupted()) {
			String str = "";
			try {
				str = waitForPropo();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
}