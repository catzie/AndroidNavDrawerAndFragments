package net.catzie.navdrawertop;

import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.res.Configuration;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import net.catzie.navdrawertop.fragments.AboutFragment;
import net.catzie.navdrawertop.fragments.HomeFragment;
import net.catzie.navdrawertop.fragments.MessagesFragment;

public class MainActivity extends AppCompatActivity {

    DrawerLayout androidDrawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    Toolbar toolbar;
    private MenuItem prevMenuItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initInstancesDrawer();

        /**
         * Default fragment
         */
        if (getSupportActionBar() != null)
        {
            getSupportActionBar().setTitle("Home");
        }

        Bundle bundle = new Bundle();
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.content, HomeFragment.newInstance(bundle))
                .commit();
    }

    private void initInstancesDrawer() {

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        androidDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_design_support_layout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(MainActivity.this, androidDrawerLayout, R.string.app_name, R.string.app_name);
        androidDrawerLayout.setDrawerListener(actionBarDrawerToggle);

        NavigationView navigationView = (NavigationView) findViewById(R.id.navigation_drawer);
        if (navigationView != null) {
            setupDrawerContent(navigationView);
        }

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        /**
         * Set default selected item on Nav Drawer
         */
        navigationView.getMenu().getItem(0).setChecked(true);
    }

    @Override
    public void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        actionBarDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        actionBarDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                androidDrawerLayout.openDrawer(GravityCompat.START);
                return true;

        }
        return super.onOptionsItemSelected(item);
    }


    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        if(prevMenuItem!=null)
                            prevMenuItem.setChecked(false);

                        menuItem.setChecked(true);

                        /**
                         * Fragment Switch
                         */

                        Bundle bundle = new Bundle();
                        String fragmentTitle = null;
                        switch(menuItem.getItemId()){
                            case R.id.navigation_drawer_item1:
                                fragmentTitle = "Home";
                                getSupportFragmentManager()
                                        .beginTransaction()
                                        .replace(R.id.content, HomeFragment.newInstance(bundle))
                                        .commit();
                                break;
                            case R.id.navigation_drawer_item2:
                                fragmentTitle = "Messages";
                                getSupportFragmentManager()
                                        .beginTransaction()
                                        .replace(R.id.content, MessagesFragment.newInstance(bundle))
                                        .commit();
                                break;
                            case R.id.navigation_drawer_item3:
                                fragmentTitle = "About";
                                getSupportFragmentManager()
                                        .beginTransaction()
                                        .replace(R.id.content, AboutFragment.newInstance(bundle))
                                        .commit();
                                break;
                        }

                        if (getSupportActionBar() != null)
                        {
                            getSupportActionBar().setTitle(fragmentTitle);
                        }

                        /**
                         * <<< End Fragment Switch
                         */
//                    Toast.makeText(MainActivity.this, "selected: " + menuItem.getItemId(), Toast.LENGTH_SHORT).show();

                        androidDrawerLayout.closeDrawers();
                        prevMenuItem = menuItem;
                        return true;
                    }
                });
    }
}