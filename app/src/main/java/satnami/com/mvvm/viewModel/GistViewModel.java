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
        context = mContext;
        gist = mGist;
    }

    public String GetGistId() {
        return gist.getId();
    }

    public String getPostAuthor(){
        return gist.getUser().toString();
    }

    public View.OnClickListener OnClickName() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Lunch this", Toast.LENGTH_SHORT).show();
            }
        };
    }

}
