package lab5.prob1.rulesets;

import lab5.prob1.gui.CDWindow;

import java.awt.*;


/**
 * Rules:
 * 1. All fields must be nonempty
 * 2. Price must be a floating point number with two decimal places
 * 3. Price must be a number greater than 0.49.
 */

public class CDRuleSet implements RuleSet {

    private CDWindow cdWindow;

    @Override
    public void applyRules(Component component) throws RuleException {
        cdWindow = (CDWindow) component;
        validateNonEmpty();
        validatePrice();
    }

    private void validateNonEmpty() throws RuleException {
        if (cdWindow.getArtistValue().trim().isEmpty() || cdWindow.getPriceValue().trim().isEmpty() || cdWindow.getTitle().trim().isEmpty()) {
            throw new RuleException(" Artist, title and price are required");
        }
    }

    private void validatePrice() throws RuleException {
        String val = cdWindow.getPriceValue().trim();
        double doubleVal = 0.0;
        try {
            doubleVal = Double.parseDouble(val);
        } catch (NumberFormatException e) {
            throw new RuleException("Price must be a floating point number.");
        }
        int len = val.length();
        if (val.charAt(len - 3) != '.') {
            throw new RuleException("Price must be a floating point number with two decimal places.");
        }
        if (doubleVal <= 0.49) {
            throw new RuleException("Price must be a number greater than 0.49.");
        }
    }

}
