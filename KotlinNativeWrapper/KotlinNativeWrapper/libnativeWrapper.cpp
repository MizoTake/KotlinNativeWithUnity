#include <cstring>
#include <stdlib.h>
#include "libnative_api.h"
#include "libnativeWrapper.h"

extern "C" {
	__declspec(dllexport) const char* call_platform_name() {
		libnative_ExportedSymbols* lib = libnative_symbols();
		auto platform = lib->kotlin.root.sample.Platform.Platform();
		const char* str = lib->kotlin.root.sample.Platform.get_name(platform);
		char* ret = (char*)malloc(strlen(str) * 4);
		strcpy(ret, str);
		return ret;
	}

	__declspec(dllexport) const char* call_platform_api(const char* url) {
		libnative_ExportedSymbols* lib = libnative_symbols();
		auto platform = lib->kotlin.root.sample.Platform.Platform();
		const char* res = lib->kotlin.root.sample.Platform.api(platform, url);
		char* ret = (char*)malloc(strlen(res) * 4);
		strcpy(ret, res);
		return ret;
	}
}