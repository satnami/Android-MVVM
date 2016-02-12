package satnami.com.mvvm.viewModel;

import android.content.Context;
import android.databinding.BaseObservable;
import android.view.View;
import android.widget.Toast;

import satnami.com.mvvm.model.Gist;

/**
 * Created by satnami on 12/2/2016.
 */
public class GistViewModel extends BaseObservable {

    private Context context;
    private Gist gist;

    public GistViewModel(Context mContext, Gist mGist) {
        this.context = mContext;
        this.gist = mGist;
        getGistUrl();
        getGistDescription();
    }

    public String getGistUrl() {
        if (this.gist.getUrl() != null && !this.gist.getUrl().isEmpty()) {
            return this.gist.getUrl();
        }
        return "no url";
    }

    public String getGistDescription() {
        if (this.gist.getDescription() != null && !this.gist.getDescription().isEmpty()) {
            return this.gist.getDescription();
        }
        return "no description";
    }

    public View.OnClickListener OnClickItem() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = "no Id";
                if (gist.getId() != null && !gist.getId().isEmpty()) {
                    id = gist.getId();
                }
                Toast.makeText(context, "Gist Id: " + id, Toast.LENGTH_SHORT).show();
            }
        };
    }

}
