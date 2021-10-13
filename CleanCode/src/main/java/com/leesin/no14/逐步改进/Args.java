package com.leesin.no14.逐步改进;

import java.text.ParseException;
import java.util.*;

/**
 *
 */
public class Args {
    private String schema;
    private boolean valid = true;
    private Set<Character> unexpectedArguments = new TreeSet<Character>();
    private Map<Character, ArgumentMarshaler> marshalers = new HashMap<>();
    private Set<Character> argsFound = new HashSet<Character>();
    private Iterator<String> currentArgument;
    private char errorArgumentId = '\0';
    private String errorParameter = "TILT";
    private com.leesin.no14.逐步改进.Args.ErrorCode errorCode = com.leesin.no14.逐步改进.Args.ErrorCode.OK;
    private List<String> argsList;

    private enum ErrorCode {
        OK, MISSING_STRING, MISSING_INTEGER, INVALID_INTEGER, UNEXPECTED_ARGUMENT
    }

    public Args(String schema, String[] args) throws ParseException {
        this.schema = schema;
        this.argsList = Arrays.asList(args);
        valid = parse();
    }

    private boolean parse() throws ParseException {
        if (schema.length() == 0 && argsList.size() == 0) {
            return true;
        }
        parseSchema();
        try {
            parseArguments();
        } catch (com.leesin.no14.逐步改进.Args.ArgsException e) {
        }
        return valid;
    }

    private boolean parseSchema() throws ParseException {
        for (String element : schema.split(",")) {

            if (element.length() > 0) {
                String trimmedElement = element.trim();
                parseSchemaElement(trimmedElement);
            }
        }
        return true;
    }

    private void parseSchemaElement(String element) throws ParseException {
        char elementId = element.charAt(0);
        String elementTail = element.substring(1);
        validateSchemaElementId(elementId);
        if (isBooleanSchemaElement(elementTail)) {
            marshalers.put(elementId, new ArgumentMarshaler.BooleanArgumentMarshaler());
        } else if (isStringSchemaElement(elementTail)) {
            marshalers.put(elementId, new ArgumentMarshaler.StringArgumentMarshaler());
        } else if (isIntegerSchemaElement(elementTail)) {
            marshalers.put(elementId, new ArgumentMarshaler.IntegerArgumentMarshaler());
        } else {
            throw new ParseException(
                    String.format("Argument: %c has invalid format: %s.",
                            elementId, elementTail), 0);
        }
    }

    private void validateSchemaElementId(char elementId) throws ParseException {
        if (!Character.isLetter(elementId)) {
            throw new ParseException(
                    "Bad character:" + elementId + "in Args format: " + schema, 0);
        }
    }

    private boolean isStringSchemaElement(String elementTail) {
        return elementTail.equals("*");
    }

    private boolean isBooleanSchemaElement(String elementTail) {
        return elementTail.length() == 0;
    }

    private boolean isIntegerSchemaElement(String elementTail) {
        return elementTail.equals("#");
    }

    private boolean parseArguments() throws com.leesin.no14.逐步改进.Args.ArgsException {
        for (currentArgument = argsList.iterator(); currentArgument.hasNext();) {
            String arg = currentArgument.next();
            parseArgument(arg);
        }
        return true;
    }

    private void parseArgument(String arg) throws com.leesin.no14.逐步改进.Args.ArgsException {
        if (arg.startsWith("-")) {
            parseElements(arg);
        }
    }

    private void parseElements(String arg) throws com.leesin.no14.逐步改进.Args.ArgsException {
        for (int i = 1; i < arg.length(); i++) {
            parseElement(arg.charAt(i));
        }
    }

    private void parseElement(char argChar) throws com.leesin.no14.逐步改进.Args.ArgsException {
        if (setArgument(argChar)) {
            argsFound.add(argChar);
        } else {
            unexpectedArguments.add(argChar);
            errorCode = com.leesin.no14.逐步改进.Args.ErrorCode.UNEXPECTED_ARGUMENT;
            valid = false;
        }
    }

