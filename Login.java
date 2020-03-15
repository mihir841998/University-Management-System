package FDBS1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class Login {

	static	JFrame frame;
	static JTextField i;
	static JLabel rr;
	static JPasswordField p;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
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
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Login");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		i = new JTextField();
		i.setBounds(148, 66, 209, 37);
		frame.getContentPane().add(i);
		i.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("ID:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(42, 69, 96, 30);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(31, 124, 96, 30);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					c11.dout.writeUTF("login");
					String h=i.getText();
					String g=p.getText();
					c11.dout.writeUTF(h);
					c11.dout.writeUTF(g);
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		btnNewButton.setBounds(255, 194, 102, 30);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Register");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				register window = new register();
				window.frame.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(104, 194, 108, 30);
		frame.getContentPane().add(btnNewButton_1);
		
		 rr = new JLabel("");
		rr.setHorizontalAlignment(SwingConstants.CENTER);
		rr.setBounds(132, 28, 233, 30);
		frame.getContentPane().add(rr);
		
		p = new JPasswordField();
		p.setBounds(148, 121, 207, 37);
		frame.getContentPane().add(p);
	}
}
