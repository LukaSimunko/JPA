package demo.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import demo.AAbteilungen;
import demo.AAbteilungenRepository;
import demo.MMitarbeiter;
import demo.MitarbeiterRepo;

@Component ("MMitarbeiterService")
@Transactional

public class MitarbeiterServiceImpl implements MitarbeiterService {

	private final MitarbeiterRepo repo;
	
	@Autowired
	public MitarbeiterServiceImpl(MitarbeiterRepo ab) {
		repo = ab;
	}
		
	
	
	@Override
	public List<MMitarbeiter> findbyname(String nachname) {
		return  repo.findByname(nachname);
	}



	@Override
	public MMitarbeiter findOne(int i) {
		return repo.findOne(i);
	}



	@Override
	public void save(MMitarbeiter m) {
		 repo.save(m);
		
	}



	@Override
	public void delete(int id1) {
		repo.delete(id1);
		
	}
	
	

}
