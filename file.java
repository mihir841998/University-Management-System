package FDBS1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import java.awt.event.ActionListener;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class file {

	static JFrame frame;
	static JTextField tf;
	private JButton btnSend;
	static FileInputStream fin;
	static JLabel ADD;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					file window = new file();
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
	public file() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 412, 260);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		tf = new JTextField();
		tf.setBounds(133, 60, 204, 33);
		frame.getContentPane().add(tf);
		tf.setColumns(10);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			}
		});
		btnBack.setBounds(122, 132, 89, 23);
		frame.getContentPane().add(btnBack);
		
		JLabel lblNewLabel = new JLabel("File Name :");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 60, 121, 33);
		frame.getContentPane().add(lblNewLabel);
		
		btnSend = new JButton("SEND");
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					if(c11.mm==0)
					{c11.dout.writeUTF("file");}
					else
					{
						c11.dout.writeUTF("file123");
					}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				String filename=tf.getText();
				
				try {
					if(c11.mm==0)
					{c11.dout.writeUTF(filename);c11.dout.flush();}
					else
					{
						c11.dout.writeUTF(filename+"#"+PCname.name.getText());c11.dout.flush();
						PC1.textArea_1.setText(PC1.textArea_1.getText().trim()+"\n"+"You sent:"+filename);
					}
					File f=new File(filename);
					 fin=new FileInputStream(f);
					

					byte b[]=new byte [1024];

					int read;
					
					while((read = fin.read(b)) != -1){
						
					    c11.dout.write(b, 0, read); 
					    c11.dout.flush(); 
					   					}
					
					
					fin.close();
				
					ADD.setText("SENT SUCCESSFULLY");
					 Timer t = new Timer(4000, new ActionListener() {

				            @Override
				            public void actionPerformed(ActionEvent e) {
				                ADD.setText(null);
				            }
				        });
				        t.setRepeats(false);
				        t.start();
				        tf.setText(null);
				       
				        
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("An error occured");
				}
				
			}
			
		});
		btnSend.setBounds(221, 132, 89, 23);
		frame.getContentPane().add(btnSend);
		
		ADD = new JLabel("");
		ADD.setHorizontalAlignment(SwingConstants.CENTER);
		ADD.setBounds(162, 22, 204, 23);
		frame.getContentPane().add(ADD);
	}
}
