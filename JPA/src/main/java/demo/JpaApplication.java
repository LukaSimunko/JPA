package demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import demo.service.AAbteilungenService;


@Import (Config.class)
public class JpaApplication implements CommandLineRunner {
	@Autowired
	private  AAbteilungenService abts;
    public static void main(String[] args) {
        SpringApplication.run(JpaApplication.class, args);
      
       
    }
	@Override
	public void run(String... arg0) throws Exception {
		  	AAbteilungen abt = new AAbteilungen();
	        abt.setA_ID(3);
	        abt.setABezeichnung("PE");
	        abts.save(abt);
		
	}
    
    
}
