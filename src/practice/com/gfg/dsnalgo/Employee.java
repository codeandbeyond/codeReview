package practice.com.gfg.dsnalgo;

public class Employee implements Cloneable{
String name;
String id;
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public Employee clone(){
	return this;
	
}
@Override
public String toString() {
	return "Employee [name=" + name + ", id=" + id + "]";
}

}
