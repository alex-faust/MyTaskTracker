package com.mytasktracker;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.widget.DatePicker;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener
{
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){
        final Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

            /*
                We should use THEME_HOLO_LIGHT, THEME_HOLO_DARK or THEME_TRADITIONAL only.

                The THEME_DEVICE_DEFAULT_LIGHT and THEME_DEVICE_DEFAULT_DARK does not work
                perfectly. This two theme set disable color of disabled dates but users can
                select the disabled dates also.

                Other three themes act perfectly after defined enabled date range of date picker.
                Those theme completely hide the disable dates from date picker object.
             */
        DatePickerDialog dpd = new DatePickerDialog(getActivity(),
                AlertDialog.THEME_HOLO_LIGHT,this,year,month,day);

            /*
                add(int field, int value)
                    Adds the given amount to a Calendar field.
             */
        // Add 3 days to Calendar
        calendar.add(Calendar.DATE, 3);

            /*
                getTimeInMillis()
                    Returns the time represented by this Calendar,
                    recomputing the time from its fields if necessary.

                getDatePicker()
                Gets the DatePicker contained in this dialog.

                setMinDate(long minDate)
                    Sets the minimal date supported by this NumberPicker
                    in milliseconds since January 1, 1970 00:00:00 in getDefault() time zone.

                setMaxDate(long maxDate)
                    Sets the maximal date supported by this DatePicker in milliseconds
                    since January 1, 1970 00:00:00 in getDefault() time zone.
             */

        // Set the Calendar new date as maximum date of date picker
        dpd.getDatePicker().setMaxDate(calendar.getTimeInMillis());

        // Subtract 6 days from Calendar updated date
        calendar.add(Calendar.DATE, -6);

        // Set the Calendar new date as minimum date of date picker
        dpd.getDatePicker().setMinDate(calendar.getTimeInMillis());

        // So, now date picker selectable date range is 7 days only

        // Return the DatePickerDialog
        return  dpd;
    }
    @Override
    public void onDateSet(DatePicker view, int year, int month, int day)
    {
        // Do something with the chosen date
        //TextView tv = (TextView) getActivity().findViewById(R.id.tv);

        // Create a Date variable/object with user chosen date
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(0);
        cal.set(year, month, day, 0, 0, 0);
        Date chosenDate = cal.getTime();

        // Format the date using style and locale
        DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.US);
        String formattedDate = df.format(chosenDate);

        // Display the chosen date to app interface
        tv.setText(formattedDate);
    }
}
