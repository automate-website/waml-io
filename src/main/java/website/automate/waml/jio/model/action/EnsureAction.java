package website.automate.waml.jio.model.action;

import website.automate.waml.jio.model.CriterionValue;

public class EnsureAction extends FilterAction {

    private CriterionValue absent;
    
    public CriterionValue getAbsent() {
        return absent;
    }

    public void setAbsent(Object absent) {
        this.absent = new CriterionValue(absent);
    }
}
