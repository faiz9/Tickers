package as9;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class JFrameExt extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameExt frame = new JFrameExt();
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
	public JFrameExt() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(4, 1, 0, 0));
		
		JPanelExt jpe1 = new JPanelExt();
		jpe1.setTicker("Java 255");
		jpe1.setBackground(new Color(0, 191, 255));
		contentPane.add(jpe1);
		
		JPanelExt jpe2 = new JPanelExt();
		jpe2.setTicker("Java256\n");
		jpe2.setBackground(new Color(32, 178, 170));
		jpe2.setDirection(false);
		jpe2.setxInc(20);
		contentPane.add(jpe2);
		
		JPanelExt jpe3 = new JPanelExt();
		jpe3.setTicker("Java257");
		jpe3.setBackground(new Color(0, 250, 154));
		jpe3.setxInc(30);
		contentPane.add(jpe3);
		
		JPanel jp = new JPanel();
		jp.setBackground(new Color(248, 248, 255));
		contentPane.add(jp);
		
		JButton btnStart = new JButton("Start");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jpe1.setMoving(true);
				jpe2.setMoving(true);
				jpe3.setMoving(true);
				
			}
		});
		jp.add(btnStart);
		
		JButton btnStop = new JButton("Stop");
		btnStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jpe1.setMoving(false);
				jpe2.setMoving(false);
				jpe3.setMoving(false);
			}
		});
		jp.add(btnStop);
	}

}
