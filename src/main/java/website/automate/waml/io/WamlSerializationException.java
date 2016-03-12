package website.automate.waml.io;

public class WamlSerializationException extends RuntimeException {

    private static final long serialVersionUID = 3262269456525705952L;

    public WamlSerializationException(String msg, Throwable e){
        super(msg, e);
    }
}
