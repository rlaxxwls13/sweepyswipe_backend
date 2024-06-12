package hufs.sweepyswipe.Dto;

import lombok.Getter;
import lombok.Setter;

import java.time.DayOfWeek;
import java.time.LocalTime;

@Getter @Setter
public class AlarmSettingsDto {
    private boolean enabled;
    private DayOfWeek dayOfWeek;
    private LocalTime time;
}
