package com.demoqa.tests.elements;

import com.demoqa.base.BaseTest;
import com.demoqa.pages.elements.LinksPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LinksTest extends BaseTest {

    @Test
    public void linkTest() {
        String actualMovedResponse;
        String actualForbiddenResponse;

        LinksPage linksPage = homePage.goToElementsCard().clickLinksItem();
        linksPage.clickSimpleLink();
        linksPage.closeWindow();

        linksPage.clickMovedResponseLink();
        actualMovedResponse = linksPage.getResponse();
        Assert.assertTrue(actualMovedResponse.contains("301")
                        && actualMovedResponse.contains("Moved Permanently"),
                "\n Actual Response Does Not Contain '301' and 'Moved Permanently' \n");


        linksPage.clickForbiddenResponseLink();
        actualForbiddenResponse = linksPage.getResponse();
        Assert.assertTrue(actualForbiddenResponse.contains("403")
                        && actualForbiddenResponse.contains("Forbidden"),
                "\n Actual Response Does Not Contain '403' and 'Forbidden' \n");
    }
}
