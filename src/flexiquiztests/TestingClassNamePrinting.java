package flexiquiztests;

public class TestingClassNamePrinting {
	
	public static void foo() 
		{ 
		String nameofCurrMethod = new Throwable() 
				.getStackTrace()[0] 
				.getMethodName(); 
		System.out.println("Name of current method: "
				+ nameofCurrMethod); 
		} 


	public static void main(String[] args) 
	{
		foo(); 
	}

}
