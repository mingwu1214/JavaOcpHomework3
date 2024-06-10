package controller.member;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.impl.MemberDaoImpl;
import model.Member;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

public class MemberUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField name;
	private JTextField username;
	private JTextField password;
	private JTextField address;
	private JTextField phone;
	private JTextField id;
	private JTextField uusername;
	private JTextField upassword;
	private JTextField uaddress;
	private JTextField uphone;
	private JTextField uname;
	private JTextField did;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MemberUI frame = new MemberUI();
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
	public MemberUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 646, 832);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 255, 255));
		panel.setBounds(10, 94, 612, 172);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		lblNewLabel.setBounds(10, 10, 105, 34);
		panel.add(lblNewLabel);
		
		name = new JTextField();
		name.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		name.setBounds(113, 16, 96, 21);
		panel.add(name);
		name.setColumns(10);
		
		username = new JTextField();
		username.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		username.setColumns(10);
		username.setBounds(113, 61, 96, 21);
		panel.add(username);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		lblUsername.setBounds(10, 55, 105, 34);
		panel.add(lblUsername);
		
		password = new JTextField();
		password.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		password.setColumns(10);
		password.setBounds(342, 61, 96, 21);
		panel.add(password);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		lblPassword.setBounds(239, 55, 105, 34);
		panel.add(lblPassword);
		
		address = new JTextField();
		address.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		address.setColumns(10);
		address.setBounds(113, 98, 441, 21);
		panel.add(address);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		lblAddress.setBounds(10, 92, 105, 34);
		panel.add(lblAddress);
		
		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		lblPhone.setBounds(10, 129, 105, 34);
		panel.add(lblPhone);
		
		phone = new JTextField();
		phone.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		phone.setColumns(10);
		phone.setBounds(113, 135, 96, 21);
		panel.add(phone);
		

		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 255, 255));
		panel_1.setBounds(10, 276, 612, 69);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		

		
		JLabel lblId_1 = new JLabel("Id");
		lblId_1.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		lblId_1.setBounds(10, 11, 105, 34);
		panel_1.add(lblId_1);
		
		did = new JTextField();
		did.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		did.setColumns(10);
		did.setBounds(113, 17, 96, 21);
		panel_1.add(did);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 355, 612, 199);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(297, 0, 0, 84);
		panel_2.add(textArea);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 43, 588, 146);
		panel_2.add(scrollPane);
		
		JTextArea showAll = new JTextArea();
		scrollPane.setViewportView(showAll);
		showAll.setWrapStyleWord(true);
		
		JButton btnQueryAll = new JButton("Query All");
		btnQueryAll.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//showAll.setText(new MemberDaoImpl().queryAll2());
				List<Member> l=new MemberDaoImpl().queryAll();
				String show="";
				for(Member m:l) 
				{
					show=show+"id"+m.getId()+"\tname:"+m.getName()+"\n";
				}
				
				String count="Total:"+l.size();
				showAll.setText(show+"\n========================================\n"+count);
				
			}
		});
		btnQueryAll.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		btnQueryAll.setBounds(10, 10, 129, 23);
		panel_2.add(btnQueryAll);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Member m=new Member(
						name.getText(),
						username.getText(),
						password.getText(),
						address.getText(),
						phone.getText()
						);
				new MemberDaoImpl().addMember(m);		
			}
		});
		btnNewButton.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		btnNewButton.setBounds(473, 135, 105, 23);
		panel.add(btnNewButton);		
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(40, 240, 251));
		panel_3.setBounds(10, 10, 612, 74);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Member Management");
		lblNewLabel_1.setFont(new Font("微軟正黑體", Font.PLAIN, 40));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 10, 592, 54);
		panel_3.add(lblNewLabel_1);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(254, 223, 255));
		panel_4.setBounds(10, 570, 612, 219);
		contentPane.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblId = new JLabel("Id");
		lblId.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		lblId.setBounds(10, 10, 105, 34);
		panel_4.add(lblId);
		
		id = new JTextField();
		id.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		id.setColumns(10);
		id.setBounds(113, 16, 96, 21);
		panel_4.add(id);
		
		JLabel lblUsername_1 = new JLabel("Username");
		lblUsername_1.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		lblUsername_1.setBounds(10, 55, 105, 34);
		panel_4.add(lblUsername_1);
		
		uusername = new JTextField();
		uusername.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		uusername.setColumns(10);
		uusername.setBounds(113, 61, 96, 21);
		panel_4.add(uusername);
		
		JLabel lblPassword_1 = new JLabel("Password");
		lblPassword_1.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		lblPassword_1.setBounds(239, 55, 105, 34);
		panel_4.add(lblPassword_1);
		
		upassword = new JTextField();
		upassword.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		upassword.setColumns(10);
		upassword.setBounds(342, 61, 96, 21);
		panel_4.add(upassword);
		
		JLabel lblAddress_1 = new JLabel("Address");
		lblAddress_1.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		lblAddress_1.setBounds(10, 92, 105, 34);
		panel_4.add(lblAddress_1);
		
		uaddress = new JTextField();
		uaddress.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		uaddress.setColumns(10);
		uaddress.setBounds(113, 98, 441, 21);
		panel_4.add(uaddress);
		
		JLabel lblPhone_1 = new JLabel("Phone");
		lblPhone_1.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		lblPhone_1.setBounds(10, 129, 105, 34);
		panel_4.add(lblPhone_1);
		
		uphone = new JTextField();
		uphone.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		uphone.setColumns(10);
		uphone.setBounds(113, 135, 96, 21);
		panel_4.add(uphone);
		
		JButton btnEdit_1 = new JButton("Edit");
		btnEdit_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int ID=Integer.parseInt(id.getText());
				String Name=uname.getText();
				String Password=upassword.getText();
				String Address=uaddress.getText();
				String Phone=uphone.getText();
				
				
				
				Member m=new MemberDaoImpl().queryMemberById(ID);
				m.setName(Name);
				m.setPassword(Password);
				m.setAddress(Address);
				m.setPhone(Phone);
				
				
				new MemberDaoImpl().updateMember(m);
				
				
				id.setText("");
				uname.setText("");
				uusername.setText("");
				upassword.setText("");
				uaddress.setText("");
				uphone.setText("");
			}
		});
		btnEdit_1.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		btnEdit_1.setBounds(473, 135, 105, 23);
		panel_4.add(btnEdit_1);
		
		uname = new JTextField();
		uname.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		uname.setColumns(10);
		uname.setBounds(342, 16, 96, 21);
		panel_4.add(uname);
		
		JLabel lblNewLabel_2_1 = new JLabel("Name");
		lblNewLabel_2_1.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		lblNewLabel_2_1.setBounds(239, 10, 105, 34);
		panel_4.add(lblNewLabel_2_1);

		JButton btnDelete = new JButton("DELETE");
		btnDelete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int ID=Integer.parseInt(did.getText());
				new MemberDaoImpl().deleteMember(ID);
				did.setText("");				
			}
		});
		btnDelete.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		btnDelete.setBounds(463, 22, 126, 23);
		panel_1.add(btnDelete);
	}
}
