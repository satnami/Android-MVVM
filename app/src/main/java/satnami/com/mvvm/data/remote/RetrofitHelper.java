package satnami.com.mvvm.data.remote;

import retrofit.RestAdapter;
import retrofit.converter.JacksonConverter;

/**
 * Created by satnami on 11/2/2016.
 */
public class RetrofitHelper {

    public GitHubService newGitHubService() {
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(GitHubService.END_POINT)
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setConverter(new JacksonConverter())
                .build();

        return restAdapter.create(GitHubService.class);
    }
}
