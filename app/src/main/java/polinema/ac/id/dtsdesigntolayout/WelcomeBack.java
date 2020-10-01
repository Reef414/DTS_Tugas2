package polinema.ac.id.dtsdesigntolayout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class WelcomeBack extends AppCompatActivity {

    // Deklarasi variabel editTextEmail dengan tipe EditText
    EditText edtEmailAddress;
    // Deklarasi variabel editTextPassword dengan tipe EditText
    EditText edtPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_back);

        // Binding edt_txt_email ke variabel editTextEmail
        edtEmailAddress = (EditText) findViewById(R.id.edt_txt_email);
        // Binding edt_txt_password ke variabel editTextPassword
        edtPass = (EditText) findViewById(R.id.edt_txt_password);

    }

    public void clickForgot(View view) {
        Intent i = new Intent(WelcomeBack.this, ForgotPassword.class);
        startActivity(i);
    }

    public void postLogin(View view) {
        // Validasi input email dan password kosong
        if (TextUtils.isEmpty(edtEmailAddress.getText().toString().trim()) && TextUtils.isEmpty(edtPass.getText().toString().trim())){
            Toast.makeText(view.getContext(),"Email dan Password Tidak Boleh Kosong",Toast.LENGTH_LONG).show();
        }
        // Validasi input email kosong
        else if(TextUtils.isEmpty(edtEmailAddress.getText().toString().trim())){
            Toast.makeText(view.getContext(),"Email Tidak Boleh Kosong",Toast.LENGTH_LONG).show();
        }
        // Validasi inputan tipe email
        else if(!isValidEmail(edtEmailAddress.getText().toString().trim())){
            Toast.makeText(view.getContext(),"Email Tidak Valid",Toast.LENGTH_LONG).show();
        }
        // Validasi password kosong
        else if(TextUtils.isEmpty(edtPass.getText().toString().trim())) {
            Toast.makeText(view.getContext(), "Password Tidak Boleh Kosong", Toast.LENGTH_LONG).show();
        }
        //validasi character maksimal password
        else if(edtPass.getText().toString().length()>15){
            Toast.makeText(view.getContext(), "Password Tidak Boleh Melebihi 15 Karakter", Toast.LENGTH_LONG).show();
        }
        else{
            Intent i = new Intent(WelcomeBack.this, SuccessActivity.class);
            startActivity(i);
        }
    }

    private boolean isValidEmail(CharSequence email) {
        return(Patterns.EMAIL_ADDRESS.matcher(email).matches());
    }

    public void clickSignUp(View view) {
        // Panggil intent sign up
    }

}
