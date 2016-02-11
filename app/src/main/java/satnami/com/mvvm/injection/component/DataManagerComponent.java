package satnami.com.mvvm.injection.component;

import dagger.Component;
import satnami.com.mvvm.data.DataManager;
import satnami.com.mvvm.injection.module.DataManagerModule;
import satnami.com.mvvm.injection.scope.PerDataManager;

/**
 * Created by satnami on 12/2/2016.
 */
@PerDataManager
@Component(dependencies = ApplicationComponent.class, modules = DataManagerModule.class)
public interface DataManagerComponent {

    void inject(DataManager dataManager);
}
