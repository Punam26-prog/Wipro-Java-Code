package Operators;

public class CompareString {

	public static void main(String[] args) {
		String str =" java";
		str.concat("World");  // not stored
		System.out.println("String(immutable):" + str);
		
		StringBuffer sb1 = new StringBuffer("Java");
		sb1.append("World");
		System.out.println("StringBuffer(mutable) : " + sb1);
		
		StringBuilder sb2 = new StringBuilder("Java");
		sb2.append("World");
		System.out.println("StringBuilder(mutable) :" + sb2);
		
		// TODO Auto-generated method stub

	}

}
