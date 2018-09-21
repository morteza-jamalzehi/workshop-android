package backbase.com.workshopandroid;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.backbase.android.Backbase;
import com.backbase.android.core.utils.BBLogger;
import com.backbase.android.listeners.ModelListener;
import com.backbase.android.model.Model;
import com.backbase.android.model.ModelSource;
import com.backbase.android.model.Renderable;

import java.util.Map;

import static backbase.com.workshopandroid.WorkshopApplication.TAG_EXPERIENCE_ID;

public class SplashActivity extends AppCompatActivity {

    private static final String TAG = SplashActivity.class.getSimpleName();
    private static final long FAKE_LOADING_DURATION = 1000;
    Backbase backbase = Backbase.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        backbase.getModel(new OnModelReadyListener(), ModelSource.LOCAL);
    }


    private class OnModelReadyListener implements ModelListener<Model> {
        @Override
        public void onModelReady(final Model model) {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                    intent.putExtra(TAG_EXPERIENCE_ID, model.getExperience().getId());
                    startActivity(intent);
                    finish();
                }
            }, FAKE_LOADING_DURATION);
        }

        @Override
        public void onError(String error) {
            //TODO optional
            BBLogger.error(TAG, "Model loaded with error: " + error);
        }
    }
}
