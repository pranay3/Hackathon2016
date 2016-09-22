package com.example.pranay.tollmap;

/**
 * Created by pupatel on 9/21/2016.
 */
public class VISAPAYLOAD {
    public static String payMoney = "100.00" ;

    public static final String mVisapayLoad = "{\n" +
            "\t\"HTTPMethod\": \"POST\",\n" +
            "\t\"path\": \"/visadirect/mvisa/v1/merchantpushpayments\",\n" +
            "\t\"payload\": {\n" +
            "\t\t\"acquirerCountryCode\": \"356\",\n" +
            "  \"acquiringBin\": \"408972\",\n" +
            "  \"amount\": "+payMoney+",\n" +
            "  \"businessApplicationId\": \"MP\",\n" +
            "  \"cardAcceptor\": {\n" +
            "    \"address\": {\n" +
            "      \"city\": \"KOLKATA\",\n" +
            "      \"country\": \"IND\"\n" +
            "    },\n" +
            "    \"idCode\": \"CA-IDCode-77765\",\n" +
            "    \"name\": \"Visa Inc. USA-Foster City\"\n" +
            "  },\n" +
            "  \"feeProgramIndicator\": \"123\",\n" +
            "  \"localTransactionDateTime\": \"2016-09-21T14:51:59\",\n" +
            "  \"purchaseIdentifier\": {\n" +
            "    \"referenceNumber\": \"REF_123456789123456789123\",\n" +
            "    \"type\": \"1\"\n" +
            "  },\n" +
            "  \"recipientName\": \"Jasper\",\n" +
            "  \"recipientPrimaryAccountNumber\": \"4123640062698797\",\n" +
            "  \"retrievalReferenceNumber\": \"412770451035\",\n" +
            "  \"secondaryId\": \"123TEST\",\n" +
            "  \"senderAccountNumber\": \"4027290077881587\",\n" +
            "  \"senderName\": \"Jasper\",\n" +
            "  \"senderReference\": \"\",\n" +
            "  \"systemsTraceAuditNumber\": \"451035\",\n" +
            "  \"transactionCurrencyCode\": \"INR\",\n" +
            "  \"transactionIdentifier\": \"381228649430015\"\n" +
            "  \n" +
            "\t}\n" +
            "}\n" ;

}
