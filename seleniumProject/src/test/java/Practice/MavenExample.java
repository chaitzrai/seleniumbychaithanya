package Practice;

import org.testng.annotations.Test;

public class MavenExample 
{
	@Test
	public void mavenTest()
	{
		String URL = System.getProperty("url");
		String Browser = System.getProperty("browser");
		System.out.println(URL+" "+Browser);
		
	}

}
