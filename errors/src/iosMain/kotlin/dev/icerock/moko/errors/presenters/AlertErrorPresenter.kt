/*
 * Copyright 2020 IceRock MAG Inc. Use of this source code is governed by the Apache 2.0 license.
 */

package dev.icerock.moko.errors.presenters

import dev.icerock.moko.errors.ErrorPresenter
import dev.icerock.moko.resources.desc.StringDesc
import platform.UIKit.UIAlertAction
import platform.UIKit.UIAlertActionStyleDefault
import platform.UIKit.UIAlertController
import platform.UIKit.UIAlertControllerStyleAlert
import platform.UIKit.UIViewController

actual class AlertErrorPresenter actual constructor(
    private val exceptionMapper: (Throwable) -> StringDesc,
    private val alertTitle: StringDesc,
    private val positiveButtonText: StringDesc
) : ErrorPresenter {

    override fun show(exception: Throwable, viewController: UIViewController) {
        val alert = UIAlertController.alertControllerWithTitle(
            title = alertTitle.localized(),
            message = exceptionMapper(exception).localized(),
            preferredStyle = UIAlertControllerStyleAlert
        )
        alert.addAction(
            UIAlertAction.actionWithTitle(
                title = positiveButtonText.localized(),
                style = UIAlertActionStyleDefault,
                handler = {}
            )
        )

        viewController.presentModalViewController(alert, true)
    }
}