    private boolean setArgument(char argChar) throws com.leesin.no14.逐步改进.Args.ArgsException {
        ArgumentMarshaler m = marshalers.get(argChar);
        if (m == null) {
            return false;
        }

        m.set(currentArgument);

        return true;
    }

    public int cardinality() {
        return argsFound.size();
    }

    public String usage() {
        if (schema.length() > 0) {
            return "-[" + schema + "]";
        } else {
            return "";
        }
    }


    /**
     * <pre>
     * {@code }
     * </pre>
     *
     * @return
     * @throws Exception
     */
    public String errorMessage() throws Exception {
        switch (errorCode) {
            case OK:
                throw new Exception("TILT: Should not get here.");
            case UNEXPECTED_ARGUMENT:
                return unexpectedArgumentMessage();
            case MISSING_STRING:
                return String.format("Could not find string parameter for -%c.",
                        errorArgumentId);


            case INVALID_INTEGER:
                return String.format("Argument -%c expects an integer but was '%s'.",
                        errorArgumentId, errorParameter);
            case MISSING_INTEGER:
                return String.format("Could not find integer parameter for -%c.",
                        errorArgumentId);
        }
        return "";
    }

    private String unexpectedArgumentMessage() {
        StringBuffer message = new StringBuffer("Argument(s) -");
        for (char c : unexpectedArguments) {
            message.append(c);
        }
        message.append(" unexpected.");
        return message.toString();
    }

    private boolean falseIfNull(Boolean b) {
        return b != null && b;
    }

    private int zeroIfNull(Integer i) {
        return i == null ? 0 : i;
    }

    private String blankIfNull(String s) {
        return s == null ? "" : s;
    }

    public String getString(char arg) {
        ArgumentMarshaler am = marshalers.get(arg);
        return am == null ? "" : (String) am.get();
    }

    public int getInt(char arg) {
        ArgumentMarshaler am = marshalers.get(arg);
        return am == null ? 0 : (int) am.get();
    }

    public boolean getBoolean(char arg) {
        ArgumentMarshaler am = marshalers.get(arg);
        boolean b = false;
        try {
            b = am != null && (Boolean) am .get();
        } catch (ClassCastException e) {
            b = false;
        }

        return b;
    }

    public boolean has(char arg) {
        return argsFound.contains(arg);
    }

    public boolean isValid() {
        return valid;
    }

    private static class ArgsException extends Exception {
    }

    private static interface ArgumentMarshaler {

        public abstract void set(Iterator<String> currentArgument) throws ArgsException;
        public abstract Object get();

        static class BooleanArgumentMarshaler implements ArgumentMarshaler {
            private static boolean booleanValue = false;

            @Override
            public void set(Iterator<String> currentArgument) throws ArgsException {
                booleanValue = true;
            }


            @Override
            public Object get() {
                return booleanValue;
            }
        }

        static class StringArgumentMarshaler implements ArgumentMarshaler {
            private static String stringValue;

            @Override
            public void set(Iterator<String> currentArgument) throws ArgsException {
                try {
                    stringValue = currentArgument.next();
                } catch (Exception e) {
                    // errorCode = ErrorCode.MISSING_STRING;
                    throw new ArgsException();

                }
            }

            @Override
            public Object get() {
                return stringValue;
            }
        }

        static class IntegerArgumentMarshaler implements ArgumentMarshaler {
            private static int integerValue;

            @Override
            public void set(Iterator<String> currentArgument) throws ArgsException {
                String parameter = null;
                try {
                    parameter = currentArgument.next();
                    set(parameter);
                } catch (ArgsException e) {
                    throw e;
                }
            }

            public void set(String s) throws ArgsException {
                try {
                    // intvalue = Integer.parseInt(s);
                } catch (NumberFormatException e) {
                    throw new ArgsException();
                }
            }

            @Override
            public Object get() {
                return integerValue;
            }
        }
    }

}




