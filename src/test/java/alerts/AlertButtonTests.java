package alerts;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class AlertButtonTests extends BaseTests {
    @Test
    public void testAlerts(){
        var alertsPage = homePage.clickJavascriptAlerts();
        alertsPage.clickAlertButton();
        alertsPage.alert_clickToAccept();
        assertEquals(alertsPage.getResult(), "You successfully clicked an alert", "messages don't match");
    }

    @Test
    public void testGetTextFromAlert(){
        var alertsPage = homePage.clickJavascriptAlerts();
        alertsPage.clickConfirmButton();
        String text = alertsPage.alert_getText();
        alertsPage.alert_clickToDismiss();
        assertEquals(text, "I am a JS Confirm", "alert text is incorrect");
        alertsPage.getResult();
    }

    @Test
    public void testSetInputInAlert(){
        var alertsPage = homePage.clickJavascriptAlerts();
        alertsPage.clickPromptButton();
        alertsPage.alert_setInput("ahmed");
        alertsPage.alert_clickToAccept();
        assertEquals(alertsPage.getResult(), "You entered: ahmed", "wrong message entered");
    }
}
