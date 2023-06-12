package adminservice.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import adminservice.entity.UserProfileMiscData;

public interface IUserProfileMiscDataRepository extends JpaRepository<UserProfileMiscData, UUID>{

}
