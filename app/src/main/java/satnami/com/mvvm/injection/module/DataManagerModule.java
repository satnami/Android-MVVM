package satnami.com.mvvm.injection.module;

import dagger.Module;
import dagger.Provides;
import rx.Scheduler;
import rx.schedulers.Schedulers;
import satnami.com.mvvm.data.remote.GitHubService;
import satnami.com.mvvm.data.remote.RetrofitHelper;
import satnami.com.mvvm.injection.scope.PerDataManager;

/**
 * Created by satnami on 12/2/2016.
 */
@Module
public class DataManagerModule {

    public DataManagerModule() {

    }

    @Provides
    @PerDataManager
    GitHubService provideGitHubService() {
        return new RetrofitHelper().newGitHubService();
    }

    @Provides
    @PerDataManager
    Scheduler provideScheduler() {
        return Schedulers.io();
    }

}
