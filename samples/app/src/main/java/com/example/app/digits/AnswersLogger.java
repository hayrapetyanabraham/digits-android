/*
 * Copyright (C) 2015 Twitter, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package com.example.app.digits;

import com.crashlytics.android.answers.Answers;
import com.crashlytics.android.answers.CustomEvent;

import com.digits.sdk.android.DigitsEventLogger;
import com.digits.sdk.android.DigitsEventDetails;

import java.util.Locale;

import io.fabric.sdk.android.Fabric;

/**
 * This logger does multiple things to demonstrate the flexibility
 * we intend to provide
 * 1) Generate Answers Custom Events
 * 2) Log to stdOut
 */
public class AnswersLogger extends DigitsEventLogger {
    private final Answers answers;
    private final String TAG = "AnswersLogger";

    AnswersLogger(Answers answers) {
        this.answers = answers;
    }

    @Override
    public void loginBegin(DigitsEventDetails digitsEventDetails) {
        answers.logCustom(new CustomEvent("Login-Digits")
                .putCustomAttribute("Action", "loginBegin")
                .putCustomAttribute("Language", digitsEventDetails.language)
                .putCustomAttribute("ElapsedTime", digitsEventDetails.elapsedTimeInMillis / 1000));

        Fabric.getLogger().d(TAG, "loginBegin event received");
        Fabric.getLogger().d(TAG, String.format(Locale.US, "timeElapsed = %d%n",
                digitsEventDetails.elapsedTimeInMillis / 1000));
        Fabric.getLogger().d(TAG, String.format(Locale.US, "language = %s",
                digitsEventDetails.language));
    }

    @Override
    public void phoneNumberImpression(DigitsEventDetails digitsEventDetails) {
        answers.logCustom(new CustomEvent("Login-Digits")
                .putCustomAttribute("Action", "phoneNumberImpression")
                .putCustomAttribute("Language", digitsEventDetails.language)
                .putCustomAttribute("ElapsedTime", digitsEventDetails.elapsedTimeInMillis / 1000));

        Fabric.getLogger().d(TAG, "phoneNumberImpression event received");
        Fabric.getLogger().d(TAG, String.format(Locale.US, "timeElapsed = %d%n",
                digitsEventDetails.elapsedTimeInMillis / 1000));
        Fabric.getLogger().d(TAG, String.format(Locale.US, "language = %s",
                digitsEventDetails.language));
    }

    @Override
    public void phoneNumberSubmit(DigitsEventDetails digitsEventDetails) {
        answers.logCustom(new CustomEvent("Login-Digits")
                .putCustomAttribute("Action", "phoneNumberSubmit")
                .putCustomAttribute("Language", digitsEventDetails.language)
                .putCustomAttribute("Country", digitsEventDetails.country)
                .putCustomAttribute("ElapsedTime", digitsEventDetails.elapsedTimeInMillis / 1000));

        Fabric.getLogger().d(TAG, "phoneNumberSubmit event received");
        Fabric.getLogger().d(TAG, String.format(Locale.US, "timeElapsed = %d%n",
                digitsEventDetails.elapsedTimeInMillis / 1000));
        Fabric.getLogger().d(TAG, String.format(Locale.US, "language = %s",
                digitsEventDetails.language));
        Fabric.getLogger().d(TAG, String.format(Locale.US, "country = %s",
                digitsEventDetails.country));
    }

    @Override
    public void phoneNumberSuccess(DigitsEventDetails digitsEventDetails) {
        answers.logCustom(new CustomEvent("Login-Digits")
                .putCustomAttribute("Action", "phoneNumberSuccess event received")
                .putCustomAttribute("Language", digitsEventDetails.language)
                .putCustomAttribute("Country", digitsEventDetails.country)
                .putCustomAttribute("ElapsedTime", digitsEventDetails.elapsedTimeInMillis / 1000));

        Fabric.getLogger().d(TAG, "phoneNumberSuccess event received");
        Fabric.getLogger().d(TAG, String.format(Locale.US, "timeElapsed = %d%n",
                digitsEventDetails.elapsedTimeInMillis / 1000));
        Fabric.getLogger().d(TAG, String.format(Locale.US, "language = %s",
                digitsEventDetails.language));
        Fabric.getLogger().d(TAG, String.format(Locale.US, "country = %s",
                digitsEventDetails.country));
    }

   @Override
   public void loginSuccess() {
        answers.logCustom(new CustomEvent("Login-Digits")
                .putCustomAttribute("Action", "loginSuccess"));

       Fabric.getLogger().d(TAG, "loginSuccess");
    }
}