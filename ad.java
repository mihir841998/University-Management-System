package FDBS1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ad {

	static JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ad window = new ad();
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
	public ad() {
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
		
		JButton btnNewButton = new JButton("Student");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				student window = new student();
				window.frame.setVisible(true);
				frame.dispose();
			}
		});
		btnNewButton.setBounds(125, 67, 163, 30);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Marks");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				marks window = new marks();
				window.frame.setVisible(true);
				frame.dispose();
			}
		});
		btnNewButton_1.setBounds(126, 122, 162, 30);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnIntership = new JButton("Intership");
		btnIntership.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				in window = new in();
				window.frame.setVisible(true);
				frame.dispose();
			}
		});
		btnIntership.setBounds(125, 182, 163, 30);
		frame.getContentPane().add(btnIntership);
	}
}
