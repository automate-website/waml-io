package website.automate.waml.io.model.action;

import website.automate.waml.io.model.CriterionValue;

public interface Action {
    boolean canBeShortNotated();
    CriterionValue getDefaultCriterionValue();
}