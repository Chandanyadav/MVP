package tcg.com.mvppattern.Network;

import com.google.gson.JsonObject;

import java.util.Map;

import io.reactivex.Single;
import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;

public interface PostInterface {

    @FormUrlEncoded
    @POST("Contacts/add_contact")
    Call<JsonObject> addContactsAPI(@HeaderMap Map<String, String> headers, @FieldMap Map<String, String> param);

}