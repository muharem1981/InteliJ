package util;

import java.beans.XMLEncoder;
import java.io.File;
import java.io.FileInputStream;
import java.util.*;

import cucumber.api.*;
import gherkin.formatter.model.DataTableRow;
import org.apache.commons.io.output.ByteArrayOutputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.*;
import org.joda.time.DateTime;

public class DataHelp {

    public static List<String> storedTexts = Arrays.asList("","","","","","","","","","");
    public static HashMap<String,String> MyMap;

    public static String getTimeStamp(String format)
    {
        String timeStamp = DateTime.now().toString(format);
        return timeStamp;
    }

    public static String prepText(String text)
    {
        try
        {
            String extension = "ext";
            String addition = "add";

            if(text.contains("TimeStamp"))
                text = text.replace("+TimeStamp","-" + getTimeStamp("YYYY-MM-DD-HH-mm-ss-SSS"));

            if(text.contains("+Text"))
            {
                int index = Integer.parseInt(text.replaceAll("\\D+",""));
                text = text.substring(0,text.indexOf("+")) + storedTexts.get(index);
            }
            else if(text.contains("+"))
            {
                extension = text.substring(text.indexOf("+"),text.length());
                text = text.replace(extension,"");
                extension = extension.replace("+","");
            }
            else if(text.contains("+"))
            {
                addition = text.substring(text.indexOf("+"),text.length());
                text = text.replace(addition,"");
            }

            if(text.contains("Text"))
            {
                int index = Integer.parseInt(text.replaceAll("\\D+",""));
                text = storedTexts.get(index);
            }

            if(!(addition.equals("add")))
                text = text + addition;
            if(!(extension.equals("ext")))
                text = text + extension;

            return text;
        }
        catch(Exception ex)
        {System.out.println(ex.toString()); return  ex.toString();}
    }

    public static String storeText(String text, String TextX)
    {
        try
        {
            int index = Integer.parseInt(TextX.replaceAll("\\D+",""));
            storedTexts.set(index,text);
            return "PASS";
        }
        catch(Exception ex)
        {System.out.println(ex.toString()); return  ex.toString();}
    }

    public static String getStoredText(String TextX)
    {
        try
        {
            int index = Integer.parseInt(TextX.replaceAll("\\D+",""));
            return storedTexts.get(index);
        }
        catch(Exception ex)
        {System.out.println(ex.toString()); return  ex.toString();}
    }

    public static String getFileNameExt(String fileName)
    {
        try
        {
            String ext = fileName.substring(fileName.indexOf("."),fileName.length());
            return ext;
        }
        catch(Exception ex)
        {System.out.println(ex.toString()); return  ex.toString();}
    }



    public static HashMap<String,String> dataToMap(DataTable table,int valueColumn)
    {
        HashMap<String,String> verticalMap = new HashMap<>();
        HashMap<String,String> horizontalMap = new HashMap<>();

        for(DataTableRow row : table.getGherkinRows())
        {
            verticalMap.put(row.getCells().get(0),row.getCells().get(valueColumn));
        }

        return verticalMap;
    }

    public static void printMap(HashMap<String,String> map)
    {
        StringBuilder sb = new StringBuilder();
        Iterator<Map.Entry<String,String>> iter = map.entrySet().iterator();

        while(iter.hasNext())
        {
            Map.Entry<String,String> entry = iter.next();
            sb.append(entry.getKey());
            sb.append("=").append('"');
            sb.append(entry.getValue());
            sb.append('"');

            if(iter.hasNext())
                sb.append(',').append(' ');
        }

        System.out.println(sb.toString());
    }

    public static String hashMapToXmlString(HashMap map)
    {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        XMLEncoder xmlEncoder = new XMLEncoder(bos);
        xmlEncoder.writeObject(map);
        xmlEncoder.flush();

        return bos.toString();
    }

    public static  String generateRandomString(int length, String startWith)
    {
        String dateTime = DateTime.now().toString("yyyyMMddHHmmss");
        int randomLength = length - startWith.length();
        int remove = dateTime.length() -randomLength;

        String randomString = dateTime.substring(1,remove);
        randomString = startWith + randomString;
        return randomString;
    }

    public static String generateRandomIntString(int min, int max)
    {
        Random rand = new Random();
        int randomInt = rand.nextInt((max-min)+1)+min;
        String randomIntString = Integer.toString(randomInt);
        return randomIntString;
    }

    public static String getDynamicDate(String dateString , String pattern)
    {
        try
        {
            DateTime newDate = new DateTime();
            dateString = dateString.replace("CurrentDate","");
            if(dateString.contains("+"))
            {
                int offset = Integer.parseInt(dateString.replace("+",""));
                newDate = DateTime.now().plusDays(offset);
            }
            else if(dateString.contains("-"))
            {
                int offset = Integer.parseInt(dateString.replace("-",""));
                newDate = DateTime.now().minusDays(offset);
            }

            return newDate.toString(pattern);
        }
        catch(Exception ex)
        {System.out.println(ex.toString()); return  ex.toString();}
    }


    public static HashMap loadExcelLines(File fileName)
    {
        // Used the LinkedHashMap and LikedList to maintain the order
        HashMap<String, LinkedHashMap<Integer, List>> outerMap = new LinkedHashMap<String, LinkedHashMap<Integer, List>>();

        LinkedHashMap<Integer, List> hashMap = new LinkedHashMap<Integer, List>();

        String sheetName = null;
        // Create an ArrayList to store the data read from excel sheet.
        // List sheetData = new ArrayList();
        FileInputStream fis = null;
        try
        {
            fis = new FileInputStream(fileName);
            // Create an excel workbook from the file system
            XSSFWorkbook workBook = new XSSFWorkbook(fis);
            // Get the first sheet on the workbook.
            for (int i = 0; i < workBook.getNumberOfSheets(); i++)
            {
                XSSFSheet sheet = workBook.getSheetAt(i);
                // XSSFSheet sheet = workBook.getSheetAt(0);
                sheetName = workBook.getSheetName(i);

                Iterator rows = sheet.rowIterator();
                while (rows.hasNext())
                {
                    XSSFRow row = (XSSFRow) rows.next();
                    Iterator cells = row.cellIterator();

                    List data = new LinkedList();
                    while (cells.hasNext())
                    {
                        XSSFCell cell = (XSSFCell) cells.next();
                        cell.setCellType(Cell.CELL_TYPE_STRING);
                        data.add(cell);
                    }
                    hashMap.put(row.getRowNum(), data);

                    // sheetData.add(data);
                }
                outerMap.put(sheetName, hashMap);
                hashMap = new LinkedHashMap<Integer, List>();
            }

        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        finally
        {
            if (fis != null)
            {
                try
                {
                    fis.close();
                }
                catch (Exception ex)
                {
                    ex.printStackTrace();
                }
            }
        }
        return outerMap;
    }


}

