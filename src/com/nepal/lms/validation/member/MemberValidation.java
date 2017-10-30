/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nepal.lms.validation.member;

import com.nepal.lms.custom.Alert;
import com.nepal.lms.util.Logy;
import com.nepal.lms.validation.BaseValidation;
import java.awt.Component;
import java.util.Calendar;

/**
 *
 * @author Suzn
 */
public class MemberValidation extends BaseValidation {

    public MemberValidation(Component component) {
        super(component);
    }

    public boolean isMemberFormValid(String name, String address, String contact, Calendar expiryDate) {
        Logy.d("Validating member insert form");
        if (isStringEmptyOrNull(name)) {
            Logy.d("Member name not valid");
            Alert.showError(component, "Name field cannot be empty.");
            return false;
        }

        if (isStringEmptyOrNull(address)) {
            Logy.d("Member address not valid");
            Alert.showError(component, "Address field cannot be empty.");
            return false;
        }
        if (isStringEmptyOrNull(contact)) {
            Logy.d("Member contact not valid");
            Alert.showError(component, "Contact field cannot be empty.");
            return false;
        } else if (isContactValid(contact)) {
            Logy.d("Member contact not valid");
            Alert.showError(component, "Contact number must be of 9 or 10 digits");
            return false;
        }

        if (isDateEmptyOrNull(expiryDate)) {
            Logy.d("Member expiry date not valid");
            Alert.showError(component, "Expiry date field cannot be empty.");
            return false;
        } else if (isExpiryDateValid(expiryDate)) {
            Logy.d("Member expiry date not valid");
            Alert.showError(component, "Expiry date must be after current date.");
            return false;
        }

        return true;
    }

}
