package website.automate.waml.io.report;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import website.automate.waml.io.model.Scenario;

@JsonPropertyOrder({"status", "message", "time", "numScenarioTotal", "numActionPasses", "numActionFailures"})
public class WamlReport {

    private ExecutionStatus status = ExecutionStatus.SUCCESS;
    
    private String message;
    
    private Double time = 0.0;
    
    private Integer numScenarioTotal = 0;
    
    private Integer numScenarioPasses = 0;
    
    private Integer numScenarioFailures = 0;
    
    private List<Scenario> scenarios = new ArrayList<>();
    
    public void updateStats(){
        for(Scenario scenario : scenarios){
            scenario.getReport().updateStats(scenario.getSteps());
            ExecutionStatus scenarioStatus = scenario.getReport().getStatus();
            status = ExecutionStatus.worstOf(status, scenarioStatus);
            setNumAction(scenarioStatus);
            time += scenario.getReport().getTime();
        }
    }
    
    private void setNumAction(ExecutionStatus actionStatus){
        numScenarioTotal++;
        if(actionStatus == ExecutionStatus.SUCCESS){
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

    public List<Scenario> getScenarios() {
        return scenarios;
    }

    public void setScenarios(List<Scenario> scenarios) {
        this.scenarios = scenarios;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
