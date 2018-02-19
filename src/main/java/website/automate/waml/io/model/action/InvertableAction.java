package website.automate.waml.io.model.action;

public abstract class InvertableAction extends BasicAction {

    private String invert;

    @Override
    public String getInvert() {
        return invert;
    }

    public void setInvert(String invert) {
        this.invert = invert;
    }
}
