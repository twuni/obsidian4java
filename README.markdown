Obsidian Portal API for Java
============================

Integration with Obsidian Portal via this API involves the following steps:

1. [Register your application](http://www.obsidianportal.com/oauth_clients/new).
2. Create a class that implements the TokenRepository interface and knows how to persist tokens to your application. Ideally, this talks to your database somehow, but for testing you can just store them in memory by throwing all the tokens into a couple of Maps.
3. Create an instance of ObsidianClientFactory, using the consumer key and consumer secret provided to you when you registered your application and the TokenRepository you implemented in step 2.
4. Once per request or session, get a client from the client factory you instantiated in step 3 and use that to get an instance of the desired service from WebServiceFactory. Those services are now wired up and ready to use.

That's it! Now you're ready to start pretending you have a native Obsidian Portal sitting on your desktop.

Sample Code
-----------

**Reference TokenRepository Implementation:**
This is a basic implementation that stores tokens in memory. New tokens are required every time the application is restarted.

	public class SimpleTokenRepository implements TokenRepository {
	
		private final Map<String, RequestToken> requestTokens = new HashMap<String, RequestToken>();
		private final Map<String, AccessToken> accessTokens = new HashMap<String, AccessToken>();
	
		public AccessToken getAccessToken( String key ) {
			return accessTokens.get( key );
		}
	
		public RequestToken getRequestToken( String key ) {
			return requestTokens.get( key );
		}
	
		public void setAccessToken( String key, AccessToken value ) {
			accessTokens.put( key, value );
		}
	
		public void setRequestToken( String key, RequestToken value ) {
			requestTokens.put( key, value );
		}
	
	}
	
**Accessing the User API:**
This is a very crude, standalone servlet capable of accessing the User API.

    public class UserServlet extends HttpServlet {

        private static final String CUSTOMER_KEY = "<your API key>";
        private static final String CUSTOMER_SECRET = "<your API secret>";
    
        private final ObsidianClientFactory clientFactory;
    
        public UserServlet() {
            TokenRepository tokenRepository = new SimpleTokenRepository();
            clientFactory = new ObsidianClientFactory( CUSTOMER_KEY, CUSTOMER_SECRET, tokenRepository );
        }

        @Override
        public void doGet( HttpServletRequest request, HttpServletResponse ) throws IOException {
        
            String userId = request.getParameter( "userId" );
            String verifier = request.getParameter( "verifier" );

            URL callbackUrl = new URL( request.getRequestURL().toString() );
            ObsidianClient client = null;
            
            if( verifier != null ) {
            	client = clientFactory.createInstance( userId, verifier );
            } else {
            	try {
	            	client = clientFactory.createInstance( userId, callbackUrl );
	            } catch( AuthorizationRequiredException exception ) {
	                response.sendRedirect( exception.getAuthorizationUrl() );
	                return;
	            }
            }

            UserService userService = WebServiceFactory.createUserService( client );
            User user = userService.getCurrentUser();

            response.getWriter().println( user.toString() );
            response.getWriter().flush();
            response.getWriter().close();
        
        }

    }

Disclaimer
----------

Both this library and the Obsidian Portal API itself are still very unstable, so use at your own risk!
