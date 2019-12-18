package com.kodilla.eprojectkfrontend.factory;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;

public class ButtonFactory {

    public final static String save = "Add";
    public final static String delete = "Delete";
    public final static String deleteAll = "Delete All";
    public final static String findBy = "Find By";

    public final Button buttonFactory(String button, String text) {
        switch (button) {
            case save:
                return save(text);
            case delete:
                return delete(text);
            case deleteAll:
                return deleteAll(text);
            case findBy:
                return findBy(text);
            default:
                return null;
        }
    }

    private Button save(String text) {
        Button save = new Button(text);
        save.addThemeVariants(ButtonVariant.LUMO_SUCCESS);
        save.getStyle().set("color", "green");
        return save;
    }

    private Button delete(String text) {
        Button delete = new Button(text);
        delete.addThemeVariants(ButtonVariant.LUMO_ERROR);
        delete.getStyle().set("color", "red");
        return delete;
    }

    private Button deleteAll(String text) {
        Button deleteAll = new Button(text);
        deleteAll.addThemeVariants(ButtonVariant.LUMO_ERROR);
        deleteAll.getStyle().set("color", "green");
        return deleteAll;
    }

    private Button findBy(String text) {
        Button findByBook = new Button(text);
        findByBook.addThemeVariants(ButtonVariant.LUMO_CONTRAST);
        findByBook.getStyle().set("color", "blue");
        return findByBook;
    }
}
