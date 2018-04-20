package interview;

public class DeepCopyImpl implements Cloneable{

	private int p;
	private AClone cloneA;
	
	public DeepCopyImpl(){
		p=15;
		cloneA = new AClone();
	}
	
	public Object clone() throws CloneNotSupportedException{
		DeepCopyImpl copy =(DeepCopyImpl) super.clone();
		copy.cloneA=(AClone)copy.cloneA.clone();
		return copy;
		
	}
	
	public static void main(String[] args)throws CloneNotSupportedException{
		DeepCopyImpl abc=new DeepCopyImpl();
		DeepCopyImpl abcClone=(DeepCopyImpl)abc.clone();
		abc.cloneA.memeberSetter(1, 1);
		abcClone.cloneA.memeberSetter(3,3);
		System.out.println("original object->objClassA:x="+abc.cloneA.getX()+"y=:"+abc.cloneA.getY());
		System.out.println("Cloned object->objClassA:x="+abcClone.cloneA.getX()+"y=:"+abcClone.cloneA.getY());
	}
	
}
