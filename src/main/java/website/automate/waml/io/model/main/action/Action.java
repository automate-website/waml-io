package website.automate.waml.io.model.main.action;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({
    "alert", "click", "debug", "define", "ensure", "enter", "execute", "filter",
    "include", "move", "open", "select", "uri", "wait", "when", "unless",
    "timeout", "failed_when", "register", "with_items"
})
public abstract class Action {

    private String register;

    private String timeout;

    @JsonProperty("failed_when")
    private String failedWhen;

    @JsonProperty("with_items")
    private Object withItems;

    public String getRegister() {
        return register;
    }

    public String getTimeout() {
        return timeout;
    }

    public String getFailedWhen() {
        return failedWhen;
    }

    public void setRegister(String register) {
        this.register = register;
    }

    public void setTimeout(String timeout) {
        this.timeout = timeout;
    }

    public void setFailedWhen(String failedWhen) {
        this.failedWhen = failedWhen;
    }

    @JsonIgnore
    public abstract String getName();

    public Object getWithItems() {
        return withItems;
    }

    public void setWithItems(Object withItems) {
        this.withItems = withItems;
    }
}
