Resource Loader Plugin for dotCMS
==================================
Installation
==================================
* Download and extract the plugin package to your {DOTCMS_ROOT}/plugins directory
* Edit conf/plugin.properties and enter the identifier for your server's shared host, if applicable
* Shut down your server ({DOTCMS_ROOT}/bin/shutdown.[sh|bat])
* On your server, run 'ant clean-plugins deploy-plugins'
* Start your server back up ({DOTCMS_ROOT}/bin/startup.[sh|bat])

Usage
==================================
* Upload files using the Web Resource file asset type, be sure to give them a resource ID (letters, numbers, dashes only), or use one of the default Google CDN values (angularjs, chromeframe, dojo, extjs, jquery, jqueryui, mootools, prototype, scriptaculous, swfobject, webfont)
* In your template or other Velocity code, use the macro #loadResource(resourceName)
* Optionally, you can set $commentBreaks [true/false] and $htmlDebug [true/false]