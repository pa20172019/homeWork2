package variousConcepts;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LearnWindowHandle {
	
	WebDriver driver;

	@Before
	public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.yahoo.com/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
		@Test
		public void windowHandle() throws InterruptedException {
			System.out.println(driver.getTitle());
			String handle1 = driver.getWindowHandle();
			//System.out.println(handle1);
			driver.findElement(By.xpath("//*[@id=\"ybar-sbq\"]")).sendKeys("xpath");
			driver.findElement(By.xpath("//*[@id=\"ybar-search\"]")).click();
			Thread.sleep(2000);
			/*
			 * System.out.println(driver.getTitle()); String handle2 =
			 * driver.getWindowHandle(); System.out.println(handle2);
			 */
			driver.findElement(By.xpath("//*[@id=\"web\"]/ol/li[1]/div/div[1]/h3/a")).click();
			Set<String> handles = driver.getWindowHandles();
			System.out.println(handles);
			for(String i : handles) {
				System.out.println(i);
				driver.switchTo().window(i);
			}
			//System.out.println(handles);
			System.out.println(driver.getTitle());
			for(String i : handles) {
				System.out.println(i);
				driver.switchTo().window(i);
			}
			//String handle3 = driver.getWindowHandle();
			//System.out.println(handle3);
		//	driver.findElement(By.xpath("//*[@id=\"topnav\"]/div/div/a[4]")).click();
			
			driver.switchTo().window(handle1);
		}
		}
