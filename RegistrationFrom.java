import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class RegistrationFrom extends JFrame {

	private JPanel contentPane;
	private JTextField txtname;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField txtage;
	private JTextField txtmobile;
	private JTextField txtemail;
	private JTextField txtuser;
	private JPasswordField txtpassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistrationFrom frame = new RegistrationFrom();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public RegistrationFrom() {
		setForeground(Color.WHITE);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\kavin\\Downloads\\_MG_0872.jpg"));
		setTitle("Registration From");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 462);
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(10, 28, 71, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Address");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(10, 61, 71, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Gender");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(10, 99, 71, 13);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Age");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3.setBounds(10, 138, 71, 13);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Mobile");
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_4.setBounds(10, 186, 71, 13);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Email");
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_5.setBounds(10, 235, 71, 13);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("User");
		lblNewLabel_6.setForeground(Color.WHITE);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_6.setBounds(10, 279, 71, 13);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Password");
		lblNewLabel_7.setForeground(Color.WHITE);
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_7.setBounds(10, 335, 71, 13);
		contentPane.add(lblNewLabel_7);
		
		txtname = new JTextField();
		txtname.setForeground(Color.BLACK);
		txtname.setBounds(91, 26, 96, 19);
		contentPane.add(txtname);
		txtname.setColumns(10);
		
		JTextArea txtadress = new JTextArea();
		txtadress.setForeground(Color.BLACK);
		txtadress.setBounds(91, 56, 249, 22);
		contentPane.add(txtadress);
		
		JRadioButton female = new JRadioButton("Female");
		female.setBackground(Color.BLACK);
		female.setForeground(Color.WHITE);
		buttonGroup.add(female);
		female.setBounds(93, 96, 103, 21);
		contentPane.add(female);
		
		JRadioButton male = new JRadioButton("Male");
		male.setBackground(Color.BLACK);
		male.setForeground(Color.WHITE);
		buttonGroup.add(male);
		male.setBounds(211, 96, 103, 21);
		contentPane.add(male);
		
		txtage = new JTextField();
		txtage.setForeground(Color.BLACK);
		txtage.setBounds(93, 136, 144, 19);
		contentPane.add(txtage);
		txtage.setColumns(10);
		
		txtmobile = new JTextField();
		txtmobile.setForeground(Color.BLACK);
		txtmobile.setBounds(93, 184, 144, 19);
		contentPane.add(txtmobile);
		txtmobile.setColumns(10);
		
		txtemail = new JTextField();
		txtemail.setForeground(Color.BLACK);
		txtemail.setBounds(91, 233, 146, 19);
		contentPane.add(txtemail);
		txtemail.setColumns(10);
		
		txtuser = new JTextField();
		txtuser.setForeground(Color.BLACK);
		txtuser.setBounds(91, 277, 146, 19);
		contentPane.add(txtuser);
		txtuser.setColumns(10);
		
		JButton btnNewButton = new JButton("Validate");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/users","root","kavinkumar23");
				String query = "insert into registration values(?,?,?,?,?,?,?,?)";
				PreparedStatement ps=con.prepareStatement(query);
				ps.setString(1,txtname.getText());
				ps.setString(2,txtadress.getText());
				if(male.isSelected()) {
					ps.setString(3, male.getText());
				}
				else {
					ps.setString(3, female.getText());
				}
				ps.setInt(4, Integer.parseInt(txtage.getText()));
				ps.setInt(5, Integer.parseInt(txtmobile.getText()));
				ps.setString(6, txtemail.getText());
				ps.setString(7, txtuser.getText());
				ps.setString(8,txtpassword.getText());
				
				int i=ps.executeUpdate();
				JOptionPane.showMessageDialog(btnNewButton, i+"Record added successfully");
				ps.close();
				con.close();
				}
				catch(Exception e1) {
					System.out.println(e1);
				}
			}
		});
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBounds(61, 378, 85, 21);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Reset");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtname.setText("");
				txtadress.setText("");
				txtage.setText("");
				txtmobile.setText("");
				txtemail.setText("");
				txtuser.setText("");
				txtpassword.setText("");
				buttonGroup.clearSelection();
			}
		});
		btnNewButton_1.setForeground(Color.BLACK);
		btnNewButton_1.setBounds(176, 378, 85, 21);
		contentPane.add(btnNewButton_1);
		
		txtpassword = new JPasswordField();
		txtpassword.setBounds(91, 333, 146, 19);
		contentPane.add(txtpassword);
		
		JButton delete = new JButton("Delete");
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/users","root","kavinkumar23");
				String query="delete from registration where username=?";
				PreparedStatement ps=con.prepareStatement(query);
				ps.setString(1,txtuser.getText());
				int i=ps.executeUpdate();
				JOptionPane.showMessageDialog(delete, i+"record deleted");
				ps.close();
				con.close();
				
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			}
		});
		delete.setBounds(295, 378, 85, 21);
		contentPane.add(delete);
	}
}
