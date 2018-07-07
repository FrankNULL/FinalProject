package patientInformation;

import java.util.Date;

public class Patient {
  
	private String name;
	 private String sex;
    private String address;
    private Integer age;
	
     private String patientNo;
     private String typeDoctor;
     private Date visitDate;
     
    
    /** full constructor */
    public Patient( String name, String sex, String address, Integer age,String patientNo, 
    		String typeDoctor, Date visitDate) {
        this.name=name;
        this.sex=sex;
        this.address=address;
        this.age= age;
        this.patientNo = patientNo;
       
      
        this.typeDoctor=typeDoctor;
        this.visitDate= visitDate;
       
    }

    public String getPatientNo() {
        return this.patientNo;
    }
    
    public void setPatientNo(String patientNo) {
        this.patientNo = patientNo;
    }

	public String getTypeDoctor() {
		return typeDoctor;
	}

	public void setTypeDoctor(String typeDoctor) {
		this.typeDoctor = typeDoctor;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Date getVisitDate() {
		return visitDate;
	}

	public void setVisitDate(Date visitDate) {
		this.visitDate = visitDate;
	}

	@Override
	public String toString() {
		return "Patient\nname=" + name 
				+ "\nsex=" + sex + "\naddress=" + address + "\nage=" + age + "\npatientNo="
				+ patientNo + "\ntypeDoctor=" + typeDoctor + "\nvisitDate=" + visitDate+"\n\n\n ";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((age == null) ? 0 : age.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((patientNo == null) ? 0 : patientNo.hashCode());
		result = prime * result + ((sex == null) ? 0 : sex.hashCode());
		result = prime * result + ((typeDoctor == null) ? 0 : typeDoctor.hashCode());
		result = prime * result + ((visitDate == null) ? 0 : visitDate.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Patient other = (Patient) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (age == null) {
			if (other.age != null)
				return false;
		} else if (!age.equals(other.age))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (patientNo == null) {
			if (other.patientNo != null)
				return false;
		} else if (!patientNo.equals(other.patientNo))
			return false;
		if (sex == null) {
			if (other.sex != null)
				return false;
		} else if (!sex.equals(other.sex))
			return false;
		if (typeDoctor == null) {
			if (other.typeDoctor != null)
				return false;
		} else if (!typeDoctor.equals(other.typeDoctor))
			return false;
		if (visitDate == null) {
			if (other.visitDate != null)
				return false;
		} else if (!visitDate.equals(other.visitDate))
			return false;
		return true;
	}
	
	
}
