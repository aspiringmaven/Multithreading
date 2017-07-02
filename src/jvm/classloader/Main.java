package jvm.classloader;

public class Main {

	public Main() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args) {
		Class<?> c = null;
		MyClassLoader loader = new MyClassLoader();
		try {
			 c = loader.loadClass("java7.cookbook.ClassA");
			System.out.println();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			System.out.println(c.getName() + "    " + c.newInstance().getClass().getClassLoader());
		} catch (InstantiationException | IllegalAccessException e) {

			e.printStackTrace();
		}
		
	}

}
