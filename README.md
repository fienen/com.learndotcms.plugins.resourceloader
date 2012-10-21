Resource Loader Plugin for dotCMS
==================================
Installation
==================================
* Download and extract the plugin package to your {DOTCMS_ROOT}/plugins directory
* Edit conf/plugin.properties and enter the identifier for your server's shared host, if applicable
* Shut down your server ({DOTCMS_ROOT}/bin/shutdown.[sh|bat])
* On your server, run 'ant clean-plugins deploy-plugins'
* Start your server back up ({DOTCMS_ROOT}/bin/startup.[sh|bat])