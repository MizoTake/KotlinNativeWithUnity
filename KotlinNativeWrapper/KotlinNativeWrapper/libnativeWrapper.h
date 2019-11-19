#pragma once

extern "C" {

	__declspec(dllexport) const char* call_platform_name();
	__declspec(dllexport) const char* call_platform_api(const char* url);

}
