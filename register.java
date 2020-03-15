package FDBS1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class register {

	static JFrame frame;
	private JTextField name1;
	private JTextField id1;
	private JTextField pass1;
	private JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					register window = new register();
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
	public register() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		name1 = new JTextField();
		name1.setBounds(151, 29, 222, 30);
		frame.getContentPane().add(name1);
		name1.setColumns(10);
		
		id1 = new JTextField();
		id1.setBounds(151, 81, 222, 30);
		frame.getContentPane().add(id1);
		id1.setColumns(10);
		
		pass1 = new JTextField();
		pass1.setBounds(151, 134, 222, 30);
		frame.getContentPane().add(pass1);
		pass1.setColumns(10);
		
		JButton btnNewButton = new JButton("Register");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					c11.dout.writeUTF("register");
					String name=name1.getText();
					String id=id1.getText();
					String pass=pass1.getText();
					c11.dout.writeUTF(id);
					c11.dout.writeUTF(pass);
					c11.dout.writeUTF(name);
					frame.dispose();
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(257, 200, 116, 30);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Name:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(35, 32, 106, 22);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ID:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(35, 81, 100, 22);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(35, 142, 106, 22);
		frame.getContentPane().add(lblNewLabel_2);
		
		btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			}
		});
		btnNewButton_1.setBounds(120, 200, 106, 30);
		frame.getContentPane().add(btnNewButton_1);
	}
}
