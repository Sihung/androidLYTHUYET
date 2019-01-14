package com.example.sh.demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Main2Activity extends AppCompatActivity {

    private EditText editID,editName,editPhone,editEmail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        addControls();
    }

    private void addControls() {
        editID=findViewById(R.id.edtContactId);
        editName=findViewById(R.id.edtTen);
        editPhone=findViewById(R.id.edtPhone);
        editEmail=findViewById(R.id.edtEmail);
    }
    public void xuLyThemMoi(View view)
    {
        try {
            FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
            DatabaseReference myRef = firebaseDatabase.getReference("contacts");
            String contactId=editID.getText().toString();
            String ten = editName.getText().toString();
            String phone = editPhone.getText().toString();
            String email = editEmail.getText().toString();
            myRef.child(contactId).child("phone").setValue(phone);
            myRef.child(contactId).child("email").setValue(email);
            myRef.child(contactId).child("name").setValue(ten);
            finish();
        }
        catch (Exception ex)
        {
            Toast.makeText(this,"Error:"+ex.toString(),Toast.LENGTH_LONG).show();
        }
    }


}
