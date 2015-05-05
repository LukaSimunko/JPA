package demo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface MitarbeiterRepo extends CrudRepository<MMitarbeiter, Integer> {
	@Query("select b from MMitarbeiter b where b.mNachname  = :nachname")
	List<MMitarbeiter> findByname(@Param("nachname") String nachname);
}
