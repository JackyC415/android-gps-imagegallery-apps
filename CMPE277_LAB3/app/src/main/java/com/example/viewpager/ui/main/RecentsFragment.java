package com.example.viewpager.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import com.example.viewpager.R;

public class RecentsFragment extends Fragment {


  private PageViewModel pageViewModel;

  public RecentsFragment() {
    // Required empty public constructor
  }

  /**
   * @return A new instance of fragment RecentsFragment.
   */
  public static RecentsFragment newInstance() {
    return new RecentsFragment();
  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    pageViewModel = ViewModelProviders.of(this).get(PageViewModel.class);
    pageViewModel.setIndex("Search Results");
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    View root = inflater.inflate(R.layout.fragment_main, container, false);
    final TextView textView = root.findViewById(R.id.section_label);
    final String location = getArguments().getString("address");
    pageViewModel.getText().observe(this, new Observer<String>() {
      @Override
      public void onChanged(@Nullable String s) {
        textView.setText(location);
      }
    });
    return root;
  }
}
