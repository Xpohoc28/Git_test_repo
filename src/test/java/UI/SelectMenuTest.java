package UI;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.demoqa.SelectMenuPage;

public class SelectMenuTest extends BaseTest {

    private SelectMenuPage selectMenuPage;

    @BeforeClass
    public void beforeClass(){
        System.out.println("Setting up before class in SelectMenuTest.");
        selectMenuPage = new SelectMenuPage(driver);
    }

    @Test(description = "Перейти на страницу 'Select Menu'")
    public void step_01(){
        selectMenuPage.openSelectMenuPage();
        Assert.assertEquals(selectMenuPage.getPageName(), "Select Menu");
    }

    @Test(description = "В первом выпадающем списке выбрать 'Group 1 Option 2'")
    public void step_02(){
        selectMenuPage.clickFirstDropDown();
        selectMenuPage.setSecondOptionInFirstDropDown();
        Assert.assertTrue(selectMenuPage.isSecondOptionDisplayedInFirstField());
    }
}