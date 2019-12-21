
public class Port {
	private int address;
	private int netMask;
	private int port = -1;
	
	public Port(int addr, int net, int port) {
		this.address = addr;
		this.netMask = net;
		this.port = port;
	}
	
	public int getAddress()  {
		return address;
	}
	public int getnetMask()  {
		return netMask;
	}
	public int getPort()  {
		return port;
	}
	
	public String toString() {
		 return "Port " + port + ", Address " + address + ", NetMask " + netMask;
	}
}
