package Operators;

public class BuilderExample {

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<=6; i++) {
			
			sb.append("line").append(i).append("\n");
		}
		System.out.println("Result : n" + sb);
		// TODO Auto-generated method stub

	}

}
