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
        AlertAction actualAlertAction = AlertAction.class.cast(action);
        assertThat(actualAlertAction.getConfirm(), is("yes"));
        assertThat(actualAlertAction.getText(), is("foo"));
        assertThat(actualAlertAction.getInput(), is("bar"));
        assertThat(actualAlertAction.getWhen(), is("${isDesktop}"));
        assertThat(actualAlertAction.getUnless(), is("${isMobile}"));
        assertThat(actualAlertAction.getTimeout(), is("100"));
    }

    @Test
    public void alertActionShortNotationIsDeserialized() throws IOException{
        InputStream clickAction = getSystemResourceAsStream(getBasePath() + "/alert-action-short-notation.yaml");
        Action action = mapper.readValue(clickAction, Action.class);

        assertNotNull(action);
        assertTrue(action instanceof AlertAction);
        AlertAction actualAlertAction = AlertAction.class.cast(action);
        assertThat(actualAlertAction.getConfirm(), is("true"));
    }
}
