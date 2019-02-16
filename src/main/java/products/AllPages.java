package products;

import products.YouTube.Pages.HomePage;
import products.YouTube.Pages.SearchPage;

public class AllPages {

    public static String getYouTubeElementSelector(String elementName)
    {
        if(System.getProperty("currentPage").equals("HomePage"))
            return products.YouTube.Pages.HomePage.getElementSelector(elementName);
        if(System.getProperty("currentPage").equals("SearchPage"))
            return products.YouTube.Pages.SearchPage.getElementSelector(elementName);
        else {System.out.println("Page has not been defined in AllPages");
            return "";}
    }

    public static String getGoogleElementSelector(String elementName)
    {
        if(System.getProperty("currentPage").equals("HomePage"))
            return products.Google.Pages.HomePage.getElementSelector(elementName);
        if(System.getProperty("currentPage").equals("SearchPage"))
            return products.Google.Pages.SearchPage.getElementSelector(elementName);
        else {System.out.println("Page has not been defined in AllPages");
            return "";}
    }


}
