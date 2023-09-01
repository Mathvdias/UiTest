package com.matheus.uitest

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.filters.SdkSuppress
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.uiautomator.By
import androidx.test.uiautomator.UiDevice
import androidx.test.uiautomator.UiObject2
import androidx.test.uiautomator.Until
import org.hamcrest.Matchers.`is`
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test


private const val CALC_PACKAGE = "com.myexample.calc"

@SdkSuppress(minSdkVersion = 33)
class GmailUITest {
    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun testOpenGmailApp() {
        val device = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())

        device.pressHome()

        val gmail: UiObject2 = device.findObject(By.text("Gmail"))

        val opened: Boolean = gmail.clickAndWait(Until.newWindow(), 3000)

        assertEquals(opened, `is`(true))
    }

}