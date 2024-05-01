package africa.semicolon.BookEase.utils;

public class NotificationContent {

    public static String htmlContent(String eventName, String attendee, String date){
        return String.format("<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "    <title>Ticket Reservation Confirmation</title>\n" +
                "    <style>\n" +
                "        /* CSS styles can be added here to customize the appearance of the email */\n" +
                "    </style>\n" +
                "</head>\n" +
                "<body>\n" +
                "    <h1>Ticket Reservation Confirmation</h1>\n" +
                "    <p>Dear ["+ attendee +"],</p>\n" +
                "    <p>Thank you for reserving a ticket for the event <strong>["+eventName+"]</strong>.</p>\n" +
                "    <p>Below are the details of your ticket reservation:</p>\n" +
                "    <ul>\n" +
                "        <li><strong>Event:</strong> [Event Name]</li>\n" +
                "        <li><strong>Ticket Type:</strong> [Ticket Type]</li>\n" +
                "        <li><strong>Reservation Date:</strong> [Reservation Date]</li>\n" +
                "        <li><strong>Confirmation Number:</strong> [Confirmation Number]</li>\n" +
                "        <!-- Add more ticket details here as needed -->\n" +
                "    </ul>\n" +
                "    <p>If you have any questions or need further assistance, please contact us at [Contact Email].</p>\n" +
                "    <p>Thank you and we look forward to seeing you at the event!</p>\n" +
                "</body>\n" +
                "</html>");
    }
}
