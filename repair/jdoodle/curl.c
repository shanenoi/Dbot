#include <stdio.h>
#include <stdlib.h>

int main() {
	system(
		"curl 'https://www.jdoodle.com/engine/execute' "
  		"-H 'x-requested-with: XMLHttpRequest' "
  		"-H 'content-type: application/json' "
  		"-H 'referer: https://www.jdoodle.com/c-online-compiler/' "
  		"--data-binary '{\"script\":\"print(\\\"Hello\\\")\",\"args\":null,\"stdin\":null,\"language\":\"python3\",\"libs\":[],\"versionIndex\":3}' "
  		"--compressed"
  	);

}