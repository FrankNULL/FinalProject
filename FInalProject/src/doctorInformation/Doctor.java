package doctorInformation;
import java.util.Date;

public class Doctor{



	private String name;
	private String phoneNumber;
	private int id;
	private String sex;
	private java.util.Date birthday;
	private String specialty;
	private double visitFee;

	public Doctor( String name,
			String phoneNumber,int id, String sex, java.util.Date birthday2, String specialty, double visitFee) {
		this.name=name;
		this.phoneNumber=phoneNumber;
		this.id = id;
		this.sex = sex;
		this.birthday = birthday2; 
		this.specialty = specialty;
		this.visitFee = visitFee;

	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public java.util.Date getBirthday() {
		return  birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getSpecialty() {
		return specialty;
	}

	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}

	public double getVisitFee() {
		return visitFee;
	}

	public void setVisitFee(double visitFee) {
		this.visitFee = visitFee;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "Doctor"
				+ "\nname=" + name + "\nphoneNumber=" + phoneNumber + "\n id=" + id + "\nsex=" + sex + "\nbirthday="
				+ birthday + "\nspecialty=" + specialty + "\nvisitFee=" + visitFee+"\n\n\n" ;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((birthday == null) ? 0 : birthday.hashCode());
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
		result = prime * result + ((sex == null) ? 0 : sex.hashCode());
		result = prime * result + ((specialty == null) ? 0 : specialty.hashCode());
		long temp;
		temp = Double.doubleToLongBits(visitFee);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}


	public boolean equals(Doctor obj) {

		return this.name.equals(obj.name)
				&&this.phoneNumber.equals(obj.phoneNumber)
				&&this.id==obj.id
				&&this.sex.equals(obj.sex)
				&&this.birthday.equals(obj.birthday)
				&&this.specialty.equals(obj.specialty)
				&&this.visitFee==obj.visitFee;
	}





}