package adminservice.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import adminservice.entity.Brand;

public interface IBrandRepository extends JpaRepository<Brand, UUID>{

}
