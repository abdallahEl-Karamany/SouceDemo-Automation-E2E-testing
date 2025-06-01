package POM;

import Actions.ElementActions;

public class InventoryPage {
    String productIconNameSelector="inventory_details_name";
    String backButtonSelector="inventory_details_back_button";
    String addToCartButtonSelector="btn_primary";
    String removeButtonSelector="btn_secondary";
    String productSelector="//div[@class='inventory_item_label']//div[text()='%s']/ancestor::div[@class='inventory_item']";
    String productIconSelector=productSelector+"//img";
    String productPageLabelSelector="product_label";
    ElementActions act= null;

    public InventoryPage(){
        act=new ElementActions();
    }

    public InventoryPage clickProductIcon(String productName){
        act.clickOnElement(ElementActions.Locator.xPath,String.format(productIconSelector,productName),5);
        return this;
    }
    public String getProductName(){
        return act.getElementText(ElementActions.Locator.className,productIconNameSelector,5);
    }
    public ProductsPage clickBackButton(){
        act.clickOnElement(ElementActions.Locator.className,backButtonSelector,ElementActions.Locator.className,productPageLabelSelector,5);
        return new ProductsPage();
    }
    public InventoryPage clickAddToCart(){
        act.clickOnElement(ElementActions.Locator.className,addToCartButtonSelector,5);
        return this;
    }
    public InventoryPage clickRemoveButton(){
        act.clickOnElement(ElementActions.Locator.className,removeButtonSelector,5);
        return this;
    }
    public String getButtonText(String buttonName){
        String x=null;
        if(buttonName.equals("ADD")){
            x=act.getElementText(ElementActions.Locator.className,addToCartButtonSelector,5);
        }
        else if(buttonName.equals("REMOVE")){
            x=act.getElementText(ElementActions.Locator.className, removeButtonSelector, 5);
        }
        return x;
    }
}
