package com.example.postofficeapp.fragments.pincode;

import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.loader.content.AsyncTaskLoader;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.postofficeapp.adapter.PincodeDetailsAdapter;
import com.example.postofficeapp.dao.PincodeDetailsDao;
import com.example.postofficeapp.database.MyDatabase;
import com.example.postofficeapp.databinding.FragmentPincodeBinding;
import com.example.postofficeapp.model.PincodeDetails;

import java.util.ArrayList;
import java.util.List;

public class PincodeFragment extends Fragment {

    private FragmentPincodeBinding binding;
    List<PincodeDetails> list;
    PincodeDetailsAdapter adapter;
    MyDatabase db;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentPincodeBinding.inflate(inflater, container, false);

        db = MyDatabase.getInstance(getActivity());

        binding.reclView.setHasFixedSize(true);
        binding.reclView.setLayoutManager(new LinearLayoutManager(getContext()));

        binding.btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                binding.pBar.setVisibility(View.VISIBLE);

                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        new AsyncPincodeTask().execute();
                    }
                });
            }
        });

        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    class AsyncPincodeTask extends AsyncTask<Void, Void, Void>
    {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            binding.pBar.setVisibility(View.VISIBLE);
            binding.tSearch.setEnabled(false);
            binding.btnSearch.setEnabled(false);
        }

        @Override
        protected Void doInBackground(Void... voids) {
            list = db.PincodeDetailsDao().findBySomethingLike(binding.tSearch.getText().toString().trim());
            adapter = new PincodeDetailsAdapter(getActivity(), list);
            return null;
        }

        @Override
        protected void onPostExecute(Void unused) {
            super.onPostExecute(unused);
            binding.reclView.setAdapter(adapter);
            binding.pBar.setVisibility(View.GONE);
            binding.tSearch.setEnabled(true);
            binding.btnSearch.setEnabled(true);
        }
    }
}