package com.kevicsalazar.quickstartguide;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * @author Kevin Salazar
 * @link kevicsalazar.com
 */

public class QuickStartPageFragment extends Fragment {

    public static QuickStartPageFragment newInstance() {
        return new QuickStartPageFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_quickstartpage, container, false);
    }

}
