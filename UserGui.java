import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ItemEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JScrollPane;
import java.awt.Font;


public class UserGui extends JFrame {
	
	Connection con ; 
	PreparedStatement pst ; 

	private JPanel blocation1;
	private final Label label_2 = new Label("ID");
	private JTable table;
	private JScrollPane scrollPane;
	
	
	private JTable table_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserGui frame = new UserGui();
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
	public UserGui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 878, 655);
		blocation1 = new JPanel();
		blocation1.setBorder(new EmptyBorder(5, 5, 5, 5));
		blocation1.setBackground(Color.decode("#c6e6f5"));
		blocation1.setLayout(null);
		setContentPane(blocation1);
		blocation1.setLayout(null);
		
		
		

		JLabel lblNewLabel = new JLabel("List all students who are above");
		lblNewLabel.setBounds(3, 11, 188, 17);
//		lblNewLabel.
		blocation1.add(lblNewLabel);

		
		TextField age1q = new TextField();

		age1q.setBounds(194, 6, 35, 22);
		blocation1.add(age1q);
		
		Label label_1 = new Label("ID");
		label_1.setBounds(0, 0, 0, 0);
		blocation1.add(label_1);
		label_2.setBounds(0, 0, 0, 0);
		blocation1.add(label_2);
		
		TextField f1q = new TextField();
		
		TextField b1qsi = new TextField();
		
		JButton btnNewButton = new JButton("GO");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
