package com.deduplication;

import java.util.Objects;

public class Cover {
    String name;
    int quantity;
    String coverObverseFile;
    String coverReverseFile;

    public Cover(String name, int quantity, String coverObverseFile, String coverReverseFile) {
        this.name = name;
        this.quantity = quantity;
        this.coverObverseFile = coverObverseFile;
        this.coverReverseFile = coverReverseFile;

    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getCoverObverseFile() {
        return coverObverseFile;
    }

    public String getCoverReverseFile() {
        return coverReverseFile;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cover cover = (Cover) o;
        return coverObverseFile.equals(cover.coverObverseFile) && coverReverseFile.equals(cover.coverReverseFile)
                || coverObverseFile.equals(cover.coverReverseFile) && coverReverseFile.equals(cover.getCoverObverseFile());
    }

    @Override
    public int hashCode() {
        return Objects.hash(coverObverseFile, coverReverseFile);
    }
}
