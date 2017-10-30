/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nepal.lms.validation.book;

import com.nepal.lms.validation.BaseValidation;
import com.nepal.lms.custom.Alert;
import com.nepal.lms.entity.book.BookInfo;
import com.nepal.lms.util.Logy;
import com.nepal.lms.util.Utils;
import java.awt.Component;
import java.util.Calendar;

/**
 *
 * @author Suzn
 */
public class BookValidation extends BaseValidation {

    public BookValidation(Component component) {
        super(component);
    }

    public boolean isStockFormValid(String title, String edition, String isbn, String quantity) {
        Logy.d("Validating book stock insert form");
        if (isStringEmptyOrNull(title)) {
            Logy.d("Book title not valid");
            Alert.showError(component, "Title field cannot be empty.");
            return false;
        }

        if (isStringEmptyOrNull(edition)) {
            Logy.d("Edition not valid");
            Alert.showError(component, "Edition field cannot be empty.");
            return false;
        } else if (edition.trim().length() < 4 || edition.trim().length() > 4) {
            Logy.d("Edition not valid");
            Alert.showError(component, "Edition must be of 4 digit");
            return false;
        }
        if (isStringEmptyOrNull(isbn)) {
            Logy.d("ISBN not valid");
            Alert.showError(component, "ISBN field cannot be empty.");
            return false;
        }

        if (isStringEmptyOrNull(quantity)) {
            Logy.d("Quantity not valid");
            Alert.showError(component, "Quantity field cannot be empty.");
            return false;
        } else if (quantity.trim().matches("0")) {
            Logy.d("Quantity not valid");
            Alert.showError(component, "Quantity must be greater than 0.");
            return false;
        }

        Logy.d("Book stock insert form is validated");

        return true;
    }

    public boolean isSubjectFormValid(String title) {
        Logy.d("Validating book subject insert form");
        if (isStringEmptyOrNull(title)) {
            Logy.d("subject title not valid");
            Alert.showError(component, "Title field cannot be empty.");
            return false;
        }

        Logy.d("Book subject insert form is validated");

        return true;
    }

    public boolean isAuthorFormValid(String title, String contact) {
        Logy.d("Validating book author insert form");
        if (isStringEmptyOrNull(title)) {
            Logy.d("author title not valid");
            Alert.showError(component, "Title field cannot be empty.");
            return false;
        }

        if (isStringEmptyOrNull(contact)) {
            Logy.d("author contact not valid");
            Alert.showError(component, "Contact field cannot be empty.");
            return false;
        } else if (isContactValid(contact)) {
            Logy.d("author contact not valid");
            Alert.showError(component, "Contact number must be of 9 or 10 digits");
            return false;
        }

        Logy.d("Book author insert form is validated");

        return true;
    }

    public boolean isPublisherFormValid(String title, String contact) {
        Logy.d("Validating book publisher insert form");
        if (isStringEmptyOrNull(title)) {
            Logy.d("publisher title not valid");
            Alert.showError(component, "Title field cannot be empty.");
            return false;
        }

        if (isStringEmptyOrNull(contact)) {
            Logy.d("publisher contact not valid");
            Alert.showError(component, "Contact field cannot be empty.");
            return false;
        } else if (isContactValid(contact)) {
            Logy.d("publisher contact not valid");
            Alert.showError(component, "Contact number must be of 9 or 10 digits");
            return false;
        }

        Logy.d("Book publisher insert form is validated");

        return true;
    }

    public boolean isShelfFormValid(String title) {
        Logy.d("Validating book shelf insert form");
        if (isStringEmptyOrNull(title)) {
            Logy.d("shelf title not valid");
            Alert.showError(component, "Title field cannot be empty.");
            return false;
        }

        Logy.d("Book shelf insert form is validated");

        return true;
    }

    public boolean isBorrowFormValid(String book, String member, Calendar expiryDate) {
        Logy.d("Validating borrow insert form");
        if (isStringEmptyOrNull(book)) {
            Logy.d("Borrow book not valid");
            Alert.showError(component, "Book Id field cannot be empty.");
            return false;
        }

        if (isStringEmptyOrNull(member)) {
            Logy.d("Borrow member not valid");
            Alert.showError(component, "Member Id field cannot be empty.");
            return false;
        }

        if (isDateEmptyOrNull(expiryDate)) {
            Logy.d("Borrow expirydate not valid");
            Alert.showError(component, "Expiry date field cannot be empty.");
            return false;
        } else if (isExpiryDateValid(expiryDate)) {
            Logy.d("Borrow expiry date not valid");
            Alert.showError(component, "Expiry date must be after current date.");
            return false;
        }

        Logy.d("Borrow insert form is validated");

        return true;
    }

    public boolean isReturnFormValid(String book, String member) {
        Logy.d("Validating return insert form");
        if (isStringEmptyOrNull(book)) {
            Logy.d("Return book not valid");
            Alert.showError(component, "Book Id field cannot be empty.");
            return false;
        }

        if (isStringEmptyOrNull(member)) {
            Logy.d("Return member not valid");
            Alert.showError(component, "Member Id field cannot be empty.");
            return false;
        }

        return true;
    }

    public boolean isBookAvailable(int availableCopies) {
        return availableCopies > 0;
    }

    public boolean isMemberValid(long expiryDate) {
        return !isExpiryDateValid(Utils.millisToCalendar(expiryDate));
    }


}
