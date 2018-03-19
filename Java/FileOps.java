import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;


/**
 * Created by Ramim on 3/19/2018.
 * Easy File operation class such as writing single/multiple images to files.
 */

public class FileOps {
    final String tempImageDirectoryName= Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES)+"/grabity_w/";
    File tempDirectory;

    public FileOps() {
        tempDirectory = new File(tempImageDirectoryName);
        if(!tempDirectory.exists()){
            tempDirectory.mkdirs();
        }
    }

    public String writeImageToFile(Bitmap bitmap) {
        String fileName= tempImageDirectoryName+"g1"+ System.currentTimeMillis()+".jpg";
        if (bitmap!=null){
            FileOutputStream fileStream= null;
                try{
                    fileStream = new FileOutputStream(fileName);
                    bitmap.compress(Bitmap.CompressFormat.JPEG,100,fileStream);
                    fileStream.close();
                }catch (Exception e){
                    e.printStackTrace();
                }

        }else{
            Log.d("fileOP", "bitmap is null");
        }

        return fileName;
    }

    public ArrayList<Bitmap> readImageFromFiles(ArrayList<String> fileNames){
        ArrayList<Bitmap> images=new ArrayList<>();
        for (String eachFile :
                fileNames) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inPreferredConfig = Bitmap.Config.ARGB_8888;
            Bitmap bitmap = BitmapFactory.decodeFile(eachFile, options);
            images.add(bitmap);
        }

        return images;
    }

    public Bitmap readSingleImageFromFile(String filePath){
        Bitmap bitmap=null;
        if (!filePath.isEmpty()){
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inPreferredConfig = Bitmap.Config.ARGB_8888;
            bitmap= BitmapFactory.decodeFile(filePath, options);
        }
        return bitmap;
    }

    public void removeTempDirectory(){
        if (tempDirectory.isDirectory())
        {
            String[] children = tempDirectory.list();
            for (int i = 0; i < children.length; i++)
            {
                new File(tempDirectory, children[i]).delete();
            }
        }

    }

}
