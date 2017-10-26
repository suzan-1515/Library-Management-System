/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nepal.lms.validation.book;

import com.nepal.lms.custom.Alert;
import com.nepal.lms.util.Logy;
import java.awt.Component;

/**
 *
 * @author Suzn
 */
public class BookValidation {

    private final Component component;

    public BookValidation(Component component) {
        this.component = component;
    }

    public boolean isStockFormValid(String title, String edition, String isbn, String quantity) {
        Logy.d("Validating book stock insert form");
        if (title.isEmpty()) {
            Logy.d("Book title not valid");
            Alert.showError(component, "Title field cannot be empty.");
            return false;
        }

        if (edition.isEmpty()) {
            Logy.d("Edition not valid");
            Alert.showError(component, "Edition field cannot be empty.");
            return false;
        }
        if (isbn.isEmpty()) {
            Logy.d("ISBN not valid");
            Alert.showError(component, "ISBN field cannot be empty.");
            return false;
        }
        if (quantity.isEmpty()) {
            Logy.d("Quantity not valid");
            Alert.showError(component, "Quantity field cannot be empty.");
            return false;
        }

        Logy.d("Book stock insert form is validated");

        return true;
    }

    public boolean isSubjectFormValid(String title) {
        Logy.d("Validating book subject insert form");
        if (title.isEmpty()) {
            Logy.d("subject title not valid");
            Alert.showError(component, "Title field cannot be empty.");
            return false;
        }

        Logy.d("Book subject insert form is validated");

        return true;
    }

}
