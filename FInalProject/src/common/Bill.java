package common;


import doctorInformation.Doctor;
import patientInformation.Patient;
public class Bill {
	protected Patient[] person =null ;
	protected Doctor[] doctors = null;
	int count1; 
	int count2;

	public Bill(int size1,int size2) {
		person = new Patient[size1];
		doctors = new Doctor[size2];
		count1 =0;
		count2 =0;
	}

	public void addPatient(Patient patient) {
		if (patient == null || !(patient instanceof Patient)) {
			System.err.println("Invalid patient!");
			return;
		}else {

			if (count1 == person.length) {
				ensurePatientCapacity();
			}

			person[count1] = patient;
			count1++;
		}

	}



	public void addDoctor(Doctor doctor) {
		if (doctor == null || !(doctor instanceof Doctor)) {
			System.err.println("Invalid doctor!");
			return;
		} else {

			if (count2 == doctors.length) {
				ensureDoctorCapacity();
			}

			doctors[count2] = doctor;
			count2++;
		}

	}

	public boolean searchPatientByName(String patientName) {
		boolean isFound = false;
		int i;
		for(i =0; i< count1; i++)
		{
			if (person[i] != null && person[i].getName().equals(patientName)) {
				isFound = true;
				break;
			}
		}
		return isFound;
	}

	public boolean searchPatientByGender(String patientGender) {
		boolean isFound = false;
		int i;
		for(i =0; i< count1; i++)
		{
			if (person[i] != null && person[i].getSex().equals(patientGender)) {
				isFound = true;
				break;
			}
		}
		return isFound;
	}

	public boolean searchPatientByAge(int patientAge) {
		boolean isFound = false;
		int i;
		for(i =0; i< count1; i++)
		{
			if (person[i] != null && person[i].getAge()==patientAge) {
				isFound = true;
				break;
			}
		}
		return isFound;
	}






	public boolean searchPatientByTypeDoctor(String targetTypeDoctor) {
		boolean isFound = false;
		int i;
		for(i =0; i< count1; i++)
		{
			if (person[i] != null && person[i].getTypeDoctor().equals(targetTypeDoctor)) {
				isFound = true;
				break;
			}
		}
		return isFound;
	}




	public boolean searchDoctorByName(String doctorName) {
		boolean isFound = false;
		int i;
		for(i =0; i< count2; i++)
		{
			if (doctors[i] != null && doctors[i].getName().equals(doctorName)) {
				isFound = true;
				break;
			}
		}
		return isFound;
	}



	public boolean searchDoctorBySpecility(String targetSpecialty) {
		boolean isFound = false;
		int i;
		for(i =0; i< count2; i++)
		{
			if (doctors[i] != null && doctors[i].getSpecialty().equals(targetSpecialty)) {
				isFound = true;
				break;
			}
		}
		return isFound;
	}


	public boolean searchDoctorByGender(String doctorGender) {
		boolean isFound = false;
		int i;
		for(i =0; i< count2; i++)
		{
			if (doctors[i] != null && doctors[i].getSex().equals(doctorGender)) {
				isFound = true;
				break;
			}
		}
		return isFound;
	}


	public boolean searchDoctorByID(int targetId) {
		boolean isFound = false;
		int i;
		for(i =0; i< count2; i++)
		{
			if (doctors[i] != null && doctors[i].getId()==targetId) {
				isFound = true;
				break;
			}
		}
		return isFound;
	}

	public boolean searchDoctorByPhoneNumber(String targetPhone) {
		boolean isFound = false;
		int i;
		for(i =0; i< count2; i++)
		{
			if (doctors[i] != null && doctors[i].getPhoneNumber().equals(targetPhone)) {
				isFound = true;
				break;
			}
		}
		return isFound;
	}

	public boolean removeDoctor (String targetName) {


		for (int i = 0;i<=doctors.length;i++) {
			if(!(doctors[i]==null)) {
				if (doctors[i].getName().equals(targetName)) {
					doctors[i] = null;
					return true;
				}
			}
		}

		return false;
	}


	public boolean removePatient(String targetname) {


		for (int i = 0; i < person.length; i++) {
			if(!(person[i]==null)) {
				if (person[i].getName().equals(targetname)) {
					person[i] = null;
					return true;
				}
			}
		}

		return false;
	}

	public void  ensurePatientCapacity() {
		Patient [] newArray = new Patient[ 2*person.length ];
		for (int i=0; i< person.length; i++)
		{ 
			newArray[i]= person[i];			
		}
		person = newArray;

	}
	public void  ensureDoctorCapacity() {
		Doctor [] newArray = new Doctor[ 2*doctors.length ];
		for (int i=0; i< doctors.length; i++)
		{ 
			newArray[i]= doctors[i];			
		}
		doctors= newArray;

	}




}