package africa.semicolon.BookEase.utils;

public class NotificationContent {

    public static String htmlContent(String eventName, String attendee, String date){
        return String.format("Hello [Attendee "+attendee+ "]" +
                "We hope this message finds you well! This is a friendly reminder about the upcoming" +
                "[Event : "+eventName+"] that you're scheduled to attend." +
                "Event Details" +
                " ."+eventName+
                " ."+date+
                "Please mark your calendar accordingly. We're looking forward to your participation and" +
                " contribution to making this event a success.\n" +
                "If you have any questions or need further assistance, feel free to reach out to us.\n" +
                "Best regards,\n" +
                "[ "+eventName+"]");
    }
}
