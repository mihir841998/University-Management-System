package FDBS1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class PC1 {

	static JFrame frame;
	private JTextField m;
	static JTextArea textArea;
	static JTextArea textArea_1;
	static String g=PCname.name.getText();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					PC1 window = new PC1();
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
	public PC1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame(g);
		frame.setBounds(100, 100, 472, 334);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 198, 165);
		frame.getContentPane().add(scrollPane);
		
		 textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(218, 10, 208, 165);
		frame.getContentPane().add(scrollPane_1);
		
		 textArea_1 = new JTextArea();
		scrollPane_1.setViewportView(textArea_1);
		
		m = new JTextField();
		m.setBounds(10, 193, 319, 58);
		frame.getContentPane().add(m);
		m.setColumns(10);
		
		JButton btnNewButton = new JButton("Share");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				c11.mm=1;
				file window = new file();
				window.frame.setVisible(true);
			}
		});
		btnNewButton.setBounds(339, 193, 85, 21);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Send");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					c11.dout.writeUTF("5#");
					c11.dout.writeUTF(m.getText()+"#"+PCname.name.getText());
					textArea_1.setText(textArea_1.getText().trim()+"\n"+"You:"+m.getText());
					m.setText(null);
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBounds(339, 229, 85, 21);
		frame.getContentPane().add(btnNewButton_1);
	}
}
