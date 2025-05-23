/*
 * Copyright (c) 2010-2024 Belledonne Communications SARL.
 *
 * This file is part of linphone-android
 * (see https://www.linphone.org).
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package org.linphone.ui.call.model

import androidx.annotation.UiThread
import androidx.lifecycle.MutableLiveData
import org.linphone.utils.AppUtils
import org.linphone.utils.Event

class ConfirmCallTransferDialogModel
    @UiThread
    constructor(
    toTransfer: String,
    toReceiveTransfer: String
) {
    val cancelEvent = MutableLiveData<Event<Boolean>>()

    val confirmEvent = MutableLiveData<Event<Boolean>>()

    val message = MutableLiveData<String>()

    init {
        message.value = AppUtils.getFormattedString(
            org.linphone.R.string.call_transfer_confirm_dialog_message,
            toTransfer,
            toReceiveTransfer
        )
    }

    @UiThread
    fun cancel() {
        cancelEvent.value = Event(true)
    }

    @UiThread
    fun confirm() {
        confirmEvent.value = Event(true)
    }
}
