package satnami.com.mvvm.view.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.subscriptions.CompositeSubscription;
import satnami.com.mvvm.MvvmApplication;
import satnami.com.mvvm.R;
import satnami.com.mvvm.data.DataManager;
import satnami.com.mvvm.data.remote.GitHubService;
import satnami.com.mvvm.model.Gist;
import satnami.com.mvvm.utils.NetworkUtils;
import satnami.com.mvvm.view.adapter.GistAdapter;
import timber.log.Timber;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link GistsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GistsFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    @Bind(R.id.recycler_gists)
    RecyclerView listGists;

    private DataManager dataManager;
    private GistAdapter gistAdapter;
    private CompositeSubscription compositeSubscription;
    private List<Gist> gists;


    public GistsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment GistsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static GistsFragment newInstance(String param1, String param2) {
        GistsFragment fragment = new GistsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        compositeSubscription = new CompositeSubscription();
        gists = new ArrayList<>();
        dataManager = MvvmApplication.get(getActivity()).getComponent().dataManager();
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        gistAdapter = new GistAdapter(getActivity());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View fragmentView = inflater.inflate(R.layout.fragment_gists, container, false);
        ButterKnife.bind(this, fragmentView);
        setupRecyclerView();
        loadStoriesIfNetworkConnected();
        return fragmentView;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        compositeSubscription.unsubscribe();
    }

    private void setupRecyclerView() {
        listGists.setLayoutManager(new LinearLayoutManager(getActivity()));
        listGists.setHasFixedSize(true);
        gistAdapter.setItems(gists);
        listGists.setAdapter(gistAdapter);
    }

    private void loadStoriesIfNetworkConnected() {
        if (NetworkUtils.isNetworkAvailable(getActivity())) {
            if (GitHubService.ACCESS_TOKEN.isEmpty() || GitHubService.USERNAME.isEmpty())
                getTopGists();
            else getUserGists();
        }
    }

    private void getTopGists() {
        compositeSubscription.add(dataManager.getTopGists()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(dataManager.getScheduler())
                .subscribe(new Subscriber<List<Gist>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Timber.e("There was a problem loading the user stories " + e);
                        Toast.makeText(getActivity(), "error", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onNext(List<Gist> gists) {
                        Log.e("latest", "" + gists.size());
                        gistAdapter.addItems(gists);
                    }
                }));
    }

    private void getUserGists() {
        compositeSubscription.add(dataManager.getUserGists()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(dataManager.getScheduler())
                .subscribe(new Subscriber<List<Gist>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Timber.e("There was a problem loading the user stories " + e);
                        Toast.makeText(getActivity(), "error", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onNext(List<Gist> gists) {
                        Log.e("user", "" + gists.size());
                        gistAdapter.addItems(gists);
                    }
                }));
    }
}