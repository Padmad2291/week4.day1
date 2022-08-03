package assignments.week4;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Window {

	public static void main(String[] args) {
		
		  WebDriverManager.chromedriver().setup();
		  ChromeDriver driver=new ChromeDriver();
		  driver.get("http://leafground.com/pages/Window.html");
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		  
		  //Click button to open home page in New Window
		  driver.findElement(By.id("home")).click();
		  
		  //Find the number of opened windows
		  String windowHandle=driver.getWindowHandle();
		  System.out.println(windowHandle);
		  
		  Set<String>windowHandles=driver.getWindowHandles();
		  System.out.println("How many handles?" +windowHandles.size());
		  
		  //Close all except this window
		  List<String>lstWindowHandles=new ArrayList<String>(windowHandles);	
		  String secondWindowHandle=lstWindowHandles.get(1);
		  System.out.println(secondWindowHandle);
		  driver.switchTo().window(secondWindowHandle);
		  driver.close();
		  
		  //Wait for 2 new Windows to open
		  driver.switchTo().window(windowHandle);
		  driver.findElement(By.xpath("//button[text()='Wait for 5 seconds']")).click();
		  Set<String>windowHandles1=driver.getWindowHandles();
		  System.out.println("How many handles?" +windowHandles1.size());
		  
		 		  
		  
		  
		  

	}

}
