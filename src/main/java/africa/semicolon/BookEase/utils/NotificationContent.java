package africa.semicolon.BookEase.utils;

public class NotificationContent {

    public static String htmlContent(String eventName, String attendee, String date){
        return String.format("<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "    <title>Ticket Reservation Confirmation</title>\n" +
                "<style>\n" +
                        "        body {\n" +
                        "            font-family: Arial, sans-serif;\n" +
                        "            margin: 0;\n" +
                        "            padding: 0;\n" +
                        "            background-color: #f2f2f2;\n" +
                        "        }\n" +
                        "        .container {\n" +
                        "            max-width: 600px;\n" +
                        "            margin: 0 auto;\n" +
                        "            padding: 20px;\n" +
                        "            background-color: #fff;\n" +
                        "            border-radius: 5px;\n" +
                        "            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);\n" +
                        "        }\n" +
                        "        h1 {\n" +
                        "            color: #333;\n" +
                        "        }\n" +
                        "        p {\n" +
                        "            color: #666;\n" +
                        "        }\n" +
                        "        ul {\n" +
                        "            list-style-type: none;\n" +
                        "            padding: 0;\n" +
                        "        }\n" +
                        "        li {\n" +
                        "            margin-bottom: 10px;\n" +
                        "        }\n" +
                        "        strong {\n" +
                        "            color: #000;\n" +
                        "        }\n" +
                        "    </style>"+
                "</head>\n" +
                "<body>\n" +
                "    <h1>Ticket Reservation Confirmation</h1>\n" +
                "    <p>Dear ["+ attendee +"],</p>\n" +
                "    <p>Thank you for reserving a ticket for the event <strong>["+eventName+"]</strong>.</p>\n" +
                "    <p>Below are the details of your ticket reservation:</p>\n" +
                "    <ul>\n" +
                "        <li><strong>Event:</strong> ["+eventName+"]</li>\n" +
                "        <li><strong>Reservation Date:</strong> ["+date+"]</li>\n" +
                "    </ul>\n" +
                "    <p>If you have any questions or need further assistance, please contact us at ["+eventName+".com].</p>\n" +
                "    <p>Thank you and we look forward to seeing you at the event!</p>\n" +
                "</body>\n" +
                "</html>");
    }
}
