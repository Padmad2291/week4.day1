package assignments.week4;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContact {

	public static void main(String[] args) throws InterruptedException {
		
		//1. Launch URL "http://leaftaps.com/opentaps/control/login" */
		
		  WebDriverManager.chromedriver().setup();
		  ChromeDriver driver=new ChromeDriver();
		  driver.get("http://leaftaps.com/opentaps/control/main");
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//2. Enter UserName and Password Using Id Locator
		  driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		  driver.findElement(By.id("password")).sendKeys("crmsfa");		  
		
		//3. Click on Login Button using Class Locator
		  driver.findElement(By.className("decorativeSubmit")).click();
		  
		//4. Click on CRM/SFA Link
		  driver.findElement(By.linkText("CRM/SFA")).click();
		  
		//5. Click on contacts Button
		  driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		  
        //6. Click on Merge Contacts using Xpath Locator
		  driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();
		  
        //7. Click on Widget of From Contact
		  driver.findElement(By.xpath("//span[text()='From Contact']/following::img")).click();
			
        //8. Click on First Resulting Contact
		  String windowHandle=driver.getWindowHandle();
		  System.out.println(windowHandle);
		  
		  Set<String>windowHandles=driver.getWindowHandles();
			System.out.println("How many handles?" +windowHandles.size());
			
			List<String>lstWindowHandles=new ArrayList<String>(windowHandles);	
			String secondWindowHandle=lstWindowHandles.get(1);
			System.out.println(secondWindowHandle);
			
			driver.switchTo().window(secondWindowHandle);
			
		    driver.findElement(By.xpath("//a[text()='17217']")).click();
		  
        //9. Click on Widget of To Contact
		    driver.switchTo().window(windowHandle);
		    driver.findElement(By.xpath("//span[text()='To Contact']/following::img")).click();
		    
        //10. Click on Second Resulting Contact
		    Set<String>windowHandles1=driver.getWindowHandles();
		    List<String>lstWindowHandles1=new ArrayList<String>(windowHandles1);	
			String secondWindowHandle1=lstWindowHandles1.get(1);
		    driver.switchTo().window(secondWindowHandle1);
		    driver.findElement(By.xpath("//a[text()='17218']")).click();
		    
        //11. Click on Merge button using Xpath Locator
		    driver.switchTo().window(windowHandle);
		    driver.findElement(By.xpath("//a[text()='Merge']")).click();
        //12. Accept the Alert
		    Alert alert=driver.switchTo().alert();
			alert.accept();
			
        //13. Verify the title of the page
			String text=driver.getTitle();
			System.out.println(text);


	}

}
