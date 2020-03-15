package FDBS1;
import java.io.*;
import java.util.*;

import com.mysql.cj.api.jdbc.Statement;

import java.net.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

// Server class

 public class s11 
{

	// Vector to store active clients
	static Vector<ClientHandler> ar = new Vector<>();
	
	// counter for clients
	static int i = 0;

	public static void main(String[] args) throws IOException 
	{
        // server is listening on port 1234
		ServerSocket ss = new ServerSocket(9998);
		
		Socket s;
		
		// running infinite loop for getting
		// client request
		while (true) 
		{
			// Accept the incoming request
			s = ss.accept();

			System.out.println("New client request received : " + s);
			
			// obtain input and output streams
			DataInputStream dis = new DataInputStream(s.getInputStream());
			DataOutputStream dos = new DataOutputStream(s.getOutputStream());
			
			System.out.println("Creating a new handler for this client...");


			// Create a new handler object for handling this request.


			// Create a new handler object for handling this request.
			ClientHandler mtch = new ClientHandler(s,dis, dos);

			// Create a new Thread with this object.
			Thread t = new Thread(mtch);
			
			System.out.println("Adding this client to active client list");

			// add this client to active clients list
			ar.add(mtch);

			// start the thread.
			t.start();

			// increment i for new client.
			// i is used for naming only, and can be replaced
			// by any naming scheme
			i++;

		}
	}
}

// ClientHandler class
class ClientHandler implements Runnable 
{
	Scanner scn = new Scanner(System.in);
	private String name;
	final DataInputStream dis;
	final DataOutputStream dos;
	Socket s;
	boolean isloggedin;
	String p;int i=0;
	
	// constructor
	public ClientHandler(Socket s,
							DataInputStream dis, DataOutputStream dos) {
		this.dis = dis;
		this.dos = dos;
		this.s = s;
		this.isloggedin=true;

	}

