package FDBS1;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class marks {

	static JFrame frame;
	private JTextField ID;
	private JTextField ESE;
	private JTextField TA;
	private JTextField Total;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					marks window = new marks();
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
	public marks() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 447, 360);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel ID1 = new JLabel("Student ID:");
		ID1.setHorizontalAlignment(SwingConstants.CENTER);
		ID1.setBounds(29, 71, 132, 26);
		frame.getContentPane().add(ID1);
		
		ID = new JTextField();
		ID.setBounds(152, 74, 150, 22);
		frame.getContentPane().add(ID);
		ID.setColumns(10);
		
		JLabel MST1 = new JLabel("MST Marks:");
		MST1.setHorizontalAlignment(SwingConstants.CENTER);
		MST1.setBounds(39, 107, 101, 26);
		frame.getContentPane().add(MST1);
		
		JTextField MST = new JTextField();
		MST.setBounds(150, 111, 152, 22);
		frame.getContentPane().add(MST);
		MST.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("ESE Marks:");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(29, 143, 113, 26);
		frame.getContentPane().add(lblNewLabel_2);
		
		ESE = new JTextField();
		ESE.setBounds(152, 150, 150, 19);
		frame.getContentPane().add(ESE);
		ESE.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("TA Marks:");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(39, 179, 101, 26);
		frame.getContentPane().add(lblNewLabel_3);
		
		TA = new JTextField();
		TA.setText("");
		TA.setBounds(152, 183, 150, 22);
		frame.getContentPane().add(TA);
		TA.setColumns(10);
		
		JLabel ADD = new JLabel("Details");
		ADD.setHorizontalAlignment(SwingConstants.CENTER);
		ADD.setBounds(162, 24, 141, 26);
		frame.getContentPane().add(ADD);
		
		JButton btnNewButton = new JButton("BACK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			}
		});
		btnNewButton.setBounds(96, 269, 85, 21);
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
				        MST.setText(null);
				        ESE.setText(null);
				        TA.setText(null);
				        Total.setText(null);
				}
				if(c11.line1.equals("1") || c11.line1.equals("4"))
				{
				String Id=ID.getText();	
				String mst=MST.getText();
				String ese=ESE.getText();
				String ta=TA.getText();
				String total=Total.getText();
				int id=Integer.parseInt(Id);
				int p1=Integer.parseInt(mst);
				int p12=Integer.parseInt(ese);
				int p13=Integer.parseInt(ta);
				int p14=Integer.parseInt(total);
				String sql = "insert into marks(id,mst,ese,ta,total)values("+id+","+p1+","+p12+","+p13+","+p14+")";
				
				
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
			        MST.setText(null);
			        ESE.setText(null);
			        TA.setText(null);
			        Total.setText(null);
			    }
			}
		});
		btnNewButton_1.setBounds(248, 269, 113, 21);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblT = new JLabel("Total:");
		lblT.setHorizontalAlignment(SwingConstants.CENTER);
		lblT.setBounds(49, 215, 85, 19);
		frame.getContentPane().add(lblT);
		
		Total = new JTextField();
		Total.setBounds(152, 215, 150, 19);
		frame.getContentPane().add(Total);
		Total.setColumns(10);
	}
}
