package tcg.com.mvppattern.View;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import tcg.com.mvppattern.Network.ApiClient;
import tcg.com.mvppattern.Network.ErrorBody;
import tcg.com.mvppattern.Network.PostInterface;
import tcg.com.mvppattern.Network.PresenterResponse;
import tcg.com.mvppattern.Presenter.CommonPresenter;
import tcg.com.mvppattern.R;
import tcg.com.mvppattern.Util.ConnectionDetector;

public class SecondActivity extends AppCompatActivity implements PresenterResponse {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        callAPI();
    }

    private void callAPI() {

        if (new ConnectionDetector(this).isInternetOn()) {

            new CommonPresenter(SecondActivity.this, this, ApiClient.getClient(this).create(PostInterface.class))
                    .addSecondCall("abc", "def","t1", "t2", "t3");

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