	@Override
	public void run() {
		 String url="jdbc:mysql://127.0.0.1:3306/mihir";
			String uname="mihir";
			String pass="mihir";
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Connection con = null;
			try {
				con = DriverManager.getConnection(url,uname,pass);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		

		String received;
		while (true) 
		{
			
			
			try
			{
				
				// receive the string
				received = dis.readUTF();
				
				System.out.println(received);
				
				if(received.equals("logout")){
					this.isloggedin=false;
					this.s.close();
					this.dis.close();
					this.dos.close();
					s11.ar.remove(this);
					try {
						con.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				}
				else if(received.equals("login"))
				{
					String b=dis.readUTF();String name1;
					String v=dis.readUTF();int i12=0;
					Statement st;
					try {
						st = (Statement) con.createStatement();
						ResultSet u=st.executeQuery("select name from login where id='"+b+"' AND pass='"+v+"'");
						while(u.next())
						{
							i12=1;
							System.out.println("m");
							 name1=u.getString("name");
							 this.name=name1;
							 if(b.charAt(0)=='1')
							 {
								 this.p="1";
								 this.dos.writeUTF("s");
								this.dos.writeUTF(this.p);
								this.dos.writeUTF(this.name); 
								continue;
							 }
							 else
							 {
								 this.p="2";
								 this.dos.writeUTF("s");
								this.dos.writeUTF(this.p);
								this.dos.writeUTF(this.name);
								continue;
							 }
							 
							
						}
						if(i12==0)
						 this.dos.writeUTF("us");
						
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					
				}
				
				else if(received.equals("register"))
				{
					String id=dis.readUTF();
					String password=dis.readUTF();
					String name=dis.readUTF();
					int i=Integer.parseInt(id);
					Statement st;
					try {
						st = (Statement) con.createStatement();int u;
						 u=st.executeUpdate("insert into login values("+i+",'"+password+"','"+name+"')");
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				else if(received.equals("file"))
				{
					String m=dis.readUTF();

					long bytesRead;byte b[]=new byte [1024];String j;
					FileOutputStream fos=new FileOutputStream(new File("server"+i+ m),true);
					do
					{
					bytesRead =  dis.read(b, 0, b.length);
					fos.write(b,0,b.length);
					}while(!(bytesRead<1024));
					fos.close();
		             for (ClientHandler mc : s11.ar) 
						{
							// if the recipient is found, write on its
							// output stream
							if (mc.isloggedin==true) 
							{
								if(mc.name==this.name)
								{
									mc.dos.writeUTF("You send:"+m);
								}
								else {
								mc.dos.writeUTF("&");
								
								mc.dos.writeUTF(this.name+"#"+m+"#1");
								
								File f=new File("server"+i+m);
								FileInputStream fin=new FileInputStream(f);
								byte b1[]=new byte [1024];
								int read;
								while((read = fin.read(b1)) != -1){
								   mc.dos.write(b1, 0, read); 
								    mc.dos.flush(); 
								}
								fin.close();
								}
							}
						
						}
		             i++;
				}
				
				else if(received.equals("file123"))
				{
					String m=dis.readUTF();
					StringTokenizer s = new StringTokenizer(m,"#");
		             String MsgToSend = s.nextToken();			             
		             String recipient = s.nextToken();
		             
		             for (ClientHandler mc : s11.ar) 
						{
							// if the recipient is found, write on its
							// output stream
							if (mc.name.equals(recipient) && mc.isloggedin==true) 
							{
								
								long bytesRead;byte b[]=new byte [1024];String j;
								FileOutputStream fos=new FileOutputStream(new File("server"+i+ MsgToSend),true);
								do
								{
								bytesRead =  dis.read(b, 0, b.length);
								fos.write(b,0,b.length);
								}while(!(bytesRead<1024));
								fos.close();
								mc.dos.writeUTF("&");
								mc.dos.writeUTF(this.name+"#"+MsgToSend+"#2");
								File f=new File("server"+i+MsgToSend);
								FileInputStream fin=new FileInputStream(f);
								byte b1[]=new byte [1024];
								int read;
								while((read = fin.read(b1)) != -1){
								   mc.dos.write(b1, 0, read); 
								    mc.dos.flush(); 
								}
								fin.close();i++;
								break;
							}
						
						}
		             
				}
				
				else if(received.equals("$$$$"))
				{
					for (ClientHandler mc : s11.ar) 
					{
						// if the recipient is found, write on its
						// output stream
						if ( mc.isloggedin==true && mc.name!=this.name) 
						{
							this.dos.writeUTF("1@"+mc.name);
						}
					}
				}
				 
				else if((received.charAt(0))=='1')
				 {
					if((received.charAt(1))=='2')
					{
						 StringTokenizer s = new StringTokenizer(received, "#");
			             String MsgToSend = s.nextToken();			             
			             String recipient = s.nextToken();
			             int i=Integer.parseInt(recipient);
			             try {
							Statement st=(Statement) con.createStatement();int u;
							 u=st.executeUpdate("delete from s where id='"+i+"'");
							 u=st.executeUpdate("delete from marks where id='"+i+"'");
							 u=st.executeUpdate("delete from internships where id='"+i+"'");
							
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					
					else { StringTokenizer s = new StringTokenizer(received, "#");
			             String MsgToSend = s.nextToken();			             
			             String recipient = s.nextToken();
			             
		            	 try {
							Statement st=(Statement) con.createStatement();
							int u=st.executeUpdate(recipient);
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}}
			             
				 }
				else if((received.charAt(0))=='2')
				{
					 
					  StringTokenizer s = new StringTokenizer(received, "#");
			             String M = s.nextToken();			             
			             String recipient = s.nextToken();
			             String z=s.nextToken();
			             if(z.equals("student")) {
			             try {
								Statement st=(Statement) con.createStatement();
								ResultSet u=st.executeQuery(recipient);
								
								 this.dos.writeUTF("*");
								   this.dos.writeUTF("student");
								 while(u.next()){
									 
							         //Retrieve by column name
							         int id  = u.getInt("id");
							         String name = u.getString("name");
							         String e = u.getString("email");
							         long p  = u.getLong("p");
							         
							         this.dos.writeUTF(id+"#"+name+"#"+e+"#"+p);
							      
							         //Display values
							      
							      }
								 this.dos.writeUTF("o#o");
								
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
			             }
			             else if(z.equals("marks")) {
				             try {
									Statement st=(Statement) con.createStatement();
									ResultSet u=st.executeQuery(recipient);
									 this.dos.writeUTF("*");
									 this.dos.writeUTF("marks");
									 while(u.next()){
								         //Retrieve by column name
								         int id  = u.getInt("id");
								         int id1  = u.getInt("mst");
								         int id2  = u.getInt("ese");
								         int id3  = u.getInt("ta");
								         int id4  = u.getInt("total");
								         String g = u.getString("grade");
								         this.dos.writeUTF(id+"#"+id1+"#"+id2+"#"+id3+"#"+id4+"#"+g);
								       
								         //Display values
								      
								      }
									 this.dos.writeUTF("o#o");
									
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
				             }
			             else  if(z.equals("internships")) {
				             try {
									Statement st=(Statement) con.createStatement();
									ResultSet u=st.executeQuery(recipient);
									 this.dos.writeUTF("*");
									 this.dos.writeUTF("internships");
									 while(u.next()){
								         //Retrieve by column name
								         int id  = u.getInt("id");
								         String g = u.getString("company");
								         int id1  = u.getInt("pay");
								 
								         String g1 = u.getString("project");
								         this.dos.writeUTF(id+"#"+g+"#"+id1+"#"+g1);
								        
								         //Display values
								      
								      }
									 this.dos.writeUTF("o#o");
									
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
				             }
			             
			             else {}
				}
				else if((received.charAt(0))=='3')
				{
					Statement st;
					try {
						st = (Statement) con.createStatement();
						int u1=st.executeUpdate("update marks set grade=(case when(total>90) then 'A' when(total>80) then 'B' when(total>70) then 'C' when(total>60) then 'D'  else 'F' end)");
						ResultSet u=st.executeQuery("select id,grade from marks");
						this.dos.writeUTF("*");
						 this.dos.writeUTF("grade");
						 while(u.next()){
					         //Retrieve by column name
					         int id  = u.getInt("id");
					         String g = u.getString("grade");
					         this.dos.writeUTF(id+"#"+g);
					      
					         //Display values
					      
					      }
						 this.dos.writeUTF("o#o");
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				else if((received.charAt(0))=='4')
				{
					Statement st;
					try {
						st = (Statement) con.createStatement();
						
						ResultSet u=st.executeQuery(" select *from s natural join marks natural join internships");
						this.dos.writeUTF("*");
						 this.dos.writeUTF("info");
						 while(u.next()){
					         //Retrieve by column name
					         int id  = u.getInt("id");
					         String g = u.getString("name");
					         String g1 = u.getString("email");
					         long id1  = u.getLong("p");
					         int id2  = u.getInt("mst");
					         int id3  = u.getInt("ese");
					         int id4  = u.getInt("ta");
					         int id5  = u.getInt("total");
					         String g2 = u.getString("grade");
					         String g3 = u.getString("company");
					         int id6  = u.getInt("pay");
					         String g4 = u.getString("project");
					         this.dos.writeUTF(id+"#"+g+"#"+g1+"#"+id1+"#"+id2+"#"+id3+"#"+id4+"#"+id5+"#"+g2+"#"+g3+"#"+id6+"#"+g4);
					      
					         //Display values
					      
					      }
						 this.dos.writeUTF("o#o");
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				
				else if(received.equals("5#"))
				{
					String h=dis.readUTF();
					// break the string into message and recipient part
					StringTokenizer st = new StringTokenizer(h, "#");
					String MsgToSend = st.nextToken();
					String recipient = st.nextToken();

					// search for the recipient in the connected devices list.
					// ar is the vector storing client of active users
					for (ClientHandler mc : s11.ar) 
					{
						// if the recipient is found, write on its
						// output stream
						if (mc.name.equals(recipient) && mc.isloggedin==true) 
						{
							mc.dos.writeUTF("5#");
							mc.dos.writeUTF("->"+MsgToSend);
							break;
						}
					
					}
				}
				else if(received.equals("55@#"))
				{
					
					String h=dis.readUTF();
					
					for (ClientHandler mc : s11.ar) 
					{
						
						// if the recipient is found, write on its
						// output stream
						if (mc.isloggedin==true) 
						{
							if(mc.name==this.name)
							{
								mc.dos.writeUTF("55@#");
								mc.dos.writeUTF("You : "+h);
							}
							else {
								mc.dos.writeUTF("55@#");
							mc.dos.writeUTF(this.name+" : "+h);
							}
						}
					
					}
				}
					
				
				 else
				 {


				// search for the recipient in the connected devices list.
				// ar is the vector storing client of active users
				for (ClientHandler mc : s11.ar) 
				{
					// if the recipient is found, write on its
					// output stream
					if (mc.isloggedin==true) 
					{
						if(mc.name==this.name)
						{
							mc.dos.writeUTF("You : "+received);
						}
						else {
						mc.dos.writeUTF(this.name+" : "+received);
						}
					}
				
				}}
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			
			
		}
		try
		{
			// closing resources
			this.dis.close();
			this.dos.close();
			
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}