package website.automate.waml.io.report;

import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import website.automate.waml.io.model.action.Action;

@JsonPropertyOrder({"status", "message", "time", "numActionPasses", "numActionFailures", "path", "criteria"})
public class ScenarioReport {

    private String message;

    private String path;

    private ExecutionStatus status = ExecutionStatus.SUCCESS;

    private Double time = 0.0;

    private Integer numActionPasses = 0;

    private Integer numActionFailures = 0;

    public void updateStats(Collection<Action> actions) {
        for (Action action : actions) {
            ExecutionStatus actionStatus = action.getReport().getStatus();
            status = ExecutionStatus.worstOf(status, actionStatus);
            setNumAction(actionStatus);
            time += action.getReport().getTime();
        }
    }

    private void setNumAction(ExecutionStatus actionStatus) {
        if (actionStatus == ExecutionStatus.SUCCESS) {
            this.numActionPasses++;
        } else {
            this.numActionFailures++;
        }
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public ExecutionStatus getStatus() {
        return status;
    }

    public void setStatus(ExecutionStatus status) {
        this.status = status;
    }

    public Double getTime() {
        return time;
    }

    public void setTime(Double time) {
        this.time = time;
    }

    public Integer getNumActionPasses() {
        return numActionPasses;
    }

    public void setNumActionPasses(Integer numActionPasses) {
        this.numActionPasses = numActionPasses;
    }

    public Integer getNumActionFailures() {
        return numActionFailures;
    }

    public void setNumActionFailures(Integer numActionFailures) {
        this.numActionFailures = numActionFailures;
    }
}
