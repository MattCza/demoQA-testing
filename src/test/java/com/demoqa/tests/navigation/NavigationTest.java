package com.demoqa.tests.navigation;

import com.demoqa.base.BasePage;
import com.demoqa.base.BaseTest;
import com.demoqa.pages.HomePage;
import com.demoqa.pages.alerts_frame_windows.AlertsFrameWindowsPage;
import com.demoqa.pages.book_store_application.BookStoreApplicationPage;
import com.demoqa.pages.elements.ButtonsPage;
import com.demoqa.pages.elements.CheckBoxPage;
import com.demoqa.pages.elements.DynamicPropertiesPage;
import com.demoqa.pages.elements.ElementsPage;
import com.demoqa.pages.elements.LinksPage;
import com.demoqa.pages.elements.TextBoxPage;
import com.demoqa.pages.elements.WebTablesPage;
import com.demoqa.pages.forms.FormsPage;
import com.demoqa.pages.forms.PracticeFormPage;
import com.demoqa.pages.interactions.InteractionsPage;
import com.demoqa.pages.widgets.WidgetsPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.function.Function;

public class NavigationTest extends BaseTest {

    @DataProvider
    public Object[][] homeCards() {
        return new Object[][]{
                {"Elements", nav(HomePage::goToElementsCard), ElementsPage.PATH},
                {"Forms", nav(HomePage::goToFormsCard), FormsPage.PATH},
                {"Alerts, Frame & Windows", nav(HomePage::goToAlertsFrameWindowsCard), AlertsFrameWindowsPage.PATH},
                {"Widgets", nav(HomePage::goToWidgetsCard), WidgetsPage.PATH},
                {"Interactions", nav(HomePage::goToInteractionsCard), InteractionsPage.PATH},
                {"Book Store Application", nav(HomePage::goToBookStoreApplicationCard), BookStoreApplicationPage.PATH},
        };
    }

    @Test(dataProvider = "homeCards")
    public void homeCardOpensSection(String card, Function<HomePage, BasePage> clickCard, String expectedPath) {
        BasePage section = clickCard.apply(new HomePage(driver()).open());

        Assert.assertEquals(section.waitForPath(expectedPath), expectedPath,
                "Home card '" + card + "' opened the wrong page");
    }

    @DataProvider
    public Object[][] elementsMenuItems() {
        return new Object[][]{
                {"Text Box", menu(ElementsPage::clickTextBoxItem), TextBoxPage.PATH},
                {"Check Box", menu(ElementsPage::clickCheckBoxItem), CheckBoxPage.PATH},
                {"Web Tables", menu(ElementsPage::clickWebTablesItem), WebTablesPage.PATH},
                {"Buttons", menu(ElementsPage::clickButtonsItem), ButtonsPage.PATH},
                {"Links", menu(ElementsPage::clickLinksItem), LinksPage.PATH},
                {"Dynamic Properties", menu(ElementsPage::clickDynamicPropertiesItem), DynamicPropertiesPage.PATH},
        };
    }

    @Test(dataProvider = "elementsMenuItems")
    public void elementsMenuItemOpensPage(String item, Function<ElementsPage, BasePage> clickItem, String expectedPath) {
        BasePage page = clickItem.apply(new ElementsPage(driver()).open());

        Assert.assertEquals(page.waitForPath(expectedPath), expectedPath,
                "Elements menu item '" + item + "' opened the wrong page");
    }

    @Test
    public void formsMenuOpensPracticeForm() {
        PracticeFormPage page = new FormsPage(driver()).open().clickPracticeBoxItem();

        Assert.assertEquals(page.waitForPath(PracticeFormPage.PATH), PracticeFormPage.PATH,
                "Forms menu item 'Practice Form' opened the wrong page");
    }

    private static Function<HomePage, BasePage> nav(Function<HomePage, BasePage> navigation) {
        return navigation;
    }

    private static Function<ElementsPage, BasePage> menu(Function<ElementsPage, BasePage> navigation) {
        return navigation;
    }

}