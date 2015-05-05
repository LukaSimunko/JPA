package demo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface AAbteilungenRepository extends CrudRepository<AAbteilungen, Integer> {
	@Query("select b from AAbteilungen b where b.aBezeichnung like :bezeichnung")
	List<AAbteilungen> findBybezeichnung(@Param("bezeichnung") String bezeichnung);
	
	
	
}
