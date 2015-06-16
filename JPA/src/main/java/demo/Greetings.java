package demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import demo.service.AAbteilungenService;
import demo.service.MitarbeiterService;

@Controller
public class Greetings
{
	@Autowired
	private AAbteilungenService abt;
	
	
	

    @RequestMapping(value = "/greeting", method = RequestMethod.GET)
    @ResponseBody
    public String greeting(@RequestParam(value="grus", required=false, defaultValue="Hallo") String grus, @RequestParam(value="name", required=false, defaultValue="Jeremia") String name, Model model)
    {
        //model.addAttribute("name", name);
        return grus+" " + name;
    }
    
    @RequestMapping(value ="/Abteilungen", method = RequestMethod.GET)
    @ResponseBody
    public String getAbteilungen()
    {
    	String s = "";
    	List<AAbteilungen> list = abt.findbybezeichnung("%");
    	if (list.isEmpty()) return "No Abteilungen";
    	for(AAbteilungen m : list)
    	{
    		s += m.toString();
    	}
    	
    	return s;
    }
    
    @RequestMapping(value ="/Abteilung/{id1}", method = RequestMethod.GET)
    @ResponseBody
    public String getAbteilung(@PathVariable int id1)
    {
    	return abt.findOne(id1).toString();
    }
    
    @RequestMapping(value ="/newAbteilung", method = RequestMethod.GET)
    @ResponseBody
    public String postAbteilung(@RequestParam(value="vname", required=true, defaultValue="NULL") String vname1, @RequestParam(value="ID", required=true, defaultValue="Doe") int ID, Model model)
    {
    	AAbteilungen m  = new AAbteilungen();
    	m.setABezeichnung(vname1);
    	m.setA_ID(ID);
    	
    	abt.save1(m);
    	return m.toString();
    }
    
    @RequestMapping(value ="/abteilung/{id1}/delete", method = RequestMethod.GET)
    @ResponseBody
    public String deltAbteilungen(@PathVariable int id1)
    {
    	abt.delete1(id1);
    	return "Deleted";
    }
}

