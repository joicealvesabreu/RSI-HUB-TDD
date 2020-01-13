package automationFramework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import br.com.rsinet.Hub_TDD.Utility.Constant;
import br.com.rsinet.Hub_TDD.Utility.ExcelUtils;

public class Apache_Poi_TC {
	
	private static WebDriver driver = null;
	 
	 public static void main(String[] args) throws Exception {
	 
	        //This is to open the Excel file. Excel path, file name and the sheet name are parameters to this method
	 
	        ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData,"Planilha1");
	 
	        driver = new ChromeDriver();
	 
	        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	 
	        driver.get(Constant.URL);
	
	       
	 
	        System.out.println("Login Successfully, now it is the time to Log Off buddy.");
	 
	      
	 
	        driver.quit();
	 
	        //This is to send the PASS value to the Excel sheet in the result column.
	 
	        ExcelUtils.setCellData("Pass", 1, 0);
	 
	 }
}
