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
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "brand", indexes = { @Index(columnList = "organization_id, brand_name", unique = true) }, uniqueConstraints = {
				@UniqueConstraint(columnNames = { "organization_id", "brand_name" }) })
@EntityListeners(AuditingEntityListener.class)
@JsonFilter(value = "brand")
public class Brand extends AuditMetaData {

	@Id
	@UuidGenerator(name = "brand_id_gen")
	@GeneratedValue(generator = "brand_id_gen")
	private UUID id;
	@Column(name = "brand_name", nullable = false)
	private String brandName;
	@Column(name = "about_url")
	private String aboutUrl;
	@ManyToOne
	@JoinColumn(name = "organization_id", nullable = false)
	private Organization organization;
	@OneToMany(mappedBy = "brand", cascade = CascadeType.ALL)
	private Set<BrandMiscData> brandMiscData = Collections.emptySet();
	@ManyToMany(mappedBy = "brands")
	private Set<UserProfile> userProfiles = Collections.emptySet();

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public String getAboutUrl() {
		return aboutUrl;
	}

	public void setAboutUrl(String aboutUrl) {
		this.aboutUrl = aboutUrl;
	}

	public Organization getOrganization() {
		return organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}

	public Set<BrandMiscData> getBrandMiscData() {
		return brandMiscData;
	}

	public void setBrandMiscData(Set<BrandMiscData> brandMiscData) {
		this.brandMiscData = brandMiscData;
	}

	public Set<UserProfile> getUserProfiles() {
		return userProfiles;
	}

	public void setUserProfiles(Set<UserProfile> userProfiles) {
		this.userProfiles = userProfiles;
	}
	
}
