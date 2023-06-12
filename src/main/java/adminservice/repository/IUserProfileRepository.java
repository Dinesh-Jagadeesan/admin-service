package adminservice.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import adminservice.entity.UserProfile;

public interface IUserProfileRepository extends JpaRepository<UserProfile, UUID>{

}
