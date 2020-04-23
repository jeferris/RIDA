package com.example.rida.ui.expenses;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rida.R;

public class ExpensesFragment extends Fragment {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;
    Button gasMaintenanceBtn;
    Button mileageBtn;
    Button earningsBtn;
    EditText gasMaintText;
    EditText mileageText;
    EditText earningsText;

    public EditText getGasMaintText() {
        return gasMaintText;
    }
    public EditText getMileageText() {
        return mileageText;
    }
    public EditText gtEarningsText() {
        return earningsText;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        // writeNewPost("author", "hello", "time");

       /* myRef = FirebaseDatabase.getInstance().getReference().child("newsfeed");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                newsfeed = new ArrayList<Post>();
                for(DataSnapshot dataSnapshot1: dataSnapshot.getChildren())
                {
                    Post p = dataSnapshot1.getValue(Post.class);
                    newsfeed.add(0, p);
                }
                adapter = new HomeRecyclerAdapter(newsfeed);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                //Toast.makeText(HomeFragment.this, "Opsss.... Something is wrong", Toast.LENGTH_SHORT).show();
            }
        });*/

        View root = inflater.inflate(R.layout.fragment_expenses, container, false);
        recyclerView = (RecyclerView) root.findViewById(R.id.recycler_view_expenses);
        layoutManager = new LinearLayoutManager(root.getContext());
        recyclerView.setLayoutManager(layoutManager);
        adapter = new ExpensesRecyclerAdapter();
        recyclerView.setAdapter(adapter);

        gasMaintenanceBtn = (Button) root.findViewById(R.id.gasMaintAdd);
        mileageBtn = (Button) root.findViewById(R.id.mileageAdd);
        earningsBtn = (Button) root.findViewById(R.id.earningsAdd);

        gasMaintText = root.findViewById(R.id.gasMaintText);
        mileageText = root.findViewById(R.id.mileageText);
        earningsText = root.findViewById(R.id.earningsText);

        gasMaintenanceBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //insert new function here
                //onNewPostClick(v);
            }
        });

        mileageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //insert new function here
                //onNewPostClick(v);
            }
        });

        earningsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //insert new function here
                //onNewPostClick(v);
            }
        });

        return root;
    }

    /*private void onNewPostClick(View v) {
        String post_contents;
        post_contents = postContent.getText().toString();
        if (TextUtils.isEmpty(post_contents)) {
            Toast.makeText(getContext(), "Please type something to post", Toast.LENGTH_LONG).show();
            return;
        }
        int i = v.getId();
        if (i == R.id.new_post_button) {
            Toast.makeText(getContext(), "newPostButton pressed", Toast.LENGTH_LONG).show();
            Timestamp ts = new Timestamp(System.currentTimeMillis());
            Post p = new Post("me", post_contents, ts.toString());
            myRef.push().setValue(p);
        }
    }*/
}
