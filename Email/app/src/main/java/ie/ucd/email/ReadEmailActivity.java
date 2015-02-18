package ie.ucd.email;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import ie.ucd.email.Components.Email;


public class ReadEmailActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_email);

        Bundle data = getIntent().getExtras();
        if(data != null){
            Email oMail = data.getParcelable(getString(R.string.email_mailObject));

            if(oMail != null){
                // set the screen info!
                ((TextView)findViewById(R.id.txtTo)).setText(oMail.get_to());
                ((TextView)findViewById(R.id.txtfrom)).setText(oMail.get_from());
                ((TextView)findViewById(R.id.txtCC)).setText(oMail.get_cc());
                ((TextView)findViewById(R.id.txtSubject)).setText(oMail.get_subject());
                ((TextView)findViewById(R.id.txtBody)).setText(oMail.get_body());

            }
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_read_email, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        return super.onOptionsItemSelected(item);
    }

    public void EditMode(View v){
        finish();
    }
}
