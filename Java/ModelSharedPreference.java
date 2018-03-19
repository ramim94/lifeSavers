import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Ramim on 7/13/2017.
 * Model SharedPreferences class for ease of read/write
 */

public class ModelSharedPreference {
    private SharedPreferences masterPref;
   
    private String division;
    private boolean isUploading;
    private int childCount;

  

    public ModelSharedPreference(Context context) {
        masterPref=context.getSharedPreferences("com.ideabinbd.trafficmama.utils.UserPrefs",context.MODE_PRIVATE);

    }


    public void setDivision(String division) {
      SharedPreferences.Editor editor= masterPref.edit();
        editor.putString("division", division);
        editor.apply();
    }
	
	public void setChildCount(int childCount) {
        SharedPreferences.Editor editor= masterPref.edit();
        editor.putInt("childCount", childCount);
        editor.apply();
    }
	 public void setUploading(boolean uploading) {
        SharedPreferences.Editor editor= masterPref.edit();
        editor.putBoolean("IsUploading", uploading);
        editor.apply();
    }
	
	public boolean isUploading() {
        return masterPref.getBoolean("IsUploading",false);
    }
	
	public String getDivision() {
        return masterPref.getString("division",false);
    }
	
	public int getChildCount() {
        return masterPref.getInt("childCount",0);
    }
	

   


}
