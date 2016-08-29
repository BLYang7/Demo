package com.blyang;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

class Person{
	public String name;
	public int age;
	
	private String prvName;
	private int prvAge;
	
	public Person(){}
	
	public Person(String name){
		this.name = name;
	}
	
	public Person(String name, int age){
		this(name);
		this.age = age;
	}

	public void agePlus(){
		this.age++;
		this.prvAge++;
	}
	
	public void agePlus(int num){
		this.age += num;
		this.prvAge += num;
	}
	
	public void resetName(String name){
		this.name = name;
	}
	
	private void agePlusPrv(){
		this.age++;
		this.prvAge++;
	}
	
	private void agePlusPrv(int num){
		this.age += num;
		this.prvAge += num;
	}
	
}

public class Demo {

	public static void main(String[] args) {
		
		try{
			Class<?> demoA = Class.forName("com.blyang.Person");
			Class<?> demoB = new Person().getClass();
			Class<?> demoC = Person.class;
					
			System.out.println("A类名称：" + demoA.getName());
			System.out.println("B类名称：" + demoB.getName());
			System.out.println("C类名称：" + demoC.getName());
			
			
			//获取该Class对象所对应类的全部构造器
	        //Constructor[] ctors = demoA.getDeclaredConstructors();
			
			//获取Class对象对应的所有public构造器集合
			Constructor[] ctors = demoA.getConstructors();

			//获取任意指定的构造器
			//Constructor ctor = demoA.getDeclaredConstructor(String.class, int.class);
			
			//获取指定的public构造器
			Constructor ctor = demoA.getConstructor(String.class, int.class);
			
	        for(Constructor c : ctors){
	            System.out.println(c);
	        }
	        System.out.println(ctor);
	        
	        //获取所有成员变量
	        Field[] fields = demoA.getDeclaredFields();
	        
	        //获取所有public成员变量
	        //Field[] fields = demoA.getFields();
	        
	        //获取指定的任意成员变量
	        Field field = demoA.getDeclaredField("age");
	        
	        //获取指定的public成员变量
	        //Field field = demoA.getField("age");
	        
	        for(Field f : fields){
	        	System.out.println(f);
	        }
	        System.out.println(field);
	        
	        //获取所有public方法集合
	        //Method[] methods = demoA.getMethods();
	        
	        //获取所有方法集合
	        Method[] methods = demoA.getDeclaredMethods();
	        
	        //获取指定的public方法
	        //Method method = demoA.getMethod("agePlus");
	        //Method method = demoA.getMethod("agePlus", int.class);
	        
	        //获取指定的任意方法
	        //Method method = demoA.getDeclaredMethod("agePlusPrv");
	        Method method = demoA.getDeclaredMethod("agePlusPrv", int.class);
	        
	        for(Method m : methods){
	        	System.out.println(m);
	        }
	        System.out.println(method);
	        
		}
		catch(Exception ex){
			System.out.println(ex);
		}
	}
}
