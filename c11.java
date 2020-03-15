package FDBS1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.StringTokenizer;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class c11 {

	static JFrame frame;
	private JTextField tf;
	static Socket s;
	static DataInputStream din;
	static DataOutputStream dout;
	static FileOutputStream fos;
	private JScrollPane scrollPane;
	private JScrollPane scrollPane_1;
	 static JTextArea ta3;
	static String line1,name,result;
	static int mm;
	static JTextArea ta;
	static JTextField tf1;
	static JTextArea ta2;

	/**
	 * Launch the application.
	 * @throws IOException 
	 * @throws UnknownHostException 
	 */
	public static void main(String[] args) throws UnknownHostException, IOException {
		s=new Socket("127.0.0.1",9998);
		din = new DataInputStream(s.getInputStream());
		   dout= new DataOutputStream(s.getOutputStream());
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
					c11 window1 = new c11();
					window1.frame.setVisible(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		String line=" ";int i=0;
		do {
		result=din.readUTF();
		
		if(result.equals("us"));
		{
			Login.rr.setText("Incorrect");
			 Timer t = new Timer(4000, new ActionListener() {

		            @Override
		            public void actionPerformed(ActionEvent e) {
		                Login.rr.setText(null);
		            }
		        });
		        t.setRepeats(false);
		        t.start();
		        Login.i.setText(null);
		        Login.p.setText(null);
		}}while(!result.equals("s"));
		frame.setVisible(true);
		
			Login.frame.dispose();

		line1=din.readUTF();
		
		name=din.readUTF();
		frame.setTitle(name);
	
	
		
		   while(!line.equals("exit"))
			{
			   
			  
				line=din.readUTF();
				
				 if(line.charAt(0)=='*')
					{String p,p1;
					 p=din.readUTF();
					
						if(p.equals("student")) {
						    Object[][] rowData = {};
						    Object[] columnNames = { "ID", "Name", "Email_ID","Phone_No." };		    
						    DefaultTableModel listTableModel;
						    listTableModel = new DefaultTableModel(rowData, columnNames);
						while(true)
						{
							p1=din.readUTF();
						
							if(p1.equals("o#o"))break;
							StringTokenizer st = new StringTokenizer(p1, "#");
							String m = st.nextToken();
							String r = st.nextToken();
							String r1 = st.nextToken();
							String r2 = st.nextToken();
							listTableModel.addRow(new Object[] {m,r,r1,r2});

						}
						Database.table = new JTable(listTableModel);
						Database.table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
						Database.table.setCellEditor(null);
						Database.scrollPane.setViewportView(Database.table);
						}
						
						else if(p.equals("internships"))
						{
							 Object[][] rowData = {};
							    Object[] columnNames = { "ID", "Company", "Pay","Project" };		    
							    DefaultTableModel listTableModel;
							    listTableModel = new DefaultTableModel(rowData, columnNames);
							while(true)
							{
								p1=din.readUTF();
							
								if(p1.equals("o#o"))break;
								StringTokenizer st = new StringTokenizer(p1, "#");
								String m = st.nextToken();
								String r = st.nextToken();
								String r1 = st.nextToken();
								String r2 = st.nextToken();
								listTableModel.addRow(new Object[] {m,r,r1,r2});

							}
							Database.table = new JTable(listTableModel);
							Database.table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
							Database.table.setCellEditor(null);
							Database.scrollPane.setViewportView(Database.table);
						}
						else if(p.equals("marks")) {
							 Object[][] rowData = {};
							    Object[] columnNames = { "ID", "MST", "ESE","TA","Total","Grades" };		    
							    DefaultTableModel listTableModel;
							    listTableModel = new DefaultTableModel(rowData, columnNames);		
							while(true)
							{
								p1=din.readUTF();
								
								if(p1.equals("o#o"))break;
								StringTokenizer st = new StringTokenizer(p1, "#");
								String m = st.nextToken();
								String r = st.nextToken();
								String r1 = st.nextToken();
								String r2 = st.nextToken();
								String r3 = st.nextToken();
								String r4 = st.nextToken();
								listTableModel.addRow(new Object[] {m,r,r1,r2,r3,r4});
							
								
							}
							Database.table = new JTable(listTableModel);
							Database.table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
							Database.table.setCellEditor(null);
							Database.scrollPane.setViewportView(Database.table);	
						}
						else if(p.equals("grade")) {
							 Object[][] rowData = {};
							    Object[] columnNames = { "ID","Grades" };		    
							    DefaultTableModel listTableModel;
							    listTableModel = new DefaultTableModel(rowData, columnNames);
							while(true)
							{
								p1=din.readUTF();
								
								if(p1.equals("o#o"))break;
								StringTokenizer st = new StringTokenizer(p1, "#");
								String m = st.nextToken();
								String r = st.nextToken();
								listTableModel.addRow(new Object[] {m,r});					
							}
							Database.table = new JTable(listTableModel);
							Database.table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
							Database.table.setCellEditor(null);
							Database.scrollPane.setViewportView(Database.table);		
						}
						
						else if(p.equals("info")) {
							Object[][] rowData = {};
						    Object[] columnNames = { "ID","Name","Email_ID","Phone_No","MST","ESE","TA","Total","Grades","Company","Pay","Project"};		    
						    DefaultTableModel listTableModel;
						    listTableModel = new DefaultTableModel(rowData, columnNames);
							while(true)
							{
								p1=din.readUTF();
							
								if(p1.equals("o#o"))break;
								StringTokenizer st = new StringTokenizer(p1, "#");
								String m = st.nextToken();
								String r = st.nextToken();
								String r1 = st.nextToken();
								String r2= st.nextToken();
								String r3= st.nextToken();
								String r4= st.nextToken();
								String r5 = st.nextToken();
								String r6 = st.nextToken();
								String r7 = st.nextToken();
								String r8 = st.nextToken();
								String r9 = st.nextToken();
								String r10 = st.nextToken();
								listTableModel.addRow(new Object[] {m,r,r1,r2,r3,r4,r5,r6,r7,r8,r9,r10});
								
							
								
							}
							Database.table = new JTable(listTableModel);
							Database.table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
							Database.table.setCellEditor(null);
							Database.scrollPane.setViewportView(Database.table);
							
						}
						else {}
						
				}
				 else if(line.charAt(0)=='&')
				 {
					 String h=din.readUTF();
					 StringTokenizer st = new StringTokenizer(h, "#");
						String m = st.nextToken();
						String r = st.nextToken();
						String r1 = st.nextToken();
						if(r1.equals("1"))
						{ ta.setText(ta.getText().trim()+"\n"+m+" send you "+r);}
						else
						{
							PC1.textArea.setText(PC1.textArea.getText().trim()+"\n"+m+" send you "+r);
						}
					 long bytesRead;byte b[]=new byte [1024];String j;
					 FileOutputStream fos=new FileOutputStream(new File(name+i+r),true);
						do
						{
						bytesRead =  din.read(b, 0, b.length);
						fos.write(b,0,b.length);
						}while(!(bytesRead<1024));
						fos.close();i++;
					
				 }
				else if(line.charAt(1)=='@')
				{
					
					StringTokenizer st = new StringTokenizer(line, "@");
					String MsgToSend = st.nextToken();
					String recipient = st.nextToken();
					System.out.println(recipient);
					ta3.setText(ta3.getText().trim()+"\n"+recipient);
				}
				else if(line.equals("5#"))
				{
					String z=din.readUTF();
					PC1.textArea.setText(PC1.textArea.getText().trim()+"\n"+z);
				}
				else if(line.equals("55@#"))
				{
					String z=din.readUTF();
					ta2.setText(ta2.getText().trim()+"\n"+z);
					
				}
				
				else {
					ta.setText(ta.getText().trim()+"\n"+line);
				}
				
			}
	}

	/**
	 * Create the application.
	 */
	public c11() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 579, 452);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 42, 345, 299);
		frame.getContentPane().add(scrollPane);
		
		ta = new JTextArea();
		scrollPane.setViewportView(ta);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(365, 42, 189, 101);
		frame.getContentPane().add(scrollPane_1);
		
		 ta3 = new JTextArea();
		scrollPane_1.setViewportView(ta3);
		
		JButton logout = new JButton("Logout");
		logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String line="logout";
				try {
					dout.writeUTF(line);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					dout.close();
					din.close();
					s.close();
					System.out.println("client closed");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
			}
		});
		logout.setBounds(10, 11, 102, 26);
		frame.getContentPane().add(logout);
		
		JButton btnNewButton_1 = new JButton("Active Users");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ta3.setText(null);
				String line="$$$$";
				try {
					dout.writeUTF(line);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBounds(122, 11, 129, 26);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Database");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Database window = new Database();
				window.frame.setVisible(true);
			}
		});
		btnNewButton_2.setBounds(264, 12, 110, 24);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("PC");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PCname window = new PCname();
				window.frame.setVisible(true);
			}
		});
		btnNewButton_3.setBounds(384, 12, 91, 24);
		frame.getContentPane().add(btnNewButton_3);
		
		tf = new JTextField();
		tf.setBounds(10, 351, 345, 54);
		frame.getContentPane().add(tf);
		tf.setColumns(10);
		
		JButton btnNewButton_4 = new JButton("Share");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mm=0;
				file window = new file();
				window.frame.setVisible(true);
			}
		});
		btnNewButton_4.setBounds(457, 384, 85, 21);
		frame.getContentPane().add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Send");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String line=" ";
				line=tf.getText().trim();
				try {
					dout.writeUTF(line);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				tf.setText(null);
				
			}
		});
		btnNewButton_5.setBounds(365, 384, 85, 21);
		frame.getContentPane().add(btnNewButton_5);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(365, 266, 189, 75);
		frame.getContentPane().add(scrollPane_2);
		
		tf1 = new JTextField();
		scrollPane_2.setViewportView(tf1);
		tf1.setColumns(10);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(365, 151, 189, 82);
		frame.getContentPane().add(scrollPane_3);
		
		ta2 = new JTextArea();
		scrollPane_3.setViewportView(ta2);
		
		JLabel lblNewLabel = new JLabel("Annoucement:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(393, 243, 117, 21);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnPost = new JButton("Post");
		btnPost.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String line123=" ";
				line123=tf1.getText().trim();
				try {
					dout.writeUTF("55@#");
					dout.writeUTF(line123);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				tf1.setText(null);
				
			}
		});
		btnPost.setBounds(412, 353, 85, 21);
		frame.getContentPane().add(btnPost);
	}
}
