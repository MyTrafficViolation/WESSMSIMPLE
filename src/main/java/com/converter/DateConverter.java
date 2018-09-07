package com.converter;

import org.springframework.core.convert.converter.Converter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/9/29.
 */
public class DateConverter implements Converter<String,Date> {
	
	private static final List<String> formarts = new ArrayList<String>(8);
    static{
        formarts.add("yyyy-MM");
        formarts.add("yyyy-MM-dd");
        formarts.add("yyyy-MM-dd hh:mm");
        formarts.add("yyyy-MM-dd hh:mm:ss");
        formarts.add("yyyy/MM");
        formarts.add("yyyy/MM/dd");
        formarts.add("yyyy/MM/dd hh:mm");
        formarts.add("yyyy/MM/dd hh:mm:ss");
    }
    public Date convert(String source) {
        String value = source.trim();
        if ("".equals(value)) {
            return null;
        }
        if(source.matches("^\\d{4}-\\d{1,2}$")){ 
            return parseDate(source, formarts.get(0));
        }else if(source.matches("^\\d{4}-\\d{1,2}-\\d{1,2}$")){
            return parseDate(source, formarts.get(1));
        }else if(source.matches("^\\d{4}-\\d{1,2}-\\d{1,2} {1}\\d{1,2}:\\d{1,2}$")){
            return parseDate(source, formarts.get(2));
        }else if(source.matches("^\\d{4}-\\d{1,2}-\\d{1,2} {1}\\d{1,2}:\\d{1,2}:\\d{1,2}$")){
            return parseDate(source, formarts.get(3));
        }else {
            //throw new IllegalArgumentException("Invalid boolean value '" + source + "'");
            if(source.matches("^\\d{4}/\\d{1,2}$")){
                return parseDate(source, formarts.get(0));
            }else if(source.matches("^\\d{4}/\\d{1,2}/\\d{1,2}$")){
                return parseDate(source, formarts.get(1));
            }else if(source.matches("^\\d{4}/\\d{1,2}/\\d{1,2} {1}\\d{1,2}:\\d{1,2}$")){
                return parseDate(source, formarts.get(2));
            }else if(source.matches("^\\d{4}/\\d{1,2}/\\d{1,2} {1}\\d{1,2}:\\d{1,2}:\\d{1,2}$")){
                return parseDate(source, formarts.get(3));
            }else {
                throw new IllegalArgumentException("Invalid boolean value '" + source + "'");
            }
        }

    }
    
    /**
     * 功能描述：格式化日期
     * 
     * @param dateStr
     *            String 字符型日期
     * @param format
     *            String 格式
     * @return Date 日期
     */
    public  Date parseDate(String dateStr, String format) {
        Date date=null;
        try {
            DateFormat dateFormat = new SimpleDateFormat(format);
            date = (Date) dateFormat.parse(dateStr);
        } catch (Exception e) {
        }
        return date;
    }

	/*public Date convert(String s) {
		Date date = null;
		try {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			simpleDateFormat.setLenient(false);
			date = simpleDateFormat.parse(s);
		} catch (Exception e) {
			SimpleDateFormat simpleDateFormat2=new SimpleDateFormat("yyyy-MM-dd");
			try {
				date = simpleDateFormat2.parse(s);
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		return date;
	}*/
   
}
