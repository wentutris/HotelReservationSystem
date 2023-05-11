import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Toolkit;
import javax.swing.ImageIcon;


public class AdminPage {

	private JFrame ReservationsAdmin;

	private JTable table2;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminPage window = new AdminPage();
					window.ReservationsAdmin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		
	}

	/**
	 * Create the application.
	 */
	public AdminPage() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		ReservationsAdmin = new JFrame();
		ReservationsAdmin.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Chuchay\\eclipse-workspace\\Hotel Reservation System\\img\\logo.png"));
		ReservationsAdmin.setResizable(false);
		ReservationsAdmin.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				
			}
		});
		ReservationsAdmin.setTitle("G6 Hotel");
		ReservationsAdmin.setBounds(100, 100, 803, 509);
		ReservationsAdmin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ReservationsAdmin.getContentPane().setLayout(null);

		
		JLabel lbl_title = new JLabel("RESERVATION LIST");
		lbl_title.setForeground(Color.GRAY);
		lbl_title.setFont(new Font("Modern No. 20", Font.PLAIN, 19));
		lbl_title.setBounds(311, 23, 199, 23);
		ReservationsAdmin.getContentPane().add(lbl_title);
		
		JButton btn_logout = new JButton("LOGOUT");
		btn_logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a = JOptionPane.showConfirmDialog(btn_logout, "Are you sure you want to logout?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if (a == JOptionPane.YES_OPTION) {
				
					ReservationsAdmin.setVisible(false);
					Login.main(null);	
				}
				else if (a == JOptionPane.NO_OPTION) {
					
					ReservationsAdmin.setVisible(true);
					
				}
			}
		});
		btn_logout.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_logout.setBounds(668, 432, 98, 30);
		ReservationsAdmin.getContentPane().add(btn_logout);
		
		JButton btn_load = new JButton("LOAD DATA");
		btn_load.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = new DefaultTableModel();
				
				model.addColumn("reservationID");
				model.addColumn("Room No");
				model.addColumn("Arrival");
				model.addColumn("Departure");
				
				
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/g6hoteldb","root","");
					java.sql.Statement stmt = con.createStatement();
					
					String sql ="Select * from Reservations";
					ResultSet rs = stmt.executeQuery(sql);
					
					
					while (rs.next()) {
					
						
						model.addRow (new Object[] {
		
								rs.getString("reservationID"), 
								rs.getString("RoomNo"), 
								rs.getString("Arrival"), 
								rs.getString("Departure")}
							);
							
						table2.setModel(model);
					}
					
					con.close();
					
					
				}
				catch(Exception x) {System.out.print(x);}
				
				
			}
		});
		btn_load.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_load.setBounds(534, 432, 122, 30);
		ReservationsAdmin.getContentPane().add(btn_load);
		
		JScrollPane scrollPane = new JScrollPane();
		ReservationsAdmin.getContentPane().add(scrollPane);
		scrollPane.setBounds(32, 68, 734, 354);
		
		
		table2 = new JTable();
		table2.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
			 "Reservation ID", "Room No", "Arrival", "Departure"
			}
		));
		table2.setBackground(new Color(176, 196, 222));
		scrollPane.setViewportView(table2);
		
		JLabel adminbg = new JLabel("");
		adminbg.setIcon(new ImageIcon("C:\\Users\\Chuchay\\eclipse-workspace\\Hotel Reservation System\\img\\ss.png"));
		adminbg.setBounds(0, 0, 789, 472);
		ReservationsAdmin.getContentPane().add(adminbg);
		
	}
}
