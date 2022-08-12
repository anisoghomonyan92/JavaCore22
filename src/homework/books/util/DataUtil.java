package homework.books.util;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DataUtil {
    private static SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
   public static Date stringToDate(String dateStr){
       try{
           return sdf.parse(dateStr);
       }catch (ParseException e){
           System.out.println("Invalid date format");
       }
       return null;

   }

   public static String dateToString(Date date){
       if(date==null){
           return " ";
       }
       return sdf.format(date);
   }



}