//				String data[][]={ {"101","Amit","670000"},    
//                        {"102","Jai","780000"},    
//                        {"101","Sachin","700000"}};    
//				String column[]={"ID","NAME","SALARY"};
//				
//				table_2 = new JTable(data, column);
//				scrollPane.setViewportView(table_2);
				
				try
				{
					int age = Integer.parseInt(age1q.getText()) ; 
					int number = Integer.parseInt(f1q.getText()) ; 
					pst = con.prepareStatement("        SELECT DISTINCT First_name, Last_name\r\n"
							+ "From student s JOIN Room r on s.Room_number=r.Number\r\n"
							+ "Where s.age>? AND r.Floor_number=?\r\n"
							+ "ORDER By First_name ASC     "
							+ "") ; 
					
					pst.setInt(1, age);
					pst.setInt(2, number);
					ResultSet rs =  pst.executeQuery() ; 
					
					List<Student> students = new ArrayList<Student>() ; 
					
					while(rs.next())
					{
						String first = rs.getString("First_name") ; 
						String last = rs.getString("Last_name") ; 
						
						
						
						Student s = new Student("",first,last,"","","","","") ; 
						
						students.add(s) ; 
						
						System.out.println(first);
						
					}
					
					String[][] data = new String[students.size()][2] ; 
					int i = 0 ; 
					for(Student t : students)
					{
						data[i][0] = t.getFirstname() ; 
						data[i][1] = t.getLastname() ; 
						i++;
						
					}
					String column[]={"Firstname","Lastname"};
					
					table_2 = new JTable(data, column);
					scrollPane.setViewportView(table_2);
					
					age1q.setText("");
					f1q.setText("");

					
				}
				
				catch(Exception p ) 
				{
					JOptionPane.showMessageDialog(null, "Error, check the data  you are entering");
				}
				
				
				


			}
		});
		btnNewButton.setBounds(204, 34, 89, 23);
		blocation1.add(btnNewButton);
		
		JLabel lblListAllStudents = new JLabel("List students whose gender is");
		lblListAllStudents.setBounds(3, 85, 180, 17);
		blocation1.add(lblListAllStudents);
		
		TextField n1q = new TextField();
		n1q.setBounds(48, 108, 102, 22);
		blocation1.add(n1q);
		
		TextField g1q = new TextField();
		
		JButton button = new JButton("GO");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try
				{
					String gender = g1q.getText()  ; 
					String nationality = n1q.getText() ; 
					
					pst = con.prepareStatement("SELECT first_name, last_name\r\n"
							+ "FROM nation\r\n"
							+ "WHERE gender=? and nationality=?") ; 
					pst.setString(1, gender);
					pst.setString(2, nationality);
					ResultSet rs =  pst.executeQuery() ; 
					
					String column[]={"Firstname","Lastname"};
					
					List<Student> students = new ArrayList<Student>() ; 
					
					while(rs.next())
					{
						String first = rs.getString("First_name") ; 
						String last = rs.getString("Last_name") ; 
						
						
						
						Student s = new Student("",first,last,"","","","","") ; 
						
						students.add(s) ; 
						
						System.out.println(first);
						
					}
					
					String[][] data = new String[students.size()][2] ; 
					int i = 0 ; 
					for(Student t : students)
					{
						data[i][0] = t.getFirstname() ; 
						data[i][1] = t.getLastname() ; 
						i++;
						
					}
										
					table_2 = new JTable(data, column);
					scrollPane.setViewportView(table_2);
					
					g1q.setText("");
					n1q.setText("");
					
				}
				catch(Exception p)
				{
					JOptionPane.showMessageDialog(null, "Error, check the data  you are entering");
				}
			}
		});
		button.setBounds(204, 113, 89, 23);
		blocation1.add(button);
		
		JLabel lblListAllStaff = new JLabel("List all IDs of students living in room");
		lblListAllStaff.setBounds(3, 169, 220, 17);
		blocation1.add(lblListAllStaff);
		
		TextField idq1 = new TextField();
		idq1.setBounds(226, 169, 52, 22);
		blocation1.add(idq1);
		
		JButton button_1 = new JButton("GO");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try
				{
					int id = Integer.parseInt(idq1.getText()) ; 
					pst = con.prepareStatement("SELECT ID\r\n"
							+ "FROM stud\r\n"
							+ "WHERE Room_number=? ") ; 
					pst.setInt(1, id);
					ResultSet rs =  pst.executeQuery() ; 
					
					String column[]={"ID"};
					
					List<Student> students = new ArrayList<Student>() ; 
					
					while(rs.next())
					{
						String idp  =    Integer.toString(rs.getInt("ID")) ; 
						
						Student s = new Student(idp,"","","","","","","") ; 
						students.add(s) ; 
						
					}
					
					String[][] data = new String[students.size()][1] ; 
					int i = 0 ; 
					for(Student t : students)
					{
						data[i][0] = t.getId() ;
						
						i++;
						
					}
					
					table_2 = new JTable(data, column);
					scrollPane.setViewportView(table_2);
					
					idq1.setText("");
				}
				catch(Exception p )
				{
					JOptionPane.showMessageDialog(null, "Error, check the data  you are entering");
				}
				
			}
		});
		button_1.setBounds(204, 197, 89, 23);
		blocation1.add(button_1);
		
		JLabel lblListAllStaff_1 = new JLabel("List all staff who work at");
		lblListAllStaff_1.setBounds(3, 243, 145, 17);
		blocation1.add(lblListAllStaff_1);
		
		TextField time1q = new TextField();

		
		JButton button_2 = new JButton("GO");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					String t = time1q.getText() ;  
					pst = con.prepareStatement("SELECT First_name,Last_name \r\n"
							+ "from staff\r\n"
							+ "where working_time=?") ; 
					pst.setString(1, t);
					ResultSet rs =  pst.executeQuery() ; 
					
					String column[]={"Firstname","Lastname"};
					
					List<Staff> staffs = new ArrayList<Staff>() ; 
					
					while (rs.next()) {
						
						
						
						String firstname = rs.getString("First_name");
						String lastname = rs.getString("Last_name");
						
						
						
						
						
						Staff sa =  new Staff("",firstname,lastname,"","","","","") ; 
						staffs.add(sa) ; 
						
						
						  System.out.println(firstname +" "+lastname);
						}
					String[][] data = new String[staffs.size()][2] ; 
					int i = 0 ; 
					for(Staff p : staffs)
					{
						data[i][0] = p.getFirstname() ; 
						data[i][1] = p.getLastname() ; 
						
						i++;
						
					}
					
					table_2 = new JTable(data, column);
					scrollPane.setViewportView(table_2);
					
					time1q.setText("");


				}
				catch(Exception p )
				{
					
				}
			}
		});
		button_2.setBounds(204, 274, 89, 23);
		blocation1.add(button_2);
		
		Label label_7 = new Label("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
		label_7.setBounds(10, 68, 283, 11);
		blocation1.add(label_7);
		
		TextField firstname10 = new TextField();
		
		
		Label label_9 = new Label("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
		label_9.setBounds(10, 152, 283, 11);
		blocation1.add(label_9);
		
		Label label_10 = new Label("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
		label_10.setBounds(10, 226, 283, 11);
		blocation1.add(label_10);
		
		Label label_11 = new Label("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
		label_11.setBounds(10, 303, 283, 11);
		blocation1.add(label_11);
		
		JLabel lblListAllNew = new JLabel("Count number of students who are grouped by");
		lblListAllNew.setBounds(3, 320, 275, 17);
		blocation1.add(lblListAllNew);
		
		JButton button_4 = new JButton("GO");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					pst = con.prepareStatement("SELECT distinct b.location,COUNT(distinct s.id) \r\n"
							+ "FROM student s, room r, floor f, building b\r\n"
							+ "WHERE s.Room_number=r.Number and r.Floor_number=f.number and f.Building_name=b.Name \r\n"
							+ "GROUP BY b.Location") ; 
					
					ResultSet rs =  pst.executeQuery() ; 
					
					String column[]={"Location","Number of students"};
					
					
					List<Record> records = new ArrayList<Record>() ; 
					
					
					while(rs.next())
					{
						String location = rs.getString(1);
						String number = Integer.toString(rs.getInt(2)) ; 
						
						Record r = new Record(location,number) ; 
						records.add(r) ; 
						
					}
					
					
					
					String[][] data = new String[records.size()][2] ; 
					int i = 0 ; 
					for(Record t : records)
					{
						data[i][0] = t.getLocation() ; 
						data[i][1] = t.getNumber() ; 
						i++;
						
					}
					
					table_2 = new JTable(data, column);
					scrollPane.setViewportView(table_2);
					
					
				}
				catch(Exception p) 
				{
					JOptionPane.showMessageDialog(null, "Error");
				}
			}
		});
		button_4.setBounds(206, 342, 89, 23);
		blocation1.add(button_4);
		
		Label label_14 = new Label("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
		label_14.setBounds(10, 371, 283, 11);
		blocation1.add(label_14);
		
		JLabel lblListAllFemale = new JLabel("Read Data");
		lblListAllFemale.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblListAllFemale.setBounds(3, 450, 175, 17);
		blocation1.add(lblListAllFemale);
		
		Label label_15 = new Label("Student ID");
		label_15.setBounds(3, 470, 112, 22);
		blocation1.add(label_15);
		
		TextField studentID10 = new TextField();
		studentID10.setBounds(3, 493, 117, 22);
		blocation1.add(studentID10);
		
		JButton button_5 = new JButton("GO");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if( firstname10.getText().equals(""))
				{
					try
					{
						int id = Integer.parseInt(studentID10.getText()) ; 
						pst = con.prepareStatement("select * from student where id = ? ") ; 
						pst.setInt(1, id);
						ResultSet rs =  pst.executeQuery() ; 
						
						
						String column[]={"ID","Firstname","Lastname","Nationality","Age","Gender","Room","Phone"};
						scrollPane.setViewportView(table_2);

						
						int row = 0 ; 
						while (rs.next()) {
							
							
							String idi = Integer.toString(rs.getInt("Id"));
							 String firstname = rs.getString("First_name");
							String lastname = rs.getString("Last_name");
							String Nationality = rs.getString("Nationality") ;
							String Gender = rs.getString("Gender") ;
							String Age = Integer.toString(rs.getInt("Age"));
							String RoomNumber = Integer.toString(rs.getInt("Room_Number"));
							String PhoneNumber = Integer.toString(rs.getInt("Phone_Number"));
							
							String data[][] ={ 
									{ idi,  firstname, lastname,  Nationality,Age, Gender, RoomNumber, PhoneNumber         } 
							} ; 
							table_2 = new JTable(data, column);
							scrollPane.setViewportView(table_2);
//							  
							  System.out.println(firstname +" "+lastname);
							}
						
					}
					catch(Exception p )
					{
						System.out.println(p.getMessage());
						JOptionPane.showMessageDialog(null, "Error, check the data  you are entering");
					}
					
					
					
				}
				
				else 
				{
					try
					{
						String firstname1 = firstname10.getText() ; 
						pst = con.prepareStatement("select * from student where First_name = ? ") ; 
						pst.setString(1, firstname1);
						ResultSet rs =  pst.executeQuery() ; 
						
						

						List<Student> students = new ArrayList<Student>() ; 
						
						while (rs.next()) {
							
							
							String idi = Integer.toString(rs.getInt("Id"));
							String firstname = rs.getString("First_name");
							String lastname = rs.getString("Last_name");
							String Nationality = rs.getString("Nationality") ;
							String Gender = rs.getString("Gender") ;
							String Age = Integer.toString(rs.getInt("Age"));
							String RoomNumber = Integer.toString(rs.getInt("Room_Number"));
							String PhoneNumber = Integer.toString(rs.getInt("Phone_Number"));
							
							
							
							Student t =  new Student(idi,firstname,lastname,Nationality,Age,Gender,PhoneNumber,RoomNumber) ; 
							students.add(t) ; 
							
							
//							  System.out.println(firstname +" "+lastname);
							}
						
						String[][] data = new String[students.size()][8] ; 
						int i = 0 ; 
						for(Student t : students)
						{
							data[i][0] = t.getId() ;
							data[i][1] = t.getFirstname() ; 
							data[i][2] = t.getLastname() ; 
							data[i][3] = t.getNationality() ; 
							data[i][4] = t.getAge() ; 
							data[i][5] = t.getGender() ; 
							data[i][6] = t.getRoom() ; 
							data[i][7] = t.getPhone() ;  
							i++;
							
						}
						 String column[]={"ID","Firstname","Lastname","Nationality","Age","Gender","Room","Phone"};
						table_2 = new JTable(data, column);
						scrollPane.setViewportView(table_2);
						
					}
					
					catch(Exception p )
					{
						JOptionPane.showMessageDialog(null, "Error, check the data  you are entering");
					}
				}
			}
		});
		button_5.setBounds(3, 584, 117, 23);
		blocation1.add(button_5);
		
		JLabel lblYears = new JLabel("years");
		lblYears.setBounds(235, 12, 35, 17);
		blocation1.add(lblYears);
		
		JLabel lblWhoLiveIn = new JLabel("who live in floor");
		lblWhoLiveIn.setBounds(3, 38, 95, 17);
		blocation1.add(lblWhoLiveIn);
		
		
		f1q.setBounds(98, 34, 35, 22);
		blocation1.add(f1q);
		
		
		g1q.setBounds(185, 85, 73, 22);
		blocation1.add(g1q);
		
		JLabel lblAndOf = new JLabel("and from");
		lblAndOf.setBounds(3, 113, 175, 17);
		blocation1.add(lblAndOf);
		
		JLabel lblWhereTeyLive = new JLabel("the building's locations they live in");
		lblWhereTeyLive.setBounds(1, 348, 204, 17);
		blocation1.add(lblWhereTeyLive);
		
		
		time1q.setBounds(156, 238, 99, 22);
		blocation1.add(time1q);
		
		
		


		
		Label label_8 = new Label("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
		label_8.setBounds(10, 175, 619, 17);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(297, 11, 567, 371);
		blocation1.add(scrollPane);
		
		
		
		scrollPane.setViewportView(table_2);
		
		Label label = new Label("Building name");
		label.setBounds(264, 470, 112, 22);
		blocation1.add(label);
		
		TextField bname1 = new TextField();
		bname1.setBounds(264, 493, 123, 22);
		blocation1.add(bname1);
		TextField textField_13 = new TextField();
		
		JButton button_3 = new JButton("GO");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try
				{
					if(textField_13.getText().equals(""))
					{
						String name  = bname1.getText() ; 
						pst = con.prepareStatement("select * from building where name = ? ") ; 
						pst.setString(1, name);
						ResultSet rs =  pst.executeQuery() ; 
						
						
						String column[]={"Name","Location","Gender"};
						
						while(rs.next()) 
						{
							String location = rs.getString("Location") ; 
							String Gender = rs.getString("Gender") ; 
							
							String data[][] ={ 
									{ name,location,Gender       } 
							} ; 
							table_2 = new JTable(data, column);
							scrollPane.setViewportView(table_2);
							
						}
					}
					else
					{
						String location = textField_13.getText() ; 
						pst = con.prepareStatement("select * from building where location = ? ") ; 
						pst.setString(1, location);
						ResultSet rs =  pst.executeQuery() ; 
						List<Building> buildings = new ArrayList<Building>() ;
						
						while(rs.next()) 
						{
							String name = rs.getString("Name") ; 
							String gender =  rs.getString("Gender") ; 
							Building b = new Building(name,location,gender) ; 
							buildings.add(b) ; 
						}
						String[][] data = new String[buildings.size()][3] ; 
						int i = 0 ; 
						for(Building t : buildings)
						{
							data[i][0] = t.getName() ; 
							data[i][1] = t.getLocation() ; 
							data[i][2] = t.getGender() ; 
							
							i++;
							
						}
						String column[]={"Name","Location","Gender"};
						table_2 = new JTable(data, column);
						scrollPane.setViewportView(table_2);
					}
				}
				catch(Exception p ) 
				{
					System.out.println(p.getMessage());
					JOptionPane.showMessageDialog(null, "Error, check the data  you are entering");
				}
			}
		});
		button_3.setBounds(264, 584, 123, 23);
		blocation1.add(button_3);
		
		Label label_3 = new Label("Staff ID");
		label_3.setBounds(146, 470, 112, 22);
		blocation1.add(label_3);
		
		TextField staffID1 = new TextField();
		staffID1.setBounds(128, 493, 107, 22);
		blocation1.add(staffID1);
		
		JButton button_6 = new JButton("GO");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					int id = Integer.parseInt(staffID1.getText()) ; 
					pst = con.prepareStatement("select * from staff where id = ? ") ; 
					pst.setInt(1, id);
					ResultSet rs =  pst.executeQuery() ;
					
					String column[]={"ID","Firstname","Lastname","Nationality","Age","Gender","Working Time","Phone"};
					while(rs.next()) 
					{
						String idi = Integer.toString(rs.getInt("Id"));
						 String firstname = rs.getString("First_name");
						String lastname = rs.getString("Last_name");
						String Nationality = rs.getString("Nationality") ;
						String Gender = rs.getString("Gender") ;
						String Age = Integer.toString(rs.getInt("Age"));
						String workingtime = rs.getString("Working_time");
						String PhoneNumber = Integer.toString(rs.getInt("Phone_Number"));
						String data[][] ={ 
								{ idi,  firstname, lastname,  Nationality,Age, Gender, workingtime, PhoneNumber         } 
						} ; 
						table_2 = new JTable(data, column);
						scrollPane.setViewportView(table_2);
					}
					
				}
				catch(Exception p)
				{
					System.out.println(p.getMessage());
					JOptionPane.showMessageDialog(null, "Error, check the data  you are entering");
				}
			}
		});
		button_6.setBounds(136, 584, 107, 23);
		blocation1.add(button_6);
		
		Label label_4 = new Label("Floor number");
		label_4.setBounds(398, 470, 112, 22);
		blocation1.add(label_4);
		
		TextField fnsi = new TextField();
		fnsi.setBounds(393, 493, 123, 22);
		blocation1.add(fnsi);
		
		JButton button_7 = new JButton("GO");
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try
				{
					int number = Integer.parseInt(fnsi.getText()) ; 
					pst = con.prepareStatement("select * from floor where number = ? ") ; 
					pst.setInt(1, number); 
					ResultSet rs =  pst.executeQuery() ; 
					
					String column[]={"Number","Rooms","Occupied","Staff","Building"};
					
					while (rs.next()) {
						
						
						
						String rooms = Integer.toString(rs.getInt("Number_rooms")) ; 
						String occupied = Integer.toString(rs.getInt("Number_occupied")) ; 
						String staff = Integer.toString(rs.getInt("Staff_ID")) ; 
						String building = rs.getString("Building_name") ;
						
						
						String data[][] ={ 
								{ Integer.toString(number),  rooms, occupied,  staff,building   } 
						} ; 
						table_2 = new JTable(data, column);
						scrollPane.setViewportView(table_2);			  
						}
					
					
					
				}
				catch(Exception p ) 
				{
					JOptionPane.showMessageDialog(null, "Error, check the data  you are entering");
				}
			}
		});
		button_7.setBounds(393, 584, 123, 23);
		blocation1.add(button_7);
		
		Label label_5 = new Label("Room number");
		label_5.setBounds(538, 470, 112, 22);
		blocation1.add(label_5);
		
		TextField rnsi = new TextField();
		rnsi.setBounds(527, 493, 123, 22);
		blocation1.add(rnsi);
		
		JButton button_8 = new JButton("GO");
		button_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try
				{
					int number = Integer.parseInt(rnsi.getText()) ; 
					pst = con.prepareStatement("select * from room where number = ? ") ; 
					pst.setInt(1, number);
					ResultSet rs =  pst.executeQuery() ; 
					
					
					String column[]={"Number","Type","Floor_number" } ; 
					
					
					while(rs.next()) 
					{
						String type = rs.getString("Type") ; 
						String floor = rs.getString("Floor_number") ; 
						
						String data[][] ={ 
								{ Integer.toString(number),type,floor       } 
						} ; 
						
						table_2 = new JTable(data, column);
						scrollPane.setViewportView(table_2);
						
					}
				}
				
				catch(Exception p ) 
				{
					JOptionPane.showMessageDialog(null, "Error, check the data  you are entering");
				}
				
			}
		});
		button_8.setBounds(527, 584, 123, 23);
		blocation1.add(button_8);
		
		JLabel lblListNameOf = new JLabel("list name of students who don\u2019t");
		lblListNameOf.setBounds(3, 393, 188, 17);
		blocation1.add(lblListNameOf);
		
		
		b1qsi.setBounds(99, 416, 66, 22);
		blocation1.add(b1qsi);
		
		JLabel lblBuilding = new JLabel(" live in building.");
		lblBuilding.setBounds(3, 416, 163, 17);
		blocation1.add(lblBuilding);
		
		JButton button_10 = new JButton("GO");
		button_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try
				{
					String bname =  b1qsi.getText() ; 
					pst = con.prepareStatement("SELECT First_name, Last_name\r\n"
							+ "FROM student s, room r, floor f, building b\r\n"
							+ "WHERE s.Room_number=r.Number and r.Floor_number=f.number and f.Building_name=b.Name AND b.Name!=?") ; 
					pst.setString(1, bname);
					ResultSet rs =  pst.executeQuery() ; 
					
					String column[]={"Firstname","Lastname"};
					
					List<Student> students = new ArrayList<Student>() ; 
					
					while (rs.next()) {
						
						
						
						String firstname = rs.getString("First_name");
						String lastname = rs.getString("Last_name");
						
						Student t =  new Student("",firstname,lastname,"","","","","") ; 
						students.add(t) ; 
						
						
						  System.out.println(firstname +" "+lastname);
						}
					String[][] data = new String[students.size()][2] ; 
					int i = 0 ; 
					for(Student t : students)
					{
						
						data[i][0] = t.getFirstname() ; 
						data[i][1] = t.getLastname() ; 
						
						i++;
						
					}
					
					table_2 = new JTable(data, column);
					scrollPane.setViewportView(table_2);
					
					b1qsi.setText("");
				}
				catch(Exception p ) 
				{
					JOptionPane.showMessageDialog(null, "Error, check the data  you are entering");
				}
			}
		});
		button_10.setBounds(206, 419, 89, 23);
		blocation1.add(button_10);
		
		Label label_12 = new Label("or first name");
		label_12.setBounds(10, 516, 112, 22);
		blocation1.add(label_12);
		
		
		firstname10.setBounds(8, 547, 107, 22);
		blocation1.add(firstname10);
		
		Label label_13 = new Label("or location");
		label_13.setBounds(264, 516, 112, 22);
		blocation1.add(label_13);
		
		
		textField_13.setBounds(264, 547, 123, 22);
		blocation1.add(textField_13);
		
		JButton btnNewButton_1 = new JButton("Go Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AdminGui f = new AdminGui() ; 
				f.setVisible(true);
				setVisible(false) ; 
				
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_1.setBounds(721, 519, 89, 50);
		blocation1.add(btnNewButton_1);


		
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



class Student 
{
	String Id ; 
	String firstname ; 
	String lastname ; 
	String nationality ; 
	String age ; 
	String gender; 
	String phone ; 
	String room ; 
	public Student(String id, String firstname, String lastname, String nationality, String age, String gender,
			String phone, String room) {
		super();
		Id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.nationality = nationality;
		this.age = age;
		this.gender = gender;
		this.phone = phone;
		this.room = room;
	}
	public String getId() {
		return Id;
	}
	public String getFirstname() {
		return firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public String getNationality() {
		return nationality;
	}
	public String getAge() {
		return age;
	}
	public String getGender() {
		return gender;
	}
	public String getPhone() {
		return phone;
	}
	public String getRoom() {
		return room;
	}
	

}


class Building 
{
	String name ; 
	String location ; 
	String gender ;
	public Building(String name, String location, String gender) {
		super();
		this.name = name;
		this.location = location;
		this.gender = gender;
	}
	public String getName() {
		return name; 
	}
	public String getLocation() {
		return location;
	}
	public String getGender() {
		return gender;
	} 
	
	
}

class Staff
{
	String Id ; 
	String firstname ; 
	String lastname ; 
	String nationality ; 
	String age ; 
	String gender; 
	String phone ; 
	String time ;
	public Staff(String id, String firstname, String lastname, String nationality, String age, String gender,
			String phone, String time) {
		super();
		Id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.nationality = nationality;
		this.age = age;
		this.gender = gender;
		this.phone = phone;
		this.time = time;
	}
	public String getId() {
		return Id;
	}
	public String getFirstname() {
		return firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public String getNationality() {
		return nationality;
	}
	public String getAge() {
		return age;
	}
	public String getGender() {
		return gender;
	}
	public String getPhone() {
		return phone;
	}
	public String getTime() {
		return time;
	} 

}

class Record
{
	String location ; 
	String number ;
	public Record(String location, String number) {
		super();
		this.location = location;
		this.number = number;
	}
	public String getLocation() {
		return location;
	}
	public String getNumber() {
		return number;
	} 
	
}