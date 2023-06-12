package adminservice.entity;

import java.util.Collections;
import java.util.Date;
import java.util.Set;
import java.util.UUID;

import org.eclipse.persistence.annotations.UuidGenerator;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import com.fasterxml.jackson.annotation.JsonFilter;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "user_profile", indexes = { @Index(columnList = "realm, username", unique = true) }, uniqueConstraints = {
		@UniqueConstraint(columnNames = { "realm", "username" }) })
@EntityListeners(AuditingEntityListener.class)
@JsonFilter(value = "userProfile")
public class UserProfile extends AuditMetaData {

	@Id
	@UuidGenerator(name = "user_profile_id_gen")
	@GeneratedValue(generator = "user_profile_id_gen")
	private UUID id;

	@Column(nullable = false)
	private String username;
	@Column(nullable = false)
	private String realm;
	@Column(name = "first_name", nullable = false)
	private String firstName;
	@Column(name = "last_name")
	private String lastName;
	private String gender;
	@ManyToOne
	@JoinColumn(name = "work_address_id")
	private Address workAddress;
	@Column(nullable = false)
	private boolean active;
	@Column(nullable = false)
	private String email;
	@Column(name = "contact_number")
	private String contactNumber;
	@Column(name = "alternate_contact_number")
	private String alternateContactNumber;
	private String nationality;
	@Temporal(TemporalType.DATE)
	@Column(name = "birth_date")
	private Date birthDate;
	@Column(name = "home_location")
	private String homeLocation;
	@ManyToMany
	@JoinTable(name = "brand_user_association", joinColumns = @JoinColumn(name = "user_profile_id"), inverseJoinColumns = @JoinColumn(name = "brand_id"))
	private Set<Brand> brands = Collections.emptySet();

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Address getWorkAddress() {
		return workAddress;
	}

	public void setWorkAddress(Address workAddress) {
		this.workAddress = workAddress;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getAlternateContactNumber() {
		return alternateContactNumber;
	}

	public void setAlternateContactNumber(String alternateContactNumber) {
		this.alternateContactNumber = alternateContactNumber;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getHomeLocation() {
		return homeLocation;
	}

	public void setHomeLocation(String homeLocation) {
		this.homeLocation = homeLocation;
	}

	public Set<Brand> getBrands() {
		return brands;
	}

	public void setBrands(Set<Brand> brands) {
		this.brands = brands;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRealm() {
		return realm;
	}

	public void setRealm(String realm) {
		this.realm = realm;
	}
	
}
