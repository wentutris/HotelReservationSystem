import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTextField;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Window.Type;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import javax.swing.UIManager;

public class Registration {

	private JFrame RegistrationPage;
	private JTextField Cust_Name;
	private JTextField Password;
	private JTextField Cust_Email;
	private JTextField Cust_Address;
	private JTextField ContactNo;
	private JTextField Username;
	private JTextField Password2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registration window = new Registration();
					window.RegistrationPage.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Registration() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		RegistrationPage = new JFrame();
		RegistrationPage.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Chuchay\\eclipse-workspace\\Hotel Reservation System\\img\\logo.png"));
		RegistrationPage.setType(Type.POPUP);
		RegistrationPage.setResizable(false);
		RegistrationPage.setTitle("G6 Hotel");
		RegistrationPage.setBounds(200, 200, 686, 431);
		RegistrationPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		RegistrationPage.getContentPane().setLayout(null);
		
		
		JButton btn_create = new JButton("CREATE ACCOUNT");
		btn_create.setBackground(UIManager.getColor("Button.light"));
		btn_create.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = Cust_Name.getText();
				String email = Cust_Email.getText();
				String address = Cust_Address.getText();
				String mobile = ContactNo.getText();
				String username = Username.getText();
				String pass1 = Password.getText();
				String pass2 = Password2.getText();
				
				
				
				
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/g6hoteldb","root","");
					Statement stmt = con.createStatement();
					
				
					if (name.equals("") || email.equals("") || address.equals("") || mobile.equals("") || username.equals("") || pass1.equals("") || pass2.equals(""))   {
						JOptionPane.showMessageDialog(null, "Field cannot be empty. Please provide details.");
					}
					
					else if (!pass1.equals(pass2)) {
						JOptionPane.showMessageDialog(null, "Mismatched Password!");
						
					}
					else if (pass1.equals(pass2)){
						String query = "INSERT INTO customerinfo (Cust_Name, Cust_Email, Cust_Address, ContactNo, Username, Password, Password2, Type)  values (' " + name + "','" + email + "',' " + address + "','" + mobile + "', '" + username + "', '" + pass1 + "', '" + pass2 + "', 'customer')";		
						stmt.execute(query);
						JOptionPane.showMessageDialog(btn_create, "Account successfully created! Login to continue.");
						RegistrationPage.setVisible(false);
						Login.main(null);
					}
					
					
					con.close();
					
				}
				
				
				catch(Exception x) {System.out.print(x);}
				
				
				
			}
		});
		btn_create.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btn_create.setForeground(UIManager.getColor("CheckBox.foreground"));
		btn_create.setBounds(154, 275, 149, 41);
		RegistrationPage.getContentPane().add(btn_create);
		
		JLabel lbl_name = new JLabel("Full Name: ");
		lbl_name.setForeground(SystemColor.activeCaptionText);
		lbl_name.setFont(new Font("Californian FB", lbl_name.getFont().getStyle() | Font.BOLD, 17));
		lbl_name.setBounds(22, 107, 107, 22);
		RegistrationPage.getContentPane().add(lbl_name);
		
		Cust_Name = new JTextField();
		Cust_Name.setColumns(10);
		Cust_Name.setBounds(139, 106, 188, 24);
		RegistrationPage.getContentPane().add(Cust_Name);
		
		JLabel lbl_pass1 = new JLabel("Password:");
		lbl_pass1.setFont(new Font("Californian FB", lbl_pass1.getFont().getStyle() | Font.BOLD, 17));
		lbl_pass1.setBounds(349, 158, 127, 22);
		RegistrationPage.getContentPane().add(lbl_pass1);
		
		Password = new JPasswordField();
		Password.setColumns(10);
		Password.setBounds(476, 157, 167, 24);
		RegistrationPage.getContentPane().add(Password);
		
		JLabel lbl_email = new JLabel("Email Address:");
		lbl_email.setFont(new Font("Californian FB", lbl_email.getFont().getStyle() | Font.BOLD, 16));
		lbl_email.setBounds(22, 139, 107, 22);
		RegistrationPage.getContentPane().add(lbl_email);
		
		Cust_Email = new JTextField();
		Cust_Email.setColumns(10);
		Cust_Email.setBounds(139, 139, 188, 24);
		RegistrationPage.getContentPane().add(Cust_Email);
		
		JLabel lbl_address = new JLabel("Address:");
		lbl_address.setFont(new Font("Californian FB", lbl_address.getFont().getStyle() | Font.BOLD, 17));
		lbl_address.setBounds(22, 178, 107, 22);
		RegistrationPage.getContentPane().add(lbl_address);
		
		Cust_Address = new JTextField();
		Cust_Address .setColumns(10);
		Cust_Address .setBounds(139, 177, 188, 24);
		RegistrationPage.getContentPane().add(Cust_Address );
		
		JLabel lbl_contactnum = new JLabel("Contact No.:");
		lbl_contactnum.setFont(new Font("Californian FB", lbl_contactnum.getFont().getStyle() | Font.BOLD, 17));
		lbl_contactnum.setBounds(22, 212, 107, 22);
		RegistrationPage.getContentPane().add(lbl_contactnum);
		
		ContactNo = new JTextField();
		ContactNo.setColumns(10);
		ContactNo.setBounds(139, 211, 188, 24);
		RegistrationPage.getContentPane().add(ContactNo);
		
		JLabel lbl_username = new JLabel("Username:");
		lbl_username.setFont(new Font("Californian FB", lbl_username.getFont().getStyle() | Font.BOLD, 17));
		lbl_username.setBounds(349, 107, 127, 22);
		RegistrationPage.getContentPane().add(lbl_username);
		
		Username = new JTextField();
		Username.setColumns(10);
		Username.setBounds(476, 106, 167, 24);
		RegistrationPage.getContentPane().add(Username);
		
		JLabel lbl_pass2 = new JLabel("Confirm Password:");
		lbl_pass2.setFont(new Font("Californian FB", lbl_pass2.getFont().getStyle() | Font.BOLD, 16));
		lbl_pass2.setBounds(349, 216, 127, 22);
		RegistrationPage.getContentPane().add(lbl_pass2);
		
		Password2 = new JPasswordField();
		Password2.setColumns(10);
		Password2.setBounds(476, 211, 167, 24);
		RegistrationPage.getContentPane().add(Password2);
		
		JButton btn_cancel = new JButton("CANCEL");
		btn_cancel.setBackground(UIManager.getColor("CheckBox.background"));
		btn_cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistrationPage.setVisible(false);
				Login.main(null);	
			}
		});
		btn_cancel.setForeground(UIManager.getColor("CheckBox.foreground"));
		btn_cancel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btn_cancel.setBounds(349, 275, 149, 41);
		RegistrationPage.getContentPane().add(btn_cancel);
		
		JLabel registrationbg = new JLabel("");
		registrationbg.setIcon(new ImageIcon("C:\\Users\\Chuchay\\eclipse-workspace\\Hotel Reservation System\\img\\signup.png"));
		registrationbg.setBounds(0, 0, 672, 394);
		RegistrationPage.getContentPane().add(registrationbg);
		
		
	}
}
