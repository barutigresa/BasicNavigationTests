package com.cbt.tests;

import org.openqa.selenium.WebElement;

public class CheckboxInfoHelper {

    int id;
    String name;
    WebElement checkbox;

    public CheckboxInfoHelper(int id, String name, WebElement checkbox) {
        this.id = id;
        this.name = name;
        this.checkbox = checkbox;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public WebElement getCheckbox() {
        return checkbox;
    }

    public void setCheckbox(WebElement checkbox) {
        this.checkbox = checkbox;
    }
}
