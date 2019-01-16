package website.automate.waml.io.model.main.action;

import website.automate.waml.io.model.main.criteria.ExportCriteria;

public class ExportAction extends ConditionalAction {

    static final String TYPE_NAME = "export";

    private ExportCriteria export;

    public ExportCriteria getExport() {
        return export;
    }

    public void setExport(ExportCriteria export) {
        this.export = export;
    }

    @Override
    public String getName() {
        return TYPE_NAME;
    }
}
