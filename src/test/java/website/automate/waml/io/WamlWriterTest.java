package website.automate.waml.io;

import static org.mockito.Mockito.doThrow;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import website.automate.waml.io.model.Scenario;

import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(MockitoJUnitRunner.class)
public class WamlWriterTest {

    @Mock
    private ObjectMapper mapper;
    
    @Mock
    private OutputStream outputStream;
    
    @Mock
    private List<Scenario> scenarios;
    
    @InjectMocks
    private WamlWriter writer;
    
    @Test(expected=RuntimeException.class)
    public void exceptionIsPropagatedUnchecked() throws IOException {
        doThrow(IOException.class).when(mapper).writeValue(outputStream, scenarios);
        
        writer.write(outputStream, scenarios);
    }
}
