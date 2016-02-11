package satnami.com.mvvm.data.remote;

import java.util.List;


import retrofit.http.GET;
import satnami.com.mvvm.model.Gist;

import rx.Observable;

/**
 * Created by satnami on 11/2/2016.
 */
public interface GitHubService {

    String END_POINT = "https://api.github.com/";

    String USERNAME = "satnami";

    String ACCESS_TOKEN = "";

    /**
     * @return list of Gists
     */
    @GET("users" + USERNAME + "/gists?access_token=" + ACCESS_TOKEN)
    Observable<List<Gist>> getGists();

}
