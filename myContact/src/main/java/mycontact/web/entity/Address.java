package mycontact.web.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "address")
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "address_id", nullable = false)
	private Integer addressId;
	
	@Column(name = "longitude", nullable = false)
	private Double longitude;
	
	@Column(name = "latitude", nullable = false)
	private Double latitude;
	
	@Column(name = "addressName", nullable = false)
	private String addressName;
	
	@OneToOne(mappedBy = "address")
    private Contact contact;
	
	public Address() {
		
	}
	
	public Address(int addressid, double longitude, double latitude, String addressname) {
		this.addressId = addressid;
		this.longitude = longitude;
		this.latitude = latitude;
		this.addressName = addressname;		
	}

	

	public Integer getAddressId() {
		return addressId;
	}

	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public String getAddressName() {
		return addressName;
	}

	public void setAddressName(String addressName) {
		this.addressName = addressName;
	}
	
	
	
}
