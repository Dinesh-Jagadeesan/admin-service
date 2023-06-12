package adminservice.entity;

import java.util.Collections;
import java.util.Set;
import java.util.UUID;

import org.eclipse.persistence.annotations.UuidGenerator;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonFilter;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "address", indexes = {
		@Index(columnList = "country, region, postal_code, locality, street, po_box_number", unique = true) }, uniqueConstraints = { @UniqueConstraint(columnNames = {
				"country", "region", "postal_code", "locality", "street", "po_box_number" }) })
@EntityListeners(AuditingEntityListener.class)
@JsonFilter(value = "address")
public class Address extends AuditMetaData {

	@Id
	@UuidGenerator(name = "address_id_gen")
	@GeneratedValue(generator = "address_id_gen")
	private UUID id;

	@Column(name = "po_box_number", nullable = false)
	private String poBoxNumber;
	@Column(name = "street", nullable = false)
	private String street;
	@Column(name = "locality", nullable = false)
	private String locality;
	@Column(name = "region", nullable = false)
	private String region;
	@Column(name = "country", nullable = false)
	private String country;
	@Column(name = "postal_code", nullable = false)
	private String postalCode;
	@Column(nullable = false)
	private boolean headquarters;
	@Column(nullable = false)
	private boolean active;
	@ManyToOne
	@JoinColumn(name = "organization_id", nullable = false)
	private Organization organization;
	@OneToMany(mappedBy = "workAddress", cascade = CascadeType.ALL)
	private Set<UserProfile> userProfiles = Collections.emptySet();

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getPoBoxNumber() {
		return poBoxNumber;
	}

	public void setPoBoxNumber(String poBoxNumber) {
		this.poBoxNumber = poBoxNumber;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getLocality() {
		return locality;
	}

	public void setLocality(String locality) {
		this.locality = locality;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public boolean isHeadquarters() {
		return headquarters;
	}

	public void setHeadquarters(boolean headquarters) {
		this.headquarters = headquarters;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Organization getOrganization() {
		return organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}

	public Set<UserProfile> getUserProfiles() {
		return userProfiles;
	}

	public void setUserProfiles(Set<UserProfile> userProfiles) {
		this.userProfiles = userProfiles;
	}
	
}
