package com.assessment.api.superhero.activities;

import android.os.Bundle;
import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.assessment.api.R;
import com.assessment.api.superhero.fragments.Hero;
import com.assessment.api.superhero.fragments.Resume;
import com.assessment.api.superhero.utilities.BottomNavigationBehavior;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Dashboard extends AppCompatActivity {

    @BindView(R.id.navigation)
    BottomNavigationView navigation;


    private static final String TAG_RESUME = "resume";
    private static final String TAG_HEROS = "heros";
    private static final String TAG_CREDITS = "credits";
    public static String CURRENT_TAG = TAG_RESUME;

    private boolean shouldLoadHomeFragOnBackPress = true;
    public static int navItemIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        ButterKnife.bind(this);

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) navigation
                .getLayoutParams();
        layoutParams.setBehavior(new BottomNavigationBehavior());

        if (savedInstanceState == null) {
            navItemIndex = 0;
            CURRENT_TAG = TAG_RESUME;
            loadFragment(new Resume());
        }
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment;
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    fragment = new Resume();
                    loadFragment(fragment);
                    CURRENT_TAG = TAG_RESUME;
                    return true;
                case R.id.navigation_heros:
                    fragment = new Hero();
                    loadFragment(fragment);
                    CURRENT_TAG = TAG_HEROS;
                    return true;
//                case R.id.navigation_attribution:
//                    fragment = new Credits();
//                    loadFragment(fragment);
//                    CURRENT_TAG = TAG_CREDITS;
//                    return true;
            }
            return false;
        }
    };



    private void loadFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public void onBackPressed() {
        if (shouldLoadHomeFragOnBackPress) {
            if (navItemIndex != 0) {
                navItemIndex = 0;
                CURRENT_TAG = TAG_RESUME;
                loadFragment(new Resume());
                return;
            }
        }
        super.onBackPressed();
    }
}