package tcg.com.mvppattern.Network;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Ram on 29/11/18.
 */

public class ErrorBody {

    @SerializedName("success")
    private boolean status;

    @SerializedName("message")
    private String message;

    @SerializedName("errCode")
    private int errorCode;

    public boolean getResult() {
        return status;
    }

    public int getErrorcode() {
        return errorCode;
    }


    public String getMessage() {
        return message;
    }


}
