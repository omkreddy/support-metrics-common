package io.confluent.support.metrics.common.time;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TimeUtilsTest {

  private class FixedClock implements Clock {

    private final long fixedTimeMs;

    public FixedClock(long fixedTimeMs) {
      this.fixedTimeMs = fixedTimeMs;
    }

    @Override
    public long currentTimeMs() {
      return fixedTimeMs;
    }

  }

  @Test
  public void returnsCurrentUnixTime() {
    // Given
    long expCurrentUnixTime = 12345678L;
    TimeUtils tu = new TimeUtils(new FixedClock(expCurrentUnixTime * 1000));

    // When/Then
    assertThat(tu.nowInUnixTime()).isEqualTo(expCurrentUnixTime);
  }

}