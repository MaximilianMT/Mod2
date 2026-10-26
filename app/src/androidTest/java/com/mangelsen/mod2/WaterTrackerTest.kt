package com.mangelsen.mod2

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.mangelsen.mod2.ui.theme.Mod2Theme
import org.junit.Rule
import org.junit.Test

class WaterTrackerTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    // 1) Кнопка добавления жидкости есть и прибавляет 250 мл
    @Test
    fun addWaterButton_increasesCountBy250() {
        composeTestRule.setContent {
            Mod2Theme {
                WaterTracker()
            }
        }
        composeTestRule.onNodeWithText("0 мл").assertIsDisplayed()
        composeTestRule.onNodeWithText("+250 мл").assertIsDisplayed().performClick()
        composeTestRule.onNodeWithText("250 мл").assertIsDisplayed()
        composeTestRule.onNodeWithText("+250 мл").performClick()
        composeTestRule.onNodeWithText("500 мл").assertIsDisplayed()
    }

    // 2) Кнопка «Завершить день» есть и сбрасывает счётчик воды до нуля
    @Test
    fun finishDayButton_resetsWaterCount() {
        composeTestRule.setContent {
            Mod2Theme {
                WaterTracker()
            }
        }
        composeTestRule.onNodeWithText("+250 мл").performClick()
        composeTestRule.onNodeWithText("250 мл").assertIsDisplayed()
        composeTestRule.onNodeWithText("Завершить день").assertIsDisplayed().performClick()
        composeTestRule.onNodeWithText("0 мл").assertIsDisplayed()
    }

    // 3) Текст с количеством дней: растёт при 1500 мл и больше, обнуляется при меньшем объёме
    @Test
    fun daysText_showsCorrectValue() {
        composeTestRule.setContent {
            Mod2Theme {
                WaterTracker()
            }
        }
        composeTestRule.onNodeWithText("Дней подряд с нормой: 0").assertIsDisplayed()

        repeat(6) { composeTestRule.onNodeWithText("+250 мл").performClick() }
        composeTestRule.onNodeWithText("1500 мл").assertIsDisplayed()
        composeTestRule.onNodeWithText("Завершить день").performClick()
        composeTestRule.onNodeWithText("Дней подряд с нормой: 1").assertIsDisplayed()

        repeat(7) { composeTestRule.onNodeWithText("+250 мл").performClick() }
        composeTestRule.onNodeWithText("Завершить день").performClick()
        composeTestRule.onNodeWithText("Дней подряд с нормой: 2").assertIsDisplayed()

        composeTestRule.onNodeWithText("+250 мл").performClick()
        composeTestRule.onNodeWithText("Завершить день").performClick()
        composeTestRule.onNodeWithText("Дней подряд с нормой: 0").assertIsDisplayed()
    }
}
