package mycontact.web.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "contact") // name of table in database
public class Contact {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)	//strategy define primary key: auto increament
	@Column(name = "id", nullable = false)
	private Integer id;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "email")
	private String email;

	
	@Column(name = "phone")
	private String phone;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "address_id", referencedColumnName = "address_id")
	private Address address;

	
	
	public Contact() {
	}

	public Contact(Integer id, String name, String email, String phone, Address address) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.address = address;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	

	
}
