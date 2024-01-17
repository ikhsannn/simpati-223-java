/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simpati223;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Date;
import java.util.Locale;

/**
 *
 * @author Ikhsan Abdillah
 */
public class Fungsi {
    public static String getMd5(String input){
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] messageDigest = md.digest(input.getBytes());
			BigInteger no = new BigInteger(1, messageDigest);
			String hashtext = no.toString(16);
			while (hashtext.length() < 32) {
				hashtext = "0" + hashtext;
			}
			return hashtext;
		}
		catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
    }
    
    public static String getYear(String date){
        String year = date.substring(0, 4);
        
        return year;
    }
    
    public static String getMonthName(String date){
        String month = date.substring(5); // Assuming the month value is 5 (May)

        int monthValue = Integer.parseInt(month);
        
        // Get the month name in full form (e.g., "Mei")
        String monthFullName = Month.of(monthValue).getDisplayName(TextStyle.FULL, new Locale("id", "ID"));
        
        return monthFullName;
    }
    
    public static String getMonthReport(int num_month){
        String month = "";
        switch(num_month){
            case 0:
                month = "01";
            break;
            case 1:
                month = "02";
            break;
            case 2:
                month = "03";
            break;
            case 3:
                month = "04";
            break;
            case 4:
                month = "05";
            break;
            case 5:
                month = "06";
            break;
            case 6:
                month = "07";
            break;
            case 7:
                month = "08";
            break;
            case 8:
                month = "09";
            break;
            case 9:
                month = "10";
            break;
            case 10:
                month = "11";
            break;
            case 11:
                month = "12";
            break;
        }
        return month;
    }
    
    public static String getBulan(String bulan) {
        String[] bulanArray = {
            "January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December"
        };
        int index = Integer.parseInt(bulan) - 1;
        return bulanArray[index];
    }
    
    public static String getDate(String tgl){
        String tanggal = tgl.substring(8, 10);
        String bulan = getBulan(tgl.substring(5, 7));
        String tahun = tgl.substring(0, 4);
        
        String result = tanggal + " " + bulan + " " + tahun;
        return result;
    }
    
    public static String getDayName(String tgl){
        // Parse the date string to a LocalDate object
        LocalDate date = LocalDate.parse(tgl, DateTimeFormatter.ISO_DATE);
        
        // Get the day name in Indonesian
        Locale indonesianLocale = new Locale("id", "ID");
        String dayName = date.getDayOfWeek().getDisplayName(TextStyle.FULL, indonesianLocale);
        
        return dayName;
    }
    
    public static void main(String[] args) {
        String tgl = "2023-04-10";
        System.out.println(getDayName(tgl)); // Output: 13 February 2020
    }
}
