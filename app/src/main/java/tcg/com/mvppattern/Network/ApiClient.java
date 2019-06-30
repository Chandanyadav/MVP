package tcg.com.mvppattern.Network;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;
import okhttp3.CertificatePinner;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import tcg.com.mvppattern.Util.Constants;

/**
 * Created by Ram on 8/02/18.
 */

public class ApiClient {

    private static Retrofit retrofit = null;

    public static Retrofit getClient(Context context) {

        if (retrofit == null) {

            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

            // String hostname = "otcapi.indt.io";
            // String hostname = "b3RjYXBpLmluZHQuaW8=";
            // Log.e("LOG", "Encrypted Host URL===>  " + SharedPrefs.encrypt("otcapi.indt.io"));

            String hostname = "YXBpLmJpdGJveC5jeA==";
            CertificatePinner certificatePinner = new CertificatePinner.Builder()
                    /*.add(SharedPrefs.decrypt(hostname), "sha256/JwgzlWQzR4zrlUG7k/Op88NwYu9A6ihoddQoK0ySTnc=")
                    .add(SharedPrefs.decrypt(hostname), "sha256/3kcNJzkUJ1RqMXJzFX4Zxux5WfETK+uL6Viq9lJNn4o=")
                    .add(SharedPrefs.decrypt(hostname), "sha256/Y9mvm0exBk1JoQ57f9Vm28jKo5lFm/woKcVxrYxu80o=")*/
                    .build();

            OkHttpClient client = new OkHttpClient.Builder()
                    .certificatePinner(certificatePinner)
                    .addInterceptor(interceptor)
                    .connectTimeout(100, TimeUnit.SECONDS)
                    .readTimeout(100, TimeUnit.SECONDS).build();

            Gson gson = new GsonBuilder()
                    .setLenient()
                    .create();

            retrofit = new Retrofit.Builder()
                    .client(client)
                    .baseUrl(Constants.BASE_URL)
/*
                    .baseUrl("http://192.168.2.137/otcapi/")
*/
/*
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
*/
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
        }

        return retrofit;
    }

}
