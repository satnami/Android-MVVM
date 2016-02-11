package satnami.com.mvvm.view.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import satnami.com.mvvm.R;
import satnami.com.mvvm.databinding.ItemGistBinding;
import satnami.com.mvvm.model.Gist;
import satnami.com.mvvm.viewModel.GistViewModel;

/**
 * Created by satnami on 12/2/2016.
 */
public class GistAdapter extends RecyclerView.Adapter<GistAdapter.BindingHolder> {

    private List<Gist> gists;
    private Context context;

    public GistAdapter(Context mContext) {
        context = mContext;
        gists = new ArrayList<>();
    }

    @Override
    public BindingHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemGistBinding itemPostBinding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.item_gist,
                parent,
                false);
        return new BindingHolder(itemPostBinding);

    }

    @Override
    public void onBindViewHolder(BindingHolder holder, int position) {
        ItemGistBinding itemGistBinding = holder.itemGistBinding;
        itemGistBinding.setViewModel(new GistViewModel(context, gists.get(position)));
    }

    @Override
    public int getItemCount() {
        return gists.size();
    }

    public void setItems(List<Gist> mGists) {
        gists = mGists;
        notifyDataSetChanged();
    }

    public void addItem(Gist gist) {
        if (!gists.contains(gist)) {
            gists.add(gist);
            notifyItemInserted(gists.size() - 1);
        } else {
            gists.set(gists.indexOf(gist), gist);
            notifyItemChanged(gists.indexOf(gist));
        }
    }

    public void addItems(List<Gist> mGists) {
        gists.addAll(mGists);
        notifyDataSetChanged();
    }

    public static class BindingHolder extends RecyclerView.ViewHolder {
        private ItemGistBinding itemGistBinding;

        public BindingHolder(ItemGistBinding mItemGistBinding) {
            super(mItemGistBinding.cardView);
            this.itemGistBinding = mItemGistBinding;
        }
    }
}
