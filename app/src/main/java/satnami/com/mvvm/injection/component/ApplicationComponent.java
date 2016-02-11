package satnami.com.mvvm.injection.component;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Component;
import satnami.com.mvvm.view.activity.MainActivity;
import satnami.com.mvvm.data.DataManager;
import satnami.com.mvvm.injection.module.ApplicationModule;

/**
 * Created by satnami on 12/2/2016.
 */
@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(MainActivity mainActivity);

    Application application();

    DataManager dataManager();
}
