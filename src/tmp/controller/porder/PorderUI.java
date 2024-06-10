package controller.porder;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Member;
import model.Porder;
import util.cal;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PorderUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField a;
	private JTextField b;
	private JTextField c;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PorderUI frame = new PorderUI();
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
	public PorderUI() {
		setTitle("Porder UI");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 345);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 416, 288);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Shopping Mall");
		lblNewLabel.setFont(new Font("新細明體", Font.BOLD, 20));
		lblNewLabel.setBounds(119, 10, 124, 37);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Customer Name:");
		lblNewLabel_1.setFont(new Font("新細明體", Font.BOLD, 20));
		lblNewLabel_1.setBounds(25, 67, 152, 31);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("A");
		lblNewLabel_1_1.setFont(new Font("新細明體", Font.BOLD, 20));
		lblNewLabel_1_1.setBounds(25, 120, 152, 31);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("B");
		lblNewLabel_1_2.setFont(new Font("新細明體", Font.BOLD, 20));
		lblNewLabel_1_2.setBounds(25, 161, 152, 31);
		panel.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("C");
		lblNewLabel_1_3.setFont(new Font("新細明體", Font.BOLD, 20));
		lblNewLabel_1_3.setBounds(25, 202, 152, 31);
		panel.add(lblNewLabel_1_3);
		
		a = new JTextField();
		a.setFont(new Font("新細明體", Font.BOLD, 20));
		a.setBounds(187, 121, 107, 27);
		panel.add(a);
		a.setColumns(10);
		
		b = new JTextField();
		b.setFont(new Font("新細明體", Font.BOLD, 20));
		b.setColumns(10);
		b.setBounds(187, 161, 107, 27);
		panel.add(b);
		
		c = new JTextField();
		c.setFont(new Font("新細明體", Font.BOLD, 20));
		c.setColumns(10);
		c.setBounds(187, 202, 107, 27);
		panel.add(c);
		
		JLabel showName = new JLabel("");
		showName.setFont(new Font("新細明體", Font.BOLD, 20));
		showName.setBounds(186, 67, 108, 24);
		panel.add(showName);
		
		/**/
		Member m=(Member)(cal.readFile("member.txt"));
		
		showName.setText(m.getName());
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				/*
				 * 1.擷取 A,B,C-->轉 int
				 * 2.new Porder(name,a,b,c)
				 * 3.saveFile(名,p);
				 * 4.切換到confirm
				 */
				int A=Integer.parseInt(a.getText());
				int B=Integer.parseInt(b.getText());
				int C=Integer.parseInt(c.getText());
				
				Porder p=new Porder(m.getName(),A,B,C);
				
				cal.saveFile("porder.txt", p);
				
				ConfirmUI c=new ConfirmUI();
				c.setVisible(true);
				dispose();				
			}
		});
		btnNewButton.setFont(new Font("新細明體", Font.PLAIN, 20));
		btnNewButton.setBounds(308, 255, 85, 23);
		panel.add(btnNewButton);

	}
}
