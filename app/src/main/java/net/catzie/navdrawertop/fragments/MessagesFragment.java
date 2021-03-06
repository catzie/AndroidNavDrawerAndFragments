package net.catzie.navdrawertop.fragments;

/**
 * Created by Catzie on 30/06/2016.
 */

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.catzie.navdrawertop.R;

public class MessagesFragment extends Fragment {

    private static final String TAG = "HomeFragment";

    public static MessagesFragment newInstance(Bundle bundle)
    {
        MessagesFragment messagesFragment = new MessagesFragment();

        if (bundle != null)
        {
            messagesFragment.setArguments(bundle);
        }

        return messagesFragment;
    }

    // The onCreateView method is called when Fragment should create its View object hierarchy,
    // either dynamically or via XML layout inflation.
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        Log.d(TAG, "inside pricelist fragment onCreateView");

        View view = inflater.inflate(R.layout.fragment_messages, parent, false);

        return view;
    }

    // This event is triggered soon after onCreateView().
    // Any view setup should occur here.  E.g., view lookups and attaching view listeners.
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        // Setup any handles to view objects here
        // EditText etFoo = (EditText) view.findViewById(R.id.etFoo);
    }

}