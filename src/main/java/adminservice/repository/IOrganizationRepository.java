package adminservice.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import adminservice.entity.Organization;

public interface IOrganizationRepository extends JpaRepository<Organization, UUID>{

}
