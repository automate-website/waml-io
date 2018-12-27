package website.automate.waml.io.model.report;

import java.util.List;

import static java.util.Arrays.asList;

public enum ExecutionStatus {
    SUCCESS, FAILURE, ERROR;

    private static List<ExecutionStatus> STATUS_SEVERITY_ORDER = asList(SUCCESS, FAILURE, ERROR);

    public static ExecutionStatus worstOf(ExecutionStatus left, ExecutionStatus right) {
        int leftIndex = STATUS_SEVERITY_ORDER.indexOf(left);
        int rightIndex = STATUS_SEVERITY_ORDER.indexOf(right);

        int index = Math.max(leftIndex, rightIndex);
        return STATUS_SEVERITY_ORDER.get(index);
    }
}
