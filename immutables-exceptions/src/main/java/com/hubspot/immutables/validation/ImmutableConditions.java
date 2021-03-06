package com.hubspot.immutables.validation;

import java.util.Optional;

import javax.annotation.Nonnull;

public class ImmutableConditions {

  public static void checkValid(boolean expression, String template, Object... arguments) {
    if (!expression) {
      throw new InvalidImmutableStateException(String.format(template, arguments));
    }
  }

  @Nonnull
  public static <T> T checkNotNull(T ref, String template, Object... arguments) {
    checkValid(ref != null, template, arguments);
    return ref;
  }

  public static <T> T checkPresent(Optional<T> maybe, String template, Object... arguments) {
    checkValid(maybe.isPresent(), template, arguments);
    return maybe.get();
  }
}
