package tcg.com.mvppattern.Network;

/**
 * Created by Ram on 29/11/18.
 */

public interface PresenterResponse<T> {

    void getResult(T response, String responseType);

    void getResultError(ErrorBody response, String responseType);

    void onFailure(Throwable message, String responseType);
}
