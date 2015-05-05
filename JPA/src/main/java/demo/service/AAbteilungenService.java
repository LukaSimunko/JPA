package demo.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import demo.AAbteilungen;


public interface AAbteilungenService {
	
	List<AAbteilungen> findbybezeichnung(String bezeichnung);
	AAbteilungen save(AAbteilungen a);
	void delete(int i);

}
