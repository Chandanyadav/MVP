package tcg.com.mvppattern.Network;


/**
 * Created by Ram on 29/11/18.
 */

public interface ApiNetworkResponse<T> {

    void onResponse(Object responseBody, String responseType);

    void onResponseErrorBody(ErrorBody responseErrorBody, String responseType);

    void onFailure(Throwable message, String responseType);
}
