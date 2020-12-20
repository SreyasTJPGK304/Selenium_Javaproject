package training;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;
public class test1 {
 WebDriver driver;
 @BeforeTest
 public void openWebsite() {
  System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");
  driver = new ChromeDriver();
  driver.manage().window().maximize();//to maximize window
  driver.get("https://www.cleartrip.com");
  String title = driver.getTitle();
  System.out.println(title);
  Assert.assertEquals(title, "#1 Site for Booking Flights, Hotels, Packages, Trains & Local activities.");
  System.out.println("Before test completed");
 }
 @Test(priority=0)
 public void testmethod() throws InterruptedException {
  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  WebElement flight = driver.findElement(By.xpath("//a[text()='Flights']"));
  flight.click();
  WebElement Onewayradio = driver.findElement(By.xpath("\"//label[@title='One way']\""));
  Onewayradio.click();
  Thread.sleep(2000);
  driver.findElement(By.id("FromTag")).sendKeys("Kochi, IN - Cochin International Airport (COK)");
  driver.findElement(By.id("ToTag")).sendKeys("Bangalore, IN - Kempegowda International Airport (BLR)");
  Thread.sleep(2000);
  SimpleDateFormat date = new SimpleDateFormat("DD/MM/YYYY");
  Calendar calendar = Calendar.getInstance();
  calendar.add(Calendar.DATE, 30);
  String date1 = date.format(calendar.getTime());
  WebElement departDate = driver.findElement(By.xpath("//input[@placeholder='Pick a date']"));
  departDate.sendKeys(date1);
  Select adult = new Select(driver.findElement(By.id("Adults")));
  adult.selectByIndex(0);
  Select child = new Select(driver.findElement(By.id("Childrens")));
  child.selectByIndex(1);
  Select infant = new Select(driver.findElement(By.id("Infants")));
  infant.selectByIndex(1);
  driver.findElement(By.id("SearchBtn")).click();
  Thread.sleep(3000);
 }
 @Test(priority=1)
 public void testmethod1() throws InterruptedException {
  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  driver.findElement(By.xpath("//p[text()='Non-stop']")).click();
  Thread.sleep(3000);
  WebElement slider = driver.findElement(By.xpath("(//div[@role='slider'])[1]"));
  Thread.sleep(3000);
  Actions move = new Actions(driver);
  slider.click();
  move.dragAndDropBy(slider, -136, 0).build().perform();
  move.release();
  Thread.sleep(3000);
  driver.findElement(By.xpath("//p[text()='Show multi-airline itineraries']")).click();
  Thread.sleep(3000);
  driver.findElement(By.xpath("//button[text()='Book']")).click();
 }
 @Test(priority=2)
 public void testmethod2() throws InterruptedException {
  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  String pageTitle = driver.getTitle();
  Assert.assertEquals(pageTitle, "Cleartrip | Book your flight securely in simple steps");
  Thread.sleep(3000);
  driver.findElement(By.xpath("itineraryBtn")).click();
  Thread.sleep(3000);
  driver.findElement(By.xpath("//input[@name='username']")).sendKeys("shridar@gmail.com");
  driver.findElement(By.xpath("//input[@id='LoginContinueBtn_1']")).click();
  Thread.sleep(3000);
  System.out.println("Test method 2 executed");
 }
 @Test(priority=3)
 public void testmethod3() throws InterruptedException {
  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  WebElement adulttitle = driver.findElement(By.name("AdultTitle1"));
  adulttitle.click();
  Select drpdwn1=new Select(adulttitle);
  drpdwn1.selectByValue("Mr");
  driver.findElement(By.name("AdultFname1")).sendKeys("Shridar");
  driver.findElement(By.name("AdultLname1")).sendKeys("s");
  Thread.sleep(1000);
  //child details
  WebElement childtitle = driver.findElement(By.name("ChildTitle1"));
  childtitle.click();
  Select drpdwn2=new Select(childtitle);
  drpdwn2.selectByValue("Mr");
  driver.findElement(By.name("ChildFname1")).sendKeys("Alan");
  driver.findElement(By.name("ChildLname1")).sendKeys("M");
  Thread.sleep(1000);
  WebElement dob1 = driver.findElement(By.name("ChildDobDay1"));
  dob1.click();
  Select drpdob1=new Select(dob1);
  drpdob1.selectByValue("15");
  WebElement dob2 = driver.findElement(By.name("ChildDobMonth1"));
  dob2.click();
  Select drpdob2=new Select(dob2);
  drpdob2.selectByValue("5");
  WebElement dob3 = driver.findElement(By.name("ChildDobYear1"));
  dob3.click();
  Select drpdob3=new Select(dob3);
  drpdob3.selectByValue("2015");
  WebElement title3 = driver.findElement(By.name("InfantTitle1"));
  title3.click();
  Select drpdwn3=new Select(title3);
  drpdwn3.selectByValue("Mstr");
  driver.findElement(By.name("InfantFname1")).sendKeys("Irfan");
  driver.findElement(By.name("InfantLname1")).sendKeys("H");
  Thread.sleep(2000);
  WebElement dob4 = driver.findElement(By.name("InfantDobDay1"));
  dob1.click();
  Select drpdob4=new Select(dob4);
  drpdob4.selectByValue("4");
  WebElement dob5 = driver.findElement(By.name("InfantDobMonth1"));
  dob2.click();
  Select drpdob5=new Select(dob5);
  drpdob5.selectByValue("4");

  WebElement dob6 = driver.findElement(By.name("InfantDobYear1"));
  dob3.click();
  Select drpdob6=new Select(dob6);
  drpdob6.selectByValue("2020");

  driver.findElement(By.name("contact1")).sendKeys("9487694254");
  Thread.sleep(2000);

  driver.findElement(By.id("travellerBtn")).click();
  Thread.sleep(2000);

  System.out.println("Test method 3 executed");

 }
 @AfterTest()
 public void aftertestmethod()
 {

  driver.quit();

 }






}

