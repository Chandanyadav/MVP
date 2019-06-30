package tcg.com.mvppattern.View;

import android.provider.SyncStateContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import tcg.com.mvppattern.Network.ApiClient;
import tcg.com.mvppattern.Network.ErrorBody;
import tcg.com.mvppattern.Network.NetworkConstants;
import tcg.com.mvppattern.Network.PostInterface;
import tcg.com.mvppattern.Network.PresenterResponse;
import tcg.com.mvppattern.Presenter.CommonPresenter;
import tcg.com.mvppattern.R;
import tcg.com.mvppattern.Util.ConnectionDetector;

public class MainActivity extends AppCompatActivity implements PresenterResponse {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Display Back button
        this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        addContactToServer();
    }

    //Finish current class(Activity or Fragment) after clciking on back button
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return true;
    }




    /*
     * Call API for registered Contact
     * Add Contact to Server
     * */
    private void addContactToServer() {


        if (new ConnectionDetector(this).isInternetOn()) {

            new CommonPresenter(MainActivity.this, this, ApiClient.getClient(this).create(PostInterface.class))
                    .addContactsCall("abc", "def","t1", "t2", "t3");

        } else {

        }
    }









    @Override
    public void getResult(Object response, String responseType) {
        {

            JsonObject jsonObject = (JsonObject) response;
            Log.d("HandleOrEmail", response + "");
            if (responseType.equals(NetworkConstants.Type.ADD_CONTACTS)) { // Add Contact

                if (jsonObject.get("status").getAsString().equals("-1")) {

                    //CustomToast.showToastMessage(this, jsonObject.get("message").toString());



                } else {


                    // CustomToast.showToastMessage(this, jsonObject.get("message").toString());
                }

            }  else if (responseType.equals(NetworkConstants.Type.HANDLE_OR_EMAIL)) { //Get Handle when email is entered and verify.....
                // Get Email e=when handle is enterd and verify..
               /* if (jsonObject.get("status").getAsString().equals("-1")) {
                    if (jsonObject.get("message").getAsString().equals("User is registered with us")) {
                        Gson gson = new GsonBuilder().create();
                        AddContactModelHandleEmail mApiResponse = gson.fromJson((JsonObject) response, AddContactModelHandleEmail.class);
                        mEdEditEmail.setText(mApiResponse.getResponse().getEmail() + "");
                        mEdEditHandel.setText(mApiResponse.getResponse().getUsername() + "");
                    } else {
                        if (chkHandleEmail.equalsIgnoreCase("email"))
                            mInputLayoutEmail.setError("User not found ");
                        if (chkHandleEmail.equalsIgnoreCase("handle"))
                            mInputLayoutHandel.setError("User Not found ");
                    }

                } else {
                    if (chkHandleEmail.equalsIgnoreCase("email"))
                        mInputLayoutEmail.setError(jsonObject.get("message").getAsString());

                    if (chkHandleEmail.equalsIgnoreCase("handle"))
                        mInputLayoutHandel.setError(jsonObject.get("message").getAsString());

                }*/
            }

        }
    }

    @Override
    public void getResultError(ErrorBody response, String responseType) {

    }

    @Override
    public void onFailure(Throwable message, String responseType) {

    }
}
