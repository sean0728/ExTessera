package ny.gelato.extessera.feature.character_sheet.view_model

import android.support.design.widget.BottomSheetDialog
import ny.gelato.extessera.base.BaseViewModel

/**
 * Created by jord.goldberg on 6/21/17.
 */

data class GoToModel(
        val destination: Destination = GoToModel.Destination.NONE

) : BaseViewModel() {

    enum class Destination {
        NONE,
        ABILITIES,
        SAVES,
        SKILLS,
        WEAPONS,
        SPELLS,
        NOTES
    }

    fun goTo(destination: Destination, sheet: BottomSheetDialog): GoToModel {
        sheet.dismiss()
        return copy(destination = destination)
    }
}