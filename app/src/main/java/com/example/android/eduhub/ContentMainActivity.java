package com.example.android.eduhub;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import static com.example.android.eduhub.EditProfilePopUp.editProfile;

public class ContentMainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_main);
        Toolbar toolbarContent = findViewById(R.id.toolbarContent);
        setSupportActionBar(toolbarContent);

        DrawerLayout drawerLayoutContent = findViewById(R.id.drawerLayoutContent);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayoutContent, toolbarContent, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayoutContent.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationViewContent = findViewById(R.id.navigationViewContent);
        navigationViewContent.setNavigationItemSelectedListener(this);

        displaySelectedScreen(R.id.menuCourse);
        navigationViewContent.setCheckedItem(R.id.menuCourse);

        if (editProfile == true) {
            displaySelectedScreen(R.id.menuProfile);
            navigationViewContent.setCheckedItem(R.id.menuProfile);
            editProfile = false;
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawerLayoutContent = findViewById(R.id.drawerLayoutContent);
        if (drawerLayoutContent.isDrawerOpen(GravityCompat.START)) {
            drawerLayoutContent.closeDrawer(GravityCompat.START);
        } else {

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.content_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        displaySelectedScreen(item.getItemId());
        return true;
    }

    public void displaySelectedScreen(int itemID) {
        //creating fragment object
        Fragment fragment = null;

        //initializing the fragment object which is selected
        switch (itemID) {
            case R.id.menuProfile:
                fragment = new ProfileFragment();
                break;
            case R.id.menuScheduler:
                fragment = new SchedulerFragment();
                break;
            case R.id.menuLogout:
                Intent i8 = new Intent(ContentMainActivity.this, MainActivity.class);
                startActivity(i8);
                break;
            case R.id.menuAbout:
                fragment = new AboutFragment();
                break;
            case R.id.menuCourse:
                fragment = new CourseContentFragment();
                break;
            case R.id.menuProgress:
                fragment = new ProgressFragment();
                break;
        }

        //replacing the fragment
        if (fragment != null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.frameLayoutContent, fragment);
            ft.commit();
        }

        DrawerLayout drawer = findViewById(R.id.drawerLayoutContent);
        drawer.closeDrawer(GravityCompat.START);
    }
}
