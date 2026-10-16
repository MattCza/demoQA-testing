package com.demoqa.pages.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class CheckBoxPage extends ElementsPage {
    public static final String PATH = "/checkbox";

    private By selectedItems = By.cssSelector("#result .text-success");

    public CheckBoxPage(WebDriver driver) {
        super(driver);
    }

    public CheckBoxPage open() {
        openPath(PATH);
        return this;
    }

    private String treeNodeXpath(String title) {
        return "//div[@role='treeitem'][.//span[@class='rc-tree-title' and text()='" + title + "']]";
    }

    private By treeNode(String title) {
        return By.xpath(treeNodeXpath(title));
    }

    private By nodeSwitcher(String title) {
        return By.xpath(treeNodeXpath(title) + "/span[contains(@class,'rc-tree-switcher')]");
    }

    private By nodeCheckbox(String title) {
        return By.xpath("//span[@role='checkbox' and @aria-label='Select " + title + "']");
    }

    public void expandNode(String title) {
        waitUntilVisible(treeNode(title));
        if ("false".equals(find(treeNode(title)).getAttribute("aria-expanded"))) {
            scrollToElementJavaScript(nodeSwitcher(title));
            click(nodeSwitcher(title));
        }
    }

    public void expandNodes(String... titles) {
        for (String title : titles) {
            expandNode(title);
        }
    }

    public void selectItem(String title) {
        waitUntilVisible(nodeCheckbox(title));
        if (!isItemChecked(title)) {
            scrollToElementJavaScript(nodeCheckbox(title));
            click(nodeCheckbox(title));
        }
    }

    public boolean isItemChecked(String title) {
        return "true".equals(checkboxState(title));
    }

    // A parent with only some children selected is shown as partially checked
    public boolean isItemPartiallyChecked(String title) {
        return "mixed".equals(checkboxState(title));
    }

    private String checkboxState(String title) {
        return find(nodeCheckbox(title)).getAttribute("aria-checked");
    }

    public List<String> getSelectedItems() {
        List<String> items = new ArrayList<>();
        for (WebElement element : driver.findElements(selectedItems)) {
            String itemText = element.getText().trim();
            if (!itemText.isEmpty()) {
                items.add(itemText);
            }
        }
        return items;
    }

}
