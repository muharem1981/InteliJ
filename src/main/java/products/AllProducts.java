package products;

import static products.AllPages.*;

public class AllProducts {

    public static String getElementSelector(String elementName)
    {
        if(System.getProperty("product").equals("YouTube"))
            return getYouTubeElementSelector(elementName);
        else if(System.getProperty("product").equals("Google"))
            return getGoogleElementSelector(elementName);
        else {System.out.println("Product has not been defined in AllProducts");
            return "";}
    }



}
