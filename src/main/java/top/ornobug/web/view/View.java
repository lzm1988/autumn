package top.ornobug.web.view;

import java.util.Map;

public class View {

    public String path;

    public Map<String, Object> model;

    public View() {
    }

    public View(String path, Map<String, Object> model) {
        this.path = path;
        this.model = model;
    }

    public String getPath() {
        return path;
    }

    public Map<String, Object> getModel() {
        return model;
    }

    public View addModel(String key, Object value) {
        model.put(key, value);
        return this;
    }

    public View addModel(Map<String, Object> modelData) {
        model.putAll(modelData);
        return this;
    }
}
