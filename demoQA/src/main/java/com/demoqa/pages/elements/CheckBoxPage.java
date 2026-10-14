package com.demoqa.pages.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static com.demoqa.utilities.JavaScriptUtility.scrollToElementJavaScript;
import static com.demoqa.utilities.Utility.explicitWaitUntilVisible;

public class CheckBoxPage extends ElementsPage {
    private By selectedItems = By.cssSelector("#result .text-success");

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
        explicitWaitUntilVisible(5, treeNode(title));
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
        explicitWaitUntilVisible(5, nodeCheckbox(title));
        if (!isItemChecked(title)) {
            scrollToElementJavaScript(nodeCheckbox(title));
            click(nodeCheckbox(title));
        }
    }

    public boolean isItemChecked(String title) {
        return "true".equals(find(nodeCheckbox(title)).getAttribute("aria-checked"));
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
