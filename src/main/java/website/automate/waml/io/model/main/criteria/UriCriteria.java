package website.automate.waml.io.model.main.criteria;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public class UriCriteria implements Criteria {

    private static final String DEFAULT_CRITERION_NAME = "url";

    private String url;

    private String body;

    @JsonProperty("body_format")
    private String bodyFormat;

    private String dest;

    private Map<String, String> headers;

    private String method;

    private String password;

    private String user;

    private String src;

    @JsonProperty("status_code")
    private String statusCode;

    public UriCriteria() {
        super();
    }

    public UriCriteria(String url) {
        this();
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getBodyFormat() {
        return bodyFormat;
    }

    public void setBodyFormat(String bodyFormat) {
        this.bodyFormat = bodyFormat;
    }

    public String getDest() {
        return dest;
    }

    public void setDest(String dest) {
        this.dest = dest;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    @Override
    public boolean canBeShortNotated() {
        return body == null
            && bodyFormat == null
            && dest == null
            && headers == null
            && method == null
            && password == null
            && user == null
            && src == null
            && statusCode == null;
    }

    @Override
    public String getDefaultCriterionName() {
        return DEFAULT_CRITERION_NAME;
    }

    @Override
    public String getDefaultCriterionValue() {
        return getUrl();
    }
}
