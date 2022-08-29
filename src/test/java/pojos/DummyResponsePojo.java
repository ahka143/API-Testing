package pojos;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DummyResponsePojo {

    private String status;
    private DummyDataPojo dummyDataPojo;
    private String message;

    /**
     * No args constructor for use in serialization
     *
     */
    public DummyResponsePojo() {
    }

    /**
     *
     * @param dummyDataPojo
     * @param message
     * @param status
     */
    public DummyResponsePojo(String status, DummyDataPojo dummyDataPojo, String message) {
        super();
        this.status = status;
        this.dummyDataPojo = dummyDataPojo;
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public DummyDataPojo getData() {
        return dummyDataPojo;
    }

    public void setData(DummyDataPojo dummyDataPojo) {
        this.dummyDataPojo = dummyDataPojo;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "DummyResponsePojo{" +
                "status='" + status + '\'' +
                ", dummyDataPojo=" + dummyDataPojo +
                ", message='" + message + '\'' +
                '}';
    }
}
