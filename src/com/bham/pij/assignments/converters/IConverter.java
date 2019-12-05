package com.bham.pij.assignments.converters;

import java.util.ArrayList;
import java.util.Arrays;

public interface IConverter {

    ArrayList<Character> hexValues = new ArrayList<>(Arrays.asList('0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'));

    String convert(String s);

    boolean isValid(String s);

}
