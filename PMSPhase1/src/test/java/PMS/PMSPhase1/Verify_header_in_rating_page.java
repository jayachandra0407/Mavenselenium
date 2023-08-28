package PMS.PMSPhase1;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Calendar;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Verify_header_in_rating_page {

	@Test
	public void tc1() throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();

		ChromeOptions options = new ChromeOptions();

		options.addArguments("--disable-notifications");

		ChromeDriver driver = new ChromeDriver(options);


			String baseURL ="https://test.salesforce.com/";
			
			driver.manage().window().maximize();

			driver.manage().deleteAllCookies();

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));		

			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));

			Actions action = new Actions(driver);		

			JavascriptExecutor executor = (JavascriptExecutor)driver;

			//Login to the UHG Website

			driver.get(baseURL);

			driver.findElement(By.id("username")).sendKeys("pms@crmit.com.pms");

			driver.findElement(By.id("password")).sendKeys("Crmit@#1234");

			driver.findElement(By.id("Login")).click();
			
			if(!(driver.findElements(By.xpath("//a[@class='switch-to-lightning']")).isEmpty()))

			driver.findElement(By.xpath("//a[@class='switch-to-lightning']")).click();
			
			//Navigating to reportee record based on the emp id
			
			Thread.sleep(2000);		

			driver.findElement(By.xpath("//div[@data-aura-class='forceSearchAssistant']/button")).click();
			
			Thread.sleep(2000);		

			driver.findElement(By.xpath("//input[@placeholder='Search...']")).sendKeys("Yuvathi");

			driver.findElement(By.xpath("//input[@placeholder='Search...']")).sendKeys(Keys.ENTER);
			
			Thread.sleep(2000);		
			
			String Employee_name = null;
			String Current_Designation= null;
			String Corporate_Band= null;
			String Corporate_Level= null;
			String Employee_ID= null;
			String Employee_Location= null;
			String Reporting_Manager= null;
			String Cost_Center_Manager= null;
			
			if(driver.findElements((By.xpath("(//div[@class='leftContent slds-col slds-wrap slds-text-body--small slds-text-color--weak']//a[text()='Employees']/../..//p)[2]"))).size()>0)
			{
				if(driver.findElement((By.xpath("(//div[@class='leftContent slds-col slds-wrap slds-text-body--small slds-text-color--weak']//a[text()='Employees']/../..//p)[2]"))).getText().contains("1 Result"))
				{
				driver.findElement(By.xpath("//th//a[text()='Yuvathi']")).click();
				Employee_name = driver.findElement(By.xpath("//records-record-layout-item[@field-label='Employee Name']//lightning-formatted-text")).getText();
				
				Current_Designation = driver.findElement(By.xpath("//records-record-layout-item[@field-label='Designation']//a//span")).getText();
				
				Corporate_Band = driver.findElement(By.xpath("(//records-record-layout-item[@field-label='Corporate Band']//span)[2]")).getText();

				Corporate_Level = driver.findElement(By.xpath("(//records-record-layout-item[@field-label='Grade']//span)[3]")).getText();

				Employee_ID = driver.findElement(By.xpath("(//records-record-layout-item[@field-label='Employee ID']//span)[3]")).getText();

				Employee_Location = driver.findElement(By.xpath("(//records-record-layout-item[@field-label='Employee Location']//span)[3]")).getText();

				Reporting_Manager = driver.findElement(By.xpath("//records-record-layout-item[@field-label='Reporting To']//a//span")).getText();

				Cost_Center_Manager = driver.findElement(By.xpath("(//records-record-layout-item[@field-label='Cost Center Manager']//span)[3]")).getText();

				}
				else
				{
					System.out.println("Multiple records found : "+driver.findElement((By.xpath("(//div[@class='leftContent slds-col slds-wrap slds-text-body--small slds-text-color--weak']//a[text()='Employees']/../..//p)[2]"))).getText());
					System.exit(0);
				}
			}
			else
			{
				System.out.println("Employee record not found");
				System.exit(0);
			}
			//Navigating to Companies

			Thread.sleep(2000);		

			driver.findElement(By.xpath("//div[@role='navigation']")).click();

			driver.findElement(By.xpath("//input[@placeholder='Search apps and items...']")).sendKeys("Performance Management System");

			driver.findElement(By.xpath("//one-app-launcher-menu-item/a[@data-label='Performance Management System']//p")).click();

			driver.findElement(By.xpath("//a[text()='Yuvathi']")).click();

			Thread.sleep(2000);
			
			String Employee_name_ratingpage = driver.findElement(By.xpath("//div/p[text()='Employee Name']/../p[2]")).getText();
			
			String Current_Designation_ratingpage = driver.findElement(By.xpath("//div/p[text()='Current Designation']/../p[2]")).getText();
			
			String Corporate_Band_ratingpage = driver.findElement(By.xpath("//div/p[text()='Corporate Band']/../p[2]")).getText();

			String Corporate_Level_ratingpage = driver.findElement(By.xpath("//div/p[text()='Corporate Level']/../p[2]")).getText();

			String Employee_ID_ratingpage = driver.findElement(By.xpath("//div/p[text()='Employee ID']/../p[2]")).getText();

			String Employee_Location_ratingpage = driver.findElement(By.xpath("//div/p[text()='Employee Location']/../p[2]")).getText();

			String Reporting_Manager_ratingpage = driver.findElement(By.xpath("//div/p[text()='Reporting Manager']/../p[2]")).getText();

			String Cost_Center_Manager_ratingpage = driver.findElement(By.xpath("//div/p[text()='Cost Center Manager']/../p[2]")).getText();

			System.out.println("Employee details : ");
		if(!(Employee_name.equals(Employee_name_ratingpage)))
		{
			System.out.println("Employee name is not matching");
		}
		else
		System.out.println(Employee_name);
		if(!(Current_Designation.equals(Current_Designation_ratingpage)))
		{
			System.out.println("Current Designation is not matching");
			System.out.println(Current_Designation);

		}
		else
		System.out.println(Current_Designation);
		if(!(Corporate_Band.equals(Corporate_Band_ratingpage)))
		{
			System.out.println("Corporate Band is not matching");
			System.out.println(Corporate_Band);
		}
		else
		System.out.println(Corporate_Band);
		if(!(Corporate_Level.equals(Corporate_Level_ratingpage)))
		{
			System.out.println("Corporate Level is not matching");
			System.out.println(Corporate_Level);
		}
		else
		System.out.println(Corporate_Level);
		if(!(Employee_ID.equals(Employee_ID_ratingpage)))
		{
			System.out.println("Employee ID is not matching");
			System.out.println(Employee_ID);
		}
		else
		System.out.println(Employee_ID);
		if(!(Employee_Location.equals(Employee_Location_ratingpage)))
		{
			System.out.println("Employee Location is not matching");
			System.out.println(Employee_Location);

		}
		else
		System.out.println(Employee_Location);
		if(!(Reporting_Manager.equals(Reporting_Manager_ratingpage)))
		{
			System.out.println("Reporting Manager is not matching");
			System.out.println(Reporting_Manager);

		}
		else
		System.out.println(Reporting_Manager);
		if(!(Cost_Center_Manager.equals(Cost_Center_Manager_ratingpage)))
		{
			System.out.println("Cost Center Manager is not matching");
			System.out.println(Cost_Center_Manager);

		}
		else
		System.out.println(Cost_Center_Manager);
		
	}
	}