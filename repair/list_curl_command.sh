# jdoodle.com
curl 'https://www.jdoodle.com/engine/execute' \
  -H 'x-requested-with: XMLHttpRequest' \
  -H 'content-type: application/json' \
  -H 'referer: https://www.jdoodle.com/c-online-compiler/' \
  --data-binary '{"script":"print(\"Hello\")","args":null,"stdin":null,"language":"python3","libs":[],"versionIndex":3}' \
  --compressed

# tutorialspoint.com
# curl 'https://tpcg1.tutorialspoint.com/tpcg.php' \
#   -H 'Connection: keep-alive' \
#   -H 'Accept: */*' \
#   -H 'User-Agent: Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/84.0.4147.135 Safari/537.36' \
#   -H 'Content-Type: application/x-www-form-urlencoded; charset=UTF-8' \
#   -H 'Origin: https://www.tutorialspoint.com' \
#   -H 'Sec-Fetch-Site: same-site' \
#   -H 'Sec-Fetch-Mode: cors' \
#   -H 'Sec-Fetch-Dest: empty' \
#   -H 'Referer: https://www.tutorialspoint.com/compile_cpp_online.php' \
#   -H 'Accept-Language: en-US,en;q=0.9,vi;q=0.8' \
#   --data-raw 'lang=cpp&device=&code=%23include+%3Ciostream%3E%0D%0A%0D%0Ausing+namespace+std%3B%0D%0A%0D%0Aint+main()%0D%0A%7B%0D%0A+++cout+%3C%3C+%22Hello+World%22+%3C%3C+endl%3B+%0D%0A+++%0D%0A+++return+0%3B%0D%0A%7D&stdinput=&ext=cpp&compile=g%2B%2B+-o+main+*.cpp&execute=main&mainfile=main.cpp&uid=2579845' \
#   --compressed
# rextester
# curl --location --request POST 'https://rextester.com/rundotnet/Run' \
# --data-raw 'LanguageChoiceWrapper=6&EditorChoiceWrapper=1&LayoutChoiceWrapper=2&Program=%2F%2Fgcc+7.4.0%0D%0A%0D%0A%23include++%3Cstdio.h%3E%0D%0A%0D%0Aint+main(void)%0D%0A%7B%0D%0A++++printf(%22Hello%2C+world!%5Cn%22)%3B%0D%0A++++return+0%3B%0D%0A%7D&CompilerArgs=-Wall+-std%3Dgnu99+-O2+-o+a.out+source_file.c&Input=&ShowWarnings=false&Privacy=&PrivacyUsers=&Title=&SavedOutput=&WholeError=&WholeWarning=&StatsToSave=&CodeGuid=&IsInEditMode=False&IsLive=False'