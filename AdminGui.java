//import java.awt.BorderLayout;
//import java.awt.EventQueue;
//
//import javax.swing.JFrame;
//import javax.swing.JPanel;
//import javax.swing.border.EmptyBorder;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFormattedTextField;
import java.awt.TextField;
import java.awt.Label;
import java.awt.Font;
import javax.swing.JScrollBar;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import java.awt.event.MouseWheelListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.MouseWheelEvent;
import javax.swing.JTable;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Checkbox;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class AdminGui extends JFrame {

	Connection con ; 
	PreparedStatement pst ;
	
	
	private JPanel contentPane;
	private JTextField Buildingname;
	private JTextField roomNumber1;
	private JTextField roomType1;
	private JTextField floorNumber1;
	private JTextField DeleteStudentTF;
	private JTextField DeleteStaffTF;
	private JTextField DeleteBuildingTF;
	private JTextField DeleteFloorTf;
	private JTextField DeleteRoomTF;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminGui frame = new AdminGui();
					frame.setVisible(true);
					frame.setTitle("Dorm Database");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AdminGui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 878, 655);

//		contentPane.setForeground(Color.BLACK);
		
		
		 
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(Color.decode("#c6e6f5"));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel(" Student");
		lblNewLabel.setBounds(10, 11, 92, 14);
		contentPane.add(lblNewLabel);

		TextField idTF = new TextField();
		idTF.setBounds(10, 44, 57, 22);
		contentPane.add(idTF);

		TextField firstTF = new TextField();
		firstTF.setBounds(78, 44, 57, 22);
		contentPane.add(firstTF);

		TextField lastTF = new TextField();
		lastTF.setBounds(148, 44, 57, 22);
		contentPane.add(lastTF);

		TextField nationalityTF = new TextField();
		nationalityTF.setBounds(215, 44, 64, 22);
		contentPane.add(nationalityTF);

		TextField genderTF = new TextField();
		genderTF.setBounds(285, 44, 57, 22);
		contentPane.add(genderTF);

		TextField ageTF = new TextField();
		ageTF.setBounds(357, 44, 57, 22);
		contentPane.add(ageTF);

		TextField phoneTF = new TextField();
		phoneTF.setBounds(431, 44, 57, 22);
		contentPane.add(phoneTF);

		TextField roommateTF = new TextField();
		roommateTF.setBounds(494, 44, 71, 22);
		contentPane.add(roommateTF);

		Label label = new Label("ID");
		label.setBounds(10, 27, 62, 22);
		contentPane.add(label);

		Label label_1 = new Label("First Name");
		label_1.setBounds(80, 27, 62, 22);
		label_1.setFont(new Font("Dialog", Font.PLAIN, 10));
		contentPane.add(label_1);

		Label label_2 = new Label("Last Name");
		label_2.setBounds(148, 27, 62, 22);
		label_2.setFont(new Font("Dialog", Font.PLAIN, 10));
		contentPane.add(label_2);

		Label label_3 = new Label("Nationality");
		label_3.setBounds(217, 27, 62, 22);
		label_3.setFont(new Font("Dialog", Font.PLAIN, 10));
		contentPane.add(label_3);

		Label label_4 = new Label("Gender");
		label_4.setBounds(285, 27, 62, 22);
		label_4.addMouseWheelListener(new MouseWheelListener() {
			public void mouseWheelMoved(MouseWheelEvent e) {
			}
		});
		label_4.setFont(new Font("Dialog", Font.PLAIN, 10));
		contentPane.add(label_4);

		Label label_5 = new Label("Age");
		label_5.setBounds(357, 27, 62, 22);
		label_5.setFont(new Font("Dialog", Font.PLAIN, 10));
		contentPane.add(label_5);

		Label label_6 = new Label("# phone");
		label_6.setBounds(431, 27, 62, 22);
		label_6.setFont(new Font("Dialog", Font.PLAIN, 10));
		contentPane.add(label_6);

		Label label_7 = new Label("Roommate");
		label_7.setBounds(499, 27, 84, 22);
		label_7.setFont(new Font("Dialog", Font.PLAIN, 10));
		contentPane.add(label_7);
		
		
		TextField roomstudentTF = new TextField();
		roomstudentTF.setBounds(571, 44, 71, 22);
		contentPane.add(roomstudentTF);

		
		
		JButton btnNewButton = new JButton("Insert");
		btnNewButton.setBounds(668, 44, 89, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				try
				{
					int id = Integer.parseInt(idTF.getText()) ; 
					String firstname = firstTF.getText() ; 
					String lastname = lastTF.getText() ; 
					String nationality = nationalityTF.getText() ; 
					int age =  Integer.parseInt(ageTF.getText()) ; 
					String gender = genderTF.getText() ; 
					int phone = Integer.parseInt(phoneTF.getText() ); 
					int room = Integer.parseInt(roomstudentTF.getText()) ; 
					
					
					
					
					if(roommateTF.getText().equals("") || roommateTF.getText().equals(null))
					{
						pst = con.prepareStatement("insert into student(ID,First_name,Last_name,Nationality,Age,Gender,Phone_number,Room_number) values(?,?,? ,?,?,? ,?,?)") ;
						pst.setInt(1, id);
						pst.setString(2, firstname);
						pst.setString(3, lastname);
						pst.setString(4, nationality);
						pst.setInt(5, age);
						pst.setString(6, gender);
						pst.setInt(7, phone);
						pst.setInt(8, room);
						pst.executeUpdate();
						JOptionPane.showMessageDialog(null, "Student is added successfully");
						idTF.setText("");
						firstTF.setText("");
						lastTF.setText("");
						nationalityTF.setText("");
						ageTF.setText("");
						genderTF.setText("");
						phoneTF.setText("");
						roomstudentTF.setText("");
						roommateTF.setText("");
					}
					else
					{
						int roommate = Integer.parseInt(roommateTF.getText()); 
						pst = con.prepareStatement("insert into student(ID,First_name,Last_name,Nationality,Age,Gender,Phone_number,Room_number,Roommate) values(?,?,? ,?,?,? ,?,?,?)") ;
						pst.setInt(1, id);
						pst.setString(2, firstname);
						pst.setString(3, lastname);
						pst.setString(4, nationality);
						pst.setInt(5, age);
						pst.setString(6, gender);
						pst.setInt(7, phone);
						pst.setInt(8, room);
						pst.setInt(9,roommate);
						
	
						pst.executeUpdate();
						JOptionPane.showMessageDialog(null, "Student is added successfully");
						idTF.setText("");
						firstTF.setText("");
						lastTF.setText("");
						nationalityTF.setText("");
						ageTF.setText("");
						genderTF.setText("");
						phoneTF.setText("");
						roomstudentTF.setText("");
						roommateTF.setText("");
					}
					
					
				  System.out.println(firstname);
				}
				catch(Exception p) 
				{
					JOptionPane.showMessageDialog(null, "Error, check the data you are entering");
					System.out.println(p.getMessage());
				}
				
						
//				int Actid = Integer.parseInt((String) Aid.getText());
//				String actfirst = Afirst.getText();
//				String actlast = Alast.getText();
//				double actrate = Double.parseDouble((String) Arate.getText());
//				String actgender = Agender.getText();
//				String actbirt = Abirth.getText();
//				int actnum = Integer.parseInt(Aphone.getText());
//				String actcoun = Acountry.getText();
//				String actstart = Astart.getText();
//				String actend = Aend.getText();
//				
//				admin.InsertActor(Actid, actfirst, actlast, actrate, actgender, actbirt, actnum, actcoun, actstart,
//						actend);
			}
		});
	
		
		
		contentPane.add(btnNewButton);

		
		Label lblNewLabel_1 = new Label(
				"- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - "
				);
		lblNewLabel_1.setBounds(10, 72, 619, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Staff");
		lblNewLabel_2.setBounds(10, 95, 84, 14);
		contentPane.add(lblNewLabel_2);

		TextField idStaff = new TextField();
		idStaff.setBounds(10, 133, 57, 22);
		contentPane.add(idStaff);

		TextField firstStaff = new TextField();
		firstStaff.setBounds(78, 133, 57, 22);
		contentPane.add(firstStaff);

		TextField lastStaff = new TextField();
		lastStaff.setBounds(148, 133, 57, 22);
		contentPane.add(lastStaff);

		TextField genderStaff = new TextField();
		genderStaff.setBounds(215, 133, 57, 22);
		contentPane.add(genderStaff);

		TextField ageStaff = new TextField();
		ageStaff.setBounds(285, 133, 57, 22);
		contentPane.add(ageStaff);

		TextField nationStaff = new TextField();
		nationStaff.setBounds(355, 133, 57, 22);
		contentPane.add(nationStaff);

		TextField timeStaff = new TextField();
		timeStaff.setBounds(431, 133, 57, 22);
		contentPane.add(timeStaff);

		Label idTF2 = new Label("ID");
		idTF2.setBounds(10, 115, 62, 22);
		idTF2.setFont(new Font("Dialog", Font.PLAIN, 10));
		contentPane.add(idTF2);

		Label label_10 = new Label("First Name");
		label_10.setBounds(78, 115, 62, 22);
		label_10.setFont(new Font("Dialog", Font.PLAIN, 10));
		contentPane.add(label_10);

		Label label_11 = new Label("Last Name");
		label_11.setBounds(148, 115, 62, 22);
		label_11.setFont(new Font("Dialog", Font.PLAIN, 10));
		contentPane.add(label_11);

		Label label_12 = new Label("gendre");
		label_12.setBounds(215, 115, 62, 22);
		label_12.setFont(new Font("Dialog", Font.PLAIN, 10));
		contentPane.add(label_12);

		Label label_13 = new Label("Age");
		label_13.setBounds(285, 115, 62, 22);
		label_13.setFont(new Font("Dialog", Font.PLAIN, 10));
		contentPane.add(label_13);

		Label label_14 = new Label("Nationality");
		label_14.setBounds(357, 115, 62, 22);
		label_14.setFont(new Font("Dialog", Font.PLAIN, 10));
		contentPane.add(label_14);

		Label label_15 = new Label("Time");
		label_15.setBounds(431, 115, 62, 22);
		label_15.setFont(new Font("Dialog", Font.PLAIN, 10));
		contentPane.add(label_15);
		
		TextField ppf = new TextField();
		ppf.setBounds(499, 133, 57, 22);
		contentPane.add(ppf);
		
		JButton button = new JButton("Insert");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try
				{
					int id = Integer.parseInt(idStaff.getText()) ; 
					String first = firstStaff.getText() ; 
					String last = lastStaff.getText() ; 
					String gender = genderStaff.getText() ;
					int age = Integer.parseInt(ageStaff.getText()) ;
					String nation = nationStaff.getText() ; 
					String time = timeStaff.getText() ; 
					int phone = Integer.parseInt(ppf.getText()) ; 
					pst = con.prepareStatement("insert into staff values(?,?,?,?,?,?,?,?)") ;
					 
					pst.setInt(1, id);
					pst.setString(2, first);
					pst.setString(3, last);
					pst.setString(4, nation);
					pst.setInt(5, age);
					pst.setString(6, gender);
					pst.setInt(7,phone);
					pst.setString(8, time);
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Staff is added successfully");

					idStaff.setText("");
					firstStaff.setText("");
					lastStaff.setText("");
					genderStaff.setText("");
					ageStaff.setText("");
					nationStaff.setText("");
					timeStaff.setText("");
					ppf.setText("");
					
				}
				catch(Exception p )
				{
					JOptionPane.showMessageDialog(null, "Error, check the data you are entering");
				}
			}
		});
		button.setBounds(668, 132, 89, 23);
		contentPane.add(button);
		
		
		Label label_16 = new Label(
				"- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
		label_16.setBounds(10, 152, 619, 22);
		contentPane.add(label_16);
		
		
		JLabel lblInsertScreenProduct = new JLabel(" Building");
		lblInsertScreenProduct.setBounds(10, 175, 172, 14);
		contentPane.add(lblInsertScreenProduct);

		TextField nameBuilding = new TextField();
		nameBuilding.setBounds(12, 210, 57, 22);
		contentPane.add(nameBuilding);

		TextField locationBuilding = new TextField();
		locationBuilding.setBounds(78, 210, 64, 22);
		contentPane.add(locationBuilding);
		


		Label label_20 = new Label("Name");
		label_20.setBounds(10, 192, 62, 22);
		contentPane.add(label_20);

		Label label_21 = new Label("Location");
		label_21.setBounds(80, 192, 62, 22);
		contentPane.add(label_21);

		Label label_28 = new Label(
				"- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
		label_28.setBounds(10, 233, 619, 22);
		contentPane.add(label_28);
		
		JLabel lblLounge = new JLabel(" Lounge");
		lblLounge.setBounds(10, 252, 172, 14);
		contentPane.add(lblLounge);
		
		
		TextField nameLounge = new TextField();
		nameLounge.setBounds(10, 289, 57, 22);
		contentPane.add(nameLounge);

		TextField numberLounge = new TextField();
		numberLounge.setBounds(78, 289, 64, 22);
		contentPane.add(numberLounge);

		Label label_30 = new Label("Name");
		label_30.setBounds(10, 269, 62, 22);
		contentPane.add(label_30);

		Label label_31 = new Label("Number");
		label_31.setBounds(78, 269, 62, 22);
		contentPane.add(label_31);
		TextField genderBuilding = new TextField();
		genderBuilding.setBounds(162, 210, 64, 22);
		contentPane.add(genderBuilding);
		JButton button_1 = new JButton("Insert");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try
				{
					String name = nameBuilding.getText() ; 
					String location = locationBuilding.getText() ; 
					String gender = genderBuilding.getText() ; 
					pst = con.prepareStatement("insert into building values(?,?,?)") ;
					 
					pst.setString(1, name);
					pst.setString(2, location);
					pst.setString(3, gender);
					
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Building is added successfully");
					nameBuilding.setText("");
					locationBuilding.setText("");
					genderBuilding.setText("");
				}
				catch(Exception p ) 
				{
					JOptionPane.showMessageDialog(null, "Error, check the data you are entering");
				}
			}
		});
		button_1.setBounds(668, 210, 89, 23);
		contentPane.add(button_1);
		
		
		Label label_32 = new Label(
				"- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
		label_32.setBounds(10, 311, 620, 22);
		contentPane.add(label_32);
		
		
		
		
		JLabel lblNewLabel_3 = new JLabel("Room");
		lblNewLabel_3.setBounds(10, 430, 160, 14);
		contentPane.add(lblNewLabel_3);

		TextField fstaff = new TextField();
		fstaff.setBounds(391, 374, 102, 22);
		contentPane.add(fstaff);

		TextField nboccupied = new TextField();
		nboccupied.setBounds(252, 374, 125, 22);
		contentPane.add(nboccupied);

		Label label_34 = new Label("New expiry date");
		label_34.setBounds(312, 296, 102, 22);
		contentPane.add(label_3);

		TextField buildingl = new TextField();
		TextField seats = new TextField();
		TextField tv = new TextField();

		
		JButton button_2 = new JButton("Insert");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try
				{
					String name = nameLounge.getText() ; 
					int number = Integer.parseInt(numberLounge.getText()) ; 
					int nseats = Integer.parseInt(seats.getText() ) ; 
					int ntv = Integer.parseInt(tv.getText()) ; 
					String building = buildingl.getText() ; 
					pst = con.prepareStatement("insert into lounge values(?,?,?,?,?)") ;
					pst.setString(1, name);
					pst.setInt(2, number);
					pst.setInt(3, nseats);
					pst.setInt(4, ntv);
					pst.setString(5, building);
					
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Lounge is added successfully");
					nameLounge.setText("");
					numberLounge.setText("");
					seats.setText("");
					tv.setText("");
					buildingl.setText("");
					
				}
				catch(Exception p) 
				{
					JOptionPane.showMessageDialog(null, "Error, check the data you are entering");
				}
			}
		});
		button_2.setBounds(668, 274, 89, 23);
		contentPane.add(button_2);

		JLabel lblNewLabel_4 = new JLabel("Floor");
		lblNewLabel_4.setBounds(20, 329, 154, 14);
		contentPane.add(lblNewLabel_4);

		TextField floornumber = new TextField();
		floornumber.setBounds(10, 374, 102, 22);
		contentPane.add(floornumber);

		TextField nbrooms = new TextField();
		nbrooms.setBounds(130, 374, 102, 22);
		contentPane.add(nbrooms);
		
		JLabel label_8 = new JLabel("Floor number");
		label_8.setBounds(10, 354, 92, 14);
		label_8.setFont(new Font("Dialog", Font.PLAIN, 10));
		contentPane.add(label_8);
		
		JLabel label_9 = new JLabel("Number of rooms");
		label_9.setBounds(130, 354, 102, 14);
		label_9.setFont(new Font("Dialog", Font.PLAIN, 10));
		contentPane.add(label_9);
		
		JLabel label_17 = new JLabel("Number of occupied rooms");
		label_17.setBounds(252, 354, 125, 14);
		label_17.setFont(new Font("Dialog", Font.PLAIN, 10));
		contentPane.add(label_17);
		
		JLabel lblStaff = new JLabel("Staff");
		lblStaff.setBounds(401, 354, 99, 14);
		lblStaff.setFont(new Font("Dialog", Font.PLAIN, 10));
		contentPane.add(lblStaff);
		TextField fbuilding = new TextField();

		
		JButton button_3 = new JButton("Insert");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try
				{
					 
					    
					    
					    int floor =  Integer.parseInt(floornumber.getText()); 
					    int rooms =  Integer.parseInt(nbrooms.getText());
					    int occ =  Integer.parseInt(nboccupied.getText());
					    int staff =  Integer.parseInt(fstaff.getText());
					    String building = fbuilding.getText();
					    
					    
					    pst = con.prepareStatement("insert into floor values(?,?,?,?,?)") ;
					    pst.setInt(1, floor);
					    pst.setInt(2, rooms);
					    pst.setInt(3, occ);
					    pst.setInt(4, staff);
					    pst.setString(5, building);
					    
					    pst.executeUpdate();
						JOptionPane.showMessageDialog(null, "Floor is added successfully");
						
						floornumber.setText("");
						nbrooms.setText("");
						nboccupied.setText("");
						fstaff.setText("");
						fbuilding.setText("");
					
				}
				catch(Exception p )
				{
					JOptionPane.showMessageDialog(null, "Error, check the data you are entering");
				}
			}
		});
		button_3.setBounds(668, 374, 89, 23);
		contentPane.add(button_3);
		
		roomNumber1 = new JTextField();
		roomNumber1.setBounds(10, 467, 96, 20);
		contentPane.add(roomNumber1);
		roomNumber1.setColumns(10);
		
		roomType1 = new JTextField();
		roomType1.setBounds(130, 467, 96, 20);
		roomType1.setColumns(10);
		contentPane.add(roomType1);
		
		floorNumber1 = new JTextField();
		floorNumber1.setBounds(252, 467, 96, 20);
		floorNumber1.setColumns(10);
		contentPane.add(floorNumber1);
		
		JLabel label_19 = new JLabel("Room number");
		label_19.setBounds(10, 455, 92, 14);
		label_19.setFont(new Font("Dialog", Font.PLAIN, 10));
		contentPane.add(label_19);
		
		JLabel label_22 = new JLabel("Room type");
		label_22.setBounds(130, 455, 92, 14);
		label_22.setFont(new Font("Dialog", Font.PLAIN, 10));
		contentPane.add(label_22);
		
		JLabel lblFloorNumber = new JLabel("Floor number");
		lblFloorNumber.setBounds(252, 455, 92, 14);
		lblFloorNumber.setFont(new Font("Dialog", Font.PLAIN, 10));
		contentPane.add(lblFloorNumber);
		
		
		
		
		
		
		
		JButton button_4 = new JButton("Insert");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try
				{
					int room = Integer.parseInt(roomNumber1.getText()); 
					System.out.println(room);
					String type =roomType1.getText() ; 
					System.out.println(type);
					int floor = Integer.parseInt(floorNumber1.getText());  
					System.out.println(floor);
					
					pst = con.prepareStatement("insert into room values(?,?,?)") ;
					
					pst.setInt(1, room);
					pst.setString(2, type);
					pst.setInt(3, floor);
					
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Room is added successfully");
					roomNumber1.setText("");
					roomType1.setText("");
					floorNumber1.setText("");

					
					
				}
				
				catch(Exception p )
				{
					JOptionPane.showMessageDialog(null, "Error, check the data you are entering");
					System.out.println(p.getMessage());
				}
			}
		});
		button_4.setBounds(668, 466, 89, 23);
		contentPane.add(button_4);
		
		JButton updateStudent = new JButton("Update");
		updateStudent.setBounds(765, 44, 89, 23);
		updateStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					System.out.println(roomstudentTF.getText());
					if(idTF.getText().equals(null) || idTF.getText().equals("")) 
					{
						JOptionPane.showMessageDialog(null, "Error, check the id of the student you are entering");
						return  ;
					}
					if(roomstudentTF.getText().equals(null) ||roomstudentTF.getText().equals("") )
					{
						pst = con.prepareStatement("update Student set Phone_number=? where ID=?") ;
						pst.setInt(1, Integer.parseInt(phoneTF.getText()));
						pst.setInt(2, Integer.parseInt(idTF.getText()));
						pst.executeUpdate();
						JOptionPane.showMessageDialog(null, "Student phone number is updated");
						phoneTF.setText("");
						idTF.setText("");
						
					}
					else if(phoneTF.getText().equals(null) ||phoneTF.getText().equals("") )
					{
						pst = con.prepareStatement("update Student set Room_number=? where ID=?") ;
						pst.setInt(1, Integer.parseInt(roomstudentTF.getText()));
						pst.setInt(2, Integer.parseInt(idTF.getText()));
						pst.executeUpdate();
						JOptionPane.showMessageDialog(null, "Student room number is updated");
						roomstudentTF.setText("");
						idTF.setText("");
						
						
					}
					else
					{
						pst = con.prepareStatement("update Student set Room_number=?,Phone_number=? where ID=?") ;
						pst.setInt(1, Integer.parseInt(roomstudentTF.getText()));
						pst.setInt(2, Integer.parseInt(phoneTF.getText()));
						pst.setInt(3, Integer.parseInt(idTF.getText()));
						pst.executeUpdate();
						JOptionPane.showMessageDialog(null, "Student phone number and room  are updated");
						phoneTF.setText("");
						roomstudentTF.setText("");
						idTF.setText("");
					}
				}
				catch(Exception p )
				{
					JOptionPane.showMessageDialog(null, "Error, check the new room number or the new phone number you are entering");
					System.out.println(p.getCause());
				}
				
				
			}
		});
		contentPane.add(updateStudent);
		
		JButton updateStaff = new JButton("Update");
		updateStaff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try
				{
					if(idStaff.getText().equals(null) || idStaff.getText().equals("")) 
					{
						JOptionPane.showMessageDialog(null, "Error, check the id of the staff you are entering");
						return  ;
					}
					if(timeStaff.getText().equals(null) ||timeStaff.getText().equals("") )
					{
						pst = con.prepareStatement("update staff set Phone_number=? where ID=?") ;
						pst.setInt(1, Integer.parseInt(ppf.getText()));
						pst.setInt(2, Integer.parseInt(idStaff.getText()));
						pst.executeUpdate();
						JOptionPane.showMessageDialog(null, "Staff phone number is updated");
						ppf.setText("");
						idStaff.setText("");
						
					}
					else if(ppf.getText().equals(null) ||ppf.getText().equals("") )
					{
						pst = con.prepareStatement("update staff set Working_time =? where ID=?") ;
						pst.setString(1,timeStaff.getText());
						pst.setInt(2, Integer.parseInt(idStaff.getText()));
						pst.executeUpdate();
						JOptionPane.showMessageDialog(null, "Staff working time is updated");
						timeStaff.setText("");
						idStaff.setText("");
						
					}
					else
					{
						pst = con.prepareStatement("update staff set Phone_number=?,Working_time=? where ID=?") ; 
						pst.setInt(1, Integer.parseInt(ppf.getText()));
						pst.setString(2, timeStaff.getText());
						pst.setInt(3, Integer.parseInt(idStaff.getText()));
						pst.executeUpdate();
						JOptionPane.showMessageDialog(null, "Staff phone number and working time  are updated");
						timeStaff.setText("");
						idStaff.setText("");
						ppf.setText("");
					}
				}
				catch(Exception p )
				{
					JOptionPane.showMessageDialog(null, "Error, check the new working time or the new phone number you are entering");
				}
				
			}
		});
		updateStaff.setBounds(765, 132, 89, 23);
		contentPane.add(updateStaff);
		
		JButton updateBuilding = new JButton("Update");
		updateBuilding.setBounds(765, 210, 89, 23);
		updateBuilding.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					if(nameBuilding.getText().equals(null) || nameBuilding.getText().equals("")) 
					{
						JOptionPane.showMessageDialog(null, "Error, check the name of the building you are entering");
						return  ;
					}
					pst = con.prepareStatement("update building set Location =? where Name =?") ; 
					pst.setString(1, locationBuilding.getText());
					pst.setString(2, nameBuilding.getText());
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Building location is updated successfully");
					nameBuilding.setText("");
					locationBuilding.setText("");
					
				}
				catch(Exception p)
				{
					JOptionPane.showMessageDialog(null, "Error, check the new location  you are entering");
				}
			}
		});
		contentPane.add(updateBuilding);
		
		JButton updateLounge = new JButton("Update");
		updateLounge.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					if(nameLounge.getText().equals(null) || nameLounge.getText().equals("") || numberLounge.getText().equals("")) 
					{
						JOptionPane.showMessageDialog(null, "Error, check the name or the number of the lounge you are entering");
						return  ;
					}
					pst = con.prepareStatement("update lounge set Number_seats  =? where Name =? and Number =?") ;
					pst.setInt(1, Integer.parseInt(seats.getText()));
					pst.setString(2, nameLounge.getText());
					pst.setInt(3, Integer.parseInt(numberLounge.getText()));
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Lounge number of seats is updated");
					seats.setText("");
					nameLounge.setText("");
					numberLounge.setText("");
					
					
				}
				catch(Exception p )
				{
					JOptionPane.showMessageDialog(null, "Error, check the new number of seats you are entering");
				}
			}
		});
		updateLounge.setBounds(767, 274, 89, 23);
		contentPane.add(updateLounge);
		
		JButton updateFloor = new JButton("Update");
		updateFloor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try
				{
					if(floornumber.getText().equals(null) || floornumber.getText().equals("")) 
					{
						JOptionPane.showMessageDialog(null, "Error, check the floor number  you are entering");
						return  ;
					}
					pst = con.prepareStatement("update floor set Number_occupied =? where Number =?") ;
					pst.setInt(2, Integer.parseInt(floornumber.getText()));
					pst.setInt(1, Integer.parseInt(nboccupied.getText()));
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Floor's number of occupied rooms is updated");
					floornumber.setText("");
					nboccupied.setText("");
				}
				catch(Exception p)
				{
					JOptionPane.showMessageDialog(null, "Error, check the new number of occupied rooms  you are entering");
				}
			}
		});
		updateFloor.setBounds(767, 374, 89, 23);
		contentPane.add(updateFloor);
		
		JButton updateRoom = new JButton("Update");
		updateRoom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try
				{
					if(roomNumber1.getText().equals(null) || roomNumber1.getText().equals("")) 
					{
						JOptionPane.showMessageDialog(null, "Error, check the room number you are entering");
						return  ;
					}
					pst = con.prepareStatement("update room set Type =? where Number =?") ;
					pst.setString(1, roomType1.getText());
					pst.setInt(2, Integer.parseInt(roomNumber1.getText()));
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Room type  is updated");
					roomType1.setText("");
					roomNumber1.setText("");
					
				}
				catch(Exception p)
				{
					JOptionPane.showMessageDialog(null, "Error, check the new type  you are entering");
				}
			}
		});
		updateRoom.setBounds(765, 466, 89, 23);
		contentPane.add(updateRoom);
		
		Label label_24 = new Label("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
		label_24.setBounds(10, 402, 620, 22);
		contentPane.add(label_24);
		
		Label label_25 = new Label("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
		label_25.setBounds(10, 485, 620, 22);
		contentPane.add(label_25);
		
		JLabel label_26 = new JLabel("Delete Student");
		label_26.setBounds(10, 503, 92, 14);
		contentPane.add(label_26);
		
		JLabel label_27 = new JLabel("ID");
		label_27.setBounds(10, 518, 92, 14);
		label_27.setFont(new Font("Dialog", Font.PLAIN, 10));
		contentPane.add(label_27);
		
		DeleteStudentTF = new JTextField();
		DeleteStudentTF.setBounds(6, 537, 96, 20);
		DeleteStudentTF.setColumns(10);
		contentPane.add(DeleteStudentTF);
		
		JButton DeletStudentButton = new JButton("Delete");
		DeletStudentButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try
				{
					pst = con.prepareStatement("delete from student where id=?") ; 
					pst.setInt(1, Integer.parseInt(DeleteStudentTF.getText()));
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Student is delete successfully");
					DeleteStudentTF.setText("");
				}
				catch(Exception p)
				{
					JOptionPane.showMessageDialog(null, "Error, check the id  you are entering");
				}
				
			}
			
		});
		DeletStudentButton.setBounds(6, 571, 96, 23);
		contentPane.add(DeletStudentButton);
		
		JLabel label_33 = new JLabel("Delete Staff");
		label_33.setBounds(113, 503, 92, 14);
		contentPane.add(label_33);
		
		JLabel label_35 = new JLabel("Delete Building");
		label_35.setBounds(228, 503, 102, 14);
		contentPane.add(label_35);
		
		JLabel label_37 = new JLabel("Delete floor");
		label_37.setBounds(338, 503, 92, 14);
		contentPane.add(label_37);
		
		JLabel label_38 = new JLabel("Delete room");
		label_38.setBounds(446, 503, 92, 14);
		contentPane.add(label_38);
		
		JLabel label_39 = new JLabel("ID");
		label_39.setBounds(113, 518, 92, 14);
		label_39.setFont(new Font("Dialog", Font.PLAIN, 10));
		contentPane.add(label_39);
		
		DeleteStaffTF = new JTextField();
		DeleteStaffTF.setBounds(109, 537, 96, 20);
		DeleteStaffTF.setColumns(10);
		contentPane.add(DeleteStaffTF);
		
		JLabel label_40 = new JLabel("Name");
		label_40.setBounds(229, 518, 92, 14);
		label_40.setFont(new Font("Dialog", Font.PLAIN, 10));
		contentPane.add(label_40);
		
		DeleteBuildingTF = new JTextField();
		DeleteBuildingTF.setBounds(228, 537, 96, 20);
		DeleteBuildingTF.setColumns(10);
		contentPane.add(DeleteBuildingTF);
		
		JLabel label_41 = new JLabel("Number");
		label_41.setBounds(338, 518, 92, 14);
		label_41.setFont(new Font("Dialog", Font.PLAIN, 10));
		contentPane.add(label_41);
		
		DeleteFloorTf = new JTextField();
		DeleteFloorTf.setBounds(334, 537, 96, 20);
		DeleteFloorTf.setColumns(10);
		contentPane.add(DeleteFloorTf);
		
		JButton DeleteStaffButton = new JButton("Delete");
		DeleteStaffButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try
				{
					pst = con.prepareStatement("delete from staff where id=?") ; 
					pst.setInt(1, Integer.parseInt(DeleteStaffTF.getText()));
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Staff is delete successfully");
					DeleteStaffTF.setText("");
					
				}
				catch(Exception p)
				{
					JOptionPane.showMessageDialog(null, "Error, check the id  you are entering");
				}
			}
		});
		DeleteStaffButton.setBounds(111, 571, 96, 23);
		contentPane.add(DeleteStaffButton);
		
		JButton DeleteBuildingButton = new JButton("Delete");
		DeleteBuildingButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					pst = con.prepareStatement("delete from building where name=?") ; 
					pst.setString(1,DeleteBuildingTF.getText());
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Building is delete successfully");
					DeleteBuildingTF.setText("");
				}
				catch(Exception p)
				{
					JOptionPane.showMessageDialog(null, "Error, check the name  you are entering");
				}
			}
		});
		DeleteBuildingButton.setBounds(228, 571, 96, 23);
		contentPane.add(DeleteBuildingButton);
		
		JButton DeleteFloorButton = new JButton("Delete");
		DeleteFloorButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					pst = con.prepareStatement("delete from floor where number=?") ; 
					pst.setInt(1, Integer.parseInt(DeleteFloorTf.getText()));
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Floor is delete successfully");
					DeleteFloorTf.setText("");
				}
				catch(Exception p)
				{
					JOptionPane.showMessageDialog(null, "Error, check the floor  you are entering");
				}
			}
		});
		DeleteFloorButton.setBounds(334, 571, 96, 23);
		contentPane.add(DeleteFloorButton);
		
		JLabel label_42 = new JLabel("Number");
		label_42.setBounds(446, 518, 92, 14);
		label_42.setFont(new Font("Dialog", Font.PLAIN, 10));
		contentPane.add(label_42);
		
		DeleteRoomTF = new JTextField();
		DeleteRoomTF.setBounds(442, 537, 96, 20);
		DeleteRoomTF.setColumns(10);
		contentPane.add(DeleteRoomTF);
		
		JButton DeleteRoomButton = new JButton("Delete");
		DeleteRoomButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					pst = con.prepareStatement("delete from room where number=?") ; 
					pst.setInt(1, Integer.parseInt(DeleteRoomTF.getText()));
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Room is delete successfully");
					DeleteRoomTF.setText("");
				}
				catch(Exception p)
				{
					JOptionPane.showMessageDialog(null, "Error, check the room number you are entering");
				}
			}
		});
		DeleteRoomButton.setBounds(442, 571, 96, 23);
		contentPane.add(DeleteRoomButton);
		
		Label label_5_1 = new Label("Room");
		label_5_1.setFont(new Font("Dialog", Font.PLAIN, 10));
		label_5_1.setBounds(589, 27, 65, 22);
		contentPane.add(label_5_1);
		
		
		
		Label label_6_1 = new Label("# phone");
		label_6_1.setFont(new Font("Dialog", Font.PLAIN, 10));
		label_6_1.setBounds(494, 115, 62, 22);
		contentPane.add(label_6_1);
		
		
		
