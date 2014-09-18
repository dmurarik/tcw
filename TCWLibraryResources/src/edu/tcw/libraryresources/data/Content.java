package edu.tcw.libraryresources.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.tcw.libraryresources.R;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class Content {

    /**
     * An array of sample (dummy) items.
     */
    public static List<ResourceItem> ITEMS = new ArrayList<ResourceItem>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static Map<String, ResourceItem> ITEM_MAP = new HashMap<String, ResourceItem>();

    static {
    	
        addItem(new ResourceItem("What's New?", R.drawable.book_library, "https://docs.google.com/document/d/1dxYLWICgWkMkfXuHN1CbdGcJ6i9w_daQTS7Ml9xiw6Y/edit?usp=sharing"));
        addItem(new ResourceItem("Databases", R.drawable.databases, "https://acps.blackboard.com/bbcswebdav/library/T.C.%20Williams/databases/library-database-logo-links.html"));
        addItem(new ResourceItem("NoodleTools", R.drawable.noodle_tools, "http://www.noodletools.com/simplesaml/module.php/core/loginuserpass.php?loginerror=&AuthState=_764c74a4210a2ae12f21fbc0fae055a1af0a15079d%3Ahttp%3A%2F%2Fwww.noodletools.com%2Fsimplesaml%2Fmodule.php%2Fcore%2Fas_login.php%3FAuthId%3Dnoodletools-sql-auth%26ReturnTo%3Dhttp%253A%252F%252Fwww.noodletools.com%252Fsimplesaml%252Fmodule.php%252Fcore%252Fpostredirect.php%253FRedirId%253D_82b806db48be2ee9fc6a506700f3f21220944443a4&ipAuthentication=0&loginScreenShowName=&bookmarklet="));
        addItem(new ResourceItem("Research Guides", R.drawable.research_guidelines, "http://www.acpsk12.org/pathfinders/"));
        addItem(new ResourceItem("Research Process", R.drawable.research_process, "https://acps.blackboard.com/bbcswebdav/pid-603231-dt-content-rid-122842_5/library/T.C.%20Williams/Research/index.html"));
        addItem(new ResourceItem("TCW Library Catalog", R.drawable.catalog, "https://tcwilliams.goalexandria.com/researcher#_"));
    }

    private static void addItem(ResourceItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.mId, item);
    }

    /**
     * A dummy item representing a piece of content.
     */
    public static class ResourceItem {
        public String mId;
        public String mName;
        public int mImageResource;
        public String mUrl;

        public ResourceItem(String id, int imageResource, String url) {
            mId = id;
            mName = id;
            mImageResource = imageResource;
            mUrl = url;
        }

        @Override
        public String toString() {
            return mUrl;
        }
    }
}
