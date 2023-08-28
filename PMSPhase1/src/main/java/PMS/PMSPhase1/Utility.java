package PMS.PMSPhase1;

import java.io.File;import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.WebDriver;

public class Utility 
{
public static void captureScreenshot(WebDriver driver,String screenshotName)
{

try 
{
TakesScreenshot ts=(TakesScreenshot)driver;

File source=ts.getScreenshotAs(OutputType.FILE);

FileHandler.copy(source, new File("D:\\UHG AUTOMATION\\UHG_1\\Screenshots\\"+screenshotName+".png"));

System.out.println("Screenshot taken");
} 
catch (Exception e)
{

System.out.println("Exception while taking screenshot "+e.getMessage());
} 
}
}
