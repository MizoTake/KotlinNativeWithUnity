#import <KotlinNativePlugin/KotlinNativePlugin.h>

extern "C" {
    const char* call_platform_name() {
        KNPPlatform *platform = [[KNPPlatform alloc] init];
        NSString *name = platform.name;
        return strdup([name UTF8String]);
    }

    const char* call_platform_api(const char* url) {
        KNPPlatform *platform = [[KNPPlatform alloc] init];
        NSString *response = [platform apiUrl:([NSString stringWithUTF8String:url])];
        return strdup([response UTF8String]);
    }
}
