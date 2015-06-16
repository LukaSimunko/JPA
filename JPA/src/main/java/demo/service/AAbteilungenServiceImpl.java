package demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import demo.AAbteilungen;
import demo.AAbteilungenRepository;

@Component ("AAbteilungenService")
@Transactional
@Service
public class AAbteilungenServiceImpl implements AAbteilungenService {

	private final AAbteilungenRepository abt;
	
	@Autowired
	public AAbteilungenServiceImpl(AAbteilungenRepository ab){
		abt = ab;
	}
	@Override
	public List<AAbteilungen> findbybezeichnung(String bezeichnung) {
		return abt.findBybezeichnung(bezeichnung);
	}
	@Override
	public AAbteilungen save1(AAbteilungen a) {
		return abt.save(a);
	}
	@Override
	public void delete1(int i) {
		abt.delete(i);
		
	}
	
	@Override
	public Object findOne(int id1) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
