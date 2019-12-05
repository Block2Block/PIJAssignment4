package com.bham.pij.assignments.converters;

import java.io.*;
import java.util.ArrayList;

public class Converter {
    public static enum ConvertMode {BIN2HEX, HEX2BIN, BIN2DEC, DEC2BIN};

    private ConvertMode convertMode;
    private ArrayList<String> inputValues;
    private ArrayList<String> outputValues;

    public Converter(ConvertMode cm) {
        this.convertMode = cm;
    }

    public String convert(String s) throws InvalidFormatException {
        String converted = "";
        IConverter converter;
        switch (convertMode) {
            case BIN2DEC:
                converter = new Bin2Dec();
                break;
            case BIN2HEX:
                converter = new Bin2Hex();
                break;
            case HEX2BIN:
                converter = new Hex2Bin();
                break;
            case DEC2BIN:
            default:
                converter = new Dec2Bin();
        }
        if (!converter.isValid(s)) {
            throw new InvalidFormatException();
        }
        return converter.convert(s);
    }

    public void fromFile(String file) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            inputValues = new ArrayList<>();
            outputValues = new ArrayList<>();

            String line = "";

            while ((line = bufferedReader.readLine())!= null) {
                inputValues.add(line);
                outputValues.add(this.convert(line));

            }

        } catch (IOException e) {
            e.printStackTrace();
            inputValues = null;
            outputValues = null;
            return;
        }
    }

    public ArrayList<String> getInputValues() {
        return inputValues;
    }

    public ArrayList<String> getOutputValues() {
        return outputValues;
    }





}


