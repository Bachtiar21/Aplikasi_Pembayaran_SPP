package tugasbesaralgo;

import java.awt.EventQueue;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JScrollPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class tubes_algo {

	private JFrame frame;
	private JTextField txtnamasiswa;
	private JTextField txtkelas;
	private JTextField txtbulan;
	private JTextField txtidsiswa;
	private JTable table;
	private JTextField txtjumlah;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					tubes_algo window = new tubes_algo();
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
	public tubes_algo() {
		initialize();
		connect();
		table_load();
	}
	
	Connection con;
	PreparedStatement pst;
	ResultSet rs;
	
	public void connect () {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/dbpembayaranspp", "root","");
		}
		catch (ClassNotFoundException ex)
		{
		
		}
		catch (SQLException ex)
		{
			
		}
	}
	
	public void table_load() 
	{
		try
		{
			pst = con.prepareStatement("select * from data_pembayaran");
			rs = pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 1078, 551);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setForeground(Color.BLACK);
		panel.setBorder(new LineBorder(Color.WHITE));
		panel.setBounds(226, 106, 373, 238);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("NAMA SISWA");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(10, 24, 108, 41);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("KELAS");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1.setBounds(10, 76, 108, 43);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("BULAN");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_2.setBounds(10, 130, 108, 39);
		panel.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_2_2 = new JLabel("JUMLAH");
		lblNewLabel_1_2_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_2_2.setBounds(10, 180, 108, 41);
		panel.add(lblNewLabel_1_2_2);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(255, 255, 255));
		panel_4.setBounds(128, 180, 229, 41);
		panel.add(panel_4);
		panel_4.setLayout(null);
		
		txtjumlah = new JTextField();
		txtjumlah.setBorder(null);
		txtjumlah.setBounds(10, 11, 209, 20);
		panel_4.add(txtjumlah);
		txtjumlah.setColumns(10);
		
		JPanel panel_4_1 = new JPanel();
		panel_4_1.setLayout(null);
		panel_4_1.setBackground(Color.WHITE);
		panel_4_1.setBounds(128, 128, 229, 41);
		panel.add(panel_4_1);
		
		txtbulan = new JTextField();
		txtbulan.setBorder(null);
		txtbulan.setBounds(10, 11, 209, 20);
		panel_4_1.add(txtbulan);
		txtbulan.setColumns(10);
		
		JPanel panel_4_2 = new JPanel();
		panel_4_2.setLayout(null);
		panel_4_2.setBackground(Color.WHITE);
		panel_4_2.setBounds(128, 76, 229, 41);
		panel.add(panel_4_2);
		
		txtkelas = new JTextField();
		txtkelas.setBorder(null);
		txtkelas.setBounds(10, 11, 209, 20);
		panel_4_2.add(txtkelas);
		txtkelas.setColumns(10);
		
		JPanel panel_4_2_1 = new JPanel();
		panel_4_2_1.setLayout(null);
		panel_4_2_1.setBackground(Color.WHITE);
		panel_4_2_1.setBounds(128, 24, 229, 41);
		panel.add(panel_4_2_1);
		
		txtnamasiswa = new JTextField();
		txtnamasiswa.setBorder(null);
		txtnamasiswa.setBounds(10, 11, 209, 20);
		panel_4_2_1.add(txtnamasiswa);
		txtnamasiswa.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(Color.WHITE));
		panel_1.setBounds(226, 414, 373, 63);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(119, 11, 229, 41);
		panel_1.add(panel_5);
		panel_5.setBackground(new Color(255, 255, 255));
		panel_5.setLayout(null);
		
		txtidsiswa = new JTextField();
		txtidsiswa.setBorder(null);
		txtidsiswa.setBounds(10, 11, 209, 20);
		panel_5.add(txtidsiswa);
		txtidsiswa.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				try {
					String id = txtidsiswa.getText ();
					
						pst = con.prepareStatement("select Nama_Siswa,Kelas,Bulan,Jumlah from data_pembayaran where id = ?");
						pst.setString(1, id);
						ResultSet rs = pst.executeQuery();
						
						if(rs.next()==true)
						{
							String namasiswa = rs.getString(1);
							String kelas = rs.getString(2);
							String bulan = rs.getString(3);
							String jumlah = rs.getString(4);
							
							txtnamasiswa.setText(namasiswa);
							txtkelas.setText(kelas);
							txtbulan.setText(bulan);
							txtjumlah.setText(jumlah);	
						}
						else 
						{
							txtnamasiswa.setText("");
							txtkelas.setText("");
							txtbulan.setText("");
							txtjumlah.setText("");
						}	
					}
				
				catch (SQLException ex) {
					
				}
				
			}
		});
		txtidsiswa.setColumns(10);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("ID SISWA");
		lblNewLabel_1_2_1.setBounds(10, 11, 86, 41);
		panel_1.add(lblNewLabel_1_2_1);
		lblNewLabel_1_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(new LineBorder(Color.WHITE));
		scrollPane.setBounds(623, 106, 429, 371);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(100, 149, 237));
		panel_2.setBounds(0, 47, 216, 465);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JButton btnNewButton = new JButton("SAVE");
		btnNewButton.setBounds(0, 198, 216, 38);
		panel_2.add(btnNewButton);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(34, 139, 34));
		
		JButton btnClear = new JButton("CLEAR");
		btnClear.setBounds(0, 274, 216, 38);
		panel_2.add(btnClear);
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnClear.setForeground(new Color(255, 255, 255));
		btnClear.setBackground(new Color(255, 215, 0));
		
		JButton btnUpdate = new JButton("UPDATE DATA");
		btnUpdate.setBounds(0, 235, 216, 38);
		panel_2.add(btnUpdate);
		btnUpdate.setForeground(new Color(255, 255, 255));
		btnUpdate.setBackground(new Color(34, 139, 34));
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		JButton btnClear_1_1 = new JButton("DELETE DATA");
		btnClear_1_1.setBounds(0, 313, 216, 38);
		panel_2.add(btnClear_1_1);
		btnClear_1_1.setForeground(new Color(255, 255, 255));
		btnClear_1_1.setBackground(new Color(220, 20, 60));
		btnClear_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		JButton btnExit = new JButton("EXIT");
		btnExit.setBounds(0, 352, 216, 38);
		panel_2.add(btnExit);
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnExit.setForeground(new Color(255, 255, 255));
		btnExit.setBackground(new Color(220, 20, 60));
		
		JLabel lblNewLabel_3 = new JLabel("ADMIN ADM. SPP");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(25, 149, 159, 38);
		panel_2.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setIcon(new ImageIcon(tubes_algo.class.getResource("/img/icon username.png")));
		lblNewLabel_4.setBounds(25, 25, 159, 129);
		panel_2.add(lblNewLabel_4);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(null);
		panel_3.setBackground(new Color(70, 130, 180));
		panel_3.setBounds(0, 0, 1062, 46);
		frame.getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(tubes_algo.class.getResource("/img/smanda.png.png")));
		lblNewLabel.setBounds(0, 0, 54, 46);
		panel_3.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("SMA NEGERI 2 KUNINGAN");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2.setBounds(64, 0, 221, 46);
		panel_3.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("APLIKASI PEMBAYARAN SPP");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2_1.setBounds(808, 0, 244, 46);
		panel_3.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("SMA NEGERI 2 KUNINGAN");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2_2.setBounds(64, 0, 221, 46);
		panel_3.add(lblNewLabel_2_2);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(100, 149, 237));
		panel_6.setBorder(null);
		panel_6.setBounds(226, 57, 373, 46);
		frame.getContentPane().add(panel_6);
		panel_6.setLayout(null);
		
		JLabel lblNewLabel_2_3 = new JLabel("FORM PEMBAYARAN");
		lblNewLabel_2_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2_3.setBounds(10, 0, 174, 46);
		panel_6.add(lblNewLabel_2_3);
		
		JPanel panel_6_1 = new JPanel();
		panel_6_1.setBorder(null);
		panel_6_1.setBackground(new Color(100, 149, 237));
		panel_6_1.setBounds(623, 57, 429, 46);
		frame.getContentPane().add(panel_6_1);
		panel_6_1.setLayout(null);
		
		JLabel lblNewLabel_2_3_2 = new JLabel("TABEL DATA PEMBAYARAN SPP");
		lblNewLabel_2_3_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2_3_2.setBounds(10, 0, 409, 46);
		panel_6_1.add(lblNewLabel_2_3_2);
		
		JPanel panel_6_2 = new JPanel();
		panel_6_2.setBorder(null);
		panel_6_2.setBackground(new Color(100, 149, 237));
		panel_6_2.setBounds(226, 367, 373, 46);
		frame.getContentPane().add(panel_6_2);
		panel_6_2.setLayout(null);
		
		JLabel lblNewLabel_2_3_1 = new JLabel("CARI SISWA");
		lblNewLabel_2_3_1.setBounds(10, 0, 174, 46);
		panel_6_2.add(lblNewLabel_2_3_1);
		lblNewLabel_2_3_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				System.exit(0);
			}
		});
		btnClear_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				String idsiswa;
				
				idsiswa = txtidsiswa.getText();
				
				try {
					pst = con.prepareStatement("delete from data_pembayaran where id=?");

					pst.setString(1, idsiswa);
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Record Delete!");
					
					table_load();
					txtnamasiswa.setText("");
					txtkelas.setText("");
					txtbulan.setText("");
					txtjumlah.setText("");
					txtnamasiswa.requestFocus();
				}
				
				catch (SQLException el) {
					el.printStackTrace();
				}
			}
		});
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String namasiswa,kelas,bulan,jumlah,idsiswa;
				
				namasiswa = txtnamasiswa.getText();
				kelas = txtkelas.getText();
				bulan = txtbulan.getText();
				jumlah = txtjumlah.getText();
				idsiswa = txtidsiswa.getText();
				
				try {
					pst = con.prepareStatement("update data_pembayaran set Nama_Siswa=?, Kelas=?, Bulan=?, Jumlah=? where id=?");
					pst.setString(1, namasiswa);
					pst.setString(2, kelas);
					pst.setString(3, bulan);
					pst.setString(4, jumlah);
					pst.setString(5, idsiswa);
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Record Update!");
					
					table_load();
					txtnamasiswa.setText("");
					txtkelas.setText("");
					txtbulan.setText("");
					txtjumlah.setText("");
					txtnamasiswa.requestFocus();
				}
				
				catch (SQLException el) {
					el.printStackTrace();
				}
			}
		});
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				txtnamasiswa.setText("");
				txtkelas.setText("");
				txtbulan.setText("");
				txtjumlah.setText("");
				txtnamasiswa.requestFocus();
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				String namasiswa,kelas,bulan,jumlah;
				
				namasiswa = txtnamasiswa.getText();
				kelas = txtkelas.getText();
				bulan = txtbulan.getText();
				jumlah = txtjumlah.getText();
				
				try {
					pst = con.prepareStatement("insert into data_pembayaran(Nama_Siswa,Kelas,Bulan,Jumlah)values(?,?,?,?)");
					pst.setString(1, namasiswa);
					pst.setString(2, kelas);
					pst.setString(3, bulan);
					pst.setString(4, jumlah);
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Record Add!");
					
					table_load();
					txtnamasiswa.setText("");
					txtkelas.setText("");
					txtbulan.setText("");
					txtjumlah.setText("");
					txtnamasiswa.requestFocus();
				}
				
				catch (SQLException el) {
					el.printStackTrace();
				}
			}
		});
	}

	public void setVisible() {
		// TODO Auto-generated method stub
		tubes_algo window = new tubes_algo();
		window.frame.setVisible(true);
	}

	public void tubes_algo() {
		// TODO Auto-generated method stub
		
	}
}


