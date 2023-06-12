package adminservice.entity;

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
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "organization_misc_data", indexes = { @Index(columnList = "organization_id, key", unique = true) }, uniqueConstraints = {
		@UniqueConstraint(columnNames = { "organization_id", "key" }) })
@EntityListeners(AuditingEntityListener.class)
@JsonFilter(value = "organizationMiscData")
public class OrganizationMiscData extends AuditMetaData {

	@Id
	@UuidGenerator(name = "organization_misc_data_id_gen")
	@GeneratedValue(generator = "organization_misc_data_id_gen")
	private UUID id;
	@Column(nullable = false)
	private String key;
	@Column(nullable = false)
	private String value;
	@ManyToOne
	@JoinColumn(name = "organization_id", nullable = false)
	private Organization organization;
	
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public Organization getOrganization() {
		return organization;
	}
	public void setOrganization(Organization organization) {
		this.organization = organization;
	}
	
}
