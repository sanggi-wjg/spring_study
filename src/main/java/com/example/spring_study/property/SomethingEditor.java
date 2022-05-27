package com.example.spring_study.property;


import java.beans.PropertyEditorSupport;

public class SomethingEditor extends PropertyEditorSupport {

    @Override
    public String getAsText() {
        Something something = (Something) getValue();
        return something.getId().toString();
    }


    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        setValue(new Something(Integer.parseInt(text)));
    }
}
