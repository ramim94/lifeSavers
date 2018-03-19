import android.net.Uri;
import android.support.v4.content.FileProvider;

/**
 * Created by Ramim on 4/4/2017.
 */

public class MyFileProvider extends FileProvider {
    @Override
    public String getType(Uri uri) {
        return "image/png";
    }
}
