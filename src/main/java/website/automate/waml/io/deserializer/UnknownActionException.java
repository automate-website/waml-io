package website.automate.waml.io.deserializer;

public class UnknownActionException extends RuntimeException {

    private static final long serialVersionUID = 902254215961310661L;

    public UnknownActionException(String msg){
        super(msg);
    }
}
