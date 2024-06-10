package controller.porder;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.impl.PorderDaoImpl;
import model.Member;
import model.Porder;
import util.cal;

import javax.swing.JLabel;
import java.awt.Font;
import java.util.List;

import javax.swing.JTextArea;

public class FinishUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FinishUI frame = new FinishUI();
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
	public FinishUI() {
		setTitle("Finish UI");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 724, 476);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 690, 419);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JTextArea output = new JTextArea();
		output.setBounds(25, 21, 642, 376);
		panel.add(output);
			
		Member m=(Member)(cal.readFile("member.txt"));

		/*
		Porder p=(Porder)(cal.readFile("porder.txt"));
		int sum=p.getA()*30+p.getB()*40+p.getC()*50;
		
		String outputDetail="訂單號碼:"+p.getId()+
				"\n客戶:"+p.getName()+"\t地址:"+m.getAddress()+"\t電話:"+m.getPhone()+
				"\nA:"+p.getA()+
				"\nB:"+p.getB()+
				"\nC:"+p.getC()+
				"\n=================================="+
				"\n小計:"+sum+"元";
		*/
		List<Porder> l = new PorderDaoImpl().selectAll();
		Porder[] p=l.toArray(new Porder[l.size()]);
		int n=p.length -1;
		
		int sum=p[n].getA()*30+p[n].getB()*40+p[n].getC()*50;
		
		String outputDetail="訂單號碼:"+p[n].getId()+
				"\n客戶:"+p[n].getName()+"\t地址:"+m.getAddress()+"\t電話:"+m.getPhone()+
				"\nA:"+p[n].getA()+
				"\nB:"+p[n].getB()+
				"\nC:"+p[n].getC()+
				"\n=================================="+
				"\n小計:"+sum+"元";		
		output.setText(outputDetail);		
	}

}
