package metier;

public class _methodes extends Object implements Cloneable{
	public Object clone(){
		 try {
		 return super.clone();
		 }
		 catch (CloneNotSupportedException e){
		 throw new InternalError();
		 }
		 }

}
