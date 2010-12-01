Obsidian Portal API for Java
============================

Integration with Obsidian Portal via this API involves the following steps:

1. Register your application at http://www.obsidianportal.com/oauth_clients/new.
2. Create a new class that extends ObsidianClient, using the consumer key and consumer secret provided to you when you registered your application.
3. Wherever you need it, instantiate your client, then request the desired service from WebServiceFactory.

That's it! Now you're ready to start pretending you have a native Obsidian Portal sitting on your desktop.

Disclaimer
----------

Both this library and the Obsidian Portal API itself are still very unstable, so use at your own risk!

