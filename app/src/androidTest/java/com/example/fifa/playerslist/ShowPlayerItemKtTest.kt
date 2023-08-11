package com.example.fifa.playerslist

import androidx.compose.ui.test.assertHasClickAction
import androidx.compose.ui.test.hasClickAction
import androidx.compose.ui.test.hasText
import org.junit.Rule
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onRoot
import androidx.compose.ui.test.printToLog
import com.example.fifa.testbuilders.PlayerTestDataBuilder
import com.example.fifa.presentation.playerslist.ShowPlayerItem
import org.junit.Test

class ShowPlayerItemKtTest {
    @get:Rule
    val rule = createComposeRule()

    @Test
    fun showPlayerItem() {
        rule.setContent {
            ShowPlayerItem(
                    PlayerTestDataBuilder()
                        .withAge(20)
                        .withName("Pedri")
                        .withFoot("Right")
                        .withPosition("CM")
                        .withClub(54)
                        .withRating(96)
                        .withLeague(53)
                        .withRarity(1)
                        .withId(2)
                        .builder()
            ) {

            }
        }
        rule.onRoot().printToLog("MY TAG")

        rule.onNode(
            hasText("Pedri") and
                    hasClickAction()
        ).assertHasClickAction()
    }
}