package demo;


import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import demo.Config;
import demo.service.AAbteilungenService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Config.class)
public class AAbtTest {
	@Autowired
	private  AAbteilungenService abt;
	
	@Test
	public void findbybez() {
		abt.findbybezeichnung("RW");
	}

}
