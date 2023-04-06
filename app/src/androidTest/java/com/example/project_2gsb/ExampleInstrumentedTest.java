package com.example.project_2gsb;

import android.content.Context;
import android.database.Cursor;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
       // assertEquals("com.example.project_2gsb", appContext.getPackageName());
        SQLiteDataBaseHelper db = new SQLiteDataBaseHelper(appContext);
        int nb =0;
        Cursor C1=db.getEDT("28");
        nb= C1.getCount();
        db.insertData("MOI", "celian", "pharma", "CHEZmOI", "tutu", "0787131378");
        db.insertRDV("28","18","MOI");
        Cursor C2= db.getEDT("28");
       int nb2= C2.getCount();
        assertEquals(nb+1,nb2);
    }


    @Test
    public void useAppContext2() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        // assertEquals("com.example.project_2gsb", appContext.getPackageName());
        SQLiteDataBaseHelper db = new SQLiteDataBaseHelper(appContext);
        int nb = 0;
        Cursor C1 = db.getAllData();
        nb = C1.getCount();
        db.insertData("laumond2", "celian", "pharma", "CHEZmOI", "tutu", "0787131378");
        Cursor C2 = db.getAllData();
        int nb2 = C2.getCount();
        assertEquals(nb+1, nb2);
    }
    @Test
    public void useAppCOntext3()
    {
        Context appContext= InstrumentationRegistry.getInstrumentation().getTargetContext();
        // assertEquals("com.example.project_2gsb", appContext.getPackageName());
        SQLiteDataBaseHelper db = new SQLiteDataBaseHelper(appContext);

    }
    @Test
    public void useAppCOntext4()
    {
        Context appContext= InstrumentationRegistry.getInstrumentation().getTargetContext();
        // assertEquals("com.example.project_2gsb", appContext.getPackageName());
        SQLiteDataBaseHelper db = new SQLiteDataBaseHelper(appContext);
        Cursor C=db.getVille("narbonne","11");
        assertEquals(1,C.getCount());

    }

}