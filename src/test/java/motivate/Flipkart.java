package motivate;

import java.sql.Driver;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Flipkart {

	public static WebDriver driver;

	@Given("user in flipkart login page")
	public void user_in_flipkart_login_page() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();

	}

	@When("user enter invalid phoneno and invalid password in a login page")
	public void user_enter_invalid_phoneno_and_invalid_password_in_a_login_page() {

		WebElement user = driver.findElement(By.xpath("(//input[@type='text'])[2]"));
		user.sendKeys("9638527419");
		WebElement pass = driver.findElement(By.xpath("//input[@type='password']"));
		pass.sendKeys("krishnan");
		WebElement buttn = driver.findElement(By.xpath("(//button[@type='submit'])[2]"));
		buttn.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.navigate().refresh();

	}

	@When("user enter invalid phoneno and valid password in a login page")
	public void user_enter_invalid_phoneno_and_valid_password_in_a_login_page() {
		WebElement user = driver.findElement(By.xpath("(//input[@type='text'])[2]"));
		user.sendKeys("9638527419");
		WebElement pass = driver.findElement(By.xpath("//input[@type='password']"));
		pass.sendKeys("krishnan94");
		WebElement buttn = driver.findElement(By.xpath("(//button[@type='submit'])[2]"));
		buttn.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.navigate().refresh();
	}

	@When("user enter valid phoneno and invalid password in a login page")
	public void user_enter_valid_phoneno_and_invalid_password_in_a_login_page() {
		WebElement user = driver.findElement(By.xpath("(//input[@type='text'])[2]"));
		user.sendKeys("8110084465");
		WebElement pass = driver.findElement(By.xpath("//input[@type='password']"));
		pass.sendKeys("krishnan");
		WebElement buttn = driver.findElement(By.xpath("(//button[@type='submit'])[2]"));
		buttn.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@Then("user should get incorrect message for invalid login")
	public void user_should_get_incorrect_message_for_invalid_login() {
		WebElement text = driver.findElement(By.xpath("//span[text()='Your username or password is incorrect']"));
		String message = text.getText();
		System.out.println(message);
		driver.close();
	}

	@When("user have to enter maximum ten numbers phoneno if it is minimum")
	public void user_have_to_enter_maximum_ten_numbers_phoneno_if_it_is_minimum() {
		WebElement user = driver.findElement(By.xpath("(//input[@type='text'])[2]"));
		user.sendKeys("811008446");
		WebElement pass = driver.findElement(By.xpath("//input[@type='password']"));
		pass.sendKeys("krishnan94");
		WebElement buttn = driver.findElement(By.xpath("(//button[@type='submit'])[2]"));
		buttn.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.navigate().refresh();
	}

	@When("user have to enter minimum ten numbers phoneno if it is maximum")
	public void user_have_to_enter_minimum_ten_numbers_phoneno_if_it_is_maximum() {
		WebElement user = driver.findElement(By.xpath("(//input[@type='text'])[2]"));
		user.sendKeys("81100844658");
		WebElement pass = driver.findElement(By.xpath("//input[@type='password']"));
		pass.sendKeys("krishnan");
		WebElement buttn = driver.findElement(By.xpath("(//button[@type='submit'])[2]"));
		buttn.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.navigate().refresh();
	}

	@When("user have to login without entering passing the values")
	public void user_have_to_login_without_entering_passing_the_values() {
		WebElement buttn = driver.findElement(By.xpath("(//button[@type='submit'])[2]"));
		buttn.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

	@Then("user should get incorrect message for invalid login access")
	public void user_should_get_incorrect_message_for_invalid_login_access() {
		WebElement text = driver.findElement(By.xpath("//span[text()='Please enter valid Email ID/Mobile number']"));
		String message = text.getText();
		System.out.println(message);
		driver.close();
	}

	@When("user have to valid username and valid password")
	public void user_have_to_valid_username_and_valid_password() {
		WebElement user = driver.findElement(By.xpath("(//input[@type='text'])[2]"));
		user.sendKeys("8110084465");
		WebElement pass = driver.findElement(By.xpath("//input[@type='password']"));
		pass.sendKeys("krishnan94");
		WebElement buttn = driver.findElement(By.xpath("(//button[@type='submit'])[2]"));
		buttn.click();
		driver.navigate().refresh();

	}

	@When("user have to search for the products and add the product into add cart")
	public void user_have_to_search_for_the_products_and_add_the_product_into_add_cart() {
		WebElement search = driver.findElement(By.xpath("//input[@class='_3704LK']"));
		search.sendKeys("apple");
		WebElement button = driver.findElement(By.xpath("//button[@class='L0Z3Pu']"));
		button.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement prodclick = driver.findElement(By.xpath("//div[text()='APPLE iPhone 11 (Black, 64 GB)']"));
		prodclick.click();
		// Use windows handling concept
		// To fetch parent window
		String parentid = driver.getWindowHandle();

		// To fetch all windows
		Set<String> allwindows = driver.getWindowHandles();
		for (String allid : allwindows) {
			if (!parentid.equals(allid)) {
				driver.switchTo().window(allid);
			}

		}

		WebElement cart = driver.findElement(By.xpath("//button[@class='_2KpZ6l _2U9uOA _3v1-ww']"));
		cart.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.navigate().refresh();
		// Get the product name
		WebElement productname = driver.findElement(By.xpath("//a[text()='APPLE iPhone 11 (Black, 64 GB)']"));
		String brand = productname.getText();
		System.out.println(brand);

	}

}
