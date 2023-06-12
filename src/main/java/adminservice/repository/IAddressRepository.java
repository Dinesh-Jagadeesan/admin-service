package adminservice.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import adminservice.entity.Address;

public interface IAddressRepository extends JpaRepository<Address, UUID> {

}
