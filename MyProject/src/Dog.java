import java.util.HashMap;
import java.util.Map;


class Dog {
	
	public Dog(String n){
		name=n;
	}
	
	public String name;
	
	public boolean equals(Object o) {
		System.out.println(name);
		if((o instanceof Dog)&& (((Dog)o).name==name))
		  
			return true;
		
		else
		return false;
		
	}
	
	public int hashcode(){
		return name.length();
	}

}

class Cat{}

enum Pets {DOG,CAT,HORSE}

class MapTest {
	
	public static void main(String [] args){
		Map<Object,Object> m= new HashMap<Object, Object>();
		
		m.put("k1", new Dog("aiko"));
		m.put("k2", Pets.DOG);
		m.put(Pets.CAT, "CAT Key");
		Dog d1= new Dog("clover");
		m.put(d1, "DOG Key");
		
	    Cat c=new Cat();
		m.put(new Cat(), "CAT Key");
		m.put(c, "what the fuck");
		
		//m.put("k1", "sex");
		System.out.println(m);
		
		System.out.println(m.get("k1"));
		String k2="k2";
		
		System.out.println(m.get(k2));
		
		Pets p=Pets.CAT;
		
//		System.out.println(m.get(Pets.CAT));
//		System.out.println(m.get(d1));
//		System.out.println(m.get(new Cat()));
//		System.out.println(m.get(new Dog("clover")));
//		System.out.println(m.get(c));
//		System.out.println(m.size());
		
		
		d1.name="vibs";
		System.out.println(m.get(d1));
		//d1.name="shas";
		//System.out.println(new Dog("clover").equals(d1));
		System.out.println(m.get(new Dog("clover")));
		d1.name="sumit";
		System.out.println(m.get(new Dog("shas")));
		
	}
}

