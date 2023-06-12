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
@Table(name = "brand_misc_data", indexes = { @Index(columnList = "brand_id, key", unique = true) }, uniqueConstraints = {
		@UniqueConstraint(columnNames = { "brand_id", "key" }) })
@EntityListeners(AuditingEntityListener.class)
@JsonFilter(value = "brandMiscData")
public class BrandMiscData extends AuditMetaData {

	@Id
	@UuidGenerator(name = "brand_misc_data_id_gen")
	@GeneratedValue(generator = "brand_misc_data_id_gen")
	private UUID id;
	@Column(nullable = false)
	private String key;
	@Column(nullable = false)
	private String value;
	@ManyToOne
	@JoinColumn(nullable = false, name = "brand_id")
	private Brand brand;
	
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
	public Brand getBrand() {
		return brand;
	}
	public void setBrand(Brand brand) {
		this.brand = brand;
	}

}
