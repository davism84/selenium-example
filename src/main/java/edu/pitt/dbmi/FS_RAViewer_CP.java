package edu.pitt.dbmi;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;
import org.testng.Assert;

public class FS_RAViewer_CP extends TestBase {

		@Test
		public void test_risk_viewer_cp() throws InterruptedException 
		{
						
			for (int second = 0;; second++) {
				if (second > timeoutLimit) Assert.fail("timeout");
				try { if ("Edit Date Range".equals(driver.findElement(By.id("datelabel")).getText())) break; } catch (Exception e) {}
				Thread.sleep(1000);
			}
					
			driver.findElement(By.name("datefilter")).clear();
			driver.findElement(By.name("datefilter")).sendKeys("01/01/1950 - 01/02/1950");
			driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);

			for (int second = 0;; second++) {
				if (second > timeoutLimit) Assert.fail("timeout");
				try { if ("".equals(driver.findElement(By.id("expand")).getText())) break; } catch (Exception e) {}
				Thread.sleep(1000);
			}
			
			for (int second = 0;; second++) {
				if (second > timeoutLimit) Assert.fail("timeout");
				try { if ("".equals(driver.findElement(By.xpath("//input[@id='expand']")).getText())) break; } catch (Exception e) {}
				Thread.sleep(1000);
			}
			
			driver.findElement(By.id("Cranberry Place")).click();
			driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
			
			driver.findElement(By.name("datefilter")).clear();
			driver.findElement(By.name("datefilter")).sendKeys("01/01/1950 - 01/02/1950");
			driver.manage().timeouts().pageLoadTimeout(1000, TimeUnit.SECONDS);
			
			for (int second = 0;; second++) {
				if (second > timeoutLimit) Assert.fail("timeout");
				try { if ("".equals(driver.findElement(By.id("expand")).getText())) break; } catch (Exception e) {}
				Thread.sleep(1000);
			}

		
		for (int second = 0;; second++) {
			if (second > timeoutLimit) Assert.fail("timeout");
			try { if ("3 Patient(s) with Newly Increased Risk of Falling".equals(driver.findElement(By.id("ui-id-1")).getText())) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}
		

//		add a wait for Expand button here
		for (int second = 0;; second++) {
			if (second > timeoutLimit) Assert.fail("timeout");
			try { if ("".equals(driver.findElement(By.id("expand")).getText())) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}
		
		for (int second = 0;; second++) {
			if (second > timeoutLimit) Assert.fail("timeout");
			try { if ("".equals(driver.findElement(By.xpath("//input[@id='expand']")).getText())) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}

		List<WebElement> list2 = driver.findElements(By.xpath("//input[@id='expand']"));
        driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
        
        if(!list2.isEmpty())
        {
			driver.findElement(By.xpath("//input[@id='expand']")).click();
			driver.manage().timeouts().pageLoadTimeout(1000, TimeUnit.SECONDS);
        }
		
		// List<WebElement> list3 = driver.findElements(By.id("expand"));
  //       driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
        
   //     if(!list3.isEmpty())
   //      {
   //      	driver.findElement(By.id("expand")).click();
			// driver.manage().timeouts().pageLoadTimeout(1000, TimeUnit.SECONDS);
   //      }
		       		       		
		for (int second = 0;; second++) {
			if (second > timeoutLimit) Assert.fail("timeout");
			try { if ("Patient #7331".equals(driver.findElement(By.linkText("Patient #7331")).getText())) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}		
		
		try {
			  Assert.assertEquals("Patient #7438", driver.findElement(By.linkText("Patient #7438")).getText());
			} catch (Error e) {
			  verificationErrors.append(e.toString());
			}
		
		try {
			  Assert.assertEquals("Patient #7571", driver.findElement(By.linkText("Patient #7571")).getText());
			} catch (Error e) {
			  verificationErrors.append(e.toString());
			}

		try {
			Assert.assertEquals("Situation: Non-Alzheimers Dementia. ADL Scale <= 21.",
					driver.findElement(By.id("sit")).getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		
		Assert.assertTrue(driver.getPageSource().contains(
				"Patient is a 87 year old White FEMALE; entered from Acute Hospital"));
	}
}
