package ie.ucd.email;

import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import ie.ucd.email.Components.Email;


public class CreateEmailActivity extends ActionBarActivity {

    private Email _mail = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_create_email);
        setTitle("Compose Email");
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState){

        if(this._mail != null){
            savedInstanceState.putParcelable(getString(R.string.email_mailObject), this._mail);
        }
        super.onSaveInstanceState(savedInstanceState);
    }

    /// this is only called if there is a saved state to restore so we don;t need
    /// to check if savedInstanceState is null.
    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState){
        super.onRestoreInstanceState(savedInstanceState);
        this._mail = savedInstanceState.getParcelable(getString(R.string.email_mailObject));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_create_email, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        return super.onOptionsItemSelected(item);
    }

    public void ClearForm(View v){
        // clear down form!
      ((EditText) findViewById(R.id.txtfrom)).setText(null);
      ((EditText) findViewById(R.id.txtTo)).setText(null);
      ((EditText) findViewById(R.id.txtCC)).setText(null);
      ((EditText) findViewById(R.id.txtBcc)).setText(null);
      ((EditText) findViewById(R.id.txtSubject)).setText(null);
      ((EditText) findViewById(R.id.txtBody)).setText(null);
    }

    public void SendEmail(View v){

        // I'm only going to validate these 2 controls
        EditText txtFrom = (EditText) findViewById(R.id.txtfrom);
        EditText txtTo = (EditText) findViewById(R.id.txtTo);

        // rip out the string values
        String cc = ((EditText) findViewById(R.id.txtCC)).getText().toString();
        String bcc = ((EditText) findViewById(R.id.txtBcc)).getText().toString();
        String from = txtFrom.getText().toString();
        String to = txtTo.getText().toString();
        String subject = ((EditText) findViewById(R.id.txtSubject)).getText().toString();
        String body = ((EditText) findViewById(R.id.txtBody)).getText().toString();

        // only create new intent if from & to have values
        if(Validate(txtFrom) && Validate(txtTo) ){
            _mail = new Email(to, from, cc, bcc, subject, body);

            // start the Read Email Activity
            Intent readActivity = new Intent(this, ReadEmailActivity.class);
            readActivity.putExtra(getString(R.string.email_mailObject), _mail);
            startActivity(readActivity);
        }
    }

    private boolean Validate(EditText ctrl){
        if(TextUtils.isEmpty(ctrl.getText())){
            ctrl.setError("Name Required!");
            return false;
        }
        return true;
    }
}
