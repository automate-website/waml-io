package website.automate.waml.io.deserializer;

public class TooManyActionsException extends RuntimeException {

    private static final long serialVersionUID = 902254215961310661L;

    public TooManyActionsException(String msg){
        super(msg);
    }
}
