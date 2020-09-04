#include <stdio.h>
#include <string.h>
#include <curl/curl.h>
int main(int argc, char *argv[]){
    CURL *curl;
    CURLcode res;
    curl = curl_easy_init();
    if(curl) {
        curl_easy_setopt(curl, CURLOPT_CUSTOMREQUEST, "POST");
        curl_easy_setopt(curl, CURLOPT_URL, "https://tpcg1.tutorialspoint.com/tpcg.php");
        curl_easy_setopt(curl, CURLOPT_FOLLOWLOCATION, 1L);
        curl_easy_setopt(curl, CURLOPT_DEFAULT_PROTOCOL, "https");
        struct curl_slist *headers = NULL;
        headers = curl_slist_append(headers, "Connection: keep-alive");
        headers = curl_slist_append(headers, "Accept: */*");
        headers = curl_slist_append(headers, "User-Agent: Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/84.0.4147.135 Safari/537.36");
        headers = curl_slist_append(headers, "Content-Type: application/x-www-form-urlencoded; charset=UTF-8");
        headers = curl_slist_append(headers, "Origin: https://www.tutorialspoint.com");
        headers = curl_slist_append(headers, "Sec-Fetch-Site: same-site");
        headers = curl_slist_append(headers, "Sec-Fetch-Mode: cors");
        headers = curl_slist_append(headers, "Sec-Fetch-Dest: empty");
        headers = curl_slist_append(headers, "Referer: https://www.tutorialspoint.com/compile_cpp_online.php");
        headers = curl_slist_append(headers, "Accept-Language: en-US,en;q=0.9,vi;q=0.8");
        headers = curl_slist_append(headers, "Cookie: PHPSESSID=mlh0bjj29nbiqhn87o9okke1q4");
        curl_easy_setopt(curl, CURLOPT_HTTPHEADER, headers);
        const char *data = "lang=cpp&device=&code=%23include+%3Ciostream%3E%0D%0A%0D%0Ausing+namespace+std%3B%0D%0A%0D%0Aint+main()%0D%0A%7B%0D%0A+++cout+%3C%3C+%22Hello+World%22+%3C%3C+endl%3B+%0D%0A+++%0D%0A+++return+0%3B%0D%0A%7D&stdinput=&ext=cpp&compile=g%2B%2B+-o+main+*.cpp&execute=main&mainfile=main.cpp&uid=2579845";
        curl_easy_setopt(curl, CURLOPT_POSTFIELDS, data);
        res = curl_easy_perform(curl);
    }
    curl_easy_cleanup(curl);
    return (int)res;
}