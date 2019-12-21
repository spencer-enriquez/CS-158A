import java.io.*;
import java.util.*;

public class NetFwd {
	private ArrayList<Port> ports = new ArrayList<Port>();
	
	// Decides which Port to forward packet to
	public String forwardTo(String ip) {
		int convert = toAddress(ip);
		for (int i = 0; i < ports.size(); i++) {
			if ((convert & ports.get(i).getnetMask()) == ports.get(i).getAddress())
				return "Forward to Port " + ports.get(i).getPort();
		}
		return "Default: No matching Address found.";
	}
	
	// Convert x.x.x.x to integer
	public int toAddress(String addr) {
		String[] temp = addr.split("\\.");
		int result = 0;
		int exp = 0;
		for (int i = temp.length - 1; i >= 0; i--) {
			result += Integer.parseInt(temp[i].trim())  * ((int) (Math.pow(256, exp)));
			//System.out.print(result[i] + " ");
			exp++;
		}
		return result;
	}
	
	public void simulate(String fileName) throws IOException {
		File file = new File(fileName);
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		String entry = br.readLine();
		while (entry != null) {
			System.out.println(entry);
			String[] temp = entry.split(",");
			ports.add(new Port(toAddress(temp[0]), toAddress(temp[1]), Integer.parseInt(temp[2].trim())));
			entry = br.readLine();
		}
		br.close();
		fr.close();
		
		//for (int i = 0; i < ports.size(); i++) {
		//	System.out.println(ports.get(i).toString());
		//}
		
		Scanner in  = new Scanner(System.in);
		System.out.print("Please input an IPv4 Address to forward: ");
		String input = in.nextLine();
		while (!input.equals("quit")) {
			//System.out.println("You entered " + input);
			System.out.println(forwardTo(input));
			System.out.print("\nPlease input an IPv4 Address to forward: ");
			input = in.nextLine();
		}
		in.close();
	}

	public static void main(String[] args) throws IOException {
		NetFwd test = new NetFwd();
		test.simulate("C:\\Users\\Spencer Enriquez\\Documents\\CS 158A\\hw3\\src\\Input");
		//System.out.println(test.toAddress("255.128.0.0"));
	}
	
	/*
	 * Sample Output:
	 * 
	 * 12.128.0.0, 255.128.0.0, 1
		15.0.0.0, 255.0.0.0, 2
		17.25.128.0, 255.255.255.0, 3
		200.10.0.0, 255.255.0.0, 4
		Please input an IPv4 Address to forward: 12.128.15.19
		Forward to Port 1
		
		Please input an IPv4 Address to forward: 15.255.255.255
		Forward to Port 2
		
		Please input an IPv4 Address to forward: 17.25.128.33
		Forward to Port 3
		
		Please input an IPv4 Address to forward: 200.10.159.64
		Forward to Port 4
		
		Please input an IPv4 Address to forward: 27.169.255.4
		Default: No matching Address found.
		
		Please input an IPv4 Address to forward: 
	 */

}
