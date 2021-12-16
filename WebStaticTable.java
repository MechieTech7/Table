package table;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import java.util.List;
public class WebStaticTable {
    WebDriver driver;
    List<WebElement> structureColumn;
    List<WebElement> rowCells;
    @BeforeTest
    void openURL(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.techlistic.com/p/demo-selenium-practice.html");
    }
    @AfterTest
    void closeBrowser(){
        driver.close();
    }

    @BeforeMethod
    void getStructure(){
        structureColumn =driver.findElements(By.xpath("//table[@class='tsc_table_s13']/tbody/tr/th"));
        rowCells =driver.findElements(By.xpath("//table[@class='tsc_table_s13']/tbody/tr[1]/td"));
    }
    @Test()
    void checkBurgKhalifaHeight(){
        for (int i = 1; i<= structureColumn.size(); i++){
            for (int j = 1; j <= rowCells.size(); j++) {
                if (driver.findElement(By.xpath("//table[@class='tsc_table_s13']/tbody/tr["+i+"]/td["+j+"]")).getText().equals("829m")){
                    System.out.println(driver.findElement(By.xpath("//table[@class='tsc_table_s13']/tbody/tr["+i+"]/th")).getText());
                }
            }
        }
    }
    @Test
    void getAllRowContents(){
        for (int i = 1; i<= structureColumn.size(); i++){
            System.out.println(driver.findElement(By.xpath("//table[@class='tsc_table_s13']/tbody/tr["+i+"]/th[1]")).getText());
            for (int j = 1; j<= rowCells.size(); j++) {
                System.out.println(driver.findElement(By.xpath("//table[@class='tsc_table_s13']/tbody/tr["+i+"]/td["+j+"]")).getText());
            }
            System.out.println("Second assignment done");
        }
    }
    @Test
    void checkStructureHas4Values(){
        Assert.assertEquals(structureColumn.size(),4);
    }
    @Test
    void check6thRowHasTwoColumns() {
        List<WebElement> footerhead = driver.findElements(By.xpath("//table/tfoot/tr/th"));
        List<WebElement> footercells = driver.findElements(By.xpath("//table/tfoot/tr/td"));
        int sixthrowColumnCount = footerhead.size() + footercells.size();
        Assert.assertEquals(sixthrowColumnCount, 2);
        System.out.println("it has two columns");
    }
}