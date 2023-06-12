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
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "organization", indexes = { @Index(columnList = "organization_uid", unique = true),
		@Index(columnList = "master_key", unique = true) }, uniqueConstraints = {
				@UniqueConstraint(columnNames = { "organization_uid" }),
				@UniqueConstraint(columnNames = { "master_key" }) })
@EntityListeners(AuditingEntityListener.class)
@JsonFilter(value = "organization")
public class Organization extends AuditMetaData {

	@Id
	@UuidGenerator(name = "organization_id_gen")
	@GeneratedValue(generator = "organization_id_gen")
	private UUID id;

	@Column(name = "organization_uid", nullable = false)
	private UUID organizationUid;
	@Column(name = "organization_name", nullable = false)
	private String organizationName;
	@Column(nullable = false)
	private boolean active;
	private String logo;
	@Column(name = "about_url")
	private String aboutUrl;
	@Column(name = "master_key", nullable = false)
	private UUID masterKey;
	@OneToMany(mappedBy = "organization", cascade = CascadeType.ALL)
	private Set<Brand> brands = Collections.emptySet();
	@OneToMany(mappedBy = "organization", cascade = CascadeType.ALL)
	private Set<Address> addresses = Collections.emptySet();
	@OneToMany(mappedBy = "organization", cascade = CascadeType.ALL)
	private Set<OrganizationMiscData> organizationMiscData = Collections.emptySet();

	public Organization() {
		super();
		this.organizationUid = UUID.randomUUID();
		this.masterKey = UUID.randomUUID();
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public UUID getOrganizationUid() {
		return organizationUid;
	}

	public String getOrganizationName() {
		return organizationName;
	}

	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public UUID getMasterKey() {
		return masterKey;
	}

	public Set<Brand> getBrands() {
		return brands;
	}

	public void setBrands(Set<Brand> brands) {
		this.brands = brands;
	}

	public Set<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(Set<Address> addresses) {
		this.addresses = addresses;
	}

	public void setMasterKey(UUID masterKey) {
		this.masterKey = masterKey;
	}

	public String getAboutUrl() {
		return aboutUrl;
	}

	public void setAboutUrl(String aboutUrl) {
		this.aboutUrl = aboutUrl;
	}

	public Set<OrganizationMiscData> getOrganizationMiscData() {
		return organizationMiscData;
	}

	public void setOrganizationMiscData(Set<OrganizationMiscData> organizationMiscData) {
		this.organizationMiscData = organizationMiscData;
	}
	
}
