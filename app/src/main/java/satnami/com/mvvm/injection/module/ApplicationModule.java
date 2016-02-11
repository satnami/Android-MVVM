package satnami.com.mvvm.injection.module;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import satnami.com.mvvm.data.DataManager;

/**
 * Created by satnami on 12/2/2016.
 */
@Module
public class ApplicationModule {
    protected final Application application;

    public ApplicationModule(Application mApplication) {
        application = mApplication;
    }

    @Provides
    @Singleton
    Application provideApplication() {
        return application;
    }

    @Provides
    @Singleton
    DataManager provideDataManager() {
        return new DataManager(application);
    }
}
