package satnami.com.mvvm;

import android.app.Application;
import android.content.Context;

import satnami.com.mvvm.injection.component.ApplicationComponent;
import satnami.com.mvvm.injection.component.DaggerApplicationComponent;
import satnami.com.mvvm.injection.module.ApplicationModule;
import timber.log.Timber;

/**
 * Created by satnami on 12/2/2016.
 */
public class MvvmApplication extends Application {

    ApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        if (BuildConfig.DEBUG) Timber.plant(new Timber.DebugTree());
        mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public static MvvmApplication get(Context context) {
        return (MvvmApplication) context.getApplicationContext();
    }

    public ApplicationComponent getComponent() {
        return mApplicationComponent;
    }

    // Needed to replace the component with a test specific one
    public void setComponent(ApplicationComponent applicationComponent) {
        mApplicationComponent = applicationComponent;
    }
}
