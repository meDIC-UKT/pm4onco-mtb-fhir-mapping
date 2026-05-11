package de.ukt.medic.fhir.profiling;


import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.YearMonth;
import java.time.ZoneId;
import java.util.Date;



/**
 * Utility class for converting between java.time.* and java.util.Date types.
 *
 * <p>This class serves as an "anti-corruption layer" for the fact that HAPI-FHIR
 * requires the use of the legacy java.util.Date class, while modern Java code
 * should use the java.time.* API introduced in Java 8. These utility methods
 * bridge the gap between the two APIs.</p>
 *
 * <p>All conversions use the system default time zone, which is appropriate for
 * most healthcare applications where dates and times are assumed to be in the
 * local time zone of the healthcare facility.</p>
 *
 * <p>This class cannot be instantiated as it only provides static utility methods.</p>
 */
public abstract class Util
{

  /**
   * Private constructor to prevent instantiation of this utility class.
   */
  private Util(){}


  /**
   * Converts a LocalDate to a java.util.Date.
   *
   * <p>The resulting Date represents the start of the day (00:00:00) in the
   * system default time zone.</p>
   *
   * @param d the LocalDate to convert
   * @return a Date representing the start of the given date
   */
  public static Date toDate(LocalDate d){
    return Date.from(
      d.atStartOfDay(ZoneId.systemDefault()).toInstant()
    );
  }


  /**
   * Converts a LocalDateTime to a java.util.Date.
   *
   * <p>The resulting Date represents the same instant in time as the LocalDateTime,
   * interpreted in the system default time zone.</p>
   *
   * @param dt the LocalDateTime to convert
   * @return a Date representing the same instant in time
   */
  public static Date toDate(LocalDateTime dt){
    return Date.from(
      dt.atZone(ZoneId.systemDefault()).toInstant()
    );
  }


  /**
   * Converts a YearMonth to a java.util.Date.
   *
   * <p>The resulting Date represents the first day of the given month at 00:00:00
   * in the system default time zone.</p>
   *
   * @param ym the YearMonth to convert
   * @return a Date representing the start of the first day of the given month
   */
  public static Date toDate(YearMonth ym){
    return toDate(ym.atDay(1));
  }


  /**
   * Converts an Instant to a java.util.Date.
   *
   * <p>This method is not strictly needed given Date.from(Instant), but is
   * included to maintain consistency by allowing code to use Util.toDate()
   * for all date conversions.</p>
   *
   * @param t the Instant to convert
   * @return a Date representing the same instant in time
   */
  public static Date toDate(Instant t){
    return Date.from(t);
  }


  /**
   * Converts a java.util.Date to a LocalDate.
   *
   * <p>The resulting LocalDate represents the date portion of the Date,
   * interpreted in the system default time zone.</p>
   *
   * @param date the Date to convert
   * @return a LocalDate representing the date portion of the given Date
   */
  public static LocalDate localDate(Date date){ 
    return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
  }

  /**
   * Converts a java.util.Date to a YearMonth.
   *
   * <p>The resulting YearMonth represents the year and month portion of the Date,
   * interpreted in the system default time zone.</p>
   *
   * @param date the Date to convert
   * @return a YearMonth representing the year and month of the given Date
   */
  public static YearMonth yearMonth(Date date){ 
    return YearMonth.from(localDate(date));
  }

}
