package edu.pitt.dbmi;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;
import org.testng.Assert;

public class FS_RAViewer_10Pt extends TestBase {

		@Test
		public void test_risk_viewerTC_10pt() throws InterruptedException 
		{	
		
			for (int second = 0;; second++) {
				if (second > timeoutLimit) Assert.fail("timeout");
				try { if ("Edit Date Range".equals(driver.findElement(By.id("datelabel")).getText())) break; } catch (Exception e) {}
				Thread.sleep(1000);
			}
		
			driver.findElement(By.name("datefilter")).clear();
			driver.findElement(By.name("datefilter")).sendKeys("01/01/1950 - 01/02/1950");
//			driver.findElement(By.id("Value")).sendKeys(Keys.ENTER);
			driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
			driver.findElement(By.id("location-analysis-container")).click();
			driver.manage().timeouts().pageLoadTimeout(1000, TimeUnit.SECONDS);
					
		for (int second = 0;; second++) {
			if (second > timeoutLimit) Assert.fail("timeout");
			try { if ("10 Patient(s) with Newly Increased Risk of Falling".equals(driver.findElement(By.id("ui-id-1")).getText())) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}
		

//		add a wait for Expand button here
		for (int second = 0;; second++) {
			if (second > timeoutLimit) Assert.fail("timeout");
			try { if ("".equals(driver.findElement(By.id("expand")).getText())) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}

		driver.findElement(By.xpath("//h3/span")).click();
		driver.manage().timeouts().pageLoadTimeout(1000, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//h3/span")).click();
		driver.manage().timeouts().pageLoadTimeout(1000, TimeUnit.SECONDS);
		
		Assert.assertTrue(driver.getPageSource().contains(("5750"))|
				(driver.getPageSource().contains("5787"))|
				(driver.getPageSource().contains("6461")));
				;
		}	
}