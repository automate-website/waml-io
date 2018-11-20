package website.automate.waml.io.deserializer;

import static java.text.MessageFormat.format;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;
import com.fasterxml.jackson.databind.node.ObjectNode;
import website.automate.waml.io.model.main.action.Action;

public class ActionDeserializer extends StdDeserializer<Action> {

    private static final long serialVersionUID = 8037140456765531389L;

    public ActionDeserializer() {
        super(Action.class);
    }

    @Override
    public Action deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
            throws IOException, JsonProcessingException {
        ObjectMapper mapper = (ObjectMapper) jsonParser.getCodec();
        ObjectNode root = (ObjectNode) mapper.readTree(jsonParser);

        List<String> fieldNames = new ArrayList<>();
        root.fieldNames().forEachRemaining(fieldNames::add);
        Class<? extends Action> actionClazz = Action.findClazzByNames(fieldNames);

        try {
            return mapper.convertValue(root, actionClazz);
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
}
