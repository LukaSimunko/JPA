package demo;


import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import demo.Config;
import demo.service.AAbteilungenService;
import demo.service.MitarbeiterService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Config.class)



public class MitarbTest {

	@Autowired
	private  MitarbeiterService abt;
	
	
	@Test
	public void findbyname() {
		abt.findbyname("Lach");
	}
	

	}

