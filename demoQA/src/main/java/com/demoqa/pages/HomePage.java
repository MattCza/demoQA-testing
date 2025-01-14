package com.demoqa.pages;

import com.demoqa.base.BasePage;
import com.demoqa.pages.alerts_frame_windows.AlertsFrameWindowsPage;
import com.demoqa.pages.book_store_application.BookStoreApplicationPage;
import com.demoqa.pages.elements.ElementsPage;
import com.demoqa.pages.forms.FormsPage;
import com.demoqa.pages.interactions.InteractionsPage;
import com.demoqa.pages.widgets.WidgetsPage;
import org.openqa.selenium.By;

import static com.demoqa.utilities.JavaScriptUtility.scrollToElementJavaScript;

public class HomePage extends BasePage {

    private By elementsCard = By.xpath("//div[@id='app']//h5[text()='Elements']");
    private By formsCard = By.xpath("//div[@id='app']//h5[text()='Forms']");
    private By alertsFrameWindowsCard = By.xpath("//div[@id='app']//h5[contains(text(),'Frame')]");
    private By widgetsCard = By.xpath("//div[@id='app']//h5[text()='Widgets']");
    private By interactionsCard = By.xpath("//div[@id='app']//h5[text()='Interactions']");
    private By bookStoreApplicationCard = By.xpath("//div[@id='app']//h5[contains(text(), 'Store')]");

    public ElementsPage goToElementsCard() {
        scrollToElementJavaScript(elementsCard);
        click(elementsCard);
        return new ElementsPage();
    }

    public FormsPage goToFormsCard() {
        scrollToElementJavaScript(formsCard);
        click(formsCard);
        return new FormsPage();
    }

    public AlertsFrameWindowsPage goToAlertsFrameWindowsCard() {
        scrollToElementJavaScript(alertsFrameWindowsCard);
        click(alertsFrameWindowsCard);
        return new AlertsFrameWindowsPage();
    }

    public WidgetsPage goToWidgetsCard() {
        scrollToElementJavaScript(widgetsCard);
        click(widgetsCard);
        return new WidgetsPage();
    }

    public InteractionsPage goToInteractionsCard() {
        scrollToElementJavaScript(interactionsCard);
        click(interactionsCard);
        return new InteractionsPage();
    }

    public BookStoreApplicationPage goToBookStoreApplicationCard () {
        scrollToElementJavaScript(bookStoreApplicationCard);
        click(bookStoreApplicationCard);
        return new BookStoreApplicationPage();
    }


}
