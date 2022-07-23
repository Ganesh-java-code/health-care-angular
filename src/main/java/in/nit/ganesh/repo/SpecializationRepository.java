package in.nit.ganesh.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.nit.ganesh.entity.Specialization;

public interface SpecializationRepository extends JpaRepository<Specialization, Integer> {

}
