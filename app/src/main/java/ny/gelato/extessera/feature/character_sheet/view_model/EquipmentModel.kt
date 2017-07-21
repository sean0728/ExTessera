package ny.gelato.extessera.feature.character_sheet.view_model

import android.support.design.widget.BottomSheetDialog
import ny.gelato.extessera.base.BaseViewModel
import ny.gelato.extessera.data.model.character.Equipment

/**
 * Created by jord.goldberg on 7/12/17.
 */

data class EquipmentModel(
        var name: String = "",
        var amount: Int = 1

) : BaseViewModel() {

    constructor(equipment: Equipment) : this(equipment.name, equipment.number)

    var change = 0

    override fun isSameAs(model: BaseViewModel): Boolean =
            if (model is EquipmentModel) name == model.name
            else false

    fun isEmpty(): Boolean = name.isBlank()

    fun showAmount(): String = amount.toString()

    fun setName(new: CharSequence) {
        name = new.toString()
        notifyChange()
    }

    fun setChange(amount: CharSequence) {
        if (amount.isEmpty()) change = 0
        else change = amount.toString().toInt()
    }

    fun createAndDismiss(sheet: BottomSheetDialog): EquipmentModel {
        action = Action.CREATE
        sheet.dismiss()
        return this
    }

    fun addAndDismiss(sheet: BottomSheetDialog): EquipmentModel {
        sheet.dismiss()
        amount += change
        notifyChange()
        return this.copy().apply { action = Action.UPDATE }
    }

    fun removeAndDismiss(sheet: BottomSheetDialog): EquipmentModel {
        sheet.dismiss()
        amount -= change
        notifyChange()
        return this.copy().apply { action = Action.UPDATE }
    }
}