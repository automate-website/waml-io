package website.automate.waml.io.deserializer;

import website.automate.waml.io.WamlDeserializationException;

public class UnknownCriterionException extends WamlDeserializationException {

	private static final long serialVersionUID = -7676165691657650400L;

	public UnknownCriterionException(String msg, Throwable cause){
        super(msg, cause);
    }
}
