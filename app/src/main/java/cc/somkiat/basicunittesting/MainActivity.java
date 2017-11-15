package cc.somkiat.basicunittesting;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import cc.somkiat.basicunittesting.exception.BaseValidationException;

public class MainActivity extends AppCompatActivity {

    private EditText editName, editEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editName = findViewById(R.id.userNameInput);
        editEmail = findViewById(R.id.emailInput);
    }

    public void onSaveClick(View view) {
        String name = editName.getText().toString();
        String email = editEmail.getText().toString();

        validate(name, email);
    }

    public void onRevertClick(View view) {
        editName.setText("");
        editEmail.setText("");

        Toast.makeText(this, "Revert", Toast.LENGTH_SHORT).show();
    }

    private void validate(String name, String email) {
        NameValidator nameValidator = new NameValidator();
        EmailValidator emailValidator = new EmailValidator();

        try {
            nameValidator.validate(name);
            emailValidator.validate(email);

        } catch (BaseValidationException e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
            return;
        }
        Toast.makeText(this, "Save", Toast.LENGTH_SHORT).show();
    }
}
