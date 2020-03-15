package FDBS1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import FDBS1.c11;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class dd {

	static JFrame frame;
	private JTextField ID;
	static JLabel ADD;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					dd window = new dd();
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
	public dd() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 408, 238);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblIdToBe = new JLabel("ID to be deleted:");
		lblIdToBe.setHorizontalAlignment(SwingConstants.CENTER);
		lblIdToBe.setBounds(51, 77, 108, 29);
		frame.getContentPane().add(lblIdToBe);
		
		ID = new JTextField();
		ID.setBounds(173, 77, 148, 29);
		frame.getContentPane().add(ID);
		ID.setColumns(10);
		
		JButton btnNewButton = new JButton("BACK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			frame.dispose();
			}
		});
		btnNewButton.setBounds(99, 134, 85, 21);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("DELETE DATA");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(c11.line1.equals("2") ||c11.line1.equals("4") )
				{
					ADD.setText("NOT AUTHORIZED TO DELETE");
					 Timer t = new Timer(4000, new ActionListener() {

				            @Override
				            public void actionPerformed(ActionEvent e) {
				                ADD.setText(null);
				            }
				        });
				        t.setRepeats(false);
				        t.start();
				       
				        ID.setText(null);
				        
				}
				
				if(c11.line1.equals("1") ||c11.line1.equals("3") )
				{
				String name=ID.getText();
				
				try {
					c11.dout.writeUTF("12#"+name);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				ADD.setText("DELETED SUCCESSFULLY");
				 Timer t = new Timer(4000, new ActionListener() {

			            @Override
			            public void actionPerformed(ActionEvent e) {
			                ADD.setText(null);
			            }
			        });
			        t.setRepeats(false);
			        t.start();
			        
			        ID.setText(null);
				}
			}
		});
		btnNewButton_1.setBounds(225, 134, 108, 21);
		frame.getContentPane().add(btnNewButton_1);
		
		ADD = new JLabel("");
		ADD.setHorizontalAlignment(SwingConstants.CENTER);
		ADD.setBounds(137, 32, 171, 21);
		frame.getContentPane().add(ADD);
	}

}
