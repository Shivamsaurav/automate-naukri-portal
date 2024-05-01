package AutomatePortal;

import java.time.LocalTime;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NaukriSelenium {

	public static void main(String[] args) {
		
		
		/*// Get the current time
        LocalTime currentTime = LocalTime.now();
		//System.out.println(currentTime);
		
		if(currentTime.getHour() == 9 && currentTime.getMinute() >= 00 ) {
			updateResume();
		}*/
		updateResume();
	}
	
	public static void updateResume() {
		// Initialize ChromeDriver
        WebDriver driver = new ChromeDriver();
        
        // Open naukri.com
        driver.get("https://www.naukri.com/nlogin/login");
        
        // Optional: Maximize the browser window
        driver.manage().window().maximize();
        
        // enter your email address and password 
        WebElement email = driver.findElement(By.id("usernameField")); 
        email.sendKeys("Your Email"); 
        
        WebElement password = driver.findElement(By.id("passwordField")); 
        password.sendKeys("Your Password"); 
 
        // click the login button 
        WebElement loginButton = driver.findElement(By.cssSelector(".blue-btn")); 
        loginButton.click(); 
 
        // wait for the login to complete 
        try { 
            Thread.sleep(2000); 
        } catch (InterruptedException e) { 
            e.printStackTrace(); 
        } 
        
        // click the view profile button 
        WebElement viewProfileButton = driver.findElement(By.xpath("/html/body/main/div/div/div[3]/div/div[3]/div[2]/a")); 
        viewProfileButton.click(); 
        
        
        WebDriverWait wait = new WebDriverWait(driver, 10); // Wait up to 10 seconds for the element to be present
        WebElement updateResumeButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html[1]/body[1]/div[3]/div[1]/div[1]/span[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]/section[1]/div[1]/div[2]/input[1]")));
        updateResumeButton.sendKeys("Local Path of your resume");
        
        String resumeFilePath = "Local Path of your resume";
        WebElement chooseFileInput = driver.findElement(By.xpath("//input[@type='file']"));
        chooseFileInput.sendKeys(resumeFilePath);
	}

}
