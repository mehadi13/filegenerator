package <package>.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import <package>.<ClassName>;

@Service
public class <ClassName>Service {
	
	@Autowired
	<ClassName>Repository <ClassNameLowerCase>Repository;
	
	public List<<ClassName>> getAll(){
		return <ClassNameLowerCase>Repository.findAll();
	}
	
	public <ClassName> getOne(int id) {
		return <ClassNameLowerCase>Repository.findOne(id);
	}
	
	public void save(<ClassName> <ClassNameLowerCase>){
		<ClassNameLowerCase>Repository.save(<ClassNameLowerCase>);
	}
	
	public void delete(int id){
		<ClassNameLowerCase>Repository.delete(id);
	}

}
