package gui;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import datenmodell.Flug;

import javax.swing.JLabel;
import javax.swing.JList;
import java.util.Observer;
import java.util.Observable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class Start extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Start frame = new Start();
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
	public Start() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBitteWhlenSie = new JLabel("Bitte w\u00E4hlen Sie einen Flug aus");
		lblBitteWhlenSie.setBounds(5, 5, 440, 16);
		contentPane.add(lblBitteWhlenSie);
		
		
		
		DefaultListModel<Flug> dlm = new DefaultListModel<>();
		
		dlm.addElement(new Flug("MUC", "FRA"));
		dlm.addElement(new Flug("KUL", "DNP"));
		
		JList listFlights = new JList(dlm);
		listFlights.setBounds(15, 33, 405, 199);
		
		
		listFlights.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				System.out.println("es wurde etwas gecklickt");
			}
		});
		contentPane.add(listFlights);
		
		JButton btnNewFlight = new JButton("Neuer Flug");
		btnNewFlight.setBounds(5, 244, 136, 29);
		btnNewFlight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				//NewFlight nf = new NewFlight();
				try {
					NewFlight nf = new NewFlight();
					nf.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
				
				System.out.println("Neuer Flug soll angelegt werden");
				
			}
		});
		
		
		contentPane.add(btnNewFlight);
		
		JButton btnNeuerPassagier = new JButton("Neuer Passagier");
		btnNeuerPassagier.setBounds(155, 244, 136, 29);
		contentPane.add(btnNeuerPassagier);
		
		JButton btnNeueBuchung = new JButton("Neue Buchung");
		btnNeueBuchung.setBounds(303, 244, 117, 29);
		contentPane.add(btnNeueBuchung);
		
		// System.out.println(listFlights.getSelectedIndices());
		// System.out.println(listFlights.getSelectedValuesList().toString());
		
	
	}
}