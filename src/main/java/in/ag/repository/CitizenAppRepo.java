package in.ag.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ag.entity.CitizenAppEntity;

public interface CitizenAppRepo extends JpaRepository<CitizenAppEntity, Serializable> {

}
