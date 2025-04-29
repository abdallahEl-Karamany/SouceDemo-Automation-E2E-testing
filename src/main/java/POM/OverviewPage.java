package POM;

import Actions.ElementActions;

import java.util.ArrayList;
import java.util.List;

public class OverviewPage {

    String itemPricesSelector="inventory_item_price";
    String totalPriceSelector="summary_subtotal_label";
    String cancelButtonSelector="cart_cancel_link ";
    String finishButtonSelector="btn_action";
    String thanksMessageSelector="complete-header";
    ElementActions act=null;
    public OverviewPage(){
        act=new ElementActions();
    }
    public float getItemPrices(){
        List<String> pricelist=new ArrayList<>();
        float sum=0;
        pricelist=act.getAllElementText(ElementActions.Locator.className,itemPricesSelector);
        for(String i:pricelist){

           sum=sum+Float.parseFloat(i.replace("$","").trim());
        }
        return sum;
    }
    public float getTotalPrice(){
        return Float.parseFloat(act.getElementText(ElementActions.Locator.className,totalPriceSelector,5)
                .replace("Item total: $","").trim());

    }
    public ProductsPage clickCancelButton(){
        act.clickOnElement(ElementActions.Locator.className,cancelButtonSelector,5);
        return new ProductsPage();
    }
    public ThanksPage clickFinishButton(){
        act.clickOnElement(ElementActions.Locator.className,finishButtonSelector, ElementActions.Locator.className,thanksMessageSelector,5);
        return new ThanksPage();
    }

}
