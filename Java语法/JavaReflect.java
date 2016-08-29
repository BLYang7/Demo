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
					
			System.out.println("A�����ƣ�" + demoA.getName());
			System.out.println("B�����ƣ�" + demoB.getName());
			System.out.println("C�����ƣ�" + demoC.getName());
			
			
			//��ȡ��Class��������Ӧ���ȫ��������
	        //Constructor[] ctors = demoA.getDeclaredConstructors();
			
			//��ȡClass�����Ӧ������public����������
			Constructor[] ctors = demoA.getConstructors();

			//��ȡ����ָ���Ĺ�����
			//Constructor ctor = demoA.getDeclaredConstructor(String.class, int.class);
			
			//��ȡָ����public������
			Constructor ctor = demoA.getConstructor(String.class, int.class);
			
	        for(Constructor c : ctors){
	            System.out.println(c);
	        }
	        System.out.println(ctor);
	        
	        //��ȡ���г�Ա����
	        Field[] fields = demoA.getDeclaredFields();
	        
	        //��ȡ����public��Ա����
	        //Field[] fields = demoA.getFields();
	        
	        //��ȡָ���������Ա����
	        Field field = demoA.getDeclaredField("age");
	        
	        //��ȡָ����public��Ա����
	        //Field field = demoA.getField("age");
	        
	        for(Field f : fields){
	        	System.out.println(f);
	        }
	        System.out.println(field);
	        
	        //��ȡ����public��������
	        //Method[] methods = demoA.getMethods();
	        
	        //��ȡ���з�������
	        Method[] methods = demoA.getDeclaredMethods();
	        
	        //��ȡָ����public����
	        //Method method = demoA.getMethod("agePlus");
	        //Method method = demoA.getMethod("agePlus", int.class);
	        
	        //��ȡָ�������ⷽ��
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
