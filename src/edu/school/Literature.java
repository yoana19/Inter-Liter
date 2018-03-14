package edu.school;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ItemEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;

import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import java.util.*;

public class Literature extends JFrame {

	private JPanel contentPane;
	private JComboBox cmbwork;
	private JTextArea textArea;
	private JButton addopen;
	private JButton removeopen;
	private JButton renameopen;
	private JPanel text;
	private JPanel addprocess;
	private JTextField addnewname;
	private JTextField renamenewname;

	JComboBox cmbgrade;
	JComboBox renamegrade;

	static Hashtable titleToFileName1 = new Hashtable();
	static Hashtable titleToFileName2 = new Hashtable();
	static Hashtable titleToFileName3 = new Hashtable();
	static Hashtable titleToFileName4 = new Hashtable();
	static Hashtable titleToFileName5 = new Hashtable();
	static Hashtable titleToFileName6 = new Hashtable();
	static Hashtable titleToFileName7 = new Hashtable();
	static Hashtable titleToFileName8 = new Hashtable();
	static Hashtable titleToFileName9 = new Hashtable();
	static Hashtable titleToFileName10 = new Hashtable();
	static Hashtable titleToFileName11 = new Hashtable();
	static Hashtable titleToFileName12 = new Hashtable();
	static Hashtable titleToFileName13 = new Hashtable();
	private JComboBox renamework;

	String cmb2[] = new String[] {};

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Literature frame = new Literature();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private static String getFileForLabel(String fileName) {

		StringBuilder result = new StringBuilder("");

		File file = new File("resources/" + fileName);

		try (Scanner scanner = new Scanner(file)) {
			result.append("<html>");
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				result.append(line).append("<br/>");
			}
			result.append("</html>");

			scanner.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

		return result.toString();

	}

	private static String getFile(String fileName) {

		StringBuilder result = new StringBuilder("");

		File file = new File("resources/" + fileName);

		try {
			Scanner scanner = new Scanner(file);
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				result.append(line).append("\n");
			}

			scanner.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

		return result.toString();

	}

	private static void saveTextFile(String fileName, String content) {

		File file = new File("resources/" + fileName);
		try (PrintWriter out = new PrintWriter(file.getAbsoluteFile())) {
			out.println(content);

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}

		return;

	}

	/**
	 * Create the frame.
	 */

	private Hashtable<String, String> titlesForCurrentClass() {
		String grade = String.valueOf(cmbgrade.getSelectedItem());
		int g = 0;
		try {
			g = Integer.parseInt(grade);
		} catch (Exception e) {
			g = 13;
		}

		switch (g) {
		case 1:
			return titleToFileName1;
		case 2:
			return titleToFileName2;
		case 3:
			return titleToFileName3;
		case 4:
			return titleToFileName4;
		case 5:
			return titleToFileName5;
		case 6:
			return titleToFileName6;
		case 7:
			return titleToFileName7;
		case 8:
			return titleToFileName8;
		case 9:
			return titleToFileName9;
		case 10:
			return titleToFileName10;
		case 11:
			return titleToFileName11;
		case 12:
			return titleToFileName12;
		default:
			return titleToFileName13;
		}
	}

