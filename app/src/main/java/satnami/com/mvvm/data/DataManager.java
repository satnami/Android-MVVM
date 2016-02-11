package satnami.com.mvvm.data;

import android.content.Context;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import rx.Scheduler;
import rx.functions.Func1;
import satnami.com.mvvm.data.remote.GitHubService;
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

    }

    public DataManager(GitHubService mGitHubService, Scheduler mScheduler) {
        gitHubService = mGitHubService;
        scheduler = mScheduler;
    }

    protected void injectDependencies(Context context) {
    }

    public Scheduler getScheduler() {
        return scheduler;
    }

    public Observable<List<Gist>> getGists() {
        return gitHubService.getGists()
                .concatMap(new Func1<List<Gist>, Observable<? extends List<Gist>>>() {
                    @Override
                    public Observable<? extends List<Gist>> call(List<Gist> gists) {
                        return Observable.just(gists);
                    }
                });
    }
}
