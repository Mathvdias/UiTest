package com.matheus.uitest

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import androidx.test.core.app.ApplicationProvider.*
import androidx.test.filters.SdkSuppress
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.uiautomator.By
import androidx.test.uiautomator.UiDevice
import androidx.test.uiautomator.UiObject2
import androidx.test.uiautomator.Until
import org.junit.Assert.assertEquals
import org.junit.Test

@SdkSuppress(minSdkVersion = 33)
class CalculatorUITest {
    @Test
    fun testTwoPlusThreeEqualsFive() {
        val context: Context = getApplicationContext()
        val calculatorPackage = context.packageName
        val device = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())

        device.pressHome()

        val calculator: UiObject2 = device.findObject(By.text("Calculator"))

        val opened: Boolean = calculator.clickAndWait(Until.newWindow(), 2000)

        if (opened && calculatorPackage != null){
            device.findObject(By.res(calculatorPackage,"5")).click()
            device.findObject(By.res(calculatorPackage,"+")).click()
            device.findObject(By.res(calculatorPackage,"5")).click()
            device.findObject(By.res(calculatorPackage,"=")).click()
            Thread.sleep(1000)
            val result: UiObject2 = device.findObject(By.res(calculatorPackage, "result"))
            assertEquals("10", result.text)
        }
    }
}
