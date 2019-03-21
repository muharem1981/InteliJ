package common.setup;

public class AllURLs {

    public static String YouTubeDev = "https://www.youtube.com";
    public static String YouTubeQA = "https://www.youtube.com";
    public static String YouTubeProd = "https://www.youtube.com";
    public static String GoogleDev = "https://www.google.com";
    public static String GoogleQA = "https://www.google.com";
    public static String GoogleProd = "https://www.google.com";
    public static String EvotingDev = "https://www.onlinevote-pit.ch/";
    public static String EvotingQA = "https://www.onlinevote-pit.ch/";
    public static String EvotingProd = "https://www.onlinevote-pit.ch/";
    public static String getProductURL()
    {

        if (System.getProperty("product").equals("YouTube") && System.getProperty("runEnvironment").equals("DEV"))
            return YouTubeDev;
        else if (System.getProperty("product").equals("YouTube") && System.getProperty("runEnvironment").equals("QA"))
            return YouTubeQA;
        else if (System.getProperty("product").equals("YouTube") && System.getProperty("runEnvironment").equals("PROD"))
            return YouTubeProd;


        else if (System.getProperty("product").equals("Google") && System.getProperty("runEnvironment").equals("DEV"))
            return GoogleDev;
        else if (System.getProperty("product").equals("Google") && System.getProperty("runEnvironment").equals("QA"))
            return GoogleQA;
        else if (System.getProperty("product").equals("Google") && System.getProperty("runEnvironment").equals("PROD"))
            return GoogleProd;

        else if (System.getProperty("product").equals("Evoting") && System.getProperty("runEnvironment").equals("DEV"))
            return EvotingDev;
        else if (System.getProperty("product").equals("Evoting") && System.getProperty("runEnvironment").equals("QA"))
            return EvotingQA;
        else if (System.getProperty("product").equals("Evoting") && System.getProperty("runEnvironment").equals("PROD"))
            return EvotingProd;

        else return "Product URL has not been defined";


    }


}
