package com.assessment.api.superhero.fragments;

import static android.text.Layout.JUSTIFICATION_MODE_INTER_WORD;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import com.assessment.api.R;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

public class Resume extends Fragment {

    @BindView(R.id.today_date)
    TextView today_date;
    @BindViews({R.id.objective1, R.id.objective2})
    List<TextView> textViewList;
    View view;
    private Calendar calendar;
    private SimpleDateFormat dateFormat;
    private String date;

    TextView language_dialog, text1;
    boolean lang_selected;
    Context context;
    Resources resources;

    public Resume() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_resume, container, false);
        ButterKnife.bind(this, view);
//        language_dialog = view.findViewById(R.id.dialog_language);

//        setLocal();
        calendar = Calendar.getInstance();
        dateFormat = new SimpleDateFormat("EEE | MMM d ''yy");
        date = dateFormat.format(calendar.getTime());
        today_date.setText(date);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            textViewList.get(0).setJustificationMode(JUSTIFICATION_MODE_INTER_WORD);
            textViewList.get(1).setJustificationMode(JUSTIFICATION_MODE_INTER_WORD);
        }

        return view;
    }

//    private void setLocal() {
//        language_dialog.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                final String[] Language = {"ENGLISH", "AFRIKAANS"};
//                final int checkedItem;
//                if (lang_selected) {
//                    checkedItem = 0;
//                } else {
//                    checkedItem = 1;
//                }
//                final AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
//                builder.setTitle("Select a Language...")
//                        .setSingleChoiceItems(Language, checkedItem,
//                                new DialogInterface.OnClickListener() {
//                                    @Override
//                                    public void onClick(DialogInterface dialog, int which) {
//                                        Toast.makeText(getActivity(), "" + which,
//                                                Toast.LENGTH_SHORT).show();
//                                        language_dialog.setText(Language[which]);
//                                        lang_selected = Language[which].equals("ENGLISH");
//                                        //if user select prefered language as English then
//                                        if (Language[which].equals("ENGLISH")) {
//                                            context = LocaleHelper.setLocale(getActivity(), "en");
//                                            resources = context.getResources();
//
//                                        }
//                                        //if user select prefered language as Afrikaans then
//                                        if (Language[which].equals("AFRIKAANS")) {
//                                            context = LocaleHelper.setLocale(getActivity(), "af");
//                                            resources = context.getResources();
////                                            textViewList.get(0).setText(resources.getString(R.string.language));
////                                            text1.setText(resources.getString(R.string.language));
//                                        }
//                                    }
//                                })
//                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                dialog.dismiss();
//                            }
//                        });
//                builder.create().show();
//            }
//        });
//    }
}