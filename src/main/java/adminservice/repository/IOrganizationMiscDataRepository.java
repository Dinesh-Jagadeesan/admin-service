package adminservice.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import adminservice.entity.OrganizationMiscData;

public interface IOrganizationMiscDataRepository extends JpaRepository<OrganizationMiscData, UUID>{

}
