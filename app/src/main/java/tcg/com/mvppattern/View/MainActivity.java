package tcg.com.mvppattern.View;

import android.provider.SyncStateContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import tcg.com.mvppattern.Network.ApiClient;
import tcg.com.mvppattern.Network.ErrorBody;
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

    }

    @Override
    public void getResultError(ErrorBody response, String responseType) {

    }

    @Override
    public void onFailure(Throwable message, String responseType) {

    }
}
