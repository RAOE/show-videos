package org.n3r.idworker.strategy;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DayPrefixRandomCodeStrategy extends DefaultRandomCodeStrategy {
    private final String dayFormat;
    private String lastDay;

    public DayPrefixRandomCodeStrategy(String dayFormat) {
        this.dayFormat = dayFormat;
    }

    @Override
    public void init() {
        String day = createDate();
        if (day.equals(lastDay))
            throw new RuntimeException("init failed for day unrolled");

        lastDay = day;

        availableCodes.clear();
        release();

        prefixIndex = Integer.parseInt(lastDay);
        if (tryUsePrefix()) return;

        throw new RuntimeException("prefix is not available " + prefixIndex);
    }

    private String createDate() {
        return new SimpleDateFormat(dayFormat).format(new Date());
    }

    @Override
    public int next() {
        if (!lastDay.equals(createDate())) init();

        return super.next();
    }
}
