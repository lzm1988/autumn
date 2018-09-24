package top.ornobug.web;

public class Request {

    private String[] requestMethods;

    private String[] path;

    public Request() {
    }

    public Request(String[] requestMethods, String[] path) {
        this.requestMethods = requestMethods;
        this.path = path;
    }

    public String[] getRequestMethods() {
        return requestMethods;
    }

    public void setRequestMethods(String[] requestMethods) {
        this.requestMethods = requestMethods;
    }

    public String[] getPath() {
        return path;
    }

    public void setPath(String[] path) {
        this.path = path;
    }
}
