package website.automate.waml.io.model.action;

import website.automate.waml.io.model.CriterionValue;

public class EnsureAction extends FilterAction {

    private CriterionValue absent;
    
    public CriterionValue getAbsent() {
        return absent;
    }

    public void setAbsent(Object absent) {
        this.absent = new CriterionValue(absent);
    }
}
