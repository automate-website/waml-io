package website.automate.waml.io.model.report;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@JsonPropertyOrder({"status", "message", "time", "total", "numActionPasses",
        "numActionFailures"})
public class WamlReport {

    private ExecutionStatus status = ExecutionStatus.SUCCESS;

    @JsonIgnore
    private String path;

    private String message;

    private Double time = 0.0;

    private Integer total = 0;

    private Integer pass = 0;

    private Integer fail = 0;

    private Map<String, Object> export;

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
        total++;
        if (actionStatus == ExecutionStatus.SUCCESS) {
            pass++;
        } else {
            fail++;
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

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getPass() {
        return pass;
    }

    public void setPass(Integer pass) {
        this.pass = pass;
    }

    public Integer getFail() {
        return fail;
    }

    public void setFail(Integer fail) {
        this.fail = fail;
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

    public Map<String, Object> getExport() {
        return export;
    }

    public void setExport(Map<String, Object> export) {
        this.export = export;
    }
}
