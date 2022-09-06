package kiosk;

import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.Desktop.Action;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.Toolkit;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;

public class kiosk extends JFrame {
	int count = 0;
	String show = "";
	static int amount;
	int aamount;
	int clickamount = 0;
	int num = 0;
	int where = 0; // 1일 시 매장, 2일 시 포장
	static int salesmoney = 0;
	int day = 1;
	int orderbtn0 = 0; // 0일 시 버튼 비어있음, 1일 시 버튼 사용 중
	int orderbtn1 = 0;
	int orderbtn2 = 0;
	int orderbtn3 = 0;
	int orderbtn4 = 0;
	int orderbtn5 = 0;
	int orderbtn6 = 0;
	int orderbtn7 = 0;
	int onoffnum = 0; // 0일 시 폐점, 1일 시 개점
	int login = 0;// 0일 시 로그아웃, 1일 시 로그인
	String id = "admin";
	String id2 = "";
	String password = "1234";
	String password2 = "";

	int seatnum0 = 0; // 0일 시 자리 비어있음
	int seatnum1 = 0;
	int seatnum2 = 0;
	int seatnum3 = 0;
	int seatnum4 = 0;
	int seatnum5 = 0;
	int seatnum6 = 0;
	int seatnum7 = 0;
	int tempseatnum = 0;

