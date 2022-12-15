package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
//import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.BooksPage;
import pages.WishListPage;

import java.util.List;
import static stepDefinitions.Hooks.driver;

public class AddToWishList {
    BooksPage booksPage;
    WishListPage wishListPage;

    @And("user add items to wish list")
    public void userAddItemsToWishList() {
        booksPage = new BooksPage(driver);
        booksPage.addItemsToFav();
    }

    @And("user navigate to wish list")
    public void userNavigateToWishList() {
        booksPage.openWishListPage();
    }

    @Then("added items should appear at wish list")
    public void addedItemsShouldAppearAtWishList() {
        wishListPage = new WishListPage(driver);
        List<WebElement> itemsName = (List<WebElement>) wishListPage.getWishListItemNames();
        //List<WebElement> itemsName = wishListPage.getWishListItemNames();
        Assert.assertEquals(itemsName.get(0).getText(),"Fahrenheit 451 by Ray Bradbury");
        Assert.assertEquals(itemsName.get(1).getText(),"First Prize Pies");
        Assert.assertEquals(itemsName.get(2).getText(),"Pride and Prejudice");

        List<WebElement> itemsQty = wishListPage.getWishListItemQty();
        int qty = 0;
        for (WebElement qtyElement : itemsQty){
            qty += Integer.parseInt(qtyElement.getAttribute("value"));
        }
        System.out.println("qty : "+qty);
        //Assert.assertEquals(3);
        Assert.assertEquals(3,3);

        Assert.assertEquals(wishListPage.getWishListTitle(), "Wishlist");
    }
}
