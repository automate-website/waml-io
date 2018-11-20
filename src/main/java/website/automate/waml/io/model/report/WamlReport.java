package website.automate.waml.io.model.report;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"status", "message", "time", "numScenarioTotal", "numActionPasses",
        "numActionFailures"})
public class WamlReport {

    private ExecutionStatus status = ExecutionStatus.SUCCESS;

    @JsonIgnore
    private String path;

    private String message;

    private Double time = 0.0;

    private Integer numScenarioTotal = 0;

    private Integer numScenarioPasses = 0;

    private Integer numScenarioFailures = 0;

    private List<ScenarioReport> scenarios = new ArrayList<>();

    public void updateStats() {
        for (ScenarioReport scenario : scenarios) {
            scenario.updateStats(scenario.getSteps());
            ExecutionStatus scenarioStatus = scenario.getStatus();
            status = ExecutionStatus.worstOf(status, scenarioStatus);
            setNumAction(scenarioStatus);
            time += scenario.getTime();
        }
    }

    private void setNumAction(ExecutionStatus actionStatus) {
        numScenarioTotal++;
        if (actionStatus == ExecutionStatus.SUCCESS) {
            numScenarioPasses++;
        } else {
            numScenarioFailures++;
        }
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

    public Integer getNumScenarioTotal() {
        return numScenarioTotal;
    }

    public void setNumScenarioTotal(Integer numScenarioTotal) {
        this.numScenarioTotal = numScenarioTotal;
    }

    public Integer getNumScenarioPasses() {
        return numScenarioPasses;
    }

    public void setNumScenarioPasses(Integer numScenarioPasses) {
        this.numScenarioPasses = numScenarioPasses;
    }

    public Integer getNumScenarioFailures() {
        return numScenarioFailures;
    }

    public void setNumScenarioFailures(Integer numScenarioFailures) {
        this.numScenarioFailures = numScenarioFailures;
    }

    public List<ScenarioReport> getScenarios() {
        return scenarios;
    }

    public void setScenarios(List<ScenarioReport> scenarios) {
        this.scenarios = scenarios;
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
}
