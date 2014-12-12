package in.bhardwaj.clipcheck;

import android.content.ClipboardManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends ActionBarActivity {

    private ClipChangeReal inew;
    private ClipboardManager mgr;

    private abstract class ClipChange implements ClipboardManager.OnPrimaryClipChangedListener{
        public abstract void onPrimaryClipChanged();
    }

    private class ClipChangeReal extends ClipChange {
        @Override
        public void onPrimaryClipChanged(){
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>  ");
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inew = new ClipChangeReal();
        mgr = (ClipboardManager)getSystemService(CLIPBOARD_SERVICE);
        mgr.addPrimaryClipChangedListener(inew);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        mgr.removePrimaryClipChangedListener(inew);
    }
}
