import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v4.content.FileProvider;
import android.util.Log;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.Target;

import java.io.File;

public class SharePic extends AsyncTask<String, Void, File> {
    Context context;

   public SharePic(Context context) {
        this.context = context;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected File doInBackground(String... strings) {
        String picURL = strings[0];
        try {
            return Glide.with(context)
                    .load(picURL)
                    .downloadOnly(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL)
                    .get();
        } catch (Exception ex) {
            Log.d("SHARE", "Sharing failed", ex);
            return null;
        }
    }

    @Override
    protected void onPostExecute(File file) {
        super.onPostExecute(file);
        if (file == null) {
            return;
        }
        Uri uri = FileProvider.getUriForFile(context, "fileprovider-authority", file);
        share(uri);

    }

    private void share(Uri uri) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("image/*");
        intent.putExtra(Intent.EXTRA_STREAM, uri);
        intent.putExtra(Intent.EXTRA_TEXT, "Your text here");
        intent.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        intent.setFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
        context.startActivity(Intent.createChooser(intent, "Share image"));
    }

    private void facebookShare(){

    }
}
