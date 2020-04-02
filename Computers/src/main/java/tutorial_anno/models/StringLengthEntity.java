package tutorial_anno.models;

import tutorial_anno.annotations.Length;

public class StringLengthEntity {
    @Length(min = 5, max = 10)
    private String firstString;

    public String getFirstString() {
        return firstString;
    }

    public void setFirstString(String firstString) {
        this.firstString = firstString;
    }

    @Override
    public String toString() {
        return "StringLengthEntity{" +
                "firstString='" + firstString + '\'' +
                '}';
    }
}
