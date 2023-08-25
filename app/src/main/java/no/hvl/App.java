package no.hvl;

import io.javalin.Javalin;
import io.javalin.http.Context;

public class App {

    private static final String WEBPAGE = "<!DOCTYPE html>\n" +
            "<html lang=\"en\">\n" +
            "<head>\n" +
            "    <meta charset=\"UTF-8\">\n" +
            "    <title>Convert units</title>\n" +
            "</head>\n" +
            "<body>\n" +
            "<h1>Unit converter</h1>\n" +
            "<form action=\"/convert\" method=\"post\">\n" +
            "    <fieldset>\n" +
            "    <label for=\"val\">Value:</label>" +
            "    <input id=\"val\" type=\"text\" name=\"value\"><br />\n" +
            "    <label for=\"source-unit\">From unit:</label>\n" +
            "    <select name=\"sunit\" id=\"source-unit\">\n" +
            "        <option value=\"in\">Inches</option>\n" +
            "        <option value=\"ft\">Feet</option>\n" +
            "        <option value=\"mi\">Miles</option>\n" +
            "        <option value=\"m\">Metres</option>\n" +
            "    </select><br />\n" +
            "    <label for=\"target-unit\">To unit:</label>\n" +
            "    <select name=\"tunit\" id=\"target-unit\">\n" +
            "        <option value=\"in\">Inches</option>\n" +
            "        <option value=\"ft\">Feet</option>\n" +
            "        <option value=\"mi\">Miles</option>\n" +
            "        <option value=\"m\">Metres</option>\n" +
            "    </select><br />\n" +
            "    <input type=\"submit\" value=\"Calculate\" />\n" +
            "    </fieldset>\n" +
            "</form>\n" +
            "</body>\n" +
            "</html>";

    private static final double IN_TO_METER = 0.0254;
    private static final double FT_TO_METER = 0.3048;
    private static final double MI_TO_METER = 1609.344;

    public static void main(String[] args) {
        Javalin app = Javalin.create().start(9000);

        app.get("/", ctx -> {
            ctx.html(WEBPAGE);
        });

        app.post("/convert", App::UnitConversionHandler);
    }

    /**
     * Handles the unit conversion request.
     * Retrieves the params from the request and calls the methods needed
     * to convert the units.
     * @param ctx
     */
    private static void UnitConversionHandler(Context ctx) {
        double value = Double.parseDouble(ctx.formParam("value"));
        String fromUnit = ctx.formParam("sunit");
        String toUnit = ctx.formParam("tunit");

        double inMeters = convertFromUnitToMeters(value, fromUnit);
        double result = convertToUnitFromMeters(inMeters, toUnit);

        ctx.result(Double.toString(result));
    }

    /**
     * Converts the input value from the given unit to meters. 
     * Accepts "in" "ft", "mi" and "m". 
     * If the fromUnit is anything else than "ft", "mi" or "m", return value is Double.NaN.
     * @param inputValue
     * @param fromUnit
     * @return the converted value in meters
     */
    public static double convertFromUnitToMeters(double inputValue, String fromUnit) {
        if (fromUnit.equals("in")) {
            return inputValue * IN_TO_METER;
        } else if (fromUnit.equals("ft")) {
            return inputValue * FT_TO_METER;
        } else if (fromUnit.equals("mi")) {
            return inputValue * MI_TO_METER;
        } else if (fromUnit.equals("m")) {
            return inputValue;
        } else {
            return Double.NaN;
        }
    }

    /**
     * Converts the input value from meters to the given unit. 
     * Accepts "in", "ft", "mi" and "m".
     * If the toUnit is anything else than "ft", "mi" or "m", return value is Double.NaN.
     * @param inMeters
     * @param toUnit
     * @return
     */
    public static double convertToUnitFromMeters(double inMeters, String toUnit) {
        if (toUnit.equals("in")) {
            return inMeters / IN_TO_METER;
        } else if (toUnit.equals("ft")) {
            return inMeters / FT_TO_METER;
        } else if (toUnit.equals("mi")) {
            return inMeters / MI_TO_METER;
        } else if (toUnit.equals("m")) {
            return inMeters;
        } else {
            return Double.NaN;
        }
    }
}
