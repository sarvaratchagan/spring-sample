package com.hsbc.demo.model;

import org.springframework.http.HttpStatus;

import java.util.Objects;

public class ResponseInfo<T> {
    private HttpStatus status;
    private T data;

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResponseInfo{" +
                "status='" + status + '\'' +
                ", data=" + data +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ResponseInfo)) return false;
        ResponseInfo<?> that = (ResponseInfo<?>) o;
        return getStatus().equals(that.getStatus()) &&
                getData().equals(that.getData());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStatus(), getData());
    }
}