	int ordernum0 = 0;
	int ordernum1 = 0;
	int ordernum2 = 0;
	int ordernum3 = 0;
	int ordernum4 = 0;
	int ordernum5 = 0;
	int ordernum6 = 0;
	int ordernum7 = 0;

	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					kiosk frame = new kiosk();
					frame.setVisible(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public kiosk() {
		
		//주문 시간
		SimpleDateFormat temporderformat = new SimpleDateFormat ("yyyy-MM-dd, HH:mm:ss");

		// txt

		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
		Date time = new Date();
		String time1 = format1.format(time);

		String fileName = "./sales/" + time1 + " 매출.txt";

		//

		// -

		JFrame f = new JFrame(); // 객체생성 및 초기화
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setBounds(150, 195, 300, 200);
		JLabel label1 = new JLabel("아이디 : ", JLabel.CENTER);
		label1.setFont(new Font("나눔고딕", Font.PLAIN, 12));
		label1.setBounds(0, 10, 99, 40);
		JLabel label2 = new JLabel("비밀번호 : ", JLabel.CENTER);
		label2.setFont(new Font("나눔고딕", Font.PLAIN, 12));
		label2.setBounds(0, 60, 99, 50);
		JTextField id1 = new JTextField();
		id1.setFont(new Font("나눔고딕", Font.PLAIN, 13));
		id1.setBounds(111, 11, 161, 40);
		JTextField password1 = new JTextField();
		password1.setFont(new Font("나눔고딕", Font.PLAIN, 12));
		password1.setBounds(111, 65, 161, 40);
		f.getContentPane().setLayout(null);
		f.getContentPane().add(label1);
		f.getContentPane().add(id1);
		f.getContentPane().add(label2);
		f.getContentPane().add(password1);

		JButton loginok = new JButton("확인");
		loginok.setFont(new Font("나눔고딕", Font.PLAIN, 14));
		loginok.setBounds(93, 120, 99, 31);
		f.getContentPane().add(loginok);

		f.setVisible(false);

		// -

		JFrame frame = new JFrame("키오스크");
		frame.setBounds(450, 195, 1000, 650);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

		JFrame managermode = new JFrame("관리자 모드");
		managermode.setBounds(25, 195, 450, 650);
		managermode.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		managermode.setVisible(false);

		JPanel main = new JPanel();
		main.setBackground(new Color(255, 255, 240));
		main.setBounds(0, 0, 984, 611);
		frame.getContentPane().add(main);
		main.setLayout(null);

		JButton store = new JButton("");
		store.setForeground(Color.BLACK);
		store.setBackground(Color.LIGHT_GRAY);
		store.setFont(new Font("국립박물관문화재단클래식 Bold", Font.PLAIN, 70));
		store.setBounds(112, 144, 328, 357);
		store.setBorder(new TitledBorder(new LineBorder(Color.LIGHT_GRAY, 3)));
		store.setIcon(new ImageIcon("./image/store.png"));
		main.add(store);

		JButton pickup = new JButton("");
		pickup.setForeground(Color.BLACK);
		pickup.setFont(new Font("국립박물관문화재단클래식 Bold", Font.PLAIN, 70));
		pickup.setBackground(Color.LIGHT_GRAY);
		pickup.setBounds(560, 144, 328, 357);
		pickup.setIcon(new ImageIcon("./image/pickup.png"));
		pickup.setBorder(new TitledBorder(new LineBorder(Color.LIGHT_GRAY, 3)));
		main.add(pickup);

		store.setEnabled(false);
		pickup.setEnabled(false);

		JButton textField = new JButton();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setForeground(Color.BLACK);
		textField.setFont(new Font("국립박물관문화재단클래식 Bold", Font.PLAIN, 50));
		textField.setBorder(new TitledBorder(new LineBorder(Color.LIGHT_GRAY, 1)));
		textField.setIcon(new ImageIcon("./image/background2.jpg"));
		textField.setBounds(0, 0, 984, 110);
		main.add(textField);

		JButton manager = new JButton("관리자 모드");
		manager.setForeground(Color.BLACK);
		manager.setFont(new Font("국립박물관문화재단클래식 Bold", Font.PLAIN, 20));
		manager.setBackground(Color.LIGHT_GRAY);
		manager.setBounds(783, 541, 161, 42);
		main.add(manager);

		JButton moneypayment = new JButton("결제");
		moneypayment.setFont(new Font("국립박물관문화재단클래식 Bold", Font.PLAIN, 50));
		moneypayment.setBounds(588, 281, 156, 270);
		moneypayment.setEnabled(false);

		// --------

		JPanel seatpanel = new JPanel();
		seatpanel.setBackground(new Color(255, 255, 240));
		seatpanel.setBounds(0, 0, 984, 611);
		frame.getContentPane().add(seatpanel);
		seatpanel.setLayout(null);

		JButton seattext = new JButton();
		seattext.setHorizontalAlignment(SwingConstants.CENTER);
		seattext.setForeground(Color.BLACK);
		seattext.setBackground(new Color(230, 230, 250));
		seattext.setBorder(new TitledBorder(new LineBorder(Color.LIGHT_GRAY, 1)));
		seattext.setBounds(0, 0, 984, 70);
		seattext.setIcon(new ImageIcon("./image/background3.jpg"));

		seatpanel.add(seattext);

		JTextField enter = new JTextField();
		enter.setEditable(false);
		enter.setBackground(new Color(230, 230, 250));
		enter.setText("입구");
		enter.setBorder(new TitledBorder(new LineBorder(Color.LIGHT_GRAY, 1)));
		enter.setFont(new Font("국립박물관문화재단클래식 Bold", Font.PLAIN, 20));
		enter.setHorizontalAlignment(SwingConstants.CENTER);
		enter.setBounds(448, 582, 116, 29);
		seatpanel.add(enter);
		enter.setColumns(10);

		JButton seatbtn_0 = new JButton("자리 1");
		seatbtn_0.setBackground(new Color(173, 216, 230));
		seatbtn_0.setFont(new Font("국립박물관문화재단클래식 Bold", Font.PLAIN, 30));
		seatbtn_0.setBounds(61, 101, 209, 116);
		seatpanel.add(seatbtn_0);

		JButton seatbtn_1 = new JButton("자리 2");
		seatbtn_1.setBackground(new Color(173, 216, 230));
		seatbtn_1.setFont(new Font("국립박물관문화재단클래식 Bold", Font.PLAIN, 30));
		seatbtn_1.setBounds(61, 265, 209, 116);
		seatpanel.add(seatbtn_1);

		JButton seatbtn_2 = new JButton("자리 3");
		seatbtn_2.setBackground(new Color(173, 216, 230));
		seatbtn_2.setFont(new Font("국립박물관문화재단클래식 Bold", Font.PLAIN, 30));
		seatbtn_2.setBounds(61, 427, 209, 116);
		seatpanel.add(seatbtn_2);

		JButton seatbtn_3 = new JButton("자리 4");
		seatbtn_3.setBackground(new Color(173, 216, 230));
		seatbtn_3.setFont(new Font("국립박물관문화재단클래식 Bold", Font.PLAIN, 30));
		seatbtn_3.setBounds(396, 101, 209, 116);
		seatpanel.add(seatbtn_3);

		JButton seatbtn_4 = new JButton("자리 5");
		seatbtn_4.setBackground(new Color(173, 216, 230));
		seatbtn_4.setFont(new Font("국립박물관문화재단클래식 Bold", Font.PLAIN, 30));
		seatbtn_4.setBounds(396, 265, 209, 116);
		seatpanel.add(seatbtn_4);

		JButton seatbtn_5 = new JButton("자리 6");
		seatbtn_5.setBackground(new Color(173, 216, 230));
		seatbtn_5.setFont(new Font("국립박물관문화재단클래식 Bold", Font.PLAIN, 30));
		seatbtn_5.setBounds(714, 101, 209, 116);
		seatpanel.add(seatbtn_5);

		JButton seatbtn_6 = new JButton("자리 7");
		seatbtn_6.setBackground(new Color(173, 216, 230));
		seatbtn_6.setFont(new Font("국립박물관문화재단클래식 Bold", Font.PLAIN, 30));
		seatbtn_6.setBounds(714, 265, 209, 116);
		seatpanel.add(seatbtn_6);

		JButton seatbtn_7 = new JButton("자리 8");
		seatbtn_7.setBackground(new Color(173, 216, 230));
		seatbtn_7.setFont(new Font("국립박물관문화재단클래식 Bold", Font.PLAIN, 30));
		seatbtn_7.setBounds(714, 427, 209, 116);
		seatpanel.add(seatbtn_7);

		JButton seatcancel = new JButton("취소");
		seatcancel.setBackground(new Color(230, 230, 250));
		seatcancel.setFont(new Font("국립박물관문화재단클래식 Bold", Font.PLAIN, 20));
		seatcancel.setBounds(863, 582, 109, 23);
		seatpanel.add(seatcancel);

		seatpanel.setVisible(false);

		// 자리관리
		JFrame seatmanager = new JFrame("관리자 모드");
		seatmanager.setBounds(1445, 195, 450, 650);
		seatmanager.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		seatmanager.setVisible(false);

		JPanel seatmanagerpanel = new JPanel();
		seatmanagerpanel.setBackground(new Color(255, 255, 240));
		seatmanagerpanel.setBounds(0, 0, 450, 611);
		seatmanager.getContentPane().add(seatmanagerpanel);
		seatmanagerpanel.setLayout(null);

		JTextField textFieldddddd = new JTextField();
		textFieldddddd.setText("카운터용 자리 관리기");
		
		textFieldddddd.setFont(new Font("나눔고딕", Font.BOLD, 22));
		textFieldddddd.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldddddd.setEditable(false);
		textFieldddddd.setBounds(12, 10, 410, 55);
		textFieldddddd.setBorder(new TitledBorder(new LineBorder(Color.LIGHT_GRAY, 2)));
		seatmanagerpanel.add(textFieldddddd);
		textFieldddddd.setColumns(10);

		JButton seatset_0 = new JButton("자리 1번 관리");
		seatset_0.setFont(new Font("나눔고딕", Font.PLAIN, 20));
		seatset_0.setBounds(12, 102, 178, 90);
		seatmanagerpanel.add(seatset_0);

		JButton seatset_1 = new JButton("자리 2번 관리");
		seatset_1.setFont(new Font("나눔고딕", Font.PLAIN, 20));
		seatset_1.setBounds(244, 102, 178, 90);
		seatmanagerpanel.add(seatset_1);

		JButton seatset_2 = new JButton("자리 3번 관리");
		seatset_2.setFont(new Font("나눔고딕", Font.PLAIN, 20));
		seatset_2.setBounds(12, 222, 178, 90);
		seatmanagerpanel.add(seatset_2);

		JButton seatset_3 = new JButton("자리 4번 관리");
		seatset_3.setFont(new Font("나눔고딕", Font.PLAIN, 20));
		seatset_3.setBounds(244, 222, 178, 90);
		seatmanagerpanel.add(seatset_3);

		JButton seatset_4 = new JButton("자리 5번 관리");
		seatset_4.setFont(new Font("나눔고딕", Font.PLAIN, 20));
		seatset_4.setBounds(12, 347, 178, 90);
		seatmanagerpanel.add(seatset_4);

		JButton seatset_5 = new JButton("자리 6번 관리");
		seatset_5.setFont(new Font("나눔고딕", Font.PLAIN, 20));
		seatset_5.setBounds(244, 347, 178, 90);
		seatmanagerpanel.add(seatset_5);

		JButton seatset_6 = new JButton("자리 7번 관리");
		seatset_6.setFont(new Font("나눔고딕", Font.PLAIN, 20));
		seatset_6.setBounds(12, 467, 178, 90);
		seatmanagerpanel.add(seatset_6);

		JButton seatset_7 = new JButton("자리 8번 관리");
		seatset_7.setFont(new Font("나눔고딕", Font.PLAIN, 20));
		seatset_7.setBounds(244, 467, 178, 90);
		seatmanagerpanel.add(seatset_7);

		JTextField orderstate_0 = new JTextField("사용 가능");
		orderstate_0.setFont(new Font("나눔고딕", Font.PLAIN, 14));
		orderstate_0.setBackground(Color.WHITE);
		orderstate_0.setHorizontalAlignment(SwingConstants.CENTER);
		orderstate_0.setEditable(false);
		orderstate_0.setBounds(41, 191, 116, 21);
		seatmanagerpanel.add(orderstate_0);
		orderstate_0.setColumns(10);

		JTextField orderstate_1 = new JTextField("사용 가능");
		orderstate_1.setHorizontalAlignment(SwingConstants.CENTER);
		orderstate_1.setFont(new Font("나눔고딕", Font.PLAIN, 14));
		orderstate_1.setEditable(false);
		orderstate_1.setColumns(10);
		orderstate_1.setBackground(Color.WHITE);
		orderstate_1.setBounds(278, 191, 116, 21);
		seatmanagerpanel.add(orderstate_1);

		JTextField orderstate_2 = new JTextField("사용 가능");
		orderstate_2.setHorizontalAlignment(SwingConstants.CENTER);
		orderstate_2.setFont(new Font("나눔고딕", Font.PLAIN, 14));
		orderstate_2.setEditable(false);
		orderstate_2.setColumns(10);
		orderstate_2.setBackground(Color.WHITE);
		orderstate_2.setBounds(41, 311, 116, 21);
		seatmanagerpanel.add(orderstate_2);

		JTextField orderstate_3 = new JTextField("사용 가능");
		orderstate_3.setHorizontalAlignment(SwingConstants.CENTER);
		orderstate_3.setFont(new Font("나눔고딕", Font.PLAIN, 14));
		orderstate_3.setEditable(false);
		orderstate_3.setColumns(10);
		orderstate_3.setBackground(Color.WHITE);
		orderstate_3.setBounds(278, 311, 116, 21);
		seatmanagerpanel.add(orderstate_3);

		JTextField orderstate_4 = new JTextField("사용 가능");
		orderstate_4.setHorizontalAlignment(SwingConstants.CENTER);
		orderstate_4.setFont(new Font("나눔고딕", Font.PLAIN, 14));
		orderstate_4.setEditable(false);
		orderstate_4.setColumns(10);
		orderstate_4.setBackground(Color.WHITE);
		orderstate_4.setBounds(41, 436, 116, 21);
		seatmanagerpanel.add(orderstate_4);

		JTextField orderstate_5 = new JTextField("사용 가능");
		orderstate_5.setHorizontalAlignment(SwingConstants.CENTER);
		orderstate_5.setFont(new Font("나눔고딕", Font.PLAIN, 14));
		orderstate_5.setEditable(false);
		orderstate_5.setColumns(10);
		orderstate_5.setBackground(Color.WHITE);
		orderstate_5.setBounds(278, 436, 116, 21);
		seatmanagerpanel.add(orderstate_5);

		JTextField orderstate_6 = new JTextField("사용 가능");
		orderstate_6.setHorizontalAlignment(SwingConstants.CENTER);
		orderstate_6.setFont(new Font("나눔고딕", Font.PLAIN, 14));
		orderstate_6.setEditable(false);
		orderstate_6.setColumns(10);
		orderstate_6.setBackground(Color.WHITE);
		orderstate_6.setBounds(41, 556, 116, 21);
		seatmanagerpanel.add(orderstate_6);

		JTextField orderstate_7 = new JTextField("사용 가능");
		orderstate_7.setHorizontalAlignment(SwingConstants.CENTER);
		orderstate_7.setFont(new Font("나눔고딕", Font.PLAIN, 14));
		orderstate_7.setEditable(false);
		orderstate_7.setColumns(10);
		orderstate_7.setBackground(Color.WHITE);
		orderstate_7.setBounds(278, 556, 116, 21);
		seatmanagerpanel.add(orderstate_7);

		// 프레임 설정
		JFrame menuframe = new JFrame("키오스크");
		menuframe.setBounds(450, 195, 1000, 650);
		menuframe.setBackground(new Color(0, 0, 0));
		menuframe.setLocationRelativeTo(null);
		menuframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Font font = new Font("맑은 고딕", Font.PLAIN, 17);
		// 메뉴판넬
		JPanel menuprint = new JPanel();
		menuprint.setLocation(0, 0);
		menuprint.setBackground(new Color(255, 255, 240));
		menuprint.setSize(615, 500);
		menuprint.setFont(font);
		menuprint.setBorder(new TitledBorder(new LineBorder(Color.LIGHT_GRAY, 2)));

		String food[] = { "떡갈비정식", "떡갈비까스", "떡갈비치즈", "골동면        ", "계란볶음밥", "로제떡볶이", "패션후르츠", "음료            " };
		int price[] = { 6500, 7500, 8000, 6500, 7000, 8000, 4000, 2000 };
		JButton bt[] = new JButton[food.length];
		JTextField suja[] = new JTextField[food.length];
		Button minus[] = new Button[food.length];
		Button plus[] = new Button[food.length];
		JButton ok[] = new JButton[food.length];
		JLabel l[] = new JLabel[food.length];
		ImageIcon icon[] = new ImageIcon[food.length];

		for (int i = 0; i < food.length; i++) {

			bt[i] = new JButton(food[i]);
			if (i < 4) {
				bt[i].setBounds(25 + i * 150, 50, 100, 100);
			} else {
				bt[i].setBounds(25 + (i - 4) * 150, 300, 100, 100);
			}
			icon[i] = new ImageIcon("./image/" + i + ".png");

			bt[i].setIcon(icon[i]);

			suja[i] = new JTextField("0");
			suja[i].setBackground(Color.white);
			suja[i].setEditable(false);
			suja[i].setBounds(bt[i].getX() + 30, bt[i].getY() + 130, 40, 20);
			suja[i].setFont(new Font("국립박물관문화재단클래식 Bold", Font.PLAIN, 18));

			minus[i] = new Button("-");
			minus[i].setBounds(bt[i].getX(), suja[i].getY(), 20, 20);
			minus[i].setEnabled(false);
			minus[i].setFont(new Font("맑은 고딕", Font.PLAIN, 20));

			plus[i] = new Button("+");
			plus[i].setBounds(bt[i].getX() + (100 - 20), suja[i].getY(), 20, 20);
			plus[i].setEnabled(false);
			plus[i].setFont(new Font("맑은 고딕", Font.PLAIN, 20));

			l[i] = new JLabel(price[i] + "원");
			l[i].setFont(new Font("국립박물관문화재단클래식 Bold", Font.PLAIN, 18));
			l[i].setBounds(bt[i].getX() + 20, suja[i].getY() - 25, 100, 20);

			ok[i] = new JButton("확인");
			ok[i].setBounds(bt[i].getX(), suja[i].getY() + 30, 100, 25);
			ok[i].setEnabled(false);
			ok[i].setBackground(new Color(230, 230, 250));
			ok[i].setFont(new Font("국립박물관문화재단클래식 Bold", Font.PLAIN, 18));

			menuprint.add(bt[i]);
			menuprint.add(suja[i]);
			menuprint.add(minus[i]);
			menuprint.add(plus[i]);
			menuprint.add(l[i]);
			menuprint.add(ok[i]);
		}

		JTextArea ta = new JTextArea("", 0, 0);
		ta.setBounds(613, 0, 371, 445);
		ta.setText("   상품명              단가         수량      합계\r\n\r\n");

		ta.setBackground(new Color(255, 255, 240));
		ta.setEditable(false);
		ta.setFont(new Font("을유1945 SemiBold", Font.PLAIN, 19));
		ta.setBorder(new TitledBorder(new LineBorder(Color.LIGHT_GRAY, 2)));

		JPanel menuoption = new JPanel();
		menuoption.setBackground(new Color(255, 255, 240));
		menuoption.setBounds(0, 498, 615, 113);
		menuoption.setFont(font);
		menuoption.setBorder(new TitledBorder(new LineBorder(Color.LIGHT_GRAY, 2)));

		menuoption.setBackground(Color.WHITE);
		JButton bt2 = new JButton("초기화");
		bt2.setBackground(new Color(230, 230, 250));
		bt2.setForeground(Color.BLACK);
		bt2.setBounds(60, 27, 202, 65);
		bt2.setFont(new Font("국립박물관문화재단클래식 Bold", Font.PLAIN, 20));
		JButton bt3 = new JButton("닫기");
		bt3.setBackground(new Color(230, 230, 250));
		bt3.setBounds(338, 27, 202, 65);
		bt3.setFont(new Font("국립박물관문화재단클래식 Bold", Font.PLAIN, 20));
		menuoption.setLayout(null);
		menuoption.add(bt2);
		menuoption.add(bt3);

		menuframe.getContentPane().setLayout(null);
		menuframe.setVisible(true);

		JPanel managerpanel = new JPanel();
		managerpanel.setBackground(new Color(255, 255, 240));
		managerpanel.setBounds(0, 0, 450, 611);
		managermode.getContentPane().add(managerpanel);
		managerpanel.setLayout(null);
		
		JButton soldoutbt = new JButton("품절관리");
		soldoutbt.setFont(new Font("나눔고딕", Font.BOLD, 14));
		soldoutbt.setBackground(new Color(224, 255, 255));
		soldoutbt.setBounds(189, 531, 113, 70);
		managerpanel.add(soldoutbt);
		
		JPanel soldoutpanel = new JPanel();
		soldoutpanel.setBackground(new Color(255, 255, 240));
		soldoutpanel.setBounds(0, 0, 434, 611);
		managermode.getContentPane().add(soldoutpanel);
		soldoutpanel.setLayout(null);
		soldoutpanel.setVisible(false);
		
		JTextField soldoutfield = new JTextField();
		soldoutfield.setText("품   절   관   리");
		soldoutfield.setFont(new Font("나눔고딕", Font.BOLD, 22));
		soldoutfield.setHorizontalAlignment(SwingConstants.CENTER);
		soldoutfield.setEditable(false);
		soldoutfield.setBounds(12, 10, 410, 55);
		soldoutfield.setBorder(new TitledBorder(new LineBorder(Color.LIGHT_GRAY, 2)));
		soldoutpanel.add(soldoutfield);
		soldoutfield.setColumns(10);
		
		JButton soldoutbt_0 = new JButton("메뉴 1 판매 상태");
		soldoutbt_0.setBackground(new Color(230, 230, 250));
		soldoutbt_0.setFont(new Font("나눔고딕", Font.PLAIN, 18));
		soldoutbt_0.setBounds(12, 75, 187, 100);
		soldoutpanel.add(soldoutbt_0);

		JButton soldoutbt_1 = new JButton("메뉴 2 판매 상태");
		soldoutbt_1.setFont(new Font("나눔고딕", Font.PLAIN, 18));
		soldoutbt_1.setBackground(new Color(230, 230, 250));
		soldoutbt_1.setBounds(235, 75, 187, 100);
		soldoutpanel.add(soldoutbt_1);

		JButton soldoutbt_2 = new JButton("메뉴 3 판매 상태");
		soldoutbt_2.setFont(new Font("나눔고딕", Font.PLAIN, 18));
		soldoutbt_2.setBackground(new Color(230, 230, 250));
		soldoutbt_2.setBounds(12, 185, 187, 100);
		soldoutpanel.add(soldoutbt_2);

		JButton soldoutbt_3 = new JButton("메뉴 4 판매 상태");
		soldoutbt_3.setFont(new Font("나눔고딕", Font.PLAIN, 18));
		soldoutbt_3.setBackground(new Color(230, 230, 250));
		soldoutbt_3.setBounds(235, 185, 187, 100);
		soldoutpanel.add(soldoutbt_3);

		JButton soldoutbt_4 = new JButton("메뉴 5 판매 상태");
		soldoutbt_4.setFont(new Font("나눔고딕", Font.PLAIN, 18));
		soldoutbt_4.setBackground(new Color(230, 230, 250));
		soldoutbt_4.setBounds(12, 295, 187, 100);
		soldoutpanel.add(soldoutbt_4);

		JButton soldoutbt_5 = new JButton("메뉴 6 판매 상태");
		soldoutbt_5.setFont(new Font("나눔고딕", Font.PLAIN, 18));
		soldoutbt_5.setBackground(new Color(230, 230, 250));
		soldoutbt_5.setBounds(235, 295, 187, 100);
		soldoutpanel.add(soldoutbt_5);

		JButton soldoutbt_6 = new JButton("메뉴 7 판매 상태");
		soldoutbt_6.setFont(new Font("나눔고딕", Font.PLAIN, 18));
		soldoutbt_6.setBackground(new Color(230, 230, 250));
		soldoutbt_6.setBounds(12, 405, 187, 100);
		soldoutpanel.add(soldoutbt_6);

		JButton soldoutbt_7 = new JButton("메뉴 8 판매 상태");
		soldoutbt_7.setFont(new Font("나눔고딕", Font.PLAIN, 18));
		soldoutbt_7.setBackground(new Color(230, 230, 250));
		soldoutbt_7.setBounds(235, 405, 187, 100);
		soldoutpanel.add(soldoutbt_7);
		
		JButton soldoutback = new JButton("돌아가기");
		soldoutback.setBackground(new Color(224, 255, 255));
		soldoutback.setFont(new Font("나눔고딕", Font.PLAIN, 20));
		soldoutback.setBounds(12, 531, 410, 70);
		soldoutpanel.add(soldoutback);
		
		soldoutbt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				managerpanel.setVisible(false);
				soldoutpanel.setVisible(true);
			}
		});
		
		soldoutbt_0.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(soldoutbt_0.getText().equals("메뉴 1 판매 상태")) {
					soldoutbt_0.setText("메뉴 1 품절 상태");
					soldoutbt_0.setForeground(Color.RED);
					bt[0].setEnabled(false);
					}
					
		        else {
		        	soldoutbt_0.setText("메뉴 1 판매 상태");
		        	soldoutbt_0.setForeground(Color.black);
		        	bt[0].setEnabled(true);
		        }
			}
		});
		soldoutbt_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(soldoutbt_1.getText().equals("메뉴 2 판매 상태")) {
					soldoutbt_1.setText("메뉴 2 품절 상태");
					soldoutbt_1.setForeground(Color.RED);
					bt[1].setEnabled(false);
				}
		        else {
		        	soldoutbt_1.setText("메뉴 2 판매 상태");
		        	soldoutbt_1.setForeground(Color.black);
		        	bt[1].setEnabled(true);
		        }
			}
		});
		soldoutbt_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(soldoutbt_2.getText().equals("메뉴 3 판매 상태")) {
					soldoutbt_2.setText("메뉴 3 품절 상태");
					soldoutbt_2.setForeground(Color.RED);
					bt[2].setEnabled(false);
				}
		        else {
		        	soldoutbt_2.setText("메뉴 3 판매 상태");
		        	soldoutbt_2.setForeground(Color.black);
		        	bt[2].setEnabled(true);
		        }
			}
		});
		soldoutbt_3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(soldoutbt_3.getText().equals("메뉴 4 판매 상태")) {
					soldoutbt_3.setText("메뉴 4 품절 상태");
					soldoutbt_3.setForeground(Color.RED);
					bt[3].setEnabled(false);
				}
		        else {
		        	soldoutbt_3.setText("메뉴 4 판매 상태");
		        	soldoutbt_3.setForeground(Color.black);
		        	bt[3].setEnabled(true);
		        }
			}
		});
		soldoutbt_4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(soldoutbt_4.getText().equals("메뉴 5 판매 상태")) {
					soldoutbt_4.setText("메뉴 5 품절 상태");
					soldoutbt_4.setForeground(Color.RED);
					bt[4].setEnabled(false);
				}
		        else {
		        	soldoutbt_4.setText("메뉴 5 판매 상태");
		        	soldoutbt_4.setForeground(Color.black);
		        	bt[4].setEnabled(true);
		        }
			}
		});
		soldoutbt_5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(soldoutbt_5.getText().equals("메뉴 6 판매 상태")) {
					soldoutbt_5.setText("메뉴 6 품절 상태");
					soldoutbt_5.setForeground(Color.RED);
					bt[5].setEnabled(false);
				}
		        else {
		        	soldoutbt_5.setText("메뉴 6 판매 상태");
		        	soldoutbt_5.setForeground(Color.black);
		        	bt[5].setEnabled(true);
		        }
			}
		});
		soldoutbt_6.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(soldoutbt_6.getText().equals("메뉴 7 판매 상태")) {
					soldoutbt_6.setText("메뉴 7 품절 상태");
					soldoutbt_6.setForeground(Color.RED);
					bt[6].setEnabled(false);
				}
		        else {
		        	soldoutbt_6.setText("메뉴 7 판매 상태");
		        	soldoutbt_6.setForeground(Color.black);
		        	bt[6].setEnabled(true);
		        }
			}
		});
		
		soldoutbt_7.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(soldoutbt_7.getText().equals("메뉴 8 판매 상태")) {
					soldoutbt_7.setText("메뉴 8 품절 상태");
					soldoutbt_7.setForeground(Color.RED);	
					bt[7].setEnabled(false);
				}
		        else {
		        	soldoutbt_7.setText("메뉴 8 판매 상태");
		        	soldoutbt_7.setForeground(Color.black);
		        	bt[7].setEnabled(true);
		        }
			}
		});
		
		soldoutback.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				managerpanel.setVisible(true);
				soldoutpanel.setVisible(false);
			}
		});

		// 컴포넌트
		menuframe.getContentPane().add(menuprint);
		menuprint.setLayout(null);

		JTextPane textPane_1 = new JTextPane();
		textPane_1.setEditable(false);
		textPane_1.setText("떡갈비정식          떡갈비까스       떡갈비치즈카츠          골동면");
		textPane_1.setBackground(new Color(255, 255, 240));
		textPane_1.setFont(new Font("국립박물관문화재단클래식 Bold", Font.PLAIN, 18));
		textPane_1.setBounds(30, 12, 556, 28);
		menuprint.add(textPane_1);

		JTextPane textPane_1_1 = new JTextPane();
		textPane_1_1.setEditable(false);
		textPane_1_1.setText("계란볶음밥          로제떡볶이     패션후르츠에이드          음료");
		textPane_1_1.setFont(new Font("국립박물관문화재단클래식 Bold", Font.PLAIN, 18));
		textPane_1_1.setBackground(new Color(255, 255, 240));
		textPane_1_1.setBounds(30, 261, 556, 28);
		menuprint.add(textPane_1_1);
		menuframe.getContentPane().add(ta);
		menuframe.getContentPane().add(menuoption);

		JPanel cardpanel = new JPanel();
		cardpanel.setBackground(new Color(255, 255, 255));
		cardpanel.setBounds(0, 0, 984, 611);
		menuframe.getContentPane().add(cardpanel);
		cardpanel.setLayout(null);

		JTextArea amountmoney2 = new JTextArea();
		amountmoney2.setEditable(false);
		amountmoney2.setFont(new Font("을유1945 SemiBold", Font.PLAIN, 19));
		amountmoney2.setBorder(new TitledBorder(new LineBorder(Color.LIGHT_GRAY, 2)));
		amountmoney2.setBackground(Color.WHITE);
		amountmoney2.setBounds(37, 34, 486, 216);
		cardpanel.add(amountmoney2);

		JTextArea amountmoney3 = new JTextArea();
		amountmoney3.setEditable(false);
		amountmoney3.setFont(new Font("국립박물관문화재단클래식 Bold", Font.PLAIN, 35));
		amountmoney3.setBackground(Color.WHITE);
		amountmoney3.setBounds(588, 34, 337, 216);
		amountmoney3.setBorder(new TitledBorder(new LineBorder(Color.LIGHT_GRAY, 2)));
		cardpanel.add(amountmoney3);

		// 초기화 버튼
		bt2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < food.length; i++) {
					bt[i].setEnabled(true);
					minus[i].setEnabled(false);
					plus[i].setEnabled(false);
					suja[i].setText("0");
					ta.setText("   상품명              단가         수량      합계\r\n\r\n");
					amount = 0;
				}
			}
		});

		// bt3 닫기버튼

		bt3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				menuframe.setVisible(false);
				for (int i = 0; i < food.length; i++) {
					bt[i].setEnabled(true);
					minus[i].setEnabled(false);
					plus[i].setEnabled(false);
					suja[i].setText("0");
					ta.setText("   상품명              단가         수량      합계\r\n\r\n");
					amount = 0;
					where = 0;
				}

				if (tempseatnum == 1) {
					seatnum0 = 0;
					seatbtn_0.setEnabled(true);
					orderstate_0.setText("사용 가능");
				} else if (tempseatnum == 2) {
					seatnum1 = 0;
					seatbtn_1.setEnabled(true);
					orderstate_1.setText("사용 가능");
				} else if (tempseatnum == 3) {
					seatnum2 = 0;
					seatbtn_2.setEnabled(true);
					orderstate_2.setText("사용 가능");
				} else if (tempseatnum == 4) {
					seatnum3 = 0;
					seatbtn_3.setEnabled(true);
					orderstate_3.setText("사용 가능");
				} else if (tempseatnum == 5) {
					seatnum4 = 0;
					seatbtn_4.setEnabled(true);
					orderstate_4.setText("사용 가능");
				} else if (tempseatnum == 6) {
					seatnum5 = 0;
					seatbtn_5.setEnabled(true);
					orderstate_5.setText("사용 가능");
				} else if (tempseatnum == 7) {
					seatnum6 = 6;
					seatbtn_6.setEnabled(true);
					orderstate_6.setText("사용 가능");
				} else if (tempseatnum == 8) {
					seatnum7 = 7;
					seatbtn_7.setEnabled(true);
					orderstate_7.setText("사용 가능");
				}

				menuframe.dispose();

			}
		});

		JPanel moneypanel = new JPanel();
		moneypanel.setBackground(new Color(255, 255, 240));

		moneypanel.setVisible(false);

		JPanel xpanel = new JPanel();
		xpanel.setBackground(new Color(255, 255, 255));
		xpanel.setBounds(0, 0, 984, 611);
		xpanel.setBorder(new TitledBorder(new LineBorder(Color.LIGHT_GRAY, 2)));
		menuframe.getContentPane().add(xpanel);
		xpanel.setLayout(null);

		JButton moneypay = new JButton("현금");
		moneypay.setForeground(new Color(0, 0, 0));
		moneypay.setBackground(new Color(230, 230, 250));
		moneypay.setFont(new Font("국립박물관문화재단클래식 Bold", Font.PLAIN, 20));
		moneypay.setBounds(631, 511, 152, 90);
		xpanel.add(moneypay);

		JButton cardpay = new JButton("카드");
		cardpay.setBackground(new Color(230, 230, 250));
		cardpay.setFont(new Font("국립박물관문화재단클래식 Bold", Font.PLAIN, 20));
		cardpay.setBounds(820, 511, 152, 90);

		xpanel.add(cardpay);

		JTextField amounttext = new JTextField();
		amounttext.setEditable(false);
		amounttext.setBackground(new Color(255, 255, 240));
		amounttext.setFont(new Font("국립박물관문화재단클래식 Bold", Font.PLAIN, 28));
		amounttext.setBounds(613, 443, 371, 57);
		amounttext.setBorder(new TitledBorder(new LineBorder(Color.LIGHT_GRAY, 2)));

		xpanel.add(amounttext);

		moneypay.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				menuprint.setVisible(false);
				menuoption.setVisible(false);
				ta.setVisible(false);
				xpanel.setVisible(false);
				moneypanel.setVisible(true);

			}
		});

		moneypanel.setBackground(Color.WHITE);
		moneypanel.setBounds(0, 0, 984, 611);
		menuframe.getContentPane().add(moneypanel);
		moneypanel.setLayout(null);

		JTextArea amountmoney = new JTextArea();
		amountmoney.setEditable(false);
		amountmoney.setFont(new Font("을유1945 SemiBold", Font.PLAIN, 19));
		amountmoney.setBorder(new TitledBorder(new LineBorder(Color.LIGHT_GRAY, 2)));
		amountmoney.setBackground(Color.WHITE);
		amountmoney.setBounds(37, 34, 486, 216);
		moneypanel.add(amountmoney);

		JTextArea amountmoney1 = new JTextArea();
		amountmoney1.setEditable(false);
		amountmoney1.setFont(new Font("국립박물관문화재단클래식 Bold", Font.PLAIN, 35));
		amountmoney1.setBackground(Color.WHITE);
		amountmoney1.setBounds(588, 34, 337, 94);
		amountmoney1.setBorder(new TitledBorder(new LineBorder(Color.LIGHT_GRAY, 2)));
		moneypanel.add(amountmoney1);

		JButton onehund = new JButton("100원");
		onehund.setBackground(new Color(230, 230, 250));
		onehund.setFont(new Font("국립박물관문화재단클래식 Bold", Font.PLAIN, 25));
		onehund.setBounds(37, 281, 144, 117);

		JButton orderbtn_0 = new JButton("주문 1");
		orderbtn_0.setEnabled(false);
		orderbtn_0.setBackground(new Color(230, 230, 250));
		orderbtn_0.setFont(new Font("나눔고딕", Font.PLAIN, 18));
		orderbtn_0.setBounds(12, 75, 187, 100);
		managerpanel.add(orderbtn_0);

		JButton orderbtn_1 = new JButton("주문 2");
		orderbtn_1.setEnabled(false);
		orderbtn_1.setFont(new Font("나눔고딕", Font.PLAIN, 18));
		orderbtn_1.setBackground(new Color(230, 230, 250));
		orderbtn_1.setBounds(235, 75, 187, 100);
		managerpanel.add(orderbtn_1);

		JButton orderbtn_2 = new JButton("주문 3");
		orderbtn_2.setEnabled(false);
		orderbtn_2.setFont(new Font("나눔고딕", Font.PLAIN, 18));
		orderbtn_2.setBackground(new Color(230, 230, 250));
		orderbtn_2.setBounds(12, 185, 187, 100);
		managerpanel.add(orderbtn_2);

		JButton orderbtn_3 = new JButton("주문 4");
		orderbtn_3.setEnabled(false);
		orderbtn_3.setFont(new Font("나눔고딕", Font.PLAIN, 18));
		orderbtn_3.setBackground(new Color(230, 230, 250));
		orderbtn_3.setBounds(235, 185, 187, 100);
		managerpanel.add(orderbtn_3);

		JButton orderbtn_4 = new JButton("주문 5");
		orderbtn_4.setEnabled(false);
		orderbtn_4.setFont(new Font("나눔고딕", Font.PLAIN, 18));
		orderbtn_4.setBackground(new Color(230, 230, 250));
		orderbtn_4.setBounds(12, 295, 187, 100);
		managerpanel.add(orderbtn_4);

		JButton orderbtn_5 = new JButton("주문 6");
		orderbtn_5.setEnabled(false);
		orderbtn_5.setFont(new Font("나눔고딕", Font.PLAIN, 18));
		orderbtn_5.setBackground(new Color(230, 230, 250));
		orderbtn_5.setBounds(235, 295, 187, 100);
		managerpanel.add(orderbtn_5);

		JButton orderbtn_6 = new JButton("주문 7");
		orderbtn_6.setEnabled(false);
		orderbtn_6.setFont(new Font("나눔고딕", Font.PLAIN, 18));
		orderbtn_6.setBackground(new Color(230, 230, 250));
		orderbtn_6.setBounds(12, 405, 187, 100);
		managerpanel.add(orderbtn_6);

		JButton orderbtn_7 = new JButton("주문 8");
		orderbtn_7.setEnabled(false);
		orderbtn_7.setFont(new Font("나눔고딕", Font.PLAIN, 18));
		orderbtn_7.setBackground(new Color(230, 230, 250));
		orderbtn_7.setBounds(235, 405, 187, 100);
		managerpanel.add(orderbtn_7);

		JButton sales = new JButton("매출액/주문내역 확인");
		sales.setBackground(new Color(224, 255, 255));
		sales.setFont(new Font("나눔고딕", Font.BOLD, 14));
		sales.setBounds(12, 531, 169, 70);
		managerpanel.add(sales);

		JButton onoff = new JButton("매점 개/폐점");
		onoff.setBackground(new Color(224, 255, 255));
		onoff.setFont(new Font("나눔고딕", Font.BOLD, 14));
		onoff.setBounds(309, 531, 113, 70);
		managerpanel.add(onoff);

		JTextField textFieldd = new JTextField();
		textFieldd.setText("주방 / 카운터용 키오스크");
		textFieldd.setFont(new Font("나눔고딕", Font.BOLD, 22));
		textFieldd.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldd.setEditable(false);
		textFieldd.setBounds(12, 10, 410, 55);
		textFieldd.setBorder(new TitledBorder(new LineBorder(Color.LIGHT_GRAY, 2)));
		managerpanel.add(textFieldd);
		textFieldd.setColumns(10);

		JPanel salespanel = new JPanel();
		salespanel.setBounds(0, 0, 434, 611);
		salespanel.setBackground(new Color(255, 255, 240));
		managermode.getContentPane().add(salespanel);
		salespanel.setLayout(null);

		JTextField salestext = new JTextField();
		salestext.setText("총매출액 및 주문내역");
		salestext.setFont(new Font("나눔고딕", Font.BOLD, 22));
		salestext.setHorizontalAlignment(SwingConstants.CENTER);
		salestext.setEditable(false);
		salestext.setBounds(12, 10, 410, 55);
		salestext.setBorder(new TitledBorder(new LineBorder(Color.LIGHT_GRAY, 2)));
		salespanel.add(salestext);
		salestext.setColumns(10);

		JTextArea allorder = new JTextArea();
		JScrollPane scrollPane = new JScrollPane(allorder);

		allorder.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		allorder.setEditable(false);
		allorder.setBounds(12, 99, 410, 373);
		JScrollPane scroll = new JScrollPane(allorder);
		scroll.setBounds(12, 75, 410, 395);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

		salespanel.add(scroll);

		JTextField salestext_2 = new JTextField();
		salestext_2.setEditable(false);
		salestext_2.setBackground(Color.WHITE);
		salestext_2.setFont(new Font("나눔고딕", Font.PLAIN, 14));
		salestext_2.setBounds(12, 482, 410, 51);
		salespanel.add(salestext_2);
		salestext_2.setColumns(10);

		JButton orderback = new JButton("돌아가기");
		orderback.setBackground(new Color(224, 255, 255));
		orderback.setFont(new Font("나눔고딕", Font.PLAIN, 20));
		orderback.setBounds(12, 543, 410, 58);
		salespanel.add(orderback);

		JPanel orderpanel_0 = new JPanel();
		orderpanel_0.setBackground(new Color(255, 255, 240));
		orderpanel_0.setBounds(0, 0, 434, 611);
		managermode.getContentPane().add(orderpanel_0);
		orderpanel_0.setLayout(null);
		
		JTextArea ordertext_0 = new JTextArea();
		ordertext_0.setEditable(false);
		ordertext_0.setFont(new Font("나눔고딕", Font.PLAIN, 14));
		ordertext_0.setBounds(12, 181, 410, 361);
		ordertext_0.setBorder(new TitledBorder(new LineBorder(Color.BLACK, 1)));
		orderpanel_0.add(ordertext_0);

		JButton orderok_0 = new JButton("준비완료");
		orderok_0.setFont(new Font("나눔고딕", Font.PLAIN, 15));
		orderok_0.setBounds(12, 552, 177, 49);
		orderpanel_0.add(orderok_0);

		JButton ordernotok_0 = new JButton("돌아가기");
		ordernotok_0.setFont(new Font("나눔고딕", Font.PLAIN, 15));
		ordernotok_0.setBounds(245, 552, 177, 49);
		orderpanel_0.add(ordernotok_0);

		JTextField orderrrr_0 = new JTextField();
		orderrrr_0.setEditable(false);
		orderrrr_0.setHorizontalAlignment(SwingConstants.CENTER);
		orderrrr_0.setText("주문내역");
		orderrrr_0.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		orderrrr_0.setBounds(12, 10, 410, 43);
		orderpanel_0.add(orderrrr_0);
		orderrrr_0.setColumns(10);

		JTextField sebuorder_0 = new JTextField();
		sebuorder_0.setBackground(Color.WHITE);
		sebuorder_0.setEditable(false);
		sebuorder_0.setHorizontalAlignment(SwingConstants.CENTER);
		sebuorder_0.setFont(new Font("나눔고딕", Font.BOLD, 18));
		sebuorder_0.setBounds(12, 122, 410, 49);
		orderpanel_0.add(sebuorder_0);
		sebuorder_0.setColumns(10);
		
		JTextField oredertime_0 = new JTextField();
		oredertime_0.setBackground(Color.WHITE);
		oredertime_0.setEditable(false);
		oredertime_0.setHorizontalAlignment(SwingConstants.CENTER);
		oredertime_0.setFont(new Font("나눔고딕", Font.BOLD, 18));
		oredertime_0.setColumns(10);
		oredertime_0.setBounds(12, 63, 410, 49);
		orderpanel_0.add(oredertime_0);

		JPanel orderpanel_1 = new JPanel();
		orderpanel_1.setLayout(null);
		orderpanel_1.setBackground(new Color(255, 255, 240));
		orderpanel_1.setBounds(0, 0, 434, 611);
		managermode.getContentPane().add(orderpanel_1);

		JTextArea ordertext_1 = new JTextArea();
		ordertext_1.setFont(new Font("나눔고딕", Font.PLAIN, 14));
		ordertext_1.setEditable(false);
		ordertext_1.setBounds(12, 181, 410, 361);
		ordertext_1.setBorder(new TitledBorder(new LineBorder(Color.BLACK, 1)));
		orderpanel_1.add(ordertext_1);

		JButton orderok_1 = new JButton("준비완료");
		orderok_1.setFont(new Font("나눔고딕", Font.PLAIN, 15));
		orderok_1.setBounds(12, 552, 177, 49);
		orderpanel_1.add(orderok_1);

		JButton ordernotok_1 = new JButton("돌아가기");
		ordernotok_1.setFont(new Font("나눔고딕", Font.PLAIN, 15));
		ordernotok_1.setBounds(245, 552, 177, 49);
		orderpanel_1.add(ordernotok_1);

		JTextField orderrrr_1 = new JTextField();
		orderrrr_1.setText("주문내역");
		orderrrr_1.setHorizontalAlignment(SwingConstants.CENTER);
		orderrrr_1.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		orderrrr_1.setEditable(false);
		orderrrr_1.setColumns(10);
		orderrrr_1.setBounds(12, 10, 410, 43);
		orderpanel_1.add(orderrrr_1);

		JTextField sebuorder_1 = new JTextField();
		sebuorder_1.setBackground(Color.WHITE);
		sebuorder_1.setHorizontalAlignment(SwingConstants.CENTER);
		sebuorder_1.setEditable(false);
		sebuorder_1.setFont(new Font("나눔고딕", Font.BOLD, 18));
		sebuorder_1.setColumns(10);
		sebuorder_1.setBounds(12, 122, 410, 49);
		orderpanel_1.add(sebuorder_1);
		
		JTextField oredertime_1 = new JTextField();
		oredertime_1.setBackground(Color.WHITE);
		oredertime_1.setEditable(false);
		oredertime_1.setHorizontalAlignment(SwingConstants.CENTER);
		oredertime_1.setFont(new Font("나눔고딕", Font.BOLD, 18));
		oredertime_1.setColumns(10);
		oredertime_1.setBounds(12, 63, 410, 49);
		orderpanel_1.add(oredertime_1);

		JPanel orderpanel_2 = new JPanel();
		orderpanel_2.setLayout(null);
		orderpanel_2.setBackground(new Color(255, 255, 240));
		orderpanel_2.setBounds(0, 0, 434, 611);
		managermode.getContentPane().add(orderpanel_2);

		JTextArea ordertext_2 = new JTextArea();
		ordertext_2.setFont(new Font("나눔고딕", Font.PLAIN, 14));
		ordertext_2.setEditable(false);
		ordertext_2.setBounds(12, 181, 410, 361);
		ordertext_2.setBorder(new TitledBorder(new LineBorder(Color.BLACK, 1)));
		orderpanel_2.add(ordertext_2);

		JButton orderok_2 = new JButton("준비완료");
		orderok_2.setFont(new Font("나눔고딕", Font.PLAIN, 15));
		orderok_2.setBounds(12, 552, 177, 49);
		orderpanel_2.add(orderok_2);

		JButton ordernotok_2 = new JButton("돌아가기");
		ordernotok_2.setFont(new Font("나눔고딕", Font.PLAIN, 15));
		ordernotok_2.setBounds(245, 552, 177, 49);
		orderpanel_2.add(ordernotok_2);

		JTextField orderrrr_2 = new JTextField();
		orderrrr_2.setText("주문내역");
		orderrrr_2.setHorizontalAlignment(SwingConstants.CENTER);
		orderrrr_2.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		orderrrr_2.setEditable(false);
		orderrrr_2.setColumns(10);
		orderrrr_2.setBounds(12, 10, 410, 43);
		orderpanel_2.add(orderrrr_2);

		JTextField sebuorder_2 = new JTextField();
		sebuorder_2.setBackground(Color.WHITE);
		sebuorder_2.setHorizontalAlignment(SwingConstants.CENTER);
		sebuorder_2.setEditable(false);
		sebuorder_2.setFont(new Font("나눔고딕", Font.BOLD, 18));
		sebuorder_2.setColumns(10);
		sebuorder_2.setBounds(12, 122, 410, 49);
		orderpanel_2.add(sebuorder_2);
		
		JTextField oredertime_2 = new JTextField();
		oredertime_2.setBackground(Color.WHITE);
		oredertime_2.setEditable(false);
		oredertime_2.setHorizontalAlignment(SwingConstants.CENTER);
		oredertime_2.setFont(new Font("나눔고딕", Font.BOLD, 18));
		oredertime_2.setColumns(10);
		oredertime_2.setBounds(12, 63, 410, 49);
		orderpanel_2.add(oredertime_2);

		JPanel orderpanel_3 = new JPanel();
		orderpanel_3.setLayout(null);
		orderpanel_3.setBackground(new Color(255, 255, 240));
		orderpanel_3.setBounds(0, 0, 434, 611);
		managermode.getContentPane().add(orderpanel_3);

		JTextArea ordertext_3 = new JTextArea();
		ordertext_3.setFont(new Font("나눔고딕", Font.PLAIN, 14));
		ordertext_3.setEditable(false);
		ordertext_3.setBounds(12, 181, 410, 361);
		ordertext_3.setBorder(new TitledBorder(new LineBorder(Color.BLACK, 1)));
		orderpanel_3.add(ordertext_3);

		JButton orderok_3 = new JButton("준비완료");
		orderok_3.setFont(new Font("나눔고딕", Font.PLAIN, 15));
		orderok_3.setBounds(12, 552, 177, 49);
		orderpanel_3.add(orderok_3);

		JButton ordernotok_3 = new JButton("돌아가기");
		ordernotok_3.setFont(new Font("나눔고딕", Font.PLAIN, 15));
		ordernotok_3.setBounds(245, 552, 177, 49);
		orderpanel_3.add(ordernotok_3);

		JTextField orderrrr_3 = new JTextField();
		orderrrr_3.setText("주문내역");
		orderrrr_3.setHorizontalAlignment(SwingConstants.CENTER);
		orderrrr_3.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		orderrrr_3.setEditable(false);
		orderrrr_3.setColumns(10);
		orderrrr_3.setBounds(12, 10, 410, 43);
		orderpanel_3.add(orderrrr_3);

		JTextField sebuorder_3 = new JTextField();
		sebuorder_3.setBackground(Color.WHITE);
		sebuorder_3.setHorizontalAlignment(SwingConstants.CENTER);
		sebuorder_3.setFont(new Font("나눔고딕", Font.BOLD, 18));
		sebuorder_3.setEditable(false);
		sebuorder_3.setColumns(10);
		sebuorder_3.setBounds(12, 122, 410, 49);
		orderpanel_3.add(sebuorder_3);
		
		JTextField oredertime_3 = new JTextField();
		oredertime_3.setBackground(Color.WHITE);
		oredertime_3.setEditable(false);
		oredertime_3.setHorizontalAlignment(SwingConstants.CENTER);
		oredertime_3.setFont(new Font("나눔고딕", Font.BOLD, 18));
		oredertime_3.setColumns(10);
		oredertime_3.setBounds(12, 63, 410, 49);
		orderpanel_3.add(oredertime_3);

		JPanel orderpanel_4 = new JPanel();
		orderpanel_4.setLayout(null);
		orderpanel_4.setBackground(new Color(255, 255, 240));
		orderpanel_4.setBounds(0, 0, 434, 611);
		managermode.getContentPane().add(orderpanel_4);

		JTextArea ordertext_4 = new JTextArea();
		ordertext_4.setFont(new Font("나눔고딕", Font.PLAIN, 14));
		ordertext_4.setEditable(false);
		ordertext_4.setBounds(12, 181, 410, 361);
		ordertext_4.setBorder(new TitledBorder(new LineBorder(Color.BLACK, 1)));
		orderpanel_4.add(ordertext_4);

		JButton orderok_4 = new JButton("준비완료");
		orderok_4.setFont(new Font("나눔고딕", Font.PLAIN, 15));
		orderok_4.setBounds(12, 552, 177, 49);
		orderpanel_4.add(orderok_4);

		JButton ordernotok_4 = new JButton("돌아가기");
		ordernotok_4.setFont(new Font("나눔고딕", Font.PLAIN, 15));
		ordernotok_4.setBounds(245, 552, 177, 49);
		orderpanel_4.add(ordernotok_4);

		JTextField orderrrr_4 = new JTextField();
		orderrrr_4.setText("주문내역");
		orderrrr_4.setHorizontalAlignment(SwingConstants.CENTER);
		orderrrr_4.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		orderrrr_4.setEditable(false);
		orderrrr_4.setColumns(10);
		orderrrr_4.setBounds(12, 10, 410, 43);
		orderpanel_4.add(orderrrr_4);

		JTextField sebuorder_4 = new JTextField();
		sebuorder_4.setBackground(Color.WHITE);
		sebuorder_4.setHorizontalAlignment(SwingConstants.CENTER);
		sebuorder_4.setFont(new Font("나눔고딕", Font.BOLD, 18));
		sebuorder_4.setEditable(false);
		sebuorder_4.setColumns(10);
		sebuorder_4.setBounds(12, 122, 410, 49);
		orderpanel_4.add(sebuorder_4);
		
		JTextField oredertime_4 = new JTextField();
		oredertime_4.setBackground(Color.WHITE);
		oredertime_4.setEditable(false);
		oredertime_4.setHorizontalAlignment(SwingConstants.CENTER);
		oredertime_4.setFont(new Font("나눔고딕", Font.BOLD, 18));
		oredertime_4.setColumns(10);
		oredertime_4.setBounds(12, 63, 410, 49);
		orderpanel_4.add(oredertime_4);

		JPanel orderpanel_5 = new JPanel();
		orderpanel_5.setLayout(null);
		orderpanel_5.setBackground(new Color(255, 255, 240));
		orderpanel_5.setBounds(0, 0, 434, 611);
		managermode.getContentPane().add(orderpanel_5);

		JTextArea ordertext_5 = new JTextArea();
		ordertext_5.setFont(new Font("나눔고딕", Font.PLAIN, 14));
		ordertext_5.setEditable(false);
		ordertext_5.setBounds(12, 181, 410, 361);
		ordertext_5.setBorder(new TitledBorder(new LineBorder(Color.BLACK, 1)));
		orderpanel_5.add(ordertext_5);

		JButton orderok_5 = new JButton("준비완료");
		orderok_5.setFont(new Font("나눔고딕", Font.PLAIN, 15));
		orderok_5.setBounds(12, 552, 177, 49);
		orderpanel_5.add(orderok_5);

		JButton ordernotok_5 = new JButton("돌아가기");
		ordernotok_5.setFont(new Font("나눔고딕", Font.PLAIN, 15));
		ordernotok_5.setBounds(245, 552, 177, 49);
		orderpanel_5.add(ordernotok_5);

		JTextField orderrrr_5 = new JTextField();
		orderrrr_5.setText("주문내역");
		orderrrr_5.setHorizontalAlignment(SwingConstants.CENTER);
		orderrrr_5.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		orderrrr_5.setEditable(false);
		orderrrr_5.setColumns(10);
		orderrrr_5.setBounds(12, 10, 410, 43);
		orderpanel_5.add(orderrrr_5);

		JTextField sebuorder_5 = new JTextField();
		sebuorder_5.setBackground(Color.WHITE);
		sebuorder_5.setHorizontalAlignment(SwingConstants.CENTER);
		sebuorder_5.setFont(new Font("나눔고딕", Font.BOLD, 18));
		sebuorder_5.setEditable(false);
		sebuorder_5.setColumns(10);
		sebuorder_5.setBounds(12, 122, 410, 49);
		orderpanel_5.add(sebuorder_5);
		
		JTextField oredertime_5 = new JTextField();
		oredertime_5.setBackground(Color.WHITE);
		oredertime_5.setEditable(false);
		oredertime_5.setHorizontalAlignment(SwingConstants.CENTER);
		oredertime_5.setFont(new Font("나눔고딕", Font.BOLD, 18));
		oredertime_5.setColumns(10);
		oredertime_5.setBounds(12, 63, 410, 49);
		orderpanel_5.add(oredertime_5);

		JPanel orderpanel_6 = new JPanel();
		orderpanel_6.setLayout(null);
		orderpanel_6.setBackground(new Color(255, 255, 240));
		orderpanel_6.setBounds(0, 0, 434, 611);
		managermode.getContentPane().add(orderpanel_6);

		JTextArea ordertext_6 = new JTextArea();
		ordertext_6.setFont(new Font("나눔고딕", Font.PLAIN, 14));
		ordertext_6.setEditable(false);
		ordertext_6.setBounds(12, 181, 410, 361);
		ordertext_6.setBorder(new TitledBorder(new LineBorder(Color.BLACK, 1)));
		orderpanel_6.add(ordertext_6);

		JButton orderok_6 = new JButton("준비완료");
		orderok_6.setFont(new Font("나눔고딕", Font.PLAIN, 15));
		orderok_6.setBounds(12, 552, 177, 49);
		orderpanel_6.add(orderok_6);

		JButton ordernotok_6 = new JButton("돌아가기");
		ordernotok_6.setFont(new Font("나눔고딕", Font.PLAIN, 15));
		ordernotok_6.setBounds(245, 552, 177, 49);
		orderpanel_6.add(ordernotok_6);

		JTextField orderrrr_6 = new JTextField();
		orderrrr_6.setText("주문내역");
		orderrrr_6.setHorizontalAlignment(SwingConstants.CENTER);
		orderrrr_6.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		orderrrr_6.setEditable(false);
		orderrrr_6.setColumns(10);
		orderrrr_6.setBounds(12, 10, 410, 43);
		orderpanel_6.add(orderrrr_6);

		JTextField sebuorder_6 = new JTextField();
		sebuorder_6.setBackground(Color.WHITE);
		sebuorder_6.setHorizontalAlignment(SwingConstants.CENTER);
		sebuorder_6.setFont(new Font("나눔고딕", Font.BOLD, 18));
		sebuorder_6.setEditable(false);
		sebuorder_6.setColumns(10);
		sebuorder_6.setBounds(12, 122, 410, 49);
		orderpanel_6.add(sebuorder_6);
		
		JTextField oredertime_6 = new JTextField();
		oredertime_6.setBackground(Color.WHITE);
		oredertime_6.setEditable(false);
		oredertime_6.setHorizontalAlignment(SwingConstants.CENTER);
		oredertime_6.setFont(new Font("나눔고딕", Font.BOLD, 18));
		oredertime_6.setColumns(10);
		oredertime_6.setBounds(12, 63, 410, 49);
		orderpanel_6.add(oredertime_6);

		JPanel orderpanel_7 = new JPanel();
		orderpanel_7.setLayout(null);
		orderpanel_7.setBackground(new Color(255, 255, 240));
		orderpanel_7.setBounds(0, 0, 434, 611);
		managermode.getContentPane().add(orderpanel_7);

		JTextArea ordertext_7 = new JTextArea();
		ordertext_7.setFont(new Font("나눔고딕", Font.PLAIN, 14));
		ordertext_7.setEditable(false);
		ordertext_7.setBounds(12, 181, 410, 361);
		ordertext_7.setBorder(new TitledBorder(new LineBorder(Color.BLACK, 1)));
		orderpanel_7.add(ordertext_7);

		JButton orderok_7 = new JButton("준비완료");
		orderok_7.setFont(new Font("나눔고딕", Font.PLAIN, 15));
		orderok_7.setBounds(12, 552, 177, 49);
		orderpanel_7.add(orderok_7);

		JButton ordernotok_7 = new JButton("돌아가기");
		ordernotok_7.setFont(new Font("나눔고딕", Font.PLAIN, 15));
		ordernotok_7.setBounds(245, 552, 177, 49);
		orderpanel_7.add(ordernotok_7);

		JTextField orderrrr_7 = new JTextField();
		orderrrr_7.setText("주문내역");
		orderrrr_7.setHorizontalAlignment(SwingConstants.CENTER);
		orderrrr_7.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		orderrrr_7.setEditable(false);
		orderrrr_7.setColumns(10);
		orderrrr_7.setBounds(12, 10, 410, 43);
		orderpanel_7.add(orderrrr_7);

		JTextField sebuorder_7 = new JTextField();
		sebuorder_7.setBackground(Color.WHITE);
		sebuorder_7.setHorizontalAlignment(SwingConstants.CENTER);
		sebuorder_7.setFont(new Font("나눔고딕", Font.BOLD, 18));
		sebuorder_7.setEditable(false);
		sebuorder_7.setColumns(10);
		sebuorder_7.setBounds(12, 122, 410, 49);
		orderpanel_7.add(sebuorder_7);
		
		JTextField oredertime_7 = new JTextField();
		oredertime_7.setBackground(Color.WHITE);
		oredertime_7.setEditable(false);
		oredertime_7.setHorizontalAlignment(SwingConstants.CENTER);
		oredertime_7.setFont(new Font("나눔고딕", Font.BOLD, 18));
		oredertime_7.setColumns(10);
		oredertime_7.setBounds(12, 63, 410, 49);
		orderpanel_7.add(oredertime_7);
		// --

		orderback.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				managerpanel.setVisible(true);
				salespanel.setVisible(false);
			}
		});

		sales.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				managerpanel.setVisible(false);
				salespanel.setVisible(true);
			}
		});

		for (int i = 0; i < food.length; i++) {
			int j = i;

			bt[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					minus[j].setEnabled(true);
					plus[j].setEnabled(true);
					bt[j].setEnabled(false);
					ok[j].setEnabled(true);

					count = 0;
				}
			});

			minus[i].addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					if (count > 0) {
						count = count - 1;
						suja[j].setText(count + "");
						ok[j].setEnabled(true);

					} else {
						minus[j].setEnabled(false);
					}
				}
			});

			plus[i].addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					count = count + 1;
					suja[j].setText(count + "");
					ok[j].setEnabled(true);
					if (count > 0) {
						minus[j].setEnabled(true);
					}
				}
			});

			ok[i].addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					show = bt[j].getActionCommand();

					if (count > 0) {
						amount += price[j] * count;
					}

					amounttext.setText(" 총액 : " + amount + "원");

					amountmoney.append("   " + show + "       " + price[j] + "        " + count + "         "
							+ price[j] * count + "원" + "\n");
					amountmoney2.append("   " + show + "       " + price[j] + "        " + count + "         "
							+ price[j] * count + "원" + "\n");
					amountmoney1.setText("결제할 금액\n" + amount + "원");
					amountmoney3.setText("결제할 금액\n" + amount + "원");

					ta.append("   " + show + "       " + price[j] + "        " + count + "         " + price[j] * count
							+ "원" + "\n");

					ok[j].setEnabled(false);
				}
			});
		}

		JTextArea nowmoney = new JTextArea();
		nowmoney.setEditable(false);
		nowmoney.setFont(new Font("국립박물관문화재단클래식 Bold", Font.PLAIN, 35));
		nowmoney.setBorder(new TitledBorder(new LineBorder(Color.LIGHT_GRAY, 2)));
		nowmoney.setBackground(Color.WHITE);
		nowmoney.setBounds(588, 156, 337, 94);
		moneypanel.add(nowmoney);

		onehund.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				clickamount = clickamount + 100;
				nowmoney.setText("");
				nowmoney.append("입금된 금액 \n");
				nowmoney.append(clickamount + "원");
				if (clickamount >= amount) {
					moneypayment.setEnabled(true);
				}
			}
		});

		moneypanel.add(onehund);

		JButton fivethousand = new JButton("5000원");
		fivethousand.setBackground(new Color(230, 230, 250));
		fivethousand.setFont(new Font("국립박물관문화재단클래식 Bold", Font.PLAIN, 25));
		fivethousand.setBounds(37, 434, 144, 117);

		fivethousand.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				clickamount = clickamount + 5000;
				nowmoney.setText("");
				nowmoney.append("입금된 금액 \n");
				nowmoney.append(clickamount + "원");
				if (clickamount >= amount) {
					moneypayment.setEnabled(true);
				}
			}
		});

		moneypanel.add(fivethousand);

		JButton fivehund = new JButton("500원");
		fivehund.setBackground(new Color(230, 230, 250));
		fivehund.setFont(new Font("국립박물관문화재단클래식 Bold", Font.PLAIN, 25));
		fivehund.setBounds(209, 281, 144, 117);
		fivehund.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				clickamount = clickamount + 500;
				nowmoney.setText("");
				nowmoney.append("입금된 금액 \n");
				nowmoney.append(clickamount + "원");
				if (clickamount >= amount) {
					moneypayment.setEnabled(true);
				}
			}
		});
		moneypanel.add(fivehund);

		JButton thousand = new JButton("1000원");
		thousand.setBackground(new Color(230, 230, 250));
		thousand.setFont(new Font("국립박물관문화재단클래식 Bold", Font.PLAIN, 25));
		thousand.setBounds(379, 281, 144, 117);
		thousand.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				clickamount = clickamount + 1000;
				nowmoney.setText("");
				nowmoney.append("입금된 금액 \n");
				nowmoney.append(clickamount + "원");
				if (clickamount >= amount) {
					moneypayment.setEnabled(true);
				}
			}
		});
		moneypanel.add(thousand);

		JButton tenthousand = new JButton("10000원");
		tenthousand.setBackground(new Color(230, 230, 250));
		tenthousand.setFont(new Font("국립박물관문화재단클래식 Bold", Font.PLAIN, 25));
		tenthousand.setBounds(209, 434, 144, 117);
		tenthousand.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				clickamount = clickamount + 10000;
				nowmoney.setText("");
				nowmoney.append("입금된 금액 \n");
				nowmoney.append(clickamount + "원");
				if (clickamount >= amount) {
					moneypayment.setEnabled(true);
				}
			}
		});
		moneypanel.add(tenthousand);

		JButton fiftythousand = new JButton("50000원");
		fiftythousand.setBackground(new Color(230, 230, 250));
		fiftythousand.setFont(new Font("국립박물관문화재단클래식 Bold", Font.PLAIN, 25));
		fiftythousand.setBounds(379, 434, 144, 117);

		fiftythousand.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				clickamount = clickamount + 50000;
				nowmoney.setText("");
				nowmoney.append("입금된 금액 \n");
				nowmoney.append(clickamount + "원");
				if (clickamount >= amount) {
					moneypayment.setEnabled(true);
				}
			}
		});
		moneypanel.add(fiftythousand);

		moneypayment.setBackground(new Color(230, 230, 250));
		moneypayment.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				xpanel.setVisible(true);
				menuprint.setVisible(true);
				menuoption.setVisible(true);
				ta.setVisible(true);
				moneypanel.setVisible(false);
				moneypayment.setEnabled(false);
				num += 1;
				salesmoney += amount;
				Calendar timee = Calendar.getInstance();
				String tempformat_time = temporderformat.format(timee.getTime());
				if (where == 1) {
					JOptionPane.showMessageDialog(main, "주문시각 : "+ tempformat_time + "\n"+ta.getText() + "주문번호 : " + num + "번 (매장), 자리 " + tempseatnum
							+ "번\n" + "주문되었습니다. \n이용해 주셔서 감사합니다. \n\n거스름돈 : " + (clickamount - amount) + "원");
					allorder.append("   "+tempformat_time+"\n   주문번호 " + num + "번, 매장, 자리 " + tempseatnum + "번, 현금계산\n\n");
					allorder.append(ta.getText());
					allorder.append("────────────────────────────────\n");
					salestext_2.setText(" 총매출액 : " + salesmoney);

					try {

						// 파일 객체 생성
						File file = new File(fileName);

						// true 지정시 파일의 기존 내용에 이어서 작성
						FileWriter fw = new FileWriter(file, true);

						// 파일안에 문자열 쓰기
						fw.write("   "+tempformat_time+"\n   주문번호 : " + num + "번 / 매장\n\n" + ta.getText() + "\n   ※누적 총매출액 : " + salesmoney
								+ "원\n───────────────────────\n");
						fw.flush();

						// 객체 닫기
						fw.close();

					} catch (Exception e1) {
						e1.printStackTrace();
					}

					if (orderbtn0 == 0) {
						sebuorder_0.setText("주문번호 : " + num + "번 / 매장, 자리 " + tempseatnum + "번");
						ordertext_0.append(ta.getText() + "\n");
						orderbtn_0.setEnabled(true);
						oredertime_0.setText(tempformat_time);
						JOptionPane.showMessageDialog(managermode, tempformat_time+"\n주문 1번 버튼에 주문이 들어왔습니다!");
						orderbtn0 = 1;
						ordernum0 = num;
					} else if (orderbtn1 == 0) {
						sebuorder_1.setText("주문번호 : " + num + "번 / 매장, 자리 " + tempseatnum + "번");
						ordertext_1.append(ta.getText() + "\n");
						orderbtn_1.setEnabled(true);
						oredertime_1.setText(tempformat_time);
						JOptionPane.showMessageDialog(managermode, tempformat_time+ "\n주문 2번 버튼에 주문이 들어왔습니다!");
						orderbtn1 = 1;
						ordernum1 = num;
					} else if (orderbtn2 == 0) {
						sebuorder_2.setText("주문번호 : " + num + "번 / 매장, 자리 " + tempseatnum + "번");
						ordertext_2.append(ta.getText() + "\n");
						orderbtn_2.setEnabled(true);
						oredertime_2.setText(tempformat_time);
						JOptionPane.showMessageDialog(managermode,tempformat_time+ "\n주문 3번 버튼에 주문이 들어왔습니다!");
						orderbtn2 = 1;
						ordernum2 = num;
					} else if (orderbtn3 == 0) {
						sebuorder_3.setText("주문번호 : " + num + "번 / 매장, 자리 " + tempseatnum + "번");
						ordertext_3.append(ta.getText() + "\n");
						orderbtn_3.setEnabled(true);
						oredertime_3.setText(tempformat_time);
						JOptionPane.showMessageDialog(managermode,tempformat_time+ "\n주문 4번 버튼에 주문이 들어왔습니다!");
						orderbtn3 = 1;
						ordernum3 = num;
					} else if (orderbtn4 == 0) {
						sebuorder_4.setText("주문번호 : " + num + "번 / 매장, 자리 " + tempseatnum + "번");
						ordertext_4.append(ta.getText() + "\n");
						orderbtn_4.setEnabled(true);
						oredertime_4.setText(tempformat_time);
						JOptionPane.showMessageDialog(managermode, tempformat_time+"\n주문 5번 버튼에 주문이 들어왔습니다!");
						orderbtn4 = 1;
						ordernum4 = num;
					} else if (orderbtn5 == 0) {
						sebuorder_5.setText("주문번호 : " + num + "번 / 매장, 자리 " + tempseatnum + "번");
						ordertext_5.append(ta.getText() + "\n");
						orderbtn_5.setEnabled(true);
						oredertime_5.setText(tempformat_time);
						JOptionPane.showMessageDialog(managermode, tempformat_time+"\n주문 6번 버튼에 주문이 들어왔습니다!");
						orderbtn5 = 1;
						ordernum5 = num;
					} else if (orderbtn6 == 0) {
						sebuorder_6.setText("주문번호 : " + num + "번 / 매장, 자리 " + tempseatnum + "번");
						ordertext_6.append(ta.getText() + "\n");
						orderbtn_6.setEnabled(true);
						oredertime_6.setText(tempformat_time);
						JOptionPane.showMessageDialog(managermode, tempformat_time+"\n주문 7번 버튼에 주문이 들어왔습니다!");
						orderbtn6 = 1;
						ordernum6 = num;
					} else if (orderbtn7 == 0) {
						sebuorder_7.setText("주문번호 : " + num + "번 / 매장, 자리 " + tempseatnum + "번");
						ordertext_7.append(ta.getText() + "\n");
						orderbtn_7.setEnabled(true);
						oredertime_7.setText(tempformat_time);
						JOptionPane.showMessageDialog(managermode, tempformat_time+"\n주문 8번 버튼에 주문이 들어왔습니다!");
						orderbtn7 = 1;
						ordernum7 = num;
					} else {
						JOptionPane.showMessageDialog(main, "주문 밀렸습니다. 관리자에게 문의하세요.");
						if (tempseatnum == 1) {
							seatnum0 = 0;
							seatbtn_0.setEnabled(true);
							orderstate_0.setText("사용 가능");
						} else if (tempseatnum == 2) {
							seatnum1 = 0;
							seatbtn_1.setEnabled(true);
							orderstate_1.setText("사용 가능");
						} else if (tempseatnum == 3) {
							seatnum2 = 0;
							seatbtn_2.setEnabled(true);
							orderstate_2.setText("사용 가능");
						} else if (tempseatnum == 4) {
							seatnum3 = 0;
							seatbtn_3.setEnabled(true);
							orderstate_3.setText("사용 가능");
						} else if (tempseatnum == 5) {
							seatnum4 = 0;
							seatbtn_4.setEnabled(true);
							orderstate_4.setText("사용 가능");
						} else if (tempseatnum == 6) {
							seatnum5 = 0;
							seatbtn_5.setEnabled(true);
							orderstate_5.setText("사용 가능");
						} else if (tempseatnum == 7) {
							seatnum6 = 6;
							seatbtn_6.setEnabled(true);
							orderstate_6.setText("사용 가능");
						} else if (tempseatnum == 8) {
							seatnum7 = 7;
							seatbtn_7.setEnabled(true);
							orderstate_7.setText("사용 가능");
						}
					}
				}

				else if (where == 2) {
					JOptionPane.showMessageDialog(main, "주문시각 : "+ tempformat_time + "\n"+ta.getText() + "주문번호 : " + num + "번 (포장)\n"
							+ "주문되었습니다. \n이용해 주셔서 감사합니다. \n\n거스름돈 : " + (clickamount - amount) + "원");
					allorder.append("   "+tempformat_time+"\n   주문번호 " + num + "번, 포장 / 현금계산\n\n");
					allorder.append(ta.getText());
					allorder.append("────────────────────────────────\n");
					salestext_2.setText(" 총매출액 : " + salesmoney);

					try {

						// 파일 객체 생성
						File file = new File(fileName);

						// true 지정 시 파일의 기존 내용에 이어서 작성
						FileWriter fw = new FileWriter(file, true);

						// 파일 안에 문자열 쓰기
						fw.write("   "+tempformat_time+"\n   주문번호 : " + num + "번 / 포장\n\n" + ta.getText() + "\n   ※누적 총매출액 : " + salesmoney
								+ "원\n───────────────────────\n");
						fw.flush();

						// 객체 닫기
						fw.close();

					} catch (Exception e1) {
						e1.printStackTrace();
					}

					if (orderbtn0 == 0) {
						sebuorder_0.setText("주문번호 : " + num + "번 / 포장");
						ordertext_0.append(ta.getText() + "\n");
						orderbtn_0.setEnabled(true);
						oredertime_0.setText(tempformat_time);
						JOptionPane.showMessageDialog(managermode, tempformat_time+"\n주문 1번 버튼에 주문이 들어왔습니다!");
						orderbtn0 = 1;
						ordernum0 = num;
					} else if (orderbtn1 == 0) {
						sebuorder_1.setText("주문번호 : " + num + "번 / 포장");
						ordertext_1.append(ta.getText() + "\n");
						orderbtn_1.setEnabled(true);
						oredertime_1.setText(tempformat_time);
						JOptionPane.showMessageDialog(managermode, tempformat_time+"\n주문 2번 버튼에 주문이 들어왔습니다!");
						orderbtn1 = 1;
						ordernum1 = num;
					} else if (orderbtn2 == 0) {
						sebuorder_2.setText("주문번호 : " + num + "번 / 포장");
						ordertext_2.append(ta.getText() + "\n");
						orderbtn_2.setEnabled(true);
						oredertime_2.setText(tempformat_time);
						JOptionPane.showMessageDialog(managermode, tempformat_time+"\n주문 3번 버튼에 주문이 들어왔습니다!");
						orderbtn2 = 1;
						ordernum2 = num;
					} else if (orderbtn3 == 0) {
						sebuorder_3.setText("주문번호 : " + num + "번 / 포장");
						ordertext_3.append(ta.getText() + "\n");
						orderbtn_3.setEnabled(true);
						oredertime_3.setText(tempformat_time);
						JOptionPane.showMessageDialog(managermode, tempformat_time+"\n주문 4번 버튼에 주문이 들어왔습니다!");
						orderbtn3 = 1;
						ordernum3 = num;
					} else if (orderbtn4 == 0) {
						sebuorder_4.setText("주문번호 : " + num + "번 / 포장");
						ordertext_4.append(ta.getText() + "\n");
						orderbtn_4.setEnabled(true);
						oredertime_4.setText(tempformat_time);
						JOptionPane.showMessageDialog(managermode, tempformat_time+"\n주문 5번 버튼에 주문이 들어왔습니다!");
						orderbtn4 = 1;
						ordernum4 = num;
					} else if (orderbtn5 == 0) {
						sebuorder_5.setText("주문번호 : " + num + "번 / 포장");
						ordertext_5.append(ta.getText() + "\n");
						orderbtn_5.setEnabled(true);
						oredertime_5.setText(tempformat_time);
						JOptionPane.showMessageDialog(managermode, tempformat_time+"\n주문 6번 버튼에 주문이 들어왔습니다!");
						orderbtn5 = 1;
						ordernum5 = num;
					} else if (orderbtn6 == 0) {
						sebuorder_6.setText("주문번호 : " + num + "번 / 포장");
						ordertext_6.append(ta.getText() + "\n");
						orderbtn_6.setEnabled(true);
						oredertime_6.setText(tempformat_time);
						JOptionPane.showMessageDialog(managermode, tempformat_time+"\n주문 7번 버튼에 주문이 들어왔습니다!");
						orderbtn6 = 1;
						ordernum6 = num;
					} else if (orderbtn7 == 0) {
						sebuorder_7.setText("주문번호 : " + num + "번 / 포장");
						ordertext_7.append(ta.getText() + "\n");
						orderbtn_7.setEnabled(true);
						oredertime_7.setText(tempformat_time);
						JOptionPane.showMessageDialog(managermode, tempformat_time+"\n주문 8번 버튼에 주문이 들어왔습니다!");
						orderbtn7 = 1;
						ordernum7 = num;
					} else {
						JOptionPane.showMessageDialog(main, "주문 밀렸습니다. 관리자에게 문의하세요.");
						if (tempseatnum == 1) {
							seatnum0 = 0;
							seatbtn_0.setEnabled(true);
							orderstate_0.setText("사용 가능");
						} else if (tempseatnum == 2) {
							seatnum1 = 0;
							seatbtn_1.setEnabled(true);
							orderstate_1.setText("사용 가능");
						} else if (tempseatnum == 3) {
							seatnum2 = 0;
							seatbtn_2.setEnabled(true);
							orderstate_2.setText("사용 가능");
						} else if (tempseatnum == 4) {
							seatnum3 = 0;
							seatbtn_3.setEnabled(true);
							orderstate_3.setText("사용 가능");
						} else if (tempseatnum == 5) {
							seatnum4 = 0;
							seatbtn_4.setEnabled(true);
							orderstate_4.setText("사용 가능");
						} else if (tempseatnum == 6) {
							seatnum5 = 0;
							seatbtn_5.setEnabled(true);
							orderstate_5.setText("사용 가능");
						} else if (tempseatnum == 7) {
							seatnum6 = 6;
							seatbtn_6.setEnabled(true);
							orderstate_6.setText("사용 가능");
						} else if (tempseatnum == 8) {
							seatnum7 = 7;
							seatbtn_7.setEnabled(true);
							orderstate_7.setText("사용 가능");
						}
					}
				}

				amount = 0;
				where = 0;
				clickamount = 0;

				for (int i = 0; i < food.length; i++) {
					bt[i].setEnabled(true);
					minus[i].setEnabled(false);
					plus[i].setEnabled(false);
					suja[i].setText("0");

					amountmoney1.setText("0");
					amounttext.setText(" 총액 : 0원\n");
					amountmoney.setText("");
					amountmoney1.setText("결제할 금액\n" + "0원");
					nowmoney.setText("입금된 금액 \n");
					ta.setText("   상품명              단가         수량      합계\r\n\r\n");
				}

				menuframe.dispose();
			}
		});
		moneypanel.add(moneypayment);

		JButton moneycancel = new JButton("취소");
		moneycancel.setBackground(new Color(230, 230, 250));
		moneycancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				menuprint.setVisible(true);
				menuoption.setVisible(true);
				ta.setVisible(true);
				xpanel.setVisible(true);
				moneypanel.setVisible(false);
				moneypayment.setEnabled(false);
				amount = 0;
				where = 0;
				clickamount = 0;
				for (int i = 0; i < food.length; i++) {
					bt[i].setEnabled(true);
					minus[i].setEnabled(false);
					plus[i].setEnabled(false);
					suja[i].setText("0");
					amountmoney1.setText("0");
					amounttext.setText(" 총액 : 0원\n");
					amountmoney.setText("");
					amountmoney1.setText("결제할 금액\n" + "0원");
					nowmoney.setText("입금된 금액 \n");
					ta.setText("   상품명              단가         수량      합계\r\n\r\n");

				}

				if (tempseatnum == 1) {
					seatnum0 = 0;
					seatbtn_0.setEnabled(true);
					orderstate_0.setText("사용 가능");
				} else if (tempseatnum == 2) {
					seatnum1 = 0;
					seatbtn_1.setEnabled(true);
					orderstate_1.setText("사용 가능");
				} else if (tempseatnum == 3) {
					seatnum2 = 0;
					seatbtn_2.setEnabled(true);
					orderstate_2.setText("사용 가능");
				} else if (tempseatnum == 4) {
					seatnum3 = 0;
					seatbtn_3.setEnabled(true);
					orderstate_3.setText("사용 가능");
				} else if (tempseatnum == 5) {
					seatnum4 = 0;
					seatbtn_4.setEnabled(true);
					orderstate_4.setText("사용 가능");
				} else if (tempseatnum == 6) {
					seatnum5 = 0;
					seatbtn_5.setEnabled(true);
					orderstate_5.setText("사용 가능");
				} else if (tempseatnum == 7) {
					seatnum6 = 6;
					seatbtn_6.setEnabled(true);
					orderstate_6.setText("사용 가능");
				} else if (tempseatnum == 8) {
					seatnum7 = 7;
					seatbtn_7.setEnabled(true);
					orderstate_7.setText("사용 가능");
				}

				menuframe.dispose();

			}
		});

		moneycancel.setFont(new Font("국립박물관문화재단클래식 Bold", Font.PLAIN, 50));
		moneycancel.setBounds(770, 281, 156, 270);
		moneypanel.add(moneycancel);

		JButton cardpayment = new JButton("결제");
		cardpayment.setBackground(new Color(230, 230, 250));
		cardpayment.setFont(new Font("국립박물관문화재단클래식 Bold", Font.PLAIN, 30));
		cardpayment.setBounds(588, 315, 155, 249);
		cardpanel.add(cardpayment);

		JButton cardcancel = new JButton("취소\r\n");
		cardcancel.setBackground(new Color(230, 230, 250));
		cardcancel.setFont(new Font("국립박물관문화재단클래식 Bold", Font.PLAIN, 30));
		cardcancel.setBounds(770, 315, 155, 249);
		cardpanel.add(cardcancel);

		JComboBox cardcombobox = new JComboBox();
		cardcombobox.setModel(new DefaultComboBoxModel(new String[] { "농협", "국민", "하나", "신한", "기업", "우리", "카카오" }));
		cardcombobox.setFont(new Font("나눔고딕", Font.PLAIN, 12));
		cardcombobox.setBounds(122, 286, 109, 20);
		cardpanel.add(cardcombobox);

		JLabel lblNewLabel = new JLabel("- 카드사");
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setBackground(Color.BLACK);
		lblNewLabel.setFont(new Font("나눔고딕", Font.PLAIN, 14));
		lblNewLabel.setBounds(37, 285, 73, 20);
		cardpanel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("- 카드번호");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setFont(new Font("나눔고딕", Font.PLAIN, 14));
		lblNewLabel_1.setBackground(Color.BLACK);
		lblNewLabel_1.setBounds(37, 315, 73, 20);
		cardpanel.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("- CVC번호");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1.setFont(new Font("나눔고딕", Font.PLAIN, 14));
		lblNewLabel_1_1.setBackground(Color.BLACK);
		lblNewLabel_1_1.setBounds(37, 345, 73, 20);
		cardpanel.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_1_1 = new JLabel("- 비밀번호");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1_1.setFont(new Font("나눔고딕", Font.PLAIN, 14));
		lblNewLabel_1_1_1.setBackground(Color.BLACK);
		lblNewLabel_1_1_1.setBounds(37, 375, 73, 20);
		cardpanel.add(lblNewLabel_1_1_1);

		textField_1 = new JTextField();
		textField_1.setFont(new Font("나눔고딕", Font.PLAIN, 12));
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setBounds(122, 316, 61, 21);
		cardpanel.add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setFont(new Font("나눔고딕", Font.PLAIN, 12));
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setColumns(10);
		textField_2.setBounds(195, 316, 61, 21);
		cardpanel.add(textField_2);

		textField_3 = new JTextField();
		textField_3.setFont(new Font("나눔고딕", Font.PLAIN, 12));
		textField_3.setHorizontalAlignment(SwingConstants.CENTER);
		textField_3.setColumns(10);
		textField_3.setBounds(268, 316, 61, 21);
		cardpanel.add(textField_3);

		textField_4 = new JTextField();
		textField_4.setFont(new Font("나눔고딕", Font.PLAIN, 12));
		textField_4.setHorizontalAlignment(SwingConstants.CENTER);
		textField_4.setColumns(10);
		textField_4.setBounds(341, 316, 61, 21);
		cardpanel.add(textField_4);

		textField_5 = new JTextField();
		textField_5.setHorizontalAlignment(SwingConstants.CENTER);
		textField_5.setFont(new Font("나눔고딕", Font.PLAIN, 12));
		textField_5.setColumns(10);
		textField_5.setBounds(122, 346, 61, 21);
		cardpanel.add(textField_5);

		textField_6 = new JTextField();
		textField_6.setHorizontalAlignment(SwingConstants.CENTER);
		textField_6.setFont(new Font("나눔고딕", Font.PLAIN, 12));
		textField_6.setColumns(10);
		textField_6.setBounds(122, 376, 32, 21);
		cardpanel.add(textField_6);

		cardpay.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				menuprint.setVisible(false);
				menuoption.setVisible(false);
				ta.setVisible(false);
				xpanel.setVisible(false);
				cardpanel.setVisible(true);
			}
		});

		JTextPane textPane = new JTextPane();
		textPane.setFont(new Font("나눔고딕", Font.PLAIN, 12));
		textPane.setText("●●");
		textPane.setEditable(false);
		textPane.setBounds(155, 376, 25, 21);
		cardpanel.add(textPane);

		cardpayment.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				xpanel.setVisible(true);
				menuprint.setVisible(true);
				menuoption.setVisible(true);
				ta.setVisible(true);
				cardpanel.setVisible(false);
				num += 1;
				salesmoney += amount;
				Calendar timee = Calendar.getInstance();
				String tempformat_time = temporderformat.format(timee.getTime());

				if (where == 1) {
					JOptionPane.showMessageDialog(main, "주문시각 : "+ tempformat_time + "\n"+ta.getText() + "주문번호 : " + num + "번 (매장), 자리 " + tempseatnum
							+ "번\n" + "주문되었습니다. \n이용해 주셔서 감사합니다. \n\n");
					allorder.append("   "+tempformat_time+"\n   주문번호 " + num + "번, 매장, 자리 " + tempseatnum + "번, 카드계산\n\n");
					allorder.append(ta.getText());
					allorder.append("────────────────────────────────\n");
					salestext_2.setText(" 총매출액 : " + salesmoney);

					try {

						// 파일 객체 생성
						File file = new File(fileName);

						// true 지정시 파일의 기존 내용에 이어서 작성
						FileWriter fw = new FileWriter(file, true);

						// 파일안에 문자열 쓰기
						fw.write("   "+tempformat_time+"\n   주문번호 : " + num + "번 / 매장\n\n" + ta.getText() + "\n   ※누적 총매출액 : " + salesmoney
								+ "원\n───────────────────────\n");
						fw.flush();

						// 객체 닫기
						fw.close();

					} catch (Exception e1) {
						e1.printStackTrace();
					}

					if (orderbtn0 == 0) {
						sebuorder_0.setText("주문번호 : " + num + "번 / 매장, 자리 " + tempseatnum + "번");
						ordertext_0.append(ta.getText() + "\n");
						orderbtn_0.setEnabled(true);
						oredertime_0.setText(tempformat_time);
						JOptionPane.showMessageDialog(managermode, tempformat_time+"\n주문 1번 버튼에 주문이 들어왔습니다!");
						orderbtn0 = 1;
						ordernum0 = num;
					} else if (orderbtn1 == 0) {
						sebuorder_1.setText("주문번호 : " + num + "번 / 매장, 자리 " + tempseatnum + "번");
						ordertext_1.append(ta.getText() + "\n");
						orderbtn_1.setEnabled(true);
						oredertime_1.setText(tempformat_time);
						JOptionPane.showMessageDialog(managermode, tempformat_time+"\n주문 2번 버튼에 주문이 들어왔습니다!");
						orderbtn1 = 1;
						ordernum1 = num;
					} else if (orderbtn2 == 0) {
						sebuorder_2.setText("주문번호 : " + num + "번 / 매장, 자리 " + tempseatnum + "번");
						ordertext_2.append(ta.getText() + "\n");
						orderbtn_2.setEnabled(true);
						oredertime_2.setText(tempformat_time);
						JOptionPane.showMessageDialog(managermode, tempformat_time+"\n주문 3번 버튼에 주문이 들어왔습니다!");
						orderbtn2 = 1;
						ordernum2 = num;
					} else if (orderbtn3 == 0) {
						sebuorder_3.setText("주문번호 : " + num + "번 / 매장, 자리 " + tempseatnum + "번");
						ordertext_3.append(ta.getText() + "\n");
						orderbtn_3.setEnabled(true);
						oredertime_3.setText(tempformat_time);
						JOptionPane.showMessageDialog(managermode, tempformat_time+"\n주문 4번 버튼에 주문이 들어왔습니다!");
						orderbtn3 = 1;
						ordernum3 = num;
					} else if (orderbtn4 == 0) {
						sebuorder_4.setText("주문번호 : " + num + "번 / 매장, 자리 " + tempseatnum + "번");
						ordertext_4.append(ta.getText() + "\n");
						orderbtn_4.setEnabled(true);
						oredertime_4.setText(tempformat_time);
						JOptionPane.showMessageDialog(managermode, tempformat_time+"\n주문 5번 버튼에 주문이 들어왔습니다!");
						orderbtn4 = 1;
						ordernum4 = num;
					} else if (orderbtn5 == 0) {
						sebuorder_5.setText("주문번호 : " + num + "번 / 매장, 자리 " + tempseatnum + "번");
						ordertext_5.append(ta.getText() + "\n");
						orderbtn_5.setEnabled(true);
						oredertime_5.setText(tempformat_time);
						JOptionPane.showMessageDialog(managermode, tempformat_time+"\n주문 6번 버튼에 주문이 들어왔습니다!");
						orderbtn5 = 1;
						ordernum5 = num;
					} else if (orderbtn6 == 0) {
						sebuorder_6.setText("주문번호 : " + num + "번 / 매장, 자리 " + tempseatnum + "번");
						ordertext_6.append(ta.getText() + "\n");
						orderbtn_6.setEnabled(true);
						oredertime_6.setText(tempformat_time);
						JOptionPane.showMessageDialog(managermode, tempformat_time+"\n주문 7번 버튼에 주문이 들어왔습니다!");
						orderbtn6 = 1;
						ordernum6 = num;
					} else if (orderbtn7 == 0) {
						sebuorder_7.setText("주문번호 : " + num + "번 / 매장, 자리 " + tempseatnum + "번");
						ordertext_7.append(ta.getText() + "\n");
						orderbtn_7.setEnabled(true);
						oredertime_7.setText(tempformat_time);
						JOptionPane.showMessageDialog(managermode, tempformat_time+"\n주문 8번 버튼에 주문이 들어왔습니다!");
						orderbtn7 = 1;
						ordernum7 = num;
					} else {
						JOptionPane.showMessageDialog(managermode, "주문 밀렸습니다. 관리자에게 문의하세요.");
						if (tempseatnum == 1) {
							seatnum0 = 0;
							seatbtn_0.setEnabled(true);
							orderstate_0.setText("사용 가능");
						} else if (tempseatnum == 2) {
							seatnum1 = 0;
							seatbtn_1.setEnabled(true);
							orderstate_1.setText("사용 가능");
						} else if (tempseatnum == 3) {
							seatnum2 = 0;
							seatbtn_2.setEnabled(true);
							orderstate_2.setText("사용 가능");
						} else if (tempseatnum == 4) {
							seatnum3 = 0;
							seatbtn_3.setEnabled(true);
							orderstate_3.setText("사용 가능");
						} else if (tempseatnum == 5) {
							seatnum4 = 0;
							seatbtn_4.setEnabled(true);
							orderstate_4.setText("사용 가능");
						} else if (tempseatnum == 6) {
							seatnum5 = 0;
							seatbtn_5.setEnabled(true);
							orderstate_5.setText("사용 가능");
						} else if (tempseatnum == 7) {
							seatnum6 = 6;
							seatbtn_6.setEnabled(true);
							orderstate_6.setText("사용 가능");
						} else if (tempseatnum == 8) {
							seatnum7 = 7;
							seatbtn_7.setEnabled(true);
							orderstate_7.setText("사용 가능");
						}
					}
				} else if (where == 2) {
					JOptionPane.showMessageDialog(main,"주문시각 : "+ tempformat_time + "\n"+
							ta.getText() + "주문번호 : " + num + "번 (포장)\n" + "주문되었습니다. \n이용해 주셔서 감사합니다. \n\n");
					allorder.append("   "+tempformat_time+"\n   주문번호 " + num + "번, 포장 / 카드계산\n\n");
					allorder.append(ta.getText());
					allorder.append("────────────────────────────────\n");
					salestext_2.setText(" 총매출액 : " + salesmoney);

					try {

						// 파일 객체 생성
						File file = new File(fileName);

						// true 지정시 파일의 기존 내용에 이어서 작성
						FileWriter fw = new FileWriter(file, true);

						// 파일안에 문자열 쓰기
						fw.write("   "+tempformat_time+"\n   주문번호 : " + num + "번 / 포장\n\n" + ta.getText() + "\n   ※누적 총매출액 : " + salesmoney
								+ "원\n───────────────────────\n");
						fw.flush();

						// 객체 닫기
						fw.close();

					} catch (Exception e1) {
						e1.printStackTrace();
					}

					if (orderbtn0 == 0) {
						sebuorder_0.setText("주문번호 : " + num + "번 / 포장");
						ordertext_0.append(ta.getText() + "\n");
						orderbtn_0.setEnabled(true);
						oredertime_0.setText(tempformat_time);
						JOptionPane.showMessageDialog(managermode, tempformat_time+"\n주문 1번 버튼에 주문이 들어왔습니다!");
						orderbtn0 = 1;
						ordernum0 = num;
					} else if (orderbtn1 == 0) {
						sebuorder_1.setText("주문번호 : " + num + "번 / 포장");
						ordertext_1.append(ta.getText() + "\n");
						orderbtn_1.setEnabled(true);
						oredertime_1.setText(tempformat_time);
						JOptionPane.showMessageDialog(managermode, tempformat_time+"\n주문 2번 버튼에 주문이 들어왔습니다!");
						orderbtn1 = 1;
						ordernum1 = num;
					} else if (orderbtn2 == 0) {
						sebuorder_2.setText("주문번호 : " + num + "번 / 포장");
						ordertext_2.append(ta.getText() + "\n");
						orderbtn_2.setEnabled(true);
						oredertime_2.setText(tempformat_time);
						JOptionPane.showMessageDialog(managermode, tempformat_time+"\n주문 3번 버튼에 주문이 들어왔습니다!");
						orderbtn2 = 1;
						ordernum2 = num;
					} else if (orderbtn3 == 0) {
						sebuorder_3.setText("주문번호 : " + num + "번 / 포장");
						ordertext_3.append(ta.getText() + "\n");
						orderbtn_3.setEnabled(true);
						oredertime_3.setText(tempformat_time);
						JOptionPane.showMessageDialog(managermode, tempformat_time+"\n주문 4번 버튼에 주문이 들어왔습니다!");
						orderbtn3 = 1;
						ordernum3 = num;
					} else if (orderbtn4 == 0) {
						sebuorder_4.setText("주문번호 : " + num + "번 / 포장");
						ordertext_4.append(ta.getText() + "\n");
						orderbtn_4.setEnabled(true);
						oredertime_4.setText(tempformat_time);
						JOptionPane.showMessageDialog(managermode, tempformat_time+"\n주문 5번 버튼에 주문이 들어왔습니다!");
						orderbtn4 = 1;
						ordernum4 = num;
					} else if (orderbtn5 == 0) {
						sebuorder_5.setText("주문번호 : " + num + "번 / 포장");
						ordertext_5.append(ta.getText() + "\n");
						orderbtn_5.setEnabled(true);
						oredertime_5.setText(tempformat_time);
						JOptionPane.showMessageDialog(managermode, tempformat_time+"\n주문 6번 버튼에 주문이 들어왔습니다!");
						orderbtn5 = 1;
						ordernum5 = num;
					} else if (orderbtn6 == 0) {
						sebuorder_6.setText("주문번호 : " + num + "번 / 포장");
						ordertext_6.append(ta.getText() + "\n");
						orderbtn_6.setEnabled(true);
						oredertime_6.setText(tempformat_time);
						JOptionPane.showMessageDialog(managermode, tempformat_time+"\n주문 7번 버튼에 주문이 들어왔습니다!");
						orderbtn6 = 1;
						ordernum6 = num;
					} else if (orderbtn7 == 0) {
						sebuorder_7.setText("주문번호 : " + num + "번 / 포장");
						ordertext_7.append(ta.getText() + "\n");
						orderbtn_7.setEnabled(true);
						oredertime_7.setText(tempformat_time);
						JOptionPane.showMessageDialog(managermode, tempformat_time+"\n주문 8번 버튼에 주문이 들어왔습니다!");
						orderbtn7 = 1;
						ordernum7 = num;
					} else {
						JOptionPane.showMessageDialog(managermode, "주문 밀렸습니다. 관리자에게 문의하세요.");
						if (tempseatnum == 1) {
							seatnum0 = 0;
							seatbtn_0.setEnabled(true);
							orderstate_0.setText("사용 가능");
						} else if (tempseatnum == 2) {
							seatnum1 = 0;
							seatbtn_1.setEnabled(true);
							orderstate_1.setText("사용 가능");
						} else if (tempseatnum == 3) {
							seatnum2 = 0;
							seatbtn_2.setEnabled(true);
							orderstate_2.setText("사용 가능");
						} else if (tempseatnum == 4) {
							seatnum3 = 0;
							seatbtn_3.setEnabled(true);
							orderstate_3.setText("사용 가능");
						} else if (tempseatnum == 5) {
							seatnum4 = 0;
							seatbtn_4.setEnabled(true);
							orderstate_4.setText("사용 가능");
						} else if (tempseatnum == 6) {
							seatnum5 = 0;
							seatbtn_5.setEnabled(true);
							orderstate_5.setText("사용 가능");
						} else if (tempseatnum == 7) {
							seatnum6 = 6;
							seatbtn_6.setEnabled(true);
							orderstate_6.setText("사용 가능");
						} else if (tempseatnum == 8) {
							seatnum7 = 7;
							seatbtn_7.setEnabled(true);
							orderstate_7.setText("사용 가능");
						}
					}
				}

				for (int i = 0; i < food.length; i++) {
					bt[i].setEnabled(true);
					minus[i].setEnabled(false);
					plus[i].setEnabled(false);
					suja[i].setText("0");
					amountmoney3.setText("0");
					amounttext.setText(" 총액 : 0원\n");
					amountmoney2.setText("");
					amountmoney3.setText("결제할 금액\n" + "0원");
					nowmoney.setText("입금된 금액 \n");
					textField_1.setText("");
					textField_2.setText("");
					textField_3.setText("");
					textField_4.setText("");
					textField_5.setText("");
					textField_6.setText("");
					amount = 0;
					where = 0;
					clickamount = 0;
					ta.setText("   상품명              단가         수량      합계\r\n\r\n");
				}

				menuframe.dispose();
			}
		});

		cardcancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				menuprint.setVisible(true);
				menuoption.setVisible(true);
				ta.setVisible(true);
				xpanel.setVisible(true);
				cardpanel.setVisible(false);
				for (int i = 0; i < food.length; i++) {
					bt[i].setEnabled(true);
					minus[i].setEnabled(false);
					plus[i].setEnabled(false);
					suja[i].setText("0");
					amountmoney3.setText("0");
					amounttext.setText(" 총액 : 0원\n");
					amountmoney2.setText("");
					amountmoney3.setText("결제할 금액 \n" + "0원");
					nowmoney.setText("입금된 금액 \n");
					textField_1.setText("");
					textField_2.setText("");
					textField_3.setText("");
					textField_4.setText("");
					textField_5.setText("");
					textField_6.setText("");
					ta.setText("   상품명              단가         수량      합계\r\n\r\n");
					amount = 0;
					clickamount = 0;
					where = 0;
				}

				if (tempseatnum == 1) {
					seatnum0 = 0;
					seatbtn_0.setEnabled(true);
					orderstate_0.setText("사용 가능");
				} else if (tempseatnum == 2) {
					seatnum1 = 0;
					seatbtn_1.setEnabled(true);
					orderstate_1.setText("사용 가능");
				} else if (tempseatnum == 3) {
					seatnum2 = 0;
					seatbtn_2.setEnabled(true);
					orderstate_2.setText("사용 가능");
				} else if (tempseatnum == 4) {
					seatnum3 = 0;
					seatbtn_3.setEnabled(true);
					orderstate_3.setText("사용 가능");
				} else if (tempseatnum == 5) {
					seatnum4 = 0;
					seatbtn_4.setEnabled(true);
					orderstate_4.setText("사용 가능");
				} else if (tempseatnum == 6) {
					seatnum5 = 0;
					seatbtn_5.setEnabled(true);
					orderstate_5.setText("사용 가능");
				} else if (tempseatnum == 7) {
					seatnum6 = 6;
					seatbtn_6.setEnabled(true);
					orderstate_6.setText("사용 가능");
				} else if (tempseatnum == 8) {
					seatnum7 = 7;
					seatbtn_7.setEnabled(true);
					orderstate_7.setText("사용 가능");
				}

				menuframe.dispose();

			}
		});

		// 끄기
		// 끄기
		menuframe.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		menuframe.setVisible(false);

		store.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				seatpanel.setVisible(true);
				menuframe.setVisible(false);
				main.setVisible(false);
				cardpanel.setVisible(false);
				amountmoney.setText("   상품명              단가         수량      합계\r\n\r\n");
				amountmoney2.setText("   상품명              단가         수량      합계\r\n\r\n");
				where = 1;
			}
		});

		pickup.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				seatpanel.setVisible(false);
				menuframe.setVisible(true);
				main.setVisible(true);
				cardpanel.setVisible(false);
				amountmoney.setText("   상품명              단가         수량      합계\r\n\r\n");
				amountmoney2.setText("   상품명              단가         수량      합계\r\n\r\n");
				where = 2;
			}
		});

		seatcancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				seatpanel.setVisible(false);
				menuframe.setVisible(false);
				main.setVisible(true);
			}
		});

		loginok.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				id2 = id1.getText();
				password2 = password1.getText();

				if (id.equals(id2) && password.equals(password2)) {
					JOptionPane.showMessageDialog(f, "로그인되었습니다.");
					f.setVisible(false);
					orderpanel_0.setVisible(false);
					orderpanel_1.setVisible(false);
					orderpanel_2.setVisible(false);
					orderpanel_3.setVisible(false);
					orderpanel_4.setVisible(false);
					orderpanel_5.setVisible(false);
					orderpanel_6.setVisible(false);
					orderpanel_7.setVisible(false);
					salespanel.setVisible(false);
					managerpanel.setVisible(true);
					managermode.setVisible(true);
					seatmanager.setVisible(true);
					main.setVisible(true);
					id1.setText("");
					password1.setText("");

					try {

						// 파일 객체 생성
						File file = new File(fileName);

						// true 지정시 파일의 기존 내용에 이어서 작성
						FileWriter fw = new FileWriter(file, true);

						// 파일안에 문자열 쓰기
						fw.flush();

						// 객체 닫기
						fw.close();

					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}

				else {

					f.setVisible(true);
					JOptionPane.showMessageDialog(f, "아이디 또는 비밀번호가 틀렸습니다.");
				}
			}
		});

		manager.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				f.setVisible(true);

			}
		});

		orderbtn_0.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				orderpanel_0.setVisible(true);
				orderpanel_1.setVisible(false);
				orderpanel_2.setVisible(false);
				orderpanel_3.setVisible(false);
				orderpanel_4.setVisible(false);
				orderpanel_5.setVisible(false);
				orderpanel_6.setVisible(false);
				orderpanel_7.setVisible(false);
				managerpanel.setVisible(false);
				managermode.setVisible(true);
				main.setVisible(true);
			}
		});

		ordernotok_0.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				managerpanel.setVisible(true);
				salespanel.setVisible(false);
				orderpanel_0.setVisible(false);
			}
		});

		orderbtn_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				orderpanel_0.setVisible(false);
				orderpanel_1.setVisible(true);
				orderpanel_2.setVisible(false);
				orderpanel_3.setVisible(false);
				orderpanel_4.setVisible(false);
				orderpanel_5.setVisible(false);
				orderpanel_6.setVisible(false);
				orderpanel_7.setVisible(false);
				managerpanel.setVisible(false);
				managermode.setVisible(true);
				main.setVisible(true);
			}
		});

		ordernotok_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				managerpanel.setVisible(true);
				salespanel.setVisible(false);
				orderpanel_1.setVisible(false);
			}
		});

		orderbtn_2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				orderpanel_0.setVisible(false);
				orderpanel_1.setVisible(false);
				orderpanel_2.setVisible(true);
				orderpanel_3.setVisible(false);
				orderpanel_4.setVisible(false);
				orderpanel_5.setVisible(false);
				orderpanel_6.setVisible(false);
				orderpanel_7.setVisible(false);
				managerpanel.setVisible(false);
				managermode.setVisible(true);
				main.setVisible(true);
			}
		});

		ordernotok_2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				managerpanel.setVisible(true);
				salespanel.setVisible(false);
				orderpanel_2.setVisible(false);
			}
		});

		orderbtn_3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				orderpanel_0.setVisible(false);
				orderpanel_1.setVisible(false);
				orderpanel_2.setVisible(false);
				orderpanel_3.setVisible(true);
				orderpanel_4.setVisible(false);
				orderpanel_5.setVisible(false);
				orderpanel_6.setVisible(false);
				orderpanel_7.setVisible(false);
				managerpanel.setVisible(false);
				managermode.setVisible(true);
				main.setVisible(true);
			}
		});

		ordernotok_3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				managerpanel.setVisible(true);
				salespanel.setVisible(false);
				orderpanel_3.setVisible(false);
			}
		});

		orderbtn_4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				orderpanel_0.setVisible(false);
				orderpanel_1.setVisible(false);
				orderpanel_2.setVisible(false);
				orderpanel_3.setVisible(false);
				orderpanel_4.setVisible(true);
				orderpanel_5.setVisible(false);
				orderpanel_6.setVisible(false);
				orderpanel_7.setVisible(false);
				managerpanel.setVisible(false);
				managermode.setVisible(true);
				main.setVisible(true);
			}
		});

		ordernotok_4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				managerpanel.setVisible(true);
				salespanel.setVisible(false);
				orderpanel_4.setVisible(false);
			}
		});

		orderbtn_5.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				orderpanel_0.setVisible(false);
				orderpanel_1.setVisible(false);
				orderpanel_2.setVisible(false);
				orderpanel_3.setVisible(false);
				orderpanel_4.setVisible(false);
				orderpanel_5.setVisible(true);
				orderpanel_6.setVisible(false);
				orderpanel_7.setVisible(false);
				managerpanel.setVisible(false);
				managermode.setVisible(true);
				main.setVisible(true);
			}
		});

		ordernotok_5.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				managerpanel.setVisible(true);
				salespanel.setVisible(false);
				orderpanel_5.setVisible(false);
			}
		});

		orderbtn_6.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				orderpanel_0.setVisible(false);
				orderpanel_1.setVisible(false);
				orderpanel_2.setVisible(false);
				orderpanel_3.setVisible(false);
				orderpanel_4.setVisible(false);
				orderpanel_5.setVisible(false);
				orderpanel_6.setVisible(true);
				orderpanel_7.setVisible(false);
				managerpanel.setVisible(false);
				managermode.setVisible(true);
				main.setVisible(true);
			}
		});

		ordernotok_6.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				managerpanel.setVisible(true);
				salespanel.setVisible(false);
				orderpanel_6.setVisible(false);
			}
		});

		orderbtn_7.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				orderpanel_0.setVisible(false);
				orderpanel_1.setVisible(false);
				orderpanel_2.setVisible(false);
				orderpanel_3.setVisible(false);
				orderpanel_4.setVisible(false);
				orderpanel_5.setVisible(false);
				orderpanel_6.setVisible(false);
				orderpanel_7.setVisible(true);
				managerpanel.setVisible(false);
				managermode.setVisible(true);
				main.setVisible(true);
			}
		});

		ordernotok_7.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				managerpanel.setVisible(true);
				salespanel.setVisible(false);
				orderpanel_7.setVisible(false);
			}
		});

		orderok_0.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				managerpanel.setVisible(true);
				salespanel.setVisible(false);
				orderpanel_0.setVisible(false);
				orderpanel_1.setVisible(false);
				orderpanel_2.setVisible(false);
				orderpanel_3.setVisible(false);
				orderpanel_4.setVisible(false);
				orderpanel_5.setVisible(false);
				orderpanel_6.setVisible(false);
				orderpanel_7.setVisible(false);
				orderbtn_0.setEnabled(false);
				JOptionPane.showMessageDialog(main, "주문번호 " + ordernum0 + "번, 음식 준비가 완료되었습니다.");
				orderbtn0 = 0;
				ordertext_0.setText("");
				sebuorder_0.setText("");
			}
		});
		orderok_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				managerpanel.setVisible(true);
				salespanel.setVisible(false);
				orderpanel_0.setVisible(false);
				orderpanel_1.setVisible(false);
				orderpanel_2.setVisible(false);
				orderpanel_3.setVisible(false);
				orderpanel_4.setVisible(false);
				orderpanel_5.setVisible(false);
				orderpanel_6.setVisible(false);
				orderpanel_7.setVisible(false);
				orderbtn_1.setEnabled(false);
				JOptionPane.showMessageDialog(main, "주문번호 " + ordernum1 + "번, 음식 준비가 완료되었습니다.");
				orderbtn1 = 0;
				ordertext_1.setText("");
				sebuorder_1.setText("");
			}
		});
		orderok_2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				managerpanel.setVisible(true);
				salespanel.setVisible(false);
				orderpanel_0.setVisible(false);
				orderpanel_1.setVisible(false);
				orderpanel_2.setVisible(false);
				orderpanel_3.setVisible(false);
				orderpanel_4.setVisible(false);
				orderpanel_5.setVisible(false);
				orderpanel_6.setVisible(false);
				orderpanel_7.setVisible(false);
				orderbtn_2.setEnabled(false);
				JOptionPane.showMessageDialog(main, "주문번호 " + ordernum2 + "번, 음식 준비가 완료되었습니다.");
				orderbtn2 = 0;
				ordertext_2.setText("");
				sebuorder_2.setText("");
			}
		});
		orderok_3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				managerpanel.setVisible(true);
				salespanel.setVisible(false);
				orderpanel_0.setVisible(false);
				orderpanel_1.setVisible(false);
				orderpanel_2.setVisible(false);
				orderpanel_3.setVisible(false);
				orderpanel_4.setVisible(false);
				orderpanel_5.setVisible(false);
				orderpanel_6.setVisible(false);
				orderpanel_7.setVisible(false);
				orderbtn_3.setEnabled(false);
				JOptionPane.showMessageDialog(main, "주문번호 " + ordernum3 + "번, 음식 준비가 완료되었습니다.");
				orderbtn3 = 0;

				ordertext_3.setText("");
				sebuorder_3.setText("");
			}
		});
		orderok_4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				managerpanel.setVisible(true);
				salespanel.setVisible(false);
				orderpanel_0.setVisible(false);
				orderpanel_1.setVisible(false);
				orderpanel_2.setVisible(false);
				orderpanel_3.setVisible(false);
				orderpanel_4.setVisible(false);
				orderpanel_5.setVisible(false);
				orderpanel_6.setVisible(false);
				orderpanel_7.setVisible(false);
				orderbtn_4.setEnabled(false);
				JOptionPane.showMessageDialog(main, "주문번호 " + ordernum4 + "번, 음식 준비가 완료되었습니다.");
				orderbtn4 = 0;
				ordertext_4.setText("");
				sebuorder_4.setText("");
			}
		});
		orderok_5.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				managerpanel.setVisible(true);
				salespanel.setVisible(false);
				orderpanel_0.setVisible(false);
				orderpanel_1.setVisible(false);
				orderpanel_2.setVisible(false);
				orderpanel_3.setVisible(false);
				orderpanel_4.setVisible(false);
				orderpanel_5.setVisible(false);
				orderpanel_6.setVisible(false);
				orderpanel_7.setVisible(false);
				orderbtn_5.setEnabled(false);
				JOptionPane.showMessageDialog(main, "주문번호 " + ordernum5 + "번, 음식 준비가 완료되었습니다.");
				orderbtn5 = 0;
				ordertext_5.setText("");
				sebuorder_5.setText("");
			}
		});
		orderok_6.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				managerpanel.setVisible(true);
				salespanel.setVisible(false);
				orderpanel_0.setVisible(false);
				orderpanel_1.setVisible(false);
				orderpanel_2.setVisible(false);
				orderpanel_3.setVisible(false);
				orderpanel_4.setVisible(false);
				orderpanel_5.setVisible(false);
				orderpanel_6.setVisible(false);
				orderpanel_7.setVisible(false);
				orderbtn_6.setEnabled(false);
				JOptionPane.showMessageDialog(main, "주문번호 " + ordernum6 + "번, 음식 준비가 완료되었습니다.");
				orderbtn6 = 0;
				ordertext_6.setText("");
				sebuorder_6.setText("");
			}
		});
		orderok_7.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				managerpanel.setVisible(true);
				salespanel.setVisible(false);
				orderpanel_0.setVisible(false);
				orderpanel_1.setVisible(false);
				orderpanel_2.setVisible(false);
				orderpanel_3.setVisible(false);
				orderpanel_4.setVisible(false);
				orderpanel_5.setVisible(false);
				orderpanel_6.setVisible(false);
				orderpanel_7.setVisible(false);
				orderbtn_7.setEnabled(false);
				JOptionPane.showMessageDialog(main, "주문번호 " + ordernum7 + "번, 음식 준비가 완료되었습니다.");
				orderbtn7 = 0;
				ordertext_7.setText("");
				sebuorder_7.setText("");
			}
		});

		seatbtn_0.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				seatpanel.setVisible(false);
				menuframe.setVisible(true);
				main.setVisible(true);
				cardpanel.setVisible(false);
				seatbtn_0.setEnabled(false);
				orderstate_0.setText("사용 중");
				seatnum0 = 1;
				tempseatnum = 1;
			}
		});
		seatbtn_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				seatpanel.setVisible(false);
				menuframe.setVisible(true);
				main.setVisible(true);
				cardpanel.setVisible(false);
				seatbtn_1.setEnabled(false);
				orderstate_1.setText("사용 중");
				seatnum1 = 1;
				tempseatnum = 2;
			}
		});
		seatbtn_2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				seatpanel.setVisible(false);
				menuframe.setVisible(true);
				main.setVisible(true);
				cardpanel.setVisible(false);
				seatbtn_2.setEnabled(false);
				orderstate_2.setText("사용 중");
				seatnum2 = 1;
				tempseatnum = 3;
			}
		});
		seatbtn_3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				seatpanel.setVisible(false);
				menuframe.setVisible(true);
				main.setVisible(true);
				cardpanel.setVisible(false);
				seatbtn_3.setEnabled(false);
				orderstate_3.setText("사용 중");
				seatnum3 = 1;
				tempseatnum = 4;
			}
		});
		seatbtn_4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				seatpanel.setVisible(false);
				menuframe.setVisible(true);
				main.setVisible(true);
				cardpanel.setVisible(false);
				seatbtn_4.setEnabled(false);
				orderstate_4.setText("사용 중");
				seatnum4 = 1;
				tempseatnum = 5;
			}
		});
		seatbtn_5.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				seatpanel.setVisible(false);
				menuframe.setVisible(true);
				main.setVisible(true);
				cardpanel.setVisible(false);
				seatbtn_5.setEnabled(false);
				orderstate_5.setText("사용 중");
				seatnum5 = 1;
				tempseatnum = 6;
			}
		});
		seatbtn_6.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				seatpanel.setVisible(false);
				menuframe.setVisible(true);
				main.setVisible(true);
				cardpanel.setVisible(false);
				seatbtn_6.setEnabled(false);
				orderstate_6.setText("사용 중");
				seatnum6 = 1;
				tempseatnum = 7;
			}
		});
		seatbtn_7.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				seatpanel.setVisible(false);
				menuframe.setVisible(true);
				main.setVisible(true);
				cardpanel.setVisible(false);
				seatbtn_7.setEnabled(false);
				orderstate_7.setText("사용 중");
				seatnum7 = 1;
				tempseatnum = 8;
			}
		});

		seatset_0.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (seatnum0 == 0) {
					seatbtn_0.setEnabled(false);
					orderstate_0.setText("사용 중");
					seatnum0 = 1;
				} else {
					seatbtn_0.setEnabled(true);
					orderstate_0.setText("사용 가능");
					seatnum0 = 0;
				}
			}
		});

		seatset_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (seatnum1 == 0) {
					seatbtn_1.setEnabled(false);
					orderstate_1.setText("사용 중");
					seatnum1 = 1;
				} else {
					seatbtn_1.setEnabled(true);
					orderstate_1.setText("사용 가능");
					seatnum1 = 0;
				}
			}
		});

		seatset_2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (seatnum2 == 0) {
					seatbtn_2.setEnabled(false);
					orderstate_2.setText("사용 중");
					seatnum2 = 1;
				} else {
					seatbtn_2.setEnabled(true);
					orderstate_2.setText("사용 가능");
					seatnum2 = 0;
				}
			}
		});
		seatset_3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (seatnum3 == 0) {
					seatbtn_3.setEnabled(false);
					orderstate_3.setText("사용 중");
					seatnum3 = 1;
				} else {
					seatbtn_3.setEnabled(true);
					orderstate_3.setText("사용 가능");
					seatnum3 = 0;
				}
			}
		});
		seatset_4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (seatnum4 == 0) {
					seatbtn_4.setEnabled(false);
					orderstate_4.setText("사용 중");
					seatnum4 = 1;
				} else {
					seatbtn_4.setEnabled(true);
					orderstate_4.setText("사용 가능");
					seatnum4 = 0;
				}
			}
		});
		seatset_5.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (seatnum5 == 0) {
					seatbtn_5.setEnabled(false);
					orderstate_5.setText("사용 중");
					seatnum5 = 1;
				} else {
					seatbtn_5.setEnabled(true);
					orderstate_5.setText("사용 가능");
					seatnum5 = 0;
				}
			}
		});
		seatset_6.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (seatnum6 == 0) {
					seatbtn_6.setEnabled(false);
					orderstate_6.setText("사용 중");
					seatnum6 = 1;
				} else {
					seatbtn_6.setEnabled(true);
					orderstate_6.setText("사용 가능");
					seatnum6 = 0;
				}
			}
		});
		seatset_7.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (seatnum7 == 0) {
					seatbtn_7.setEnabled(false);
					orderstate_7.setText("사용 중");
					seatnum7 = 1;
				} else {
					seatbtn_7.setEnabled(true);
					orderstate_7.setText("사용 가능");
					seatnum7 = 0;
				}
			}
		});

		onoff.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (onoffnum == 0) {
					store.setEnabled(true);
					pickup.setEnabled(true);
					onoffnum = 1;

				}

				else {
					store.setEnabled(false);
					pickup.setEnabled(false);
					onoffnum = 0;

					try {

						// 파일 객체 생성
						File file = new File(fileName);

						// true 지정 시 파일의 기존 내용에 이어서 작성
						FileWriter fw = new FileWriter(file, true);

						// 파일 안에 문자열 쓰기
						fw.write("\n\n\n   마감 총매출액 : " + salesmoney + "원\n");
						fw.flush();

						// 객체 닫기
						fw.close();

					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}

			}
		});
	}
}
