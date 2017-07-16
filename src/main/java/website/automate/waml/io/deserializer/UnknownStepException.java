package website.automate.waml.io.deserializer;

import website.automate.waml.io.WamlDeserializationException;

public class UnknownStepException extends WamlDeserializationException {

    private static final long serialVersionUID = 902254215961310661L;

    public UnknownStepException(String msg){
        super(msg);
    }
}
