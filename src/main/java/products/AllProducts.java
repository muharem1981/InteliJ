package products;

import static products.AllPages.*;

public class AllProducts {

    public static String getElementSelector(String elementName)
    {
        if(System.getProperty("currentProduct").equals("YouTube"))
            return getYouTubeElementSelector(elementName);
        else if(System.getProperty("currentProduct").equals("Google"))
            return getGoogleElementSelector(elementName);
        else {System.out.println("Product has not been defined in AllProducts");
            return "";}
    }



}
