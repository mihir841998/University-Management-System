package FDBS1;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import FDBS1.c11;

import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class student {

	static JFrame frame;
	private JTextField ID;
	private JTextField Name;
	private JTextField email;
	private JTextField p;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					student window = new student();
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
	public student() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 489, 314);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Student ID:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(29, 71, 132, 26);
		frame.getContentPane().add(lblNewLabel);
		
		ID = new JTextField();
		ID.setBounds(152, 74, 150, 22);
		frame.getContentPane().add(ID);
		ID.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Name:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(39, 107, 101, 26);
		frame.getContentPane().add(lblNewLabel_1);
		
		Name = new JTextField();
		Name.setBounds(150, 111, 152, 22);
		frame.getContentPane().add(Name);
		Name.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Email ID:");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(29, 143, 113, 26);
		frame.getContentPane().add(lblNewLabel_2);
		
		email = new JTextField();
		email.setBounds(152, 150, 150, 19);
		frame.getContentPane().add(email);
		email.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Phone No.:");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(39, 179, 101, 26);
		frame.getContentPane().add(lblNewLabel_3);
		
		p = new JTextField();
		p.setText("");
		p.setBounds(152, 183, 150, 22);
		frame.getContentPane().add(p);
		p.setColumns(10);
		
		JLabel ADD = new JLabel("");
		ADD.setHorizontalAlignment(SwingConstants.CENTER);
		ADD.setBounds(162, 24, 141, 26);
		frame.getContentPane().add(ADD);
		
		JButton btnNewButton = new JButton("BACK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			}
		});
		btnNewButton.setBounds(92, 233, 85, 21);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("ADD DATA");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(c11.line1.equals("2") || c11.line1.equals("3"))
				{
					ADD.setText("NOT AUTHORIZED TO ADD");
					 Timer t = new Timer(4000, new ActionListener() {

				            @Override
				            public void actionPerformed(ActionEvent e) {
				                ADD.setText(null);
				            }
				        });
				        t.setRepeats(false);
				        t.start();
				        ID.setText(null);
				        Name.setText(null);
				        email.setText(null);
				        p.setText(null);
				}
				if(c11.line1.equals("1") || c11.line1.equals("4"))
				{
				String Id=ID.getText();	
				String name=Name.getText();
				String e=email.getText();
				String ph=p.getText();
				
				int id=Integer.parseInt(Id);
				long p1=Integer.parseInt(ph);
				String sql = "insert into s(id,name,email,p) values("+id+",'"+name+"','"+e+"',"+p1+")";
				
				
				try {
					c11.dout.writeUTF("1#"+sql);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				ADD.setText("ADDED SUCCESSFULLY");
				 Timer t = new Timer(4000, new ActionListener() {

			            @Override
			            public void actionPerformed(ActionEvent e) {
			                ADD.setText(null);
			            }
			        });
			        t.setRepeats(false);
			        t.start();
			        ID.setText(null);
			        Name.setText(null);
			        email.setText(null);
			        p.setText(null);
			    }
			}
		});
		btnNewButton_1.setBounds(240, 233, 85, 21);
		frame.getContentPane().add(btnNewButton_1);
	}
}
