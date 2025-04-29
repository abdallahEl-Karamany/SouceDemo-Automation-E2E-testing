package POM;

import Actions.ElementActions;

public class CheckOutPage {
    String errorMessageSelector="h3";
    String firstNameFieldSelector="first-name";
    String lastNameFieldSelector="last-name";
    String zipCodeSelector="postal-code";
    String continueButtonSelector="input.btn_primary";
    String cancelButtonSelector="a.cart_cancel_link";
    ElementActions act=null;
    public CheckOutPage(){
        act=new ElementActions();
    }
    public CheckOutPage setFirstName(String firstName){

        act.sendString(firstName, ElementActions.Locator.id,firstNameFieldSelector,5);
        return this;
    }
    public CheckOutPage setLastName(String lastName){

        act.sendString(lastName, ElementActions.Locator.id,lastNameFieldSelector,5);
        return this;
    }
    public CheckOutPage setZipCode(String postalCode){

        act.sendString(postalCode, ElementActions.Locator.id,zipCodeSelector,5);
        return this;
    }
    public CartPage clickCancelButton(){
        act.clickOnElement(ElementActions.Locator.cssSelector,cancelButtonSelector,5);
        return new CartPage();
    }
    public String getErrorMessage(){
        return act.getElementText(ElementActions.Locator.tagName,errorMessageSelector,5);
    }
    public OverviewPage clickContinueButton(){
        act.clickOnElement(ElementActions.Locator.cssSelector,continueButtonSelector,5);
        return new OverviewPage();
    }


}
