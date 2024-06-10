package controller.porder;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.member.LoginErrorUI;
import dao.impl.PorderDaoImpl;
import model.Porder;
import util.cal;

import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ConfirmUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConfirmUI frame = new ConfirmUI();
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
	public ConfirmUI() {
		setTitle("Confirm UI");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 359);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 416, 302);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel custom = new JLabel("?");
		custom.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		custom.setBackground(new Color(128, 255, 255));
		custom.setBounds(10, 20, 102, 29);
		panel.add(custom);
		
		JLabel show = new JLabel("Following is your shopping list");
		show.setFont(new Font("新細明體", Font.BOLD, 20));
		show.setBounds(122, 20, 269, 48);
		panel.add(show);
		

		
		JTextArea output = new JTextArea();
		output.setBounds(20, 67, 368, 156);
		panel.add(output);

		/**/
		Porder p=(Porder)(cal.readFile("porder.txt"));
		
		custom.setText(p.getName());
		
		show.setText("Following is your shopping list");
		
		int sum=p.getA()*30+p.getB()*40+p.getC()*50;
		
		String outputDetail="A:" + p.getA() +
				"\nB:" + p.getB() +
				"\nC:" + p.getC() +
				"\nTotal:" + sum + " NTD";
		output.setText(outputDetail);
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new PorderDaoImpl().add(p);
				FinishUI l= new FinishUI();
				l.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setFont(new Font("新細明體", Font.BOLD, 20));
		btnNewButton.setBounds(254, 248, 137, 44);
		panel.add(btnNewButton);		
	}
}
