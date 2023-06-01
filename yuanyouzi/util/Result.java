package yuanyouzi.util;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class Result {
    private int code;
    private String msg;
    private String result;

    private String result1;

    private String result2;

    public void setSuccess(String msg, String result) {
        this.code = 200;
        this.msg = "success-" + msg;
        this.result = result;
    }

    public void setInfo(String msg, String result) {
        this.code = 400;
        this.msg = "warning-" + msg;
        this.result = result;
    }

    public void setSuccess1(String msg, String result,String result1,String result2) {
        this.code = 200;
        this.msg = "success-" + msg;
        this.result = result;
        this.result1 = result1;
        this.result2 = result2;
    }

    public void setSuccess2(String msg, String result,String result1) {
        this.code = 200;
        this.msg = "success-" + msg;
        this.result = result;
        this.result1 = result1;
    }

    public void setSuccess3(String msg, String result) {
        this.code = 200;
        this.msg = "success-" + msg;
        this.result = result;
    }
}