	public Literature() {

		titleToFileName8.put("Старогръцка митология", "a.txt");
		titleToFileName8.put("Илиада", "b.txt");
		titleToFileName8.put("Любов", "c.txt");
		titleToFileName8.put("Антигона", "d.txt");
		titleToFileName8.put("Библия", "e.txt");
		titleToFileName8.put("Пространно житие на Константин – Кирил", "f.txt");
		titleToFileName8.put("За буквите", "fa.txt");
		titleToFileName8.put("Азбучна молитва", "g.txt");
		titleToFileName8.put("Декамерон", "h.txt");
		titleToFileName8.put("Дон Кихот", "i.txt");
		titleToFileName8.put("Хамлет", "j.txt");
		titleToFileName8.put("Сонети", "gg.txt");
		titleToFileName9.put("Пътешествията на Гъливер", "l.txt");
		titleToFileName9.put("Лека нощ", "m.txt");
		titleToFileName9.put("Тя иде като нощ красива", "n.txt");
		titleToFileName9.put("На А.П. Керн; Аз своя паметник сградих – неръкотворен", "o.txt");
		titleToFileName9.put("Дядо Горио", "p.txt");
		titleToFileName9.put("Мадам Бовари", "q.txt");
		titleToFileName9.put("Сплин", "r.txt");
		titleToFileName9.put("Униние; Есенна песен", "s.txt");
		titleToFileName9.put("История славянобългарска", "t.txt");
		titleToFileName9.put("Изворът на Белоногата", "u.txt");
		titleToFileName9.put("Майце си", "v.txt");
		titleToFileName9.put("Моята молитва", "w.txt");
		titleToFileName9.put("Хаджи Димитър", "x.txt");
		titleToFileName9.put("Обесването на Васил Левски", "y.txt");
		titleToFileName9.put("Странник", "„z.txt");
		titleToFileName10.put("Епопея на забравените", "aa.txt");
		titleToFileName10.put("Под игото", "ab.txt");
		titleToFileName10.put("Бай Ганьо. Невероятни разкази за един съвременен българин", "ac.txt");
		titleToFileName10.put("Сърце на сърцата", "„ad.txt");
		titleToFileName10.put("Две хубави очи; Обичам те; Маска", "ae.txt");
		titleToFileName10.put("Да се завърнеш…", "af.txt");
		titleToFileName10.put("Гераците", "ag.txt");
		titleToFileName10.put("Септември", "ah.txt");
		titleToFileName10.put("Зимни вечери", "ai.txt");
		titleToFileName10.put("Повест", "aj.txt");
		titleToFileName10.put("Индже; Албена", "ak.txt");
		titleToFileName10.put("Писмо", "al.txt");
		titleToFileName10.put("Тютюн", "am.txt");
		titleToFileName10.put("Нежната спирала", "an.txt");
		titleToFileName10.put("Дърво без корен", "ao.txt");
		titleToFileName11.put("Железният светилник", "ap.txt");
		titleToFileName11.put("Бай Ганьо на гости", "aq.txt");
		titleToFileName11.put("Криворазбраната цивилизация", "ar.txt");
		titleToFileName11.put("При Рилския манастир", "as.txt");
		titleToFileName11.put("Спи езерото", "at.txt");
		titleToFileName11.put("Градушка", "au.txt");
		titleToFileName11.put("До моето първо либе", "av.txt");
		titleToFileName11.put("Новото гробище над Сливница", "aw.txt");
		titleToFileName11.put("Сватба", "ax.txt");
		titleToFileName11.put("Борба", "ay.txt");
		titleToFileName11.put("Андрешко", "az.txt");
		titleToFileName11.put("Приказка за стълбата", "ba.txt");
		titleToFileName11.put("Паисий", "bb.txt");
		titleToFileName11.put("Нощ", "bc.txt");
		titleToFileName11.put("История", "bd.txt");
		titleToFileName12.put("Аз искам да те помня все така", "be.txt");
		titleToFileName12.put("Колко си хубава", "bf.txt");
		titleToFileName12.put("Любов", "bg.txt");
		titleToFileName12.put("Спасова могила", "bh.txt");
		titleToFileName12.put("Молитва", "bi.txt");
		titleToFileName12.put("Вяра", "bj.txt");
		titleToFileName12.put("Ветрената мелница", "bk.txt");
		titleToFileName12.put("Песента на колелетата", "bl.txt");
		titleToFileName12.put("Балада за Георг Хених", "bm.txt");
		titleToFileName12.put("Две души", "bn.txt");
		titleToFileName12.put("Потомка", "bo.txt");
		titleToFileName12.put("Честен кръст", "bp.txt");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		cmbgrade = new JComboBox();
		cmbgrade.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {

				List<String> titles = Collections.list(titlesForCurrentClass().keys());
				titles.add(0, "Изберете произведение");
				cmb2 = (String[]) titles.toArray(new String[titles.size()]);
				cmbwork.setModel(new DefaultComboBoxModel(cmb2));
				cmbwork.setVisible(true);
			}
		});
		cmbgrade.setMaximumRowCount(13);
		cmbgrade.setModel(new DefaultComboBoxModel(new String[] { "Избери клас... ", "1", "2", "3", "4", "5", "6", "7",
				"8", "9", "10", "11", "12" }));
		cmbgrade.setBounds(10, 20, 210, 20);
		contentPane.add(cmbgrade);

		cmbwork = new JComboBox();
		cmbwork.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				Hashtable titleToFileName;
				textArea.setText(getFile((String) titlesForCurrentClass().get(String.valueOf(cmbwork.getSelectedItem()))));
				textArea.setCaretPosition(0);
			}
		});
		cmbwork.setMaximumRowCount(13);
		cmbwork.setBounds(230, 20, 210, 20);
		contentPane.add(cmbwork);

		JButton save = new JButton("Запази промени");
		save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println((String) titlesForCurrentClass().get(String.valueOf(cmbwork.getSelectedItem())));
				System.out.println(textArea.getText());
				saveTextFile((String) titlesForCurrentClass().get(String.valueOf(cmbwork.getSelectedItem())),
						textArea.getText());
			}
		});
		save.setBounds(10, 60, 430, 25);
		contentPane.add(save);

		text = new JPanel();
		text.setBounds(10, 100, 430, 300);
		contentPane.add(text);
		text.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		text.add(scrollPane, BorderLayout.CENTER);

		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		cmbwork.setVisible(false);
	}
}
