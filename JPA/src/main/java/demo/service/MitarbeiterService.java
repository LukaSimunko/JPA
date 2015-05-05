package demo.service;

import java.util.List;

import demo.AAbteilungen;
import demo.MMitarbeiter;

public interface MitarbeiterService {
	
	List<MMitarbeiter> findbyname(String nachname);
	
	

}
