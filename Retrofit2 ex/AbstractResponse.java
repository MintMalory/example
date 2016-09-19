package com.ua.sng.fourthdimension.retrofit2;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Sopilko on 11.07.2016.
 */
public abstract class AbstractResponse<T> {

    @SerializedName("base_url")
    private String baseURL;

    @SerializedName("success")
    private boolean success;

    // used for error handling
    @SerializedName("error")
    private String errorMessage;

    @SerializedName("code")
    private Integer errorCode;

    @SerializedName("meta")
    public Meta meta;

    // used for normal operation
    @SerializedName("objects")
    protected T data;

    public String getBaseURL() {
        return baseURL;
    }

    public void setBaseURL(String baseURL) {
        this.baseURL = baseURL;
    }

    public boolean isSuccess() {
        return success;
    }

    public T getData() {
        return data;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public AbstractResponse(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "AbstractResponse{" +
                "success=" + success +
                ", errorMessage='" + errorMessage + '\'' +
                ", errorCode=" + errorCode +
                ", data=" + data +
                '}';
    }
}