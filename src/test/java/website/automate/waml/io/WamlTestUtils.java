package website.automate.waml.io;

import java.io.File;
import java.io.FileInputStream;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import com.fasterxml.jackson.databind.ObjectMapper;

public class WamlTestUtils {

    private static final ObjectMapper WAML_MAPPER = WamlConfig.getInstance().getMapper();

    public static ObjectMapper getObjectMapper() {
        return WAML_MAPPER;
    }

    public static String readFile(File file) throws Exception {
        return IOUtils.toString(new FileInputStream(file), StandardCharsets.UTF_8);
    }

    public static Collection<File> getSamples(String baseClassPath) {
        return FileUtils.listFiles(getScenariosDir(baseClassPath), new String[] {"yaml", "yml"},
                false);
    }

    private static File getScenariosDir(String baseClassPath) {
        return new File(getAbsoluteScenariosPath(baseClassPath));
    }

    private static String getAbsoluteScenariosPath(String baseClassPath) {
        return WamlTestUtils.class.getClassLoader().getResource(baseClassPath).getPath();
    }
}