//		TextField genderBuilding = new TextField();
//		genderBuilding.setBounds(162, 210, 64, 22);
//		contentPane.add(genderBuilding);
		
		Label label_21_1 = new Label("Gender");
		label_21_1.setBounds(162, 192, 62, 22);
		contentPane.add(label_21_1);
		
		Label label_31_1 = new Label("Nb seats");
		label_31_1.setBounds(148, 269, 64, 22);
		contentPane.add(label_31_1);
		
		seats.setBounds(148, 289, 64, 22);
		contentPane.add(seats);
		
		tv.setBounds(226, 289, 64, 22);
		contentPane.add(tv);
		
		buildingl.setBounds(296, 289, 64, 22);
		contentPane.add(buildingl);
		
		Label label_31_1_1 = new Label("Nb tv");
		label_31_1_1.setBounds(246, 269, 71, 22);
		contentPane.add(label_31_1_1);
		
		Label label_31_1_1_1 = new Label("Building");
		label_31_1_1_1.setBounds(302, 269, 112, 22);
		contentPane.add(label_31_1_1_1);
		
		fbuilding.setBounds(513, 374, 102, 22);
		contentPane.add(fbuilding);
		
		JLabel lblBuilding = new JLabel("Building");
		lblBuilding.setFont(new Font("Dialog", Font.PLAIN, 10));
		lblBuilding.setBounds(510, 354, 99, 14);
		contentPane.add(lblBuilding);
		
		JButton readAndqueries = new JButton("Read and Queries");
		readAndqueries.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				UserGui secondpage = new UserGui() ; 
//				
				secondpage.setVisible(true);
				setVisible(false) ; 
				
			}
		});
		readAndqueries.setFont(new Font("Tahoma", Font.BOLD, 21));
		readAndqueries.setForeground(Color.DARK_GRAY);
		readAndqueries.setBounds(587, 551, 235, 23);
		contentPane.add(readAndqueries);
		
		
		
		
		
		connect() ;
		
		
	}
	
	public void connect()
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver") ; 
			con = DriverManager.getConnection("jdbc:mysql://localhost/housing277", "root", "") ; 
			
		}
		catch(ClassNotFoundException  e)
		{
			
		}
		catch(SQLException e )
		{
			
		}
	}
}