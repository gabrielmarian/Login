package Cont;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class FLogin extends JFrame {
	private Image img_logo = new ImageIcon(FLogin.class.getResource("/img/login.png")).getImage().getScaledInstance(90,
			90, Image.SCALE_SMOOTH);
	private Image img_username = new ImageIcon(FLogin.class.getResource("/img/man.png")).getImage()
			.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
	private Image img_password = new ImageIcon(FLogin.class.getResource("/img/key.png")).getImage()
			.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
	private Image img_log_in = new ImageIcon(FLogin.class.getResource("/img/padlock.png")).getImage()
			.getScaledInstance(30, 30, Image.SCALE_SMOOTH);

	private JPanel contentPane;
	private JPasswordField txtPassword;
	private JLabel lblloginmessage = new JLabel("");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FLogin frame = new FLogin();
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
	public FLogin() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 779, 482);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 139, 139));
		contentPane.setBorder(new LineBorder(Color.BLUE, 2));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(253, 240, 250, 40);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JTextArea txtUserName = new JTextArea();
		txtUserName.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtUserName.getText().equals("Username")) {
					txtUserName.setText("");
				}
				else {
					txtUserName.selectAll();
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtUserName.getText().equals("")) {
					txtUserName.setText("Username");
				}
			}
		});
		txtUserName.setFont(new Font("Arial", Font.PLAIN, 14));
		txtUserName.setText("UserName");
		txtUserName.setBounds(10, 10, 176, 25);
		panel.add(txtUserName);
		
		JLabel lblUsername = new JLabel("");
		lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsername.setBounds(205, 1, 45, 40);
		panel.add(lblUsername);
		lblUsername.setIcon(new ImageIcon(img_username));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(253, 290, 250, 40);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		txtPassword = new JPasswordField();
		txtPassword.setFont(new Font("Arial", Font.PLAIN, 14));
		txtPassword.setSelectedTextColor(Color.WHITE);
		txtPassword.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtPassword.getText().equals("Password")) {
					txtPassword.setEchoChar('*');
					txtPassword.setText("");
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtPassword.getText().equals("")) {
					txtPassword.setText("Password");
					txtPassword.setEchoChar((char)0);
				}
			}
		});
		txtPassword.setBorder(null);
		txtPassword.setEchoChar((char)0);
		txtPassword.setForeground(Color.BLACK);
		txtPassword.setText("Password");
		txtPassword.setBounds(10, 10, 172, 20);
		panel_1.add(txtPassword);
		
		JLabel lblKey = new JLabel("");
		lblKey.setHorizontalAlignment(SwingConstants.CENTER);
		lblKey.setBounds(205, 0, 45, 40);
		panel_1.add(lblKey);
		lblKey.setIcon(new ImageIcon(img_password));
		
		JPanel panel_2 = new JPanel();
		panel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(txtUserName.getText().equals("Gabriel") && txtPassword.getText().equals("bunica")) {
					//daca utilizatorul scrie corect
					lblloginmessage.setText("");
					JOptionPane.showMessageDialog(null, "Login Successful");
				}
				else if(txtUserName.getText().equals("") || txtUserName.getText().equals("Username") ||
						txtPassword.getText().equals("") || txtPassword.getText().equals("Password")) {
					lblloginmessage.setText("Please input all requirements!");
				}
				else {
					lblloginmessage.setText("Username and password didn't match!");

				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_2.setBackground(new Color(30, 60, 60));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel_2.setBackground(new Color(47, 79, 79));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				panel_2.setBackground(new Color(60, 80, 80));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				panel_2.setBackground(new Color(30, 60, 60));
			}
		});
		panel_2.setBackground(new Color(47, 79, 79));
		panel_2.setBounds(253, 374, 250, 50);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("LOG IN");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel.setBounds(86, 10, 97, 30);
		panel_2.add(lblNewLabel);
		
		JLabel lblLog_in = new JLabel("");
		lblLog_in.setHorizontalAlignment(SwingConstants.CENTER);
		lblLog_in.setBounds(178, 10, 62, 30);
		panel_2.add(lblLog_in);
		lblLog_in.setIcon(new ImageIcon(img_log_in));
		
		JLabel lblX = new JLabel("X");
		lblX.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JOptionPane.showConfirmDialog(null,"Are you sure want to close this application?","Confirmation",JOptionPane.YES_NO_OPTION) == 0) {
					FLogin.this.dispose();
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblX.setForeground(Color.RED);
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				lblX.setForeground(Color.WHITE);
			}
		});
		lblX.setForeground(Color.WHITE);
		lblX.setHorizontalAlignment(SwingConstants.CENTER);
		lblX.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		lblX.setBounds(749, 10, 20, 13);
		contentPane.add(lblX);
		
		JLabel lblIconLogo = new JLabel("");
		lblIconLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconLogo.setBackground(Color.WHITE);
		lblIconLogo.setForeground(Color.BLACK);
		lblIconLogo.setBounds(253, 72, 250, 147);
		contentPane.add(lblIconLogo);
		lblIconLogo.setIcon(new ImageIcon(img_logo));
		
		lblloginmessage.setForeground(Color.DARK_GRAY);
		lblloginmessage.setFont(new Font("Arial", Font.PLAIN, 12));
		lblloginmessage.setBounds(252, 351, 251, 13);
		contentPane.add(lblloginmessage);
		setLocationRelativeTo(null);
	}
}
