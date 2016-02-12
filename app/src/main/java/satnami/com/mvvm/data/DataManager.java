package satnami.com.mvvm.data;

import android.content.Context;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import rx.Scheduler;
import rx.functions.Func1;
import satnami.com.mvvm.MvvmApplication;
import satnami.com.mvvm.data.remote.GitHubService;
import satnami.com.mvvm.injection.component.DaggerDataManagerComponent;
import satnami.com.mvvm.injection.module.DataManagerModule;
import satnami.com.mvvm.model.Gist;

/**
 * Created by satnami on 12/2/2016.
 */
public class DataManager {
    @Inject
    protected GitHubService gitHubService;
    @Inject
    protected Scheduler scheduler;

    public DataManager(Context context) {
        injectDependencies(context);
    }

    public DataManager(GitHubService mGitHubService, Scheduler mScheduler) {
        gitHubService = mGitHubService;
        scheduler = mScheduler;
    }

    protected void injectDependencies(Context context) {
        DaggerDataManagerComponent.builder()
                .applicationComponent(MvvmApplication.get(context).getComponent())
                .dataManagerModule(new DataManagerModule())
                .build()
                .inject(this);
    }

    public Scheduler getScheduler() {
        return scheduler;
    }

    public Observable<List<Gist>> getUserGists() {
        return gitHubService.getUserGists()
                .concatMap(new Func1<List<Gist>, Observable<? extends List<Gist>>>() {
                    @Override
                    public Observable<? extends List<Gist>> call(List<Gist> gists) {
                        return Observable.just(gists);
                    }
                });
    }

    public Observable<List<Gist>> getTopGists() {
        return gitHubService.getTopGists()
                .concatMap(new Func1<List<Gist>, Observable<? extends List<Gist>>>() {
                    @Override
                    public Observable<? extends List<Gist>> call(List<Gist> gists) {
                        return Observable.just(gists);
                    }
                });
    }
}
