//
//  KotlinNativeWrapperTest.m
//  KotlinNativeWrapperTest
//
//  Created by MizoTake on 2019/11/10.
//  Copyright © 2019 MizoTake. All rights reserved.
//

#import <XCTest/XCTest.h>
//#include <iostream>
#include "libnativeWrapper.h"

@interface KotlinNativeWrapperTest : XCTestCase

@end

@implementation KotlinNativeWrapperTest

- (void)setUp {
    // Put setup code here. This method is called before the invocation of each test method in the class.
}

- (void)tearDown {
    // Put teardown code here. This method is called after the invocation of each test method in the class.
}

- (void)testExample {
    // This is an example of a functional test case.
    // Use XCTAssert and related functions to verify your tests produce the correct results.
    const char* str = call_platform_name();
    printf("call libnative: %s \n", str);
    
    const char* res = call_platform_api("https://raw.githubusercontent.com/MizoTake/KotlinNativeWithUnity/master/Response.txt");
    printf("call platform api: %s \n", res);
    
}

- (void)testPerformanceExample {
    // This is an example of a performance test case.
    [self measureBlock:^{
        // Put the code you want to measure the time of here.
    
    }];
}

@end
