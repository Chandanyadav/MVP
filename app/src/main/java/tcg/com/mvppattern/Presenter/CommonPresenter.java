package tcg.com.mvppattern.Presenter;

import android.content.Context;

import java.util.HashMap;
import java.util.Map;

import tcg.com.mvppattern.Network.ApiNetworkResponse;
import tcg.com.mvppattern.Network.ErrorBody;
import tcg.com.mvppattern.Network.NetworkConstants;
import tcg.com.mvppattern.Network.NetworkHandler;
import tcg.com.mvppattern.Network.PostInterface;
import tcg.com.mvppattern.Network.PresenterResponse;

public class CommonPresenter implements ApiNetworkResponse {

    PresenterResponse presenterResponse;
    PostInterface apiService;
    NetworkHandler networkHandler;
    Context context;

    public CommonPresenter(Context context, PresenterResponse presenterResponse, PostInterface apiService) {
        this.context = context;
        this.presenterResponse = presenterResponse;
        this.apiService = apiService;
        networkHandler = new NetworkHandler(this);
    }

    public void addContactsCall(String firstName, String lastName, String requestType, String emailId, String userName) {

        Map<String, String> paramlist = new HashMap<>();
        paramlist.put("first_name", firstName);
        paramlist.put("last_name", lastName);
        paramlist.put("request_type", requestType);
        paramlist.put("email", emailId);
        paramlist.put("username", userName);



        Map<String, String> haderparam = new HashMap<>();
         //haderparam.put("content-type", "application/json");
        haderparam.put("signature", "");
        haderparam.put("publicKey", "");
        haderparam.put("access-token", "");

        apiService.addContactsAPI(haderparam, paramlist).enqueue(networkHandler.EnqueueRequest(NetworkConstants.Type.ADD_CONTACTS));
    }


    public void addSecondCall(String firstName, String lastName, String requestType, String emailId, String userName) {

        Map<String, String> paramlist = new HashMap<>();
        paramlist.put("first_name", firstName);
        paramlist.put("last_name", lastName);
        paramlist.put("request_type", requestType);
        paramlist.put("email", emailId);
        paramlist.put("username", userName);



        Map<String, String> haderparam = new HashMap<>();
        //haderparam.put("content-type", "application/json");
        haderparam.put("signature", "");
        haderparam.put("publicKey", "");
        haderparam.put("access-token", "");

        apiService.addSecondCallAPI(haderparam, paramlist).enqueue(networkHandler.EnqueueRequest(NetworkConstants.Type.SECOND_ACTIVITY));
    }
    @Override
    public void onResponse(Object responseBody, String responseType) {

        presenterResponse.getResult(responseBody, responseType);
    }

    @Override
    public void onResponseErrorBody(ErrorBody responseErrorBody, String responseType) {

        presenterResponse.getResultError(responseErrorBody, responseType);
    }

    @Override
    public void onFailure(Throwable message, String responseType) {
        presenterResponse.onFailure(message, responseType);
    }

}
