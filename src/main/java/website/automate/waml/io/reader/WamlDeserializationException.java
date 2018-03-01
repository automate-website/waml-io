package website.automate.waml.io.reader;

public class WamlDeserializationException extends RuntimeException {

    private static final long serialVersionUID = 3262269456525705952L;

    public WamlDeserializationException(String msg, Throwable e) {
        super(msg, e);
    }

    public WamlDeserializationException(String msg) {
        super(msg);
    }
}
