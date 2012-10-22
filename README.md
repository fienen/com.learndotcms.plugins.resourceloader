Resource Loader Plugin for dotCMS
==================================
Installation
==================================
* Download and extract the plugin package to your {DOTCMS_ROOT}/plugins directory.
* Edit conf/plugin.properties and enter the identifier for your server's shared host, if applicable.
* Edit conf/plugin.properties and change the file asset's structure name and Velocity variable name, if necessary.
* Shut down your server ({DOTCMS_ROOT}/bin/shutdown.[sh|bat]).
* On your server, run 'ant clean-plugins deploy-plugins'.
* Start your server back up ({DOTCMS_ROOT}/bin/startup.[sh|bat]).

Usage
==================================
* Upload files using the Web Resource file asset type, be sure to give them a resource ID (letters, numbers, dashes only). Multiple files can share a Resource ID, and they will all load when the macro is called. Loading is limited to .js, .css, and .vtl files.
* You can use one of the default Google CDN values ( *angularjs*, *chromeframe*, *dojo*, *extjs*, *jquery*, *jqueryui*, *mootools*, *prototype*, *scriptaculous*, *swfobject*, *webfont* ) without having a local copy of the file.
* In your template or other Velocity code, use the macro #loadResource(resourceName)
* Optionally, you can set <code>$resourceCache</code> [int], <code>$commentBreaks</code> [bool], <code>$htmlDebug</code> [bool], <code>$boxCss</code> [bool], <code>$boxCssMinify</code> [bool], <code>$boxCssCache</code> [bool], <code>$boxCssVersion</code> [str], <code>$boxJs</code> [bool], <code>$boxJsDefer</code> [bool], <code>$boxJsAppend</code> [bool], <code>$boxJsMinify</code> [bool], <code>$boxJsCache</code> [bool], <code>$boxJsVersion</code> [int]. See the comments on the macros-ext.vm file for a full explanation of each variable and its purpose.
* Any custom settings will persist over multiple uses of the <code>loadResource()</code> macro, they must be manually reset if you wish to use different settings at different times.
* If you enable <code>$boxJs</code> usage and set <code>$boxJsDefer</code> to true, you must manually place <code><script>box.get();</script></code> on your page where you want the JavaScript to come in at.

Examples
==================================
```
## BASIC EXAMPLE
#loadResource('jquery')
#loadResource('ourPhotoGallery')

## ADVANCED EXAMPLE
#set($boxCss = true)
#set($htmlDebug = true)
#set($resourceCache = 3600)
#loadResource('foundation')
```