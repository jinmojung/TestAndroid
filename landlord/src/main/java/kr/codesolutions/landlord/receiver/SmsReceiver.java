package kr.codesolutions.landlord.receiver;

import java.util.Calendar;
import java.util.Date;

import android.content.BroadcastReceiver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.Toast;

import kr.codesolutions.landlord.common.Const;

public class SmsReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(Const.TAG,"111111111111111111111111111111");
        Toast.makeText(context,intent.getAction().toString(),Toast.LENGTH_SHORT);
        if ("android.provider.Telephony.SMS_RECEIVED".equals(intent.getAction())) {
            Bundle bundle = intent.getExtras();
            Object messages[] = (Object[])bundle.get("pdus");
            SmsMessage smsMessage[] = new SmsMessage[messages.length];
            
            for(int i = 0; i < messages.length; i++) {
                smsMessage[i] = SmsMessage.createFromPdu((byte[])messages[i]);
            }
            
            Date curDate = new Date(smsMessage[0].getTimestampMillis());
            String origNumber = smsMessage[0].getOriginatingAddress();
            String message = smsMessage[0].getMessageBody().toString();
            Log.d(Const.TAG,"origNumber="+origNumber+"message="+message);
            Toast.makeText(context,"origNumber="+origNumber+"message="+message,Toast.LENGTH_SHORT);

            String[] projectionCalendar = new String[] {
                    "_id",
                    "name"
            };

            String[] projectionEvents = new String[] {
                    "account_name",
                    "account_type",
                    "accessLevel",
                    "allDay",
                    "allowedReminders",
                    "availability",
                    "calendar_id",
                    "calendar_color",
                    "calendar_displayName",
                    "calendar_timezone",
                    "canModifyTimeZone",
                    "canOrganizerRespond",
                    "deleted",
                    "description",
                    "dirty",
                    "dtstart",
                    "dtend",
                    "duration",
                    "eventColor",
                    "eventLocation",
                    "eventStatus",
                    "eventTimezone",
                    "exrule",
                    "exdate",
                    "guestsCanInviteOthers",
                    "guestsCanModify",
                    "guestsCanSeeGuests",
                    "hasAlarm",
                    "hasAttendeeData",
                    "hasExtendedProperties",
                    "lastDate",
                    "lastSynced",
                    "maxReminders",
                    "original_id",
                    "originalAllDay",
                    "originalInstanceTime",
                    "organizer",
                    "rdate",
                    "rrule",
                    "selfAttendeeStatus",
                    "title",
                    "visible",
            } ;

            Uri calendars	= Uri.parse("content://com.android.calendar/calendars");
            Uri events		= Uri.parse("content://com.android.calendar/events");

            String result ="";
            String calId = null;
            try{
                Cursor managedCursorCalendar	=	context.getContentResolver().query(calendars, projectionCalendar,	"_id=1",	null,	null);
                Cursor managedCursorEvents		=	context.getContentResolver().query(events,	projectionEvents,	null,	null,	null);


                if (managedCursorCalendar.moveToFirst())
                {
                    String calName;
                    int nameColumn = managedCursorCalendar.getColumnIndex("name");
                    int idColumn = managedCursorCalendar.getColumnIndex("_id");

                    do {
                        calName = managedCursorCalendar.getString(nameColumn);
                        calId = managedCursorCalendar.getString(idColumn);
                        result = result + "calName:" + calName + " || idColumn:" + idColumn + "\n";
                        result = result + "calId:" + calId + " || idColumn:" + idColumn + "\n";
                    } while (managedCursorCalendar.moveToNext());

                }

                if (managedCursorEvents.moveToFirst()) {
                    String columnNames[] = managedCursorEvents.getColumnNames();
                    String value = "";
                    String colNamesString = "";
                    do {
                        value = "";

                        for (String colName : columnNames) {
                            value += colName + " = ";
                            value += managedCursorEvents.getString(managedCursorEvents.getColumnIndex(colName))
                                    + " \n";
                        }

                        Log.e("INFO : ", value);
                        result = result + value;
                    } while (managedCursorEvents.moveToNext());
                }
            }catch(Exception e){
            }












            long l = Calendar.getInstance().getTimeInMillis();
            ContentValues calEvent  = new ContentValues();
            calEvent.put(CalendarContract.Events.CALENDAR_ID,  calId); // XXX pick)
            calEvent.put(CalendarContract.Events.TITLE, "landlord");
            calEvent.put(CalendarContract.Events.DESCRIPTION, "origNumber="+origNumber+"message="+message);
            calEvent.put(CalendarContract.Events.DTSTART,l);
            calEvent.put(CalendarContract.Events.DTEND, l+60 * 1000);
            calEvent.put(CalendarContract.Events.EVENT_TIMEZONE, "Indian/Christmas");

            Uri eventsUri = Uri.parse("content://com.android.calendar/events");
            Uri calUri = context.getContentResolver().insert(eventsUri, calEvent);
        }
    }
}
