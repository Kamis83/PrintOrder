package com.deduplication;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCover {

    @Test
    void showDuplicateCoverFiles() {

        //Given
        Cover cover1 = new Cover("J22_01", 1000, "FC-DHL", "NB-Innen");
        Cover cover2 = new Cover("J22_02", 2000, "FC-DHL", "NB-Innen");
        int sumQuantity = 0;
        //When
        if (cover1.equals(cover2)) {
            sumQuantity = cover1.getQuantity() + cover2.getQuantity();
        }
        //Then
        assertEquals(3000, sumQuantity);
    }

    @Test
    void showDuplicateCoverFilesObverseReverse() {

        //Given
        Cover cover1 = new Cover("J22_01", 1000, "FC-DHL", "NB-Innen");
        Cover cover2 = new Cover("J22_02", 4000, "NB-Innen", "FC-DHL");
        int sumQuantity = 0;

        //When
        if (cover1.equals(cover2)) {
            sumQuantity = cover1.getQuantity() + cover2.getQuantity();
        }
        //Then
        assertEquals(5000, sumQuantity);

    }

    @Test
    void showUnDuplicateFiles() {

        //Given
        Cover cover1 = new Cover("J22_01", 1000, "FC-DHL", "NB-Innen");
        Cover cover2 = new Cover("J22_02", 2000, "FC-DHL", "FC-DHL");
        int sumQuantity = 0;
        //When
        if (cover1.equals(cover2)) {
            sumQuantity = cover1.getQuantity() + cover2.getQuantity();
        }
        //Then
        assertEquals(0, sumQuantity);

    }


}




