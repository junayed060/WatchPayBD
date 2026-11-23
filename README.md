# WatchPay BD — Android starter project

This is a native Android (Kotlin + Jetpack Compose) starter UI for WatchPay BD.

## Build
Open this folder in Android Studio (recent version), allow Gradle sync, then choose **Build > Build Bundle(s) / APK(s) > Build APK(s)**.

## Current scope
- Home, Watch Ads, Wallet and Profile screens
- Placeholder balance only; no real money is stored or paid
- No ad network, login, backend, admin panel or payout integration is connected yet

## Before real rewards or payouts
1. Obtain written confirmation from the ad provider that incentivized/rewarded viewing is permitted for the exact ad format and app traffic.
2. Build a secure backend with authentication, server-side reward verification, fraud controls and an auditable ledger.
3. Integrate payout providers only after merchant/business approval and compliance checks.
4. Never credit users based only on a client-side button tap or an unverified ad click.
