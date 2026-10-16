package com.demoqa.pages;

import com.demoqa.base.BasePage;
import com.demoqa.pages.alerts_frame_windows.AlertsFrameWindowsPage;
import com.demoqa.pages.book_store_application.BookStoreApplicationPage;
import com.demoqa.pages.elements.ElementsPage;
import com.demoqa.pages.forms.FormsPage;
import com.demoqa.pages.interactions.InteractionsPage;
import com.demoqa.pages.widgets.WidgetsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    public static final String PATH = "/";

    private By elementsCard = By.xpath("//div[@class='card-body']/h5[text()='Elements']");
    private By formsCard = By.xpath("//div[@class='card-body']/h5[text()='Forms']");
    private By alertsFrameWindowsCard = By.xpath("//div[@class='card-body']/h5[contains(text(),'Frame')]");
    private By widgetsCard = By.xpath("//div[@class='card-body']/h5[text()='Widgets']");
    private By interactionsCard = By.xpath("//div[@class='card-body']/h5[text()='Interactions']");
    private By bookStoreApplicationCard = By.xpath("//div[@class='card-body']/h5[contains(text(), 'Store')]");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage open() {
        openPath(PATH);
        return this;
    }

    public ElementsPage goToElementsCard() {
        scrollToElementJavaScript(elementsCard);
        click(elementsCard);
        return new ElementsPage(driver);
    }

    public FormsPage goToFormsCard() {
        scrollToElementJavaScript(formsCard);
        click(formsCard);
        return new FormsPage(driver);
    }

    public AlertsFrameWindowsPage goToAlertsFrameWindowsCard() {
        scrollToElementJavaScript(alertsFrameWindowsCard);
        click(alertsFrameWindowsCard);
        return new AlertsFrameWindowsPage(driver);
    }

    public WidgetsPage goToWidgetsCard() {
        scrollToElementJavaScript(widgetsCard);
        click(widgetsCard);
        return new WidgetsPage(driver);
    }

    public InteractionsPage goToInteractionsCard() {
        scrollToElementJavaScript(interactionsCard);
        click(interactionsCard);
        return new InteractionsPage(driver);
    }

    public BookStoreApplicationPage goToBookStoreApplicationCard () {
        scrollToElementJavaScript(bookStoreApplicationCard);
        click(bookStoreApplicationCard);
        return new BookStoreApplicationPage(driver);
    }


}
