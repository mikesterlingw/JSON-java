package org.json;

public class DefaultNumberSerializer extends NumberSerializer {

  /**
   * If it might be a number, try converting it. If a number cannot be
   * produced, then the value will just be a string.
   */
  public Object deserialize(String string) {
    char initial = string.charAt(0);
    if ((initial >= '0' && initial <= '9') || initial == '-') {
      try {
        if (string.indexOf('.') > -1 || string.indexOf('e') > -1
            || string.indexOf('E') > -1
            || "-0".equals(string)) {
          Double d = Double.valueOf(string);
          if (!d.isInfinite() && !d.isNaN()) {
            return d;
          }
        } else {
          Long myLong = new Long(string);
          if (string.equals(myLong.toString())) {
            if (myLong.longValue() == myLong.intValue()) {
              return Integer.valueOf(myLong.intValue());
            }
            return myLong;
          }
        }
      } catch (Exception ignore) {
      }
    }
    return string;
  }

  public String serialize(Number number) {
    return number.toString();
  }
}