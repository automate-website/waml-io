package website.automate.waml.io;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLGenerator.Feature;
import website.automate.waml.io.deserializer.ActionDeserializer;
import website.automate.waml.io.deserializer.ActionReportDeserializer;
import website.automate.waml.io.mappers.ActionMapper;
import website.automate.waml.io.mappers.ScenarioMapper;
import website.automate.waml.io.model.main.action.Action;
import website.automate.waml.io.model.report.ActionReport;
import website.automate.waml.io.reader.WamlReader;
import website.automate.waml.io.serializer.WamlSerializerModifier;
import website.automate.waml.io.writer.WamlWriter;

public class WamlConfig {

    private static final String MODULE_NAME = "waml-io";

    private static final WamlConfig INSTANCE = new WamlConfig();

    private ObjectMapper mapper;

    private ActionMapper actionMapper;

    private ScenarioMapper scenarioMapper;

    private WamlReader wamlReader;

    private WamlWriter wamlWriter;

    public static WamlConfig getInstance() {
        return INSTANCE;
    }

    private WamlConfig() {
        mapper = createMapper();
        actionMapper = new ActionMapper(mapper);
        scenarioMapper = new ScenarioMapper(mapper);
        wamlWriter = new WamlWriter(mapper);
        wamlReader = new WamlReader(mapper);
    }

    private ObjectMapper createMapper() {
        SimpleModule module = new SimpleModule(MODULE_NAME, Version.unknownVersion());
        module.addDeserializer(Action.class, new ActionDeserializer());
        module.addDeserializer(ActionReport.class, new ActionReportDeserializer());
        module.setSerializerModifier(new WamlSerializerModifier());

        ObjectMapper mapper = new ObjectMapper(new YAMLFactory().enable(Feature.MINIMIZE_QUOTES));
        mapper.registerModule(module);
        mapper.setSerializationInclusion(Include.NON_NULL);
        return mapper;
    }

    public ObjectMapper getMapper() {
        return mapper;
    }

    public ActionMapper getActionMapper() {
        return actionMapper;
    }

    public ScenarioMapper getScenarioMapper() {
        return scenarioMapper;
    }

    public WamlReader getWamlReader() {
        return wamlReader;
    }

    public WamlWriter getWamlWriter() {
        return wamlWriter;
    }
}
