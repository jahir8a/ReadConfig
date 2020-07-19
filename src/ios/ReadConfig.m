/********* ReadConfig.m Cordova Plugin Implementation *******/

#import <Cordova/CDV.h>

@interface ReadConfig : CDVPlugin {
  // Member variables go here.
}

- (void)obtenerValorConfig:(CDVInvokedUrlCommand*)command;
@end

@implementation ReadConfig

- (void)obtenerValorConfig:(CDVInvokedUrlCommand*)command
{
    CDVPluginResult* pluginResult = nil;
    NSString* echo = [[command.arguments objectAtIndex:0] valueForKey:@"key"];

    if (echo != nil && echo == "keyApp") {
        NSString* paramValue = [[[NSBundle mainBundle] infoDictionary] valueForKey:echo];
        if(paramValue == nil)
            paramValue = @"";
        pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK messageAsString:paramValue];
    } else {
        pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_ERROR];
    }

    [self.commandDelegate sendPluginResult:pluginResult callbackId:command.callbackId];
}

@end
