package POM;

import Actions.ElementActions;

public class LoginPage {


    String usernameSelector="user-name";
    String passwordSelector="password";
    String loginButtonSelector="login-button";
    String errorMessageSelector="h3";
    ElementActions act;
    public LoginPage(){
        act=new ElementActions();
    }

    public LoginPage homeNavigation(String url){
        act.PageNavigation(url);
        return this;

    }
    public LoginPage setUserName(String username){
        act.sendString(username, ElementActions.Locator.id,usernameSelector,5);
        return this;
    }
    public LoginPage setPassword(String password){
        act.sendString(password, ElementActions.Locator.id,passwordSelector,5);
        return this;
    }

    public ProductsPage clickLoginButton(){
        act.clickOnElement(ElementActions.Locator.id,loginButtonSelector,5);
        return new ProductsPage();
    }
    public String getErrorMessage(){
        return act.getElementText(ElementActions.Locator.tagName,errorMessageSelector,5);
    }
}
