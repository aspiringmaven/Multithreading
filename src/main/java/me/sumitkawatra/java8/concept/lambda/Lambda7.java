package me.sumitkawatra.java8.concept.lambda;

public class Lambda7 {
	
	public static void main(String[] args) {
		/**
		 * checked exception and lambda.
		 */
		Contract<String, Integer> fun = (String jobName) -> {
			if(jobName == null) {
				throw new CheckedException();
			}
			return jobName.length();
			};
			
			try {
				System.out.println(fun.process("Laado"));
			} catch (CheckedException e) {
				e.printStackTrace();
			}
	}

}


@FunctionalInterface
interface Contract<T,R> {
	public R process (T jobName) throws CheckedException;
}



class CheckedException extends Exception {

	private static final long serialVersionUID = -1450834654782806958L;
	
}

class ChildExecption extends CheckedException {
	
}