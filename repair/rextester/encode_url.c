#include <stdio.h>
#include <string.h>
#include <curl/curl.h>

int main() {
    char* source="#include <stdio.h>";
    CURL* curl = curl_easy_init();
    if (curl) {
        printf("%s", curl_easy_escape(curl, source, strlen(source)));
    }
}
