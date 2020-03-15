package FDBS1;
import java.awt.EventQueue;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.StringTokenizer;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.JTable;

public class Database {

	static JFrame frame;

	private JButton adddata;
	private JButton deletedata;
	private JButton btnViewTable;
	static JScrollPane scrollPane;
	static int count=0;
	private JButton btnGrades;
	static JLabel ADD;
	static JTable table;
	/**
	 * Launch the application.
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Database window = new Database();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		  
	}

	/**
	 * Create the application.
	 */
	public Database() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 492, 404);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		
		adddata = new JButton("ADD DATA");
		adddata.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ad window = new ad();
				window.frame.setVisible(true);
			
				frame.dispose();
			}
		});
		adddata.setBounds(10, 23, 89, 23);
		frame.getContentPane().add(adddata);
		
		deletedata = new JButton("DELETE DATA");
		deletedata.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dd window = new dd();
				window.frame.setVisible(true);
				frame.dispose();
			}
		});
		deletedata.setBounds(109, 23, 123, 23);
		frame.getContentPane().add(deletedata);
		
		btnViewTable = new JButton("VIEW TABLE");
		btnViewTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				vt1 window = new vt1();
				window.frame.setVisible(true);
			}
		});
		btnViewTable.setBounds(241, 23, 121, 23);
		frame.getContentPane().add(btnViewTable);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 67, 456, 244);
		frame.getContentPane().add(scrollPane);
		
		
		
		
		JButton btnNewButton = new JButton("BACK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			}
		});
		btnNewButton.setBounds(96, 321, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		btnGrades = new JButton("Grades");
		btnGrades.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					c11.dout.writeUTF("3");
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
						
			}
		});
		btnGrades.setBounds(381, 24, 85, 21);
		frame.getContentPane().add(btnGrades);
		
		JButton btnSearch = new JButton("INFO");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(c11.line1.equals("3") ||c11.line1.equals("4") )
				{
					ADD.setText("NOT AUTHORIZED TO SELECT");
					 Timer t = new Timer(4000, new ActionListener() {

				            @Override
				            public void actionPerformed(ActionEvent e) {
				                ADD.setText(null);
				            }
				        });
				        t.setRepeats(false);
				        t.start();
				       
				      
				        
				}
				
				if(c11.line1.equals("1") ||c11.line1.equals("2") )
				{
				
				
				try {
					c11.dout.writeUTF("4");
				
				
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
			}
		});
		btnSearch.setBounds(239, 321, 123, 23);
		frame.getContentPane().add(btnSearch);
		
		ADD = new JLabel("");
		ADD.setHorizontalAlignment(SwingConstants.CENTER);
		ADD.setBounds(141, 23, 193, 25);
		frame.getContentPane().add(ADD);
		
}	
}
