package <package>.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import <package>.model.<ClassName>;


@Controller
@RequestMapping("/<ClassNameLowerCase>")
public class <ClassName>Controller {
	
	@Autowired
	private <ClassName>Service <ClassNameLowerCase>Service;
	
	@GetMapping
    public String index() {
    	System.out.println("Index");
    	List<<ClassName>> ls = <ClassNameLowerCase>Service.getAll();
        return "<ClassNameLowerCase>/index";
    }

    @GetMapping("{id}")
    public String show(@PathVariable int id) {
    	System.out.println("show");
    	<ClassName> <ClassNameLowerCase> = <ClassNameLowerCase>Service.getOne(id);
        return "<ClassNameLowerCase>/show";
    }
    
    
    @GetMapping("/create")
    public String create() {
    	System.out.println("create");
    	return "<ClassNameLowerCase>/create";
    }

    @PostMapping
    public String store(@RequestBody <ClassName> <ClassNameLowerCase>) {
    	System.out.println("store");
    	<ClassNameLowerCase>Service.save(<ClassNameLowerCase>);
        return "redirect:<ClassNameLowerCase>/create";
    }
    
    @GetMapping("{id}/edit")
    public String edit() {
    	System.out.println("edit");
    	return "<ClassNameLowerCase>/edit";
    }

    @PostMapping("{id}")
    public String update(@PathVariable int id,@RequestBody <ClassName> <ClassNameLowerCase>) {
    	System.out.println("update");
    	<ClassNameLowerCase>Service.save(<ClassNameLowerCase>);
    	return "redirect:create";
    }

   @DeleteMapping("{id}")
    public void delete(@PathVariable int id) {
    	System.out.println("delete");
    	<ClassNameLowerCase>Service.delete(id);
    }

}
