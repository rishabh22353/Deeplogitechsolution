 
 
 public class TimesStories {
 
 public JSONArray generateStories() {
 
		URI uri = new URI("http://10.23.34.45/getTimeStories");
		URL  url = uri.toURL ();  
		URLConnection connection = url.openConnection();  
		HttpsURLConnection con = (HttpsURLConnection) connection; 
		
		con.setRequestMethod( "GET" );
		con.setDoInput(true);
		con.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream (con.getOutputStream());
		
		int iStatusCode = con.getResponseCode();
		
		InputStream is = null;
		String strJSONResponse="";
		JSONArray jsonArray = null;
		
		if(iStatusCode==200){

			is = con.getInputStream();

			strJSONResponse = IOUtils.toString(is);
			
			if(null != strJSONResponse && strJSONResponse.length()>0) {
				JSONObject jsnobject = new JSONObject(strJSONResponse);
				jsonArray = jsnobject.getJSONArray();
				for (int i = 0; i < jsonArray.length(); i++) {
					JSONObject explrObject = jsonArray.getJSONObject(i);
				}
				
			}
		}
	return jsonArray;
 
	}
}
