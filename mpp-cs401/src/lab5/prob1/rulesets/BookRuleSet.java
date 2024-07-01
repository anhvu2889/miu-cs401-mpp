package lab5.prob1.rulesets;

import lab5.prob1.gui.BookWindow;

import java.awt.*;


/**
 * Rules:
 * 1. All fields must be nonempty
 * 2. Isbn must be numeric and consist of either 10 or 13 characters
 * 3. If Isbn has length 10, the first digit must be 0 or 1
 * 4. If Isbn has length 13, the first 3 digits must be either 978 or 979
 * 5. Price must be a floating point number with two decimal places
 * 6. Price must be a number greater than 0.49.
 */
public class BookRuleSet implements RuleSet {

    private BookWindow bookWindow;

    @Override
    public void applyRules(Component component) throws RuleException {
        bookWindow = (BookWindow) component;
        validateNonEmpty();
        validateISBN();
        validatePrice();
    }

    private void validateNonEmpty() throws RuleException {
        if (bookWindow.getIsbnValue().trim().isEmpty() ||
                bookWindow.getTitleValue().trim().isEmpty() ||
                bookWindow.getPriceValue().trim().isEmpty()) {
            throw new RuleException("Non-empty ISBN and Title are required.");
        }
    }

    private void validateISBN() throws RuleException {
        String val = bookWindow.getIsbnValue().trim();
        for (char c : val.toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new RuleException("ISBN contains non-digit characters.");
            }
        }
        int len = val.length();
        if (len != 10 && len != 13)
            throw new RuleException("Isbn must be numeric and consist of either 10 or 13 characters");
        if (len == 10 && !(val.charAt(0) == '0' || val.charAt(0) == '1')) {
            throw new RuleException("If Isbn has length 10, the first digit must be 0 or 1");
        }
        if (len == 13 && !(val.startsWith("978") || val.startsWith("979"))) {
            throw new RuleException("If Isbn has length 13, the first 3 digits must be either 978 or 979");
        }
    }

    private void validatePrice() throws RuleException {
        String val = bookWindow.getPriceValue().trim();
        double doubleVal = 0.00;
        try {
            doubleVal = Double.parseDouble(val);
        } catch (NumberFormatException e) {
            throw new RuleException("Price must be a floating point number with two decimal places");
        }
        int len = val.length();  //  "xxx.yy"
        if (len < 3 || val.charAt(len - 3) != '.') {
            throw new RuleException("Price must be a floating point number with two decimal places");
        }
        if (doubleVal <= 0.49) {
            throw new RuleException("Price must be a number greater than 0.49.");
        }
    }

}
