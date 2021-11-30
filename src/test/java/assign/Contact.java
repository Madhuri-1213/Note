package assign;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;


import org.openqa.selenium.chrome.ChromeDriver;


	public class Contact {
@Test
		public void verify() {
			// TODO Auto-generated method stub
			 System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\Dell\\\\Downloads\\\\chromedriver_win32\\\\chromedriver.exe");  
		        WebDriver driver = new ChromeDriver();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.navigate().to("https://evernote.com/");
				driver.manage().window().maximize();
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollBy(0,5900)", "");
				CharSequence selectLinkOpeninNewTab=Keys.chord(Keys.CONTROL,Keys.RETURN);
		        WebElement info = driver.findElement(By.xpath("/html/body/footer/div[1]/div[2]/div[5]"));
		        int noOfLink = info.findElements(By.tagName("a")).size();
		        System.out.println(noOfLink);
		        for(int i=0;i<noOfLink;i++) {
		        	String s= Integer.toString(i+1);
		        	String t=driver.findElement(By.xpath("//div[@class='link-section'][5]/ul/li["+s+"]/a")).getText();
	                System.out.println(t);
		        	driver.findElement(By.xpath("//div[@class='link-section'][5]/ul/li["+s+"]/a")).sendKeys(selectLinkOpeninNewTab);
		            ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		            driver.switchTo().window(tabs.get(i+1));
		            String cp=driver.getTitle();
		            System.out.println(cp);
		            driver.navigate().back();
		            if(cp.contains(t)) {
		            	System.out.println("Matches");
		            }
		            else {
		            	System.out.println("Not Matches");
		            }
		            //Assert.assertFalse(cp.contains(t));
		        }
		}

	}

