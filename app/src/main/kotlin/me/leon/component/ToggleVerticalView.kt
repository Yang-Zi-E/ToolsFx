package me.leon.component

import javafx.beans.property.SimpleBooleanProperty
import tornadofx.*

class ToggleVerticalView(
    val list: List<String> = listOf("raw", "hex", "base64"),
    var index: Int = 0,
    show: SimpleBooleanProperty = SimpleBooleanProperty(true),
) : AbsToggleView(list, index, show) {

    override val root = vbox { populate() }
}
