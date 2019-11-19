#include <iostream>
#include "libnativeWrapper.h"

int main()
{
	std::cout << call_platform_name();
	std::cout << "\n";
	std::cout << call_platform_api("https://raw.githubusercontent.com/MizoTake/KotlinNativeWithUnity/master/Response.txt");
	std::cout << "\n";
}
