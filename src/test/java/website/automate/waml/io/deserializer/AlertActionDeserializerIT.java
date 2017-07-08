package website.automate.waml.io.deserializer;

import org.junit.Test;
import website.automate.waml.io.model.action.Action;
import website.automate.waml.io.model.action.AlertAction;

import java.io.IOException;
import java.io.InputStream;

import static java.lang.ClassLoader.getSystemResourceAsStream;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class AlertActionDeserializerIT extends DeserializerBase {

    @Test
    public void alertActionIsDeserialized() throws IOException{
        InputStream alertAction = getSystemResourceAsStream(getBasePath() + "/alert-action.yaml");
        Action action = mapper.readValue(alertAction, Action.class);

        assertNotNull(action);
        assertTrue(action instanceof AlertAction);
        AlertAction actualClickAction = AlertAction.class.cast(action);
        assertThat(actualClickAction.getConfirm(), is("yes"));
        assertThat(actualClickAction.getText(), is("foo"));
        assertThat(actualClickAction.getInput(), is("bar"));
        assertThat(actualClickAction.getWhen(), is("${isDesktop}"));
        assertThat(actualClickAction.getUnless(), is("${isMobile}"));
        assertThat(actualClickAction.getTimeout(), is("100"));
    }

    @Test
    public void alertActionShortNotationIsDeserialized() throws IOException{
        InputStream clickAction = getSystemResourceAsStream(getBasePath() + "/alert-action-short-notation.yaml");
        Action action = mapper.readValue(clickAction, Action.class);

        assertNotNull(action);
        assertTrue(action instanceof AlertAction);
        AlertAction actualClickAction = AlertAction.class.cast(action);
        assertThat(actualClickAction.getConfirm(), is("true"));
    }
}
