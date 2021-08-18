package in.labsoft;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import javax.swing.JButton;
import javax.swing.DesktopManager;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.JToolBar;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;

import java.awt.BorderLayout;
import javax.swing.JDesktopPane;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.Rectangle;
import javax.swing.JMenuItem;

public class FormMainGUI extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JFrame frame;
	private int width, height;
	private JDesktopPane desktopPane;
	private JDesktopPane desktopPane_1;
	private JPanel panel;
	private JToolBar toolBar;
	private JTabbedPane tabbedPane;
	private JPanel panel_1;
	private JPanel panel_2;
	private JMenuBar menuBar;
	private JTable table;
	private JScrollPane jsp;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	private JButton btnNewButton_4;
	private JButton button;
	private JButton button_1;
	private JButton btnReports;
	private JButton btnDatabaseBackup;
	private JButton btnNewButton_5;
	private JButton btnPatientsInformation;
	private JButton btnSuppliersInformation;
	private JButton btnMedicinePurchases;
	private JButton btnRecvOrder;
	private JButton btnNewButton_6;
	private JLabel lblUserName;
	private JButton btnNewMedicines;
	private JLabel label_4;
	private JButton btnStockDetails;
	private JLabel label_5;
	private JButton button_3;
	private JButton btnTestCategories;
	private JLabel label_7;
	private JLabel label_9;
	private JButton btnExam;
	private JButton btnTestSubCat;
	private JButton btnAddMajorTests;
	private JLabel label_10;
	private JButton btnAddTestFactors;
	private JLabel label_11;
	private JButton btnTestRequestForm;
	private JLabel label_13;
	private JButton btnTestReadings;
	private JButton btnTestReports;
	private JMenu mnPersonalManagement;
	private JMenuItem mntmLogout;

	/**
	 * Create the application.
	 */
	public FormMainGUI() {
		frame = this;
		setIconImage(new ImageIcon(this.getClass().getResource("/img/icons/ico_logo.png")).getImage());
		setBackground(new Color(47, 79, 79));
		setForeground(new Color(75, 0, 130));
		setResizable(false);
		setTitle("Pathology Lab Manager 1.0");
		setState(NORMAL);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		width = (int)screenSize.getWidth() - 10;
		height = (int)screenSize.getHeight() - 97;
		getContentPane().setPreferredSize( new Dimension(width, height) );
		cv.setWH(width - 560, height - 75);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		menuBar = new JMenuBar();
		menuBar.setBorder(new LineBorder(Color.GREEN));
		menuBar.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		menuBar.setForeground(Color.BLACK);
		menuBar.setBackground(Color.DARK_GRAY);
		setJMenuBar(menuBar);
		
		JMenu mnAdmin = new JMenu("Admin");
		mnAdmin.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		mnAdmin.setForeground(Color.YELLOW);
		mnAdmin.setBackground(new Color(255, 255, 255));
		menuBar.add(mnAdmin);
		
		mnPersonalManagement = new JMenu("Personal Management");
		mnAdmin.add(mnPersonalManagement);
		
		JMenuItem mntmDoctors = new JMenuItem("Doctors");
		mntmDoctors.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeOpenedChilds();
				desktopPane.add(new DoctorsInfo(desktopPane));
			}
		});
		mnPersonalManagement.add(mntmDoctors);
		
		JMenuItem mntmPatients = new JMenuItem("Patients");
		mntmPatients.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeOpenedChilds();
				desktopPane.add(new PatientsInfo(desktopPane));
			}
		});
		mnPersonalManagement.add(mntmPatients);
		
		JMenuItem mntmSuppliers = new JMenuItem("Suppliers");
		mntmSuppliers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeOpenedChilds();
				desktopPane.add(new SupplierInfo(desktopPane));
			}
		});
		mnPersonalManagement.add(mntmSuppliers);
		
		JMenu mnMedicineManagement = new JMenu("Medicine Management");
		mnAdmin.add(mnMedicineManagement);
		
		JMenuItem mntmNew = new JMenuItem("New");
		mntmNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeOpenedChilds();
				desktopPane.add(new MedicineInfo(desktopPane));
			}			
		});
		mnMedicineManagement.add(mntmNew);
		
		JMenuItem mntmPurchase = new JMenuItem("Purchase");
		mntmPurchase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeOpenedChilds();
				desktopPane.add(new MedicinePurchase(desktopPane));
			}
		});
		mnMedicineManagement.add(mntmPurchase);
		
		JMenuItem mntmRecieve = new JMenuItem("Recieve");
		mntmRecieve.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeOpenedChilds();
				desktopPane.add(new RecieveOrder(desktopPane));
			}
		});
		mnMedicineManagement.add(mntmRecieve);
		
		JMenuItem mntmStock = new JMenuItem("Stock");
		mntmStock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeOpenedChilds();
				desktopPane.add(new ViewStock(desktopPane));
			}
		});
		mnMedicineManagement.add(mntmStock);
		
		JMenu mnDatabaseBackups = new JMenu("Database Backups");
		mnAdmin.add(mnDatabaseBackups);
		
		JMenuItem mntmBackup = new JMenuItem("Backup");
		mntmBackup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeOpenedChilds();
				desktopPane.add(new DatabaseBackup(desktopPane));
			}
		});
		mnDatabaseBackups.add(mntmBackup);
		
		JMenuItem mntmRestore = new JMenuItem("Restore");
		mntmRestore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeOpenedChilds();
				desktopPane.add(new DatabaseBackup(desktopPane));
			}
		});
		mnDatabaseBackups.add(mntmRestore);
		
		JMenu mnTest = new JMenu("Test");
		mnTest.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		mnTest.setForeground(Color.YELLOW);
		menuBar.add(mnTest);
		
		JMenuItem mntmTestForm = new JMenuItem("Test Form");
		mntmTestForm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeOpenedChilds();
				desktopPane.add(new NewTestRequest(desktopPane));
			}
		});
		mnTest.add(mntmTestForm);
		
		JMenuItem mntmTestReading = new JMenuItem("Test Reading");
		mntmTestReading.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeOpenedChilds();
				desktopPane.add(new TestReadings(desktopPane));
			}
		});
		mnTest.add(mntmTestReading);
		
		JMenuItem mntmTestBill = new JMenuItem("Test Bill");
		mntmTestBill.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeOpenedChilds();
				desktopPane.add(new PendingBills(FormMainGUI.this,desktopPane));
			}
		});
		mnTest.add(mntmTestBill);
		
		JMenuItem mntmTestReport = new JMenuItem("Test Report");
		mntmTestReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeOpenedChilds();
				desktopPane.add(new PendingReports(FormMainGUI.this,desktopPane));
			}
		});
		mnTest.add(mntmTestReport);
		
		JMenu mnProfiles = new JMenu("Profiles");
		mnProfiles.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		mnProfiles.setForeground(Color.YELLOW);
		menuBar.add(mnProfiles);
		
		JMenuItem mntmSetting = new JMenuItem("Setting");
		mntmSetting.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeOpenedChilds();
				desktopPane.add(new ManageProfile(desktopPane));
			}
		});
		mnProfiles.add(mntmSetting);
		
		mntmLogout = new JMenuItem("Logout");
		mntmLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblUserName.setText(null);
				LoginDialog lgnDialog=new LoginDialog(FormMainGUI.this);
				lgnDialog.setVisible(true);
			}
		});
		mnProfiles.add(mntmLogout);
		
		toolBar = new JToolBar();
		toolBar.setBorder(new MatteBorder(0, 1, 0, 1, (Color) Color.YELLOW));
		toolBar.setBackground(Color.BLACK);
		toolBar.setFloatable(false);
		getContentPane().add(toolBar, BorderLayout.NORTH);
		toolBar.setPreferredSize( new Dimension(width, 55) );
		
		btnNewButton = new JButton();
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				closeOpenedChilds();
				desktopPane.add(new PatientsInfo(desktopPane));
			}
		});
		btnNewButton.setForeground(new Color(75, 0, 130));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setToolTipText("Add New Patients Information");
		btnNewButton.setText("New Patient  ");
		btnNewButton.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(255, 255, 0)));
		btnNewButton.setPreferredSize(new Dimension(32, 32));
		btnNewButton.setBackground(SystemColor.control);
		btnNewButton.setIcon(new ImageIcon(FormMainGUI.class.getResource("/img/icons/ico_01.png")));
		toolBar.add(btnNewButton);
				
		btnNewButton_1 = new JButton();
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				closeOpenedChilds();
				desktopPane.add(new DoctorsInfo(desktopPane));
			}
		});
		btnNewButton_1.setForeground(new Color(75, 0, 130));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1.setText("New Doctor  ");
		btnNewButton_1.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.YELLOW));
		btnNewButton_1.setPreferredSize(new Dimension(32, 32));
		btnNewButton_1.setBackground(SystemColor.control);
		btnNewButton_1.setIcon(new ImageIcon(FormMainGUI.class.getResource("/img/icons/ico_02.png")));
		toolBar.add(btnNewButton_1);
				
		btnNewButton_2 = new JButton();
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeOpenedChilds();
				desktopPane.add(new SupplierInfo(desktopPane));
			}
		});
		btnNewButton_2.setForeground(new Color(75, 0, 130));
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_2.setText("New Supplier  ");
		btnNewButton_2.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.YELLOW));
		btnNewButton_2.setPreferredSize(new Dimension(32, 32));
		btnNewButton_2.setBackground(SystemColor.control);
		btnNewButton_2.setIcon(new ImageIcon(FormMainGUI.class.getResource("/img/icons/ico_03.png")));
		toolBar.add(btnNewButton_2);
		
		btnNewButton_3 = new JButton();
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				closeOpenedChilds();
				desktopPane.add(new MedicinePurchase(desktopPane));
			}
		});
		btnNewButton_3.setForeground(new Color(75, 0, 130));
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_3.setText("Purchase Order  ");
		btnNewButton_3.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.YELLOW));
		btnNewButton_3.setPreferredSize(new Dimension(32, 32));
		btnNewButton_3.setBackground(SystemColor.control);
		btnNewButton_3.setIcon(new ImageIcon(FormMainGUI.class.getResource("/img/icons/ico_04.png")));
		toolBar.add(btnNewButton_3);
				
		btnNewButton_4 = new JButton();
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeOpenedChilds();
				desktopPane.add(new NewTestRequest(desktopPane));
			}
		});
		btnNewButton_4.setForeground(new Color(75, 0, 130));
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_4.setText("Test Entry  ");
		btnNewButton_4.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.YELLOW));
		btnNewButton_4.setPreferredSize(new Dimension(32, 32));
		btnNewButton_4.setBackground(SystemColor.control);
		btnNewButton_4.setIcon(new ImageIcon(FormMainGUI.class.getResource("/img/icons/ico_05.png")));
		toolBar.add(btnNewButton_4);
		
		button = new JButton();
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeOpenedChilds();
				desktopPane.add(new TestReadings(desktopPane));
			}
		});
		button.setText("Test Description  ");
		button.setPreferredSize(new Dimension(32, 32));
		button.setForeground(new Color(75, 0, 130));
		button.setFont(new Font("Tahoma", Font.BOLD, 12));
		button.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.YELLOW));
		button.setBackground(SystemColor.control);
		button.setIcon(new ImageIcon(FormMainGUI.class.getResource("/img/icons/ico_06.png")));
		toolBar.add(button);
		
		button_1 = new JButton();
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeOpenedChilds();
				desktopPane.add(new PendingBills(FormMainGUI.this,desktopPane));
			}
		});
		button_1.setText("Expenses  ");
		button_1.setPreferredSize(new Dimension(32, 32));
		button_1.setForeground(new Color(75, 0, 130));
		button_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		button_1.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.YELLOW));
		button_1.setBackground(SystemColor.control);
		button_1.setIcon(new ImageIcon(FormMainGUI.class.getResource("/img/icons/ico_07.png")));
		toolBar.add(button_1);
		
		btnReports = new JButton();
		btnReports.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeOpenedChilds();
				desktopPane.add(new PendingReports(FormMainGUI.this,desktopPane));
			}
		});
		btnReports.setText("Reports  ");
		btnReports.setPreferredSize(new Dimension(32, 32));
		btnReports.setForeground(new Color(75, 0, 130));
		btnReports.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnReports.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.YELLOW));
		btnReports.setBackground(SystemColor.control);
		btnReports.setIcon(new ImageIcon(FormMainGUI.class.getResource("/img/icons/ico_09.png")));
		toolBar.add(btnReports);
		
		btnDatabaseBackup = new JButton();
		btnDatabaseBackup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeOpenedChilds();
				desktopPane.add(new DatabaseBackup(desktopPane));
			}
		});
		btnDatabaseBackup.setText("Database Backup  ");
		btnDatabaseBackup.setPreferredSize(new Dimension(32, 32));
		btnDatabaseBackup.setForeground(new Color(75, 0, 130));
		btnDatabaseBackup.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnDatabaseBackup.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.YELLOW));
		btnDatabaseBackup.setBackground(SystemColor.control);
		btnDatabaseBackup.setIcon(new ImageIcon(FormMainGUI.class.getResource("/img/icons/ico_10.png")));
		toolBar.add(btnDatabaseBackup);
		
		desktopPane = new JDesktopPane();
		desktopPane.setBorder(new MatteBorder(1, 0, 1, 0, (Color) new Color(255, 0, 255)));
		desktopPane.setBackground(Color.BLACK);
		getContentPane().add(desktopPane, BorderLayout.CENTER);
		
		desktopPane_1 = new JDesktopPane();
		desktopPane_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(255, 0, 255)));
		desktopPane_1.setBackground(Color.BLACK);
		desktopPane_1.setPreferredSize( new Dimension(350, height - 77) );
		getContentPane().add(desktopPane_1, BorderLayout.EAST);
		
		JLabel lblNewLabel_1 = new JLabel("Pending Reports Delivery");
		lblNewLabel_1.setBorder(new LineBorder(Color.RED));
		lblNewLabel_1.setForeground(Color.CYAN);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setIcon(new ImageIcon(FormMainGUI.class.getResource("/img/left_panel/ico_01.png")));
		lblNewLabel_1.setBounds(10, 65, 330, 25);
		desktopPane_1.add(lblNewLabel_1);
		
		JPanel panel_4 = new JPanel(new BorderLayout());
		panel_4.setBorder(new LineBorder(Color.RED));
		panel_4.setBackground(Color.BLACK);
		panel_4.setBounds(10, 95, 330, 475);
		desktopPane_1.add(panel_4);
		
		String[] col=new String[] {"Date", "Test","Name"};
		Object[][] data=getTableData();
		table = new JTable(new MyTableModel(data,col)){
		    private static final long serialVersionUID = 1L;
			public Component prepareRenderer(TableCellRenderer renderer, int row, int column){
		        Component returnComp = super.prepareRenderer(renderer, row, column);
		        Color alternateColor = new Color(252,242,206);
		        Color whiteColor = Color.YELLOW;
		        if (!returnComp.getBackground().equals(getSelectionBackground())){
		            Color bg = (row % 2 == 0 ? alternateColor : whiteColor);
		            returnComp .setBackground(bg);
		            bg = null;
		        }
		        return returnComp;
		    }
		};
		table.setForeground(Color.BLACK);
		table.setBackground(Color.BLACK);
		table.setShowHorizontalLines(true);
		table.setShowVerticalLines(true);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setBorder(new LineBorder(Color.GREEN));
		table.getColumnModel().getColumn(0).setPreferredWidth(80);
		table.getColumnModel().getColumn(1).setPreferredWidth(120);
		table.getColumnModel().getColumn(2).setPreferredWidth(125);
		/*DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);*/
		table.setFillsViewportHeight(true);
		table.addMouseListener(new MouseAdapter() {
		    public void mousePressed(MouseEvent mouseEvent) {
		        JTable table =(JTable) mouseEvent.getSource();
		        if (mouseEvent.getClickCount() == 2 && table.getSelectedRow() != -1) {
		            //getSinglePatDetails();
		        }
		        else if (mouseEvent.getClickCount() == 1 && table.getSelectedRow() != -1) {
		        	button.setEnabled(true);
		        }
		    }
		});
		jsp=new JScrollPane(table,ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);	
		table.getTableHeader().setBackground(Color.WHITE);
		table.getTableHeader().setForeground(new Color(75,0,130));
		table.getTableHeader().setFont(new Font("Tahoma",Font.BOLD,12));
		panel_4.add(table.getTableHeader(), BorderLayout.PAGE_START);
		panel_4.add(jsp, BorderLayout.CENTER);
		
		btnNewButton_6 = new JButton("SHOW REPORT");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeOpenedChilds();
				desktopPane.add(new PendingReports(FormMainGUI.this,desktopPane));
			}
		});
		btnNewButton_6.setBorder(new LineBorder(Color.RED));
		btnNewButton_6.setForeground(Color.YELLOW);
		btnNewButton_6.setBackground(new Color(139, 0, 0));
		btnNewButton_6.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_6.setBounds(10, 575, 330, 30);
		desktopPane_1.add(btnNewButton_6);
		
		JPanel pnlUserProfile = new JPanel();
		pnlUserProfile.setBorder(new LineBorder(Color.RED));
		pnlUserProfile.setBackground(Color.ORANGE);
		pnlUserProfile.setBounds(10, 10, 330, 50);
		desktopPane_1.add(pnlUserProfile);
		pnlUserProfile.setLayout(null);
		
		lblUserName = new JLabel();
		lblUserName.setBorder(new LineBorder(new Color(139, 0, 0)));
		lblUserName.setHorizontalTextPosition(SwingConstants.CENTER);
		lblUserName.setForeground(new Color(75, 0, 130));
		lblUserName.setFont(new Font("Bodoni MT", Font.PLAIN, 17));
		lblUserName.setBounds(10, 10, 220, 30);
		pnlUserProfile.add(lblUserName);
		
		JButton btnChangePass = new JButton();
		btnChangePass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeOpenedChilds();
				desktopPane.add(new ManageProfile(desktopPane));
			}
		});
		btnChangePass.setBackground(new Color(0, 255, 127));
		btnChangePass.setBorder(new LineBorder(new Color(128, 0, 0)));
		btnChangePass.setIcon(new ImageIcon(FormMainGUI.class.getResource("/img/left_panel/ico_changepass.png")));
		btnChangePass.setBounds(235, 10, 40, 30);
		pnlUserProfile.add(btnChangePass);
		
		JButton btnLogout = new JButton();
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblUserName.setText(null);
				LoginDialog lgnDialog=new LoginDialog(FormMainGUI.this);
				lgnDialog.setVisible(true);
			}
		});
		btnLogout.setBackground(new Color(0, 255, 127));
		btnLogout.setBorder(new LineBorder(new Color(128, 0, 0)));
		btnLogout.setIcon(new ImageIcon(FormMainGUI.class.getResource("/img/left_panel/ico_logout.png")));
		btnLogout.setBounds(280, 10, 40, 30);
		pnlUserProfile.add(btnLogout);
		
		panel = new JPanel();
		FlowLayout fl_panel = (FlowLayout) panel.getLayout();
		fl_panel.setAlignment(FlowLayout.LEFT);
		panel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(255, 0, 255)));
		panel.setBackground(Color.BLACK);
		panel.setPreferredSize( new Dimension(210, height - 77) );
		getContentPane().add(panel, BorderLayout.WEST);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBorder(null);
		tabbedPane.setForeground(Color.RED);
		tabbedPane.setBackground(Color.BLACK);
		tabbedPane.setPreferredSize( new Dimension(200, height - 65) );
		panel.add(tabbedPane);
		
		panel_1 = new JPanel();
		panel_1.setBackground(Color.BLACK);
		tabbedPane.addTab("ADMIN", null, panel_1, null);
		panel_1.setLayout(null);
		
		btnNewButton_5 = new JButton("Doctors Information");
		btnNewButton_5.setHorizontalTextPosition(SwingConstants.LEADING);
		btnNewButton_5.setMinimumSize(new Dimension(175, 28));
		btnNewButton_5.setMaximumSize(new Dimension(175,28));
		btnNewButton_5.setPreferredSize(new Dimension(175,28));
		btnNewButton_5.setBorder(new MatteBorder(1, 1, 1, 0, (Color) Color.RED));
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeOpenedChilds();
				desktopPane.add(new DoctorsInfo(desktopPane));
			}
		});
		btnNewButton_5.setBackground(Color.BLACK);
		btnNewButton_5.setForeground(Color.YELLOW);
		btnNewButton_5.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_5.setFont(new Font("Baskerville Old Face", Font.PLAIN, 14));
		btnNewButton_5.setBounds(10, 10, 145, 28);
		panel_1.add(btnNewButton_5);
		
		btnPatientsInformation = new JButton("Patients Information");
		btnPatientsInformation.setHorizontalTextPosition(SwingConstants.LEADING);
		btnPatientsInformation.setBounds(new Rectangle(10, 10, 175, 28));
		btnPatientsInformation.setPreferredSize(new Dimension(175, 28));
		btnPatientsInformation.setMinimumSize(new Dimension(175, 28));
		btnPatientsInformation.setMaximumSize(new Dimension(175, 28));
		btnPatientsInformation.setBorder(new MatteBorder(1, 1, 1, 0, (Color) Color.RED));
		btnPatientsInformation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				closeOpenedChilds();
				desktopPane.add(new PatientsInfo(desktopPane));
			}
		});
		btnPatientsInformation.setHorizontalAlignment(SwingConstants.LEFT);
		btnPatientsInformation.setForeground(Color.YELLOW);
		btnPatientsInformation.setFont(new Font("Baskerville Old Face", Font.PLAIN, 14));
		btnPatientsInformation.setBackground(Color.BLACK);
		btnPatientsInformation.setBounds(10, 49, 145, 28);
		panel_1.add(btnPatientsInformation);
		
		btnSuppliersInformation = new JButton("Suppliers Information");
		btnSuppliersInformation.setHorizontalTextPosition(SwingConstants.LEADING);
		btnSuppliersInformation.setBounds(new Rectangle(10, 10, 175, 28));
		btnSuppliersInformation.setPreferredSize(new Dimension(175, 28));
		btnSuppliersInformation.setMinimumSize(new Dimension(175, 28));
		btnSuppliersInformation.setMaximumSize(new Dimension(175, 28));
		btnSuppliersInformation.setBorder(new MatteBorder(1, 1, 1, 0, (Color) Color.RED));
		btnSuppliersInformation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				closeOpenedChilds();
				desktopPane.add(new SupplierInfo(desktopPane));
			}
		});
		btnSuppliersInformation.setHorizontalAlignment(SwingConstants.LEFT);
		btnSuppliersInformation.setForeground(Color.YELLOW);
		btnSuppliersInformation.setFont(new Font("Baskerville Old Face", Font.PLAIN, 14));
		btnSuppliersInformation.setBackground(Color.BLACK);
		btnSuppliersInformation.setBounds(10, 88, 145, 28);
		panel_1.add(btnSuppliersInformation);
		
		btnMedicinePurchases = new JButton("Medicine Purchases");
		btnMedicinePurchases.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				closeOpenedChilds();
				desktopPane.add(new MedicinePurchase(desktopPane));
			}
		});
		btnMedicinePurchases.setHorizontalTextPosition(SwingConstants.LEADING);
		btnMedicinePurchases.setBounds(new Rectangle(10, 10, 175, 28));
		btnMedicinePurchases.setPreferredSize(new Dimension(175, 28));
		btnMedicinePurchases.setMinimumSize(new Dimension(175, 28));
		btnMedicinePurchases.setMaximumSize(new Dimension(175, 28));
		btnMedicinePurchases.setBorder(new MatteBorder(1, 1, 1, 0, (Color) Color.RED));
		btnMedicinePurchases.setHorizontalAlignment(SwingConstants.LEFT);
		btnMedicinePurchases.setForeground(Color.YELLOW);
		btnMedicinePurchases.setFont(new Font("Baskerville Old Face", Font.PLAIN, 14));
		btnMedicinePurchases.setBackground(Color.BLACK);
		btnMedicinePurchases.setBounds(10, 165, 145, 28);
		panel_1.add(btnMedicinePurchases);
		
		btnRecvOrder = new JButton("Recieve Order");
		btnRecvOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeOpenedChilds();
				desktopPane.add(new RecieveOrder(desktopPane));
			}
		});
		btnRecvOrder.setHorizontalTextPosition(SwingConstants.LEADING);
		btnRecvOrder.setBounds(new Rectangle(10, 10, 175, 28));
		btnRecvOrder.setPreferredSize(new Dimension(175, 28));
		btnRecvOrder.setMinimumSize(new Dimension(175, 28));
		btnRecvOrder.setMaximumSize(new Dimension(175, 28));
		btnRecvOrder.setBorder(new MatteBorder(1, 1, 1, 0, (Color) Color.RED));
		btnRecvOrder.setHorizontalAlignment(SwingConstants.LEFT);
		btnRecvOrder.setForeground(Color.YELLOW);
		btnRecvOrder.setFont(new Font("Baskerville Old Face", Font.PLAIN, 14));
		btnRecvOrder.setBackground(Color.BLACK);
		btnRecvOrder.setBounds(10, 204, 145, 28);
		panel_1.add(btnRecvOrder);
		
		JLabel lblLbl = new JLabel("");
		lblLbl.setHorizontalAlignment(SwingConstants.CENTER);
		lblLbl.setBorder(new MatteBorder(1, 0, 1, 1, (Color) Color.RED));
		lblLbl.setIcon(new ImageIcon(FormMainGUI.class.getResource("/img/left_panel/ico_09.png")));
		lblLbl.setBounds(154, 10, 31, 28);
		panel_1.add(lblLbl);
		
		JLabel label = new JLabel("");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBorder(new MatteBorder(1, 0, 1, 1, (Color) Color.RED));
		label.setIcon(new ImageIcon(FormMainGUI.class.getResource("/img/left_panel/ico_09.png")));
		label.setBounds(154, 49, 31, 28);
		panel_1.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBorder(new MatteBorder(1, 0, 1, 1, (Color) Color.RED));
		label_1.setIcon(new ImageIcon(FormMainGUI.class.getResource("/img/left_panel/ico_09.png")));
		label_1.setBounds(154, 88, 31, 28);
		panel_1.add(label_1);
		
		JLabel label_2 = new JLabel("");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setBorder(new MatteBorder(1, 0, 1, 1, (Color) Color.RED));
		label_2.setIcon(new ImageIcon(FormMainGUI.class.getResource("/img/left_panel/ico_09.png")));
		label_2.setBounds(154, 165, 31, 28);
		panel_1.add(label_2);
		
		JLabel label_3 = new JLabel("");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setBorder(new MatteBorder(1, 0, 1, 1, (Color) Color.RED));
		label_3.setIcon(new ImageIcon(FormMainGUI.class.getResource("/img/left_panel/ico_09.png")));
		label_3.setBounds(154, 204, 31, 28);
		panel_1.add(label_3);
		
		btnNewMedicines = new JButton("New Medicines");
		btnNewMedicines.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				closeOpenedChilds();
				desktopPane.add(new MedicineInfo(desktopPane));
			}
		});
		btnNewMedicines.setPreferredSize(new Dimension(175, 28));
		btnNewMedicines.setMinimumSize(new Dimension(175, 28));
		btnNewMedicines.setMaximumSize(new Dimension(175, 28));
		btnNewMedicines.setHorizontalTextPosition(SwingConstants.LEADING);
		btnNewMedicines.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewMedicines.setForeground(Color.YELLOW);
		btnNewMedicines.setFont(new Font("Baskerville Old Face", Font.PLAIN, 14));
		btnNewMedicines.setBounds(new Rectangle(10, 10, 175, 28));
		btnNewMedicines.setBorder(new MatteBorder(1, 1, 1, 0, (Color) Color.RED));
		btnNewMedicines.setBackground(Color.BLACK);
		btnNewMedicines.setBounds(10, 126, 145, 28);
		panel_1.add(btnNewMedicines);
		
		label_4 = new JLabel("");
		label_4.setIcon(new ImageIcon(FormMainGUI.class.getResource("/img/left_panel/ico_09.png")));
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setBorder(new MatteBorder(1, 0, 1, 1, (Color) Color.RED));
		label_4.setBounds(154, 126, 31, 28);
		panel_1.add(label_4);
		
		btnStockDetails = new JButton("View Stock");
		btnStockDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				closeOpenedChilds();
				desktopPane.add(new ViewStock(desktopPane));
			}
		});
		btnStockDetails.setPreferredSize(new Dimension(175, 28));
		btnStockDetails.setMinimumSize(new Dimension(175, 28));
		btnStockDetails.setMaximumSize(new Dimension(175, 28));
		btnStockDetails.setHorizontalTextPosition(SwingConstants.LEADING);
		btnStockDetails.setHorizontalAlignment(SwingConstants.LEFT);
		btnStockDetails.setForeground(Color.YELLOW);
		btnStockDetails.setFont(new Font("Baskerville Old Face", Font.PLAIN, 14));
		btnStockDetails.setBounds(new Rectangle(10, 10, 175, 28));
		btnStockDetails.setBorder(new MatteBorder(1, 1, 1, 0, (Color) Color.RED));
		btnStockDetails.setBackground(Color.BLACK);
		btnStockDetails.setBounds(10, 243, 145, 28);
		panel_1.add(btnStockDetails);
		
		label_5 = new JLabel("");
		label_5.setIcon(new ImageIcon(FormMainGUI.class.getResource("/img/left_panel/ico_09.png")));
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setBorder(new MatteBorder(1, 0, 1, 1, (Color) Color.RED));
		label_5.setBounds(154, 243, 31, 28);
		panel_1.add(label_5);
		
		button_3 = new JButton("Database Backups");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeOpenedChilds();
				desktopPane.add(new DatabaseBackup(desktopPane));
			}
		});
		button_3.setIcon(null);
		button_3.setPreferredSize(new Dimension(175, 28));
		button_3.setMinimumSize(new Dimension(175, 28));
		button_3.setMaximumSize(new Dimension(175, 28));
		button_3.setHorizontalTextPosition(SwingConstants.LEADING);
		button_3.setHorizontalAlignment(SwingConstants.LEFT);
		button_3.setForeground(Color.YELLOW);
		button_3.setFont(new Font("Baskerville Old Face", Font.PLAIN, 14));
		button_3.setBounds(new Rectangle(10, 10, 175, 28));
		button_3.setBorder(new MatteBorder(1, 1, 1, 0, (Color) Color.RED));
		button_3.setBackground(Color.BLACK);
		button_3.setBounds(10, 283, 145, 28);
		panel_1.add(button_3);
		
		JLabel label_6 = new JLabel("");
		label_6.setIcon(new ImageIcon(FormMainGUI.class.getResource("/img/left_panel/ico_09.png")));
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setBorder(new MatteBorder(1, 0, 1, 1, (Color) Color.RED));
		label_6.setBounds(154, 283, 31, 28);
		panel_1.add(label_6);
		
		panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 140, 0));
		tabbedPane.addTab("TEST", null, panel_2, null);
		panel_2.setLayout(null);
		
		btnTestCategories = new JButton("Test Categories");
		btnTestCategories.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeOpenedChilds();
				desktopPane.add(new TestCategory(desktopPane));
			}
		});
		btnTestCategories.setPreferredSize(new Dimension(175, 28));
		btnTestCategories.setMinimumSize(new Dimension(175, 28));
		btnTestCategories.setMaximumSize(new Dimension(175, 28));
		btnTestCategories.setHorizontalTextPosition(SwingConstants.LEADING);
		btnTestCategories.setHorizontalAlignment(SwingConstants.LEFT);
		btnTestCategories.setForeground(new Color(75, 0, 130));
		btnTestCategories.setFont(new Font("Baskerville Old Face", Font.PLAIN, 14));
		btnTestCategories.setBorder(new MatteBorder(1, 1, 1, 0, (Color) Color.RED));
		btnTestCategories.setBackground(new Color(255, 140, 0));
		btnTestCategories.setBounds(10, 11, 145, 28);
		panel_2.add(btnTestCategories);
		
		label_7 = new JLabel("");
		label_7.setIcon(new ImageIcon(FormMainGUI.class.getResource("/img/left_panel/ico_47.png")));
		label_7.setHorizontalAlignment(SwingConstants.CENTER);
		label_7.setBorder(new MatteBorder(1, 0, 1, 1, (Color) Color.RED));
		label_7.setBounds(154, 11, 31, 28);
		panel_2.add(label_7);
		
		btnExam = new JButton("Test Examinitions");
		btnExam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				closeOpenedChilds();
				desktopPane.add(new TestExamType(desktopPane));
			}
		});
		btnExam.setPreferredSize(new Dimension(175, 28));
		btnExam.setMinimumSize(new Dimension(175, 28));
		btnExam.setMaximumSize(new Dimension(175, 28));
		btnExam.setHorizontalTextPosition(SwingConstants.LEADING);
		btnExam.setHorizontalAlignment(SwingConstants.LEFT);
		btnExam.setForeground(new Color(75, 0, 130));
		btnExam.setFont(new Font("Baskerville Old Face", Font.PLAIN, 14));
		btnExam.setBorder(new MatteBorder(1, 1, 1, 0, (Color) Color.RED));
		btnExam.setBackground(new Color(255, 140, 0));
		btnExam.setBounds(10, 89, 145, 28);
		panel_2.add(btnExam);
		
		JLabel label_8 = new JLabel("");
		label_8.setIcon(new ImageIcon(FormMainGUI.class.getResource("/img/left_panel/ico_47.png")));
		label_8.setHorizontalAlignment(SwingConstants.CENTER);
		label_8.setBorder(new MatteBorder(1, 0, 1, 1, (Color) Color.RED));
		label_8.setBounds(154, 89, 31, 28);
		panel_2.add(label_8);
		
		btnTestSubCat = new JButton("Test Sub-Categories");
		btnTestSubCat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				closeOpenedChilds();
				desktopPane.add(new TestSubCategory(desktopPane));
			}
		});
		btnTestSubCat.setPreferredSize(new Dimension(175, 28));
		btnTestSubCat.setMinimumSize(new Dimension(175, 28));
		btnTestSubCat.setMaximumSize(new Dimension(175, 28));
		btnTestSubCat.setHorizontalTextPosition(SwingConstants.LEADING);
		btnTestSubCat.setHorizontalAlignment(SwingConstants.LEFT);
		btnTestSubCat.setForeground(new Color(75, 0, 130));
		btnTestSubCat.setFont(new Font("Baskerville Old Face", Font.PLAIN, 14));
		btnTestSubCat.setBorder(new MatteBorder(1, 1, 1, 0, (Color) Color.RED));
		btnTestSubCat.setBackground(new Color(255, 140, 0));
		btnTestSubCat.setBounds(10, 50, 145, 28);
		panel_2.add(btnTestSubCat);
		
		label_9 = new JLabel("");
		label_9.setIcon(new ImageIcon(FormMainGUI.class.getResource("/img/left_panel/ico_47.png")));
		label_9.setHorizontalAlignment(SwingConstants.CENTER);
		label_9.setBorder(new MatteBorder(1, 0, 1, 1, (Color) Color.RED));
		label_9.setBounds(154, 50, 31, 28);
		panel_2.add(label_9);
		
		btnAddMajorTests = new JButton("Add Major Tests");
		btnAddMajorTests.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeOpenedChilds();
				desktopPane.add(new MajorTests(desktopPane));
			}
		});
		btnAddMajorTests.setPreferredSize(new Dimension(175, 28));
		btnAddMajorTests.setMinimumSize(new Dimension(175, 28));
		btnAddMajorTests.setMaximumSize(new Dimension(175, 28));
		btnAddMajorTests.setHorizontalTextPosition(SwingConstants.LEADING);
		btnAddMajorTests.setHorizontalAlignment(SwingConstants.LEFT);
		btnAddMajorTests.setForeground(new Color(75, 0, 130));
		btnAddMajorTests.setFont(new Font("Baskerville Old Face", Font.PLAIN, 14));
		btnAddMajorTests.setBorder(new MatteBorder(1, 1, 1, 0, (Color) Color.RED));
		btnAddMajorTests.setBackground(new Color(255, 140, 0));
		btnAddMajorTests.setBounds(10, 128, 145, 28);
		panel_2.add(btnAddMajorTests);
		
		label_10 = new JLabel("");
		label_10.setIcon(new ImageIcon(FormMainGUI.class.getResource("/img/left_panel/ico_47.png")));
		label_10.setHorizontalAlignment(SwingConstants.CENTER);
		label_10.setBorder(new MatteBorder(1, 0, 1, 1, (Color) Color.RED));
		label_10.setBounds(154, 128, 31, 28);
		panel_2.add(label_10);
		
		btnAddTestFactors = new JButton("Add Test Factors");
		btnAddTestFactors.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				closeOpenedChilds();
				desktopPane.add(new TestFactors(desktopPane));
			}
		});
		btnAddTestFactors.setPreferredSize(new Dimension(175, 28));
		btnAddTestFactors.setMinimumSize(new Dimension(175, 28));
		btnAddTestFactors.setMaximumSize(new Dimension(175, 28));
		btnAddTestFactors.setHorizontalTextPosition(SwingConstants.LEADING);
		btnAddTestFactors.setHorizontalAlignment(SwingConstants.LEFT);
		btnAddTestFactors.setForeground(new Color(75, 0, 130));
		btnAddTestFactors.setFont(new Font("Baskerville Old Face", Font.PLAIN, 14));
		btnAddTestFactors.setBorder(new MatteBorder(1, 1, 1, 0, (Color) Color.RED));
		btnAddTestFactors.setBackground(new Color(255, 140, 0));
		btnAddTestFactors.setBounds(10, 167, 145, 28);
		panel_2.add(btnAddTestFactors);
		
		label_11 = new JLabel("");
		label_11.setIcon(new ImageIcon(FormMainGUI.class.getResource("/img/left_panel/ico_47.png")));
		label_11.setHorizontalAlignment(SwingConstants.CENTER);
		label_11.setBorder(new MatteBorder(1, 0, 1, 1, (Color) Color.RED));
		label_11.setBounds(154, 167, 31, 28);
		panel_2.add(label_11);
		
		JButton btnAddTestCharges = new JButton("Add Test Charges");
		btnAddTestCharges.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				closeOpenedChilds();
				desktopPane.add(new TestCharges(desktopPane));
			}
		});
		btnAddTestCharges.setPreferredSize(new Dimension(175, 28));
		btnAddTestCharges.setMinimumSize(new Dimension(175, 28));
		btnAddTestCharges.setMaximumSize(new Dimension(175, 28));
		btnAddTestCharges.setHorizontalTextPosition(SwingConstants.LEADING);
		btnAddTestCharges.setHorizontalAlignment(SwingConstants.LEFT);
		btnAddTestCharges.setForeground(new Color(75, 0, 130));
		btnAddTestCharges.setFont(new Font("Baskerville Old Face", Font.PLAIN, 14));
		btnAddTestCharges.setBorder(new MatteBorder(1, 1, 1, 0, (Color) Color.RED));
		btnAddTestCharges.setBackground(new Color(255, 140, 0));
		btnAddTestCharges.setBounds(10, 206, 145, 28);
		panel_2.add(btnAddTestCharges);
		
		JLabel label_12 = new JLabel("");
		label_12.setIcon(new ImageIcon(FormMainGUI.class.getResource("/img/left_panel/ico_47.png")));
		label_12.setHorizontalAlignment(SwingConstants.CENTER);
		label_12.setBorder(new MatteBorder(1, 0, 1, 1, (Color) Color.RED));
		label_12.setBounds(154, 206, 31, 28);
		panel_2.add(label_12);
		
		btnTestRequestForm = new JButton("Test Request Form");
		btnTestRequestForm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				closeOpenedChilds();
				desktopPane.add(new NewTestRequest(desktopPane));
			}
		});
		btnTestRequestForm.setPreferredSize(new Dimension(175, 28));
		btnTestRequestForm.setMinimumSize(new Dimension(175, 28));
		btnTestRequestForm.setMaximumSize(new Dimension(175, 28));
		btnTestRequestForm.setHorizontalTextPosition(SwingConstants.LEADING);
		btnTestRequestForm.setHorizontalAlignment(SwingConstants.LEFT);
		btnTestRequestForm.setForeground(new Color(75, 0, 130));
		btnTestRequestForm.setFont(new Font("Baskerville Old Face", Font.PLAIN, 14));
		btnTestRequestForm.setBorder(new MatteBorder(1, 1, 1, 0, (Color) Color.RED));
		btnTestRequestForm.setBackground(new Color(255, 140, 0));
		btnTestRequestForm.setBounds(10, 245, 145, 28);
		panel_2.add(btnTestRequestForm);
		
		label_13 = new JLabel("");
		label_13.setIcon(new ImageIcon(FormMainGUI.class.getResource("/img/left_panel/ico_47.png")));
		label_13.setHorizontalAlignment(SwingConstants.CENTER);
		label_13.setBorder(new MatteBorder(1, 0, 1, 1, (Color) Color.RED));
		label_13.setBounds(154, 245, 31, 28);
		panel_2.add(label_13);
		
		btnTestReadings = new JButton("Test Readings");
		btnTestReadings.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				closeOpenedChilds();
				desktopPane.add(new TestReadings(desktopPane));
			}
		});
		btnTestReadings.setPreferredSize(new Dimension(175, 28));
		btnTestReadings.setMinimumSize(new Dimension(175, 28));
		btnTestReadings.setMaximumSize(new Dimension(175, 28));
		btnTestReadings.setHorizontalTextPosition(SwingConstants.LEADING);
		btnTestReadings.setHorizontalAlignment(SwingConstants.LEFT);
		btnTestReadings.setForeground(new Color(75, 0, 130));
		btnTestReadings.setFont(new Font("Baskerville Old Face", Font.PLAIN, 14));
		btnTestReadings.setBorder(new MatteBorder(1, 1, 1, 0, (Color) Color.RED));
		btnTestReadings.setBackground(new Color(255, 140, 0));
		btnTestReadings.setBounds(10, 284, 145, 28);
		panel_2.add(btnTestReadings);
		
		JLabel label_14 = new JLabel("");
		label_14.setIcon(new ImageIcon(FormMainGUI.class.getResource("/img/left_panel/ico_47.png")));
		label_14.setHorizontalAlignment(SwingConstants.CENTER);
		label_14.setBorder(new MatteBorder(1, 0, 1, 1, (Color) Color.RED));
		label_14.setBounds(154, 284, 31, 28);
		panel_2.add(label_14);
		
		btnTestReports = new JButton("Test Reports");
		btnTestReports.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				closeOpenedChilds();
				desktopPane.add(new PendingReports(FormMainGUI.this,desktopPane));
			}
		});
		btnTestReports.setPreferredSize(new Dimension(175, 28));
		btnTestReports.setMinimumSize(new Dimension(175, 28));
		btnTestReports.setMaximumSize(new Dimension(175, 28));
		btnTestReports.setHorizontalTextPosition(SwingConstants.LEADING);
		btnTestReports.setHorizontalAlignment(SwingConstants.LEFT);
		btnTestReports.setForeground(new Color(75, 0, 130));
		btnTestReports.setFont(new Font("Baskerville Old Face", Font.PLAIN, 14));
		btnTestReports.setBorder(new MatteBorder(1, 1, 1, 0, (Color) Color.RED));
		btnTestReports.setBackground(new Color(255, 140, 0));
		btnTestReports.setBounds(10, 362, 145, 28);
		panel_2.add(btnTestReports);
		
		JLabel label_15 = new JLabel("");
		label_15.setIcon(new ImageIcon(FormMainGUI.class.getResource("/img/left_panel/ico_47.png")));
		label_15.setHorizontalAlignment(SwingConstants.CENTER);
		label_15.setBorder(new MatteBorder(1, 0, 1, 1, (Color) Color.RED));
		label_15.setBounds(154, 362, 31, 28);
		panel_2.add(label_15);
		
		JButton btnTestBill = new JButton("Test Bill");
		btnTestBill.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				closeOpenedChilds();
				desktopPane.add(new PendingBills(FormMainGUI.this,desktopPane));
			}
		});
		btnTestBill.setPreferredSize(new Dimension(175, 28));
		btnTestBill.setMinimumSize(new Dimension(175, 28));
		btnTestBill.setMaximumSize(new Dimension(175, 28));
		btnTestBill.setHorizontalTextPosition(SwingConstants.LEADING);
		btnTestBill.setHorizontalAlignment(SwingConstants.LEFT);
		btnTestBill.setForeground(new Color(75, 0, 130));
		btnTestBill.setFont(new Font("Baskerville Old Face", Font.PLAIN, 14));
		btnTestBill.setBorder(new MatteBorder(1, 1, 1, 0, (Color) Color.RED));
		btnTestBill.setBackground(new Color(255, 140, 0));
		btnTestBill.setBounds(10, 323, 145, 28);
		panel_2.add(btnTestBill);
		
		JLabel label_16 = new JLabel("");
		label_16.setIcon(new ImageIcon(FormMainGUI.class.getResource("/img/left_panel/ico_47.png")));
		label_16.setHorizontalAlignment(SwingConstants.CENTER);
		label_16.setBorder(new MatteBorder(1, 0, 1, 1, (Color) Color.RED));
		label_16.setBounds(154, 323, 31, 28);
		panel_2.add(label_16);
		
		
		this.pack();
		setVisible(true);
		
		LoginDialog lgnDialog=new LoginDialog(this);
		lgnDialog.setVisible(true);
	}
	
	public final void setUserProfile() {
		lblUserName.setText("Welcome User : \'" + cv.getUser().toUpperCase() + "\'.");
	}
	
	public void closeOpenedChilds() {
		JInternalFrame frames[] = desktopPane.getAllFrames();
		DesktopManager dm = desktopPane.getDesktopManager();
		for (int i = 0 ; i < frames.length ; i ++){
			dm.closeFrame(frames[i]);
			try {
				frames[i].setClosed(false);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		desktopPane.revalidate();
		desktopPane.repaint();
	}
	
	public Object[][] getTableData(){
		Object[][] temp;
		try {
			String SQL = "select reading_id,reading_date,cust_name from labsoft.tbl_reading_main where IsDelivered = 0;";
			DBManager dbconn = DBManager.getInstance();
			ResultSet rs = dbconn.selectRecords(SQL);
			if(rs != null) {
				rs.last();
				int count = rs.getRow();
				rs.beforeFirst();
				temp=new Object[count][3];
				int i = 0;
				while(rs.next()) {
					int id = rs.getInt(1);
					String date = rs.getString(2);
					String name = rs.getString(3);
					String sql1 = "select test_name from labsoft.tbl_reading_detail where reading_id = " + id +" limit 1;";
					ResultSet rs1 = dbconn.selectRecords(sql1);
					if(rs1.next()) {
						String tname = rs1.getString(1);
						temp[i][0] = date;
						temp[i][1] = name;
						temp[i][2] = tname;
						i++;
					}
				}
			}
			else {
				temp = new Object[0][3];
			}
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Can't Retrieve Test Information", cv.getLT(), JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
			temp = new Object[0][3];
		}
		return temp;
	}
}
