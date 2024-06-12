package com.sca.tools;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class DateToolTest {

    @Test
    public void shouldConvertLocalDateTimeWithZoneToOffsetDateTime() {
        LocalDateTime localDateTime = LocalDateTime.of(2024, 12, 11, 10, 0);
        ZoneId zoneId = ZoneId.of(DateTool.ZONE_ID_BRUSSELS);
        OffsetDateTime expected = ZonedDateTime.of(localDateTime, zoneId).toOffsetDateTime();

        OffsetDateTime offsetDateTime = DateTool.localDateTimeWithZoneToOffsetDateTime(localDateTime, zoneId);
        Assertions.assertThat(offsetDateTime).isEqualTo(expected);
    }

    @Test
    public void shouldConvertLocalDateTimeToOffsetDateTime() {
        LocalDateTime localDateTime = LocalDateTime.of(2024, 12, 11, 10, 0);
        ZoneId zoneId = ZoneId.of(DateTool.ZONE_ID_BRUSSELS);
        OffsetDateTime expected = ZonedDateTime.of(localDateTime, zoneId).toOffsetDateTime();

        OffsetDateTime offsetDateTime = DateTool.localDateTimeBrusselsZoneToOffsetDateTime(localDateTime);
        Assertions.assertThat(offsetDateTime).isEqualTo(expected);
    }
}
