package br.com.rsinet.Hub_TDD.Utility;

	import java.io.File;
	import java.io.IOException;
	import org.apache.commons.io.FileUtils;
	import org.openqa.selenium.OutputType;
	import org.openqa.selenium.TakesScreenshot;
	import org.openqa.selenium.WebDriver;


	public class Utility {
	
		public static  void  captureScreenshot(WebDriver driver, String ScreenshotName)
		{
			
			try {
			TakesScreenshot ts =(TakesScreenshot)driver;
			
			File source = ts.getScreenshotAs(OutputType.FILE);

			FileUtils.copyFile(source, new File ("./PrintsdeTestes/" + ScreenshotName +".png"));
			
			System.out.println("Screenshots taken");
				
			} 
			catch (Exception e) 
			{
				System.out.println("Exception while taking screenshot" + e.getMessage());
				
			}
		
		/*
		 * Utility.captureScreenshot(driver, "elemento");
		 * Esse comando é para chamar o print e dar um nome para ele.
		 */

}
}