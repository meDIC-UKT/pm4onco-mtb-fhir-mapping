package de.ukt.medic.fhir.profiling;


import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.YearMonth;
import java.time.ZoneId;
import java.util.Date;



public abstract class Util
{

  // Private constructor only for use as method object/class
  private Util(){}

  
  public static Date toDate(LocalDate d){
    return Date.from(
      d.atStartOfDay(ZoneId.systemDefault()).toInstant()
    );
  }


  public static Date toDate(LocalDateTime dt){
    return Date.from(
      dt.atZone(ZoneId.systemDefault()).toInstant()
    );
  }


  public static Date toDate(YearMonth ym){
    return toDate(ym.atDay(1));
  }


  // Not strictly needed, given Date.from(Instant),
  // just added to allow keeping code consistent by using Util.toDate(Instant t)
  public static Date toDate(Instant t){
    return Date.from(t);
  }

  
  public static LocalDate localDate(Date date){ 
    return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
  }

  public static YearMonth yearMonth(Date date){ 
    return YearMonth.from(localDate(date));
  }

}
