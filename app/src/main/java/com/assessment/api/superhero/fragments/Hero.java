package com.assessment.api.superhero.fragments;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.assessment.api.R;
import com.assessment.api.superhero.activities.HeroProfile;
import com.assessment.api.superhero.pojo.HeroImage;
import com.assessment.api.superhero.retrofit.Api;
import com.bumptech.glide.Glide;
import com.google.android.material.snackbar.Snackbar;
import java.util.List;
import java.util.Objects;
import net.steamcrafted.loadtoast.LoadToast;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class Hero extends Fragment {

    @BindViews({R.id.character_one, R.id.character_two, R.id.character_three, R.id.character_four,
            R.id.character_five})
    List<TextView> listTextView;
    @BindViews({R.id.image_one, R.id.image_two, R.id.image_three, R.id.image_four, R.id.image_five})
    List<ImageView> imageViewList;
    @BindView(R.id.constraint)
    ConstraintLayout coordinatorLayout;

    View view;
    Snackbar snackbar;
    LoadToast loadToast;

    public Hero() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_heros, container, false);
        ButterKnife.bind(this, view);
        showLoading();
        getBatman();
        getWolverine();
        getSuperman();
        getIronMan();
        gethulk();

        return view;
    }

    private void showLoading() {
        loadToast = new LoadToast(getContext())
                .setProgressColor(Color.RED)
                .setText("Loading...")
                .setTranslationY(100)
                .setBackgroundColor(getResources().getColor(R.color.colorAccent))
                .setTextColor(getResources().getColor(R.color.white))
                .setProgressColor(getResources().getColor(R.color.white))
                .setBorderColor(getResources().getColor(R.color.colorAccent));
        loadToast.show();
    }

    public void getBatman() {
        Api.getClient().fetchCharacterImages(69, new Callback<HeroImage>() {
            @Override
            public void success(HeroImage heroImage, Response response) {
                loadToast.hide();
                Log.d("successful_response", heroImage.getResponse());
                if (heroImage.getResponse().equalsIgnoreCase("success")) {
                    String name = heroImage.getName();
                    String image_url = heroImage.getUrl();

                    Glide.with(Objects.requireNonNull(getContext())).load(image_url)
                            .into(imageViewList.get(0));
                    listTextView.get(0).setText(name);
//                    hideLoading();
                } else {
                    loadToast.hide();
                    Log.d("unSuccessful_response", heroImage.getResponse() + heroImage.getError());
                    snackbar = Snackbar
                            .make(coordinatorLayout, heroImage.getResponse() + heroImage.getError(),
                                    Snackbar.LENGTH_LONG);
                    snackbar.setBackgroundTint(
                            ContextCompat.getColor(getActivity(), R.color.unsuccessful));
                    snackbar.setDuration(5000);
                    setSnackBarPosition();
                }
            }

            @Override
            public void failure(RetrofitError error) {
                loadToast.hide();
                snackbar = Snackbar
                        .make(coordinatorLayout, Objects.requireNonNull(error.getMessage()),
                                Snackbar.LENGTH_LONG);
                snackbar.setBackgroundTint(
                        ContextCompat.getColor(getActivity(), R.color.warning));
                snackbar.setDuration(5000);
                setSnackBarPosition();
                Log.e("error", error.toString());
            }
        });

    }


    private void getWolverine() {
        Api.getClient().fetchCharacterImages(717, new Callback<HeroImage>() {
            @Override
            public void success(HeroImage heroImage, Response response) {
                loadToast.hide();
                Log.d("successful_response", heroImage.getResponse());
                if (heroImage.getResponse().equalsIgnoreCase("success")) {
                    String name = heroImage.getName();
                    String image_url = heroImage.getUrl();

                    Glide.with(Objects.requireNonNull(getContext())).load(image_url)
                            .into(imageViewList.get(1));
                    listTextView.get(1).setText(name);
//                    hideLoading();
                } else {
                    loadToast.hide();
                    Log.d("unSuccessful_response", heroImage.getResponse() + heroImage.getError());
                    snackbar = Snackbar
                            .make(coordinatorLayout, heroImage.getResponse() + heroImage.getError(),
                                    Snackbar.LENGTH_LONG);
                    snackbar.setBackgroundTint(
                            ContextCompat.getColor(getActivity(), R.color.unsuccessful));
                    snackbar.setDuration(5000);
                    setSnackBarPosition();
                }
            }

            @Override
            public void failure(RetrofitError error) {
                loadToast.hide();
                snackbar = Snackbar
                        .make(coordinatorLayout, Objects.requireNonNull(error.getMessage()),
                                Snackbar.LENGTH_LONG);
                snackbar.setBackgroundTint(
                        ContextCompat.getColor(getActivity(), R.color.warning));
                snackbar.setDuration(5000);
                setSnackBarPosition();
                Log.e("error", error.toString());
            }
        });
    }

    private void getSuperman() {
        Api.getClient().fetchCharacterImages(644, new Callback<HeroImage>() {
            @Override
            public void success(HeroImage heroImage, Response response) {
                loadToast.hide();
                Log.d("successful_response", heroImage.getResponse());
                if (heroImage.getResponse().equalsIgnoreCase("success")) {
                    String name = heroImage.getName();
                    String image_url = heroImage.getUrl();

                    Glide.with(Objects.requireNonNull(getContext())).load(image_url)
                            .into(imageViewList.get(2));
                    listTextView.get(2).setText(name);
//                    hideLoading();
                } else {
                    loadToast.hide();
                    Log.d("unSuccessful_response", heroImage.getResponse() + heroImage.getError());
                    snackbar = Snackbar
                            .make(coordinatorLayout, heroImage.getResponse() + heroImage.getError(),
                                    Snackbar.LENGTH_LONG);
                    snackbar.setBackgroundTint(
                            ContextCompat.getColor(getActivity(), R.color.unsuccessful));
                    snackbar.setDuration(5000);
                    setSnackBarPosition();
                }
            }

            @Override
            public void failure(RetrofitError error) {
                loadToast.hide();
                snackbar = Snackbar
                        .make(coordinatorLayout, Objects.requireNonNull(error.getMessage()),
                                Snackbar.LENGTH_LONG);
                snackbar.setBackgroundTint(
                        ContextCompat.getColor(getActivity(), R.color.warning));
                snackbar.setDuration(5000);
                setSnackBarPosition();
                Log.e("error", error.toString());
            }
        });
    }

    private void getIronMan() {
        Api.getClient().fetchCharacterImages(346, new Callback<HeroImage>() {
            @Override
            public void success(HeroImage heroImage, Response response) {
                loadToast.hide();
                Log.d("successful_response", heroImage.getResponse());
                if (heroImage.getResponse().equalsIgnoreCase("success")) {
                    String name = heroImage.getName();
                    String image_url = heroImage.getUrl();

                    Glide.with(Objects.requireNonNull(getContext())).load(image_url)
                            .into(imageViewList.get(3));
                    listTextView.get(3).setText(name);
//                    hideLoading();
                } else {
                    loadToast.hide();
                    Log.d("unSuccessful_response", heroImage.getResponse() + heroImage.getError());
                    snackbar = Snackbar
                            .make(coordinatorLayout, heroImage.getResponse() + heroImage.getError(),
                                    Snackbar.LENGTH_LONG);
                    snackbar.setBackgroundTint(
                            ContextCompat.getColor(getActivity(), R.color.unsuccessful));
                    snackbar.setDuration(5000);
                    setSnackBarPosition();
                }
            }

            @Override
            public void failure(RetrofitError error) {
                loadToast.hide();
                snackbar = Snackbar
                        .make(coordinatorLayout, Objects.requireNonNull(error.getMessage()),
                                Snackbar.LENGTH_LONG);
                snackbar.setBackgroundTint(
                        ContextCompat.getColor(getActivity(), R.color.warning));
                snackbar.setDuration(5000);
                setSnackBarPosition();
                Log.e("error", error.toString());
            }
        });
    }


    private void gethulk() {
        Api.getClient().fetchCharacterImages(332, new Callback<HeroImage>() {
            @Override
            public void success(HeroImage heroImage, Response response) {
                loadToast.hide();
                Log.d("successful_response", heroImage.getResponse());
                if (heroImage.getResponse().equalsIgnoreCase("success")) {
                    String name = heroImage.getName();
                    String image_url = heroImage.getUrl();

                    Glide.with(Objects.requireNonNull(getContext())).load(image_url)
                            .into(imageViewList.get(4));
                    listTextView.get(4).setText(name);
//                    hideLoading();
                } else {
                    loadToast.hide();
                    Log.d("unSuccessful_response", heroImage.getResponse() + heroImage.getError());
                    snackbar = Snackbar
                            .make(coordinatorLayout, heroImage.getResponse() + heroImage.getError(),
                                    Snackbar.LENGTH_LONG);
                    snackbar.setBackgroundTint(
                            ContextCompat.getColor(getActivity(), R.color.unsuccessful));
                    snackbar.setDuration(5000);
                    setSnackBarPosition();
                }
            }

            @Override
            public void failure(RetrofitError error) {
                loadToast.hide();
                snackbar = Snackbar
                        .make(coordinatorLayout, Objects.requireNonNull(error.getMessage()),
                                Snackbar.LENGTH_LONG);
                snackbar.setBackgroundTint(
                        ContextCompat.getColor(getActivity(), R.color.warning));
                snackbar.setDuration(5000);
                setSnackBarPosition();
                Log.e("error", error.toString());
            }
        });
    }


    @OnClick({R.id.batman, R.id.wolverine, R.id.superman, R.id.iron_man, R.id.hulk})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.batman:
                Intent batman = new Intent(getActivity(), HeroProfile.class);
                batman.putExtra("id", 69);
                startActivity(batman);
                break;
            case R.id.wolverine:
                Intent wolverine = new Intent(getActivity(), HeroProfile.class);
                wolverine.putExtra("id", 717);
                startActivity(wolverine);
                break;
            case R.id.superman:
                Intent superman = new Intent(getActivity(), HeroProfile.class);
                superman.putExtra("id", 644);
                startActivity(superman);
                break;
            case R.id.iron_man:
                Intent iron_man = new Intent(getActivity(), HeroProfile.class);
                iron_man.putExtra("id", 346);
                startActivity(iron_man);
                break;
            case R.id.hulk:
                Intent hulk = new Intent(getActivity(), HeroProfile.class);
                hulk.putExtra("id", 332);
                startActivity(hulk);
                break;
        }
    }

    private void setSnackBarPosition() {
        View snackbarLayout = snackbar.getView();
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        lp.setMargins(0, 100, 0, 0);
        snackbarLayout.setLayoutParams(lp);
    }
//    public void hideLoading() {
//        view.findViewById(R.id.shimmerCharacters).setVisibility(View.GONE);
//    }
//
//    public void showLoading() {
//        view.findViewById(R.id.shimmerCharacters).setVisibility(View.VISIBLE);
//    }
}