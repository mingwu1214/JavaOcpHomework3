package controller;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.member.AddMemberUI;
import controller.member.LoginErrorUI;
import controller.member.LoginSuccessUI;
import dao.impl.MemberDaoImpl;
import model.Member;
import util.cal;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class LoginUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField username;
	private JTextField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginUI frame = new LoginUI();
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
	public LoginUI() {
		setTitle("Member Management System - Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 416, 227);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		lblNewLabel.setBounds(10, 23, 111, 35);
		panel.add(lblNewLabel);
		
		username = new JTextField();
		username.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		username.setBounds(131, 29, 96, 21);
		panel.add(username);
		username.setColumns(10);
		
		password = new JTextField();
		password.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		password.setColumns(10);
		password.setBounds(131, 75, 96, 21);
		panel.add(password);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		lblPassword.setBounds(10, 69, 111, 35);
		panel.add(lblPassword);
		

		
		JButton btnSignup = new JButton("SignUp");
		btnSignup.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AddMemberUI l=new AddMemberUI();
				l.setVisible(true);
				dispose();				
			}
		});
		btnSignup.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		btnSignup.setBounds(146, 136, 127, 35);
		panel.add(btnSignup);
		

		JButton btnNewButton = new JButton("login");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				/*
				 * 1.擷取-->username,password->getText
				 * 2.判斷-->queryMember(帳號,密碼);
				 * 3.!=null-->LoginSuccessUI
				 * 4.LoginErrorUI
				 */
				
				String Username=username.getText();
				String Password=password.getText();		
				Member m=new MemberDaoImpl().queryMember(Username, Password);
				
				if(m!=null) {
					/*
					try {
						FileOutputStream fos = new FileOutputStream("member.txt");
						ObjectOutputStream oos =new ObjectOutputStream(fos);
						oos.writeObject(m);
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();						
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					*/
					cal.saveFile("member.txt", m);
					
					LoginSuccessUI l=new LoginSuccessUI();
					l.setVisible(true);
					dispose();
				}else {
						LoginErrorUI l= new LoginErrorUI();
						l.setVisible(true);
						dispose();
				}
			}
		});
		btnNewButton.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		btnNewButton.setBounds(10, 136, 96, 35);
		panel.add(btnNewButton);
	}
}
