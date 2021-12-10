package Practice;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.comcast.generic.BaseClase;

@Listeners(com.crm.comcast.generic.ListnerImplementation.class)
public class ScreenshotTest extends BaseClase
{
	static
	{
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	}
	@Test
	public void testdsdsaadfsdfsdfs()
	{
	System.out.println(100/0);
		
	}


}
