package website.automate.waml.io.model.report;

import java.util.Collection;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import website.automate.waml.io.model.main.Scenario;
import website.automate.waml.io.model.main.action.Action;

@JsonPropertyOrder({"status", "message", "time", "numActionPasses", "numActionFailures", "path",
        "criteria"})
public class ScenarioReport {

    private String message;

    private String path;

    private ExecutionStatus status = ExecutionStatus.SUCCESS;

    private Double time = 0.0;

    private Integer numActionPasses = 0;

    private Integer numActionFailures = 0;

    private List<ActionReport> steps;

    public void updateStats(Collection<ActionReport> steps) {
        for (ActionReport step : steps) {
            ExecutionStatus actionStatus = step.getStatus();
            status = ExecutionStatus.worstOf(status, actionStatus);
            setNumAction(actionStatus);
            time += step.getTime();
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

    public List<ActionReport> getSteps() {
        return steps;
    }

    public void setSteps(List<ActionReport> steps) {
        this.steps = steps;
    }
}
