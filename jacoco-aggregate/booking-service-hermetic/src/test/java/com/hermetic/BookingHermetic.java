package com.hermetic;

import com.booking.BookCab;
import org.junit.Test;

public class BookingHermetic {

    BookCab bookCab = new BookCab();

    @Test
    public void test1(){
        bookCab.cancelRide();
    }

}
