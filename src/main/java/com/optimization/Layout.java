package com.optimization;

public record Layout(String imposition,int numberOfPrintFormSets,String kindOfSheetRotation,int printRun) {
    public Layout(String imposition, int numberOfPrintFormSets, String kindOfSheetRotation) {
        this(imposition, numberOfPrintFormSets, kindOfSheetRotation, 0);
    }
}
