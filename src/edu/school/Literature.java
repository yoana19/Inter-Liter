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
	static Hashtable<String, String> titleToFileName8 = new Hashtable<String, String>();
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

		titleToFileName8.put("Старогръцка митология", "Старогръцка митология.txt");
		titleToFileName8.put("Илиада", "Илиада.txt");
		titleToFileName8.put("Любов", "Любов.txt");
		titleToFileName8.put("Антигона", "Антигона.txt");
		titleToFileName8.put("Библия", "Библията.txt");
		titleToFileName8.put("Пространно житие на Константин – Кирил", "Пространно житие на Константин-Кирил.txt");
		titleToFileName8.put("Азбучна молитва", "Азбучна молитва.txt");
		titleToFileName8.put("Декамерон", "Декамерон.txt");
		titleToFileName8.put("Дон Кихот", "Дон Кихот.txt");
		titleToFileName8.put("Хамлет", "Хамлет.txt");
		titleToFileName8.put("Сонети", "");
		titleToFileName9.put("Пътешествията на Гъливер", "");
		titleToFileName9.put("Лека нощ", "");
		titleToFileName9.put("Тя иде като нощ красива", "");
		titleToFileName9.put("На А.П. Керн; Аз своя паметник сградих – неръкотворен", "");
		titleToFileName9.put("Дядо Горио", "");
		titleToFileName9.put("Мадам Бовари", "");
		titleToFileName9.put("Сплин", "");
		titleToFileName9.put("Униние; Есенна песен", "");
		titleToFileName9.put("История славянобългарска", "");
		titleToFileName9.put("Изворът на Белоногата", "");
		titleToFileName9.put("Майце си", "");
		titleToFileName9.put("Моята молитва", "");
		titleToFileName9.put("Хаджи Димитър", "");
		titleToFileName9.put("Обесването на Васил Левски", "");
		titleToFileName9.put("Странник", "");
		titleToFileName10.put("Епопея на забравените", "");
		titleToFileName10.put("Под игото", "");
		titleToFileName10.put("Бай Ганьо. Невероятни разкази за един съвременен българин", "");
		titleToFileName10.put("Сърце на сърцата", "");
		titleToFileName10.put("Две хубави очи; Обичам те; Маска", "");
		titleToFileName10.put("Да се завърнеш…", "");
		titleToFileName10.put("Гераците", "");
		titleToFileName10.put("Септември", "");
		titleToFileName10.put("Зимни вечери", "");
		titleToFileName10.put("Повест", "");
		titleToFileName10.put("Индже; Албена", "");
		titleToFileName10.put("Писмо", "");
		titleToFileName10.put("Тютюн", "„Тютюн“ (Д.txt");
		titleToFileName10.put("Нежната спирала", "");
		titleToFileName10.put("Дърво без корен", "");
		titleToFileName11.put("Железният светилник", "");
		titleToFileName11.put("Бай Ганьо на гости", "");
		titleToFileName11.put("Криворазбраната цивилизация", "");
		titleToFileName11.put("При Рилския манастир", "");
		titleToFileName11.put("Спи езерото", "");
		titleToFileName11.put("Градушка", "");
		titleToFileName11.put("До моето първо либе", "");
		titleToFileName11.put("Новото гробище над Сливница", "");
		titleToFileName11.put("Сватба", "");
		titleToFileName11.put("Борба", "");
		titleToFileName11.put("Андрешко", "");
		titleToFileName11.put("Приказка за стълбата", "");
		titleToFileName11.put("Паисий", "");
		titleToFileName11.put("Нощ", "");
		titleToFileName11.put("История", "");
		titleToFileName12.put("Аз искам да те помня все така", "");
		titleToFileName12.put("Колко си хубава", "");
		titleToFileName12.put("Любов", "");
		titleToFileName12.put("Спасова могила", "");
		titleToFileName12.put("Молитва", "");
		titleToFileName12.put("Вяра", "");
		titleToFileName12.put("Ветрената мелница", "");
		titleToFileName12.put("Песента на колелетата", "");
		titleToFileName12.put("Балада за Георг Хених", "");
		titleToFileName12.put("Две души", "");
		titleToFileName12.put("Потомка", "");
		titleToFileName12.put("Честен кръст", "");

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

				textArea.setText(
						getFile((String) titlesForCurrentClass().get(String.valueOf(cmbwork.getSelectedItem()))));
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
