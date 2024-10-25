package me.deepcraft.utils;

public class TimerUtil {

        private long prevMS;

        public TimerUtil() {
            this.prevMS = 0L;
        }

        public TimerUtil(boolean reset) {
            this.prevMS = 0;
            if (reset)
                reset();
        }

        public boolean delay(final double d) {
            return hasReached(d, true);
        }

        public boolean hasReached(final double d) {
            return hasReached(d, false);
        }

        public boolean hasReached(final double d, boolean reset) {
            if (getTimePassed() >= d) {
                if (reset)
                    this.reset();

                return true;
            }
            return false;
        }

        public void reset() {
            this.prevMS = this.getTime();
        }

        public long getTime() {
            return System.nanoTime() / 1000000L;
        }

        public long getPrevMS() {
            return this.prevMS;
        }

        public long getTimePassed() {
            return this.getTime() - this.getPrevMS();
        }

    }
