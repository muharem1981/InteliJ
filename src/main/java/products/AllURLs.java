package products;

public class AllURLs {

    public static String YouTubeURL = "https://www.youtube.com";
    public static String GoogleURL = "https://www.google.com";

    public static String getProductURL()
    {

        if (System.getProperty("currentProduct").equals("YouTube"))
            return YouTubeURL;

        else if (System.getProperty("currentProduct").equals("Gogle"))
            return GoogleURL;

        else return "Product URL has not been defined";


    }


}
