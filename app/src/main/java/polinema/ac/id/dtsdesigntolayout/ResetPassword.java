package polinema.ac.id.dtsdesigntolayout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ResetPassword extends AppCompatActivity {

    // Deklarasi EditText
    EditText newPass,confirmPass,resetCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);

        // Binding EditText
        newPass = (EditText) findViewById(R.id.edt_new_password);
        confirmPass = (EditText) findViewById(R.id.edt_confirm_password);
        resetCode = (EditText) findViewById(R.id.edt_txt_code);
    }

    public void postChangePassword(View view) {
        // Validasi kosong
        if(TextUtils.isEmpty(resetCode.getText())){
            Toast.makeText(view.getContext(), "Reset Code Tidak Boleh Kosong", Toast.LENGTH_LONG).show();
        }else if (TextUtils.isEmpty(newPass.getText().toString().trim()) && TextUtils.isEmpty(confirmPass.getText().toString().trim())){
            Toast.makeText(view.getContext(),"Password Baru dan Konfirmasi Password Tidak Boleh Kosong",Toast.LENGTH_LONG).show();
        }else if(TextUtils.isEmpty(newPass.getText().toString().trim())){
            Toast.makeText(view.getContext(), "Password Baru Tidak Boleh Kosong", Toast.LENGTH_LONG).show();
        }else if(TextUtils.isEmpty(confirmPass.getText().toString().trim())){
            Toast.makeText(view.getContext(), "Konfirmasi Password Tidak Boleh Kosong", Toast.LENGTH_LONG).show();

        // Cek inputan new dan confirm
        }else if (!newPass.getText().toString().equals(confirmPass.getText().toString())){
            Toast.makeText(view.getContext(),"Password Baru dan Konfirmasi Password Harus Sama",Toast.LENGTH_LONG).show();
        }else if(newPass.getText().toString().length()>15 && confirmPass.getText().toString().length()>15){
            Toast.makeText(view.getContext(), "Password Baru Tidak Boleh Melebihi 15 Karakter", Toast.LENGTH_LONG).show();
        }else{
            Intent i = new Intent(ResetPassword.this, SuccessActivity.class);
            startActivity(i);
        }
    }
}
