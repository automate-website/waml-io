package website.automate.waml.io.model.report;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.Collection;
import java.util.List;

@JsonPropertyOrder({"status", "message", "time", "pass", "fail", "path",
        "criteria"})
public class ScenarioReport {

    private String message;

    private String path;

    private ExecutionStatus status = ExecutionStatus.SUCCESS;

    private Double time = 0.0;

    private List<ActionReport> steps;

    public void updateStats(Collection<ActionReport> steps) {
        for (ActionReport step : steps) {
            ExecutionStatus actionStatus = step.getStatus();
            status = ExecutionStatus.worstOf(status, actionStatus);
            time += step.getTime();
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

    public List<ActionReport> getSteps() {
        return steps;
    }

    public void setSteps(List<ActionReport> steps) {
        this.steps = steps;
    }
}
