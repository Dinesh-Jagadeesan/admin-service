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
@Table(name = "user_profile_misc_data", indexes = { @Index(columnList = "user_profile_id, key", unique = true) }, uniqueConstraints = {
		@UniqueConstraint(columnNames = { "user_profile_id", "key" }) })
@EntityListeners(AuditingEntityListener.class)
@JsonFilter(value = "userProfileMiscData")
public class UserProfileMiscData extends AuditMetaData {

	@Id
	@UuidGenerator(name = "user_profile_misc_data_id_gen")
	@GeneratedValue(generator = "user_profile_misc_data_id_gen")
	private UUID id;
	@Column(nullable = false)
	private String key;
	@Column(nullable = false)
	private String value;
	@ManyToOne
	@JoinColumn(name = "user_profile_id", nullable = false)
	private UserProfile userProfile;
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
	public UserProfile getUserProfile() {
		return userProfile;
	}
	public void setUserProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
	}
	
}
