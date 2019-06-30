package tcg.com.mvppattern.Network;

import android.support.annotation.NonNull;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NetworkHandler<T> {

    private static final String TAG = NetworkHandler.class.getSimpleName();
    private ApiNetworkResponse apiNetworkResponse;

    public NetworkHandler(ApiNetworkResponse iNetworkResultListener) {
        this.apiNetworkResponse = iNetworkResultListener;
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public Callback EnqueueRequest(final String type) {

        return new Callback<T>() {
            @Override
            public void onResponse(@NonNull Call<T> call, @NonNull Response<T> response) {

                if (response.isSuccessful()) {
                    apiNetworkResponse.onResponse(response.body(), type);
                } else if (!response.errorBody().equals(null)) {
                    try {
                        Gson gson = new GsonBuilder().create();
                        ErrorBody mApiError = gson.fromJson(response.errorBody().string(), ErrorBody.class);
                        apiNetworkResponse.onResponseErrorBody(mApiError, type);

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(@NonNull Call<T> call, @NonNull Throwable t) {
                apiNetworkResponse.onFailure(t, type);
            }
        };
    }
}
