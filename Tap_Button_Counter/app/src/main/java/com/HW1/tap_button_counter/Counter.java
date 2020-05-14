package com.HW1.tap_button_counter;

class Counter {
    private int mCount;

    public Counter() {
        mCount = 0;
    }

    public void addCount() {
        mCount++;
    }

    public Integer getCount() {
        return mCount;
    }
}
