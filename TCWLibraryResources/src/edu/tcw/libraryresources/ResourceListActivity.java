package edu.tcw.libraryresources;

import edu.tcw.libraryresources.data.Content;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuItem;




/**
 * An activity representing a list of Resouces. This activity
 * has different presentations for handset and tablet-size devices. On
 * handsets, the activity presents a list of items, which when touched,
 * lead to a {@link ResourceDetailActivity} representing
 * item details. On tablets, the activity presents the list of items and
 * item details side-by-side using two vertical panes.
 * <p>
 * The activity makes heavy use of fragments. The list of items is a
 * {@link ResourceListFragment} and the item details
 * (if present) is a {@link ResourceDetailFragment}.
 * <p>
 * This activity also implements the required
 * {@link ResourceListFragment.Callbacks} interface
 * to listen for item selections.
 */
public class ResourceListActivity extends FragmentActivity
        implements ResourceListFragment.Callbacks {

    /**
     * Whether or not the activity is in two-pane mode, i.e. running on a tablet
     * device.
     */
    private boolean mTwoPane;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resource_list);

        if (findViewById(R.id.resource_detail_container) != null) {
            // The detail container view will be present only in the
            // large-screen layouts (res/values-large and
            // res/values-sw600dp). If this view is present, then the
            // activity should be in two-pane mode.
            mTwoPane = true;

            // In two-pane mode, list items should be given the
            // 'activated' state when touched.
            ((ResourceListFragment) getSupportFragmentManager()
                    .findFragmentById(R.id.resource_list))
                    .setActivateOnItemClick(true);
        }

        // TODO: If exposing deep links into your app, handle intents here.
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
    	if(mTwoPane){
    		menu.add(Menu.NONE, 1423, Menu.NONE, "Load in browser");
    	}
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == 1423 && ids != null){
        	String url = Content.ITEM_MAP.get(ids).mUrl;
        	Intent i = new Intent(Intent.ACTION_VIEW);
        	i.setData(Uri.parse(url));
        	startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }
    private String ids;
    /**
     * Callback method from {@link ResourceListFragment.Callbacks}
     * indicating that the item with the given ID was selected.
     */
    @Override
    public void onItemSelected(String id) {
    	ids = id;
        if (mTwoPane) {
            // In two-pane mode, show the detail view in this activity by
            // adding or replacing the detail fragment using a
            // fragment transaction.
            Bundle arguments = new Bundle();
            arguments.putString(ResourceDetailFragment.ARG_ITEM_ID, id);
            ResourceDetailFragment fragment = new ResourceDetailFragment();
            fragment.setArguments(arguments);
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.resource_detail_container, fragment)
                    .commit();

        } else {
            // In single-pane mode, simply start the detail activity
            // for the selected item ID.
            Intent detailIntent = new Intent(this, ResourceDetailActivity.class);
            detailIntent.putExtra(ResourceDetailFragment.ARG_ITEM_ID, id);
            startActivity(detailIntent);
        }
    }
}
