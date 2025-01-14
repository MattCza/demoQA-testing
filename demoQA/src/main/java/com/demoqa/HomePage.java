package com.demoqa;

import com.base.BasePage;
import com.demoqa.alerts_frame_windows.AlertsFrameWindowsPage;
import com.demoqa.book_store_application.BookStoreApplicationPage;
import com.demoqa.elements.ElementsPage;
import com.demoqa.forms.FormsPage;
import com.demoqa.interactions.InteractionsPage;
import com.demoqa.widgets.WidgetsPage;
import org.openqa.selenium.By;

import static com.utilities.JavaScriptUtility.*;

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
