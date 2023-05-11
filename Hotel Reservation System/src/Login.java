import java.awt.EventQueue;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

import java.awt.Font;
import javax.swing.JTextField;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;

import java.sql.DriverManager;
import java.awt.Window.Type;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.UIManager;




public class Login {

	JFrame LoginPage;
	private JTextField Username;
	private JTextField Password;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.LoginPage.setVisible(true);
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
		LoginPage = new JFrame();
		LoginPage.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Chuchay\\eclipse-workspace\\Hotel Reservation System\\img\\logo.png"));
		LoginPage.setType(Type.POPUP);
		LoginPage.setResizable(false);
		LoginPage.setTitle("G6 Hotel");
		LoginPage.setBounds(100, 100, 634, 417);
		LoginPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		LoginPage.getContentPane().setLayout(null);
		
	
		
	
		
		JLabel lbl_username = new JLabel("Username: ");
		lbl_username.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbl_username.setBounds(148, 127, 107, 22);
		LoginPage.getContentPane().add(lbl_username);
		
		JLabel lbl_password = new JLabel("Password:");
		lbl_password.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbl_password.setBounds(148, 172, 107, 22);
		LoginPage.getContentPane().add(lbl_password);
		
		
		Username = new JTextField();
		Username.setColumns(10);
		Username.setBounds(241, 127, 188, 24);
		LoginPage.getContentPane().add(Username);
		
		Password = new JPasswordField();
		Password.setName("");
		Password.setColumns(10);
		Password.setBounds(241, 175, 188, 24);
		
		
	
		LoginPage.getContentPane().add(Password);
		
		JButton btn_login = new JButton("LOGIN");
		btn_login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				String uname = Username.getText(); 
				String pass = Password.getText();
				
				if (uname.equals("") || pass.equals(""))   {
					JOptionPane.showMessageDialog(null, "Invalid Username or Password.");
				}
				
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/g6hoteldb","root","");
					Statement stmt = con.createStatement();
					
					String sql ="Select * from customerinfo where Username='"+ uname +"' and Password='"+pass.toString()+"' and Type = 'customer'";
					ResultSet rs = stmt.executeQuery(sql);
					
						
					if (rs.next()) {
						JOptionPane.showMessageDialog(null, "Login Successful!");
						
						LoginPage.setVisible(false);
						CustHomePage.main(null);	
					}
					/*else {
						JOptionPane.showMessageDialog(null, "Invalid Username or Password.");
					}*/
					
					
				
					String sql2 ="Select * from customerinfo where Username='"+ uname +"' and Password='"+pass.toString()+"' and Type = 'admin'";
					ResultSet rs2 =stmt.executeQuery(sql2);
				
					if (rs2.next()) {
						LoginPage.setVisible(false);
						AdminPage.main(null);	
					}
					
				
				
					
					con.close();
					
					
				}
				catch(Exception x) {System.out.print(x);}
				
				
				
		
			} 
		
		});
		btn_login.setForeground(Color.BLACK);
		btn_login.setBackground(UIManager.getColor("CheckBox.interiorBackground"));
		btn_login.setBounds(170, 249, 112, 33);
		LoginPage.getContentPane().add(btn_login);
		
		JButton btn_signup = new JButton("SIGNUP");
		btn_signup.setBackground(UIManager.getColor("CheckBox.interiorBackground"));
		btn_signup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginPage.setVisible(false);
				Registration.main(null);
			}
		});
		btn_signup.setForeground(Color.BLACK);
		btn_signup.setBounds(307, 249, 112, 33);
		LoginPage.getContentPane().add(btn_signup);
		
		JLabel loginbg = new JLabel("");
		loginbg.setIcon(new ImageIcon("C:\\Users\\Chuchay\\eclipse-workspace\\Hotel Reservation System\\img\\login.png"));
		loginbg.setBounds(0, 0, 620, 370);
		LoginPage.getContentPane().add(loginbg);
		
	
		
	}
}
