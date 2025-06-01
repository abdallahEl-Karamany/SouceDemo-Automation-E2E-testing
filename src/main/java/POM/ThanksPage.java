package POM;

import Actions.ElementActions;

public class ThanksPage {
    String thanksMessageSelector="complete-header";
    String menuButtonSelector="//div[@class='bm-burger-button']";
    String logoutButtonSelector="logout_sidebar_link";
    ElementActions act=null;
    public ThanksPage(){
        act=new ElementActions();
    }
    public String getThanksMessage(){
        return act.getElementText(ElementActions.Locator.className,thanksMessageSelector,5);
    }

    public void clickMenuButton(){
        act.clickOnElement(ElementActions.Locator.xPath, menuButtonSelector, 5);
    }
    public void clickLogoutButton(){
        act.clickOnElement(ElementActions.Locator.id, logoutButtonSelector, 10);
    }


}
