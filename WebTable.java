package Task;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class WebTable {
    static void Table() {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://html.com/tables/");
        driver.manage().window().maximize();

     List <WebElement> rows = driver.findElements(By.xpath("//table[@class='related-elements']/tbody/tr"));
     List  <WebElement> columns = driver.findElements(By.xpath("//table[@class='related-elements']/tbody/tr/th"));
     int rowNum = rows.size();
     int colNum = columns.size();
        System.out.println(rowNum);
        System.out.println(colNum);
       for(int i=2; i<= rows.size(); i++) {
           for (int j = 1; j <= columns.size(); j++) {
               WebElement content = driver.findElement(By.xpath("//table[@class='related-elements']/tbody/tr[" + i + "]/td[" + j + "]"));
               //content.getText();
               String table = content.getText();
               // Object students[][] = new Object[rowNum][colNum];
               //students [i][j] = content.getText();
               System.out.println(table);
           }
       }
            }


       // System.out.println(driver.findElement(By.xpath("//table[@class='related-elements']/tbody/tr[8]/td[3]")).getText()); */



    public static void main(String[] args) {
        Table();
    }
}

