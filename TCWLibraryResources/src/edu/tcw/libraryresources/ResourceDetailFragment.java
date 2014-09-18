package edu.tcw.libraryresources;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;


import edu.tcw.libraryresources.data.Content;

/**
 * A fragment representing a single Resource detail screen.
 * This fragment is either contained in a {@link ResourceListActivity}
 * in two-pane mode (on tablets) or a {@link ResourceDetailActivity}
 * on handsets.
 */
public class ResourceDetailFragment extends Fragment {
    /**
     * The fragment argument representing the item ID that this fragment
     * represents.
     */
    public static final String ARG_ITEM_ID = "item_id";

    /**
     * The dummy content this fragment is presenting.
     */
    private Content.ResourceItem mItem;
    private ProgressBar pb;
    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public ResourceDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(ARG_ITEM_ID)) {
            // Load the dummy content specified by the fragment
            // arguments. In a real-world scenario, use a Loader
            // to load content from a content provider.
            mItem = Content.ITEM_MAP.get(getArguments().getString(ARG_ITEM_ID));
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_resource_detail, container, false);

        pb = (ProgressBar) rootView.findViewById(R.id.pbHeaderProgress);
        // Show the dummy content as text in a TextView.
        if (mItem != null) {
        	WebView mWebview = ((WebView) rootView.findViewById(R.id.resource_detail));
    		mWebview.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
    		mWebview.clearCache(true);
    		WebSettings webSettings = mWebview.getSettings();
    		webSettings.setJavaScriptEnabled(true);
    		mWebview.loadUrl(mItem.mUrl);
    		final WebViewClient client = new WebViewClient() {
    			@Override
    			public boolean shouldOverrideUrlLoading(WebView view, String url) {
    				view.loadUrl(url);
    				return true;
    			}

    			@Override
    			public void onPageStarted(WebView view, String url, Bitmap favicon) {
    				view.clearCache(true);
    				super.onPageStarted(view, url, favicon);
    				showloading();
    			}

    			@Override
    			public void onPageFinished(WebView view, String url) {
    				view.clearCache(true);
    				hideLoading();
    				// progressBar.setVisibility(View.GONE);
    			}
    		};
    		mWebview.setWebViewClient(client);
        }

        return rootView;
    }
    
    boolean shown = false;
    public void showloading(){
    	if(!shown)
    		pb.setVisibility(View.VISIBLE);
    	shown = true;
    }
    
    public void hideLoading(){
    	
    	pb.setVisibility(View.GONE);
    	shown = false;
    }
}
