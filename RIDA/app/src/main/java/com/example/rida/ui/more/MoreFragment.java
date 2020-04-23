package com.example.rida.ui.more;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.rida.MainActivity;
import com.example.rida.R;
import com.google.firebase.auth.FirebaseAuth;

public class MoreFragment extends Fragment {

    private Button profileBtn;
    private Button messagesBtn;
    private Button settingsBtn;
    private Button helpBtn;
    private Button signOutBtn;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        View root = inflater.inflate(R.layout.fragment_more, container, false);

        profileBtn = (Button) root.findViewById(R.id.profile_button);
        messagesBtn = (Button) root.findViewById(R.id.messages_button);
        settingsBtn = (Button) root.findViewById(R.id.settings_button);
        helpBtn = (Button) root.findViewById(R.id.help_button);
        signOutBtn = (Button) root.findViewById(R.id.signout_button);

        profileBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Sorry, this feature hasn't been implemented yet!", Toast.LENGTH_LONG).show();
            }
        });
        messagesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Sorry, this feature hasn't been implemented yet!", Toast.LENGTH_LONG).show();
            }
        });
        settingsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Sorry, this feature hasn't been implemented yet!", Toast.LENGTH_LONG).show();
            }
        });
        helpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Sorry, this feature hasn't been implemented yet!", Toast.LENGTH_LONG).show();
            }
        });
        signOutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth mAuth = FirebaseAuth.getInstance();
                mAuth.getInstance().signOut();
                Intent signOutIntent = new Intent(MoreFragment.this.getContext(), MainActivity.class);
                startActivity(signOutIntent);
            }
        });
        return root;
    }
}
