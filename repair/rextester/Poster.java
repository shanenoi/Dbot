import java.io.*;
import okhttp3.*;
public class Poster {
    public static void main(String []args) throws IOException{
        OkHttpClient client = new OkHttpClient().newBuilder()
            .build();
        MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
        RequestBody body = RequestBody.create(mediaType, "LanguageChoiceWrapper=6&EditorChoiceWrapper=1&LayoutChoiceWrapper=2&Program=//gcc+7.4.0#include++<stdio.h>int+main(void){++++printf(\"Hello,+world!\\n\");++++return+0;}&CompilerArgs=-Wall+-std=gnu99+-O2+-o+a.out+source_file.c&Input=&ShowWarnings=false&Privacy=&PrivacyUsers=&Title=&SavedOutput=&WholeError=&WholeWarning=&StatsToSave=&CodeGuid=&IsInEditMode=False&IsLive=False");
        Request request = new Request.Builder()
            .url("https://rextester.com/rundotnet/Run")
            .method("POST", body)
            .addHeader("Content-Type", "application/x-www-form-urlencoded")
            .build();
        Response response = client.newCall(request).execute();
        System.out.println(response.body().string());
    }
}

