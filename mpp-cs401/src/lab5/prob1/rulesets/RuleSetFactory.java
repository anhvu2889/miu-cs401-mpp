package lab5.prob1.rulesets;

import java.awt.*;
import java.util.HashMap;


final public class RuleSetFactory {
    private RuleSetFactory() {
    }

    static HashMap<Class<? extends Component>, RuleSet> map = new HashMap<>();

}
