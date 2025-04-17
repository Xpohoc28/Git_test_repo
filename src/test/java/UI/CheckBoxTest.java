package UI;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.demoqa.CheckBoxPage;

public class CheckBoxTest extends BaseTest {

    private CheckBoxPage checkBoxPage;

    @BeforeClass
    public void beforeClass(){
        System.out.println("Setting up before class in CheckBoxTest.");
        checkBoxPage = new CheckBoxPage(driver);
    }

    @Test(description = "Перейти на страницу")
    public void step_01(){
        checkBoxPage.openCheckBoxPage();
        Assert.assertEquals(checkBoxPage.getPageName(), "Check Box");
    }

    @Test(description = "Развернуть чекбосы 'Home', отметить чекбокс 'Desktop'")
    public void step_02(){
        checkBoxPage.openListCheckBox("Home");
        checkBoxPage.setCheckBox("Desktop",true);
        Assert.assertTrue(checkBoxPage.getCheckBoxState("Desktop"));
    }
}