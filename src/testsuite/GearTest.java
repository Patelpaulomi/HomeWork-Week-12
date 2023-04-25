package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class GearTest extends Utility {
    String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setup(){
        openBrowser(baseUrl);
    }

    @Test

    public void  userShouldAddProductSuccessFullyToShoppinCart() throws InterruptedException {
        Thread.sleep(2000);
        //Mouse Hover on Gear Menu
        mouseHoverToElement(By.id("ui-id-6"));
        // Click on Bags
        mouseHoverAndClick(By.xpath("//span[contains(text(),'Bags')]"));
        //Click on Product Name ‘Overnight Duffle’
        clickOnElement(By.xpath("//a[contains(text(),'Overnight Duffle')]"));
        //Verify the text ‘Overnight Duffle’
        verifyText("Overnight Duffle",By.xpath("//span[contains(text(),'Overnight Duffle')]"),"Overnight Duffle");
       //Change Qty 3
        clearTextFromField(By.xpath("//input[@id='qty']"));
        sendTextToElement(By.xpath("//input[@id='qty']"),"3");
        // Click on ‘Add to Cart’ Button.
        clickOnElement(By.xpath("//span[contains(text(),'Add to Cart')]"));
        // Verify the text‘You added Overnight Duffle to your shopping cart.’
        verifyText("You added Overnight Duffle to your shopping cart.",By.xpath("//div[@role='alert']/div/div"),"You added Overnight Duffle to your shopping cart.");
        // Click on ‘shopping cart’ Link into message
        clickOnElement(By.xpath("//a[contains(text(),'shopping cart')]"));
        //Verify the product name ‘Cronus Yoga Pant’
        verifyText("Overnight Duffle",By.xpath("//td[@class='col item']//a[normalize-space()='Overnight Duffle']"),"Overnight Duffle");
        //Verify the Qty is ‘3’
        String expectedTotal = "3";
        String actualTotal = getTextFromElement(By.xpath("//span[@class='counter-number']"));
        Assert.assertEquals(expectedTotal, actualTotal);
       // verifyText("3", By.xpath("//span[@class='counter-number']"), "3");
        //Verify the product price ‘$135.00’
        verifyText("$135.00",By.xpath("//span[@class='cart-price']//span[@class='price'][normalize-space()='$135.00']"),"$135.00");
        // Change Qty to ‘5’
        clearTextFromField(By.xpath("//input[@id='cart-103429-qty']"));
        sendTextToElement(By.xpath("//input[@id='cart-103429-qty']"),"5");
        //Click on ‘Update Shopping Cart’ button
        clickOnElement(By.xpath("//span[contains(text(),'Update Shopping Cart')]"));
       //Verify the product price ‘$225.00’
        verifyText("$225.00",By.xpath("//td[@class='col subtotal']//span[@data-label='Excl. Tax']"),"$225");




   }
    @After
    public void tearDown(){
        closeBrowser();
    }

}
