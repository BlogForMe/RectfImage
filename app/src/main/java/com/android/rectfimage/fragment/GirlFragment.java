package com.android.rectfimage.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.rectfimage.CircleRectActivity;
import com.android.rectfimage.LearnTranslateActivity;
import com.android.rectfimage.R;
import com.android.rectfimage.SingleActivity;
import com.android.rectfimage.Xfermodes;

/**
 * A fragment with a Google +1 button.
 * Activities that contain this fragment must implement the
 * Use the {@link GirlFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GirlFragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;


    public GirlFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment GirlFragment.
     */
    public static GirlFragment newInstance(String param1, String param2) {
        GirlFragment fragment = new GirlFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_girl, container, false);
        setUpView(view);

        return view;
    }

    private void setUpView(View v) {
        v.findViewById(R.id.tv).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), Xfermodes.class));
            }
        });

        /**
         * 测试tranlate(x,y)方法
         */
        v.findViewById(R.id.tv_translate).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), LearnTranslateActivity.class));
            }
        });
        /**
         * 画图
         */
        v.findViewById(R.id.tv_circleRect).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), CircleRectActivity.class));
            }
        });

        /**
         * 对Apidemos单个进行测试
         */
        v.findViewById(R.id.tv_single).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), SingleActivity.class));
            }
        });
    }


}
