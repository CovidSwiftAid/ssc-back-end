package com.shu.ssc.utils.exceptionUtils;

import com.shu.ssc.common.result.ResultCode;
import lombok.Data;

@Data
public class ExistedException extends Exception {
    protected Integer errorCode;

    protected String errorMsg;

    public ExistedException(ResultCode resultCode) {
        super(resultCode.getMessage());
        this.errorCode = resultCode.getCode();
        this.errorMsg = resultCode.getMessage();
    }

    public ExistedException(ResultCode resultCode, Throwable cause) {
        super(resultCode.getMessage(), cause);
        this.errorCode = resultCode.getCode();
        this.errorMsg = resultCode.getMessage();
    }
}
