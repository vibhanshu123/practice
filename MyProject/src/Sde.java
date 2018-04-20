
public class Sde {
	
	

}

interface A { 
	
void x(); 

}
class B implements A { 
public void x() { 
} 
public void y() { 
	
} 
}


class C extends B {
	public void x() {
		
	} 

public void abc(){
java.util.List<A> list = new java.util.ArrayList<A>();
list.add(new B());
list.add(new C());
for (A a:list) {
a.x();
a.y();;
}
}

}

