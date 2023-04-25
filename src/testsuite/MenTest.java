package testsuite;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class MenTest extends Utility {
    String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setup(){
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldAddProductSuccessFullyToShoppinCart() throws InterruptedException{
        Thread.sleep(2000);
        //Mouse Hover on Men Menu
        mouseHoverToElement(By.xpath("//span[contains(text(),'Men')]"));
        //Mouse Hover on Bottoms
        mouseHoverToElement(By.xpath("//a[@id='ui-id-18']/span[2]"));
        //Click on Pants
        mouseHoverAndClick(By.id("ui-id-23"));
        //Mouse Hover on product name‘Cronus Yoga Pant’ and click on size 32.
        mouseHoverToElement(By.xpath("//a[contains(text(),'Cronus Yoga Pant')]"));
        mouseHoverAndClick(By.id("option-label-size-143-item-175"));
        // Mouse Hover on product name ‘Cronus Yoga Pant’ and click on colour Black.
        mouseHoverToElement(By.xpath("//a[contains(text(),'Cronus Yoga Pant')]"));
        mouseHoverAndClick(By.id("option-label-color-93-item-49"));
        //Mouse Hover on product name‘Cronus Yoga Pant’ and click on‘Add To Cart’ Button.
        mouseHoverToElement(By.xpath("//a[contains(text(),'Cronus Yoga Pant')]"));
        mouseHoverAndClick(By.xpath("//div[@class='actions-primary']/form//button/span"));
        //Verify the text‘You added Cronus Yoga Pant to your shopping cart.’
        verifyText("You added Cronus Yoga Pant to your shopping cart.",By.xpath("//div[@class='message-success success message']"),"You added Cronus Yoga Pant to your shopping cart");
      //Click on ‘shopping cart’ Link into message
        mouseHoverAndClick(By.xpath("//a[contains(text(),'shopping cart')]"));
        //Verify the text ‘Shopping Cart.’
        verifyText("Shopping Cart",By.xpath("//span[@class='base']"),"Shopping Cart");
        //Verify the product name ‘Cronus Yoga Pant’
        verifyText("Cronus Yoga Pant",By.xpath("//td[@class='col item']//a[normalize-space()='Cronus Yoga Pant']"), "Cronus Yoga Pant");
       //Verify the product size ‘32’
        verifyText("32",By.xpath("//dd[contains(text(),'32')]"),"32");
        // Verify the product colour ‘Black’
        verifyText("Black",By.xpath("//dd[contains(text(),'Black')]"),"colour");

    }
    @After
    public void tearDown(){
        closeBrowser();
    }

}
