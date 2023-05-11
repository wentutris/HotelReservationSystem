import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Window.Type;
import java.awt.Toolkit;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class CustHomePage {

	JFrame HomePage;
	private JTextField Cust_Name;
	private JTextField Cust_Email;
	private JTextField ContactNo;
	private JTextField Cust_Address;
	
	private JTextField Arrival;
	private JTextField Departure;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustHomePage window = new CustHomePage();
					window.HomePage.setVisible(true);
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CustHomePage() {
		initialize();	
		
	}

	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		HomePage = new JFrame();
		HomePage.setResizable(false);
		HomePage.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Chuchay\\eclipse-workspace\\Hotel Reservation System\\img\\logo.png"));
		HomePage.setType(Type.POPUP);
		HomePage.getContentPane().setBackground(SystemColor.inactiveCaptionBorder);
		HomePage.setTitle("6G Hotel");
		HomePage.setBounds(100, 100, 770, 456);
		HomePage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		HomePage.getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tabbedPane.setBounds(10, 10, 736, 366);
		HomePage.getContentPane().add(tabbedPane);
		
		JPanel pnl_home = new JPanel();
		tabbedPane.addTab("Home", null, pnl_home, null);
		pnl_home.setLayout(null);
		
		JLabel lbl_homebg = new JLabel("");
		lbl_homebg.setIcon(new ImageIcon("C:\\Users\\Chuchay\\eclipse-workspace\\Hotel Reservation System\\img\\HOME.png"));
		lbl_homebg.setBounds(0, 0, 731, 335);
		pnl_home.add(lbl_homebg);
		
		JPanel pnl_booknow = new JPanel();
		tabbedPane.addTab("Book Now", null, pnl_booknow, null);
		pnl_booknow.setLayout(null);
		
		JLabel lbl_customer = new JLabel("Full Name:");
		lbl_customer.setFont(new Font("Corbel", Font.PLAIN, 17));
		lbl_customer.setBounds(140, 43, 100, 24);
		pnl_booknow.add(lbl_customer);
		
		Cust_Name = new JTextField();
		Cust_Name.setFont(new Font("SansSerif", Font.PLAIN, 13));
		Cust_Name.setBounds(240, 43, 406, 23);
		pnl_booknow.add(Cust_Name);
		Cust_Name.setColumns(10);
		
		JLabel lbl_email = new JLabel("Email:");
		lbl_email.setFont(new Font("Corbel", Font.PLAIN, 17));
		lbl_email.setBounds(140, 78, 100, 24);
		pnl_booknow.add(lbl_email);
		
		Cust_Email = new JTextField();
		Cust_Email.setFont(new Font("SansSerif", Font.PLAIN, 13));
		Cust_Email.setColumns(10);
		Cust_Email.setBounds(240, 79, 406, 23);
		pnl_booknow.add(Cust_Email);
		
		JLabel lbl_contact = new JLabel("Contact No.");
		lbl_contact.setFont(new Font("Corbel", Font.PLAIN, 17));
		lbl_contact.setBounds(140, 109, 100, 24);
		pnl_booknow.add(lbl_contact);
		
		ContactNo = new JTextField();
		ContactNo.setFont(new Font("Dubai", Font.PLAIN, 10));
		ContactNo.setColumns(10);
		ContactNo.setBounds(240, 108, 406, 25);
		pnl_booknow.add(ContactNo);
		
		JLabel lbl_roomtype = new JLabel("Room Type:");
		lbl_roomtype.setFont(new Font("Corbel", Font.PLAIN, 17));
		lbl_roomtype.setBounds(140, 179, 100, 24);
		pnl_booknow.add(lbl_roomtype);
		
		JComboBox RoomType = new JComboBox();
		RoomType.setFont(new Font("SansSerif", Font.PLAIN, 10));
		RoomType.setBackground(Color.WHITE);
		RoomType.setModel(new DefaultComboBoxModel(new String[] {"[Select Room No]", "201", "202", "203", "204", "301", "302", "303", "304", "305", "306", "307", "308", "401", "402", "403", "404"}));
		
		RoomType.setBounds(240, 180, 406, 24);
		pnl_booknow.add(RoomType);
		
		
		JLabel lbl_Arrival = new JLabel("Arrival:");
		lbl_Arrival.setFont(new Font("Corbel", Font.PLAIN, 17));
		lbl_Arrival.setBounds(140, 216, 100, 24);
		pnl_booknow.add(lbl_Arrival);
		
		JLabel lbl_Departure = new JLabel("Departure:");
		lbl_Departure.setFont(new Font("Corbel", Font.PLAIN, 17));
		lbl_Departure.setBounds(140, 250, 100, 24);
		pnl_booknow.add(lbl_Departure);
		
		JButton btn_proceed = new JButton("PROCEED");
		btn_proceed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String arrival = Arrival.getText();
				RoomType.getSelectedItem();
				String room = RoomType.getSelectedItem().toString();
				
				String departure = Departure.getText();
				
				
				
				
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/g6hoteldb","root","");
					Statement stmt = con.createStatement();
					
					
					if(room.equals("") || arrival.equals("") || departure.equals(""))   {
						JOptionPane.showMessageDialog(null, "Field cannot be empty. Please provide details.");
					}
					
					else {
			
						String query = "INSERT INTO Reservations ( RoomNo, Arrival, Departure) values( '" + room +" ', '" + arrival + "', '" + departure + "')";		
						stmt.execute(query);
						JOptionPane.showMessageDialog(btn_proceed, "Reservation submitted successfully!");
						
				
						Arrival.setText("");
						Departure.setText("");
						
					}
					
					
					con.close();
					
				}
				
				
				catch(Exception x) {System.out.print(x);}
			}
		});
		btn_proceed.setFont(new Font("SansSerif", Font.PLAIN, 12));
		btn_proceed.setBounds(250, 293, 111, 32);
		pnl_booknow.add(btn_proceed);
		
		JButton btn_cancel = new JButton("CANCEL");
		btn_cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cust_Name.setText("");
				Cust_Email.setText("");
				Cust_Address.setText("");
				ContactNo.setText("");
				Arrival.setText("");
				Departure.setText("");
				
			}
		});
		
		btn_cancel.setFont(new Font("SansSerif", Font.PLAIN, 12));
		btn_cancel.setBounds(371, 293, 111, 32);
		pnl_booknow.add(btn_cancel);
		
		Arrival = new JTextField();
		Arrival.setToolTipText("YYYY/MM/DD");
		Arrival.setBounds(240, 215, 406, 25);
		pnl_booknow.add(Arrival);
		Arrival.setColumns(10);
		
		Departure = new JTextField();
		Departure.setToolTipText("YYYY/MM/DD");
		Departure.setColumns(10);
		Departure.setBounds(240, 250, 406, 25);
		pnl_booknow.add(Departure);
		
		JLabel lbl_address = new JLabel("Address:");
		lbl_address.setFont(new Font("Corbel", Font.PLAIN, 17));
		lbl_address.setBounds(140, 146, 100, 24);
		pnl_booknow.add(lbl_address);
		
		Cust_Address = new JTextField();
		Cust_Address.setColumns(10);
		Cust_Address.setBounds(240, 143, 406, 24);
		pnl_booknow.add(Cust_Address);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Chuchay\\eclipse-workspace\\Hotel Reservation System\\img\\BOOK NOW.png"));
		lblNewLabel.setBounds(0, 0, 731, 335);
		pnl_booknow.add(lblNewLabel);
		
		
		JPanel pnl_gallery = new JPanel();
		tabbedPane.addTab("Gallery and Service", null, pnl_gallery, null);
		
		JLabel gands_bg = new JLabel("");
		gands_bg.setIcon(new ImageIcon("C:\\Users\\Chuchay\\eclipse-workspace\\Hotel Reservation System\\img\\GALLERY2.png"));
		pnl_gallery.add(gands_bg);
		
		
		
		
		
		
		JPanel pnl_aboutus = new JPanel();
		tabbedPane.addTab("Contact Us", null, pnl_aboutus, null);
		pnl_aboutus.setLayout(null);
		
		JLabel lbl_ctcusbg = new JLabel("");
		lbl_ctcusbg.setIcon(new ImageIcon("C:\\Users\\Chuchay\\eclipse-workspace\\Hotel Reservation System\\img\\CONTACT US.png"));
		lbl_ctcusbg.setBounds(0, 0, 731, 335);
		pnl_aboutus.add(lbl_ctcusbg);
		
		JPanel pnl_terms = new JPanel();
		tabbedPane.addTab("Terms and Condition", null, pnl_terms, null);
		
		JLabel tandc_bg = new JLabel("");
		tandc_bg.setIcon(new ImageIcon("C:\\Users\\Chuchay\\eclipse-workspace\\Hotel Reservation System\\img\\terms & conditions.png"));
		pnl_terms.add(tandc_bg);
		
		JButton btn_logout = new JButton("Log-out");
		btn_logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a = JOptionPane.showConfirmDialog(btn_logout, "Are you sure you want to logout?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if (a == JOptionPane.YES_OPTION) {
				
					HomePage.setVisible(false);
					Login.main(null);	
				}
				else if (a == JOptionPane.NO_OPTION) {
					
					HomePage.setVisible(true);
					
				}
				
				
			}
		});
		btn_logout.setBounds(635, 386, 98, 23);
		HomePage.getContentPane().add(btn_logout);
		
		
	}
}
