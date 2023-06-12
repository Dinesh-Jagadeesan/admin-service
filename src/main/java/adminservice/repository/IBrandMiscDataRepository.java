package adminservice.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import adminservice.entity.BrandMiscData;

public interface IBrandMiscDataRepository extends JpaRepository<BrandMiscData, UUID>{

}
