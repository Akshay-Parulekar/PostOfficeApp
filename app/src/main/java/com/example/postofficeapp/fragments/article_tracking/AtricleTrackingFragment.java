package com.example.postofficeapp.fragments.article_tracking;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.postofficeapp.databinding.FragmentArticleTrackingBinding;

public class AtricleTrackingFragment extends Fragment {

    private FragmentArticleTrackingBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ArticleTrackingViewModel articleTrackingViewModel =
                new ViewModelProvider(this).get(ArticleTrackingViewModel.class);

        binding = FragmentArticleTrackingBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textSlideshow;
        articleTrackingViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}