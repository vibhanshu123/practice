
public class AnimalDoctor{
	
	public void checkPolymorphism(Polymorphism[] polymorphisms){
		for(Polymorphism p:polymorphisms)
			p.checkUp();
	}
	
	public static void main(String[] args){
		Dog1[] dogs={new Dog1(),new Dog1()};
		Cat1[] cats={new Cat1(),new Cat1(),new Cat1()};
		Bird1[] birds={new Bird1()};
		
		AnimalDoctor an=new AnimalDoctor();
		an.checkPolymorphism(dogs);
		an.checkPolymorphism(cats);
		an.checkPolymorphism(birds);
	}

}
