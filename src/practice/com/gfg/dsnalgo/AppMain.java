package practice.com.gfg.dsnalgo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import com.gfg.dsnalgo.ExpressionEvaluator.EXPRESSIONTYPE;

public class AppMain {
public static void main(String[] args) {
	/*Map m = new HashMap();
	Parent parent = new Parent();
	Parent parent2 = new Child();
	Child child=(Child) new Parent();
	child.display();
	child.print();
parent.print();
parent2.print();
((Child) parent2).display();*/
	/*int arr[]={55,5,1,1,1,22,3,3,666,98,7};
	int count=1;
	Arrays.sort(arr);
	for(int i=0;i<arr.length-1;i=i+1){
		
		if(arr[i]==arr[i+1]){
			
			count++;
		}else if(count%2!=0){
			System.out.println(arr[i]);
			count=1;
		}else{
			count=1;
		}
	}*/
	Employee e1=new Employee();
	e1.setId("51879_FS");
	e1.setName("Ashok");
	//System.out.println(e1);
	Employee e2=(Employee) e1.clone();
	e2.setId("51880_FS");
	System.out.println(e1);
	System.out.println(e2);
	Stack stack=new Stack();

	ExpressionEvaluator exev=new ExpressionEvaluator("+538", EXPRESSIONTYPE.Prefix);
	
	System.out.println("(+546) =  "+exev.GetInfixExpression()+" "+exev.GetValue());
}
}
