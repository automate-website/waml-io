package website.automate.waml.io.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;
import com.fasterxml.jackson.databind.node.ObjectNode;
import website.automate.waml.io.model.main.action.Action;
import website.automate.waml.io.model.main.action.ActionRegistry;
import website.automate.waml.io.model.report.ActionReport;
import website.automate.waml.io.model.report.ExecutionStatus;
import website.automate.waml.io.model.report.LogEntry;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.text.MessageFormat.format;
import static java.util.Arrays.asList;

public class ActionReportDeserializer extends StdDeserializer<ActionReport> {

    private static final long serialVersionUID = 8037140456765531389L;

    public ActionReportDeserializer() {
        super(ActionReport.class);
    }

    @Override
    public ActionReport deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
            throws IOException {
        ObjectMapper mapper = (ObjectMapper) jsonParser.getCodec();
        ObjectNode root = mapper.readTree(jsonParser);

        try {
            return fromObjectNode(root, mapper);
        } catch (IllegalArgumentException e) {
            Throwable cause = e.getCause();
            if (cause instanceof UnrecognizedPropertyException) {
                UnrecognizedPropertyException unknownCriterionException =
                        (UnrecognizedPropertyException) cause;
                throw new UnknownCriterionException(format("Unknown criterion {0} for step {1}.",
                        unknownCriterionException.getPropertyName(),
                        unknownCriterionException.getKnownPropertyIds()), e);
            }
            throw e;
        }
    }

    private ActionReport fromObjectNode(ObjectNode objectNode, ObjectMapper mapper){
        ActionReport actionReport = new ActionReport();

        JsonNode timeNode = objectNode.remove("time");
        if(timeNode != null){
            actionReport.setTime(timeNode.asDouble());
        }

        JsonNode statusNode = objectNode.remove("status");
        if(statusNode != null){
            actionReport.setStatus(ExecutionStatus.valueOf(statusNode.asText()));
        }

        JsonNode message = objectNode.remove("message");
        if(message != null){
            actionReport.setMessage(message.asText());
        }

        JsonNode log = objectNode.remove("log");
        if(log != null){
            actionReport.setLogEntries(mapper.convertValue(log, new TypeReference<List<LogEntry>>(){}));
        }

        Action action = mapper.convertValue(objectNode, Action.class);
        actionReport.setStep(action);

        return actionReport;
    }
}
