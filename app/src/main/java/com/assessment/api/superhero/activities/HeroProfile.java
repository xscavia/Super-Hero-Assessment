package com.assessment.api.superhero.activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.palette.graphics.Palette;
import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import com.assessment.api.R;
import com.assessment.api.superhero.pojo.Appearance;
import com.assessment.api.superhero.pojo.Biography;
import com.assessment.api.superhero.pojo.Connections;
import com.assessment.api.superhero.pojo.HeroImage;
import com.assessment.api.superhero.pojo.PowerStats;
import com.assessment.api.superhero.retrofit.Api;
import com.bumptech.glide.Glide;
import com.google.android.material.snackbar.Snackbar;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Objects;
import net.steamcrafted.loadtoast.LoadToast;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class HeroProfile extends AppCompatActivity {

    @BindViews({R.id.Name, R.id.fullName, R.id.alterEgos, R.id.placeOfBirth, R.id.publisher_,
            R.id.alignment_})
    List<TextView> textViewList;
    @BindViews({R.id.intelligence, R.id.strength, R.id.speed, R.id.durability, R.id.power,
            R.id.combat})
    List<TextView> power_textViewList;
    @BindViews({R.id.gender, R.id.race, R.id.height, R.id.weight, R.id.eye_color, R.id.hair_color})
    List<TextView> appearanceTextViewList;
    @BindView(R.id.imageView_hero)
    ImageView imageView;
    @BindView(R.id.group_affilation)
    TextView group_affiliations;
    @BindView(R.id.relatives)
    TextView relatives;
    @BindView(R.id.constraint_)
    ConstraintLayout constraintLayout;
    int id;
    Snackbar snackbar;
    LoadToast loadToast;

    URL myFileUrl;
    Bitmap imageBitmap = null;
    String image_url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hero_profile);
        ButterKnife.bind(this);
        changeStatusBarColor();
        showLoading();
        Intent intent = getIntent();
        Bundle s = intent.getExtras();

        assert s != null;
        id = s.getInt("id");
        getCharacterImage(id);
        getBiography(id);
        getPowerStats(id);
        getAppearance(id);
        getConnections(id);
    }


    public void getCharacterImage(int character_id) {
        Api.getClient().fetchCharacterImages(character_id, new Callback<HeroImage>() {
            @Override
            public void success(HeroImage heroImage, Response response) {
                Log.d("successful_response", heroImage.getResponse());
                if (heroImage.getResponse().equalsIgnoreCase("success")) {
                    image_url = heroImage.getUrl();
                    Glide.with(HeroProfile.this).load(image_url)
                            .into(imageView);
                    StringToBitMap stringToBitMap = new StringToBitMap();
                    stringToBitMap.execute();
                } else {
                    loadToast.hide();
                    Log.d("unSuccessful_response", heroImage.getResponse() + heroImage.getError());
                    snackbar = Snackbar
                            .make(constraintLayout, heroImage.getResponse() + heroImage.getError(),
                                    Snackbar.LENGTH_LONG);
                    snackbar.setBackgroundTint(
                            ContextCompat.getColor(HeroProfile.this, R.color.unsuccessful));
                    snackbar.setDuration(5000);
                    setSnackBarPosition();
                }
            }

            @Override
            public void failure(RetrofitError error) {
                loadToast.hide();
                snackbar = Snackbar
                        .make(constraintLayout, Objects.requireNonNull(error.getMessage()),
                                Snackbar.LENGTH_LONG);
                snackbar.setBackgroundTint(
                        ContextCompat.getColor(HeroProfile.this, R.color.warning));
                snackbar.setDuration(5000);
                setSnackBarPosition();
                Log.e("error", error.toString());
            }
        });

    }

    public void getBiography(int character_id) {
        Api.getClient().fetchBiography(character_id, new Callback<Biography>() {
            @Override
            public void success(Biography biography, Response response) {
                Log.d("successful_response", biography.getResponse());
                if (biography.getResponse().equalsIgnoreCase("success")) {
                    String name = biography.getName();
                    String fullname = biography.getFull_name();
                    String alter = biography.getAlter_egos();
                    String pob = biography.getPlace_of_birth();
                    String publisher = biography.getPublisher();
                    String alignment = biography.getAlignment();
                    setTextViewList(name, fullname, alter, pob, publisher, alignment);
                } else {
                    loadToast.hide();
                    Log.d("unSuccessful_response", biography.getResponse() + biography.getError());
                    snackbar = Snackbar
                            .make(constraintLayout, biography.getResponse() + biography.getError(),
                                    Snackbar.LENGTH_LONG);
                    snackbar.setBackgroundTint(
                            ContextCompat.getColor(HeroProfile.this, R.color.unsuccessful));
                    snackbar.setDuration(5000);
                    setSnackBarPosition();
                }
            }

            @Override
            public void failure(RetrofitError error) {
                loadToast.hide();
                snackbar = Snackbar
                        .make(constraintLayout, Objects.requireNonNull(error.getMessage()),
                                Snackbar.LENGTH_LONG);
                snackbar.setBackgroundTint(
                        ContextCompat.getColor(HeroProfile.this, R.color.warning));
                snackbar.setDuration(5000);
                setSnackBarPosition();
                Log.e("error", error.toString());
            }
        });

    }

    public void getPowerStats(int character_id) {
        Api.getClient().fetchPowerstats(character_id, new Callback<PowerStats>() {
            @Override
            public void success(PowerStats powerStats, Response response) {
                loadToast.hide();
                Log.d("successful_response", powerStats.getResponse());
                if (powerStats.getResponse().equalsIgnoreCase("success")) {
                    String intelligence = powerStats.getIntelligence();
                    String strength = powerStats.getStrength();
                    String speed = powerStats.getSpeed();
                    String durability = powerStats.getDurability();
                    String power = powerStats.getPower();
                    String combat = powerStats.getCombat();
                    setPowerTextViewList(intelligence, strength, speed, durability, power, combat);
                } else {
                    loadToast.hide();
                    Log.d("unSuccessful_response",
                            powerStats.getResponse() + powerStats.getError());
                    snackbar = Snackbar
                            .make(constraintLayout,
                                    powerStats.getResponse() + powerStats.getError(),
                                    Snackbar.LENGTH_LONG);
                    snackbar.setBackgroundTint(
                            ContextCompat.getColor(HeroProfile.this, R.color.unsuccessful));
                    snackbar.setDuration(5000);
                    setSnackBarPosition();
                }
            }

            @Override
            public void failure(RetrofitError error) {
                loadToast.hide();
                snackbar = Snackbar
                        .make(constraintLayout, Objects.requireNonNull(error.getMessage()),
                                Snackbar.LENGTH_LONG);
                snackbar.setBackgroundTint(
                        ContextCompat.getColor(HeroProfile.this, R.color.warning));
                snackbar.setDuration(5000);
                setSnackBarPosition();
                Log.e("error", error.toString());
            }
        });

    }

    private void getAppearance(int character_id) {
        Api.getClient().fetchAppearance(character_id, new Callback<Appearance>() {
            @Override
            public void success(Appearance appearance, Response response) {
                Log.d("successful_response", appearance.getResponse());
                if (appearance.getResponse().equalsIgnoreCase("success")) {
                    String gender = appearance.getGender();
                    String race = appearance.getRace();
                    List<String> height = appearance.getHeight();
                    List<String> weight = appearance.getWeight();
                    String eye_color = appearance.getEye_color();
                    String hair_color = appearance.getHair_color();
                    setAppearanceTextViewList(gender, race, height, weight, eye_color, hair_color);
                } else {
                    loadToast.hide();
                    Log.d("unSuccessful_response",
                            appearance.getResponse() + appearance.getError());
                    snackbar = Snackbar
                            .make(constraintLayout,
                                    appearance.getResponse() + appearance.getError(),
                                    Snackbar.LENGTH_LONG);
                    snackbar.setBackgroundTint(
                            ContextCompat.getColor(HeroProfile.this, R.color.unsuccessful));
                    snackbar.setDuration(5000);
                    setSnackBarPosition();
                }
            }

            @Override
            public void failure(RetrofitError error) {
                loadToast.hide();
                snackbar = Snackbar
                        .make(constraintLayout, Objects.requireNonNull(error.getMessage()),
                                Snackbar.LENGTH_LONG);
                snackbar.setBackgroundTint(
                        ContextCompat.getColor(HeroProfile.this, R.color.warning));
                snackbar.setDuration(5000);
                setSnackBarPosition();
                Log.e("error", error.toString());
            }
        });
    }

    private void getConnections(int character_id) {
        Api.getClient().fetchConnections(character_id, new Callback<Connections>() {
            @Override
            public void success(Connections connections, Response response) {
                Log.d("successful_response", connections.getResponse());
                if (connections.getResponse().equalsIgnoreCase("success")) {
                    String affiliation = connections.getGroup_affiliation();
                    String relatives_ = connections.getRelatives();
                    group_affiliations.setText(affiliation);
                    relatives.setText(relatives_);
                } else {
                    loadToast.hide();
                    Log.d("unSuccessful_response",
                            connections.getResponse() + connections.getError());
                    snackbar = Snackbar
                            .make(constraintLayout,
                                    connections.getResponse() + connections.getError(),
                                    Snackbar.LENGTH_LONG);
                    snackbar.setBackgroundTint(
                            ContextCompat.getColor(HeroProfile.this, R.color.unsuccessful));
                    snackbar.setDuration(5000);
                    setSnackBarPosition();
                }
            }

            @Override
            public void failure(RetrofitError error) {
                loadToast.hide();
                snackbar = Snackbar
                        .make(constraintLayout, Objects.requireNonNull(error.getMessage()),
                                Snackbar.LENGTH_LONG);
                snackbar.setBackgroundTint(
                        ContextCompat.getColor(HeroProfile.this, R.color.warning));
                snackbar.setDuration(5000);
                setSnackBarPosition();
                Log.e("error", error.toString());
            }
        });
    }


    private void setTextViewList(String name, String fullname, String alter, String pob,
            String publisher, String alignment) {

        textViewList.get(0).setText(name);
        textViewList.get(1).setText(fullname);
        textViewList.get(2).setText(alter);
        textViewList.get(3).setText(pob);
        textViewList.get(4).setText(publisher);
        textViewList.get(5).setText(alignment);
    }

    private void setPowerTextViewList(String intelligence, String strength, String speed,
            String durability, String power, String combat) {
        power_textViewList.get(0).setText(intelligence);
        power_textViewList.get(1).setText(strength);
        power_textViewList.get(2).setText(speed);
        power_textViewList.get(3).setText(durability);
        power_textViewList.get(4).setText(power);
        power_textViewList.get(5).setText(combat);
    }

    @SuppressLint("SetTextI18n")
    private void setAppearanceTextViewList(String gender, String race, List<String> height,
            List<String> weight, String eye_color, String hair_color) {
        appearanceTextViewList.get(0).setText(gender);
        appearanceTextViewList.get(1).setText(race);
        appearanceTextViewList.get(2).setText(height.get(0) + " / " + height.get(1));
        appearanceTextViewList.get(3).setText(weight.get(0) + " / " + weight.get(1));
        appearanceTextViewList.get(4).setText(eye_color);
        appearanceTextViewList.get(5).setText(hair_color);
    }

    public class StringToBitMap extends AsyncTask<String, String, String> {


        @Override
        protected String doInBackground(String... strings) {
            try {

                myFileUrl = new URL(image_url);
                HttpURLConnection conn = (HttpURLConnection)
                        myFileUrl.openConnection();
                conn.setDoInput(true);
                conn.connect();
                InputStream is = conn.getInputStream();
                imageBitmap = BitmapFactory.decodeStream(is);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            paintTextBackground(imageBitmap);
        }
    }

    private void paintTextBackground(Bitmap image) {

        Palette.from(image).generate(new Palette.PaletteAsyncListener() {
            @Override
            public void onGenerated(Palette palette) {
                //work with the palette here
                int defaultValue = 0x000000;
                int vibrant = palette.getVibrantColor(defaultValue);
                int vibrantLight = palette.getLightVibrantColor(defaultValue);
                int vibrantDark = palette.getDarkVibrantColor(defaultValue);
                int muted = palette.getMutedColor(defaultValue);
                int mutedLight = palette.getLightMutedColor(defaultValue);
                int mutedDark = palette.getDarkMutedColor(defaultValue);

                power_textViewList.get(0).setBackgroundColor(vibrant);
                power_textViewList.get(1).setBackgroundColor(vibrant);
                power_textViewList.get(2).setBackgroundColor(vibrant);
                power_textViewList.get(3).setBackgroundColor(vibrant);
                power_textViewList.get(4).setBackgroundColor(vibrant);
                power_textViewList.get(5).setBackgroundColor(vibrant);

            }
        });
    }

    public void onClick(View v) {
        super.onBackPressed(); // or super.finish();
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

    private void showLoading() {
        loadToast = new LoadToast(HeroProfile.this)
                .setProgressColor(Color.RED)
                .setText("Loading...")
                .setTranslationY(100)
                .setBackgroundColor(getResources().getColor(R.color.colorAccent))
                .setTextColor(getResources().getColor(R.color.white))
                .setProgressColor(getResources().getColor(R.color.white))
                .setBorderColor(getResources().getColor(R.color.colorAccent));
        loadToast.show();
    }

    /**
     * Making notification bar transparent
     */
    private void changeStatusBarColor() {
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
    }
}