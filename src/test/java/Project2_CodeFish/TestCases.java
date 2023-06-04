package Project2_CodeFish;

import BrwosersUtilMethods.BrowsersUtil;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class TestCases {




    @Test
    public void Tc_01() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions=new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");
        //validating Title :
        Assert.assertEquals(driver.getTitle(),"Web Orders Login");
        Thread.sleep(1000);
        //login function
        driver.findElement(By.cssSelector("#ctl00_MainContent_username")).sendKeys("Tester");
        driver.findElement(By.cssSelector("#ctl00_MainContent_password")).sendKeys("test");
        driver.findElement(By.xpath("//input[@value='Login']")).click();
        Thread.sleep(1000);
        // validating Title and Header
        Assert.assertEquals(driver.getTitle(),"Web Orders");
        WebElement header1=driver.findElement(By.xpath("//h2"));
        Assert.assertEquals(BrowsersUtil.getText(header1),"List of All Orders");


    }


    @Test
    public void Tc_02() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions=new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");
        //validating Title :
        Assert.assertEquals(driver.getTitle(),"Web Orders Login");
        Thread.sleep(1000);
        //login function
        driver.findElement(By.cssSelector("#ctl00_MainContent_username")).sendKeys("Tester");
        driver.findElement(By.cssSelector("#ctl00_MainContent_password")).sendKeys("test");
        driver.findElement(By.xpath("//input[@value='Login']")).click();
        Thread.sleep(1000);
        // validating Title and Header
        Assert.assertEquals(driver.getTitle(),"Web Orders");
        WebElement header1=driver.findElement(By.xpath("//h2"));
        Assert.assertEquals(BrowsersUtil.getText(header1),"List of All Orders");


        Thread.sleep(1000);
        // clicking view all products and validate is selected
        WebElement viewAllProducts=driver.findElement(By.xpath("//a[.='View all products']"));
        if(!viewAllProducts.isSelected()){
        viewAllProducts.click();}
        Thread.sleep(1000);
        viewAllProducts=driver.findElement(By.xpath("//a[.='View all products']"));
        // Assert.assertTrue(viewAllProducts.isSelected()); // validation
        // header-2
        WebElement header2=driver.findElement(By.xpath("//h2"));
        Assert.assertEquals(BrowsersUtil.getText(header2),"List of Products");
        //title
        Assert.assertTrue(driver.getCurrentUrl().contains("Products"));

    }


    @Test
    public void Tc_03() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions=new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");
        //validating Title :
        Assert.assertEquals(driver.getTitle(),"Web Orders Login");
        Thread.sleep(1000);
        //login function
        driver.findElement(By.cssSelector("#ctl00_MainContent_username")).sendKeys("Tester");
        driver.findElement(By.cssSelector("#ctl00_MainContent_password")).sendKeys("test");
        driver.findElement(By.xpath("//input[@value='Login']")).click();
        Thread.sleep(1000);


        //Links
        List<WebElement> allLinks=driver.findElements(By.xpath("//li//a"));
        for(WebElement eachLink : allLinks){
            if(BrowsersUtil.getText(eachLink).equals("View all orders")){
            Assert.assertTrue(eachLink.getAttribute("href").contains("Default.aspx"));
            System.out.println(eachLink.getAttribute("href"));
            }else if (BrowsersUtil.getText(eachLink).equals("View all products")){
            Assert.assertTrue(eachLink.getAttribute("href").contains("Products.aspx"));
            System.out.println(eachLink.getAttribute("href"));
            }else if(BrowsersUtil.getText(eachLink).equals("Order")){
            Assert.assertTrue(eachLink.getAttribute("href").contains("Process.aspx"));
            System.out.println(eachLink.getAttribute("href"));
            }else{
            Assert.assertTrue(false);
            }
        }

    }








    @Test
    public void Tc_04() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions=new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");
        //login function
        driver.findElement(By.cssSelector("#ctl00_MainContent_username")).sendKeys("Tester");
        driver.findElement(By.cssSelector("#ctl00_MainContent_password")).sendKeys("test");
        driver.findElement(By.xpath("//input[@value='Login']")).click();
        Thread.sleep(1000);


        //clicking Order Button and selecting ScreenServer
        driver.findElement(By.xpath("//a[.='Order']")).click();
        WebElement selectingScreenSaver=driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_ddlProduct"));
        BrowsersUtil.selectBy(selectingScreenSaver,"ScreenSaver","value");

        driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_txtQuantity")).sendKeys("5");
        driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_txtName")).sendKeys("CodeFishITSchool");
        driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox2")).sendKeys("2200 E DEVON");
        driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox3")).sendKeys("Des Plaines");
        driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox4")).sendKeys("IL");
        driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox5")).sendKeys("60018");
        driver.findElement(By.xpath("//input[@value='MasterCard']")).click();
        driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox6")).sendKeys("444993876233");
        driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$TextBox1']")).sendKeys("03/24");
        driver.findElement(By.xpath("//a[@id='ctl00_MainContent_fmwOrder_InsertButton']")).click();

       //validating Order was ordered successfully
        WebElement OrderDone=driver.findElement(By.xpath("//div//strong"));
        Thread.sleep(1000);
       // BrowsersUtil.scrollWithJS(driver,OrderDone);
        Assert.assertEquals(BrowsersUtil.getText(OrderDone),"New order has been successfully added.");

        //Moving to view All Orders
        driver.findElement(By.xpath("//a[.='View all orders']")).click();


        //validaiting Order is on the Order Box and infos

        WebElement orderInfo=driver.findElement(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//td[1]"));
        System.out.println(BrowsersUtil.getText(orderInfo));



//        driver.findElement().sendKeys();
//        driver.findElement().sendKeys();





    }






}
