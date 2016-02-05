package org.json;

public abstract class NumberSerializer {
  abstract String serialize(Number number);

  abstract Object deserialize(String string);
}