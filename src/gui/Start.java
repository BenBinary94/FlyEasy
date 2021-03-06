package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import datenmodell.Destinations;
import datenmodell.Flug;
import datenmodell.FlugVerwaltung;

import javax.swing.JLabel;
import javax.swing.JList;
import java.util.Observer;
import java.util.Observable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.util.List;
import java.util.LinkedList;

public class Start extends JFrame {

	private JPanel contentPane;
	FlugVerwaltung verwaltung = new FlugVerwaltung();
	JList listFlights = new JList();

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

		lblBitteWhlenSie.setBounds(5, 5, 264, 16);
		contentPane.add(lblBitteWhlenSie);

		verwaltung.add(new Flug("20190505", Destinations.FRA, Destinations.DTM, false));
		verwaltung.add(new Flug("20190505", Destinations.FRA, Destinations.MIA, true));
		verwaltung.add(new Flug("20190505", Destinations.MUC, Destinations.GRU, true));

		verwaltung.ser();

		updateList();

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

				// NewFlight nf = new NewFlight();
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

		JButton btnRefresh = new JButton("Aktualisieren");
		btnRefresh.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
					updateList();
			}
		});
		btnRefresh.setBounds(303, 0, 117, 29);
		contentPane.add(btnRefresh);

		// System.out.println(listFlights.getSelectedIndices());
		// System.out.println(listFlights.getSelectedValuesList().toString());

	}

	public void updateList() {

		List<Flug> fluege = verwaltung.deser();

		if (!fluege.isEmpty()) {

			System.out.println("Deserialisieren erfolgreich");

			System.out.println(fluege);

			DefaultListModel<Flug> dlm = new DefaultListModel<>();

			for (Flug f : fluege) {

				dlm.addElement(f);
			}

			listFlights = new JList<Flug>(dlm);

		}

	}
}
