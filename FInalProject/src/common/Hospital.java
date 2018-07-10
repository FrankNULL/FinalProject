package common;

import java.awt.EventQueue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;


import javax.swing.JLabel;


import javax.swing.JButton;
import java.awt.CardLayout;
import javax.swing.JTextField;

import doctorInformation.Doctor;
import patientInformation.Patient;

import javax.swing.JComboBox;
import javax.swing.JTextArea;

public class Hospital {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField txtMmddyyyy;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_11;
	private JTextField txtMmddyyyy_1;
	private JTextField textField_10;


	private Bill biInfo = new Bill(1, 1);
	private SimpleDateFormat format =new SimpleDateFormat("mm/dd/yyyy");
	private JTextField textField_1;
	private JPanel patientPage;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Hospital window = new Hospital();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Hospital() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1000, 750);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));

		patientPage = new JPanel();
		frame.getContentPane().add(patientPage, "name_1301512728384250");
		patientPage.setLayout(null);





		JPanel mainPage = new JPanel();
		frame.getContentPane().add(mainPage, "name_1301512733195368");
		mainPage.setLayout(null);

		JPanel doctorPage = new JPanel();
		frame.getContentPane().add(doctorPage, "name_1301592637972281");
		doctorPage.setLayout(null);


		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(321, 152, 646, 385);
		doctorPage.add(scrollPane_1);

		JTextArea textArea_1 = new JTextArea();
		scrollPane_1.setViewportView(textArea_1);

		String[] sexList  = {"male","female"};
		JComboBox comboBox_4 = new JComboBox(sexList);
		comboBox_4.setBounds(79, 197, 130, 50);
		patientPage.add(comboBox_4);

		String[] searchList= {"Allergists/Immunologists", "Anesthesiologists", "Cardiologists", "Colon and Rectal Surgeons",
				"Dermatologists", "Endocrinologists", "Emergency Medicine Specialists", "Family Physicians"};
		JComboBox comboBox_1 = new JComboBox(searchList);
		comboBox_1.setBounds(107, 541, 130, 27);
		patientPage.add(comboBox_1);

		String[] doctorType = {"Name","DoctorType","Gender", "Age"};
		JComboBox comboBox = new JComboBox(doctorType);
		comboBox.setBounds(633, 46, 98, 27);
		patientPage.add(comboBox);


		String[] sexList2 = {"male","female"};
		JComboBox comboBox_5 = new JComboBox(sexList2);
		comboBox_5.setBounds(83, 267, 133, 45);
		doctorPage.add(comboBox_5);

		String[] searchListS = {"Name","Specialty","ID","Phone Number","Gender"};
		JComboBox comboBox_3 = new JComboBox(searchListS);
		comboBox_3.setBounds(557, 79, 87, 27);
		doctorPage.add(comboBox_3);

		String[] doctorS =  {"Allergists/Immunologists", "Anesthesiologists", "Cardiologists", "Colon and Rectal Surgeons",
				"Dermatologists", "Endocrinologists", "Emergency Medicine Specialists","Family Physicians"};
		JComboBox comboBox_2 = new JComboBox(doctorS);
		comboBox_2.setBounds(86, 365, 130, 24);
		doctorPage.add(comboBox_2);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(253, 104, 706, 464);
		patientPage.add(scrollPane);



		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);


		JButton btnNewButton_2 = new JButton("Add");
		btnNewButton_2.setBounds(33, 625, 163, 29);
		patientPage.add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String name = textField.getText();
				String sex = (String)comboBox_4.getSelectedItem();
				String address = textField_2.getText();
				int age = Integer.parseInt(textField_3.getText());
				String patientNo = textField_5.getText();
				Date visitDate=  null;

				try {
					visitDate =  format.parse( txtMmddyyyy.getText() );

				}catch(Exception ex) {
					textArea.append("Invalid Date!\n ");
				}



				String typeDoctor = (String)comboBox_1.getSelectedItem();
				boolean testText = true;
				boolean testRepeat = true;
				if((name==null)||(sex==null)||(address==(null))||(age == 0)||(visitDate==  null)) {

					testText =false;
				}

				if(biInfo.count1>=1) {
					for(Patient patient: biInfo.person) {
						if(!(patient==null)){
							if(patient.getName().equals(name)
									&&(patient.getAddress().equals(address))
									&&patient.getAge().equals(age)
									&&patient.getPatientNo().equals(patientNo)
									&&patient.getSex().equals(sex)
									&&patient.getTypeDoctor().equals(typeDoctor)
									&&patient.getVisitDate().equals(visitDate)) {
								testRepeat =false;
								textArea.append("This Patient has already been added our system!\nPlease enter another Patient!\n");
							}
						}
					}
				}
				if(testText&&testRepeat) {
					Patient patient = new Patient(name, sex, address, age, patientNo, typeDoctor, visitDate);
					biInfo.addPatient(patient);
					textArea.append("Patient "+name+" Information has successfullly added!\n\n");
				}

			}

		});
		JButton btnNewButton_3 = new JButton("Reset");
		btnNewButton_3.setBounds(498, 625, 163, 29);
		patientPage.add(btnNewButton_3); 
		btnNewButton_3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				textField_2.setText("");
				textField_3.setText("");
				txtMmddyyyy.setText("");
				textField_5.setText("");
				comboBox.setSelectedIndex(0);
				comboBox_4.setSelectedIndex(0);
				comboBox_1.setSelectedIndex(0);

			}
		});

		JButton btnNewButton_4 = new JButton("Remove");
		btnNewButton_4.setBounds(239, 625, 142, 29);
		patientPage.add(btnNewButton_4);
		btnNewButton_4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String patientName = textField.getText();

				boolean isRemoved = biInfo.removePatient(patientName);

				if (isRemoved) {
					textArea.append(patientName + " removed!\n\n");
				} else {
					textArea.append(patientName + " doesn't exist in our system!\n\n");
				}


			}
		});

		JLabel lblNewLabel_1 = new JLabel("Patient Information");
		lblNewLabel_1.setBounds(150, 17, 142, 16);
		patientPage.add(lblNewLabel_1);

		JButton btnNewButton_5 = new JButton("Back to Main Page");
		btnNewButton_5.setBounds(768, 625, 157, 29);
		patientPage.add(btnNewButton_5);
		btnNewButton_5.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				mainPage.setVisible(true);
				patientPage.setVisible(false);
				doctorPage.setVisible(false);

			}
		});
		JLabel lblNewLabel_2 = new JLabel("Name");
		lblNewLabel_2.setBounds(33, 156, 61, 16);
		patientPage.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Gender");
		lblNewLabel_3.setBounds(33, 213, 61, 16);
		patientPage.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Address");
		lblNewLabel_4.setBounds(33, 259, 98, 45);
		patientPage.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("Age");
		lblNewLabel_5.setBounds(33, 316, 83, 45);
		patientPage.add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("Visit Date");
		lblNewLabel_6.setBounds(33, 401, 61, 16);
		patientPage.add(lblNewLabel_6);

		JLabel lblNewLabel_7 = new JLabel("PatientNo.");
		lblNewLabel_7.setBounds(33, 458, 98, 54);
		patientPage.add(lblNewLabel_7);

		textField = new JTextField();
		textField.setBounds(79, 151, 130, 26);
		patientPage.add(textField);
		textField.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setBounds(89, 273, 115, 26);
		patientPage.add(textField_2);
		textField_2.setColumns(10);

		textField_3 = new JTextField();
		textField_3.setBounds(94, 325, 115, 26);
		patientPage.add(textField_3);
		textField_3.setColumns(10);

		txtMmddyyyy = new JTextField();
		txtMmddyyyy.setText("MM/DD/YYYY");
		txtMmddyyyy.setBounds(101, 396, 108, 26);
		patientPage.add(txtMmddyyyy);
		txtMmddyyyy.setColumns(10);

		textField_5 = new JTextField();
		textField_5.setBounds(99, 472, 108, 26);
		patientPage.add(textField_5);
		textField_5.setColumns(10);



		JLabel lblNewLabel_9 = new JLabel("Doctor Type");
		lblNewLabel_9.setBounds(24, 513, 130, 81);
		patientPage.add(lblNewLabel_9);


		textField_6 = new JTextField();
		textField_6.setBounds(550, 71, 181, 26);
		patientPage.add(textField_6);
		textField_6.setColumns(10);

		JLabel lblNewLabel_10 = new JLabel("Key Word");
		lblNewLabel_10.setBounds(455, 76, 83, 16);
		patientPage.add(lblNewLabel_10);

		JButton btnNewButton_11 = new JButton("Search");
		btnNewButton_11.setBounds(439, 45, 92, 29);
		patientPage.add(btnNewButton_11);



		btnNewButton_11.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String target = textField_6.getText();

				if(comboBox.getSelectedItem() == "Name"&&(target!=null)) {
					if(biInfo.searchPatientByName(target)) {
						for(int i =0 ;i<biInfo.person.length;i++) {
							if(!(biInfo.person[i]==null)) {
								if(biInfo.person[i].getName().equals(target)) {
									textArea.append("Search result\n"+biInfo.person[i].toString());
								}
							}
						}
					}else {
						textArea.append("Sorry, we cannot find this Patient!\n");
					} 
				}


				if(comboBox.getSelectedItem() == "DoctorType"&&(target!=null)) {

					if(biInfo.searchPatientByTypeDoctor(target)) {

						for(int i =0 ;i<biInfo.person.length;i++) {
							if(!(biInfo.person[i]==null)) {
								if(biInfo.person[i].getTypeDoctor().equals(target)) {
									textArea.append("Search result\n"+biInfo.person[i].toString());
								}
							}
						}

					}else {
						textArea.append("Sorry, we cannot find this Patient!\n");
					}
				}




				if(comboBox.getSelectedItem() == "Gender"&&(target!=null)) {
					if(biInfo.searchPatientByGender(target)) {
						for(int i =0 ;i<biInfo.person.length;i++) {
							if(!(biInfo.person[i]==null)) {
								if(biInfo.person[i].getSex().equals(target)) {
									textArea.append("Search result\n"+biInfo.person[i].toString());
								}
							}
						}
					}else {
						textArea.append("Sorry, we cannot find this Patient!\n");
					} 
				}



				if(comboBox.getSelectedItem() == "Age"&&(target!=null)) {
					int targetAge = Integer.parseInt(target);
					if(biInfo.searchPatientByAge(targetAge)) {
						for(int i =0 ;i<biInfo.person.length;i++) {
							if(!(biInfo.person[i]==null)) {
								if(biInfo.person[i].getAge() == targetAge) {
									textArea.append("Search result\n"+biInfo.person[i].toString());
								}
							}
						}
					}else {
						textArea.append("Sorry, we cannot find this Patient!\n");
					} 
				}


			}
		});


		JButton btnNewButton_13 = new JButton("Show Patient List");
		btnNewButton_13.setBounds(275, 584, 309, 29);
		patientPage.add(btnNewButton_13);




		btnNewButton_13.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				for( int i=0;i<biInfo.person.length;i++) {
					if(!(biInfo.person[i]==null) ){
						if(!(biInfo.person[i].getName()==null) ){
							textArea.append("Patient ***************\n"+biInfo.person[i].toString());
						}
					}
				}
			}
		});



		JButton btnClearWindow = new JButton("Clear Window");
		btnClearWindow.setBounds(727, 584, 181, 29);
		patientPage.add(btnClearWindow);

		btnClearWindow.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");

			}
		});

		JButton btnNewButton = new JButton("Doctor Page");
		btnNewButton.setBounds(281, 166, 311, 76);
		mainPage.add(btnNewButton);

		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				mainPage.setVisible(false);
				doctorPage.setVisible(true);
				patientPage.setVisible(false);

			}
		});

		JButton btnNewButton_1 = new JButton("Patient Page");
		btnNewButton_1.setBounds(281, 292, 311, 76);
		mainPage.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {


			@Override
			public void actionPerformed(ActionEvent e) {
				mainPage.setVisible(false);
				patientPage.setVisible(true);
				doctorPage.setVisible(false);

			}
		});

		JLabel lblNewLabel = new JLabel("      Welcom to Hospital Information Management System");
		lblNewLabel.setBounds(235, 6, 576, 203);
		mainPage.add(lblNewLabel);


		JLabel lblNewLabel_11 = new JLabel("Name");
		lblNewLabel_11.setBounds(45, 152, 61, 16);
		doctorPage.add(lblNewLabel_11);

		JLabel lblNewLabel_12 = new JLabel("ID");
		lblNewLabel_12.setBounds(56, 217, 61, 16);
		doctorPage.add(lblNewLabel_12);

		JLabel lblNewLabel_13 = new JLabel("Gender");
		lblNewLabel_13.setBounds(34, 280, 61, 16);
		doctorPage.add(lblNewLabel_13);

		JLabel lblNewLabel_14 = new JLabel("Specialty");
		lblNewLabel_14.setBounds(27, 368, 79, 16);
		doctorPage.add(lblNewLabel_14);

		JLabel lblNewLabel_15 = new JLabel("Visit Fee");
		lblNewLabel_15.setBounds(27, 438, 90, 16);
		doctorPage.add(lblNewLabel_15);

		JLabel lblNewLabel_16 = new JLabel("Birthday");
		lblNewLabel_16.setBounds(27, 521, 145, 16);
		doctorPage.add(lblNewLabel_16);

		textField_7 = new JTextField();
		textField_7.setBounds(86, 213, 130, 24);
		doctorPage.add(textField_7);
		textField_7.setColumns(10);

		textField_8 = new JTextField();
		textField_8.setBounds(89, 149, 127, 22);
		doctorPage.add(textField_8);
		textField_8.setColumns(10);

		textField_11 = new JTextField();
		textField_11.setBounds(86, 433, 130, 26);
		doctorPage.add(textField_11);
		textField_11.setColumns(10);

		txtMmddyyyy_1 = new JTextField();
		txtMmddyyyy_1.setText("MM/DD/YYYY");
		txtMmddyyyy_1.setBounds(83, 516, 130, 26);
		doctorPage.add(txtMmddyyyy_1);
		txtMmddyyyy_1.setColumns(10);

		JButton btnNewButton_6 = new JButton("Add");
		btnNewButton_6.setBounds(55, 616, 117, 29);
		doctorPage.add(btnNewButton_6);
		btnNewButton_6.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String name = textField_8.getText();
				String sex= (String)comboBox_5.getSelectedItem();
				int id =0;
				try{
					id= Integer.parseInt(textField_7.getText());
				}catch(Exception ex) {
					textArea_1.append("Pleanse enter valid id\n");
				}
				String specialty = (String)comboBox_2.getSelectedItem();
				double visitFee = Double.parseDouble(textField_11.getText());
				try {
					visitFee =  Double.parseDouble(textField_11.getText());
				} catch (Exception exx) {
					textArea_1.append("Please enter valid visit fee!\n");
				}
				Date birthday=  null;
				String phoneNumber = textField_1.getText();

				try {
					birthday =  format.parse( txtMmddyyyy_1.getText() );

				}catch(Exception ex) {
					textArea_1.append("Invalid Date\n");
				}




				boolean testText = true;
				boolean testRepeat = true;
				if((name==null)||(sex==null)||(visitFee==0)||(id==0)||(birthday==  null)) {

					testText =false;
					textArea_1.append("Please enter vaild information\n");
				}
				if(biInfo.count2>=1) {
					for(Doctor doctor: biInfo.doctors) {
						if(!(doctor==null)) {
							if((doctor.getBirthday().equals(birthday)
									&&doctor.getId()==id
									&&doctor.getName().equals(name)
									&&doctor.getPhoneNumber().equals(phoneNumber)
									&&doctor.getSex().equals(sex)
									&&doctor.getSpecialty().equals(specialty)
									&&doctor.getVisitFee()==visitFee)){
								testRepeat =false;
								textArea_1.append("This Doctor exists in this System!\nPlease check your information!\n ");
								break;
							}
						}
					}
				}
				if(testText&&testRepeat) {
					biInfo.addDoctor(new Doctor(name, phoneNumber, id, sex, birthday, specialty, visitFee));
					textArea_1.append("Doctor "+ name +"has been successfully added!\n");
				}

			}

		});
		JButton btnNewButton_7 = new JButton("Remove");
		btnNewButton_7.setBounds(271, 616, 117, 29);
		doctorPage.add(btnNewButton_7);
		btnNewButton_7.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String name = textField_8.getText();


				boolean isRemoved = biInfo.removeDoctor(name);

				if (isRemoved) {
					textArea_1.append("Doctor " + name+ " has successful removed!\n");
				} else {
					textArea_1.append(name + " doesn't exist in our system!\n");
				}

			}
		});

		JButton btnNewButton_8 = new JButton("Reset");
		btnNewButton_8.setBounds(563, 616, 117, 29);
		doctorPage.add(btnNewButton_8);
		btnNewButton_8.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				textField_7.setText("");
				textField_8.setText("");
				textField_11.setText("");
				txtMmddyyyy_1.setText("");
				comboBox_2.setSelectedIndex(0);
				comboBox_3.setSelectedIndex(0);
				comboBox_5.setSelectedIndex(0);
			}
		});
		JButton btnNewButton_9 = new JButton("Back");
		btnNewButton_9.setBounds(829, 616, 98, 29);
		doctorPage.add(btnNewButton_9);

		btnNewButton_9.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				patientPage.setVisible(false);
				mainPage.setVisible(true);
				doctorPage.setVisible(false);

			}
		});




		textField_10 = new JTextField();
		textField_10.setBounds(429, 109, 226, 30);
		doctorPage.add(textField_10);
		textField_10.setColumns(10);

		JLabel lblKeyWord = new JLabel("Key Word");
		lblKeyWord.setBounds(343, 109, 117, 30);
		doctorPage.add(lblKeyWord);

		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setBounds(37, 549, 117, 78);
		doctorPage.add(lblPhone);

		textField_1 = new JTextField();
		textField_1.setBounds(86, 575, 130, 26);
		doctorPage.add(textField_1);
		textField_1.setColumns(10);

		JButton btnNewButton_12 = new JButton("Show Doctor List ");
		btnNewButton_12.setBounds(321, 575, 359, 29);
		doctorPage.add(btnNewButton_12);
		btnNewButton_12.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				for(int i =0;i<biInfo.doctors.length;i++) {

					if(!(biInfo.doctors[i]==null)) {
						textArea_1.append("************Doctor"+"*********\n"+biInfo.doctors[i].toString()+"\n");
					}

				}

			}
		});






		JLabel lblDoctorInformation = new JLabel("Doctor Information");
		lblDoctorInformation.setBounds(255, 0,  739, 168);
		doctorPage.add(lblDoctorInformation);

		JButton btnNewButton_14 = new JButton("Clear Window");
		btnNewButton_14.setBounds(777, 575, 188, 29);
		doctorPage.add(btnNewButton_14);

		btnNewButton_14.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				textArea_1.setText("");

			}
		});

		JButton btnNewButton_10 = new JButton("Search");
		btnNewButton_10.setBounds(429, 79, 98, 27);
		doctorPage.add(btnNewButton_10);

		btnNewButton_10.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String target = textField_10.getText();
				if(comboBox_3.getSelectedItem() == "Name"&&(target!=null)) {

					if(biInfo.searchDoctorByName(target)) {
						for(int i =0 ;i<biInfo.doctors.length;i++) {
							if(!(biInfo.doctors[i]==null)) {
								if(biInfo.doctors[i].getName().equals(target)) {
									textArea_1.append("\n\nSearch result--------------\n"+biInfo.doctors[i].toString());
								}
							}
						}
					}else {
						textArea_1.append("\nSearch result--------------\nSorry, this Doctor does not exist!\n");
					}
				}

				if(comboBox_3.getSelectedItem() == "Specialty"&&(target!=null)){
					if(biInfo.searchDoctorBySpecility(target)) {
						for(int i =0 ;i<biInfo.doctors.length;i++) {
							if(!(biInfo.doctors[i]==null)) {
								if(biInfo.doctors[i].getSpecialty().equals(target)) {
									textArea_1.append("\n\nSearch result--------------\n"+biInfo.doctors[i].toString());
								}
							}
						}
					}else {
						textArea_1.append("\nSearch result--------------\nSorry, this Doctor does not exist!\n");
					}

				}

				if(comboBox_3.getSelectedItem() == "Gender"&&(target!=null)){
					if(biInfo.searchDoctorByGender(target)) {
						for(int i =0 ;i<biInfo.doctors.length;i++) {
							if(!(biInfo.doctors[i]==null)) {
								if(biInfo.doctors[i].getSex().equals(target)) {
									textArea_1.append("\n\nSearch result--------------\n"+biInfo.doctors[i].toString());
								}
							}
						}
					}else {
						textArea_1.append("\nSearch result--------------\nSorry, this Doctor does not exist!\n");
					}

				}
				if(comboBox_3.getSelectedItem() == "ID"&&(target!=null)){
					int targetId = Integer.parseInt(target);
					if(biInfo.searchDoctorByID(targetId)) {
						for(int i =0 ;i<biInfo.doctors.length;i++) {
							if(!(biInfo.doctors[i]==null)) {
								if(biInfo.doctors[i].getId()== targetId){
									textArea_1.append("\n\nSearch result--------------\n"+biInfo.doctors[i].toString());
								}
							}
						}
					}else {
						textArea_1.append("\nSearch result--------------\nSorry, this Doctor does not exist!\n");
					}

				}


				if(comboBox_3.getSelectedItem() == "Phone Number"&&(target!=null)){

					if(biInfo.searchDoctorByPhoneNumber(target)) {
						for(int i =0 ;i<biInfo.doctors.length;i++) {
							if(!(biInfo.doctors[i]==null)) {
								if(biInfo.doctors[i].getPhoneNumber().equals(target)){
									textArea_1.append("\n\nSearch result--------------\n"+biInfo.doctors[i].toString());
								}
							}
						}
					}else {
						textArea_1.append("\nSearch result--------------\nSorry, this Doctor does not exist!\n");
					}

				}


			}
		});

		mainPage.setVisible(true);
		patientPage.setVisible(false);
		doctorPage.setVisible(false);
	}
}

