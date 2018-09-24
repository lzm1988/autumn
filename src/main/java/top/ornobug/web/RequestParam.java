package top.ornobug.web;

import top.ornobug.common.CastUtil;

import java.util.Map;

public class RequestParam {

    private Map<String, Object> paramMap;

    public RequestParam() {
    }

    public RequestParam(Map<String, Object> paramMap) {
        this.paramMap = paramMap;
    }

    public Map<String, Object> getParamMap() {
        return paramMap;
    }

    public Boolean getBoolean(String key) {
        return CastUtil.string2Boolean(String.valueOf(paramMap.get(key)));
    }

    public Integer getInteger(String key) {
        return CastUtil.string2Integer(String.valueOf(paramMap.get(key)));
    }

    public Long getLong(String key) {
        return CastUtil.string2Long(String.valueOf(paramMap.get(key)));
    }

    public Double getDouble(String key) {
        return CastUtil.string2Double(String.valueOf(paramMap.get(key)));
    }

    public String getString(String key) {
        return String.valueOf(paramMap.get(key));
    }

    public Object getObject(String key) {
        return paramMap.get(key);
    }

}
