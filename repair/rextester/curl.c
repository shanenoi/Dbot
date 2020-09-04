#include <stdio.h>
#include <string.h>
#include <curl/curl.h>
int main(int argc, char *argv[]){
    CURL *curl;
    CURLcode res;
    curl = curl_easy_init();
    if(curl) {
        curl_easy_setopt(curl, CURLOPT_CUSTOMREQUEST, "POST");
        curl_easy_setopt(curl, CURLOPT_URL, "https://rextester.com/rundotnet/Run");
        curl_easy_setopt(curl, CURLOPT_FOLLOWLOCATION, 1L);
        curl_easy_setopt(curl, CURLOPT_DEFAULT_PROTOCOL, "https");
        struct curl_slist *headers = NULL;
        headers = curl_slist_append(headers, "Content-Type: application/x-www-form-urlencoded");
        curl_easy_setopt(curl, CURLOPT_HTTPHEADER, headers);
        const char *data = "LanguageChoiceWrapper=6&EditorChoiceWrapper=1&LayoutChoiceWrapper=2&Program=//gcc+7.4.0%0D%0A%0D%0A%23include++%3Cstdio.h%3E%0D%0A%0D%0Aint+main%28void%29%0D%0A%7B%0D%0A++++printf%28%22Hello%2C+world%21%5Cn%22%29%3B%0D%0A++++return+0%3B%0D%0A%7D&CompilerArgs=-Wall+-std%3Dgnu99+-O2+-o+a.out+source_file.c&Input=&ShowWarnings=false&Privacy=&PrivacyUsers=&Title=&SavedOutput=&WholeError=&WholeWarning=&StatsToSave=&CodeGuid=&IsInEditMode=False&IsLive=False";
        curl_easy_setopt(curl, CURLOPT_POSTFIELDS, data);
        res = curl_easy_perform(curl);
    }
    curl_easy_cleanup(curl);
    return (int)res;
}