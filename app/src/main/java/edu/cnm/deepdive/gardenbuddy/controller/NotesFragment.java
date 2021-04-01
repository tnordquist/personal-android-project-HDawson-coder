package edu.cnm.deepdive.gardenbuddy.controller;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import edu.cnm.deepdive.gardenbuddy.R;
import edu.cnm.deepdive.gardenbuddy.viewmodel.NotesViewModel;

public class NotesFragment extends Fragment {

  private NotesViewModel notesViewModel;

  public View onCreateView(@NonNull LayoutInflater inflater,
      ViewGroup container, Bundle savedInstanceState) {
    notesViewModel =
        ViewModelProviders.of(this).get(NotesViewModel.class);
    View root = inflater.inflate(R.layout.fragment_notes, container, false);
    final TextView textView = root.findViewById(R.id.notes_header);
    notesViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
      @Override
      public void onChanged(@Nullable String s) {
        textView.setText(s);
      }
    });
    return root;
  }
}