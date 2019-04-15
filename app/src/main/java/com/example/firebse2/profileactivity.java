package com.example.firebse2;



import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class profileactivity extends AppCompatActivity implements View.OnClickListener{

    FirebaseAuth firebaseAuth;
    EditText name1;
    EditText adress1;
    Button savebutton;
    FirebaseDatabase database ;

    DatabaseReference databaseReference;



    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profileactivity );

        firebaseAuth=FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();

        databaseReference=FirebaseDatabase.getInstance().getReference();
        FirebaseUser user= firebaseAuth.getCurrentUser();

        name1=(EditText)findViewById(R.id.editText3);
        adress1=(EditText)findViewById(R.id.editText4);
        savebutton=(Button)findViewById(R.id.button4);



        savebutton.setOnClickListener(this);

    }

    public void saveuserinfo(){

        String name= name1.getText().toString().trim();
        String address =adress1.getText().toString().trim();

        userinfo userinfo1 =new userinfo(name,address);

        FirebaseUser user= firebaseAuth.getCurrentUser();
        databaseReference.child(user.getUid()).setValue(userinfo1);
        Toast.makeText(this,"data is saved",Toast.LENGTH_LONG).show();

    }


    @Override
    public void onClick(View view) {
        if (view==savebutton){
            saveuserinfo();

        }

    }
}
