package POM;

import Actions.ElementActions;

public class ThanksPage {
    String thanksMessageSelector="complete-header";
    ElementActions act=null;
    public ThanksPage(){
        act=new ElementActions();
    }
    public String getThanksMessage(){
        return act.getElementText(ElementActions.Locator.className,thanksMessageSelector,5);
    }

}
